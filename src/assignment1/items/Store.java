package assignment1.items;
import assignment1.items.*;

public class Store {
    private ItemList itemList;
    private double totalRevenue;

    public Store(ItemList itemList) {
        this.itemList = itemList;
        this.totalRevenue = 0.0;
    }

    public double getRevenue() {
        return this.totalRevenue;
    }

    private void setRevenue(double revenue) {
        this.totalRevenue += revenue;
    }


    public ItemList getItems() {
        return this.itemList;
    }

    public void cleanUp() {
        StoreItem[] storeItem = itemList.getAllItems();
        StoreItem[] removedItem = new StoreItem[storeItem.length];
        int counter = 0;
        for (int i = 0; i < itemList.getAllItems().length; i++) {
            if (storeItem[i] instanceof Snack) {
                if (((Snack) storeItem[i]).isExpired()) {
                    removedItem[i] = storeItem[i];
                    counter += 1;
                }
            }
        }

        for (int i = 0; i < counter; i++) {
            this.itemList.removeItem(removedItem[i]);
        }
    }

    public int completeSale(ItemList itemList) {
        cleanUp();
        StoreItem[] storeItems = itemList.getAllItems(); // correct
        int totalHappiness = 0; // correct

        for (int i = 0; i < storeItems.length; i++) {
            if (storeItems[i] instanceof Snack) {
                itemList.removeItem(storeItems[i]);
                totalHappiness += ( (Snack) storeItems[i]).getHappinessIndex();
                setRevenue( ((Snack) storeItems[i]).getPrice());
            }

            else if (storeItems[i] instanceof Drink ) {
                itemList.removeItem(storeItems[i]);
                totalHappiness += ((Drink) storeItems[i]).getHappinessIndex();
                setRevenue( (((Drink) storeItems[i]).getPrice()) * ((Drink) storeItems[i]).getNumOfBottles());
            }

        }
        return totalHappiness;

    }

    public void refillDrinkInventory(Drink[] drinks) {
        StoreItem[] storeItem = itemList.getAllItems();
        for (int i = 0; i < drinks.length; i++) {
            for (int j = 0; j < storeItem.length; j++) {
                if (storeItem[j] instanceof Drink) {
                    if (((Drink) storeItem[j]).equals(drinks[i])) {
                        ((Drink) storeItem[j]).combine(drinks[i]);
                    }
                }
            }
        }
    }

}