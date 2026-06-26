package com.example.showmilhao.service;

import com.example.showmilhao.model.BancoPerguntas;
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;

public class CarregarPerguntas {

    public static BancoPerguntas carregar(String arquivo){

        try{

            InputStream stream =
                    CarregarPerguntas.class.getResourceAsStream(arquivo);

            if(stream == null){
                System.out.println("Arquivo JSON não encontrado!");
                return null;
            }

            InputStreamReader reader =
                    new InputStreamReader(stream);

            Gson gson = new Gson();

            BancoPerguntas banco =
                    gson.fromJson(reader, BancoPerguntas.class);

            return banco;

        }catch(Exception e){

            e.printStackTrace();
            return null;

        }

    }
}