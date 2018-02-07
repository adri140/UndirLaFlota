package enfonsarlaflota;
/**
 * <h2>Clase IniMatrizes "InicialitzarMatrius", conte els method per inicialitzar totes les matrius.</h2>
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class IniMatrizes {
	/**
	 * Method <b>inicializarMaqSecret</b>, genera els baixells de forma aleatoria i els pocisiona al teulell.
	 * @param maq1Secret Taulell que conte la distribucio dels baixells posicionats per la maquina.
	 * @param TAB Indica la amplada i la alçada del taulell
	 * @param carac Indica el caracter que s'utilitzara per cobrir el taulell, en aquet cas indica el caracter que identifica l'aigua.
	 */
	public static void inicializarMaqSecret(char[][] maq1Secret, int TAB, char carac) {
		int fila, col, direccion;
		int pos = 1; //indica el numero de posicions que tindra el vaixell - 1
		int baixell = 0; //indica el baixell
		boolean ok;
		
		inicializarSol(maq1Secret, TAB, 'A');
		
		pos = 3;
		do {
		 	do{
			ok = false;
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					direccion = Entradas.genRandom(4); //0 derecha, 1 izquierda, 2 abajo, 3 arriba
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos, maq1Secret);
					//if (ok != false) ok = posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); //terminar
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); //terminar
			}while(ok != true);
		
		baixell++;
		}while(baixell < 1);
		
		pos = 2;
		baixell = 0;
		do {
		 	do{
			ok = false;
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					direccion = Entradas.genRandom(4); //0 derecha, 1 izquierda, 2 abajo, 3 arriba
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos, maq1Secret);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); //terminar
			}while(ok != true);
		
		baixell++;
		}while(baixell < 2);
		
		pos = 1;
		baixell = 0;
		do {
		 	do{
			ok = false;
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					direccion = Entradas.genRandom(4); //0 derecha, 1 izquierda, 2 abajo, 3 arriba
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos, maq1Secret);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); //terminar
			}while(ok != true);
		
		baixell++;
		}while(baixell < 3);
		
		pos = 0;
		baixell = 0;
		do {
		 	do{
			ok = false;
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					direccion = Entradas.genRandom(4); //0 derecha, 1 izquierda, 2 abajo, 3 arriba
					//System.out.println("fila "+ fila + " col " + col + " direccion " + direccion);
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos, maq1Secret);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); //terminar
			}while(ok != true);
		 	//mostrar(maq1Secret, TAB); //m1Sol
		baixell++;
		}while(baixell < 4); 
	}
	
	public static void inicializarSol(char[][] Solucion, int TAB, char carac) {
		for(int i = 0; i < TAB; i++) {
			for(int p = 0; p < TAB; p++) {
				Solucion[i][p] = carac;
			}
		}
	}
	/**
	 * Method <b>inicializarUserSecret</b>, permet al usuari introduir la distribucio dels baixells que ell bulgui.
	 * @param jug1Secret Taulell que conte la distribució dels baixells del jugador.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param barco Indica el caracter que utilitzara el programa per indicar que es un baixell.
	 * @param agua Indica el caracter que indica l'aigua.
	 */
	public static void inicializarUserSecret(char[][] jug1Secret, int TAB, char barco, char agua) {
		int FilaInici, ColInici;
		int pos; //indica de quants baixells sera la posicio
		int direccion; //indica la direccion hacia donde se generara el barco
		int baixell; //indica quants baixells a d'introduir de tantes posicions
		boolean ok = false; //indica si el baixell esta bé posicionat
		
		inicializarSol(jug1Secret, TAB, agua); //A de aigua
		
		pos = 3;
		baixell = 1; //1 baixell de 4 posicions.
		do {
			do {
			Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Baixell "+ baixell +" de " + 0 + " Introdueix les posicions i la direccio del baixell de 4 posicions:");
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos, jug1Secret);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell--;
		}while(baixell != 0);
		
		pos = 2;
		baixell = 2; //2 baixell de 3 posicions.
		do { 
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Baixell "+ baixell +" de " + 0 + " Introdueix les posicions i la direccio del baixell de 3 posicions:");
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos, jug1Secret);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell--;
		}while(baixell != 0);
		
		
		pos = 1;
		baixell = 3; //3 baixell de 2 posicions.
		do {
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Baixell "+ baixell +" de " + 0 + " Introdueix les posicions i la direccio del baixell de 2 posicions:");
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos, jug1Secret);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell--;
		}while(baixell != 0);
		
		pos = 0;
		baixell = 4; //4 baixell de 1 posicions.
		do {
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Baixell "+ baixell +" de " + 0 + " Introdueix les posicions i la direccio del baixell de 1 posicions:");
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos, jug1Secret);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell--;
		}while(baixell != 0);
	}
	/**
	 * Method <b>escribirMatiz</b>, escriu a la matriu els baixells.
	 * @param fila Indica la fila on comença el baixell.
	 * @param col Indica la columna on comença el baixell.
	 * @param pos Indica el numero de posicions que tindra el baixell.
	 * @param maq1Secret Conte el taulell on es colocara el baixell.
	 * @param direccion Indica la direccio cap a on es dirigeix el baixell.
	 */
	public static void escribirMatriz(int fila, int col, int pos, char[][] maq1Secret, int direccion) {
		switch(direccion) {
		case 0:
			do {
				maq1Secret[fila][col] = 'B';
				col++;
				pos--;
			}while(pos > -1);
			break;
		case 3:
			do {
				maq1Secret[fila][col] = 'B';
				fila++;
				pos--;
			}while(pos > -1);
			break;
		}
	}
}
