package edu.escuelaing.arsw.URLReaderScanner;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Ejercicio Realizado en clase
 *
 */
public class URLScanner
{
    public static void main( String[] args ) throws MalformedURLException {
        URL personalSite = new URL("http://ldbn.escuelaing.edu.co:80/publicaciones.pdf=val=45&r=78#publicaciones");
        System.out.println( "Protocolo: "+ personalSite.getProtocol() );
        System.out.println( "Authority: "+ personalSite.getAuthority() );
        System.out.println( "Host: "+ personalSite.getHost() );
        System.out.println( "Port: "+ personalSite.getPort() );
        System.out.println( "Path: "+ personalSite.getPath() );
        System.out.println( "Query: "+ personalSite.getQuery() );
        System.out.println( "File: "+ personalSite.getFile() );
        System.out.println( "Ref: "+ personalSite.getRef() );

    }
}
