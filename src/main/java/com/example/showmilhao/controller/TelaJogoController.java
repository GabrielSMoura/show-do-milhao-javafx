package com.example.showmilhao.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import com.example.showmilhao.Main;
import com.example.showmilhao.apresentador.Bordoes;
import com.example.showmilhao.model.BancoPerguntas;
import com.example.showmilhao.model.Pergunta;
import com.example.showmilhao.service.CarregarPerguntas;
import com.example.showmilhao.service.SorteadorPerguntas;
import com.example.showmilhao.bonus.PerguntaChocolate;

import java.util.Random;

public class TelaJogoController {

    @FXML private ImageView apresentador;
    @FXML private ImageView balaoMensagem;
    @FXML private Label campoMensagem;
    @FXML private Label campoMensagemBonus;
    @FXML private ImageView iconePerguntaExtra;

    @FXML private Label campoPergunta;
    @FXML private Label alternativaA;
    @FXML private Label alternativaB;
    @FXML private Label alternativaC;
    @FXML private Label alternativaD;

    @FXML private Label campoValorPergunta;
    @FXML private Label campoPremio;
    @FXML private Label campoExtras;

    @FXML private Label campoUniversitarios;
    @FXML private Label campoPular;

    private Image apresentadorNormal =
            new Image(getClass().getResource("/imagens/leoApresentador.png").toExternalForm());

    private Image apresentadorChocolate =
            new Image(getClass().getResource("/imagens/leoBombom.png").toExternalForm());

    private SorteadorPerguntas sorteador;

    private Pergunta perguntaAtual;

    private boolean perguntaBonus = false;

    private int perguntaNumero = 0;

    private int total = 0;

    private int chocolates = 0;

    private int dicasUniversitarios = 2;

    private int pularPergunta = 2;

    private boolean jogoAcabou = false;

    private Random random = new Random();

    private boolean bonus100 = false;
    private boolean bonus250 = false;
    private boolean bonus500 = false;
    private boolean bonus750 = false;
    private boolean bonus900 = false;

    private int[] premios = {
            10000,20000,30000,40000,50000,
            75000,100000,150000,200000,250000,
            300000,350000,400000,450000,500000,
            600000,700000,850000,900000,1000000
    };

    @FXML
    public void initialize(){

        apresentador.setImage(apresentadorNormal);

        iconePerguntaExtra.setVisible(false);

        balaoMensagem.setVisible(false);

        campoMensagem.setText("");

        campoMensagemBonus.setText("");

        String arquivo = "";

        if(Main.temaEscolhido.equals("Java")){
            arquivo = "/perguntas/perguntas_java.json";
        } else if(Main.temaEscolhido.equals("Python")){
            arquivo = "/perguntas/perguntas_python.json";
        } else if(Main.temaEscolhido.equals("Power BI")){
            arquivo = "/perguntas/perguntas_powerBI.json";
        }

        BancoPerguntas banco = CarregarPerguntas.carregar(arquivo);

        sorteador = new SorteadorPerguntas(banco);

        carregarPergunta();

        campoUniversitarios.setText(String.valueOf(dicasUniversitarios));
        campoPular.setText(String.valueOf(pularPergunta));
    }

    private void digitarTexto(Label label, String texto){

        label.setText("");

        Timeline timeline = new Timeline();

        for(int i = 0; i < texto.length(); i++){

            final int index = i;

            KeyFrame keyFrame = new KeyFrame(
                    Duration.millis(35 * i),
                    e -> label.setText(texto.substring(0,index+1))
            );

            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }

    private void professorFala(){

        if(perguntaBonus) return;

        balaoMensagem.setVisible(true);

        campoMensagemBonus.setText("");

        digitarTexto(campoMensagem, Bordoes.gerar());
    }

    private void verificarPerguntaBonus(){

        if(total == 100000 && !bonus100){ iniciarBonus(); bonus100 = true; }
        else if(total == 250000 && !bonus250){ iniciarBonus(); bonus250 = true; }
        else if(total == 500000 && !bonus500){ iniciarBonus(); bonus500 = true; }
        else if(total == 750000 && !bonus750){ iniciarBonus(); bonus750 = true; }
        else if(total == 950000 && !bonus900){ iniciarBonus(); bonus900 = true; }

    }

    private void iniciarBonus(){

        perguntaBonus = true;

        iconePerguntaExtra.setVisible(true);

        apresentador.setImage(apresentadorChocolate);

        balaoMensagem.setVisible(true);

        digitarTexto(campoMensagem,"Vale 1 chocolate!");

        int valorPergunta = premios[perguntaNumero];

        String dificuldade = Main.definirDificuldade(valorPergunta);

        perguntaAtual = PerguntaChocolate.executar(sorteador,dificuldade);

        campoPergunta.setText(perguntaAtual.perguntas);

        alternativaA.setText(perguntaAtual.opcoes.A);
        alternativaB.setText(perguntaAtual.opcoes.B);
        alternativaC.setText(perguntaAtual.opcoes.C);
        alternativaD.setText(perguntaAtual.opcoes.D);
    }

    private void carregarPergunta(){

        int valorPergunta = premios[perguntaNumero];

        String dificuldade = Main.definirDificuldade(valorPergunta);

        perguntaAtual = sorteador.sortear(dificuldade);

        campoPergunta.setText(perguntaAtual.perguntas);

        alternativaA.setText(perguntaAtual.opcoes.A);
        alternativaB.setText(perguntaAtual.opcoes.B);
        alternativaC.setText(perguntaAtual.opcoes.C);
        alternativaD.setText(perguntaAtual.opcoes.D);

        campoValorPergunta.setText(String.valueOf(valorPergunta - total));
        campoPremio.setText(String.valueOf(total));
        campoExtras.setText(String.valueOf(chocolates));

        professorFala();
    }

    private void verificarResposta(String resposta){

        if(jogoAcabou) return;

        if(perguntaBonus){

            iconePerguntaExtra.setVisible(false);

            apresentador.setImage(apresentadorNormal);

            balaoMensagem.setVisible(false);

            if(resposta.equals(perguntaAtual.resposta)){

                chocolates++;

                campoExtras.setText(String.valueOf(chocolates));

                digitarTexto(campoMensagemBonus,"");

            }else{

                digitarTexto(campoMensagemBonus,"Errou a pergunta extra!");
            }

            perguntaBonus = false;

            carregarPergunta();

            return;
        }

        if(resposta.equals(perguntaAtual.resposta)){

            total = premios[perguntaNumero];

            perguntaNumero++;

            verificarPerguntaBonus();

            if(perguntaBonus) return;

            if(perguntaNumero >= premios.length){

                jogoAcabou = true;

                Main.premioFinal = total;

                Main.chocolatesGanhos = chocolates;

                Main.trocarTela("telaGanhou.fxml");

                return;
            }

            carregarPergunta();

        }else{

            jogoAcabou = true;

            Main.premioFinal = total;

            Main.chocolatesGanhos = chocolates;

            Main.trocarTela("telaPerdeu.fxml");
        }
    }

    @FXML private void clicarA(){ verificarResposta("A"); }
    @FXML private void clicarB(){ verificarResposta("B"); }
    @FXML private void clicarC(){ verificarResposta("C"); }
    @FXML private void clicarD(){ verificarResposta("D"); }

    @FXML
    private void fecharJogo(){
        Platform.exit();
    }

    @FXML
    private void usarUniversitarios(){

        if(dicasUniversitarios == 0){

            digitarTexto(campoMensagem,"Sem universitários!");

            return;
        }

        dicasUniversitarios--;

        campoUniversitarios.setText(String.valueOf(dicasUniversitarios));

        try{

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/view/telaUniversitarios.fxml")
            );

            Parent root = loader.load();

            TelaUniversitariosController controller = loader.getController();

            controller.receberPergunta(perguntaAtual);

            Main.telaJogoSalva = campoPergunta.getScene().getRoot();

            Main.stage.getScene().setRoot(root);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private void pularPergunta(){

        if(pularPergunta == 0){

            digitarTexto(campoMensagem,"Não pode pular!");

            return;
        }

        pularPergunta--;

        campoPular.setText(String.valueOf(pularPergunta));

        carregarPergunta();
    }
}