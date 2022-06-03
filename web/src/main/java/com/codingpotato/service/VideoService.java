package com.codingpotato.service;

import com.codingpotato.DTO.BoardDTO;
import com.codingpotato.model.Board;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class VideoService {

    public void uploadVideo(MultipartFile video, String userEmail) throws Exception {


        File file = new File("C:\\Users\\leonilpark\\Documents\\Final_Project\\web\\src\\main\\resources\\"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))+".mp4");
        video.transferTo(file);

        String ip = "192.168.0.2";
        int port = 50001;

        String path2 = "C:\\Users\\leonilpark\\Documents\\Final_Project\\ObjectTracking\\videoData\\slice_test2_1.mp4";
        Socket socket = new Socket(ip, port);
        OutputStream os = socket.getOutputStream();
        FileInputStream fin1;
        FileInputStream fin2;
        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        String msg="";
        fin1 = new FileInputStream(file); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.
        fin2 = new FileInputStream(new File(path2)); //FileInputStream - 파일에서 입력받는 스트림을 개통합니다.
        byte[] buffer = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.


        os.write(userEmail.getBytes("UTF-8"));

        System.out.println("mail send...");

        System.out.println(is.read(buffer));
        System.out.println("learn video send...");


        int len;                               //전송할 데이터의 길이를 측정하는 변수입니다.
        int data = 0;                            //전송횟수, 용량을 측정하는 변수입니다.

        //
        while ((len = fin1.read(buffer)) > 0) {     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            data++;                        //데이터의 양을 측정합니다.
        }

        int datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.

        fin1.close();

        fin1 = new FileInputStream(file);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
        byte[] byteArr = String.valueOf(data).getBytes("UTF-8");

        os.write(byteArr);                   //데이터 전송횟수를 서버에 전송하고,
//            os.writeUTF(path);               //파일의 이름을 서버에 전송합니다.

        len = 0;

        System.out.println(is.read(buffer));
//        a = is.readAllBytes();

        for (; data > 0; data--) {                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
            len = fin1.read(buffer);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            os.write(buffer, 0, len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
        }

        os.flush();

        System.out.println("약 " + datas + " kbyte");

        len = 0;
        data = 0;

        System.out.println(is.read(buffer));
//        a = is.readAllBytes();
        System.out.println("target video send...");

        byte[] buffer2 = new byte[1024];        //바이트단위로 임시저장하는 버퍼를 생성합니다.



        while ((len = fin2.read(buffer2)) > 0) {     //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            data++;                        //데이터의 양을 측정합니다.
        }

        datas = data;                      //아래 for문을 통해 data가 0이되기때문에 임시저장한다.

        fin2.close();
        fin2 = new FileInputStream(path2);   //FileInputStream이 만료되었으니 새롭게 개통합니다.
        byteArr = String.valueOf(data).getBytes();

        os.write(byteArr);                   //데이터 전송횟수를 서버에 전송하고,

        System.out.println(is.read(buffer));


        len = 0;

        for (; data > 0; data--) {                   //데이터를 읽어올 횟수만큼 FileInputStream에서 파일의 내용을 읽어옵니다.
            len = fin2.read(buffer2);        //FileInputStream을 통해 파일에서 입력받은 데이터를 버퍼에 임시저장하고 그 길이를 측정합니다.
            os.write(buffer2, 0, len);       //서버에게 파일의 정보(1kbyte만큼보내고, 그 길이를 보냅니다.
        }

        System.out.println("약 " + datas + " kbyte");

        System.out.println(is.read(buffer));

        socket.close();
        file.delete();
    }
}
