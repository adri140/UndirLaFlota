package enfonsarlaflota;

/**
 * <h2>Clase Joc, Inicialitza el joc i indica el jugador que jugara.</h2>
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */

public class Joc {
	/**
	 * Method Joc, genera els taulells i crida a les funcions que els inicialitzen.
	 * Un cop inicialitsats els taulells crida a la funcio <b>jugar</b> per començar el joc.
	 */
	public static void joc() {
		char[][] jug1Sol, jug1Secret; //Jugador (Sol = Visible Secret = Secreta)
		char[][] maq1Sol, maq1Secret; //Maquina (Sol = Visible Secret = Secreta)
		int[] memoria = new int [2]; //memoria de la inteligencia artificial [0] = fila [1] = col
		char resp;
		int TAB = 10;
		boolean ok = false;
		
		jug1Sol = new char [TAB][TAB];
		jug1Secret = new char [TAB][TAB];
		maq1Sol = new char [TAB][TAB];
		maq1Secret = new char [TAB][TAB];
		
		IniMatrizes.inicializarSol(jug1Sol, TAB, '?'); //A de aigua
		IniMatrizes.inicializarSol(maq1Sol, TAB, '?'); //A de aigua
		IniMatrizes.inicializarMaqSecret(maq1Secret, TAB, 'B'); //B de baixell
		IniMatrizes.inicializarUserSecret(jug1Secret, TAB, 'B', 'A');
		
		do {
			ok = jugar(jug1Sol, jug1Secret, maq1Sol, maq1Secret, TAB, memoria);
			if (ok != true) {
				resp = Entradas.charUser("de la partida: ");
			}
			else {
				resp = 's';
			}
		}while(resp != 'S' && resp != 's' && ok != true);//tmp
	}
	
	/**
	 * Method <b>Jugar</b> gestiona els torns dels jugadors, aixi com la crida a les funcions que permeten visualitzar els taulells i les funcions de tirades.
	 * @param maq1Sol Taulell que pot veure tot el mon.
	 * @param maq1Secret Taulell que oculta la solucio del joc, generat per la maquina.
	 * @param TAB Indica l'amplada i la alçada del taulell.
	 * @param memoria
	 * @return Retorna un boolean:
	 * 		<ul>
	 * 			<li>True: Fi de la partida</li>
	 * 			<li>False: La partida no ha terminat</li>
	 * 		</ul>
	 */
	public static boolean jugar(char[][] jug1Sol, char[][] jug1Secret, char[][] maq1Sol, char[][] maq1Secret, int TAB, int[] memoria) {
		int Player = 2; //def 2
		boolean ok = false;
		do {
			Player = (Player % 2) + 1;
			switch (Player) {
			case 1:
				//System.out.println("Maquina Sol: ");
				//Salidas.mostrar(maq1Sol, TAB); //m1Sol
				System.out.println("Jugador Sol: ");
				Salidas.mostrar(jug1Sol, TAB); //m1Sol*/
				//System.out.println("Maq Sec: ");
				//Salidas.mostrar(maq1Secret, TAB); //m1Sol
				
				ok = Tiradas.PlayerARM(maq1Sol, maq1Secret, TAB, Player);
				break;
			case 2:
				ok = Tiradas.MaqARM(jug1Sol, jug1Secret, TAB, Player, memoria);
				break;
			}
		}while(Player < 2 && ok != true);
		if (ok != false) System.out.println("Guanya el jugador " + Player + ". ");
		
		return ok;
	}
	
}
