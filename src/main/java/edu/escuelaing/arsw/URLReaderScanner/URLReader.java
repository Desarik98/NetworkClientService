package edu.escuelaing.arsw.URLReaderScanner;

import java.io.*;
import java.net.*;

/**
 * Ejercicio realizado en clase
 */
public class URLReader {
    public static void main(String[] args) throws Exception {
        URL google = new URL("http://www.google.com/");
        FileWriter file = null;
        PrintWriter pw = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            file = new FileWriter("/home/daniel/Escritorio/ARSW/NetworkClientService/src/main/java/edu/escuelaing/arsw/URLReaderScanner/google.html");
            pw = new PrintWriter(file);
            while ((inputLine = reader.readLine()) != null) {
                pw.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        } finally {
            try {
                if(null != file){
                    file.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}