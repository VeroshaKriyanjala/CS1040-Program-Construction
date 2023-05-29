import java.io.Serializable;

public class Items implements Serializable{
    private String itemName;
    private static int itemCodeCounter=0;
    private int itemCode;
    private double price;
    private double weight;
    private String manufacturedDate;
    private String expiredDate;
    private double discount;

    public Items(String itemName,double price, double weight, String manufacturedDate, String expiredDate, double discount) {
        this.itemName=itemName;
        this.itemCode = ++itemCodeCounter;
        this.price = price;
        this.weight = weight;
        this.manufacturedDate = manufacturedDate;
        this.expiredDate = expiredDate;
        this.discount = discount;
        POS.addItemsToHashMap(this);
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName=itemName;
    }

    public int getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
