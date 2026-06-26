package com.example.showmilhao.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import com.example.showmilhao.*;

public class EscolherTemaController {

    @FXML
    private ComboBox<String> comboTema;

    @FXML
    public void initialize(){

        comboTema.getItems().add("Java");
        comboTema.getItems().add("Python");
        comboTema.getItems().add("Power BI");
    }

    @FXML
    private void confirmarTema(){

        String tema = comboTema.getValue();

        if(tema != null){

            Main.temaEscolhido = tema;

            Main.trocarTela("telaJogo.fxml");

        }

    }

}