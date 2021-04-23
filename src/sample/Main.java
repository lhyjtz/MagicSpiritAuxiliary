package sample;

import javafx.application.Application;;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;


public class Main extends Application {
    private static String mInitUrl = "https://17roco.qq.com/default.html";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("梦灵辅助-开发者:绿辉zzZ-开发中-版本V0.0.5");
        URL resource = Paths.get("src/sample/sample.fxml").toUri().toURL();
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root, 1050, 770);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}