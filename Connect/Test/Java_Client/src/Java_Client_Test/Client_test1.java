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
        fin = new FileInputStream(new File(path)); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.

        byte[] buffer = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.
        int len;                               //전송할 데이터의 길이를 측정하는 변수입니다.
        int data = 0;                            //전송횟수, 용량을 측정하는 변수입니다.

        while ((len = fin.read(buffer)) > 0) {     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            data++;                        //데이터의 양을 측정합니다.
        }

        int datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.

        fin.close();
        fin = new FileInputStream(path);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
        byte[] byteArr = String.valueOf(data).getBytes("UTF-8");
        os.write(byteArr);                   //데이터 전송횟수를 서버에 전송하고,
//            os.writeUTF(path);               //파일의 이름을 서버에 전송합니다.

        len = 0;

        for (; data > 0; data--) {                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
            len = fin.read(buffer);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            os.write(buffer, 0, len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
        }

        System.out.println("약 " + datas + " kbyte");
        
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
	    
	}
}