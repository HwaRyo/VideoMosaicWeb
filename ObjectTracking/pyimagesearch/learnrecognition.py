import cv2
import numpy as np
import os, glob


class learnRecognition:

    def __init__(self, datasetDir):
        self.trainData, self.trainLabels = [], []
        self.dirs = [d for d in glob.glob(datasetDir+'/*') if os.path.isdir(d)]

    def process(self):
        print("Collecting train data set:")
        for dir in self.dirs:
            id = dir.split('_')[1]  # Excepting id
            files = glob.glob(dir + '/*.jpg')
            print('\t path:%s, %dfiles' % (dir, len(files)))
            for file in files:
                img = cv2.imread(file, cv2.IMREAD_GRAYSCALE)
                self.trainData.append(np.asarray(img, dtype=np.uint8))
                self.trainLabels.append(int(id))

            trainData = np.asarray(self.trainData)
            trainLabels = np.int32(self.trainLabels)

            model = cv2.face.LBPHFaceRecognizer_create()
            model.train(trainData, trainLabels)
            model.write('model/custom/custom.xml')