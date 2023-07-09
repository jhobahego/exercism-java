public class SalaryCalculator {
    private double salary = 1000.00;
    public double multiplierPerDaysSkipped(int daysSkipped) {
        return daysSkipped > 5 ? 0.85 : 1;
    }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold > 20 ? 13 : 10;
    }

    public double bonusForProductSold(int productsSold) {
        return productsSold * multiplierPerProductsSold(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double finalSalary = salary * multiplierPerDaysSkipped(daysSkipped) + bonusForProductSold(productsSold);
        return Math.min(finalSalary, 2000.00);
    } 
}
