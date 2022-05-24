package Java_Client_Test;

import java.net.*;
import java.nio.ByteBuffer;
import java.awt.Image;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.opencv.core.*;
import org.opencv.videoio.*;
import org.opencv.imgcodecs.Imgcodecs;

public class Client_test1 {
	
	public static void main(String[] args){
		

//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // necessary part of running OpenCV

		String ip = "192.168.0.149";
		int port = 50001;
		String file_path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\pns_color.jpg";
		byte[] bytes = new byte[4096];
		Image image;
		
//		VideoCapture vc = new VideoCapture(file_path);
			
			DataOutputStream dos;
			OutputStream sock_os, file_os;
			
			InputStream is;
			ByteBuffer bb;
			
			try(Socket socket = new Socket("192.168.0.149", port)){

				
				
				sock_os = socket.getOutputStream();
				
				is = new BufferedInputStream(new FileInputStream(file_path));
				
				sock_os.write(is.readAllBytes());
						
//				while(true) {
					
					
					
//					Mat frame = new Mat();
//					MatOfByte bytemat = new MatOfByte();
//					
//					vc.grab();
//					vc.retrieve(frame);
//
//					double[] vec = frame.get(0,0);
//					
//					System.out.println(frame.get(frame_wh, bytes));
//					System.out.println(frame_wh[0]);
//					System.out.println(frame_wh[1]);
//					Rect rect = new Rect(0, 0, mat.rows(), mat.cols());
					
					
//					Rect[] mat_reval = ((MatOfByte) mat).toArray();
					
//					Imgcodecs.imencode(".jpg", mat, bytemat);
//					
//					System.out.println(mat.dump());
//				}
				
			} catch (UnknownHostException e) {
				System.out.println("Connect lost Exception");
			} catch (IOException e) {
				System.out.println("IO Exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
		
}
//public class Client_test1 {
//	
//	public static void main(String[] args){
//		
//		String ip = "192.168.0.149";
//		int port = 50001;
//		String file_path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\slice_test2.mp4";
//		byte[] bytes = new byte[4096];
//		
//		DataOutputStream dos;
//		OutputStream os;
//		InputStream is;
//		
//		try(Socket socket = new Socket(ip,  port)){
//			
//			is = new FileInputStream(new File(file_path));
//			os = socket.getOutputStream();
//			
//			int count = is.read(bytes, 0, 4096);
//			
//			while(count != -1) {
//				
//				os.write(bytes, 0, 4096);
//				count = is.read(bytes, 0, 4096);
//			}
//			
//		} catch (UnknownHostException e) {
//			System.out.println("Connect lost Exception");
//		} catch (IOException e) {
//			System.out.println("IO Exception");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
