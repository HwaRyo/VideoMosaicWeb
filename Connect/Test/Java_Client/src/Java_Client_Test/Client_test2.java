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
	    
//	    fin = new FileInputStream(new File(path)); //FileInputStream - ���Ͽ��� �Է¹޴� ��Ʈ���� �����մϴ�.
	    byte[] buffer = new byte[1024];        //����Ʈ������ �ӽ������ϴ� ���۸� �����մϴ�.
	    int len;                               //������ �������� ���̸� �����ϴ� �����Դϴ�.
	    int data = 0;                            //����Ƚ��, �뷮�� �����ϴ� �����Դϴ�.
	    System.out.println(data);

//	    for (int i = a.length/1024;  (i-data)> 0; data++) {     //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
//	    	data++;                        //�������� ���� �����մϴ�.
//	    }

	    int datas = data;                      //�Ʒ� for���� ���� data�� 0�̵Ǳ⶧���� �ӽ������Ѵ�.

//	    fin.close();
//	    fin = new FileInputStream(path);   //FileInputStream�� ����Ǿ����� ���Ӱ� �����մϴ�.
	    byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
	    os.write(byteArr);                   //������ ����Ƚ���� ������ �����ϰ�,
//	            os.writeUTF(path);               //������ �̸��� ������ �����մϴ�.

	    len = 0;

	    for (; data > 0; data--) {                   //�����͸� �о�� Ƚ����ŭ FileInputStream���� ������ ������ �о�ɴϴ�.
//	       len = fin.read(buffer);        //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
	       os.write(buffer, 0, len);       //�������� ������ ����(1kbyte��ŭ������, �� ���̸� �����ϴ�.
	    }

	    System.out.println("�� " + datas + " kbyte");
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