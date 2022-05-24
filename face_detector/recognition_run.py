import cv2
import os, glob


class recognition_run:

    def __init__(self, video_dir):
        # video_dir -> 비디오가 저장되어 있는 디렉토리
        self.video_dir = video_dir
        self.face_classifier = cv2.CascadeClassifier('opencv/data/haarcascades/haarcascade_frontalface_default.xml')
        self.model = cv2.face.LBPHFaceRecognizer_create()

    def process(self):
        # capture setting on camera
        cap = cv2.VideoCapture(self.video_dir)
        while cap.isOpened():
            ret, frame = cap.read
            if not ret:
                print("No exist frame")
                break
            else:
                fps = cap.get(cv2.CAP_PROP_FPS)
                delay = int(1000/fps)
                cv2.waitKey(delay)
                gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
                # face detecting
                faces = self.face_classifier.detectMultiScale(gray, 1.3, 5)
                for (x, y, w, h) in faces:
                    # draw face area
                    cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 255), 2)
                    face = frame[y:y+h, x:x+w]
                    face = cv2.resize(face, (200,200))
                    face = cv2.resize(face, cv2.COLOR_BGR2GRAY)
                    rate = 15  # reduction ratio in mosaic
                    x = x - 5
                    y = y - 15
                    w = w + 10
                    h = h + 30
                    roi = face
                    roi = cv2.resize(roi, (w // rate, h // rate))
                    # enlarge to original size
                    roi = cv2.resize(roi, (w, h), interpolation=cv2.INTER_AREA)
                    frame[y:y + h, x:x + w] = roi  # mosaic application
                cv2.imshow('Face Recognition', frame)
                if cv2.waitKey(1) == 27:  # esc
                    break
            cap.release()
            cv2.destroyAllWindows()
