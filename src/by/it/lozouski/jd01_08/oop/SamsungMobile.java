package by.it.lozouski.jd01_08.oop;

abstract class SamsungMobile implements Mobile {
    private String modelName;
    private String operationSystem;
    private int releaseYear;

    public SamsungMobile(String modelName) {
        this.modelName = modelName;
    }


    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    @Override
    public void getCall() {

    }

    @Override
    public void sendCall() {

    }

    @Override
    public void getMessage() {

    }

    @Override
    public void sendMessage() {
    }

    @Override
    public void blueTooth() {
        System.out.println("Model " + this.modelName + " doesn't support BlueTooth.");
    }

    @Override
    public void wiFi() {
        System.out.println("Model " + this.modelName + " doesn't support Wi-Fi.");
    }

    @Override
    public void gps() {
        System.out.println("Model " + this.modelName + " doesn't have GPS.");
    }

    public void samsungPay() {
        System.out.println("Model " + this.modelName + " doesn't support Samsung PAY");

    }

    public void dualSim() {
        System.out.println("Model " + this.modelName + " doesn't support dual SIM");

    }
}
