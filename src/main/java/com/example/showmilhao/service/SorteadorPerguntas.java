package com.example.showmilhao.service;

import com.example.showmilhao.model.BancoPerguntas;
import com.example.showmilhao.model.Pergunta;

import java.util.List;
import java.util.Random;

public class SorteadorPerguntas {

    private BancoPerguntas banco;

    private Random random = new Random();

    public SorteadorPerguntas(BancoPerguntas banco){
        this.banco = banco;
    }

    public Pergunta sortear(String dificuldade){

        List<Pergunta> lista;

        switch (dificuldade){

            case "medio":
                lista = banco.medio;
                break;

            case "hard":
                lista = banco.hard;
                break;

            case "expert":
                lista = banco.expert;
                break;

            default:
                lista = banco.easy;
        }

        // Segurança: se acabar perguntas daquela dificuldade
        if(lista == null || lista.isEmpty()){
            throw new RuntimeException("Não há mais perguntas disponíveis para dificuldade: " + dificuldade);
        }

        int index = random.nextInt(lista.size());

        Pergunta pergunta = lista.get(index);

        // Remove a pergunta para evitar repetição
        lista.remove(index);

        return pergunta;
    }
}