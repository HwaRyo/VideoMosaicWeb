package Java_Client_Test;

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