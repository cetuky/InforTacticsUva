package trabajo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		char [][]prueba = {{'a','b','c','d','e','f'},{'a','b','c','d','e','f'},{'a','b','c','d','e','f'},{'a','b','c','d','e','f'},{'a','b','c','d','e','f'},{'a','b','c','d','e','f'}};
		char [][]prueba2 = {{'a','b','c'},{'d','e','f'},{'g','h','i'}};
		String []prueba3 = {"A01","G14","K22",""} ;
		char a;
		int valor=1;
		int barajas = 0;
		int nbaraja = 0;
//		Old_methods.inicializaMatriz(prueba);
//		Old_methods.printBoard(prueba);
//		InfortacticsUVa.printTroops();
//		InfortacticsUVa.printElixir(6);
		//Methods.initializeDeck(prueba3);
//		InfortacticsUVa.printBoard(prueba3);
//		for(int i=0;i<prueba3.length;i++)
//		System.out.print(prueba3[i].charAt(0));
//		a = (char)(valor+'0');
//		System.out.print(a);
//		System.out.println(InfortacticsUVa.checkTroop('A'));
//		InfortacticsUVa.addTroop(prueba3, 'A', "02");
//		for(int c=0;c<prueba3.length;c++)
//			System.out.print(InfortacticsUVa.invalidPos("31"));
//		System.out.print(InfortacticsUVa.occupiedPos(prueba3,"01"));
//		System.out.print(0+'1');
		try {
			//Abro un Scanner para contar cuántas barajas tiene el fichero BarajasEnemigas.txt
			Scanner count = new Scanner(new File("Barajas/BarajasEnemigas.txt"));
			while(count.hasNextLine()) {
				barajas++;
				count.nextLine();
			}
			count.close();
			
			//Abro otro Scanner para elegir una baraja aleatoria del fichero BarajasEnemigas.txt
			Scanner read = new Scanner(new File("Barajas/BarajasEnemigas.txt"));
			nbaraja = (int)(Math.random()*barajas);
			for(int fila=0;fila<nbaraja;fila++)
				read.nextLine();
		} catch	(FileNotFoundException e){
			System.out.println("****Ha habido un error al cargar la baraja enemiga****");
		}finally {
			System.out.println(barajas);
		}
	}

}
