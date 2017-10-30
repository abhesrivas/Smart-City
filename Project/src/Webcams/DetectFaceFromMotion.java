package Webcams;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgcodecs.*;
import org.opencv.imgproc.*;

public class DetectFaceFromMotion{
	static int j=0;
	public static void detectFaceFromMotion() {

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("\nRunning FaceDetector");

		final String directory="/home/abhishek/eclipse-workspace/Project";
		//CascadeClassifier cascade1;
		//cascade1.load("C:/opencv2.4.9/sources/data/haarcascades/haarcascade_frontalface_alt.xml");
		//DetectMotionExample.i
		while(j<DetectMotion.i)
		{
			CascadeClassifier faceDetector = new CascadeClassifier("/home/abhishek/Vision/opencv/data/haarcascades/haarcascade_frontalface_alt.xml");
			Mat image = Imgcodecs.imread(directory+"/test"+j+".jpg");

			MatOfRect faceDetections = new MatOfRect();
			faceDetector.detectMultiScale(image, faceDetections);

			System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));
			if(faceDetections.toArray().length>0)
			{
				for (Rect rect : faceDetections.toArray()) 
				{
					Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
							new Scalar(0, 255, 0));
				}

				String filename = "output"+j+".jpg";
				System.out.println(String.format("Writing %s", filename));
				Imgcodecs.imwrite(filename, image);
				j++;
			}
			else
				j++;
		}
	}
}