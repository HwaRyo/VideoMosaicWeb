import socket
import threading
import pythonmodel
import mailsend
from pyimagesearch.sampleGathering import sampleGathering
from pyimagesearch.learnrecognition import learnRecognition

def serverStart(connect):

    # 이메일
    buffSize = 4096
    count = connect.recv(buffSize)
    userEmail = count.decode('utf-8')

####################################################################################

    # FOLDER CREATE

####################################################################################

    # 학습용 데이터
    buffSize = 1024
    count = connect.recv(buffSize)
    learnData = count.decode('utf-8')
    
    for i in range(0, int(learnData)):
        faceDir = 'L_' + userEmail + '.mp4'
        video = connect.recv(1024)
        with open(faceDir, "ab") as f:
            f.write(video)

    # 처리용 데이터
    buffSize = 1024
    count = connect.recv(buffSize)
    processData = count.decode('utf-8')
    
    for i in range(0, int(processData)):
        videoDir = 'P_' + userEmail + '.mp4'
        video = connect.recv(1024)
        with open(videoDir, "ab") as f:
            f.write(video)

####################################################################################

    connect.close()

####################################################################################

    faceDir = ""
    datasetDir = ""
    id = ""
    recogModelDir = ""
    videoDir = ""

    gatheringData = sampleGathering(faceDir, id)
    recogModel = learnRecognition(datasetDir)

    gatheringData.videoCapture()
    recogModel.process()

####################################################################################

    pythonModel = pythonmodel(userEmail)
    pythonModel.process()

####################################################################################
    
    mailSend = mailsend(userEmail)
    title = "[코딩하는 감자들]"
    content = "모자이크 처리가 완료되었습니다.\n \
                이용해 주셔서 감사합니다.\n \
                - 코딩하는 감자들 - \
                "
    mailSend.send(title = title, content = content)

serverSocket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serverSocket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
serverSocket.bind(('192.168.0.6', 50001))
serverSocket.listen()

try:
    while True:
        clientSocket, address = serverSocket.accept()
        serverThread = threading.Thread(target=serverStart, args = (clientSocket))
        serverThread.start()
except:
    print("server")
finally:
    serverSocket.close()
    clientSocket.close()