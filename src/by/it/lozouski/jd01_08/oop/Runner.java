package by.it.lozouski.jd01_08.oop;

class Runner {
    private static void printInfo(SamsungMobile name){
        System.out.println(name.toString());
        System.out.println("-----------------------------------");
        name.getCall();
        name.sendCall();
        name.getMessage();
        name.sendMessage();
        name.blueTooth();
        name.wiFi();
        name.gps();
        name.samsungPay();
        name.dualSim();
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        SamsungMobile phone1 = new GalaxyA8("Galaxy A8","Android 8.0",2017);
        SamsungMobile phone2 = new GalaxyS1Duos("Galaxy S1 Duos","Android 4.4",2014);
        SamsungMobile phone3 = new GalaxyFocus("Galaxy Focus","Android 2.1",2011);
        printInfo(phone1);
        printInfo(phone2);
        printInfo(phone3);
    }
}
