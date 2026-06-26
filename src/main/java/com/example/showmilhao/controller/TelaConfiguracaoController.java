package com.example.showmilhao.controller;

import com.example.showmilhao.Main;
import com.example.showmilhao.audio.AudioManager;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class TelaConfiguracaoController {

    @FXML
    private Slider sliderVolume;

    @FXML
    public void initialize() {

        sliderVolume.setValue(AudioManager.getVolume() * 100);

        sliderVolume.valueProperty().addListener((obs, oldVal, newVal) -> {

            double volume = newVal.doubleValue() / 100.0;

            AudioManager.setVolume(volume);

        });
    }

    @FXML
    public void voltarMenu(MouseEvent event) {

        Main.trocarTela("telaInicial.fxml");

    }

}