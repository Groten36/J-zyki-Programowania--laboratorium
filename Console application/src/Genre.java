
public enum Genre {
	RPG("RPG"),
	FPS("FPS"),
	Adventure("Przygodowa"),
	Simulation("Symulacyjna"),
	Sport("Sportowa"),
	Racing("Wyscigowa"),
	Action("Akcji"),
	Strategy("Strategia"),
	Horror("Horror"),
	Party("Imprezowa"),
	UNKNOWN("----------");
	
	String genreName;
	
	@Override
	public String toString() {
		return genreName;
	}
	
	Genre (String genre_name) {
		 genreName=genre_name;
	}
}
