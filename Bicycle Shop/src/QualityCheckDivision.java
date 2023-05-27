import java.util.HashMap;
import java.util.Random;

public class QualityCheckDivision extends BicycleShop{
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
