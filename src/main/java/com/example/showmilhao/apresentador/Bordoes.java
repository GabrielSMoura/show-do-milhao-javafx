package com.example.showmilhao.apresentador;

import java.util.Random;

public class Bordoes {

    private static final String[] bordoes = {

            "Tem certeza disso?",
            "Eu expliquei na aula!",
            "Java não perdoa!",
            "Essa é fácil hein!",
            "Olha o bug aparecendo!",
            "Respira e pensa!",
            "Bug detectado na resposta!",
            "Compilou? Então confia!",
            "Respira, pensa e responde!",
            "Java está te observando!",
            "Cuidado com o bug!",
            "Isso cai na prova!",
            "Olha a pegadinha!",
            "Pensa como programador!",
            "Não esquece das chaves!",
            "Tem cara de bug!",
            "Teste seu raciocínio!",
            "Hora do debug!",
            "Será que compila?",
            "Confia no algoritmo!",
            "Código não mente!",
            "Isso quebra o código!",
            "Olha o erro!",
            "Java não esquece!",
            "Pensou na lógica?",
            "Resposta ou exceção?",
            "Tá com bug!",
            "Cuidado com isso!",
            "Quase deu erro!",
            "Java não perdoa!",
            "Essa é clássica!",
            "Pensa antes de clicar!",
            "Bug ou resposta?",
            "Olha a lógica!",
            "Respira, quase lá!",
            "Resposta valendo milhão!"
    };

    private static final Random random = new Random();

    public static String gerar(){

        int index = random.nextInt(bordoes.length);

        return bordoes[index];
    }

}