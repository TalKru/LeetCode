package questions.playList;

public class main {

    public static void main(String[] args) {
        /*
        int songsAmount = 4;
        Song[] songArr = new Song[songsAmount];
        Song song1 = new Song("Don't Call Me Up",     "Mabel" );
        Song song2 = new Song("Middle of the Night",  "Elley Duhe");
        Song song3 = new Song("What have you done",   "Within Temptation");
        Song song4 = new Song("Set Fire to the Rain", "No Resolve");
        songArr[0] = song1;
        songArr[1] = song2;
        songArr[2] = song3;
        songArr[3] = song4;
        */
        Song[] songArr = {
                new Song("Don't Call Me Up",    "Mabel" ),
                new Song("Middle of the Night", "Elley Duhe"),
                new Song("What have you done",  "Within Temptation"),
                new Song("Set Fire to the Rain","No Resolve")
        };

        shufflePlaylist shuffPL = new shufflePlaylist(songArr);

        for (int k = 0; k < 3; k++) {
            for (int i = 1; i <= songArr.length; i++) { // full playlist cycle
                shuffPL.pullSong().printSong();
            }
            System.out.println("=================(RESET LIST)=====================");
        }
    }
}
