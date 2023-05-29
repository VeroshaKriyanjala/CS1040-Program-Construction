import java.io.Serializable;

public class Cashier implements Serializable{
    String cashierName;
    
    public Cashier(String cashierName){
        this.cashierName=cashierName;
        POS.addCashierToHashMap(this);
    }

    public void setCashierName(String cashierName){
        this.cashierName=cashierName;
    }

    public String getCashierName(){
        return cashierName;
    }
    
    public Items addItemsOfCustomer(int itemCode) throws ItemCodeNotFound{
        return POS.getItemDetails(itemCode);
        
    }
}
