package users;

import java.io.IOException;

import Webcams.DetectMotion;

//import drone.GeoLocator;

public abstract class User
{
	
	public abstract void introduce() throws IOException, Exception;
	
	public abstract void interact()throws IOException, Exception;
	
	private String location;
	
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	

	/*public static void main(String args[]) throws IOException
	{
		boolean line=true;
		long start = System.nanoTime();
		while(line) {
			if(System.nanoTime() - start > 0.1E9) { //More than 10 minutes past the start.
				System.out.println("Timeout!");
				line=false;
			}
			DetectMotion.detectMotion(); //Process the line.
		}
	}*/
	//public static void main(String args[]) throws Exception
	//{
	//	String[] coordinates=GeoLocator.geoLocate("Varanasi");
	//	System.out.println("Latitude: "+coordinates[0]);
	//	System.out.println("Longitude: "+coordinates[1]);
	//}
}
