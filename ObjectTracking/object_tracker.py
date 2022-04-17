#python object_tracker.py --prototxt deploy.prototxt.txt --model res10_300x300_ssd_iter_140000.caffemodel

import sys
sys.path.append("D:\\School\\FinalProject\\VideoMosaicWeb\\ObjectTracking\\pyimagesearch")
from pyimagesearch.centroidtracker import CentroidTracker
from moviepy.editor import *
import numpy as np
import argparse
import imutils
import time
import cv2

ap = argparse.ArgumentParser()
ap.add_argument("-p", "--prototxt", required=True,
	help="path to Caffe 'deploy' prototxt file")
ap.add_argument("-m", "--model", required=True,
	help="path to Caffe pre-trained model")
ap.add_argument("-c", "--confidence", type=float, default=0.5,
	help="minimum probability to filter weak detections")
# ap.add_argument("-v", "--video", required=True,
# 	help="path to video file to be processed")
ap.add_argument("-v", "--video", default=0,
	help="path to video file to be processed")
args = vars(ap.parse_args())

ct = CentroidTracker()
(H, W) = (None, None)

print("[INFO] loading model... ", end='')
net = cv2.dnn.readNetFromCaffe(args["prototxt"], args["model"])
print("Done")

print("[INFO] extracting audio of video... ", end='')
vfaudio = VideoFileClip(args["video"]).audio
print("Done")

# initialize the video stream and allow the camera sensor to warmup
print("[INFO] starting video... ", end='')
vc = cv2.VideoCapture(args["video"])
fcc = cv2.VideoWriter_fourcc(*'DIVX')
fps = round(vc.get(cv2.CAP_PROP_FPS), 2)
outPath = args["video"].split('\\')[-1].split('.')[0]+'.avi'
vw = cv2.VideoWriter(outPath, fcc, 30,
	(int(vc.get(cv2.CAP_PROP_FRAME_WIDTH)),int(vc.get(cv2.CAP_PROP_FRAME_HEIGHT))))
print("Done")

# loop over the frames from the video stream
while vc.isOpened():
	# read the next frame from the video stream and resize it
	ret, frame = vc.read()
	print(int(vc.get(cv2.CAP_PROP_POS_FRAMES)), '/', int(vc.get(cv2.CAP_PROP_FRAME_COUNT)))
	if not ret:
		break
	# if the frame dimensions are None, grab them
	if W is None or H is None:
		(H, W) = frame.shape[:2]

	# construct a blob from the frame, pass it through the network,
	# obtain our output predictions, and initialize the list of
	# bounding box rectangles
	blob = cv2.dnn.blobFromImage(frame, 1.0, (W, H),
		(104.0, 177.0, 123.0))
	net.setInput(blob)
	detections = net.forward()
	rects = []

	# loop over the detections
	for i in range(0, detections.shape[2]):
		# filter out weak detections by ensuring the predicted
		# probability is greater than a minimum threshold
		if detections[0, 0, i, 2] > args["confidence"]:

			# compute the (x, y)-coordinates of the bounding box for
			# the object, then update the bounding box rectangles list
			box = detections[0, 0, i, 3:7] * np.array([W, H, W, H])
			rects.append(box.astype("int"))

			(startX, startY, endX, endY) = box.astype("int")
			print(startX, startY, endX, endY)
			# cv2.rectangle(frame, (startX, startY), (endX, endY),
			# 	(0, 255, 0), 2)

	objects = ct.update(rects) 
	for (objectID, centroid) in objects.items():
		text = "ID {}".format(objectID)
		cv2.putText(frame, text, (centroid[0] - 10, centroid[1] - 10),
			cv2.FONT_HERSHEY_SIMPLEX, 0.5, (0, 255, 0), 2)
		cv2.circle(frame, (centroid[0], centroid[1]), 4, (0, 255, 0), -1)

	#추후 삭제
	# cv2.imshow("Frame", frame)
	vw.write(frame)
	key = cv2.waitKey(1) & 0xFF

	if key == ord("q") or key == ord("Q"):
		break

vc.release()
vw.release()
cv2.destroyAllWindows()

vfvideo = VideoFileClip(outPath)
vfvideo.audio = vfaudio
vfvideo.write_videofile(args["video"].split('\\')[-1].split('.')[0]+'.mp4')