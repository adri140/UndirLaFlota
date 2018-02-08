package enfonsarlaflota;
import java.util.Random;
public class IA {
	final static Random rnd = new Random();
	/**
	 * Method <b>genSearch</b>, genera la direccio cap a hon disparara en funcio de la posicio del baixell trobat
	 * @param fila Conte la fila on es troba el baixell
	 * @param col Conte la columna on es troba el baixell
	 * @return Retorna un int, numero enter que indica cap a hon disparara.
	 */
	public static int genSearch(int fila, int col) {
		int resposta = 0;
		if(fila == 0 && col == 0) {
			resposta = rnd.nextInt(2);
			switch(resposta) {
				case 1: resposta = 0;
			break;
				case 2: resposta = 2;
			break;
			}
		}
		else {
			if(fila == 9 && col == 0) {
				resposta = rnd.nextInt(2);
				switch(resposta) {
					case 1: resposta = 0;
				break;
					case 2: resposta = 3;
				break;
				}
			}
			else {
				if(fila == 0 && col == 9) {
					resposta = rnd.nextInt(2);
					switch(resposta) {
						case 1: resposta = 1;
					break;
						case 2: resposta = 2;
					break;
					}
				}
				else {
					if(fila == 9 && col ==9) {
						resposta = rnd.nextInt(2);
						switch(resposta) {
							case 1: resposta = 3;
						break;
							case 2: resposta = 1;
						break;
						}
					}
					else {
						if(fila == 0) {
							resposta = rnd.nextInt(3);
							switch(resposta) {
								case 1: resposta = 3;
							break;
								case 2: resposta = 0;
							break;
								case 3: resposta = 2;
							break;
							}
						}
						else {
							if(fila == 9) {
								resposta = rnd.nextInt(3);
								switch(resposta) {
									case 1: resposta = 3;
								break;
									case 2: resposta = 1;
								break;
									case 3: resposta = 2;
								break;
								}
							}
							else {
								if(col == 0) {
									resposta = rnd.nextInt(3);
									switch(resposta) {
										case 1: resposta = 0;
									break;
										case 2: resposta = 1;
									break;
										case 3: resposta = 2;
									break;
									}
								}
								else {
									if(col == 9) {
										resposta = rnd.nextInt(3);
										switch(resposta) {
											case 1: resposta = 0;
										break;
											case 2: resposta = 1;
										break;
											case 3: resposta = 3;
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
	
	public static int col(int buscar, int col) {
		if(buscar == 0) col = col + 1;
		else col = col - 1;
		return col;
	}
	
	public static int fila (int buscar, int fila) {
		if(buscar == 2) fila = fila + 1;
		else fila = fila - 1;
		return fila;
	}
	
	
	
	
	
}
