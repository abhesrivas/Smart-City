package users;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import drone.*;

public class ControlPanel
{

	private static ArrayList<Drone> dronesActive=new ArrayList<Drone>();


	public static void activateDrones(Drone D)
	{
		Manufacturer.removeDrones(D);
		D.isActivated=true;
		dronesActive.add(D);
		System.out.println("Drone "+D.getName()+" activated.");
	}

	public static void deactivateDrones(Drone D)
	{
		dronesActive.remove(D);
		D.isActivated=false;
		Manufacturer.addDrones(D);
		System.out.println("Drone "+D.getName()+" deactivated.");
	}

	public static void viewActivated()
	{
		int i=1;
		for(Drone D:dronesActive)
		{
			System.out.println(i+"."+D.getName()+" "+D.getModel_number()+" "+D.getLocation());
			i++;
		}
	}

	public static void main(String args[])throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			System.out.println("Choose: 1. Control, 2. Users, 3. Exit");
			int choice=Integer.parseInt(br.readLine());

			switch(choice)
			{
			case 2: users();
			continue;
			case 1: controlPanel(); 
			continue;
			case 3: System.exit(0);
			}
		}
	}
	public static void users() throws Exception
	{
		User U;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean condition=true;
		while(condition)
		{
			System.out.println("Users: [1. Tourist, 2. Police, 3. Cab/Taxi Agent, 4. Exit]");
			int choice=Integer.parseInt(br.readLine());

			switch(choice)
			{

			case 1: U=new Tourist();
			U.introduce();
			U.interact();
			continue;

			case 2: U=new Police();
			U.introduce();
			U.interact();
			continue;

			case 3: U=new Agent();
			U.introduce();
			U.interact();
			continue;

			case 4: ControlPanel.viewActivated();
			continue;

			case 5: Manufacturer.manufactureDrone();
			continue;

			case 6: condition=false;
			break;
			}
		}
	}
	public static void controlPanel() throws Exception
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		boolean condition=true;
		while(condition)
		{
			System.out.println("Control Panel: [1. Activate Drones, 2. Deactivate Drones, 3. View Drones in Storage, 4. View Activated Drones, 5. Order Drone, 6. Exit");
			int choice=Integer.parseInt(br.readLine());

			switch(choice)
			{

			case 1: Manufacturer.viewDrones();
			System.out.println("Drone number: ");
			ControlPanel.activateDrones(Manufacturer.getDrone(Integer.parseInt(br.readLine())-1));
			continue;

			case 2: ControlPanel.viewActivated();
			System.out.println("Drone number: ");
			ControlPanel.deactivateDrones(ControlPanel.getDrone(Integer.parseInt(br.readLine())-1));
			continue;

			case 3: Manufacturer.viewDrones(); 
			continue;

			case 4: ControlPanel.viewActivated();
			continue;

			case 5: Manufacturer.manufactureDrone();
			continue;

			case 6: condition=false;
					break;
			}
		}
	}


	public static Drone getTouristDroneInLocation(String s)
	{
		for(Drone D:dronesActive)
		{
			if(D instanceof TouristDrone || D instanceof MultiDrone)
			{
				if(D.getLocation().equalsIgnoreCase(s))
				{
					//if(D.isOccupied=true)
					//	continue;
					//else
						return (TouristDrone)D;
				}
			}
		}
		return null;
	}

	public static Drone getPoliceDroneInLocation(String s)
	{
		for(Drone D:dronesActive)
		{
			if(D instanceof PoliceDrone || D instanceof MultiDrone)
			{
				if(D.getLocation().equalsIgnoreCase(s))
				{
					//if(D.isOccupied=true)
					//	continue;
					//else
						return (PoliceDrone)D;
				}
			}
		}
		return null;
	}
	public static Drone getDrone(int i)
	{
		// TODO Auto-generated method stub
		return dronesActive.get(i);
	}



}
