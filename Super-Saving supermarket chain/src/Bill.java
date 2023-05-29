import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable{
    private Cashier cashierName;
    private String branch;
    private Customer customer;
    private double totalDiscount;
    private double totalPrice;
    private String billDate;
    private List<BoughtItems> boughtItems;

    public Bill(Cashier cashierName, String branch, Customer customer) {
        this.cashierName = cashierName;
        this.branch = branch;
        this.customer = customer;
        this.totalDiscount = 0.0;
        this.totalPrice = 0.0;
        this.billDate = getCurrentDateTime();
        this.boughtItems = new ArrayList<>();
    }

    public Bill(Cashier cashierName, String branch) {
        this.cashierName = cashierName;
        this.branch = branch;
        this.customer = null;
        this.totalDiscount = 0.0;
        this.totalPrice = 0.0;
        this.billDate = getCurrentDateTime();
        this.boughtItems = new ArrayList<>();
    }

    public Cashier getCashierName() {
        return cashierName;
    }
    
    public void setCashierName(Cashier cashierName) {
        this.cashierName = cashierName;
    }
    
    public String getBranch() {
        return branch;
    }
    
    public void setBranch(String branch) {
        this.branch = branch;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public double getTotalDiscount() {
        return totalDiscount;
    }
    
    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public List<BoughtItems> getBoughtItems() {
        return boughtItems;
    }
    
    public void addBoughtItem(BoughtItems boughtItem) {
        boughtItems.add(boughtItem);
    }

    public String getBillDate() {
        return billDate;
    }
    
    private String getCurrentDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void printBill(Customer customer,Cashier cashier,String branch){
        System.out.println(".....Super-Saving supermarket chain.....");
        System.out.println("Cashier's Name : "+cashier.getCashierName());
        System.out.println("Branch : "+branch);
        System.out.println("Customer's Name : "+customer.getCustomerName());
        // System.out.println("Customer's Name : " + (customer.getCustomerName() != null && !customer.getCustomerName().isEmpty() ? customer.getCustomerName() : ""));
        System.out.println(this.getCurrentDateTime());
        for(BoughtItems boughtItem: boughtItems){
            double payableAmountPerItem=boughtItem.findTotalAmountForOneItem()-boughtItem.findTotalDiscountForOneItem();
            System.out.println(boughtItem.getBoughtItem().getItemName()+"  Rs."+boughtItem.getBoughtItem().getPrice()+"  "+boughtItem.getBoughtItem().getDiscount()+"   "+boughtItem.findTotalAmountForOneItem()+" "+boughtItem.findTotalDiscountForOneItem()+"    "+payableAmountPerItem);
            totalDiscount=totalDiscount+boughtItem.findTotalDiscountForOneItem();
            totalPrice=totalPrice+boughtItem.findTotalAmountForOneItem();
        }
        System.out.println("Total Amount : Rs."+totalPrice);
        System.out.println("Total Discount : Rs."+totalDiscount);
        System.out.println("Total payable amount : Rs."+(totalPrice-totalDiscount));
        System.out.println("..........................................");
    }
}
