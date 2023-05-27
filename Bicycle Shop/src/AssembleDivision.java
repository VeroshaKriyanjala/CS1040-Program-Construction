public class AssembleDivision extends BicycleShop{

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
