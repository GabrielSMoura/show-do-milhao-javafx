package com.example.showmilhao.bonus;

import com.example.showmilhao.model.Pergunta;
import com.example.showmilhao.service.SorteadorPerguntas;

public class PerguntaChocolate {

    public static Pergunta executar(SorteadorPerguntas sorteador, String dificuldade){

        return sorteador.sortear(dificuldade);

    }

}