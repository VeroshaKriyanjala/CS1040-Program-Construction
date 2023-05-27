import java.util.Scanner;

public class BicycleShop {
    private static Scanner scanner = new Scanner(System.in);

    public Bicycle process(String bicycleType){
        String color;
        Boolean qualityPassedStatus;
        Boolean returnToAssemblyDEvision=true;
        if(bicycleType.equals("0 MotorBicycle")){
            System.out.println("Enter the color of Motor Bicycle : ");
            color=scanner.nextLine();
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
        }else if(bicycleType.equals("0 KidsFootBicycle")){
            System.out.println("Enter the color of Kids Foot Bicycle : ");
            color=scanner.nextLine();
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
        }else if(bicycleType.equals("0 AdultFootBicycle")){
            System.out.println("Enter the color of Adult Foot Bicycle : ");
            color=scanner.nextLine();
            Bicycle adultFootBicycle=AssembleDivision.assembleAdultFootBicycle(color);
            System.out.println("Id num "+adultFootBicycle.getId()+" adult's foot bicycle is ready for you.");
            System.out.println("This is your "+adultFootBicycle.getColor()+" colored adult foot bicycle");
            return adultFootBicycle;
        }
        return null;
    }
}                   