package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebViewBuilder;
import javafx.stage.Stage;
import sample.Tool.XMLRead.WildMonsterXMLRead;

public class cs extends Application {
    private String mInitUrl = "https://17roco.qq.com/default.html";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WildMonsterXMLRead wildMonsterXMLRead = new WildMonsterXMLRead();
        wildMonsterXMLRead.WildMonsterReadXML();
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        Region headerLeftSpring = new Region();
 /*       HBox searchBox = HBoxBuilder.create()
                .spacing(0)
                .children(
                        WebViewBuilder.create()
                                .prefWidth(1050)
                                .prefHeight(580)
                                .location(mInitUrl)
                                .build()
                )
                .build();*/
        Scene scene = SceneBuilder.create()
                .width(1050)
                .height(770)
                .root(
                        BorderPaneBuilder.create()
                                .top(
                                        HBoxBuilder.create()
                                                .children(
                                                        WebViewBuilder.create()
                                                                .prefWidth(1050)
                                                                .prefHeight(580)
                                                                .location(mInitUrl)
                                                                .id("app-title")
                                                                .build()
                                                )
                                                .build()
                                )
                                .center(
                                        TabPaneBuilder.create()
                                                .tabs(
                                                        TabBuilder.create()
                                                                .text("Tab A")
                                                                .build(),
                                                        TabBuilder.create()
                                                                .text("Tab B")
                                                                .build(),
                                                        TabBuilder.create()
                                                                .text("Tab C")
                                                                .build()
                                                )
                                                .build()
                                )
                                .bottom(
                                        HBoxBuilder.create()
                                                .id("footer")
                                                .children(
                                                        new Label("Footer Left"),
                                                        new Label("Footer Right")
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();
        HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);
        primaryStage.setTitle("梦灵辅助-开发状态-开发版本V1.0");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}