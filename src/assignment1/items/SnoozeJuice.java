package assignment1.items;

public class SnoozeJuice extends Drink {
    private double temperature;
    public static int HOT_COLD_BOOST = 2;

    public SnoozeJuice(double price, int happinessIndex, int numOfBottles, double temperature) {
        super(price, happinessIndex, numOfBottles, false);

        this.temperature = temperature;
        this.numOfBottles = numOfBottles;
    }

    public boolean equals(Object object) {
        if (object instanceof SnoozeJuice) {
            if (Math.abs(this.temperature - ((SnoozeJuice) object).temperature) < 0.001) {
                return super.equals(object);
            }

            else {
                return false;
            }
        }

        else {
            return false;
        }

    }

    @Override
    public int getHappinessIndex() {
        int baseHappinessIndex = super.getHappinessIndex();

        if (this.temperature < 4 || this.temperature > 65) {
            return 0;
        }
        for (int i = 0; i < MyDate.SUMMER_MONTHS.length; i++) {
            if (MyDate.today().getMonth() == MyDate.SUMMER_MONTHS[i]) {
                if (this.temperature >= 4 && this.temperature <= 10 ) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }

        for (int i = 0; i < MyDate.WINTER_MONTHS.length; i++) {
            if (MyDate.today().getMonth() == MyDate.WINTER_MONTHS[i]) {
                if (this.temperature >= 55 && this.temperature <= 65 ) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }

        return super.getHappinessIndex();
    }

    private boolean isSummer() {
        MyDate today = MyDate.today();
        int month = today.getMonth();
        return month >= 6 && month <= 8; // June, July, August
    }

    private boolean isWinter() {
        MyDate today = MyDate.today();
        int month = today.getMonth();
        return month >= 12 || month <= 2; // December, January, February
    }

    public SnoozeJuice getPortion(int numBottlesDesired) {
        if (numBottlesDesired <= 0) {
            return null;
        }

        if (numBottlesDesired <= this.numOfBottles) {
            SnoozeJuice portion = new SnoozeJuice(this.getPrice(), this.getHappinessIndex(), numBottlesDesired, this.temperature);
            this.numOfBottles -= numBottlesDesired;
            return portion;
        } else {
            return null;
        }
    }
}