import socket
from threading import Thread

print("python socket")
def echo_handler(conn, addr):
    BUF_SIZE = 1024
    count = conn.recv(BUF_SIZE)
    msg1 = count.decode('utf-8')
    
    for i in range(0, int(msg1)):
        video = conn.recv(1024)
        with open("test.mp4", "ab") as f:
            f.write(video)
    
    t = Thread(target)

def test_tread():
    print([i for i in range(100)])

def run_server(host = '192.168.0.18', port = 50001):
    with socket.socket() as sock:
        sock.bind((host, port))
        while True:
            sock.listen(3)
            conn, addr = sock.accept()
            echo_handler(conn, addr)
            t = Thread(target=echo_handler, args=(conn, addr))
            t.start()
        

if __name__ == '__main__':
    run_server()