package enfonsarlaflota;
import java.util.Scanner;
import java.util.Random;
/**
 * <h2>Clase Entradas, conte tots els method que permeten i gestionen la entrada de dades al programa per teclat</h2>
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class Entradas {
	/**
	 * Atribut reader que permet la llectura de dades per teclat.
	 */
	final static Scanner reader = new Scanner (System.in);
	/**
	 * Atribut rnd que permet la generacio aleatoria de numeros enters.
	 */
	final static Random rnd = new Random();
	/**
	 * Method <b>genRandom</b>, permet la generacio aleatoria de numeros enters de 0 a la mida del taulell - 1.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @return Retorna un numero enter.
	 */
	public static int genRandom(int TAB) {
		int input;
		input = rnd.nextInt(TAB);
		return input;
	}
	/**
	 * Method <b>charUser</b>, filtra la entrada de un caracter per teclat.
	 * @param output String que enviara al Method que permet la entrada de dades al programa.
	 * @return Retorna un caracter llegit per teclat.
	 */
	public static char charUser(String output) {
		char res;
		do {
			res = inpChar(output);
		}while(res != 'n' && res != 'N' && res != 'S' && res != 's');
		return res;
	}
	/**
	 * Method <b>inpChar</b>, permet la entrada de caracters per teclat, concretament la resposta a una pregunta.
	 * @param output String que mostrara per consola habans de la entrada de dades.
	 * @return Retorna un caracter al Method que la cridat.
	 */
	public static char inpChar(String output) {
		boolean ok = false;
		char input = 'A';
		
		do {
			System.out.print("Vols sortir  " + output);
			try {
				input = reader.next().charAt(0);
				ok = true;
			}
			catch (Exception e) {
				System.out.println("Nomes és permeten caracters.");
				reader.nextLine();
			}
		}while(ok != true);
		return input;
	}
	/**
	 * Method <b>inpInt</b>, permet la entrada de numeros enters per teclat.
	 * @param output String que mostrara per consola havans de la entrada de dades.
	 * @return Retorna un numero enter al Method que la cridat.
	 */
	public static int inpInt(String output) {
		boolean ok = false;
		int input = 0;
		do {
			System.out.print(output);
			try {
				input = reader.nextInt();
				ok = true;
			}
			catch (Exception e) {
				System.out.println("Nomes és permeten numeros enters. ");
				reader.nextLine();
			}
		}while(ok != true);
		return input;
	}
	/**
	 * Method <b>inpCharFil</b> "input char Fila" permet la entrada de la fila per teclat.
	 * @param output  String que mostrara habans de permetre la entrada de dades per teclat.
	 * @return Retorna el caracter introduit per teclat.
	 */
	public static char inpCharFil(String output) {
		boolean ok = false;
		char input = 'A';
		do {
			System.out.print(output);
			try {
				input = reader.next().charAt(0);
				ok = true;
			}
			catch(Exception e) {
				System.out.println("Error, nomes es permeten lletres. ");
				reader.nextLine();
			}
		}while (ok != true);
		return input;
	}
	/**
	 * Method <b>inpColUser</b> "Input Columna User", comprova que la entrada de les dades es coorecte.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @return Retorna un numero enter al Method que la cridat.
	 */
	public static int inputColUser (int TAB) {
		int resp;
		boolean ok = false;
		do {
			resp = inpInt("Introdueix la Columna: (0-9)");	
			if (resp >= 0 && resp <= TAB - 1) ok = true;
		}while (ok != true);
		return resp;
	}
	/**
	 * Method <b>inputFilaUser</b> "Input Fila User", comprova que la entrada de les dades es coorecte.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @return Retorna un numero enter que indica la fila del taulell escollida per l'usuari.
	 */
	public static int inputFilaUser(int TAB) {
		char resp;
		boolean ok = false;
		int num = 0;
		do {
			resp = inpCharFil("Introdueix la lletra de la Fila: ");
			if ((resp >= 'A' && resp <= 'J') || (resp >= 'a' && resp <= 'j')) ok = true;
		}while(ok != true);
		switch (resp) {
		case 'A':
		case 'a':
			num = 0;
			break;
		case 'B':
		case 'b':
			num = 1;
			break;
		case 'C':
		case 'c':
			num = 2;
			break;
		case 'D':
		case 'd':
			num = 3;
			break;
		case 'E':
		case 'e':
			num = 4;
			break;
		case 'F':
		case 'f':
			num = 5;
			break;
		case 'G':
		case 'g':
			num = 6;
			break;
		case 'H':
		case 'h':
			num = 7;
			break;
		case 'I':
		case 'i':
			num = 8;
			break;
		case 'J':
		case 'j':
			num = 9;
			break;
		}
		return num;
	}
	/**
	 * Method <b>inputDirUser</b> "Input Direction User", comprova que la entrada de dades es coorecte.
	 * @return Retorna un numero enter que indica la direcció cap a on s'orientara el baixell.
	 */
	public static int inputDirUser() {
		boolean ok = false;
		int input;
		
		do {
			input = inpInt("Introdueix la direcció cap a on vols que es direccioni el baixell: \n0: Dreta, 1: Esquerra, 2: Cap Abaix, 3: Cap Adalt.");
			if (input >= 0 && input <= 3) ok = true;
		}while(ok != true);
		return input;
	}
}
