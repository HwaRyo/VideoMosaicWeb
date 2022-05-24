import cv2
import os

class sampleGathering:
    def __init__(self, faceDir, id):
        self.faceDir = faceDir
        self.target_cnt = 10
        self.cnt = 0
        self.faceClassifier = cv2.CascadeClassifier('../model/haarcascade_frontalface_default.xml')
        self.id = id

    def videoCapture(self):
        cap = cv2.VideoCapture(self.faceDir)
        videoLength = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
        if videoLength >= 300:
            self.target_cnt = 300
        else:
            self.target_cnt = videoLength

        fps = cap.get(cv2.CAP_PROP_FPS)
        delay = int(1000 / fps)
        while True:
            ret, frame = cap.read()
            if ret:
                cv2.waitKey(delay)  # 지연시간 설정
                gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
                faces = self.faceClassifier.detectMultiScale(
                    gray,
                    scaleFactor=1.2,  # 검색 윈도우 확대 비율
                    minNeighbors=6,  # 최소 간격
                    minSize=(20, 20)  # 최소 크기
                )
                if len(faces) == 1:
                    (x, y, w, h) = faces[0]
                    face = gray[y:y + h, x:x + w]
                    face = cv2.resize(face, (200, 200))
                    dir = "11"
                    fileNamePath = os.path.join(dir, str(self.cnt) + '.jpg')
                    cv2.imwrite(fileNamePath, face)
                    self.cnt += 1

                if self.cnt == self.target_cnt:
                    break
            else:
                break
        cap.release()
