public class Customer {
    private String name;
    private String boughtItem;

    public Customer(String name) {
        this.name = name;
        this.boughtItem = null;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public void setBoughtItem(String boughtItem){
        this.boughtItem=boughtItem;
    }

    public String getBoughtItem(){
        return boughtItem;
    }
}
