package by.it.busel.jd02_02;

import java.util.Map;

class Cashier extends Thread {

    private static Double totalRevenue = 0.0;

    private static final Object totalRevenueMonitor = new Object();

    private static void increaseTotalRevenue(Double value) {
        synchronized (totalRevenueMonitor) {
            totalRevenue = totalRevenue + value;
        }
    }

    private static Double getTotalRevenue() {
        synchronized (totalRevenueMonitor) {
            return totalRevenue;
        }
    }

    private String preBlanks = "";
    private String postBlanks = "";

    Cashier(int id) {
        this.setName("Cashier №" + id + " ");
        Dispatcher.cashierOpensTheCounter();
        setPreBlanks(id);
        setPostBlanks(id);
    }

    private void setPreBlanks(int id) {
        int index = (id - 1) * 24;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(" ");
        }
        preBlanks = sb.toString();
    }

    private void setPostBlanks(int id) {
        int index = (5 - id) * 24;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index; i++) {
            sb.append(" ");
        }
        postBlanks = sb.toString();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void run() {
        System.out.println(this + " has started to work.");
        while (!Dispatcher.shopCanBeClosed()) {
            if (Dispatcher.saysCashierToCloseTheCounter()) {
                try {
                    waitTillNotified();
                } catch (InterruptedException e) {
                    System.out.println(this + " has left the shop!!!.");
                    return;
                }
            }
            Buyer buyerAtTheCounter = SoleQueue.extract();
            serve(buyerAtTheCounter);
        }
        Dispatcher.cashierClosesTheCounter();
        System.out.println(this + " has ended to work.");
        System.out.println(this + " has left the shop.");
    }

    private void waitTillNotified() throws InterruptedException {
        synchronized (this) {
            Dispatcher.cashierClosesTheCounter();
            System.out.println(this + " has ended to work!!!.");
            wait();
            Dispatcher.cashierOpensTheCounter();
            System.out.println(this + " has started to work!!!.");
        }
    }

    @SuppressWarnings("all")
    private void serve(Buyer buyerAtTheCounter) {
        if (buyerAtTheCounter != null) {
            synchronized (buyerAtTheCounter) {
                System.out.println(this + " has started to serve " + buyerAtTheCounter);
                Helper.sleep(2000, 5000);
                Map<String, Double> personalGoods = buyerAtTheCounter.payOff();
                System.out.println(getCheckAndService(buyerAtTheCounter, personalGoods));
//                System.out.println(this + " has ended to serve " + buyerAtTheCounter);
                buyerAtTheCounter.notify();
            }
        } else {
            yield();
        }
    }

    private String getCheckAndService(Buyer buyerAtTheCounter, Map<String, Double> personalGoods) {
        int index = 0;
        Double total = 0.0;
        StringBuilder sb = new StringBuilder("\n");
        sb.append(preBlanks).append(this).append('\n');
        sb.append(preBlanks).append("╔══════════════════════╗").append('\n');
        sb.append(preBlanks).append("║").append(String.format("%-22s", buyerAtTheCounter)).append("║").append('\n');
        sb.append(preBlanks).append("╠══╦════════════╦══════╣").append(postBlanks).append("╔═════════════╦═════════════╗").append('\n');
        sb.append(preBlanks).append("║").append("№№").append("║")
                .append("item        ").append("║")
                .append("price ").append("║")
                .append(postBlanks).append("║")
                .append("queue size   ").append("║").append("Shop revenue ").append("║").append("\n");
        for (Map.Entry<String, Double> entry : personalGoods.entrySet()) {
            total = total + entry.getValue();
            increaseTotalRevenue(entry.getValue());
            sb.append(preBlanks).append("╠══╬════════════╬══════╣")
                    .append(postBlanks).append("╠═════════════╬═════════════╣").append('\n');
            sb.append(preBlanks).append("║").append(String.format("%2d", ++index))
                    .append("║").append(String.format("%12s", entry.getKey()))
                    .append("║").append(String.format("%6.2f", entry.getValue())).append("║")
                    .append(postBlanks)
                    .append("║").append(String.format("%13d", SoleQueue.getBuyersQuantity()))
                    .append("║").append(String.format("%13.2f", getTotalRevenue()))
                    .append("║").append('\n');
        }
        sb.append(preBlanks).append("╠══╩════╦═══════╩══════╣")
                .append(postBlanks).append("╚═════════════╩═════════════╝").append('\n');
        sb.append(preBlanks).append(String.format("║%8s%10.2f%4s║", "To pay:║", total, " BYN"));
        sb.append('\n').append(preBlanks).append("╚═══════╩══════════════╝").append('\n');
        sb.append(this).append(" has ended to serve ").append(buyerAtTheCounter);
        return sb.toString();
    }
}
