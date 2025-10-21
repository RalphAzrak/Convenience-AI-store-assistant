package assignment1.items;
import assignment1.items.StoreItem;

public abstract class Drink extends StoreItem {
    public static int MAX_PACK_SIZE = 6;
    public static int BUZZY_HAPPINESS_BOOST = 1;

    protected int numOfBottles;
    private boolean buzziness;

    public Drink(double price, int happinessIndex, int numOfBottles, boolean buzziness){
        super(price, happinessIndex);
        this.numOfBottles = numOfBottles;
        this.buzziness = buzziness;
    }

    public int getNumOfBottles(){
        return this.numOfBottles;
    }
    private boolean getBuzziness(){
        return this.buzziness;
    }

    public int get_HappinessIndex() {
        if (this.buzziness) {
            return (super.getHappinessIndex() + Drink.BUZZY_HAPPINESS_BOOST);
        }
        else {
            return (super.getHappinessIndex());
        }
    }

    public boolean equals(Object object){
        if(object instanceof Drink) {
            return (this.buzziness == ((Drink)object).buzziness && super.equals(object));
        } else {
            return false;
        }
    }
    public boolean combine(Drink other){
        if(!this.equals(other)){
            return false;
        }

        if(this.numOfBottles >= Drink.MAX_PACK_SIZE){
            return false;
        }

        int bottlesRemainingUntilFull = MAX_PACK_SIZE - this.numOfBottles;
        int bottlesToTransfer = Math.min(bottlesRemainingUntilFull, other.numOfBottles);


        this.numOfBottles += bottlesToTransfer;


        if (bottlesToTransfer == other.numOfBottles) {
            other.numOfBottles = 0;
        } else {

            other.numOfBottles -= bottlesToTransfer;
        }

        return true;

    }

    public abstract Drink getPortion(int quantity);
}