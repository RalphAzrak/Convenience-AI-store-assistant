package assignment1.items;

public class FizzWiz extends Drink {
    private int numOfBottles;

    public FizzWiz(double price, int happinessIndex, int numOfBottles){
        super(price, happinessIndex, numOfBottles, true);
        this.numOfBottles = numOfBottles;
    }

    public boolean equals(Object object){
        if(object instanceof FizzWiz fizzWiz) {
            return super.equals(object) && this.numOfBottles == fizzWiz.numOfBottles;
        }else{
            return false;
        }
    }

    public FizzWiz getPortion(int numBottlesDesired){
        if(numBottlesDesired <= 0){
            return null;
        }

        if(numBottlesDesired <= this.numOfBottles){
            FizzWiz portion = new FizzWiz(this.getPrice(), this.getHappinessIndex(), numBottlesDesired);
            this.numOfBottles -= numBottlesDesired;
            return portion;
        }

        return null;
    }
}
