package org.example.ClassicalRockMusicPlayer;

import org.example.SoundTrack;

import java.util.ArrayList;
import java.util.List;

public class RockMusicPlayer {
    List<SoundTrack> rockTrack = new ArrayList<SoundTrack>();

    public RockMusicPlayer() {
        rockTrack.add(new SoundTrack("Metallica", "Nothing Else Matters"));
        rockTrack.add(new SoundTrack("Linkin Park", "In The End"));
    }

    public void PlayingRockMusic() {
        System.out.println("Now is playing rock music: ");
        for (SoundTrack soundTrack : rockTrack) {
            System.out.println("Music Performer: " + soundTrack.getMusicPerformer() + "\n" +
                    "Music Composition: " + soundTrack.getMusicalСomposition());
        }
    }
}