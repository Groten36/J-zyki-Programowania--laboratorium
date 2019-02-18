import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Game {
	 String title;
	 String developer;
	 String publisher;
	 Platform platform;
	 int realise;
	 Genre genre;
	 Mode mode;
	 int number;
	
	
	@Override
	public String toString() {
		return "Game [title=" + title + ", developer=" + developer + ", publisher=" + publisher + ", platform="
				+ platform + ", realise=" + realise + ", genre=" + genre + ", mode=" + mode + ", number=" + number
				+ "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws GameException {
		if(title==null|| title.equals("")) {
			throw new GameException("£ancuch znakow musi byc niepusty!");
		}
		this.title = title;
	}

	public String getDeveloper() {
		return developer;
	}

	public void setDeveloper(String developer) {
		this.developer = developer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) throws GameException {
		this.platform = platform;
	}
	
	public void setPlatform(String platform_name) throws GameException {
		if(platform_name==null||platform_name.equals("")) {
			this.platform=Platform.UNKNOWN;
		}
		
		for(Platform platform : Platform.values()) {
			if(platform.platformName.equals(platform_name)) {
					this.platform=platform;
					return;
				}
			}
		throw new GameException("Brak takiej platformy");
	}

	public int getRealise() {
		return realise;
	}

	public void setRealise(int realise) {
		this.realise = realise;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public void setGenre(String genre_name) throws GameException {
		if(genre_name==null||genre_name.equals("")) {
			this.genre=Genre.UNKNOWN;
		}
		
		for(Genre genre : Genre.values()) {
			if(genre.genreName.equals(genre_name))
					this.genre=genre;
					return;
				}
		throw new GameException("Brak takiej gatunku");
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public void setMode(String mode_name) throws GameException {
		if(mode_name==null||mode_name.equals("")) {
			this.mode=Mode.UNKNOWN;
		}
		
		for(Mode mode : Mode.values()) {
			if(mode.modeName.equals(mode_name))
					this.mode=mode;
					return;
				}
		throw new GameException("Brak takiego trybu");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	
	public Game(String title,String publisher, String developer,Platform platform,int realise,Genre genre, Mode mode, int number) {
		this.title=title;
		this.platform=platform;
		this.genre=genre;
		this.number=number;
		this.publisher=publisher;
		this.developer=developer;
		this.realise=realise;
		this.mode=mode;
		
	}
	
	public Game(String title) {
		this.title=title;
		this.platform=Platform.UNKNOWN;
		this.genre=Genre.UNKNOWN;
		this.mode=Mode.UNKNOWN;
		
	}
	
	public static void printToFile(PrintWriter writer,Game game) {
		writer.println(game.title+"#"+game.developer+"#"+game.publisher+"#"+game.platform+"#"+game.realise+"#"+
						game.genre+"#"+game.mode+"#"+game.number);
	}
	
	public static void printToFile(String file_name, Game game) throws GameException, FileNotFoundException {
		try(PrintWriter writer=new PrintWriter(file_name)){
			printToFile(writer,game);}
		}
				
	
	public static Game readFromFile(BufferedReader reader) throws IOException, GameException {
		String line=reader.readLine();
		String txt[]=line.split("#");
		Game game= new Game(txt[0]);
		game.setDeveloper(txt[1]);
		game.setPublisher(txt[2]);
		game.setPlatform(txt[3]);
		game.setRealise(Integer.parseInt(txt[4]));
		game.setGenre(txt[5]);
		game.setMode(txt[6]);
		game.setNumber(Integer.parseInt(txt[7]));
		return game;
	}
	
	public static Game readFromFile(String fileName) throws IOException, GameException {
		BufferedReader reader= new BufferedReader(new FileReader (new File (fileName)));
		return Game.readFromFile(reader);
	}
	
	
	
	
}
