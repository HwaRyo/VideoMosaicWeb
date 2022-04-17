import socket
import threading
import struct
import pickle
import cv2

def binder(client_socket, addr):
	print('Connected by', addr)
	data_buffer = b""
	data_size = struct.calcsize("L")
	try:
		while True:

		    while len(data_buffer) < data_size:
		        data_buffer += client_socket.recv(4096)

		    packed_data_size = data_buffer[:data_size]
		    data_buffer = data_buffer[data_size:]
		    frame_size = struct.unpack(">L", packed_data_size)[0]
		    
		    while len(data_buffer) < frame_size:
		        data_buffer += client_socket.recv(4096)
		    
		    frame_data = data_buffer[:frame_size]
		    data_buffer = data_buffer[frame_size:]
		    
		    print("Frame size - {} bytes".format(frame_size))
		    
		    frame = pickle.loads(frame_data)
		    frame = cv2.imdecode(frame, cv2.IMREAD_COLOR)
		    
		    print(frame[:10])
		    cv2.imshow('Frame', frame)

	except:
		print("except : " , addr)
	finally:
		client_socket.close()

server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
server_socket.bind(('192.168.0.149', 50001))
server_socket.listen()

try:
	while True:
		client_socket, addr = server_socket.accept()
		th = threading.Thread(target=binder, args = (client_socket,addr))

		th.start()
except:
	print("server")
finally:
	server_socket.close()
	client_socket.close()
	cv2.destroyAllWindows()