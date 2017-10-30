package Webcams;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamMotionDetector;
import com.github.sarxos.webcam.WebcamMotionEvent;
import com.github.sarxos.webcam.WebcamMotionListener;

/**
 * Detect motion. This example demonstrates how to use build-in motion detector
 * and motion listener to fire motion events.
 * 
 * @author Bartosz Firyn (SarXos)
 */
public class DetectMotion implements WebcamMotionListener {

	static final long start = System.nanoTime();
	static Webcam webcam;
	static int i=0;
	public static int timeToStop;
	
	public DetectMotion() {
		WebcamMotionDetector detector = new WebcamMotionDetector(Webcam.getDefault());
		detector.setInterval(500); // one check per 500 ms
		detector.addMotionListener(this);
		detector.start();
	}

	public void setTimeToStop(int a)//In seconds
	{
		timeToStop=a;
	}
	@Override
	public void motionDetected(WebcamMotionEvent wme) {
		// get default webcam and open it
		webcam = Webcam.getDefault();
		webcam.open();

		// get image
		BufferedImage image = webcam.getImage();

		// save image to PNG file
		try
		{
			ImageIO.write(image, "JPG", new File("test"+i+".jpg"));
			i++;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Detected motion, picture saved as test"+i+".jpg");
		if(System.nanoTime() - start > timeToStop*Math.pow(10, 9))
		{
			System.out.println("Bye.");	

			webcam.close();
		}
	}

	public static void detectMotion()throws IOException 
	{
		new DetectMotion();
		System.in.read(); // keep program open
	}
}
