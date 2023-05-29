import java.io.Serializable;

public class BoughtItems implements Serializable{
    private Items item;
    private int quantity;
    private double totalAmountForOneItem;
    private double totalDiscountForOneItem;

    public BoughtItems(Items item,int quantity){
        this.item=item;
        this.quantity=quantity;
        this.totalAmountForOneItem=0;
        this.totalDiscountForOneItem=0;
    }

    public Items getBoughtItem(){
        return item;
    }

    public int getBoughtItemQuantity(){
        return quantity;
    }

    public void setTotalAmountForOneItem(double totalAmountForOneItem){
        this.totalAmountForOneItem=totalAmountForOneItem;
    }

    public double getTotalAmountForOneItem(){
        return totalAmountForOneItem;
    }

    public void setTotalDiscountForOneItem(double totalDiscountForOneItem){
        this.totalDiscountForOneItem=totalDiscountForOneItem;
    }

    public double getTotalDiscountForOneItem(){
        return totalDiscountForOneItem;
    }

    public double findTotalAmountForOneItem(){
        double totalAmountForOneItem=this.getBoughtItem().getPrice()*this.getBoughtItemQuantity();
        return totalAmountForOneItem;
    }

    public double findTotalDiscountForOneItem(){
        double totalDiscountForOneItem=this.getBoughtItem().getPrice()*this.getBoughtItemQuantity()*this.getBoughtItem().getDiscount()/100;
        return totalDiscountForOneItem;
    }
}
