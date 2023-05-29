public class MainArtist extends Singers{

    public MainArtist(String ArtistName) {
        super(ArtistName);
    }

    @Override
    public void sing(){
        System.out.println("Main Artist is singing");
    }
}
