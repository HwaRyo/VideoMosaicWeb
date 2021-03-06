import cv2
import os, glob


class module_face_recognition:

    def __init__(self, model_dir,video_dir):  # model_dir -> 모델이 저장되어 있는 디렉토리
        self.video_dir = video_dir
        self.model_dir = model_dir
        self.min_accuracy = 80  # threshold
        self.face_classifier = cv2.CascadeClassifier('opencv/data/haarcascades/haarcascade_frontalface_default.xml')
        self.model = cv2.face.LBPHFaceRecognizer_create()
        self.model.read(os.path.join(self.model_dir, 'custom.xml'))

    def information(self):
        # information creating
        dirs = [d for d in glob.glob(self.model_dir + "/*") if os.path.isdir(d)]
        names = dict([])
        for dir in dirs:
            dir = os.path.basename(dir)
            name, id = dir.split('_')
            names[int(id)] = name
        return names

    def process(self):
        names = self.information()
        # capture setting on camera
        cap = cv2.VideoCapture(self.video_dir) # Video Capture object create
        while cap.isOpened():
            ret, frame = cap.read()
            if not ret:
                print("no frame")
                break
            else:
                # video fps calculate
                fps = cap.get(cv2.CAP_PROP_FPS)
                delay = int(1000 / fps)
                cv2.waitKey(delay)
                gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
                # face detecting
                faces = self.face_classifier.detectMultiScale(gray, 1.3, 5) # detection

                for (x, y, w, h) in faces:
                    # draw face area
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 255), 2)
                    face = frame[y:y + h, x:x + w]
                    face = cv2.resize(face, (200, 200))
                    face = cv2.resize(face, cv2.COLOR_BGR2GRAY)
                    # prediction with recognition
                    label, confidence = self.model.predict(face)
                    if confidence < 400:
                        # accuracy distance -> procent
                        accuracy = int(100 * (1 - confidence / 400))
                        if accuracy >= self.min_accuracy:
                            msg = '%s(%.0f%%)' % (names[label], accuracy)
                            # display name and accuracy
                            txt, base = cv2.getTextSize(msg, cv2.FONT_HERSHEY_PLAIN, 1, 3)
                            cv2.rectangle(frame, (x, y - base - txt[1]), (x + txt[0], y + txt[1]), (0, 255, 255), -1)
                            cv2.putText(frame, msg, (x, y), cv2.FONT_HERSHEY_PLAIN, 1, (200, 200, 200), 2, cv2.LINE_AA)
                        else:  # mosaic
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
