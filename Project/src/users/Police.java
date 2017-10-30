package users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Webcams.DetectFaceFromMotion;
import drone.*;

public class Police extends User
{

	Drone D;
	boolean onDuty;
	private static ArrayList<Object> HQ_inbox=new ArrayList<Object>();

	public static void addInbox(Object a)
	{
		HQ_inbox.add(a);
	}

	public static void deleteInbox()
	{
		HQ_inbox.remove(HQ_inbox.size()-1);
	}

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

	@Override
	public void introduce()throws Exception
	{

		System.out.println("Officer, enter your location: ");
		String location=br.readLine();
		setLocation(location);

		System.out.println("You have "+HQ_inbox.size()+" new mails from PoliceDrones. Check? [Y/N]");
		String check=br.readLine();

		if(check.equalsIgnoreCase("Y"))
		{
			for(Object o:HQ_inbox)
			{
				if(o instanceof String)
					System.out.println(o.toString());

				if(o instanceof Integer)
					//Use the integers
					System.out.println(o.toString());	
			}
		}

		D=ControlPanel.getPoliceDroneInLocation(location);

		if(D instanceof PoliceDrone)
		{
			D.isOccupied=true;
			System.out.println("PoliceDrone "+D.getName()+" at "+D.getLocation()+" is here. ");
		}
		else if(D instanceof MultiDrone)
		{
			D.isOccupied=true;
			System.out.println("MultiDrone "+D.getName()+" at "+D.getLocation()+" is here. ");
		}

		new Police().interact();
	}

	public void interact()throws Exception
	{
		while(true)
		{
			System.out.println("Police: [1. Go with Drone to new location, 2. Start Motion Surveillance, 3. Detect Faces, 4. Display Image, 5. Exit]");
			int choice=Integer.parseInt(br.readLine());
			String place;
			String[] coordinates;
			switch(choice)
			{
			case 1:  System.out.println("Enter place: ");
			place=br.readLine();
			coordinates=GeoLocator.geoLocate(place);
			D.setLatitude(coordinates[0]);
			D.setLongitude(coordinates[1]);
			setLocation(place);
			continue;

			case 2: 
				System.out.println("Enter duration in seconds to record movement: ");
				D.startCamera(Integer.parseInt(br.readLine()));
				continue;
			case 3: DetectFaceFromMotion.detectFaceFromMotion();
			continue;

			case 4:

			case 5: System.exit(0);

			}	
		}
	}




}
