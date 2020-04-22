import java.time.LocalDateTime;

public class AirQualityProfile {
	private LocalDateTime datetime;
	private String location;
	private int aqi;
	private int pm25;
	private double temp;
	public static int cout = 0;
	
	public AirQualityProfile(LocalDateTime dt, String loc, int aqi, int pm25, double temp) {
		datetime 	= dt;
		location 	= loc;
		this.aqi 	= aqi;
		this.pm25 	= pm25;
		this.temp	= temp;
		cout++;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public int getPm25() {
		return pm25;
	}

	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
	public boolean isUnhealthy() {
		if(aqi>100) return true;
		
		return false;
	}
	public void tem() {
		if(temp>25) System.out.println("Hot");
		else if(temp==25) System.out.println("Nice weather");
		else System.out.println("Cool");
	}
	
	
	public void printAirQualityInfo() {
		System.out.println(location+" at "+datetime);
		System.out.println("AQI: "+aqi+"PM2.5: "+pm25+" microgram/m3");
		System.out.println("Temperature: "+temp);
		if(isUnhealthy()) System.out.println("Unhealthy");
		else System.out.println("Healthy");
		tem();
		
	}
}
