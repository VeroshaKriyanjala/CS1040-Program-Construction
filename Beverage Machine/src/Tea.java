public class Tea extends BeverageMachine {
    private static int teaCounter=0;
    private int calories;

    public Tea(){
        counter++;
        teaCounter++;
        calories=10;
    }

    public int getCalories(){
        return calories;
    }

    public String processTea(Customer newCustomer){
        newCustomer.setBoughtItem("Tea");
        lastSold=newCustomer.getBoughtItem();
        System.out.println(newCustomer.getName()+", enjoy a cup of Tea.");
        cupsCount.set(1,teaCounter);
        return lastSold;
    }
}
