/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebview.Java;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.concurrent.Executors;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author shibendutta
 */
class MyBrowser extends Region {
    
    HBox toolbar;
 
    WebView webView = new WebView();
    WebEngine webEngine = webView.getEngine();
    
    public MyBrowser(){
        try{
            InetSocketAddress addr = new InetSocketAddress(8080); // assign the free port number
            HttpServer server = HttpServer.create(addr, 0);
            String JSRoute = "/hello"; // Declare the route string
            //String JSFname = "printHello()"; // Declare function name for JS file
            //String JSId = "helloId";
            server.createContext(JSRoute, (HttpHandler) new Hello());
            server.setExecutor(Executors.newCachedThreadPool());
            server.start();
            System.out.println("listening on port: 8181");

            // Call method to open HTML page
            loadPage();
            } 
            catch(Exception ex){
                System.out.print("Unable to start server " + ex.getMessage());
                System.exit(-1);
            }
    }

    private void loadPage() {
        try{
            // Load html page
            final URL indexUrl = this.getClass().getResource("/javawebview/GUI/index.html");
            webEngine.load(indexUrl.toString());
            getChildren().add(webView);
        }
        catch(Exception ex){
            System.out.print("Unable to load web view " + ex);
            System.exit(-1);
        }
    }
    
}
