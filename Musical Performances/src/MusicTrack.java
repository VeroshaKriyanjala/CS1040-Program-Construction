public class MusicTrack{
    String musicTrackName;
    String musicTrackDuration;

    public MusicTrack(String musicTrackName,String musicTrackDuration){
        this.musicTrackName=musicTrackName;
        this.musicTrackDuration=musicTrackDuration;
    }

    public void playMusicTrack(){
        System.out.println("Music track '"+ this.musicTrackName+"' is playing");
    }
}
