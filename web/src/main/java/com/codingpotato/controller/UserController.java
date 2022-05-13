package com.codingpotato.controller;

import com.codingpotato.exception.ResourceNotFoundException;
import com.codingpotato.model.User;
import com.codingpotato.repository.UserRepository;
import com.codingpotato.security.CurrentUser;
import com.codingpotato.security.TokenProvider;
import com.codingpotato.security.UserPrincipal;
import com.codingpotato.service.WebService;
import com.codingpotato.service.WebServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.env.ConfigTreePropertySource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.*;
import java.net.Socket;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebServiceImpl webService;

    @GetMapping("/profile")
    public Map<String, String> requestSomething(@RequestHeader Map<String, Object> requestHeader) {
        String reqToken = requestHeader.get("authorization").toString().replace("Bearer ", "");
        return webService.getProfile(reqToken);
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        String path = "D:\\Git\\VideoMosaicWeb\\web\\src\\main\\resources\\slice_test2.mp4";

        byte[] fileByte = FileUtils.readFileToByteArray(new File(path));

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode("slice_test2.mp4", "UTF-8") + "\";");
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    @GetMapping("/upload")
    public void upload(HttpServletResponse response) throws Exception {

        String ip = "192.168.0.18";
        int port = 50001;
        String path = "D:\\Git\\VideoMosaicWeb\\web\\src\\main\\resources\\slice_test2.mp4";
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

    }
}
