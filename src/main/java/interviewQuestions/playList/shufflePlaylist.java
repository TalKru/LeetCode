package interviewQuestions.playList;
/*
Implement a playlist shuffle:

- play randomly each song from the playlist while not repeating previously played songs
- in place solution
- fast and efficient as possible
 */
import java.util.Random;

public class shufflePlaylist {

    Song[] playList;
    int startPointer;
    int freshSongsAmount;

    public shufflePlaylist(Song[] playList) { // Constructor

        int len = playList.length;

        this.freshSongsAmount = len;
        this.startPointer = 0;
        this.playList = new Song[len];

        for (int i = 0; i < len; i++) {
            this.playList[i] = playList[i];
        }
    }

    public Song pullSong() {

        Random rand = new Random();
        int len = playList.length;
        int randSongIndex = startPointer + rand.nextInt(len - startPointer); // choose next song

        Song chosenRandSong = this.playList[randSongIndex]; // save reference to return song

        swapSongs(startPointer, randSongIndex);     /* [V][V][?][?][rand][?][?] */
                                                    /* [V][V][rand][?][?][?][?] */
        startPointer++;

        if (startPointer >= len) { // if we are out of songs
            startPointer = 0; // start over
        }
        return chosenRandSong;
    }

    public void swapSongs(int i, int j) {

        Song tempSong = playList[i];
        playList[i] = playList[j];
        playList[j] = tempSong;
    }

}

