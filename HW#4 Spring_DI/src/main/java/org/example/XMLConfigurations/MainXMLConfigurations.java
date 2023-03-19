package org.example.XMLConfigurations;

import org.example.MusicPlayer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXMLConfigurations {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext javaContext = new ClassPathXmlApplicationContext("XMLConfigurations.xml");
        MusicPlayer musicPlayer = javaContext.getBean(MusicPlayer.class);
        musicPlayer.playClassicalMusic();
        musicPlayer.playRockMusic();
    }
}