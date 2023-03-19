package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.ClassicalRockMusicPlayer.ClassicalMusicPlayer;
import org.example.ClassicalRockMusicPlayer.RockMusicPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class MusicPlayer {
    private ClassicalMusicPlayer classicalMusicPlayer;
    private RockMusicPlayer rockMusicPlayer;

    public MusicPlayer(ClassicalMusicPlayer classicalMusicPlayer, RockMusicPlayer rockMusicPlayer) {
        this.classicalMusicPlayer = classicalMusicPlayer;
        this.rockMusicPlayer = rockMusicPlayer;
    }

    public void playClassicalMusic() {
        classicalMusicPlayer.PlayingClassicMusic();
    }

    public void playRockMusic() {
        rockMusicPlayer.PlayingRockMusic();
    }
}