import java.io.Serializable;

public class Customer implements Serializable{
    private static int customerIdCounter=0;
    private int customerId;
    private String customerName;

    public Customer(String customerName){
        customerIdCounter=customerIdCounter+1;
        this.customerId=customerIdCounter;
        this.customerName=customerName;
        POS.addCustomerToHashMap(this);
    }
    

    public Customer(){
        customerIdCounter=customerIdCounter+1;
        this.customerId=customerIdCounter;
        this.customerName=null;

    }

    public void setCustomerName(String customerName){
        this.customerName=customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

}
