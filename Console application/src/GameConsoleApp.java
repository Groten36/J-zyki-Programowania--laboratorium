import java.io.IOException;

public class GameConsoleApp {

	ConsoleUserDialog UI= new ConsoleUserDialog();
	
	private static final String MENU=
			"MENU GLOWNE:\n"+
			"1.Dodaj gre\n"+
			"2.Zmodyfikuj gre\n"+
			"3.Usun gre\n"+
			"4.Wczytaj gre z pliku\n"+
			"5.Zapisz gre do pliku\n"+
			"6.Wyswietl dane gry\n"+
			"7.Wyjdz\n";
	
	private static final String CHANGE_MENU=
			"Wybierz dana do zmiany:\n"+
			"1.Tytul\n"+
			"2.Deweloper\n"+
			"3.Wydawca\n"+
			"4.Rok wydania\n"+
			"5.Platforma\n"+
			"6.Gatunek\n"+
			"7.Tryb\n"+
			"8.Ilosc sztuk"+
			"9.Cofnij";
	
	Game currentGame=null;
	public static void main(String[] args) throws IOException, GameException {
		// TODO Auto-generated method stub
		GameConsoleApp app=new GameConsoleApp();
		app.Menu();
	}

	public  void Menu() throws IOException, GameException {
		while(true) {
			UI.clearConsole();
			UI.printMessage(MENU);
			switch(UI.enterInt("Menu-->")) {
			case 1: currentGame=addGame(); break;
			case 2: changeGame(currentGame); break;
			case 3: currentGame=null; break;
			case 4: currentGame=Game.readFromFile("Gry.txt"); break;
			case 5: currentGame.printToFile("Gry.txt", currentGame); break;
			case 6: showGame(currentGame);break;
			case 7: System.exit(0);
				
			}
		}
	}

	
	private void showGame(Game game) {
		// TODO Auto-generated method stub
		System.out.println(
				"Tytul gry: "+game.getTitle()+
				"\nDeweloper: "+game.getDeveloper()+
				"\nWydawca: "+game.getPublisher()+
				"\nRok wydania: "+game.getRealise()+
				"\nPlatforma: "+game.getPlatform()+
				"\nGatunek: "+game.getGenre()+
				"\nTryb: "+game.getMode()+
				"\nIlosc sztuk: "+game.getNumber());
		
	}

	private void changeGame(Game game) throws GameException {
		// TODO Auto-generated method stub
		UI.printMessage(CHANGE_MENU);
		switch(UI.enterInt("Wybór-->")) {
		case 1:game.setTitle(UI.enterString("Nowy tytul:"));		break;
		case 2:game.setDeveloper(UI.enterString("Nowy deweloper:"));break;
		case 3:game.setPublisher(UI.enterString("Nowy wydawca:"));	break;
		case 4:game.setRealise(UI.enterInt("Nowy rok wydania:"));	break;
		case 5:game.setPlatform(UI.enterString("Nowa platforma:"));	break;
		case 6:game.setGenre(UI.enterString("Nowy gatunek:"));		break;
		case 7:game.setMode(UI.enterString("Nowy tryb:"));			break;
		case 8:game.setNumber(UI.enterInt("Nowa ilosc sztuk:"));	break;
		case 9:return;
		}
		
	}

	private Game addGame() throws GameException {
		// TODO Auto-generated method stub
		String title=UI.enterString("Podaj tytul:");
		String developer=UI.enterString("Podaj dewelopera:");
		String publisher=UI.enterString("Podaj wydawce:");
		int realise=UI.enterInt("Podaj rok wydania:");
		String platform=UI.enterString("Podaj paltforme:");
		String genre=UI.enterString("Podaj gatunek:");
		String mode=UI.enterString("Podaj tryb:");
		int number=UI.enterInt("Podaj ilosc sztuk:");
		
		
		Game game= new Game(title);
		game.setDeveloper(developer);
		game.setPublisher(publisher);
		game.setRealise(realise);
		game.setPlatform(platform);
		game.setGenre(genre);
		game.setMode(mode);
		game.setNumber(number);
		return game;
	}
}
