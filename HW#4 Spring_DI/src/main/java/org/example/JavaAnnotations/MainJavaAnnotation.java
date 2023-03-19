package org.example.JavaAnnotations;

import org.example.JavaConfiguration.JavaConfiguration;
import org.example.MusicPlayer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext javaContext = new AnnotationConfigApplicationContext(JavaAnnotations.class);
        MusicPlayer musicPlayer = javaContext.getBean(MusicPlayer.class);
        musicPlayer.playClassicalMusic();
        musicPlayer.playRockMusic();
        javaContext.close();
    }
}