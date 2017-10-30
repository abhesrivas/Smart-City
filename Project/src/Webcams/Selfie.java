package Webcams;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.github.sarxos.webcam.Webcam;


public class Selfie {

	static int i=0;
	public static void takeSelfie(String s) throws IOException {
		Webcam webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(176,144));
		webcam.open();
		ImageIO.write(webcam.getImage(), "JPG", new File("Selfie"+i+"_s.jpg"));
		i++;
		webcam.close();
	}

}