package enfonsarlaflota;
/**
 * <h2>Clase Comprovaciones</h2>
 * Conte tots els methods que comproven que els vaixells es posicionen a una ubicació coorecte, a més de escriure els vaixells als taulers i comprovar si estan undits o tocats.
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
 */
public class Comprovaciones {
	/**
	 * Method <b>comprovarTirada</b>, comprova si el vaixell esta tocat o undit, i mostra per consola el resultat.
	 * @param fila Indica la fila on esta situat el vaixell.
	 * @param col Indica la columna on esta situat el vaixell.
	 * @param MatSol És el taulell que es mostra a tot el món.
	 * @param MatSecret És el taulell que conte la solucio secreta.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param Player Indica el jugador.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: Baixell Undit.</li>
	 * 		<li>False: Baixell Tocat.</li>
	 * 	</ul>
	 */
	public static boolean comprovarTirada(int fila, int col, char[][] MatSol, char[][] MatSecret, int TAB, int Player) {
		int i = 1;
		boolean ok = true;
		if(fila == 0 && col == 0) {
			if(MatSecret[fila][col + 1] == 'B') {
				while(ok != false && MatSecret[fila][col + i] != 'A' && col + i < TAB - 1) {
					if(MatSecret[fila][col + i] == MatSol[fila][col + i]) i++;
					else ok = false;
				}
				if(ok != false && MatSecret[fila][col + i] != 'A') {
					if(MatSecret[fila][col + i] == MatSol[fila][col + i]) ok = true;
					else ok = false;
				}
			}
			else {
				while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
					if(MatSecret[fila + 1][col] == MatSol[fila + i][col]) i++;
					else ok = false;
				}
				if(ok != false && MatSecret[fila + i][col] != 'A') {
					if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
					else ok = false;
				}
			}
		}
		else {
			if(fila == 0 && col == 9) {
				if(MatSecret[fila][col - 1] == 'B') {
					while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
						if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
						else ok = false;
					}
					if(ok != false && MatSecret[fila][col - i] != 'A') {
						if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
						else ok = false;
					}
				}
				else {
					while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
						if(MatSecret[fila + 1][col] == MatSol[fila + i][col]) i++;
						else ok = false;
					}
					if (ok != false && MatSecret[fila + i][col] != 'A') {
							if(MatSecret[fila + 1][col] == MatSol[fila + i][col]) ok = true;
							else ok = false;
					}
				}
			}
			else {
				if(fila == 9 && col == 0) {
					if(MatSecret[fila - 1][col] == 'B') {
						while(ok != false && MatSecret[fila - i][col] != 'A' && fila - i > 0) {
							if(MatSecret[fila - 1][col] == MatSol[fila - i][col]) i++;
							else ok = false;
						}
						if(ok != false && MatSecret[fila - i][col] != 'A') {
							if(MatSecret[fila - 1][col] == MatSol[fila - i][col]) ok = true;
							else ok = false;
						}
					}
					else {
						while(ok != false && MatSecret[fila][col + i] != 'A' && col + i < TAB - 1) {
							if(MatSecret[fila][col + i] == MatSol[fila][col + i]) i++;
							else ok = false;
						}
						if(ok != false && MatSecret[fila][col + i] != 'A') {
							if(MatSecret[fila][col + i] == MatSol[fila][col + i]) ok = true;
							else ok = false;
						}
					}
				}
				else {
					if(fila == 9 && col == 9) {
						if(MatSecret[fila - 1][col] == 'B') {
							while(ok != false && MatSecret[fila - i][col] != 'A' && fila - i > 0) {
								if(MatSecret[fila - 1][col] == MatSol[fila - i][col]) i++;
								else ok = false;
							}
							if(ok != false && MatSecret[fila - i][col] != 'A') {
								if(MatSecret[fila - 1][col] == MatSol[fila - i][col]) ok = true;
								else ok = false;
							}
						}
						else {
							while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
								if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
								else ok = false;
							}
							if(ok != false && MatSecret[fila][col - i] != 'A') {
								if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
								else ok = false;
							}
						}
					}
					else {
						if(fila == 0) {
							if(MatSecret[fila][col + 1] == 'B') {
								while(col + i < TAB && ok != false) { //TAB - 1
									if(MatSecret[fila][col + i] != 'A') i++;
									else ok = false;
								}
								if(i > 9) i--; 
								col = col + i;
								i = 1;
								ok = true;
								while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
									if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
									else ok = false;
								}
								if(ok != false && MatSecret[fila][col - i] != 'A') {
									if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
									else ok = false;
								}
							}
							else {
								if(MatSecret[fila][col - 1] == 'B') {
									while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
										if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
										else ok = false;
									}
									if(ok != false && MatSecret[fila][col - i] != 'A') {
										if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
										else ok = false;
									}
								}
								else {
									//cap abaix
									while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
										if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
										else ok = false;
									}
									if(ok != false && MatSecret[fila + i][col] != 'A') {
										if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
										else ok = false;
									}
								}
							}
						}
						else {
							if(fila == 9) {
								if(MatSecret[fila][col + 1] == 'B') {
									while(col + i < TAB && ok != false) { //TAB -1
										if(MatSecret[fila][col + i] != 'A') i++;
										else ok = false;
									}
									col = col + i;
									i = 1;
									ok = true;
									while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
										if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
										else ok = false;
									}
									if(ok != false && MatSecret[fila][col - i] != 'A') {
										if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
										else ok = false;
									}
								}
								else {
									if(MatSecret[fila][col - 1] == 'B') {
										while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) { //0
											if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
											else ok = false;
										}
										if(ok != false && MatSecret[fila][col - i] != 'A') {
											if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
											else ok = false;
										}
									}
									else {
										while(ok != false && MatSecret[fila - i][col] != 'A' && fila - i > 0) {
											if(MatSecret[fila - i][col] == MatSol[fila - i][col]) i++;
											else ok = false;
										}
										if(ok != false && MatSecret[fila - i][col] != 'A') {
											if(MatSecret[fila - i][col] == MatSol[fila - i][col]) ok = true;
											else ok = false;
										}
									}
								}
							}
							else {
								if (col == 0) {
									if(MatSecret[fila - 1][col] == 'B') {
										while(ok != false && fila - i > -1) { //0
											if(MatSecret[fila - i][col] == 'B') i++;
											else ok = false;
										}
										fila = fila - i;
										i = 1;
										ok = true;
										while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
											if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
											else ok = false;
										}
										if(ok != true && MatSecret[fila + i][col] != 'A') {
											if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
											else ok = false;
										}
									}
									else {
										if(MatSecret[fila + 1][col] == 'B') {
											while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
												if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
												else ok = false;
											}
											if(ok != false && MatSecret[fila + i][col] != 'A') {
												if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
												else ok = false;
											}
										}
										else {
											while(ok != false && MatSecret[fila][col + i] != 'A' && col + i < TAB - 1) {
												if(MatSecret[fila][col + i] == MatSol[fila][col + i]) i++;
												else ok = false;
											}
											if(ok != false && MatSecret[fila][col + i] != 'A') {
												if(MatSecret[fila][col + i] == MatSol[fila][col + i]) ok = true;
												else ok = false;
											}
										}
									}
								}
								else {
									if(col == 9) {
										if(MatSecret[fila - 1][col] == 'B') {
											while(ok != false && fila - i > -1) { //0
												if(MatSecret[fila - i][col] == 'B') i++;
												else ok = false;
											}
											fila = fila - i;
											i = 1;
											ok = true;
											while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
												if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
												else ok = false;
											}
											if (ok != false && MatSecret[fila + i][col] != 'A') {
												if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
												else ok = false;
											}
										}
										else {
											if(MatSecret[fila + 1][col] == 'B') {
												while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB -1) {
													if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
													else ok = false;
												}
												if (ok != false && MatSecret[fila + i][col] != 'A') {
													if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
													else ok = false;
												}
											}
											else {
												while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
													if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
													else ok = false;
												}
												if (ok != false && MatSecret[fila][col - i] != 'A') {
													if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
													else ok = false;
												}
											}
										}
									}
									else {
										if(MatSecret[fila][col + 1] == 'B') {
											while(col + i < TAB && ok != false) { //TAB -1
												if(MatSecret[fila][col + i] != 'A') i++;
												else ok = false;
											}
											col = col + i;
											i = 1;
											ok = true;
											while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) {
												if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
												else ok = false;
											}
											if (ok != false && MatSecret[fila][col - i] != 'A') {
												if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
												else ok = false;
											}
										}
										else {
											if(MatSecret[fila][col - 1] == 'B') {
												while(ok != false && MatSecret[fila][col - i] != 'A' && col - i > 0) { // 0
													if(MatSecret[fila][col - i] == MatSol[fila][col - i]) i++;
													else ok = false;
												}
												if(ok != false && MatSecret[fila][col - i] != 'A') {
													if(MatSecret[fila][col - i] == MatSol[fila][col - i]) ok = true;
													else ok = false;
												}
											}
											else {
												if(MatSecret[fila - 1][col] == 'B') {
													while(ok != false && fila - i > -1) { // 0
														if(MatSecret[fila - i][col] == 'B') i++;
														else ok = false;
													}
													fila = fila - i;
													i = 1;
													ok = true;
													while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) {
														if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
														else ok = false;
													}
													if (ok != false && MatSecret[fila + i][col] != 'A') {
														if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
														else ok = false;
													}
												}
												else {
													while(ok != false && MatSecret[fila + i][col] != 'A' && fila + i < TAB - 1) { // -1
														if(MatSecret[fila + i][col] == MatSol[fila + i][col]) i++;
														else ok = false;
													}
													if (ok != false && MatSecret[fila + i][col] != 'A') {
														if(MatSecret[fila + i][col] == MatSol[fila + i][col]) ok = true;
														else ok = false;	
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(Player == 1) {
			if (ok == true) System.out.println("Vaixell enfonsat, tornes a disparar.");
			else System.out.println("Vaixell tocat, tornes a disparar.");
		}
		return ok;
	}
	/**
	 * Method <b>comprovarTablero</b>, Comprova si tots els vaixells dels taulell han sigut descoberts.
	 * @param Solucion Taulell que tot el món pot veure.
	 * @param Secret Taulell que conte la solució, secret.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param Player Indica el jugador.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: Tots els vaixells trobats i undits.</li>
	 * 		<li>False: Algun vaixell no torbat o no undit.</li>
	 * 	</ul>
	 */
	public static boolean comprovarTablero(char[][] Solucion, char[][] Secret, int TAB, int Player) {
		int i = 0;
		int p;
		boolean ok = true;
		while(i < TAB && ok != false) {
			p = 0;
			while(p < TAB && ok != false) {
				if(Secret[i][p] == 'B') {
					if(Secret[i][p] == Solucion[i][p]) ok = true;
					else ok = false;
				}
				p++;
			}
			i++;
		}
		if(ok != false && Player == 1) System.out.println("Has guanyat.");
		return ok;
	}
	/**
	 * Method <b>BarcosDireccion3</b>, Comprova que és pot posar els vaixells amb direcció 2 i 3.
	 * @param FilaMod Indica la fila on comença el vaixell.
	 * @param ColMod Indica la columna on comença el vaixell.
	 * @param pos Indica el numero de posicions que tindra el vaixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param MatSecret Taulell secret, on es realitzaran totes les comprovacions.
	 * @return Retorna un boolean.
	 * 	<ul>
	 * 		<li>True: El vaixell és pot ubicar a a questa posició.</li>
	 * 		<li>False: El vaixell no és pot ubicar a aquesta posició.</li>
	 * 	</ul>
	 */
	public static boolean BarcosDireccion3(int FilaMod, int ColMod, int pos, int TAB, char[][] MatSecret) {
		boolean ok = false; //desplaçament de 0 a 9 fila
		
		if(FilaMod == 0 && ColMod == 0) {
			do {
				if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
				else ok = false;
				FilaMod++;
				pos--;
			}while(ok != false && pos > -1);
			if(ok != false) {
				if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
				else ok = false;
			}
		}
		else {
			if(FilaMod == 9 && ColMod == 0) {
				if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
				else ok = false;
				if (ok != false) {
					do {
						if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
						else ok = false;
						FilaMod++;
						pos--;
					}while(ok != false && pos > -1 && FilaMod <= TAB - 1);
				}
			}
			else {
				if(FilaMod == 0 && ColMod == 9) {
					do {
						if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
						else ok = false;
						FilaMod++;
						pos--;
					}while(ok != false && pos > -1);
					if (ok != false) {
						if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
						else ok = false;
					}
				}
				else {
					if(FilaMod == 9 && ColMod == 9) {
						if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
						else ok = false;
						if (ok != false) {
							do {
								if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
								FilaMod++;
								pos--;
							}while(ok != false && pos > -1 && FilaMod < TAB);
						}
					}
					else {
						if(FilaMod == 0) {
							do {
								if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
								FilaMod++;
								pos--;
							}while(ok != false && pos > -1);
							if (ok != false) {
								if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
							}
						}
						else {
							if(FilaMod == 9) {
								if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B' && MatSecret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
								else ok = false;
								if(ok != false) {
									do {
										if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
										else ok = false;
										FilaMod++;
										pos--;
									}while(ok != false && pos > -1 && FilaMod < TAB);
								}
							}
							else {
								if(ColMod == 0) {
									if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
									else ok = false;
									if(ok != false) {
										do {
											if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
											else ok = false;
											FilaMod++;
											pos--;
										}while(ok != false && pos > -1);
										if(ok != false && FilaMod < TAB - 1) {
											if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod + 1] != 'B') ok = true;
											else ok = false;
										}
									}
								}
								else {
									if(ColMod == 9) {
										if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
												else ok = false;
												FilaMod++;
												pos--;
											}while(ok != false && pos > -1);
											if(ok != false && FilaMod < TAB) {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B') ok = true;
												else ok = false;
											}
										}
									}
									else {
										if(MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B' && MatSecret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod ][ColMod + 1] != 'B') ok = true;
												else ok = false;
												FilaMod++;
												pos--;
											}while(ok != false && pos > -1 && FilaMod < TAB - 1);
											if(ok != false) {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod ][ColMod + 1] != 'B') ok = true;
												else ok = false;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return ok;
	}
	/**
	 * Method <b>BarcosDireccion0</b>, Comprova que és pot posar els vaixells amb direcció 0 i 1.
	 * @param FilaMod Indica la fila on comença elvaixell.
	 * @param ColMod Indica la columna on comença el vaixell.
	 * @param pos Indica el numero de posicions que tindra el vaixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param MatSecret Taulell secret, on és realitzaran totes les comprovacions.
	 * @return Retorna un boolean.
	 * 	<ul>
	 * 		<li>True: El vaixell es pot ubicar a a questa posició.</li>
	 * 		<li>False: El vaixell no es pot ubicar a aquesta posició.</li>
	 * 	</ul>
	 */
	public static boolean BarcosDireccion0(int FilaMod, int ColMod, int pos, int TAB, char[][] MatSecret) {
		boolean ok = false; //desplaçament cap a la dreta columna
		
		if(FilaMod == 0 && ColMod == 0) {
			do {
				if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
				else ok = false;
				pos--;
				ColMod++;
			}while(ok != false && pos > -1);
			if(ok != false) {
				if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
				else ok = false;
			}
		}
		else {
			if(FilaMod == 9 && ColMod == 0) {
				do {
					if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
					else ok = false;
					pos--;
					ColMod++;
				}while(ok != false && pos > -1);
				if(ok != false) {
					if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
					else ok = false;
				}
			}
			else {
				if(FilaMod == 0 && ColMod== 9) {
					do {
						if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
						else ok = false;
						pos--;
						ColMod--;
					}while(ok != false && pos > -1);
					if(ok != false && ColMod <= TAB - 1) {
						if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
						else ok = false;
					}
				}
				else {
					if(FilaMod == 9 && ColMod == 9) {
						do {
							if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
							else ok = false;
							pos--;
							ColMod--;
						}while(ok != false && pos > -1);
						if(ok != false && ColMod <= TAB -1) {
							if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
							else ok = false;
						}
					}
					else {
						if(FilaMod == 0) {
							if(MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
							else ok = false;
							if(ok != false) {
								do {
									if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
									else ok = false;
									pos--;
									ColMod++;
								}while(ok != false && pos > -1);
								if(ok != false && ColMod <= TAB - 1) {
									if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
									else ok = false;
								}
							}
						}
						else {
							if(FilaMod == 9) {
								if(MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
								else ok = false;
								if(ok != false) {
									do {
										if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
										else ok = false;
										pos--;
										ColMod++;
									}while(ok != false && pos > -1);
									if(ok != false && ColMod <= TAB - 1) {
										if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
										else ok = false;
									}
								}
							}
							else {
								if(ColMod == 0) {
									do {
										if(MatSecret[FilaMod][ColMod] == 'B' || MatSecret[FilaMod - 1][ColMod] == 'B' || MatSecret[FilaMod + 1][ColMod] == 'B') ok = false;
										else ok = true;
										pos--;
										ColMod++;
									}while(ok != false && pos > -1);//pos - 1
									if(ok != false) {
										if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
										else ok = false;
									}
								}
								else {
									if(ColMod == 9) {
										if(MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B' && MatSecret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if (ok != false) {
											do {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
												else ok = false;
												pos--;
												ColMod--;
											}while(ok != false && pos > -1);
										}
									}
									else {
										if(MatSecret[FilaMod][ColMod - 1] != 'B' && MatSecret[FilaMod - 1][ColMod - 1] != 'B' && MatSecret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B') ok = true;
												else ok = false;
												pos--;
												ColMod++;
											}while(ok != false && pos > -1 && ColMod < TAB - 1);
											if(ok != false) {
												if(MatSecret[FilaMod][ColMod] != 'B' && MatSecret[FilaMod + 1][ColMod] != 'B' && MatSecret[FilaMod - 1][ColMod] != 'B') ok = true;
												else ok = false;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return ok;
	}
	/**
	 * Method <b>comprobar</b>, comprova que el vaixell cap al taulell.
	 * @param fila Indica la fila on comença el vaixell.
	 * @param col Indica la columna on comença el vaixell.
	 * @param direccion Indica la direcció cap a on es direccionara el vaixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param pos Indica el numero de posicions que tindra el vaixell.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: El vaixell cap al taulell.</li>
	 * 		<li>False: El vaixell no cap al taulell</li>
	 * 	</ul>
	 */
	public static boolean comprobar (int fila, int col, int direccion, int TAB, int pos) {
		boolean ok = false;
		switch (direccion) {
		case 0: //dreta 0-9 columna
			if (col + pos < TAB) ok = true;
			else ok = false;
			break;
		case 1: //esquerra 9-0 columna
			if (col - pos >= 0) ok = true;
			else ok = false;
			break;
		case 2: //abaix 0-9 fila
			if (fila + pos < TAB) ok = true;
			else ok = false;
			break;
		case 3: //adalt 9-0 fila
			if (fila - pos >= 0) ok = true;
			else ok = false;
			break;
			default: ok = false;
		}
		return ok;
	}
	/**
	 * Method <b>posicionarBarco</b>, indica on comença els vaixells, la direcció i crida als methods de comprovació dels methods BarcosDireccion0 i BarcosDireccion3.
	 * La posicionació dels vaixells consisteix en comprovar que no hi ha vaixells proxims a aquest, els vaixells és posicionen de esquerra a dreta i de adalt (0-9) a abaix (9-0).
	 * @param fila Indica la fila on comença el vaixell.
	 * @param col Indica la columna on comença el vaixell.
	 * @param direccion Indica la direcció del vaixell.
	 * @param TAB Indica la alçada i la amplada del vaixell.
	 * @param pos Indica quantes posicions tindra el vaixell.
	 * @param MatSecret Conte el taulell secret, on s'escriuran els vaixells.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>Ture: S'ha escrit el vaixell al taulell.</li>
	 * 		<li>False: No s'ha esccrit el vaixell al taulell.</li>
	 * 	</ul>
	 */
	public static boolean posicionarBarco(int fila, int col, int direccion, int TAB, int pos, char[][] MatSecret) {
		boolean ok = false;
		int FilaMod = 0;
		int ColMod = 0;
		int direccion1 = 0;
		switch(direccion) {
		case 0: //dreta
			FilaMod = fila;
			ColMod = col;
			direccion1 = 0;
			break;
		case 1: //esquerra
			FilaMod = fila;
			ColMod = col - pos;
			direccion1 = 0;
			break;
		case 2: //adalt 9 - 0
			FilaMod = fila; // - pos
			ColMod = col;
			direccion1 = 3;
			break;
		case 3: //abaix 0 - 9
			FilaMod = fila - pos;
			ColMod = col;
			direccion1 = 3;
			break;
			default: ok = false;
		}
		
		if(direccion1 == 0) ok = BarcosDireccion0(FilaMod, ColMod, pos, TAB, MatSecret); 
		else ok = BarcosDireccion3(FilaMod, ColMod, pos, TAB, MatSecret);
		
		if(ok != false) IniMatrizes.escribirMatriz(FilaMod, ColMod, pos, MatSecret, direccion1); 
		
		return ok;
	}
}
