package assignment1.items;

import java.lang.Math;

public abstract class StoreItem {
    private double price;
    private int happinessIndex;

    public StoreItem(double price, int happinessIndex) {
        if (happinessIndex < 0 || price < 0) {
            throw new IllegalArgumentException("Happiness and Price can not be negative");
        }
        this.price = price;
        this.happinessIndex = happinessIndex;
    }

    public final double getPrice() {
        return this.price;
    }
    public int getHappinessIndex() {
        return this.happinessIndex;
    }
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof StoreItem)) {
            return false;
        }

        if (Math.abs(this.getPrice() - ((StoreItem) object).getPrice()) < 0.001) {
            if (this.getHappinessIndex() == ((StoreItem) object).getHappinessIndex()) {
                return true;
            }
        }
        return false;
    }

}

