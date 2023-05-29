public class BackupDancers extends Artists implements Ibackup{

    public BackupDancers(String ArtistName) {
        super(ArtistName);
    }

    public void dance(){
        System.out.println("Backup Dancers are Dancing");
    }
    
    public void backup(){
        System.out.println("Backup dancers backup the artist by dancing");
    }
}
