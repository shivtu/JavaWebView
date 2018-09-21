/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebview.Java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author shibendutta
 */
public class JavaWebView extends Application {

    private Scene scene;
    MyBrowser myBrowser;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Java WebView");
         
        myBrowser = new MyBrowser();
        scene = new Scene(myBrowser, 800, 500);
         
        primaryStage.setScene(scene);
        primaryStage.show();

        // close app on window close
        primaryStage.setOnCloseRequest(winClose->{
            System.exit(0);
        });
    }
    
}
