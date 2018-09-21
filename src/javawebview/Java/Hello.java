/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javawebview.Java;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
/**
 *
 * @author shibendutta
 */
public class Hello implements HttpHandler {

    public Hello() {
    }
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
       try
       {
            // Localhost to send response to JS file
            String requestMethod = exchange.getRequestMethod();
            if (requestMethod.equalsIgnoreCase("GET")) {
                Headers responseHeaders = exchange.getResponseHeaders();
                responseHeaders.set("Content-Type", "text/plain");
                exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*"); // restrict unknown clients
                exchange.sendResponseHeaders(200, 0);
                OutputStream responseBody = exchange.getResponseBody();

                String s = "Do whatever Java can!";

                responseBody.write(s.getBytes());

                //close localhost
                responseBody.close();
            }
       }
       catch(IOException ex)
       {
           System.out.println(Arrays.toString(ex.getStackTrace()));
       }
    }
    
}
