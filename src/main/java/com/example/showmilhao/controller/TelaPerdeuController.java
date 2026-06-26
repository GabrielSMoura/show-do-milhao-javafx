package com.example.showmilhao.controller;

import com.example.showmilhao.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.application.Platform;
import com.example.showmilhao.audio.AudioManager;

public class TelaPerdeuController {

    @FXML
    private Label campoPremioFinal;

    @FXML
    private Label campoChocolates;

    @FXML
    public void initialize(){

        campoPremioFinal.setText(String.valueOf(Main.premioFinal));

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