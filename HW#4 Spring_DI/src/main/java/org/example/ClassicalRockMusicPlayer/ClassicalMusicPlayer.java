package org.example.ClassicalRockMusicPlayer;

import org.example.SoundTrack;

import java.util.ArrayList;
import java.util.List;

public class ClassicalMusicPlayer {
    List<SoundTrack> classicTrack = new ArrayList<SoundTrack>();

    public ClassicalMusicPlayer() {
        classicTrack.add(new SoundTrack("Bach", "Toccata and fugue in D minor"));
        classicTrack.add(new SoundTrack("Carl Orff", "Carmina burana"));
    }

    public void PlayingClassicMusic() {
        System.out.println("Now is playing the classical music: ");
        for (SoundTrack soundTrack : classicTrack) {
            System.out.println("Music Performer: " + soundTrack.getMusicPerformer() + "\n" +
                    "Music Composition: " + soundTrack.getMusicalСomposition());
        }
    }
}