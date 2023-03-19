package org.example.JavaConfiguration;

import org.example.ClassicalRockMusicPlayer.ClassicalMusicPlayer;
import org.example.ClassicalRockMusicPlayer.RockMusicPlayer;
import org.example.MusicPlayer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfiguration {
    @Bean
    public ClassicalMusicPlayer classicalMusicPlayer() {
        return new ClassicalMusicPlayer();
    }

    @Bean
    public RockMusicPlayer rockMusicPlayer() {
        return new RockMusicPlayer();
    }

    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(classicalMusicPlayer(), rockMusicPlayer());
    }
}