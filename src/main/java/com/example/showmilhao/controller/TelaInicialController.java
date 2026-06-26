package com.example.showmilhao.controller;

import javafx.fxml.FXML;
import com.example.showmilhao.Main;

public class TelaInicialController {

    @FXML
    private void clicarJogar(){

        Main.trocarTela("escolherTema.fxml");

    }

    @FXML
    private void abrirConfiguracoes(){

        Main.trocarTela("configuracoes.fxml");

    }

    @FXML
    private void abrirCreditos(){

        Main.trocarTela("creditos.fxml");

    }

}