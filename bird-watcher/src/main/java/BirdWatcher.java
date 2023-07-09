
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        if(birdsPerDay.length > 0)
            return birdsPerDay[birdsPerDay.length - 1];
        return 0;
    }

    public void incrementTodaysCount() {
        if(birdsPerDay.length > 0)
            birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        boolean hasDay = false;
        for(int i = 0; i < birdsPerDay.length; i++) {
            if(birdsPerDay[i] == 0) {
                hasDay = true;
                break;
            }
        }
        return hasDay;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;

        for(int i = 0; i < birdsPerDay.length; i++) {
            if(numberOfDays > birdsPerDay.length) {
                sum += birdsPerDay[i];
            }else if(i < numberOfDays){
                sum += birdsPerDay[i];
            }
        }
        return sum;
    }

    public int getBusyDays() {
        int busyDays = 0;
        for(int i = 0; i < birdsPerDay.length; i++) {
            if(birdsPerDay[i] >= 5)
                busyDays++;
        }
        return busyDays;
    }
}
