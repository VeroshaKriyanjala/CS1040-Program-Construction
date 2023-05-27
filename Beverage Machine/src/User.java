public class User {
    private String name;

    public User(){
        this.name="Verosha";
    }

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    void useMachine(){
        BeverageMachine.process();
    }
}
