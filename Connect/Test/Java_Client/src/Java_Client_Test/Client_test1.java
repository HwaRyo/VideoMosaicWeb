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
	    
	    fin = new FileInputStream(new File(path)); //FileInputStream - ���Ͽ��� �Է¹޴� ��Ʈ���� �����մϴ�.
	    byte[] buffer = new byte[1024];        //����Ʈ������ �ӽ������ϴ� ���۸� �����մϴ�.
	    int len;                               //������ �������� ���̸� �����ϴ� �����Դϴ�.
	    int data = 0;                            //����Ƚ��, �뷮�� �����ϴ� �����Դϴ�.

	    while ((len = fin.read(buffer)) > 0) {     //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
	       data++;                        //�������� ���� �����մϴ�.
	    }
	    System.out.println(data);

	    int datas = data;                      //�Ʒ� for���� ���� data�� 0�̵Ǳ⶧���� �ӽ������Ѵ�.

	    fin.close();
	    fin = new FileInputStream(path);   //FileInputStream�� ����Ǿ����� ���Ӱ� �����մϴ�.
	    byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
	    os.write(byteArr);                   //������ ����Ƚ���� ������ �����ϰ�,
//	            os.writeUTF(path);               //������ �̸��� ������ �����մϴ�.

	    len = 0;

	    for (; data > 0; data--) {                   //�����͸� �о�� Ƚ����ŭ FileInputStream���� ������ ������ �о�ɴϴ�.
	       len = fin.read(buffer);        //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
	       os.write(buffer, 0, len);       //�������� ������ ����(1kbyte��ŭ������, �� ���̸� �����ϴ�.
	    }

	    System.out.println("�� " + datas + " kbyte");
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
