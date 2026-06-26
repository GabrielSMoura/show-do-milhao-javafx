package com.example.showmilhao.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Platform;
import com.example.showmilhao.audio.AudioManager;
import com.example.showmilhao.Main;

public class TelaGanhouController {

    @FXML
    private Label campoPremioFinal;

    @FXML
    private Label campoChocolates;

    @FXML
    public void initialize(){

        campoChocolates.setText(String.valueOf(Main.chocolatesGanhos));
    }

    @FXML
    private void voltarMenu(){

        Main.trocarTela("telaInicial.fxml");

    }

    @FXML
    private void fecharJogo(){

        AudioManager.getVolume();

        Platform.exit();

    }
}