public class Coffee extends BeverageMachine {
    private static int coffeeCounter=0;
    private int calories;

    public Coffee(){
        counter++;
        coffeeCounter++;
        calories=20;
    }

    public int getCalories(){
        return calories;
    }

    public String processCoffee(Customer newCustomer){
        newCustomer.setBoughtItem("Coffee");
        lastSold=newCustomer.getBoughtItem();
        System.out.println(newCustomer.getName()+", enjoy a cup of Coffee.");
        cupsCount.set(0,coffeeCounter);
        return lastSold;
    }

}
