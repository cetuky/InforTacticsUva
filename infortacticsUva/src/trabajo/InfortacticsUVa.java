package trabajo;
import java.util.Scanner;

public class InfortacticsUVa {
	
	//Método que sirve para imprimir el menú del juego.
	public static void printMenu() {
		System.out.println("  🏰 InforTactics UVa 🏰");
		System.out.println("·------------------------·");
		System.out.println("| 1. Nueva Partida       |");
		System.out.println("| 2. Configurar Baraja   |");
		System.out.println("| 3. Guardar Baraja      |");
		System.out.println("| 4. Cargar Baraja       |");
		System.out.println("| 5. Salir               |");
		System.out.println("·------------------------·");
		System.out.print("Opción: ");
	}
	
	//Método que recibe un vector con la posición de cada personaje e imprime el tablero por pantalla.
	public static void printBoard(String[]gameDeck) {	
		int nfil=Assets.BOARD_ROWS; int ncol=Assets.BOARD_COLUMNS;
		char simbolo;
		String imagen;
		
		//Inicio cabecera
		System.out.println("TABLERO\n");
			for(int cont=0;cont<nfil;cont++)
				System.out.print("    "+cont);
			System.out.println();
		//Fin cabecera
			
			//Recorre todas las filas
			for(int fil=0;fil<nfil;fil++) {
				System.out.print("  ");
				//Linea separadora de cada fila
				for(int cont=0;cont<nfil;cont++)
					System.out.print(" ————");	
				System.out.println();
				System.out.print(fil);
				//Recorre cada posición de cada fila
				for(int col=0;col<ncol;col++) {
					//Inicializa imagen en vacío
					if (fil<nfil/2)
						imagen=""+Assets.NO_POSITION+Assets.NO_POSITION;
						else
						imagen="  ";
					//Busca en todo el vector
					for(int i=0; i < gameDeck.length; i++) {
						if(gameDeck[i].length()!=0) {
							int filCarta = gameDeck[i].charAt(1) - '0'; 
							int colCarta = gameDeck[i].charAt(2) - '0';
							
							if((filCarta==fil)&&(colCarta==col)) {
								simbolo = gameDeck[i].charAt(0);
								imagen = getImage(simbolo);		
							}
						}
					}
				System.out.print(" | "+imagen);
			}
			System.out.println(" |");
		}
		System.out.print("  ");
		for(int cont=0;cont<nfil;cont++)
			System.out.print(" ————");
			System.out.println();
	}
	
	public static String getImage(char simbolo) {
		String imagen="";
		switch(simbolo) {
		case 'A': 	imagen=Assets.ARCHER_IMAGE;break;
		case 'D': 	imagen=Assets.DRAGON_IMAGE;break;
		case 'P': 	imagen=Assets.PRINCESS_IMAGE;break;
		case 'V': 	imagen=Assets.VALKYRIE_IMAGE;break;
		case 'G': 	imagen=Assets.GOBLIN_IMAGE;break;
		case 'K': 	imagen=Assets.PK_IMAGE;break;
		}
		return imagen;
	}
	
	public static int getElixir(char simbolo) {
		int elixir=0;
		switch(simbolo) {
		case 'A': 	elixir=Assets.ARCHER_ELIXIR;break;
		case 'D': 	elixir=Assets.DRAGON_ELIXIR;break;
		case 'P': 	elixir=Assets.PRINCESS_ELIXIR;break;
		case 'V': 	elixir=Assets.VALKYRIE_ELIXIR;break;
		case 'G': 	elixir=Assets.GOBLIN_ELIXIR;break;
		case 'K': 	elixir=Assets.PK_ELIXIR;break;
		}
		return elixir;
	}
	
	//Método que verifica el vector ,para controlar que cada String tiene 3 posiciones
	public static boolean checkDeck(String[]deck) {
		int nStr=0;
		boolean result=true;
		while ((nStr<deck.length)&&(result==true)) {
			if((deck[nStr].length()!=0)&&(deck[nStr].length()!=3))
				result=false;
			nStr++;
		}
		return result;
	}
	
	//Método que comprueba que el char que le entregamos se corresponde con algún personaje
	public static boolean checkTroop(char troop) {
		boolean result=false;
		switch(troop) {
		case 'A':
		case 'D':
		case 'P':
		case 'V':
		case 'G':
		case 'K':
			result=true;
		}
		return result;
	}

	
	//Método que muestra los personajes seleccionables
	public static void printTroops() {
		System.out.println("Personaje      Símb.  Elixir  %Ataque  %Defensa");
		System.out.println("-----------------------------------------------");
		System.out.println(Assets.ARCHER_IMAGE+Assets.ARCHER_NAME+"      "+Assets.ARCHER_SYMBOL+"      "
		+Assets.ARCHER_ELIXIR+"       "+ Assets.ARCHER_ATTACK+"       "+Assets.ARCHER_DEFENSE);
		System.out.println(Assets.DRAGON_IMAGE+Assets.DRAGON_NAME+"       "+Assets.DRAGON_SYMBOL+"      "
		+Assets.DRAGON_ELIXIR+"       "+ Assets.DRAGON_ATTACK+"       "+Assets.DRAGON_DEFENSE);
		System.out.println(Assets.PRINCESS_IMAGE+Assets.PRINCESS_NAME+"     "+Assets.PRINCESS_SYMBOL+"      "
				+Assets.PRINCESS_ELIXIR+"       "+ Assets.PRINCESS_ATTACK+"       "+Assets.PRINCESS_DEFENSE);
		System.out.println(Assets.VALKYRIE_IMAGE+Assets.VALKYRIE_NAME+"    "+Assets.VALKYRIE_SYMBOL+"      "
				+Assets.VALKYRIE_ELIXIR+"       "+ Assets.VALKYRIE_ATTACK+"       "+Assets.VALKYRIE_DEFENSE);
		System.out.println(Assets.GOBLIN_IMAGE+Assets.GOBLIN_NAME+"       "+Assets.GOBLIN_SYMBOL+"      "
				+Assets.GOBLIN_ELIXIR+"       "+ Assets.GOBLIN_ATTACK+"       "+Assets.GOBLIN_DEFENSE);
		System.out.println(Assets.PK_IMAGE+Assets.PK_NAME+"    "+Assets.PK_SYMBOL+"      "
				+Assets.PK_ELIXIR+"       "+ Assets.PK_ATTACK+"       "+Assets.PK_DEFENSE);
		System.out.println("-----------------------------------------------");
	}
	
	//Método que imprime en pantalla el elixir restante
	public static void printElixir(int elixir) {
	System.out.println("Elixir Restante 🔥: "+elixir);
	}

	
	public static void main(String[] args) {
		String[] playerDeck = new String[(Assets.BOARD_ROWS/2)*Assets.BOARD_COLUMNS];
		String[] enemyDeck = new String[(Assets.BOARD_ROWS/2)*Assets.BOARD_COLUMNS];
		String[] gameDeck = new String[Assets.BOARD_ROWS*Assets.BOARD_COLUMNS];
		int elixir=Assets.INITIAL_ELIXIR;
		String opc;
		boolean invalido=true;
		Scanner in = new Scanner(System.in);
		Methods.initializeDeck(playerDeck);
		Methods.initializeDeck(enemyDeck);
		Methods.createGameDeck(playerDeck, enemyDeck, gameDeck);
		
		
				
		while(invalido) {
			Methods.flushScreen();
			printMenu();
			opc = in.next();
			switch(opc){
			case "1": 	invalido=false;
						Methods.flushScreen();
						break;
			case "2":	if(checkDeck(gameDeck)) {
							invalido=false; 
							char troop;
							do {
								do {
									Methods.flushScreen();
									printBoard(gameDeck);
									System.out.println();
									printTroops();
									System.out.println();
									printElixir(elixir);
									System.out.println("Personaje a añadir (x para borrar; 0 para guardar)");
									String add = in.next();
									troop = add.charAt(0);
									if(!checkTroop(troop))
										Methods.flushScreen();
										System.out.println("Introduzca un Símbolo válido");
								}while((!checkTroop(troop))&&(troop!=0)&&(troop!='x'));
								if(elixir<getElixir(troop))
									Methods.flushScreen();
									System.out.println("¡No tienes suficiente elixir!");
							}while(elixir<getElixir(troop));
						}
						else {
							Methods.flushScreen();
							System.out.println("Su mazo es inválido");
						}
						
						break;
			case "3":	invalido=false;
						Methods.flushScreen();
						break;
			case "4":	invalido=false;
						Methods.flushScreen();
						break;
			case "5":	invalido=false;
						Methods.flushScreen();
						System.out.println("¡Hasta la próxima!");
						break;
			default:	System.out.println("Opción no válida");
			}
		}
		
	}

}