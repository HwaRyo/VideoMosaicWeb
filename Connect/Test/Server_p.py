import socket
import struct
import pickle
import cv2

ip = socket.gethostbyname(socket.gethostname())
port = 50001

server_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

server_socket.bind((ip, port))
server_socket.listen(10) 


client_socket, address = server_socket.accept()
print('connect ip -', address[0])

data_buffer = b""

data_size = struct.calcsize("L")

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
    
    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

client_socket.close()
server_socket.close()
print('close...')

cv2.destroyAllWindows()