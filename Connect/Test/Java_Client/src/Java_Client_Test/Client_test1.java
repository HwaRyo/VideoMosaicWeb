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
	
<<<<<<< HEAD
	public static void main(String[] args) throws Exception {
		
		String ip = "192.168.0.149";
	    int port = 50001;
	    String path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\slice_test2.mp4";
	    Socket socket = new Socket(ip, port);
	    OutputStream os = socket.getOutputStream();
	    FileInputStream fin;
	    
	    fin = new FileInputStream(new File(path)); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.
	    byte[] buffer = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.
	    int len;                               //전송할 데이터의 길이를 측정하는 변수입니다.
	    int data = 0;                            //전송횟수, 용량을 측정하는 변수입니다.

	    while ((len = fin.read(buffer)) > 0) {     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
	       data++;                        //데이터의 양을 측정합니다.
	    }
	    System.out.println(data);

	    int datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.

	    fin.close();
	    fin = new FileInputStream(path);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
	    byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
	    os.write(byteArr);                   //데이터 전송횟수를 서버에 전송하고,
//	            os.writeUTF(path);               //파일의 이름을 서버에 전송합니다.

	    len = 0;

	    for (; data > 0; data--) {                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
	       len = fin.read(buffer);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
	       os.write(buffer, 0, len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
	    }

	    System.out.println("약 " + datas + " kbyte");
	    Scanner scanner = new Scanner(System.in);
	    int age = scanner.nextInt();
	    
	}
}
=======
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
>>>>>>> SW
