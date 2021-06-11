package edu.escuelaing.arsw.URLReaderScanner;

import java.io.*;
import java.net.*;

/**
 * Ejercicio realizado en clase
 */
public class URLReader {
    public static void main(String[] args) throws Exception {

        URL google = new URL(args[0]);
        FileWriter file = null;
        PrintWriter pw = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(google.openStream()))) {
            String inputLine = null;
            file = new FileWriter("resultado.html");
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