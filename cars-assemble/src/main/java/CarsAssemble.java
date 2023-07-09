public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        if(speed == 10){
            return (speed * 221) * 0.77;
        }else if(speed == 9){
            return (speed * 221) * 0.80;
        } else if (speed > 4) {
            return (speed * 221) * 0.90;
        }

        return (double)speed * 221;
    }

    public int workingItemsPerMinute(int speed) {
//        double minutes = (double)speed / 60;
//        double result = 0.0;
//        if(speed == 10){
//            result = (minutes * 221) * 0.77;
//        }else if(speed == 9){
//            result = (minutes * 221) * 0.80;
//        } else if (speed > 4) {
//            result =  (minutes * 221) * 0.90;
//        }else{
//            result = minutes * 221;
//        }

        return (int)productionRatePerHour(speed) / 60;
    }
}
