import socket
from threading import Thread

def echo_handler(conn, addr, terminator="bye"):
    BUF_SIZE = 1024
    while True:
        data = conn.recv(BUF_SIZE)
        msg = data.decode('utf-8')
        print('RECEIVED: {} << {}'.format(msg, addr))
        conn.sendall(data)
        if msg == terminator:
            conn.close()
            break

def run_server(host = '192.168.0.149', port = 50001):
    with socket.socket() as sock:
        sock.bind((host, port))
        while True:
            sock.listen(3)
            conn, addr = sock.accept()
            t = Thread(target=echo_handler, args=(conn, addr))
            t.start()
        sock.close()

if __name__ == '__main__':
    run_server()