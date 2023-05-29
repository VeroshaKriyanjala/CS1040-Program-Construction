public class Performance {
    String performanceName;
    String PerformanceYear;
    String performanceVenue;

    public Performance(String performanceName){
        this.performanceName=performanceName;
        this.PerformanceYear="2023";
        this.performanceVenue="Glendale";
    }

    public void setPerformanceName(String performanceName){
        this.performanceName=performanceName;
    }
    public String getPerformanceName(){
        return performanceName;
    }
    public String getPerformanceYear(){
        return PerformanceYear;
    }
    public String getPerformanceVenue(){
        return performanceVenue;
    }

    public void recordPerformance(){
        
    }

}
