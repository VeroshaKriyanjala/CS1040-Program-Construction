import java.util.ArrayList;
import java.util.Scanner;

public abstract class BeverageMachine {
    protected static int counter=0;
    protected static  ArrayList<Integer> cupsCount;
    protected static String lastSold;

    static Scanner scanner=new Scanner(System.in);

    public static void process(){
        cupsCount=new ArrayList<Integer>();
        cupsCount.add(0);
        cupsCount.add(0);
        boolean choice2=true;
        int totalCupAmount;

        while(choice2){
            System.out.println("1.Produce a beverage ");
            System.out.println("2.Print calaries in the cup");
            System.out.println("3.Print number of Tea and Coffee cups produced");
            System.out.println("4.Exit");
            int choice=scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Name");
                    String name=scanner.next();
                    Customer newCustomer=new Customer(name);

                    System.out.println(newCustomer.getName()+", what Beverage do you want : ");
                    System.out.println("1.Water");
                    System.out.println("2.Tea");
                    System.out.println("3.Coffee");
                    int choiceBeverage=scanner.nextInt();
                    switch(choiceBeverage){
                        case 1:
                            Water water=new Water();
                            water.processWater(newCustomer);
                            System.out.println(newCustomer.getBoughtItem());
                            continue;
                        case 2:
                            Tea tea=new Tea();
                            tea.processTea(newCustomer);                         
                            continue;
                        case 3:
                            Coffee coffee=new Coffee();
                            coffee.processCoffee(newCustomer);
                            continue;
                    }
                    continue;
                case 2:
                    if(lastSold=="Tea"){
                        System.out.println("Tea");
                        System.out.println("calories value is : "+"10");
                    }else if(lastSold=="Coffee"){
                        System.out.println("Coffee");
                        System.out.println("calories value is : "+"20");
                    }else{
                        System.out.println("Water");
                        System.out.println("calories value is : "+"0");
                    }
                    continue;
                case 3:
                    System.out.println("Number of Coffee cups produced : "+cupsCount.get(0));
                    System.out.println("Number of Tea cups produced : "+cupsCount.get(1));
                    totalCupAmount=cupsCount.get(0)+cupsCount.get(1);
                    System.out.println("Number of Total cups produced : "+totalCupAmount);
                    continue;
                case 4:
                    System.out.println("Thank you");
                    choice2=false;
                    continue;
                default:
                    System.out.println("Invalid Input");
                    continue;
            }
        }
    }
}

        // /if 0 <beverage name>
        // Get the beverage machine to produce the beverage
        // print its name to console
        // // If 1
        // Get the beverage machine to calculate the amount of calories in the cup that it
        // last produced.
        // Print this value to the console
        // // If 3
        // Get the beverage machine to return the number of coffee+tea cups it produced
        // Print this value to the console
        // //if anything else
        // //print “invalid input”

