package enfonsarlaflota;
/**
 * <h2>Clase IniMatrizes "InicialitzarMatrius", conte els method per inicialitzar totes les matrius.</h2>
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
 */
public class IniMatrizes {
	/**
	 * Method <b>inicializarMaqSecret</b>, genera els vaixells de forma aleatoria i els pocisiona al teulell.
	 * @param maq1Secret Taulell que conte la distribucio dels vaixells posicionats per la maquina.
	 * @param TAB Indica la amplada i la alçada del taulell
	 * @param carac Indica el caracter que s'utilitzara per cobrir el taulell, en aquet cas indica el caracter que identifica l'aigua.
	 */
	public static void inicializarMaqSecret(char[][] maq1Secret, int TAB, char carac) {
		int fila, col, direccion;
		int pos = 1; //indica el numero de posicions que tindra el vaixell - 1
		int baixell = 0; //indica el vaixell
		boolean ok;
		
		inicializarSol(maq1Secret, TAB, 'A');
		
		pos = 3;
		do {
		 	do{
			ok = false;
				do {
					fila = Entradas.genRandom(TAB);
					col = Entradas.genRandom(TAB);
					direccion = Entradas.genRandom(4); //0 dreta, 1 esquerra, 2 cap a abaix, 3 cap a adalt
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); 
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
					direccion = Entradas.genRandom(4); //0 dreta, 1 esquerra, 2 cap a abaix, 3 cap a adalt
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); 
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
					direccion = Entradas.genRandom(4); //0 dreta, 1 esquerra, 2 cap a abaix, 3 cap a adalt
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret);
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
					direccion = Entradas.genRandom(4); //0 dreta, 1 esquerra, 2 cap a abaix, 3 cap a adalt
					ok = Comprovaciones.comprobar(fila, col, direccion, TAB, pos);
				}while(ok != true);
			ok = false;
			ok = Comprovaciones.posicionarBarco(fila, col, direccion, TAB, pos, maq1Secret); 
			}while(ok != true);
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
	 * Method <b>inicializarUserSecret</b>, permet al usuari introduir la distribució dels vaixells que ell bulgui.
	 * @param jug1Secret Taulell que conte la distribució dels vaixells del jugador.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param barco Indica el caracter que utilitzara el programa per indicar que és un vaixell.
	 * @param agua Indica el caracter que indica l'aigua.
	 */
	public static void inicializarUserSecret(char[][] jug1Secret, int TAB, char barco, char agua) {
		int FilaInici, ColInici;
		int pos; //indica de quants vaixells sera la posició
		int direccion; //indica la direcció cap a on és generara el vaixell
		int baixell; //indica quants vaixells a introduit per a cada tipus de vaixell
		boolean ok = false; //indica si el vaixell esta bé posicionat
		
		inicializarSol(jug1Secret, TAB, agua); //A de aigua
		
		pos = 3;
		baixell = 0; //1 vaixell de 4 posicions.
		do {
			do {
			Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Introdueix les coordenades i les direccions dels vaixells de 4 posicions " + "(" + baixell + " / 1)" );
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell++;
		}while(baixell != 1);
		
		pos = 2;
		baixell = 0; //2 vaixell de 3 posicions.
		do { 
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Introdueix les coordenades i les direccions dels vaixell de 3 posicions " + "(" + baixell + " / 2)" );
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell++;
		}while(baixell != 2);
		
		
		pos = 1;
		baixell = 0; //3 vaixell de 2 posicions.
		do {
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Introdueix les coordenades i les direccions dels vaixells de 2 posicions " + "(" + baixell + " / 3)" );
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = Entradas.inputDirUser();
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell++;
		}while(baixell != 3);
		
		pos = 0;
		baixell = 0; //4 vaixell de 1 posicions.
		do {
			ok = false;
			do {
				Salidas.mostrar(jug1Secret, TAB); 
				do {
					System.out.println("Introdueix les posicions dels vaixells d'1 posicions " + "(" + baixell + " / 4)" );
					FilaInici = Entradas.inputFilaUser(TAB);
					ColInici = Entradas.inputColUser(TAB);
					direccion = 0;
					ok = Comprovaciones.comprobar(FilaInici, ColInici, direccion, TAB, pos);
					if(ok != true)System.out.println("No es pot posar el baixell, el baixell sortiria del taulell.");
				}while(ok != true);
				ok = false;
				ok = Comprovaciones.posicionarBarco(FilaInici, ColInici, direccion, TAB, pos, jug1Secret); 
				if(ok != true) System.out.println("No es pot posar el baixell, toca o sobreposa un altre baixell.");
			}while(ok != true);
			baixell++;
		}while(baixell != 4);
	}
	/**
	 * Method <b>escribirMatiz</b>, escriu a la matriu els vaixells.
	 * @param fila Indica la fila on comença el vaixell.
	 * @param col Indica la columna on comença el vaixell.
	 * @param pos Indica el numero de posicions que tindra el vaixell.
	 * @param MatSecret Conte el taulell on es colocara el vaixell.
	 * @param direccion Indica la direccio cap a on es dirigeix el vaixell.
	 */
	public static void escribirMatriz(int fila, int col, int pos, char[][] MatSecret, int direccion) {
		switch(direccion) {
		case 0:
			do {
				MatSecret[fila][col] = 'B';
				col++;
				pos--;
			}while(pos > -1);
			break;
		case 3:
			do {
				MatSecret[fila][col] = 'B';
				fila++;
				pos--;
			}while(pos > -1);
			break;
		}
	}
}
