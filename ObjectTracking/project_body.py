import socket
import threading
from pythonmodel import pythonModel
from mailsend import mailSend

def serverStart(connect, address):

    # 이메일
    buffSize = 4096
    count = connect.recv(buffSize)
    userEmail = count.decode('utf-8')

    # 학습용 데이터
    buffSize = 1024
    count = connect.recv(buffSize)
    learnData = count.decode('utf-8')
    
    for i in range(0, int(learnData)):
        fileName = 'L_' + userEmail + '.mp4'
        video = connect.recv(1024)
        with open(fileName, "ab") as f:
            f.write(video)

    # 처리용 데이터
    buffSize = 1024
    count = conn.recv(buffSize)
    processData = count.decode('utf-8')
    
    for i in range(0, int(processData)):
        fileName = 'P_' + userEmail + '.mp4'
        video = conn.recv(1024)
        with open(fileName, "ab") as f:
            f.write(video)

####################################################################################

    connect.close()

####################################################################################

    # Face recognition model code

####################################################################################

    pythonModel = pythonModel(userEmail)
    pythonModel.process()

####################################################################################
    
    mailSend = mailSend(userEmail)
    title = "[코딩하는 감자들]"
    content = "모자이크 처리가 완료되었습니다.\n \
                이용해 주셔서 감사합니다.\n\n \
                - 코딩하는 감자들 - \
                "
    mailSend.send(title = title, content = content)

serverSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serverSocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
serverSocket.bind(('192.168.0.149', 50001))
serverSocket.listen()

try:
    while True:
        clientSocket, address = serverSocket.accept()
        serverThread = threading.Thread(target=serverStart, args = (clientSocket, address))
        serverThread.start()
except:
    print("server")
finally:
    serverSocket.close()
    clientSocket.close()