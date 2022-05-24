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
	
	public static void main(String[] args) throws Exception {
		
		String ip = "192.168.0.149";
        int port = 50001;
        String path = "D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\slice_test2.mp4";
        Socket socket = new Socket(ip, port);
        OutputStream os = socket.getOutputStream();
        FileInputStream fin;
        DataOutputStream dout = new DataOutputStream(os);
        fin = new FileInputStream(new File(path)); //FileInputStream - ���Ͽ��� �Է¹޴� ��Ʈ���� �����մϴ�.

        byte[] buffer = new byte[1024];        //����Ʈ������ �ӽ������ϴ� ���۸� �����մϴ�.
        int len;                               //������ �������� ���̸� �����ϴ� �����Դϴ�.
        int data = 0;                            //����Ƚ��, �뷮�� �����ϴ� �����Դϴ�.

        while ((len = fin.read(buffer)) > 0) {     //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
            data++;                        //�������� ���� �����մϴ�.
        }

        int datas = data;                      //�Ʒ� for���� ���� data�� 0�̵Ǳ⶧���� �ӽ������Ѵ�.

        fin.close();
        fin = new FileInputStream(path);   //FileInputStream�� ����Ǿ����� ���Ӱ� �����մϴ�.
        byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
        os.write(byteArr);                   //������ ����Ƚ���� ������ �����ϰ�,
//            os.writeUTF(path);               //������ �̸��� ������ �����մϴ�.

        len = 0;

        for (; data > 0; data--) {                   //�����͸� �о�� Ƚ����ŭ FileInputStream���� ������ ������ �о�ɴϴ�.
            len = fin.read(buffer);        //FileInputStream�� ���� ���Ͽ��� �Է¹��� �����͸� ���ۿ� �ӽ������ϰ� �� ���̸� �����մϴ�.
            os.write(buffer, 0, len);       //�������� ������ ����(1kbyte��ŭ������, �� ���̸� �����ϴ�.
        }

        System.out.println("�� " + datas + " kbyte");
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
	    
	}
}