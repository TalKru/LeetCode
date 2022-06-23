package questions.playList;

public class Song {
    private final String songName;
    private final String artist;

    public Song(String songName, String artist) {

        this.songName = songName;
        this.artist = artist;
    }

    public void printSong() {

        System.out.println("[Name: " + this.songName + "| Artist: " + this.artist + "]");
    }
}
