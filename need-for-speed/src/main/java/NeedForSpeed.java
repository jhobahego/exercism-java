class NeedForSpeed {
    // TODO: define the constructor for the 'NeedForSpeed' class
    private int battery = 100;
    private final int speed;
    private final int batteryDrain;

    private int distance = 0;
    public NeedForSpeed(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public int getSpeed(){ return speed; }

    public boolean batteryDrained() {
        return battery <= 0;
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if(!batteryDrained()){
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    // TODO: define the constructor for the 'RaceTrack' class
    private int distance;
    public RaceTrack(int distance) {
        this.distance = distance;
    }
    public boolean tryFinishTrack(NeedForSpeed car) {
        while (!car.batteryDrained()){
            car.drive();
            distance -= car.getSpeed();
            if(distance <= 0)
                return true;
        }
        return false;
    }
}
