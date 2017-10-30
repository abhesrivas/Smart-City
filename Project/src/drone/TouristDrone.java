package drone;

public class TouristDrone extends Drone
{
	public TouristDrone(String name, String model_number, String location) throws Exception
	{
		super(name,model_number,location);
	}
	
	public static void checkPlaceWithinCity(String place, String location) throws Exception
	{
		String[] coordinates=GeoLocator.geoLocate(place);
		String[] coordinates_Tourist=GeoLocator.geoLocate(location);
		boolean isWithin=false;

		if((int)Integer.parseInt(coordinates_Tourist[0])==(int)Integer.parseInt(coordinates[0]))
		{
			if((int)Integer.parseInt(coordinates_Tourist[1])==(int)Integer.parseInt(coordinates[1]))
			{
				isWithin=true;
			}
		}
		if(isWithin)
		{
			System.out.println(place+" is in "+location+".");
		}
		else
			System.out.println(place+" is not in "+location+".");
	}
	
}
