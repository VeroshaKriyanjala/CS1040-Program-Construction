public class Bicycle {
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
