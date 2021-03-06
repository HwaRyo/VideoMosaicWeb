import cv2
import os


class sample_gathering:
    def __init__(self, face_dir, name, id):
        self.face_dir = face_dir
        self.target_cnt = 10
        self.cnt = 0
        self.face_classifier = cv2.CascadeClassifier('opencv/data/haarcascades/haarcascade_frontalface_default.xml')
        self.name = name
        self.id = id

    def video_capture(self):
        cap = cv2.VideoCapture(self.face_dir)  # Video Capture object create
        # total frame get & target count image setting
        video_length = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
        if video_length >= 300:
            self.target_cnt = 300
        else:
            self.target_cnt = video_length
        # fps calculate
        fps = cap.get(cv2.CAP_PROP_FPS)
        delay = int(1000 / fps)
        while True:
            ret, frame = cap.read()
            if ret:
                cv2.waitKey(delay)  # 지연시간 설정
                gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
                # face detection
                faces = self.face_classifier.detectMultiScale(
                    gray,
                    scaleFactor=1.2,  # 검색 윈도우 확대 비율
                    minNeighbors=6,  # 최소 간격
                    minSize=(20, 20)  # 최소 크기
                )
                if len(faces) == 1:
                    (x, y, w, h) = faces[0]
                    # marking area and save file
                    cv2.rectangle(frame, (x, y), (x + w, y + h), (0, 255, 0), 1)
                    face = gray[y:y + h, x:x + w]
                    face = cv2.resize(face, (200, 200))
                    file_name_path = os.path.join(dir, str(self.cnt) + '.jpg')
                    cv2.imwrite(file_name_path, face)
                    cv2.putText(frame, str(self.cnt), (x, y), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255, 0), 2)
                    self.cnt += 1
                else:
                    # if faces are more than 1 or None Detection, show error
                    if len(faces) == 0:
                        msg = "no face"
                    else:
                        msg = "too many face."
                    cv2.putText(frame, str(msg), (445, 430), cv2.FONT_HERSHEY_COMPLEX, 1, (0, 255, 0), 2)
                cv2.imshow('face record', frame)
                if cv2.waitKey(1) == 27 or self.cnt == self.target_cnt:
                    break
            else:
                print("Can't find video")
                break
        cap.release()
        cv2.destroyAllWindows()
        print("Collecting Samples Completed")
