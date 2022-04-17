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
			// ���Ͽ� �����ϱ� ���� ���� ������ �����Ѵ�.
			InetSocketAddress ipep = new InetSocketAddress("192.169.0.149", 50001);
			// ���� ����!
			client.connect(ipep);
			
			// ������ ������ �Ϸ�Ǹ� inputstream�� outputstream�� �޴´�.
			try (OutputStream sender = client.getOutputStream(); InputStream receiver = client.getInputStream();) {
				
				
				
				
				// �޽����� for ���� ���� 10�� �޽����� �����Ѵ�.
//				for (int i = 0; i < 10; i++) {
					
					// ������ �޽����� �ۼ��Ѵ�.
//					String msg = "java test message - " + i;
					
//					// string�� byte�迭 �������� ��ȯ�Ѵ�.
					byte[] data;
					
					BufferedImage originalImage = ImageIO.read(new File(file_path));
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ImageIO.write(originalImage, "jpg", baos);
					baos.flush();
					 
					data = baos.toByteArray();
					System.out.println(Arrays.toString(data));
					baos.close();

					
					// ByteBuffer�� ���� ������ ���̸� byte�������� ��ȯ�Ѵ�.
					ByteBuffer b = ByteBuffer.allocate(1024);
					
					// byte������ little ������̴�.
					b.order(ByteOrder.LITTLE_ENDIAN);
					b.putInt(data.length);
					
					// ������ ���� ����
					sender.write(b.array(), 0, 4);
					// ������ ����
					sender.write(data);
					
		//			data = new byte[4];
		//			// ������ ���̸� �޴´�.
		//			receiver.read(data, 0, 4);
		//			// ByteBuffer�� ���� little ����� �������� ������ ���̸� ���Ѵ�.
		//			ByteBuffer b = ByteBuffer.wrap(data);
		//			b.order(ByteOrder.LITTLE_ENDIAN);
		//			int length = b.getInt();
		//			// �����͸� ���� ���۸� �����Ѵ�.
		//			data = new byte[length];
		//			// �����͸� �޴´�.
		//			receiver.read(data, 0, length);
		//			// byte������ �����͸� string�������� ��ȯ�Ѵ�.
		//			msg = new String(data, "UTF-8");
		//			// �ֿܼ� ����Ѵ�.
		//			System.out.println(msg);
				
//				}
				}
			} catch (Throwable e) {
			e.printStackTrace();
			}

	}

}
