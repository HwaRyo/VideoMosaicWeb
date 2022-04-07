package Java_Client_Test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Client_test3 {

	public static void main(String[] args) {
		// ������ �����Ѵ�.
		try (Socket client = new Socket()) {
			
			// ���Ͽ� �����ϱ� ���� ���� ������ �����Ѵ�.
			InetSocketAddress ipep = new InetSocketAddress("127.0.0.1", 9999);
			
			// ���� ����!
			client.connect(ipep);
			
			// ������ ������ �Ϸ�Ǹ� inputstream�� outputstream�� �޴´�.
			try (OutputStream sender = client.getOutputStream(); InputStream receiver = client.getInputStream();) {
				
				// �޽����� for ���� ���� 10�� �޽����� �����Ѵ�.
				for (int i = 0; i < 10; i++) {
					
					// ������ �޽����� �ۼ��Ѵ�.
					String msg = "java test message - " + i;
					
					// string�� byte�迭 �������� ��ȯ�Ѵ�.
					byte[] data = msg.getBytes();
					
					// ByteBuffer�� ���� ������ ���̸� byte�������� ��ȯ�Ѵ�.
					ByteBuffer b = ByteBuffer.allocate(4);
					
					// byte������ little ������̴�.
					b.order(ByteOrder.LITTLE_ENDIAN);
					b.putInt(data.length);
					
					// ������ ���� ����
					sender.write(b.array(), 0, 4);
					
					// ������ ����
					sender.write(data);
					data = new byte[4];
					
					// ������ ���̸� �޴´�.
					receiver.read(data, 0, 4);
					
					// ByteBuffer�� ���� little ����� �������� ������ ���̸� ���Ѵ�.
					b = ByteBuffer.wrap(data);
					b.order(ByteOrder.LITTLE_ENDIAN);
					int length = b.getInt();
					
					// �����͸� ���� ���۸� �����Ѵ�.
					data = new byte[length];
					
					// �����͸� �޴´�.
					receiver.read(data, 0, length);
					
					// byte������ �����͸� string�������� ��ȯ�Ѵ�.
					msg = new String(data, "UTF-8");
					
					// �ֿܼ� ����Ѵ�.
					System.out.println(msg);
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

}
