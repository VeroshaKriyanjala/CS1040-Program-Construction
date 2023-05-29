public class LivePerformance extends Performance{

    public LivePerformance(String performanceName) {
        super(performanceName);
    }

    public void interactWithAudience(){
        System.out.println("The Artist is interacting with audience");
    }

    @Override
    public void recordPerformance(){
        System.out.println("Live Performance is recording");
    }
}
