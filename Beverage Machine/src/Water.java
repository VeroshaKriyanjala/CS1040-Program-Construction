public class Water extends BeverageMachine {

    public Water(){
        counter++;
    }

    public String processWater(Customer newCustomer){
        newCustomer.setBoughtItem("Water");
        lastSold=newCustomer.getBoughtItem();
        System.out.println(newCustomer.getName()+", enjoy a cup of Water.");
        return lastSold;
    }

}

