import cv2
import socket
import pickle
import struct

ip = '192.168.0.149'
port = 50001

capture = cv2.VideoCapture("D:\\School\\FinalProject\\VideoMosaicWeb\\Connect\\Data\\Test1.mp4")

capture.set(cv2.CAP_PROP_FRAME_WIDTH, 640)
capture.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
    client_socket.connect((ip, port))
    
    print("Connect!")

    while True:
        
        retval, frame = capture.read()
        retval, frame = cv2.imencode('.jpg', frame, [cv2.IMWRITE_JPEG_QUALITY, 90])
        frame = pickle.dumps(frame)
        print("Frame size : {} bytes".format(len(frame)))

        client_socket.sendall(struct.pack(">L", len(frame)) + frame)

capture.release()