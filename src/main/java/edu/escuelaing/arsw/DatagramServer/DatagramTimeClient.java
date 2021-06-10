package edu.escuelaing.arsw.DatagramServer;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatagramTimeClient {
    public static String lastDate;
    public static void main(String[] args) {
        byte[] sendBuf = new byte[256];
        Thread t = new Thread(){
            @Override
            public void run() {
                while(true) {
                    try {
                        DatagramSocket socket = new DatagramSocket();
                        socket.setSoTimeout(5000);
                        byte[] buf = new byte[256];
                        InetAddress address = InetAddress.getByName("127.0.0.1");
                        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 4445);
                        socket.send(packet);
                        packet = new DatagramPacket(buf, buf.length);
                        try {
                            socket.receive(packet);
                            String received = new String(packet.getData(), 0, packet.getLength());
                            lastDate = received;
                            System.out.println("Date: " + received);
                        }catch (SocketTimeoutException e){
                            System.out.println("Date: " + lastDate);
                        }
                        Thread.sleep(5000);
                    } catch (IOException | InterruptedException ex) {
                        Logger.getLogger(DatagramTimeClient.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("Date");
                    }
                }
            }
        };
        t.start();
    }
}
