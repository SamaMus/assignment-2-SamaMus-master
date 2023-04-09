package code;

import given.Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* *
 *
 * ASSIGNMENT 2-Part2
 * STUDENT AUTHOR: <Insert Student Name>
 *
 * MODIFY
 *
 * */

public class Playlist {

    LLDeque<Song> deque; // your playlist, you will perform most of your operations on this deque
    PlayQueue pq; // to use for play functionality later
    /*
     * ADD FIELDS IF NEEDED
     */

    public Playlist() {
        deque = new LLDeque<Song>() {
            @Override
            public void addLast(Song obj) {

            }

            @Override
            public <E> E removeFirst() {
                return null;
            }

            @Override
            public <E> E peekFirst() {
                return null;
            }

            @Override
            public <E> E peekFront() {
                return null;
            }
        };
        pq = new PlayQueue(deque);

        /*
         *
         * Feel free to modify it if needed.
         *
         */
    }

    // Song class is given to you. You do not need to modify this class.
    public static class Song {
        String name;
        String artist;
        int year;

        public Song(String n, String a, int y) {
            name = n;
            artist = a;
            year = y;
        }

        @Override
        public String toString() {
            return "Song: " + name + " -- by " + artist + " -- released in " + year + "";
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!Playlist.Song.class.isAssignableFrom(obj.getClass())) {
                return false;
            }

            final Playlist.Song other = (Playlist.Song) obj;
            if (this.name == other.name && this.artist == other.artist && this.year == other.year)
                return true;
            else
                return false;
        }

        public String getName(){
            return name;
        }

        public String getArtist(){
            return artist;
        }

        public int getYear(){
            return year;
        }
    }

    /*
     *
     * Feel free to modify it if needed.
     *
     */
    public void loadPlaylist(String fileName) throws IOException {
        /*
         * MODIFY THIS FUNCTION IF NEEDED
         */
        BufferedReader reader;

        reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();

        while (line != null) {
            String parts[] = line.split(";");
            Song s = new Song(parts[0], parts[1], Integer.parseInt(parts[2]));
            deque.addBehind(s);
            line = reader.readLine();
        }
        reader.close();
    }

    // Do not modify this function so that we can have same outputs for autograder comparison
    public String toString() {
        StringBuilder sb = new StringBuilder(1000);
        if (deque.toString() == null){
            return null;
        }
        sb.append(deque.toString());
        return sb.toString();
    }

    /*
     * ADD METHODS IF NEEDED
     */


    // Insert a new Song to the end of our dequeu. Name, artist and year are given to you as input arguments.
    public void insertSong(String n, String a, int y) {
        // To-DO
        Util.NotImplementedYetSoft();
    }

    // Delete a song with a given name from the playlist. You do not need to consider the case where multiple songs
    // having the same name. Do not do anything if song does not exist in the playlist. Return the deleted song.
    // After deleting a Song rest of the order MUST remain same as before.
    // Make use of the data structures you have implemented:
    public Song deleteSong(String n) {
        // To-DO
        Util.NotImplementedYetSoft();
        return null;
    }

    // Reverse the order of Songs in the playlist.
    // For instance if the initial order is A-B-C-D new order has to be D-C-B-A.
    public void reverse() {
        // To-DO
        Util.NotImplementedYetSoft();
    }


    // Perform shuffle operation with the algorithm defined in the homework pdf for you
    // Be careful about the specific random numbers that are generated for you with the given seed.
    // Modify the deque here
    // ints is a double array where ints[i][0] and ints[i][1] has the two random numbers to swap
    // for ith step
    // ints[i][0] can be greater or smaller than ints[i][1]
    // these random numbers are fixed with a seed in the main file to test later with autograd

    public void shuffle(int[][] ints) {
        // To-DO
        Util.NotImplementedYetSoft();
    }

    // Given for the sake of simplicity.
    public void play() {
        pq = new PlayQueue(deque);
    }


    // Given for the sake of simplicity.
    public String print_pq() {
        return pq.toString();
    }


    // This method plays a song from your playqueue which means it pops the topmost song.
    // If playqueue loop flag is true played song MUST be re-added to the end of plaqueue.
    public void play_song(String n) {
        // To-DO
        Util.NotImplementedYetSoft();
    }

    public static class PlayQueue {
        Queue playqueue;
        Boolean loop;

        // Implement constructor
        // Initial loop flag MUST be true
        public PlayQueue(LLDeque<Song> q) {
            // To-DO
            Util.NotImplementedYetSoft();
        }

        @Override
        public String toString() {
            if (playqueue != null){
                return playqueue.toString();
            }
            return null;
        }

        public Boolean getLoop() {
            return loop;
        }

        public void setLoop(Boolean l){
            loop = l;
        }
    }

};