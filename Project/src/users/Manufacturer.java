package users;

import java.io.*;
import java.util.ArrayList;

import drone.Drone;
import drone.PoliceDrone;
import drone.TouristDrone;

public class Manufacturer
{
	private static ArrayList<Drone> dronesStorage=new ArrayList<Drone>();

	public static void manufactureDrone()throws Exception
	{
		Drone D;

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Manufacture: 1. Tourist Drone, 2. Police Drone, 3. Both");

		switch(Integer.parseInt(br.readLine()))
		{
		case 1: 
			System.out.println("Enter Drone name: ");
			String name=br.readLine();
			System.out.println("Enter Drone model: ");
			String model=br.readLine();
			System.out.println("Enter Drone installation location: ");
			String location=br.readLine();

			D=new TouristDrone(name,model,location);
			dronesStorage.add(D);
			break;

		case 2: 
			System.out.println("Enter Drone name: ");
			name=br.readLine();
			System.out.println("Enter Drone model: ");
			model=br.readLine();
			System.out.println("Enter Drone installation location: ");
			location=br.readLine();

			D=new PoliceDrone(name,model,location);
			dronesStorage.add(D);
			break;
		}
	}

	public static void addDrones(Drone D)
	{

		dronesStorage.add(D);
	}

	public static void removeDrones(Drone D)
	{
		dronesStorage.remove(D);
	}

	public static void viewDrones()
	{
		int i=1;
		for(Drone D:dronesStorage)
		{
			System.out.println(i+"."+D.getName()+" "+D.getModel_number()+" "+D.getLocation());
			i++;
		}
	}

	public static Drone getDrone(int i)
	{
		return Manufacturer.dronesStorage.get(i);
	}

}

