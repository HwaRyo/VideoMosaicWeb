import socket
from threading import Thread

def echo_handler(conn, addr, terminator="bye"):
    '''개별 연결에 대해 에코잉을 처리하는 핸들러'''
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
            # 새 연결이 생성되면 새 스레드에서 에코잉을 처리하게 한다.
            t = Thread(target=echo_handler, args=(conn, addr))
            t.start()
        sock.close()

if __name__ == '__main__':
    run_server()