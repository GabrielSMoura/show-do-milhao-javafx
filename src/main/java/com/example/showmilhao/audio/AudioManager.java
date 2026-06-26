package com.example.showmilhao.audio;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

    private static MediaPlayer musicaFundo;

    private static double volume = 0.5;

    public static void tocarMusicaFundo() {

        try {

            String caminho = AudioManager.class
                    .getResource("/audio/theme.mp3")
                    .toExternalForm();

            Media media = new Media(caminho);

            musicaFundo = new MediaPlayer(media);

            musicaFundo.setCycleCount(MediaPlayer.INDEFINITE);

            musicaFundo.setVolume(volume);

            musicaFundo.play();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setVolume(double novoVolume) {

        volume = novoVolume;

        if (musicaFundo != null) {

            musicaFundo.setVolume(volume);

        }

    }

    public static double getVolume() {

        return volume;

    }
}