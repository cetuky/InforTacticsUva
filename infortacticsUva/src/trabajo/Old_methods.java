package trabajo;

public class Old_methods {
	//V1Método que recibe una matriz con el personaje que hay en cada casilla e imprime el tablero por pantalla.
	public static void printBoard(char[][]pos) {
	int nfil=pos.length; int ncol=pos[0].length;
	System.out.println("TABLERO\n");
	System.out.println("    0   1   2   3   4   5");
	for(int fil=0;fil<nfil;fil++) {
		System.out.println("   ——— ——— ——— ——— ——— ———");
		System.out.print(fil);
		for(int col=0;col<ncol;col++) {
			System.out.print(" | "+pos[fil][col]);
		}
		System.out.println(" |");
	}
	System.out.println("   ——— ——— ——— ——— ——— ———");
}

	//V2Método que recibe una matriz con el personaje que hay en cada casilla e imprime el tablero por pantalla.
		public static void printBoard(char[][]pos) {
			int nfil=pos.length; int ncol=pos[0].length;
			System.out.println("TABLERO\n");
			System.out.print(" ");
			for(int cont=0;cont<nfil;cont++)
				System.out.print("   "+cont);
			System.out.println();
			for(int fil=0;fil<nfil;fil++) {
				System.out.print("  ");
				for(int cont=0;cont<nfil;cont++)
					System.out.print(" ———");
				System.out.println();
				System.out.print(fil);
				for(int col=0;col<ncol;col++) {
					System.out.print(" | "+pos[fil][col]);
				}
				System.out.println(" |");
			}
			System.out.print("  ");
			for(int cont=0;cont<nfil;cont++)
				System.out.print(" ———");
			System.out.println();
		}
		
		//Método que sirve para inicializar la matriz al inicio del juego, cuando no hay personajes en el tablero
		public static void inicializaMatriz(char[][]matriz) {
			int nfil=matriz.length; int ncol=matriz[0].length;
			for(int fil=0;fil<nfil/2;fil++)
				for(int col=0;col<ncol;col++)
					matriz[fil][col]=Assets.NO_POSITION;
			for(int fil=nfil/2;fil<nfil;fil++)
				for(int col=0;col<ncol;col++)
					matriz[fil][col]=' ';
		}
		
		char[][]tablero=new char[Assets.BOARD_ROWS][Assets.BOARD_COLUMNS];
}


