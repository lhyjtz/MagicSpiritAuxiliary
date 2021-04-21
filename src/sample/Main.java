package sample;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sample.Tool.XMLRead.WildMonsterXMLRead;


/**
 * @param
 * @author LHYJTZ
 * @data 2021/4/20 14:25
 * @return null
 */
public class Main extends Application {
    private String mInitUrl = "https://17roco.qq.com/default.html";

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("梦灵辅助-开发状态-开发版本V1.0");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        try {
            AnchorPane root = new AnchorPane();
            Scene scene = new Scene(root, 1050, 750);
            WebView mWebView = new WebView();
            mWebView.setPrefWidth(1047d);
            mWebView.setPrefHeight(580d);
            ScrollPane scrollPane = new ScrollPane(mWebView);
            scrollPane.setPrefSize(scene.getWidth(), scene.getHeight());
            root.getChildren().add(scrollPane);
            mWebView.autosize();
            mWebView.getEngine().load(mInitUrl);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WildMonsterXMLRead wildMonsterXMLRead = new WildMonsterXMLRead();
        wildMonsterXMLRead.WildMonsterReadXML();
    }

    public static void main(String[] args) {
        launch(args);
    }
}