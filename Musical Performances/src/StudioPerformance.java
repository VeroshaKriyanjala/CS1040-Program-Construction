public class StudioPerformance extends Performance{

    public StudioPerformance(String performanceName) {
        super(performanceName);
    }

    public void audioProcessing(){

    }

    @Override
    public void recordPerformance(){
        System.out.println("Studio Performance is recording");
    }
}
