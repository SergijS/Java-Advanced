package org.example.JavaConfiguration;

import org.example.MusicPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfiguration {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        MusicPlayer musicPlayer = javaContext.getBean(MusicPlayer.class);
        musicPlayer.playClassicalMusic();
        musicPlayer.playRockMusic();
        javaContext.close();
    }
}