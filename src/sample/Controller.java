package sample;
/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML// fx:id="bottom",控制底部持续刷新的控件id
    private Label bottom;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="webView"
    private WebView webView; // Value injected by FXMLLoader

    @FXML // fx:id="Tab1"
    private Tab Tab1; // Value injected by FXMLLoader

    @FXML
    // This method is called by the FXMLLoader when initialization is complete
    public void initialize() {
        final WebEngine webengine = webView.getEngine();
        webengine.load("https://17roco.qq.com/default.html");
        String cs = "首页";
        Tab1.setText(cs);
        bottom.setText("梦灵辅助,开发者:绿辉zzZ,开发状态,版本V0.0.5");
    }

    public void printHelloWorld(ActionEvent actionEvent) {
        System.out.println("Cd");
    }

}



