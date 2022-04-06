package Java_Client_Test;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client_test1 {
	
	public static void main(String[] args) {
		
		int port = 50001;
		DataOutputStream dos;
		OutputStream os;
		
		try(Socket socket = new Socket("192.168.0.149", port)){
			
//			dos = new DataOutputStream(socket.getOutputStream());
			os = socket.getOutputStream();
			
			while(true) {
				
				Scanner scanner = new Scanner(System.in);
				String command = scanner.nextLine(); //Enter command
				
				os.write(command.getBytes("UTF-8"));
				
//				dos.writeUTF(command);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("Connect lost Exception");
		} catch (IOException e) {
			System.out.println("IO Exception");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
