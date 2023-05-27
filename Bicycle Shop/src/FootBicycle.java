public class FootBicycle extends Bicycle{
    private String bell;

    public FootBicycle(String color) {
        super(color);
        this.bell="Bell";
    }

    public String getBell(){
        return bell;
    }
}