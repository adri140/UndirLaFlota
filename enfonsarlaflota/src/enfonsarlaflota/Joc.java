package enfonsarlaflota;

/**
 * <h2>Clase Joc, Inicialitza el joc i indica el jugador que jugara.</h2>
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
 */

public class Joc {
	/**
	 * Method Joc, genera els taulells i crida als Methods que els inicialitzen.
	 * Un cop inicialitsats els taulells crida al Method <b>jugar</b> per començar el joc.
	 */
	public static void joc() {
		char[][] jug1Sol, jug1Secret; //Jugador (Sol = Visible Secret = Secreta)
		char[][] maq1Sol, maq1Secret; //Maquina (Sol = Visible Secret = Secreta)
		int[] memoria = {11, 11}; //memória de la IA [0] = fila [1] = col
		char resp;
		int TAB = 10;
		boolean ok = false;
		
		jug1Sol = new char [TAB][TAB];
		jug1Secret = new char [TAB][TAB];
		maq1Sol = new char [TAB][TAB];
		maq1Secret = new char [TAB][TAB];
		
		IniMatrizes.inicializarSol(jug1Sol, TAB, '?'); //A de aigua
		IniMatrizes.inicializarSol(maq1Sol, TAB, '?'); //A de aigua
		IniMatrizes.inicializarMaqSecret(maq1Secret, TAB, 'B'); //B de vaixell
		IniMatrizes.inicializarUserSecret(jug1Secret, TAB, 'B', 'A');
		System.out.println("La teva distribució: ");
		Salidas.mostrar(jug1Secret, TAB); 
		
		do {
			ok = jugar(jug1Sol, jug1Secret, maq1Sol, maq1Secret, TAB, memoria);
			if (ok != true) {
				resp = Entradas.charUser("de la partida: ");
			}
			else {
				resp = 's';
			}
		}while(resp != 'S' && resp != 's' && ok != true);
	}
	
	/**
	 * Method <b>Jugar</b> gestiona els torns dels jugadors, aixi com la crida als Methodas que permeten visualitzar els taulells i les tirades.
	 * @param jug1Sol Taulell del jugador que pot veure tot el món.
	 * @param jug1Secret Taulell del jugador ocult, conte la solució.
	 * @param maq1Sol Taulell de la maquina que pot veure tot el món.
	 * @param maq1Secret Taulell de la maquina que oculta la solució del joc, generat per la maquina.
	 * @param TAB Indica l'amplada i la alçada del taulell.
	 * @param memoria Memória de la IA, pos 0 = fila, pos 1 = col.
	 * @return Retorna un boolean:
	 * 		<ul>
	 * 			<li>True: Fi de la partida.</li>
	 * 			<li>False: La partida no ha terminat.</li>
	 * 		</ul>
	 */
	public static boolean jugar(char[][] jug1Sol, char[][] jug1Secret, char[][] maq1Sol, char[][] maq1Secret, int TAB, int[] memoria) {
		int Player = 2; //def 2
		boolean ok = false;
		do {
			Player = (Player % 2) + 1;
			switch (Player) {
			case 1:
				System.out.println("Taulell del Jugador: ");
				Salidas.mostrar(jug1Sol, TAB); 
				ok = Tiradas.PlayerARM(maq1Sol, maq1Secret, TAB, Player);
				break;
			case 2:
				ok = Tiradas.MaqARM(jug1Sol, jug1Secret, TAB, Player, memoria);
				break;
			}
		}while(Player < 2 && ok != true);
		if (ok != false) {
			System.out.println("Guanya el Jugador " + Player + ". ");
			System.out.println("Taulell del Jugador: ");
			Salidas.mostrar(jug1Sol, TAB);
			System.out.println("Taulell secret del Jugador: ");
			Salidas.mostrar(jug1Secret, TAB);
			System.out.println("Taulell de la Maquina: ");
			Salidas.mostrar(maq1Sol, TAB);
			System.out.println("Taulell secret de la Maquina: ");
			Salidas.mostrar(maq1Secret, TAB);
		}	
		return ok;
	}
}
