package Java_Client_Test;

<<<<<<< Updated upstream
=======
<<<<<<< HEAD
import java.net.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class Client_test2 {
	
	public static void main(String[] args) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		String ip = "192.168.0.149";
	    int port = 50001;
	    String path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\slice_test2.mp4";
	    
	    VideoCapture vc = new VideoCapture(path);
	    
	    Mat frame = new Mat();
	    
	    if (vc.read(frame)){
            System.out.println("Frame Obtained");
            System.out.println("Captured Frame Width " +
                    frame.width() + " Height " + frame.height());
            Imgcodecs.imwrite("camera.jpg", frame);
            System.out.println("OK");
        }
	    
	    MatOfByte matOfByte = new MatOfByte();
	    Imgcodecs.imencode(".jpg", frame, matOfByte);
	    byte[] byteArray = matOfByte.toArray();
	    
	    BufferedImage bufferedImage = matToBufferedImage(frame);
	    
	    showWindow(bufferedImage);
        vc.release();
	    
	    Socket socket = new Socket(ip, port);
	    OutputStream os = socket.getOutputStream();
	    FileInputStream fin;
	    
//	    fin = new FileInputStream(new File(path)); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.
	    byte[] buffer = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.
	    int len;                               //전송할 데이터의 길이를 측정하는 변수입니다.
	    int data = 0;                            //전송횟수, 용량을 측정하는 변수입니다.
	    System.out.println(data);

//	    for (int i = a.length/1024;  (i-data)> 0; data++) {     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
//	    	data++;                        //데이터의 양을 측정합니다.
//	    }

	    int datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.

//	    fin.close();
//	    fin = new FileInputStream(path);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
	    byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
	    os.write(byteArr);                   //데이터 전송횟수를 서버에 전송하고,
//	            os.writeUTF(path);               //파일의 이름을 서버에 전송합니다.

	    len = 0;

	    for (; data > 0; data--) {                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
//	       len = fin.read(buffer);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
	       os.write(buffer, 0, len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
	    }

	    System.out.println("약 " + datas + " kbyte");
	    Scanner scanner = new Scanner(System.in);
	    int age = scanner.nextInt();
	}
	
	private static BufferedImage matToBufferedImage(Mat frame) {
        int type = 0;
        if (frame.channels() == 1) {
            type = BufferedImage.TYPE_BYTE_GRAY;
        } else if (frame.channels() == 3) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        BufferedImage image = new BufferedImage(frame.width(), frame.height(), type);
        WritableRaster raster = image.getRaster();
        DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
        byte[] data = dataBuffer.getData();
        System.out.println(data);
        frame.get(0, 0, data);

        return image;
    }
	
	private static void showWindow(BufferedImage img) {
        JFrame frame = new JFrame();
        frame.getContentPane().add(new JLabel(new ImageIcon(img)));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(img.getWidth(), img.getHeight() + 30);
        frame.setTitle("Image captured");
        frame.setVisible(true);
    }
}
=======
>>>>>>> Stashed changes
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class Client_test2 {

	public static void main(String[] args) {
		
		String file_path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\pns_color.jpg";
		
		try (Socket client = new Socket()) {
			// 소켓에 접속하기 위한 접속 정보를 선언한다.
			InetSocketAddress ipep = new InetSocketAddress("192.169.0.149", 50001);
			// 소켓 접속!
			client.connect(ipep);
			
			// 소켓이 접속이 완료되면 inputstream과 outputstream을 받는다.
			try (OutputStream sender = client.getOutputStream(); InputStream receiver = client.getInputStream();) {
				
				
				
				
				// 메시지는 for 문을 통해 10번 메시지를 전송한다.
//				for (int i = 0; i < 10; i++) {
					
					// 전송할 메시지를 작성한다.
//					String msg = "java test message - " + i;
					
//					// string을 byte배열 형식으로 변환한다.
					byte[] data;
					
					BufferedImage originalImage = ImageIO.read(new File(file_path));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(originalImage, "jpg", baos);
					baos.flush();
					 
					data = baos.toByteArray();
					System.out.println(Arrays.toString(data));
					baos.close();

					
					// ByteBuffer를 통해 데이터 길이를 byte형식으로 변환한다.
					ByteBuffer b = ByteBuffer.allocate(1024);
					
					// byte포멧은 little 엔디언이다.
					b.order(ByteOrder.LITTLE_ENDIAN);
					b.putInt(data.length);
					
					// 데이터 길이 전송
					sender.write(b.array(), 0, 4);
					// 데이터 전송
					sender.write(data);
					
		//			data = new byte[4];
		//			// 데이터 길이를 받는다.
		//			receiver.read(data, 0, 4);
		//			// ByteBuffer를 통해 little 엔디언 형식으로 데이터 길이를 구한다.
		//			ByteBuffer b = ByteBuffer.wrap(data);
		//			b.order(ByteOrder.LITTLE_ENDIAN);
		//			int length = b.getInt();
		//			// 데이터를 받을 버퍼를 선언한다.
		//			data = new byte[length];
		//			// 데이터를 받는다.
		//			receiver.read(data, 0, length);
		//			// byte형식의 데이터를 string형식으로 변환한다.
		//			msg = new String(data, "UTF-8");
		//			// 콘솔에 출력한다.
		//			System.out.println(msg);
				
//				}
				}
			} catch (Throwable e) {
			e.printStackTrace();
			}

	}

}
<<<<<<< Updated upstream
=======
>>>>>>> SW
>>>>>>> Stashed changes
