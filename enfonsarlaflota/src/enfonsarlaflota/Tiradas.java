package enfonsarlaflota;
/**
 * <h2>Clase Tiradas, agrupa les dades introduides per l'usuari i la maquina.</h2>
 * Basicament crida als Methods de entrada de dades i despres envia aquestes dades a els methods que realitzen els canvis als taulells. 
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
 */
public class Tiradas {
	/**
	 * Method <b>MaqARM</b>, genera les dades necessàries per realitzar les tirades sobre el taulell de l’usuari. 
	 * @param jug1Sol Taulell de l'usuari, no conte la solució.
	 * @param jug1Secret Taulell de l'usuari, oculta la solució.
	 * @param TAB Indica alçada i la amplada del taulell
	 * @param Player Indica el Jugador.
	 * @param memoria Memória de la maquina.
	 * @return Torna un boolean.
	 * 		<ul>	
	 * 			<li>True: Indica que la partida ha terminat.</li>
	 * 			<li>False: Indica que la partida no ha terminat</li>
	 * 		</ul>
	 */
	public static boolean MaqARM(char[][] jug1Sol, char[][] jug1Secret, int TAB, int Player, int[] memoria) {
		boolean ok; //indica si no ha disparat habans a aquesta posició
		boolean ok2; //indica si ha tocat o undit algun vaixell i si ha guanyat.
		boolean torna ; //indica si torna a tirar o no
		int fila = 0; 
		int col = 0;
		int buscar;
		
		do {
			torna = false;
			ok = false;
			ok2 = false;
			if (memoria[0] != 11 && memoria[1] != 11) {
				do {
					fila = memoria[0];
					col = memoria[1];
					buscar = IA.IAgenSearch(fila, col); //genera la direcció cap a on buscar en funció de la seva posició
					if(buscar == 0 || buscar == 1) col = IA.IAcol(buscar, col); //retorna la columna on disparara
					else fila = IA.IAfila(buscar, fila); //retorna la fila on disparara
					if((fila >= 0 && fila <= 9) && (col >= 0 && col <= 9)) {
						if(jug1Sol[fila][col] == '?') ok = true;
						else {
							if(jug1Sol[fila][col] == 'B') {
								if(buscar == 0 || buscar == 1) {
									col = IA.ReCol(jug1Sol, fila, col, buscar, TAB);
								}
								else {
									fila = IA.ReFila(jug1Sol, fila, col, buscar, TAB);
								}
								ok = true;
								
							}
							else ok = false;
						}
					}
					else ok = false;
				}while (ok != true);
			}
			else {
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					if(jug1Sol[fila][col] == '?') ok = true;
					else ok = false;
				}while(ok != true);
			}
		
			jug1Sol[fila][col] = jug1Secret[fila][col];
			if(jug1Sol[fila][col] == 'B') {
				memoria[0] = fila;
				memoria[1] = col;
				ok2 = Comprovaciones.comprovarTirada(fila, col, jug1Sol, jug1Secret, TAB, Player);
				torna = true;
				if(ok2 != false) {
					memoria[0] = 11;
					memoria[1] = 11;
					ok2 = Comprovaciones.comprovarTablero(jug1Sol, jug1Secret, TAB, Player);
				}
			}
		}while(torna != false && ok2 != true);
		return ok2;
	}
	/**
	 * Method <b>PlayerARM</b>, basicament gestiona la tirada del jugador.
	 * @param maq1Sol Taulell de la maquina, no conte la solució.
	 * @param maq1Secret Taulell de la maquina, oculta la solució
	 * @param TAB Indica la alçada i la amplada del taulell
	 * @param Player Indica el jugador.
	 * @return Torna un boolean.
	 * 		<ul>	
	 * 			<li>True: Indica que la partida ha terminat.</li>
	 * 			<li>False: Indica que la partida no ha terminat</li>
	 * 		</ul>
	 */
	public static boolean PlayerARM(char[][] maq1Sol, char[][] maq1Secret, int TAB, int Player) {
		int filaUser;
		int colUser;
		boolean ok;
		boolean ok2;
		boolean torna; //indica si torna a tirar o no
		do {
			System.out.println("Taulell de la Maquina: ");
			Salidas.mostrar(maq1Sol, TAB); //m1Sol
			torna = false;
			ok = false;
			ok2 = false;
			do {
				filaUser = Entradas.inputFilaUser(TAB);
				colUser = Entradas.inputColUser(TAB);
				if (maq1Sol[filaUser][colUser] == '?') ok = true;
				else System.out.println("Aquesta posició ja esta descoberta, tria una altre. ");
			}while(ok != true);
			maq1Sol[filaUser][colUser] = maq1Secret[filaUser][colUser];
			if(maq1Sol[filaUser][colUser] == 'B') {
				ok2 = Comprovaciones.comprovarTirada(filaUser, colUser, maq1Sol, maq1Secret, TAB, Player);
				torna = true;
				if(ok2 != false) ok2 = Comprovaciones.comprovarTablero(maq1Sol, maq1Secret, TAB, Player);
			}
			else System.out.println("Aigua, pers el torn.");
		}while(torna != false && ok2 != true);
		return ok2;
	}
}
