import java.util.Scanner;

public class Demo {
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
