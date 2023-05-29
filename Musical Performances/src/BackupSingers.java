public class BackupSingers extends Singers implements Ibackup{

    public BackupSingers(String ArtistName) {
        super(ArtistName);
    }

    @Override
    public void sing(){
        System.out.println("Backup Singers are Singing");
    }

    public void backup(){
        System.out.println("Backup Singers back up the artist by singing");
    }
 
}
