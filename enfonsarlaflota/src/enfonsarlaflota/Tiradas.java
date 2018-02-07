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
	 * @return Torna un boolean.
	 * 		<ul>	
	 * 			<li>True: Indica que la partida ha terminat.</li>
	 * 			<li>False: Indica que la partida no ha terminat</li>
	 * 		</ul>
	 */
	public static boolean MaqARM(char[][] jug1Sol, char[][] jug1Secret, int TAB, int Player) {
		boolean ok = false; //indica si no ha disparat habans a aquesta posicio
		boolean ok2 = false; //indica si ha tocat o undit algun baixell i si ha guanyat.
		int fila, col;
		
		do {
			fila = Entradas.genRandom(TAB);
			col = Entradas.genRandom(TAB);
			if(jug1Sol[fila][col] == '?') ok = true;
			else ok = false;
		}while(ok != true);
		jug1Sol[fila][col] = jug1Secret[fila][col];
		if(jug1Sol[fila][col] == 'B') {
			ok2 = Comprovaciones.comprovarTirada(fila, col, jug1Sol, jug1Secret, TAB, Player);
			if(ok2 != false) ok2 = Comprovaciones.comprovarTablero(jug1Sol, jug1Secret, TAB, Player);
		}
		
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
		boolean ok = false;
		boolean ok2 = false;
		/*System.out.println("Secreta MAQ:");
		mostrar(maq1Secret, TAB); //m1Sol
		System.out.println("Solucion MAQ:");
		mostrar(maq1Sol, TAB); //m1Sol*/
		
		do {
			filaUser = Entradas.inputFilaUser(TAB);
			colUser = Entradas.inputColUser(TAB);
			if (maq1Sol[filaUser][colUser] == '?') ok = true;
			else System.out.println("Aquesta posició ja esta descuberta, tria una altre. ");
		}while(ok != true);
		maq1Sol[filaUser][colUser] = maq1Secret[filaUser][colUser];
		if(maq1Sol[filaUser][colUser] == 'B') {
			ok2 = Comprovaciones.comprovarTirada(filaUser, colUser, maq1Sol, maq1Secret, TAB, Player);
			if(ok2 != false) ok2 = Comprovaciones.comprovarTablero(maq1Sol, maq1Secret, TAB, Player);
		}
		else System.out.println("Aigua.");
		return ok2;
	}
}
