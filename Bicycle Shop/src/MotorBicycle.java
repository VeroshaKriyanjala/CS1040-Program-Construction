public class MotorBicycle extends Bicycle{
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
