package enfonsarlaflota;
import java.util.Random;
/**
 * <h2>Classe IA, conte la malloria de les funcions de la IA</h2>
 * @author Adrian Recio Marín
 * @version Cosole-2
 * @sinze 10/02/2018
 */
public class IA {
	final static Random rnd = new Random();
	/**
	 * Method <b>IAgenSearch</b>, genera la direcció cap a hon disparara en funció de la posició del vaixell trobat.
	 * @param fila Conte la fila on es troba el vaixell
	 * @param col Conte la columna on es troba el vaixell
	 * @return Retorna un int, numero enter que indica cap a hon disparara.
	 */
	public static int IAgenSearch(int fila, int col) {
		int resposta = 0;
		if(fila == 0 && col == 0) {
			resposta = rnd.nextInt(2);
			switch(resposta) {
				case 0: resposta = 0;
			break;
				case 1: resposta = 2;
			break;
			}
		}
		else {
			if(fila == 9 && col == 0) {
				resposta = rnd.nextInt(2);
				switch(resposta) {
					case 0: resposta = 0;
				break;
					case 1: resposta = 3;
				break;
				}
			}
			else {
				if(fila == 0 && col == 9) {
					resposta = rnd.nextInt(2);
					switch(resposta) {
						case 0: resposta = 1;
					break;
						case 1: resposta = 2;
					break;
					}
				}
				else {
					if(fila == 9 && col ==9) {
						resposta = rnd.nextInt(2);
						switch(resposta) {
							case 0: resposta = 3;
						break;
							case 1: resposta = 1;
						break;
						}
					}
					else {
						if(fila == 0) {
							resposta = rnd.nextInt(3);
							switch(resposta) {
								case 0: resposta = 0;
							break;
								case 1: resposta = 1;
							break;
								case 2: resposta = 3;
							break;
							}
						}
						else {
							if(fila == 9) {
								resposta = rnd.nextInt(3);
								switch(resposta) {
									case 0: resposta = 0;
								break;
									case 1: resposta = 1;
								break;
									case 2: resposta = 3;
								break;
								}
							}
							else {
								if(col == 0) {
									resposta = rnd.nextInt(3);
									switch(resposta) {
										case 0: resposta = 0;
									break;
										case 1: resposta = 2;
									break;
										case 2: resposta = 3;
									break;
									}
								}
								else {
									if(col == 9) {
										resposta = rnd.nextInt(3);
										switch(resposta) {
											case 0: resposta = 1;
										break;
											case 1: resposta = 2;
										break;
											case 2: resposta = 3;
										break;
										}
									}
									else {
										resposta = rnd.nextInt(4);
									}
								}
							}
						}
					}
				}
			}
		}
		return resposta;
	}
	/**
	 * Method <b>IAcol</b>, modifica el valor de la columna emmagatzemada a la memória en funció a la direcció, en aquet cas modifica la columna si la direcció és 0 o 1 (Dreta o Esquerra).
	 * @param buscar Emmagatzema la direcció cap a on disparara, en aquest method nomes hi hauran dos valors 0 o 1.
	 * @param col Per defecte conte el valor de la posicio de la memória que coorespon a la columna.
	 * @return Retorna el nou valor de la columna.
	 */
	public static int IAcol(int buscar, int col) {
		if(buscar == 0) col = col + 1;
		else col = col - 1;
		return col;
	}
	/**
	 * Method <b>IAfila</b>, modifica el valor de la fila emmagatzemada a la memória en funció a la direcció, en aquest cas modifica la fila si la direcció és 2 o 3 (Abaix o Adalt).
	 * @param buscar Emmagatzema la direcció cap a on disparara, en aquest method nomes hi hauran dos valors 2 o 3.
	 * @param fila Per defecte conte el valor de la posicio de la memória que coorespon a la fila.
	 * @return Retorna el nou valor de la fila.
	 */
	public static int IAfila (int buscar, int fila) {
		if(buscar == 2) fila = fila + 1;
		else fila = fila - 1;
		return fila;
	}
}
