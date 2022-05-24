import cv2
import os

class recognition:

    def __init__(self, model_dir, video_dir):  # model_dir -> 모델이 저장되어 있는 디렉토리
        self.videoDir = video_dir
        self.modelDir = model_dir
        self.minAccuracy = 80  # threshold
        self.model = cv2.face.LBPHFaceRecognizer_create()
        self.model.read(os.path.join(self.modelDir, 'custom.xml'))

    def recognization(self, x, y, w, h, frame):
        face = frame[y:y + h, x:x + w]
        face = cv2.resize(face, (200, 200)) #recognition size
        face = cv2.resize(face, cv2.COLOR_BGR2GRAY)
        label, confidence = self.model.predict(face)
        if confidence < 400:
            accuracy = int(100 * (1 - confidence / 400))

            if accuracy < self.minAccuracy:
                rate = 15  # reduction ratio in mosaic
                x = x - 5
                y = y - 15
                w = w + 10
                h = h + 30
                roi = face
                roi = cv2.resize(roi, (w // rate, h // rate))
                roi = cv2.resize(roi, (w, h), interpolation=cv2.INTER_AREA)
                frame[y:y + h, x:x + w] = roi  # mosaic application

        return frame