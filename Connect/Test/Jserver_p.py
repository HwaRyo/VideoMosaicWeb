import socket, threading

def binder(client_socket, addr):
	print('Connected by', addr)
	try:
		while True:

			data = client_socket.recv(4)

			# 최초 4바이트는 전송할 데이터의 크기이다. 그 크기는 little big 엔디언으로 byte에서 int형식으로 변환한다.
			# C#의 BitConverter는 big엔디언으로 처리된다.
			length = int.from_bytes(data, "little")

			# 다시 데이터를 수신한다.
			data = client_socket.recv(length)

			# 수신된 데이터를 str형식으로 decode한다.
			msg = data.decode()

			# 수신된 메시지를 콘솔에 출력한다.
			print('Received from', addr, msg)

			# 수신된 메시지 앞에 「echo:」 라는 메시지를 붙힌다.
			msg = "echo : " + msg

			# 바이너리(byte)형식으로 변환한다.
			data = msg.encode()

			# 바이너리의 데이터 사이즈를 구한다.
			length = len(data)

			# 데이터 사이즈를 little 엔디언 형식으로 byte로 변환한 다음 전송한다.
			client_socket.sendall(length.to_bytes(4, byteorder='little'))

			# 데이터를 클라이언트로 전송한다.
			client_socket.sendall(data)
	except:
		# 접속이 끊기면 except가 발생한다.
		print("except : " , addr)
	finally:
		# 접속이 끊기면 socket 리소스를 닫는다.
		client_socket.close()

# 소켓을 만든다.
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# 소켓 레벨과 데이터 형태를 설정한다.
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

# 서버는 복수 ip를 사용하는 pc의 경우는 ip를 지정하고 그렇지 않으면 None이 아닌 ''로 설정한다.
# 포트는 pc내에서 비어있는 포트를 사용한다. cmd에서 netstat -an | find "LISTEN"으로 확인할 수 있다.
server_socket.bind(('192.168.0.149', 50001))

# server 설정이 완료되면 listen를 시작한다.
server_socket.listen()

try:
	# 서버는 여러 클라이언트를 상대하기 때문에 무한 루프를 사용한다.
	while True:
		# client로 접속이 발생하면 accept가 발생한다.
		# 그럼 client 소켓과 addr(주소)를 튜플로 받는다.
		client_socket, addr = server_socket.accept()
		th = threading.Thread(target=binder, args = (client_socket,addr))

		# 쓰레드를 이용해서 client 접속 대기를 만들고 다시 accept로 넘어가서 다른 client를 대기한다.
		th.start()
except:
	print("server")
finally:
	# 에러가 발생하면 서버 소켓을 닫는다.
	server_socket.close()