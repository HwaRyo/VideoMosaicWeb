import sys
sys.path.append("D:\\School\\FinalProject\\VideoMosaicWeb\\ObjectTracking\\pyimagesearch")
from pyimagesearch.centroidtracker import centroidTracker
from pyimagesearch.recognition import recognition
from moviepy.editor import *
import numpy as np
import cv2

class pythonModel:

	def __init__(self, videoPath, recogModelPath):
		self.prototxt = 'model/deploy.prototxt.txt'
		self.detectModel = 'model/res10_300x300_ssd_iter_140000.caffemodel'
		self.videoPath = videoPath
		self.recogModelPath = recogModelPath
		self.threshold = 0.5

	def process(self):
		centTrac = centroidTracker()
		(H, W) = (None, None)

		net = cv2.dnn.readNetFromCaffe(self.prototxt, self.detectModel)

		vfaudio = VideoFileClip(self.videoPath).audio
		videoCapture = cv2.VideoCapture(self.videoPath)

		fcc = cv2.VideoWriter_fourcc(*'DIVX')
		fps = round(videoCapture.get(cv2.CAP_PROP_FPS), 2)
		outPath = self.videoPath.split('\\')[-1].split('.')[0]+'.avi'
		videoWriter = cv2.VideoWriter(outPath, fcc, fps,
			(int(videoCapture.get(cv2.CAP_PROP_FRAME_WIDTH)),int(videoCapture.get(cv2.CAP_PROP_FRAME_HEIGHT))))

		while videoCapture.isOpened():
			ret, frame = videoCapture.read()
			if not ret:
				break
			if W is None or H is None:
				(H, W) = frame.shape[:2]

			blob = cv2.dnn.blobFromImage(frame, 1.0, (W, H),
										 (104.0, 177.0, 123.0))
			net.setInput(blob)
			detections = net.forward()
			rects = []

			for i in range(0, detections.shape[2]):
				if detections[0, 0, i, 2] > self.threshold:

					box = detections[0, 0, i, 3:7] * np.array([W, H, W, H])

				rects.append(box.astype("int"))
				(startX, startY, endX, endY) = box.astype("int")
				recogModel = recognition(self.recogModelPath, self.videoPath)
				recogModel.recognization(startX, startY, endX-startX, endY-startY, frame)

			objects = centTrac.update(rects)
			for (objectID, centroid) in objects.items():
				pass


			# text = "ID {}".format(objectID)
			# # face recognition code add
			#
			# # cv2.putText(frame, text, (centroid[0] - 10, centroid[1] - 10),
			# 	# cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)
			# # cv2.circle(frame, (centroid[0], centroid[1]), 4, (0, 255, 0), -1)


			videoWriter.write(frame)

		videoCapture.release()
		videoWriter.release()
		cv2.destroyAllWindows()

		videoFileClip = VideoFileClip(outPath)
		videoFileClip.audio = vfaudio
		videoFileClip.write_videofile(self.videoPath.split('\\')[-1].split('.')[0]+'.mp4')