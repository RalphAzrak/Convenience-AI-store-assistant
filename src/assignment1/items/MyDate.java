package assignment1.items;

import java.time.LocalDate;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public static int[] SUMMER_MONTHS = {6,7,8};
    public static int[] WINTER_MONTHS = {12,1,2};

    public MyDate(int day, int month, int year){
        if(year<0){
            throw new IllegalArgumentException("Date is invalid");
        }

        this.day = day;

        this.month = month;

        if (month == 2) {
            if (day < 1 || day > 28) {
                throw new IllegalArgumentException("Day Can not be less than 1 or greater than 28");
            }
        }

        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day <1 || day > 31) {
                throw new IllegalArgumentException("Days should be between 1 and 31");
            }
        }

        else {
            if (day <1 || day > 30) {
                throw new IllegalArgumentException("Day should be between 1 and 30");
            }
        }

        this.year = year;
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;
    }

    public int getYear(){
        return this.year;
    }

    public boolean equals(Object object){
        if (object == null) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (!(object instanceof MyDate)) {
            return false;
        }

        if (this.getDay() == ((MyDate) object).getDay()) {


            if (this.getMonth() == ((MyDate) object).getMonth()) {


                if (this.getYear() == ((MyDate) object).getYear()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static MyDate today(){
        LocalDate localDate = LocalDate.now();
        return new MyDate(localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear());
    }
}

