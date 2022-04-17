import socket

def run_client(host=socket.gethostbyname(socket.gethostname()), port=50001):
    with socket.socket() as sock:
        sock.connect((host, port))
        for _ in range(10):
            data = input(">>")
            sock.sendall(data.encode())
            if data == 'bye':
                sock.close()
                break
            res = sock.recv(1024)
            print(res.decode())
            
if __name__ == '__main__':
    run_client()