package drone;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This is the implementation Haversine Distance Algorithm between two places
 * @author ananth
 *  R = earth’s radius (mean radius = 6,371km)
    Δlat = lat2− lat1
    Δlong = long2− long1
    a = sin²(Δlat/2) + cos(lat1).cos(lat2).sin²(Δlong/2)
    c = 2.atan2(√a, √(1−a))
    d = R.c
 *
 */
 
public class HaversineDistance {
 
    /**
     * @param args
     * arg 1- latitude 1
     * arg 2 - latitude 2
     * arg 3 - longitude 1
     * arg 4 - longitude 2
     * "25.3045924","82.9782368","25.3110799","82.9864430"
     */
	
    public static void getDistance(Double lat1, Double lon1, Double lat2, Double lon2) {
        
        final int R = 6371; // Radius of the earth
        //Double lat1 = Double.parseDouble("25.3045924");
        //Double lon1 = Double.parseDouble("82.9782368");
        //Double lat2 = Double.parseDouble("25.3110799");
        //Double lon2 = Double.parseDouble("82.9864430");
        Double latDistance = toRad(lat2-lat1);
        Double lonDistance = toRad(lon2-lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + 
                   Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
                   Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        Double distance = R * c;
         
        System.out.println("The distance between two lat and long is::" + distance);
 
    }
    
    public static void main(String args[]) throws Exception
    {
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	while(true)
    	{
    		System.out.println("Enter the first place: ");
    		String first=br.readLine();
    		String[] coordinatesFirst=GeoLocator.geoLocate(first);
    		System.out.println("Location: "+first+" "+coordinatesFirst[0]+" "+coordinatesFirst[1]);
    		System.out.println("Enter the second place: ");
    		String second=br.readLine();
    		String[] coordinatesSecond=GeoLocator.geoLocate(second);
    		System.out.println("Location: "+second+" "+coordinatesSecond[0]+" "+coordinatesSecond[1]);
    		
    		
    		getDistance(Double.parseDouble(coordinatesFirst[0]),Double.parseDouble(coordinatesFirst[1]),Double.parseDouble(coordinatesSecond[0]),Double.parseDouble(coordinatesSecond[1]));
    	}
    }
     
    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
 