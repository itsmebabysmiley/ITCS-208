import java.time.LocalDateTime;

public class AirQualityTester {

	public static void main(String[] args) {

		AirQualityProfile a = new AirQualityProfile(LocalDateTime.now(),"Thon Buri",112,40,29.0);
		a.printAirQualityInfo();
		AirQualityProfile b = new AirQualityProfile(LocalDateTime.now(),"Phuket",51,12,31);
		b.printAirQualityInfo();
		System.out.println("count: "+AirQualityProfile.cout);
		
	}

}
