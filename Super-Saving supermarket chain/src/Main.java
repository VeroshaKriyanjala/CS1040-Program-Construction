import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void dummyData(){
        Cashier cashier1=new Cashier("Kamal");
        Cashier cashier2=new Cashier("Nayana");
        Cashier cashier3=new Cashier("Amal");

        Customer customer1=new Customer("Nesha");
        Customer customer2=new Customer("Aravinda");
        Customer customer3=new Customer("kokila");

        Items item1=new Items("Apple",10,100,"2023/05/01","2023/05/09",10);
        Items item2=new Items("Orange",20.5,100,"2023/06/01","2023/05/10",5);
        Items item3=new Items("Grapes",100,50,"2023/05/05","2023/05/11",8);
        Items item4=new Items("Papaya",1500,500,"2023/03/10","2023/0512",12);
        Items item5=new Items("Nelli",20.5,100,"2023/06/12","2023/05/13",15);
        Items item6=new Items("Pine",120.5,100,"2023/04/10","2023/05/14",9);

    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ItemCodeNotFound {
        
        dummyData();
        
        POS.process();
    }
}
