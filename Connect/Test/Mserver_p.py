import socket
from threading import Thread

def echo_handler(conn, addr):
    BUF_SIZE = 1024
    data = conn.recv(BUF_SIZE)
    msg = data.decode('utf-8')
    print('email: {} path: {} ip: {}'.format(msg.split(';')[0],msg.split(';')[1], addr))
    t = Thread(target=test_thread, args=(addr, conn))
    t.start()

def test_thread(addr, conn): # Modify Model Thread
    for i in range(100):
        print(i, addr)

def run_server(host = '192.168.0.149', port = 50001):
    with socket.socket() as sock:
        sock.bind((host, port))
        while True:
            sock.listen(3)
            conn, addr = sock.accept()
            echo_handler(conn, addr)
            # t = Thread(target=echo_handler, args=(conn, addr))
            # t.start()
        

if __name__ == '__main__':
    run_server()