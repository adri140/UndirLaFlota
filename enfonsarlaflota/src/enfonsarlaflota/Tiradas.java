package enfonsarlaflota;
/**
 * <h2>Clase Tiradas, agrupa les dades introduides per l'usuari i la maquina.</h2>
 * Basicament crida a les funcions de entrada de dades i despres envia aquestes dades a els methods que realitzen els canvis als taulells. 
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class Tiradas {
	/**
	 * Method <b>MaqARM</b>, emmagatzema les dades generades per la maquina per realitzar la tirada sobre el taulell de l'usuari. 
	 * @param jug1Sol Taulell de l'usuari, no conte la solucio.
	 * @param jug1Secret Taulell de l'usuari, oculta la solucio.
	 * @param TAB
	 * @param Player
	 * @param memoria
	 * @return Torna un boolean.
	 * 		<ul>	
	 * 			<li>True: Indica que la partida ha terminat.</li>
	 * 			<li>False: Indica que la partida no ha terminat</li>
	 * 		</ul>
	 */
	public static boolean MaqARM(char[][] jug1Sol, char[][] jug1Secret, int TAB, int Player, int[] memoria) {
		boolean ok; //indica si no ha disparat habans a aquesta posicio
		boolean ok2; //indica si ha tocat o undit algun baixell i si ha guanyat.
		boolean torna ; //indica si torna a tirar o no
		int fila = 0; 
		int col = 0;
		int buscar;
		
		
		
		
		do {
			torna = false;
			ok = false;
			ok2 = false;
			do {
				if (memoria[0] != 11 && memoria[1] != 11) {
					fila = memoria[0];
					col = memoria[1];
					buscar = Ia.genSearch(fila, col);
					if(buscar == 0 || buscar == 1) col = Ia.Col(buscar, col);
					else fila = Ia.Fila(buscar, fila);
				}
				else {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					if(jug1Sol[fila][col] == '?') ok = true;
					else ok = false;
				}
			}while(ok != true);
			jug1Sol[fila][col] = jug1Secret[fila][col];
			if(jug1Sol[fila][col] == 'B') {
				memoria[0] = fila;
				memoria[1] = col;
				ok2 = Comprovaciones.comprovarTirada(fila, col, jug1Sol, jug1Secret, TAB, Player);
				torna = true;
				if(ok2 != false) ok2 = Comprovaciones.comprovarTablero(jug1Sol, jug1Secret, TAB, Player);
			}
		}while(torna != false && ok2 != true);
		return ok2;
	}
	/**
	 * Method <b>PlayerARM</b>, basicament gestiona la tirada del jugador.
	 * @param maq1Sol Taulell de la maquina, no conte la solucio.
	 * @param maq1Secret Taulell de la maquina, oculta la solucio
	 * @param TAB Indica la alçada i la amplada del taulell
	 * @param Player
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
		/*System.out.println("Secreta MAQ:");
		mostrar(maq1Secret, TAB); //m1Sol
		System.out.println("Solucion MAQ:");
		mostrar(maq1Sol, TAB); //m1Sol*/
		do {
			System.out.println("Maquina Sol: ");
			Salidas.mostrar(maq1Sol, TAB); //m1Sol
			/*System.out.println("Jugador Sol: ");
			Salidas.mostrar(jug1Sol, TAB); //m1Sol*/
			//System.out.println("Maq Sec: ");
			//Salidas.mostrar(maq1Secret, TAB); //m1Sol
			torna = false;
			ok = false;
			ok2 = false;
			do {
				filaUser = Entradas.inputFilaUser(TAB);
				colUser = Entradas.inputColUser(TAB);
				if (maq1Sol[filaUser][colUser] == '?') ok = true;
				else System.out.println("Aquesta posició ja esta descuberta, tria una altre. ");
			}while(ok != true);
			maq1Sol[filaUser][colUser] = maq1Secret[filaUser][colUser];
			if(maq1Sol[filaUser][colUser] == 'B') {
				ok2 = Comprovaciones.comprovarTirada(filaUser, colUser, maq1Sol, maq1Secret, TAB, Player);
				torna = true;
				if(ok2 != false) ok2 = Comprovaciones.comprovarTablero(maq1Sol, maq1Secret, TAB, Player);
			}
			else System.out.println("Aigua, pers el turn.");
		}while(torna != false && ok2 != true);
		return ok2;
	}
}
