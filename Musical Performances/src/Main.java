public class Main {
    public static void main(String[] args) {
        MainArtist mainArtist=new MainArtist("Taylor Swift");

        Performance livePerformance=new LivePerformance("Eras Tour");
        MusicTrack tracklist1=new MusicTrack("Lavender Haze", "10 minutes");
        MusicTrack tracklist2=new MusicTrack("All Too Well","12 minutes");
        MusicTrack tracklist3=new MusicTrack("the lakes","8 minutes");
        MusicTrack tracklist4=new MusicTrack("The Man","15 minutes");
        MusicTrack tracklist5=new MusicTrack("Love Story","16minutes");

        BackupSingers backupSinger1=new BackupSingers("Jeslyn");
        BackupSingers backupSinger2=new BackupSingers("Melanie");

        BackupDancers backupDancer1=new BackupDancers("Stephanie");
        BackupDancers backupDancer2=new BackupDancers("jake");

        System.out.println("Welcome to the Performance "+livePerformance.getPerformanceName()+" by "+mainArtist.getArtistName()+"!");
        mainArtist.sing();
        backupSinger1.backup();
        backupSinger2.backup();
        backupDancer1.backup();
        backupDancer2.backup();

        tracklist1.playMusicTrack();
        tracklist2.playMusicTrack();
        tracklist3.playMusicTrack();
        tracklist4.playMusicTrack();
        tracklist5.playMusicTrack();
        
    }
}
