package com.example.showmilhao.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import com.example.showmilhao.Main;
import com.example.showmilhao.model.Pergunta;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class TelaUniversitariosController {

    @FXML
    private Label dica1;

    @FXML
    private Label dica2;

    private Random random = new Random();

    public void receberPergunta(Pergunta pergunta){

        // resposta correta
        String correta = pergunta.resposta;

        // lista de erradas
        List<String> erradas = new ArrayList<>();

        if(!correta.equals("A")) erradas.add("A");
        if(!correta.equals("B")) erradas.add("B");
        if(!correta.equals("C")) erradas.add("C");
        if(!correta.equals("D")) erradas.add("D");

        // escolhe uma errada aleatória
        String erradaAleatoria = erradas.get(random.nextInt(erradas.size()));

        String textoCorreto = pegarTextoAlternativa(pergunta, correta);
        String textoErrado = pegarTextoAlternativa(pergunta, erradaAleatoria);

        // embaralha as dicas
        boolean inverter = random.nextBoolean();

        if(inverter){

            dica1.setText(textoCorreto);
            dica2.setText(textoErrado);

        }else{

            dica1.setText(textoErrado);
            dica2.setText(textoCorreto);

        }
    }

    private String pegarTextoAlternativa(Pergunta pergunta, String letra){

        switch(letra){

            case "A":
                return pergunta.opcoes.A;

            case "B":
                return pergunta.opcoes.B;

            case "C":
                return pergunta.opcoes.C;

            case "D":
                return pergunta.opcoes.D;
        }

        return "";
    }

    @FXML
    private void voltarJogo(){

        Main.voltarJogo();

    }
}