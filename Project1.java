import java.util.Scanner;
import java.text.DecimalFormat;

public class Project1
{
	public static void main(String[] args)
	{
		String location1;
		String location2;
		double origlat1;
		double origlat2;
		double origlon1;
		double origlon2;
		double lat1;
		double lon1;
		double lat2;
		double lon2;
		double radiusOfEarth = 3958.75586;
		double deltaLat;
		double deltaLon;
		double sindeltaLat;
		double sindeltaLon;
		double sinsqrdeltaLat;
		double sinsqrdeltaLon;
		double coslat1;
		double coslat2;
		double a;
		double circumference; 
		double distance;

		//Stores name and longitude and lattude values of a location entered by the user
		System.out.println("Please enter the name of a location");
		Scanner scan = new Scanner(System.in);
		location1 = scan.nextLine();

		System.out.println("Please enter the latitude value of " + location1 + " in degrees:");
		origlat1 = scan.nextDouble();

		System.out.println("Please enter the longitude value of " + location1 + " in degrees:");
		origlon1 = scan.nextDouble();

		System.out.println("Please enter the name of a second location");
		Scanner scan1 = new Scanner(System.in);
		location2 = scan1.nextLine();

		System.out.println("Please enter the latitude value of " + location2 + " in degrees:");
		origlat2 = scan.nextDouble();

		System.out.println("Please enter the longitude value of " + location2 + " in degrees:");
		origlon2 = scan.nextDouble();

		//Converts the entered longitude and latitude values from degrees to radians
		lat1 = origlat1 * (Math.PI / 180);
		lat2 = origlat2 * (Math.PI / 180);
		lon1 = origlon1 * (Math.PI / 180);
		lon2 = origlon2 * (Math.PI / 180);

		//Haversine Formula
		deltaLat = lat2 - lat1;
		deltaLon = lon2 - lon1;

		sindeltaLat = Math.sin(deltaLat / 2);
		sinsqrdeltaLat = Math.pow(sindeltaLat, 2);

		sindeltaLon = Math.sin(deltaLon / 2);
		sinsqrdeltaLon = Math.pow(sindeltaLon, 2);

		coslat1 = Math.cos(lat1);
		coslat2 = Math.cos(lat2);

		a = sinsqrdeltaLat + (coslat1 * coslat2 * sinsqrdeltaLon);
		circumference = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		distance = radiusOfEarth * circumference;

		//Rounds values to three decimal places including zero if it in the third decimal place
		DecimalFormat fmt = new DecimalFormat("0.000");

		System.out.println("The distance between " + location1 + " (" + origlat1 + ", " + origlon1 + ") " + "and " + location2 + " (" + origlat2 + ", " + origlon2 + ") is " + fmt.format(distance) + " miles.");
	}
}