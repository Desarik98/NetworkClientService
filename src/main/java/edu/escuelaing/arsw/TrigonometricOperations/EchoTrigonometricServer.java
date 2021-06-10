package edu.escuelaing.arsw.TrigonometricOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoTrigonometricServer {
    public static void main(String[] args) throws IOException {
        String operation = null;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35002);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35001.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String outputLine = null;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje:"+inputLine);
            if(inputLine.contains("fun")){
                switch (inputLine) {
                    case "fun:sin":
                        operation = "sin";
                        break;
                    case "fun:tan":
                        operation = "tan";
                        break;
                    default:
                        operation = "cos";
                        break;
                }
                outputLine = operation;
            }
            else{
                outputLine = operations(operation,inputLine);
            }
            out.println(outputLine);
            assert outputLine != null;
            if (outputLine.equals("Respuestas: Bye.")) break;
        } out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }

    public static String operations(String op,String input){
        Double res = null;
        double pi = 1;
        String num = "";
        String den = "";
        System.out.println(op);
        if (input.contains("π")){
            pi = Math.PI;
            input = input.substring(0,input.indexOf("π"))+input.substring(input.indexOf("π")+1);
        }
        if(input.contains("/")){
            num = input.substring(0,input.indexOf("/"));
            den = input.substring(input.indexOf("/")+1);
            if(num.length() == 0){
                num = "1";
            }
            if(den.length() == 0){
                den = "1";
            }
        }
        else {
            den = "1";
            if (input.length()==0){
                num = "1";
            }else {
                num = input;
            }
        }
        double r = Integer.parseInt(num)*pi/Integer.parseInt(den);
        switch (op){
            case "sin":
                System.out.println("Seno");
                res = Math.sin(r);
                break;
            case "cos":
                System.out.println("Coseno");
                res = Math.cos(r);
                break;
            case "tan":
                System.out.println("Tangente");
                res = Math.tan(r);
                break;
        }
        assert res != null;
        return res.toString();
    }
}
