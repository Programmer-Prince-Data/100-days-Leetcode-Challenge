class Solution {
    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double farhrenheit = celsius * 1.80 + 32.00;

        return new double[] {kelvin, farhrenheit};
    }
}