package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.WebViewBuilder;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class Main extends Application {
    private String mInitUrl = "https://17roco.qq.com/default.html";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("梦灵辅助-开发状态-开发版本V1.0");
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        Region headerLeftSpring = new Region();
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
                                                                .text("首页")
                                                                .content(
                                                                        HBoxBuilder.create()
                                                                                .children(
                                                                                        ButtonBuilder.create().text("button1").build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .closable(false)//选项卡不可关闭
                                                                .build(),
                                                        TabBuilder.create()
                                                                .text("宠物列表")
                                                                .content(
                                                                        HBoxBuilder.create()
                                                                                .children(
                                                                                        ButtonBuilder.create().text("button2").build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .closable(false)
                                                                .build(),
                                                        TabBuilder.create()
                                                                .text("活动列表")
                                                                .content(
                                                                        HBoxBuilder.create()
                                                                                .children(
                                                                                        ButtonBuilder.create().text("button2").build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .closable(false)
                                                                .build(),
                                                        TabBuilder.create()
                                                                .text("活动列表")
                                                                .content(
                                                                        HBoxBuilder.create()
                                                                                .children(
                                                                                        ButtonBuilder.create().text("button4").build()
                                                                                )
                                                                                .build()
                                                                )
                                                                .closable(false)
                                                                .build()
                                                )

                                                .build()

                                )
                                .bottom(
                                        HBoxBuilder.create()
                                                .id("footer")
                                                .children(
                                                        new Label("Footer Left")
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();
        HBox.setHgrow(headerLeftSpring, Priority.ALWAYS);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}