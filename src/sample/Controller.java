package sample;
/**
 * Sample Skeleton for 'sample.fxml' Controller Class
 */

import java.net.URL;
import java.util.ResourceBundle;


import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import sample.Tool.Untils.HTTPUtils;

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

    /**
     * public void printHelloWorld1(ActionEvent actionEvent) throws ExecutionException, InterruptedException {
     * ExecutorService executor = Executors.newCachedThreadPool();
     * Future<String> future = (Future<String>) executor.submit(task);
     * executor.shutdown();
     * System.out.println(future.get());
     * }
     */
    /**
     * @param actionEvent 启动刷级线程，使用restart(),使用start()会重新刷级会出现反射错误，具体原因不明
     *                    Starting a swipe thread using restart() and starting () will cause a reflection error for unknown reasons
     * @author LHYJTZ
     * @data 2021/5/18 11:17
     */
    public void printHelloWorld1(ActionEvent actionEvent) {
        service.restart();
    }

    /**
     * @param actionEvent 使用 cancel()停止线程，无法使用interrupt(),因为此处调用需要静态，而interrupt()是非静态方法、
     *                    Use cancel() to stop the thread. Interrupt () cannot be used because the call needs to be static and interrupt() is a non-static method
     * @author LHYJTZ
     * @data 2021/5/18 11:19
     */
    public void printHelloWorld2(ActionEvent actionEvent) {
        service.cancel();
        Platform.runLater(() -> bottom.setText("停止刷级"));
    }
    // class Task implements Callable<String> {// 实现了Runnable接口，jdk就知道这个类是一个线程

    //      @Override
    //    public String call() throws Exception {
    //        String cs = null;
    //      for (int i = 0; i < 10; i++) {
    //           cs = HTTPUtils.WildMonsterXMLRead();
    //      }
    //       System.out.println(cs);
    //     Thread.currentThread().sleep(1250);
    //       return cs;
    //    }

    /**
     * @author LHYJTZ
     * @data 2021/5/18 11:35
     * @param actionEvent 创建Service线程，里面封装了Task线程，使用Platform.runLater影响主线程实现更新Label
     * Create a Service thread that wraps the Task thread and use platform. runLater to influence the main thread implementation to update the Label
     * @return null
     */
    Service<Integer> service = new Service<Integer>() {
        @Override
        protected Task<Integer> createTask() {
            return new Task<Integer>() {
                @Override
                protected Integer call() throws Exception {
                    for (int i = 0; i < 10; i++) {
                        String cs = HTTPUtils.WildMonsterXMLRead();
                        System.out.println(cs);
                        Thread.sleep(1250);
                        Platform.runLater(() -> bottom.setText("cs"));
                    }
                    return null;
                }
            };
        }
    };
}



