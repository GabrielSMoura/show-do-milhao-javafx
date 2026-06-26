package com.example.showmilhao;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import com.example.showmilhao.audio.AudioManager;

public class Main extends Application {

    public static Stage stage;

    public static String temaEscolhido;

    public static int premioFinal = 0;

    public static int chocolatesGanhos = 0;

    public static Parent telaJogoSalva;

    @Override
    public void start(Stage stage) throws Exception {

        Main.stage = stage;

        Parent root = FXMLLoader.load(
                Main.class.getResource("/view/telaInicial.fxml")
        );

        Scene scene = new Scene(root);

        stage.setTitle("Show do Milhão");
        stage.setScene(scene);

        AudioManager.tocarMusicaFundo();
        AudioManager.setVolume(0.3);

        stage.show();
    }


    public static void trocarTela(String fxml) {

        try {

            Parent root = FXMLLoader.load(
                    Main.class.getResource("/view/" + fxml)
            );

            stage.getScene().setRoot(root);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void voltarJogo() {

        stage.getScene().setRoot(telaJogoSalva);

    }

    public static String definirDificuldade(int dinheiro) {

        if (dinheiro >= 850000) return "expert";
        if (dinheiro >= 600000) return "hard";
        if (dinheiro >= 250000) return "medio";

        return "easy";
    }

    public static void main(String[] args) {
        launch(args);
    }
}