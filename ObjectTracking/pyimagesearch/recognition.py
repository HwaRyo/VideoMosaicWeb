import cv2
import os
import numpy as np

class recognition:

    def __init__(self, modelPath):  # model_dir -> 모델이 저장되어 있는 디렉토리
        self.minAccuracy = 80  # threshold
        self.model = cv2.face.LBPHFaceRecognizer_create()
        self.model.read(modelPath)

    def recognization(self, x, y, w, h, frame):
        if w>32 and h>32:
            face = frame[y:y + h, x:x + w].copy()
            face = cv2.resize(face, (200, 200)) #recognition size
            face = cv2.cvtColor(face, cv2.COLOR_BGR2GRAY)
            label, confidence = self.model.predict(face)
            if confidence < 400:
                accuracy = int(100 * (1 - confidence / 400))

                if accuracy < self.minAccuracy:
                    rate = 15  # reduction ratio in mosaic
                    roi = frame[y:y + h, x:x + w].copy()
                    if roi.shape[0] < 16 or roi.shape[1] < 16:
                        return frame
                    roi = cv2.resize(roi, (w // rate, h // rate))
                    roi = cv2.resize(roi, (w, h), interpolation=cv2.INTER_AREA)
                    frame[y:y + h, x:x + w] = roi  # mosaic application

        return frame