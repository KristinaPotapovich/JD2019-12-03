package by.it.lozouski.jd01_08.oop;

class GalaxyFocus extends SamsungMobile {
    private String modelName;
    private String operationSystem;
    private int releaseYear;

    public GalaxyFocus(String modelName, String operationSystem, int releaseYear) {
        super(modelName);
        this.operationSystem = operationSystem;
        this.releaseYear = releaseYear;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = super.getModelName();
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
    public String toString() {
        return "Model: " + super.getModelName() + "\nOperation System: " + this.operationSystem + "\nRelease Year: " + this.releaseYear;
    }

    @Override
    public void getCall() {
        System.out.println("Model " + super.getModelName() + " supports get call.");
    }

    @Override
    public void sendCall() {
        System.out.println("Model " + super.getModelName() + " supports send call.");
    }

    @Override
    public void getMessage() {
        System.out.println("Model " + super.getModelName()+ " supports get message.");
    }

    @Override
    public void sendMessage() {
        System.out.println("Model " + super.getModelName() + " supports send message.");
    }

    @Override
    public void blueTooth() {
        System.out.println("Model " + super.getModelName() + " supports BlueTooth Version 2.2");
    }

    @Override
    public void wiFi() {
        super.wiFi();
    }

    @Override
    public void gps() {
        super.gps();
    }

    @Override
    public void samsungPay() {
        super.samsungPay();
    }

    @Override
    public void dualSim() {
        super.dualSim();
    }
}
