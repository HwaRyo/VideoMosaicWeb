import socket
import struct
import pickle
import cv2

ip = socket.gethostbyname(socket.gethostname())
port = 50001

server_socket = socket.socket(socket.AF_INET,socket.SOCK_STREAM)

# 소켓 주소 정보 할당
server_socket.bind((ip, port))

# 연결 리스닝(동시 접속) 수 설정
server_socket.listen(10) 


# 연결 수락(클라이언트 (소켓, 주소 정보) 반환)
client_socket, address = server_socket.accept()
print('connect ip -', address[0])

# 수신한 데이터를 넣을 버퍼(바이트 객체)
data_buffer = b""

# calcsize : 데이터의 크기(byte)
# - L : 부호없는 긴 정수(unsigned long) 4 bytes
data_size = struct.calcsize("L")

while True:
    # 설정한 데이터의 크기보다 버퍼에 저장된 데이터의 크기가 작은 경우
    while len(data_buffer) < data_size:
        # 데이터 수신
        data_buffer += client_socket.recv(4096)

    # 버퍼의 저장된 데이터 분할
    packed_data_size = data_buffer[:data_size]
    data_buffer = data_buffer[data_size:] 
    
    # struct.unpack : 변환된 바이트 객체를 원래의 데이터로 변환
    # - > : 빅 엔디안(big endian)
    #   - 엔디안(endian) : 컴퓨터의 메모리와 같은 1차원의 공간에 여러 개의 연속된 대상을 배열하는 방법
    #   - 빅 엔디안(big endian) : 최상위 바이트부터 차례대로 저장
    # - L : 부호없는 긴 정수(unsigned long) 4 bytes 
    frame_size = struct.unpack(">L", packed_data_size)[0]
    
    # 프레임 데이터의 크기보다 버퍼에 저장된 데이터의 크기가 작은 경우
    while len(data_buffer) < frame_size:
        # 데이터 수신
        data_buffer += client_socket.recv(4096)
    
    # 프레임 데이터 분할
    frame_data = data_buffer[:frame_size]
    data_buffer = data_buffer[frame_size:]
    
    print("Frame size - {} bytes".format(frame_size))
    
    # loads : 직렬화된 데이터를 역직렬화
    # - 역직렬화(de-serialization) : 직렬화된 파일이나 바이트 객체를 원래의 데이터로 복원하는 것
    frame = pickle.loads(frame_data)
    
    # imdecode : 이미지(프레임) 디코딩
    # 1) 인코딩된 이미지 배열
    # 2) 이미지 파일을 읽을 때의 옵션
    #    - IMREAD_COLOR : 이미지를 COLOR로 읽음
    frame = cv2.imdecode(frame, cv2.IMREAD_COLOR)
    
    # 프레임 출력
    cv2.imshow('Frame', frame)
    
    # 'q' 키를 입력하면 종료
    key = cv2.waitKey(1) & 0xFF
    if key == ord("q"):
        break

client_socket.close()
server_socket.close()
print('close...')

cv2.destroyAllWindows()