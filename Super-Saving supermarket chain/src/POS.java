import java.io.*;
import java.util.*;

public class POS implements Serializable{
    static HashMap<Integer,Items> itemCodeNItem=new HashMap<>();
    static HashMap<String,Customer> customerNameNCustomer=new HashMap<>();
    static HashMap<String,Cashier> cashierNameNCashier=new HashMap<>();
    static HashMap<Integer,Bill> billHashMap=new HashMap<>();


    public static void addItemsToHashMap(Items item){
        itemCodeNItem.put(item.getItemCode(),item);
    }

    public static void addCustomerToHashMap(Customer customer){
        customerNameNCustomer.put(customer.getCustomerName(),customer);
    }

    public static void addCashierToHashMap(Cashier cashier){
        cashierNameNCashier.put(cashier.getCashierName(),cashier);
    }

    public static Items getItemsFromHashMap(int itemName){
        return itemCodeNItem.get(itemName);
    }

    public static Customer getCustomerFromHashMap(String customerName){
        return customerNameNCustomer.get(customerName);
    }

    public static Cashier getCashierFromHashMap(String cashierName){
        return cashierNameNCashier.get(cashierName);
    }

    static Scanner scanner=new Scanner(System.in);

    public static void process() throws ItemCodeNotFound{
        System.out.println("Enter the branch : ");
        String branch=scanner.nextLine();
        Cashier cashier=new Cashier("Ashan");
        int mainOption=1;
        while(mainOption!=3){
            System.out.println("1.New customer");
            System.out.println("2.Existing Customer");
            System.out.println("3.Exit");
            mainOption=scanner.nextInt();
            scanner.nextLine();
            switch(mainOption){
                case 1:
                    System.out.println("Welcome to the Super-Saving supermarket chain");
                    System.out.println("Are you a registered customer (yes/no): ");
                    String registerFind=scanner.nextLine();
                    Bill bill;
                    Customer customer=null;
                    if(registerFind.equals("yes")){
                        System.out.println("Enter Customer's name : ");
                        String name=scanner.nextLine();
                        customer=POS.getCustomerFromHashMap(name);
                        bill=new Bill(cashier,branch, customer);
                        addItems(bill,cashier,customer,branch);
                    }else{
                        bill=new Bill(cashier,branch);
                        customer=new Customer();
                        addItems(bill,cashier,customer,branch);
                    }
                    
                    continue;
                case 2:
                    System.out.println("Enter customer Id : ");
                    int customerId=scanner.nextInt();
                    scanner.nextLine();
                    try {
                        addItems(getSerializedHashMap().get(customerId),cashier,getSerializedHashMap().get(customerId).getCustomer(),branch);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;
                case 3:
                    break;   
            }
        }
    }

    public static void addItems(Bill bill,Cashier cashier,Customer customer,String branch) throws ItemCodeNotFound{
        System.out.println("Cashier,now you can start adding items : ");
        String cashiersChoice="yes";
        while(cashiersChoice.equals("yes")){
            System.out.println("Do you want to add item (yes/no): ");
            cashiersChoice=scanner.nextLine();
            if(cashiersChoice.equals("yes")){
                System.out.println("Enter item code : ");
                int itemCode=scanner.nextInt();
                Items item;
                item = cashier.addItemsOfCustomer(itemCode);
                scanner.nextLine();
                System.out.println("Enter item quantity : ");
                int quantity=scanner.nextInt();
                scanner.nextLine();
                BoughtItems boughtItem=new BoughtItems(item, quantity);
                boughtItem.setTotalAmountForOneItem(boughtItem.findTotalAmountForOneItem());
                boughtItem.setTotalDiscountForOneItem(boughtItem.findTotalDiscountForOneItem());
                bill.addBoughtItem(boughtItem);
            }
        }
        System.out.println("Do you want to terminate bill (yes/no): ");
        cashiersChoice=scanner.nextLine();
        if(cashiersChoice.equals("yes")){
            bill.printBill(customer, cashier, branch);
        }else{
            System.out.println("Your customer Id is : "+customer.getCustomerId());
            billHashMap.put(customer.getCustomerId(), bill);
            try(ObjectOutputStream b=new ObjectOutputStream(new FileOutputStream("BillDetials.ser"))){
                b.writeObject(billHashMap);
                b.close();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static Items getItemDetails(int itemCode) throws ItemCodeNotFound{
        Items itemGoingToAdd=null;
        itemGoingToAdd=POS.getItemsFromHashMap(itemCode);
        return itemGoingToAdd; 
    }

    public static HashMap<Integer,Bill> getSerializedHashMap() throws FileNotFoundException, IOException{
        HashMap<Integer,Bill> deserializedHashMap=null;
        try(ObjectInputStream B=new ObjectInputStream(new FileInputStream("BillDetials.ser"))){
            Object one=B.readObject();
            deserializedHashMap=(HashMap<Integer,Bill>)one;
        }catch(ClassNotFoundException e){
            e.getStackTrace();
        }
        return deserializedHashMap;
    }
}
