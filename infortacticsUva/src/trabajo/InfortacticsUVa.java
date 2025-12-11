package trabajo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class InfortacticsUVa {

	/**
	 * Método que sirve para imprimir el menú del juego.
	 */
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

	/**
	 * //Método que recibe un vector con la posición de cada personaje e imprime el tablero por pantalla.
	 * @param gameDeck
	 */
	public static void printBoard(String[]gameDeck) {	
		int nfil=Assets.BOARD_ROWS; int ncol=Assets.BOARD_COLUMNS;
		char simbolo;
		String imagen;

		//Inicio cabecera
		System.out.println("TABLERO\n");
		System.out.print("X\\Y");
		for(int cont=0;cont<nfil;cont++)
			System.out.print(" "+cont+"   ");
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

	/**
	 * Método que dado el símbolo de un personaje, devuelve su imagen
	 * @param simbolo
	 * @return
	 */
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

	/**
	 * Método que dado el símbolo de un personaje, devuelve su nombre
	 * @param simbolo
	 * @return
	 */
	public static String getName(char simbolo) {
		String name="";
		switch(simbolo) {
		case 'A': 	name=Assets.ARCHER_NAME;break;
		case 'D': 	name=Assets.DRAGON_NAME;break;
		case 'P': 	name=Assets.PRINCESS_NAME;break;
		case 'V': 	name=Assets.VALKYRIE_NAME;break;
		case 'G': 	name=Assets.GOBLIN_NAME;break;
		case 'K': 	name=Assets.PK_NAME;break;
		}
		return name;
	}

	/**
	 * Método que dado el símbolo de un personaje, devuelve su coste de elixir
	 * @param simbolo
	 * @return
	 */
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

	/**
	 * Método que verifica el vector,para controlar que cada String tiene 3 posiciones
	 * @param deck
	 * @return
	 */
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
	
	/**
	 * Método sobrecargado, para permitir comprobar un vector copiado en un String
	 * @param troop
	 * @return
	 */
	public static boolean checkDeck(String troop) {
		boolean error = false;
		if(troop.length()==3) {
			if(checkTroop(troop.charAt(0))) {
				String pos = ""+troop.charAt(1)+troop.charAt(2);
				if(outBoard(pos))
					error=true;
			}else error=true;
		} else error=true;
		return !error;
	}

	/**
	 * Método que comprueba si una baraja está vacía
	 * PRE: baraja con formato válido
	 * @param deck
	 * @return
	 */
	public static boolean emptyDeck(String[]deck) {
		int nStr=0;
		boolean result=true;
		while ((nStr<deck.length)) {
			if(deck[nStr].length()!=0)
				result=false;
			nStr++;
		}
		return result;
	}

	/**
	 * Método que comprueba que el char que le entregamos se corresponde con algún personaje
	 * @param troop
	 * @return
	 */
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


	/**
	 * Método que muestra los personajes seleccionables
	 */
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

	/**
	 * Método que imprime en pantalla el elixir restante
	 * @param elixir
	 */
	public static void printElixir(int elixir) {
		System.out.println("Elixir Restante 🔥: "+elixir);
	}


	/**
	 * Método que comprueba si ya hay alguna tropa en una posición específica
	 * False = posición no ocupada
	 *	True = posición ocupada
	 * @param deck
	 * @param pos
	 * @return result
	 */

	public static boolean occupiedPos(String[]deck, String pos) {
		boolean result=false;
		for(int cont=0;cont<deck.length;cont++)
			if(deck[cont].length()>0) {
				if((deck[cont].charAt(1)==pos.charAt(0))&&(deck[cont].charAt(2)==pos.charAt(1)))
					result=true;
			}
		return result;
	}
	
	/**
	 * Método que comprueba si la posición introducida está en los límites del tablero
	 * @param pos
	 * @return
	 */
	public static boolean outBoard(String pos) {
		boolean result=false;
		if ((pos.length()!=2)||((pos.charAt(0)-'0'>=Assets.BOARD_ROWS)||(pos.charAt(0)-'0'<0))||
				((pos.charAt(1)-'0'<0)||(pos.charAt(1)-'0'>=Assets.BOARD_COLUMNS)))
			result=true;
		return result;
	}

	/**
	 * Método que comprueba si la posición introducida es válida
	 * true = inválida
	 * false = válida
	 */
	public static boolean invalidPos(String pos) {
		boolean result=false;
		if ((pos.length()!=2)||((pos.charAt(0)-'0'<Assets.BOARD_ROWS/2)||(pos.charAt(0)-'0'>=Assets.BOARD_ROWS))||
				((pos.charAt(1)-'0'<0)||(pos.charAt(1)-'0'>=Assets.BOARD_COLUMNS)))
			result=true;
		return result;
	}
	
	/**
	 * Método que comprueba si la posición introducida es válida para la baraja enemiga
	 * true = inválida
	 * false = válida
	 */
	public static boolean invalidEnemyPos(String pos) {
		boolean result=false;
		if ((pos.length()!=2)||((pos.charAt(0)-'0'>Assets.BOARD_ROWS/2)||(pos.charAt(0)-'0'<0))||
				((pos.charAt(1)-'0'<0)||(pos.charAt(1)-'0'>=Assets.BOARD_COLUMNS)))
			result=true;
		return result;
	}

	/**
	 * Método para introducir una nueva tropa en el vector
	 * @param deck
	 * @param troop
	 * @param pos
	 */
	public static void addTroop(String[]deck,char troop,String pos) {
		int cont=0;
		while((cont<deck.length)&&(deck[cont].length()>0))
			cont++;
		deck[cont]=(troop+pos);
	}

	/**
	 * Método para eliminar una tropa del vector
	 * @param deck
	 * @param pos
	 */
	public static void removeTroop(String[]deck,String pos) {
		int cont=0;
		boolean samepos=false;
		while((cont<deck.length)&&(!samepos)) {
			if(deck[cont].length()>0) {
				if((deck[cont].charAt(1)==pos.charAt(0))&&(deck[cont].charAt(2)==pos.charAt(1)))
					samepos=true;
			}
			if(!samepos)
				cont++;
		}
		if(cont<deck.length)
			deck[cont]="";
	}

	public static void showDeck(String[]deck) {
		String image, name;
		int posx,posy;
		for(int pos=0;pos<deck.length;pos++) {
			if(deck[pos]!="") {
				image=getImage(deck[pos].charAt(0));
				name=getName(deck[pos].charAt(0));
				posx=deck[pos].charAt(1)-'0';
				posy=deck[pos].charAt(2)-'0';
				System.out.println(image+" "+name+" en la posición ["+posx+","+posy+"]");
			}
		}
	}

	/**
	 * Método que devuelve el elixir de la tropa en la pos. XY del vector
	 * @param deck
	 * @param pos
	 * @return
	 */
	public static int returnElixir(String[]deck,String pos) {
		int cont=0;
		int elixir=0;
		boolean samepos=false;
		while((cont<deck.length)&&(!samepos)) {
			if(deck[cont].length()>0) {
				if((deck[cont].charAt(1)==pos.charAt(0))&&(deck[cont].charAt(2)==pos.charAt(1)))
					samepos=true;
			}
			if(!samepos)
				cont++;
		}
		if(cont<deck.length)
			elixir=getElixir(deck[cont].charAt(0));
		return elixir;
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

		//Intento abrir el fichero BarajasEnemigas.txt (en caso de que este exista)

		while(invalido) {
			printMenu();
			opc = in.next();
			switch(opc){
			case "1": 	
				Methods.flushScreen();
				if(!emptyDeck(playerDeck)) {
					int barajas = 0;
					int nbaraja=0;
					try {
						//Abro un Scanner para contar cuántas barajas tiene el fichero BarajasEnemigas.txt
						Scanner count = new Scanner(new File("Barajas/BarajasEnemigas.txt"));
						while(count.hasNextLine()) {
							barajas++;
							count.nextLine();
						}
						count.close();

						String selectedDeck;
						//Abro otro Scanner para elegir una baraja aleatoria del fichero BarajasEnemigas.txt
						Scanner read = new Scanner(new File("Barajas/BarajasEnemigas.txt"));
						nbaraja = (int)(Math.random()*barajas);
						for(int fila=0;fila<nbaraja;fila++)
							read.nextLine();
						selectedDeck = read.nextLine();
						read.close();
						//La baraja enemiga está copiada en selectedDeck
						//Copiamos la baraja enemiga en el vector y comprobamos que la baraja sea válida
						Scanner check = new Scanner(selectedDeck);
						boolean valid = true;
						int pos = 0;
						while((check.hasNext())&&(valid)&&(pos < playerDeck.length)) {
							String nextTroop = check.next();
							String position = ""+nextTroop.charAt(1)+nextTroop.charAt(2);
							if(!invalidEnemyPos(position)){
								if(!occupiedPos(enemyDeck, position)) {
									if(!checkDeck(nextTroop))
										valid = false;
								}
								else
									valid = false;
							}
							else
								valid = false;
							enemyDeck[pos]=nextTroop;
							pos++;
						}
						check.close();
						System.out.println("El enemigo juega con:");
						showDeck(enemyDeck);
						Methods.startGame(in, playerDeck, enemyDeck);
					} catch	(FileNotFoundException e){
						System.out.println("****Ha habido un error al cargar la baraja enemiga****");
					} 
				}
				else
					System.out.println("****Tienes que configurar tu baraja antes****");
				break;
			case "2":	
				char troop=' ';
				Methods.flushScreen();
				do {
					if(!checkDeck(playerDeck)) {
						Methods.flushScreen();
						System.out.println("****Su mazo guardado es inválido****");
						System.out.println("****Cree un nuevo mazo válido****");
						Methods.initializeDeck(playerDeck);
						elixir = Assets.INITIAL_ELIXIR;
					}
					boolean validtroop, validpos;
					String pos;
					int troopelixir=0;
					do {
						//pregunta tropa
						do {
							Methods.createGameDeck(playerDeck, enemyDeck, gameDeck);
							printBoard(gameDeck);
							System.out.println();
							printTroops();
							System.out.println();
							printElixir(elixir);
							System.out.println("Personaje a añadir (x para borrar; 0 para guardar)");
							String add = in.next();
							troop = add.charAt(0);
							if((!checkTroop(troop))&&(troop!='0')&&(troop!='x')) {
								validtroop=false;
								Methods.flushScreen();
								System.out.println("****Introduzca un Símbolo válido****");
							}
							else {
								validtroop=true;
								if((troop!='0')&&(troop!='x'))
									troopelixir= getElixir(troop);
								if((troop=='0')||(troop=='x'))
									troopelixir=0;
							}
						}while(!validtroop);

						if(elixir<troopelixir) {
							Methods.flushScreen();
							System.out.println("****¡No tienes suficiente elixir!****");
						}
					}while(elixir<troopelixir);


					//Comprobar que la posición es válida
					if(troop!='0') {
						do {
							System.out.println("Introduzca la posición XY de la tropa que desea introducir/eliminar");
							pos=in.next();
							if(invalidPos(pos)) {
								System.out.println("Posición inválida");
								validpos=false;
							}else if((occupiedPos(playerDeck,pos))&&(troop!='x')){
								System.out.println("Posición ocupada por otra tropa");	
								validpos=false;
							}else {
								validpos=true;
							}
						}while(!validpos);
						if(troop=='x') {
							elixir += returnElixir(playerDeck,pos);
							removeTroop(playerDeck,pos);
							Methods.flushScreen();
						}
						else {
							addTroop(playerDeck,troop,pos);
							elixir -= troopelixir;
							Methods.flushScreen();
						}
					}
					Methods.createGameDeck(playerDeck, enemyDeck, gameDeck);
				}while(troop!='0');
				Methods.flushScreen();							
				break;
			case "3":	
				Methods.flushScreen();
				try {
					PrintWriter guardar = new PrintWriter("Barajas/BarajaGuardada.txt");
					for(int pos=0;pos<playerDeck.length;pos++) {
						if(playerDeck[pos].length()!=0) {
							guardar.print(playerDeck[pos]+" ");
						}
					}
					System.out.println("****Su baraja se ha guardado con éxito****");
					guardar.close();
				}catch(FileNotFoundException e) {
					System.out.println("****Ha habido un problema al guardar la baraja****");
				}

				break;
			case "4":	
				Methods.flushScreen();
				try {
					//Lee el fichero e inicializa mazo y elixir
					Scanner leer = new Scanner(new File("Barajas/BarajaGuardada.txt"));
					Methods.initializeDeck(playerDeck);
					int pos=0;
					elixir = Assets.INITIAL_ELIXIR;
					boolean valid = true;
					//Copia los valores mientras el formato de la baraja sea correcto
					while((leer.hasNext())&&(valid)&&(pos < playerDeck.length)) {
						String nextTroop = leer.next();
						String position = ""+nextTroop.charAt(1)+nextTroop.charAt(2);
						if(!invalidPos(position)){
							if(!occupiedPos(playerDeck,position)) {
								if(!checkDeck(nextTroop))
									valid = false;
							}
							else
								valid = false;
						}
						else
							valid = false;
						playerDeck[pos]=nextTroop;
						pos++;
						elixir -= getElixir(nextTroop.charAt(0));
					}
					leer.close();
					//Si el formato no es correcto resetea el mazo y el elixir
					if(!valid) {
						System.out.println("****La baraja guardada está corrompida****");
						Methods.initializeDeck(playerDeck);
						elixir = Assets.INITIAL_ELIXIR;
					}
					else {
						System.out.println("****La baraja se ha cargado exitosamente****");
						Methods.createGameDeck(playerDeck, enemyDeck, gameDeck);
					}
				}catch(FileNotFoundException e) {
					System.out.println("****Ha habido un problema al cargar la baraja****");
				}
				break;
			case "5":	
				invalido=false;
				Methods.flushScreen();
				System.out.println("¡Hasta la próxima!");
				break;


			default:	
				Methods.flushScreen();
				System.out.println("****Opción no válida****");
			}
		}

	}

}