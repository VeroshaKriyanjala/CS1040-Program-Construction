import java.util.Scanner;
import java.util.HashMap;
import java.util.Random;

public class template {
    private static Scanner scanner = new Scanner(System.in);;

	public static void main(String[] args) {
		BicycleShop shop = new BicycleShop();
		Boolean choice=true;

        while(choice) {
            System.out.println("Is there is a new customer : ");
            String newCustomer=scanner.nextLine();
            if(newCustomer.equals("yes")){
                choice=true;

                System.out.println("Enter Value : ");
                String s = scanner.nextLine();
    
                if(s.startsWith("0")){			
                    if (s.length()>2) {// the input string may contain bicycle type
                        if(s.equals("0 MotorBicycle")){
                            System.out.println("You are going to buy a MotorBicycle");
                        }else if(s.equals("0 KidsFootBicycle")){
                            System.out.println("You are going to buy KidsFootBicycle");
                        }else if(s.equals("0 AdultFootBicycle")){
                            System.out.println("You are going to buy AdultFootBicycle");
                        }
                        shop.process(s).getColor();  
                    }
                }
                else{
                    System.out.println("invalid input : "+s);
                }
            }else if(newCustomer.equals("no")){
                choice=false;
            }
        }
        System.out.println("Do you want to check the Quality check Records : ");
        String recordCheckChoice=scanner.nextLine();
        if(recordCheckChoice.equals("yes")){
            QualityCheckDivision.printQualityCheckRecords();
        }
        System.out.println("Thank you");
        
	        // if (!s.equals("")) {
	        //     //main code
            //     if(s.equals("0 MotorBicycle") || s.equals("0 KidsFootBicycle") || s.equals("0 AdultFootBicycle")){
            //         shop.process(s);
            //     }else{
            //         System.out.println("invalid input : "+s);
            //     }
	        // }	       
	    // }
	}
}


class Bicycle {
    private String color;
    private int id;
    private static int totalCounter=0;

    public Bicycle(String color){
        totalCounter++;
        this.color=color;
        this.id=totalCounter;
    }

    public int getId(){
        return id;
    }
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color=color;
    }
    
}

class FootBicycle extends Bicycle{
    private String bell;

    public FootBicycle(String color) {
        super(color);
        this.bell="Bell";
    }

    public String getBell(){
        return bell;
    }
}

class AdultFootBicycle extends FootBicycle{
    private String lamp;

    public AdultFootBicycle(String color){
        super(color);
        this.lamp="Lamp";
    }

    public String lamp(){
        return lamp;
    }
}

class MotorBicycle extends Bicycle{
    private int engineNumber;
    private static int motorBicycleCounter=400;

    public MotorBicycle(String color) {
        super(color);
        motorBicycleCounter++;
        this.engineNumber=motorBicycleCounter;
    }

    public int getEngineNumber(){
        return engineNumber;
    }
    
}

class KidsFootBicycle extends FootBicycle{
    private String stabilizers;
    public KidsFootBicycle(String color) {
        super(color);
        this.stabilizers="Stabilizers";
    }

    public String getStabilizers(){
        return stabilizers;
    }
}

// import java.util.Scanner;

class BicycleShop {
    // private static Scanner scanner;

    public Bicycle process(String bicycleType){
        String color;
        Boolean qualityPassedStatus;
        Boolean returnToAssemblyDEvision=true;
        if(bicycleType=="0 MotorBicycle"){
            System.out.println("Enter the color of Motor Bicycle : ");
            color="red";
            while(returnToAssemblyDEvision){
                Bicycle motorBicycle=AssembleDivision.assembleMotorBicycle(color);
                qualityPassedStatus=QualityCheckDivision.getQuality(motorBicycle);
                if(qualityPassedStatus){
                    System.out.println("This is your "+motorBicycle.getColor()+" colored motor bicycle.");
                    returnToAssemblyDEvision=false;
                    return motorBicycle;
                }else{
                    System.out.println("Wait a moment. Quality check failed. We create a another bicycle for you.");
                }
            }
        }else if(bicycleType=="0 KidsFootBicycle"){
            System.out.println("Enter the color of Kids Foot Bicycle : ");
            color="green";
            while(returnToAssemblyDEvision){
                Bicycle kidsFootBicycle=AssembleDivision.assembleKidsFootBicycle(color);
                qualityPassedStatus=QualityCheckDivision.getQuality(kidsFootBicycle);
                if(qualityPassedStatus){
                    System.out.println("This is your "+kidsFootBicycle.getColor()+" colored kid's foot bicycle.");
                    returnToAssemblyDEvision=false;
                    return kidsFootBicycle;
                }else{
                    System.out.println("Wait a moment. Quality check failed. We create a another bicycle for you.");
                }
            }
        }else if(bicycleType=="0 AdultFootBicycle"){
            System.out.println("Enter the color of Adult Foot Bicycle : ");
            color="blue";
            Bicycle adultFootBicycle=AssembleDivision.assembleAdultFootBicycle(color);
            System.out.println("This is your "+adultFootBicycle.getColor()+" colored adult foot bicycle");
            return adultFootBicycle;
        }
        return null;
    }
}                   

class AssembleDivision extends BicycleShop{

    public static KidsFootBicycle assembleKidsFootBicycle(String color) {
        KidsFootBicycle kidsFootBicycle=new KidsFootBicycle(color);
        System.out.println("Kids Foot Bicycle was assembled.");
        return kidsFootBicycle;
    }

    public static AdultFootBicycle assembleAdultFootBicycle(String color) {
        AdultFootBicycle adultFootBicycle=new AdultFootBicycle(color);
        System.out.println("Adult Foot Bicycle was assembled.");
        return adultFootBicycle;
    }

    public static MotorBicycle assembleMotorBicycle(String color) {
        MotorBicycle  motorBicycle=new MotorBicycle(color);
        System.out.println("Motor Bicycle was assembled.");
        return motorBicycle;
    }

}

class QualityCheckDivision extends BicycleShop{
    static HashMap<Integer, Boolean> qualityChechedDeatails = new HashMap<Integer, Boolean>();

    public static Boolean getQuality(Bicycle bicycle){
        Boolean passTest=true;
        if(bicycle instanceof MotorBicycle){
            MotorBicycle motorBicycle=(MotorBicycle) bicycle;
            Random random = new Random();
            passTest=random.nextBoolean();
            if(passTest){
                System.out.println("The quality of the Motor Bicycle is checked. Id num "+motorBicycle.getId()+" motor bicycle is ready for you.");
                qualityChechedDeatails.put(bicycle.getId(),passTest);
            }else{
                qualityChechedDeatails.put(bicycle.getId(),passTest);
            }
        }else if(bicycle instanceof KidsFootBicycle){
            KidsFootBicycle kidsFootBicycle=(KidsFootBicycle) bicycle;
            Random random = new Random();
            passTest=random.nextBoolean();
            if(passTest){
                System.out.println("The quality of the Kids Foot Bicycle is checked. Id num "+kidsFootBicycle.getId()+" kids bicycle is ready for you.");
                qualityChechedDeatails.put(bicycle.getId(),passTest);
            }else{
                qualityChechedDeatails.put(bicycle.getId(),passTest);
            }
        }
        return passTest;
    }

    public static void printQualityCheckRecords(){
        for(int i: qualityChechedDeatails.keySet()){
            System.out.println("id number : "+i+"   Status : "+ qualityChechedDeatails.get(i));
        }
    }

}

