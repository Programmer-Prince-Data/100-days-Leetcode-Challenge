class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        int totalDays = 0;
        for (int i = 1971; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
    
        for (int i = 1; i < month; i++) {
            if (i == 2 && isLeapYear(year)) {
                totalDays += 29;
            } else {
                totalDays += months[i];
            }
        }
        
        totalDays += day - 1; 
        return days[(totalDays + 5) % 7];
    }
    
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}