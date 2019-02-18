
public enum Platform {
	PC("PC"),
	Playstation("Playstation"),
	XBOX("XBOX"),
	Nintendo("Nintendo"),
	Mobile("Mobilna"),
	UNKNOWN("--------");
	
	String platformName;
	

	Platform (String platform_name) {
		 platformName=platform_name;
	}
	
	@Override
	public String toString() {
		return platformName;
	}
	
	
	
	
}
