class ProductionRemoteControlCar implements Comparable<ProductionRemoteControlCar>, RemoteControlCar{
    private int distanceTravelled;
    private int numberOfVictories;

    public void drive() {
        this.distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return Integer.compare(this.getNumberOfVictories(), o.getNumberOfVictories());
    }
}
