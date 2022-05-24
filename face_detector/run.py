import module_sample_gathering
import module_face_detection
import module_face_recognition

face_dir = ""
dataset_dir = ""
name = ""
id = ""
model_dir = ""
video_dir = ""

sample_gathering = module_sample_gathering(face_dir, name, id)
face_detection = module_face_detection(dataset_dir)
face_recognition = module_face_recognition(model_dir, video_dir)

sample_gathering.video_capture()
face_detection.process()
face_recognition.process()

