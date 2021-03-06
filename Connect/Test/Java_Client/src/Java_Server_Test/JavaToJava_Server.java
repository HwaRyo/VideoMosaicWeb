package Java_Server_Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaToJava_Server {
	public static final int DEFAULT_BUFFER_SIZE = 10000;
    public static void main(String[] args) {
        int port =  50001;
        String filename = "outPut.jpg";
         
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("This server is listening... (Port: " + port  + ")");
            Socket socket = server.accept();
            InetSocketAddress isaClient = (InetSocketAddress) socket.getRemoteSocketAddress();
             
            System.out.println("A client("+isaClient.getAddress().getHostAddress()+
                    " is connected. (Port: " +isaClient.getPort() + ")");
             
            FileOutputStream fos = new FileOutputStream(filename);
            InputStream is = socket.getInputStream();
            
            double startTime = System.currentTimeMillis(); 
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int readBytes;
            
            while ((readBytes = is.read(buffer)) != -1) {
                fos.write(buffer, 0, readBytes);
            }
            
            double endTime = System.currentTimeMillis();
            double diffTime = (endTime - startTime)/ 1000;;
 
            System.out.println("time: " + diffTime+ " second(s)");
             
            is.close();
            fos.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
