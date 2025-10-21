package assignment1.items;

public class Snack extends StoreItem {
    private String snackType;
    private MyDate expirationDate;

    public Snack(double price, int happinessIndex, String snackType, MyDate expirationDate) {
        super(price, happinessIndex);
        this.snackType = snackType;
        this.expirationDate = expirationDate;
    }
    private String getSnackType(){
        return snackType;
    }
    private MyDate getExpirationDate(){
        return expirationDate;
    }

    public boolean equals(Object object){
        if (object== null) {
            return false;
        }

        if (!(object instanceof Snack)) {
            return false;
        }

        if (this == object) {
            return true;
        }

        if (!(this.getSnackType().equals(((Snack) object).getSnackType()))) {
            return false;
        }

        if (!(this.expirationDate.equals(((Snack) object).expirationDate))) {
            return false;
        }

        if (!(this.getPrice() == ((Snack) object).getPrice())) {
            return false;
        }

        if (!(this.getHappinessIndex() == ((Snack) object).getHappinessIndex())) {
            return false;
        }

        return true;
    }

    public boolean isExpired() {
        MyDate today = MyDate.today();

        if (today.getYear() > this.expirationDate.getYear()) {
            return true;
        }

        else if (today.getYear() == this.expirationDate.getYear()) {
             if (today.getMonth() > this.expirationDate.getMonth()) {
                 return true;
             }

             else if (today.getMonth() == this.expirationDate.getMonth()) {
                 if (today.getDay() > this.expirationDate.getDay()){
                     return true;
                 }
                 else {
                     return false;
                 }
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
    public int getHappinessIndex(){
        if(isExpired()){
            return super.getHappinessIndex() / 2;
        }else{
            return super.getHappinessIndex();
        }
    }
}
