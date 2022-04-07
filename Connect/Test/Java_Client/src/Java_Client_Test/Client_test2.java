package Java_Client_Test;

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
