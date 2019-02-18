
public enum Mode {
	Singleplayer("Single"),
	Multiplayer("Multi"),
	Both("Oba"),
	UNKNOWN("----------");
	
	String modeName;
	
	@Override
	public String toString() {
		return modeName;
	}
	
	Mode (String mode_name) {
		 modeName=mode_name;
	}

}
