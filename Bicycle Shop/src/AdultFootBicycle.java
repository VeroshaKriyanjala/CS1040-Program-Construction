public class AdultFootBicycle extends FootBicycle{
    private String lamp;

    public AdultFootBicycle(String color){
        super(color);
        this.lamp="Lamp";
    }

    public String lamp(){
        return lamp;
    }
}
