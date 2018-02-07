package enfonsarlaflota;
/**
 * <h2>Clase Comprovaciones</h2>
 * Conte tots els methods que comproven que els baixells es posicionen a una ubicació coorecte, a més de escriure els baixells als taulers i comprovar si estan undits o tocats.
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class Comprovaciones {
	/**
	 * Method <b>comprovarTirada</b>, comprova si el baixell esta tocat o undit, i mostra per consola el resultat.
	 * @param fila Indica la fila on esta situat el baixell.
	 * @param col Indica la columna on esta situat el baixell.
	 * @param maq1Sol És el taulell que es mostra a tot el mon.
	 * @param maq1Secret És el taulell que conte la solucio secreta.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param Player Indica el jugador.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: Baixell Undit.</li>
	 * 		<li>False: Baixell Tocat.</li>
	 * 	</ul>
	 */
	public static boolean comprovarTirada(int fila, int col, char[][] maq1Sol, char[][] maq1Secret, int TAB, int Player) {
		int i = 1;
		boolean ok = true;
		//comprovar si esta undit:
		if(fila == 0 && col == 0) {
			if(maq1Secret[fila][col + 1] == 'B') {
				while(ok != false && maq1Secret[fila][col + i] != 'A' && col + i < TAB - 1) {
					if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) i++;
					else ok = false;
				}
				if(ok != false && maq1Secret[fila][col + i] != 'A') {
					if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) ok = true;
					else ok = false;
				}
			}
			else {
				while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
					if(maq1Secret[fila + 1][col] == maq1Sol[fila + i][col]) i++;
					else ok = false;
				}
				if(ok != false && maq1Secret[fila + i][col] != 'A') {
					if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
					else ok = false;
				}
			}
		}
		else {
			if(fila == 0 && col == 9) {
				if(maq1Secret[fila][col - 1] == 'B') {
					while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
						if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
						else ok = false;
					}
					if(ok != false && maq1Secret[fila][col - i] != 'A') {
						if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
						else ok = false;
					}
				}
				else {
					while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
						if(maq1Secret[fila + 1][col] == maq1Sol[fila + i][col]) i++;
						else ok = false;
					}
					if (ok != false && maq1Secret[fila + i][col] != 'A') {
							if(maq1Secret[fila + 1][col] == maq1Sol[fila + i][col]) ok = true;
							else ok = false;
					}
				}
			}
			else {
				if(fila == 9 && col == 0) {
					if(maq1Secret[fila - 1][col] == 'B') {
						while(ok != false && maq1Secret[fila - i][col] != 'A' && fila - i > 0) {
							if(maq1Secret[fila - 1][col] == maq1Sol[fila - i][col]) i++;
							else ok = false;
						}
						if(ok != false && maq1Secret[fila - i][col] != 'A') {
							if(maq1Secret[fila - 1][col] == maq1Sol[fila - i][col]) ok = true;
							else ok = false;
						}
					}
					else {
						while(ok != false && maq1Secret[fila][col + i] != 'A' && col + i < TAB - 1) {
							if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) i++;
							else ok = false;
						}
						if(ok != false && maq1Secret[fila][col + i] != 'A') {
							if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) ok = true;
							else ok = false;
						}
					}
				}
				else {
					if(fila == 9 && col == 9) {
						if(maq1Secret[fila - 1][col] == 'B') {
							while(ok != false && maq1Secret[fila - i][col] != 'A' && fila - i > 0) {
								if(maq1Secret[fila - 1][col] == maq1Sol[fila - i][col]) i++;
								else ok = false;
							}
							if(ok != false && maq1Secret[fila - i][col] != 'A') {
								if(maq1Secret[fila - 1][col] == maq1Sol[fila - i][col]) ok = true;
								else ok = false;
							}
						}
						else {
							while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
								if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
								else ok = false;
							}
							if(ok != false && maq1Secret[fila][col - i] != 'A') {
								if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
								else ok = false;
							}
						}
					}
					else {
						if(fila == 0) {
							if(maq1Secret[fila][col + 1] == 'B') {
								while(col + i < TAB && ok != false) { //TAB - 1
									if(maq1Secret[fila][col + i] != 'A') i++;
									else ok = false;
								}
								if(i > 9) i--; //esto no estaba pruebas????
								col = col + i;
								i = 1;
								ok = true;
								while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
									if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
									else ok = false;
								}
								if(ok != false && maq1Secret[fila][col - i] != 'A') {
									if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
									else ok = false;
								}
							}
							else {
								if(maq1Secret[fila][col - 1] == 'B') {
									while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
										if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
										else ok = false;
									}
									if(ok != false && maq1Secret[fila][col - i] != 'A') {
										if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
										else ok = false;
									}
								}
								else {
									//para abajo
									while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
										if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
										else ok = false;
									}
									if(ok != false && maq1Secret[fila + i][col] != 'A') {
										if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
										else ok = false;
									}
								}
							}
						}
						else {
							if(fila == 9) {
								if(maq1Secret[fila][col + 1] == 'B') {
									while(col + i < TAB && ok != false) { //TAB -1
										if(maq1Secret[fila][col + i] != 'A') i++;
										else ok = false;
									}
									col = col + i;
									i = 1;
									ok = true;
									while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
										if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
										else ok = false;
									}
									if(ok != false && maq1Secret[fila][col - i] != 'A') {
										if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
										else ok = false;
									}
								}
								else {
									if(maq1Secret[fila][col - 1] == 'B') {
										while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) { //0
											if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
											else ok = false;
										}
										if(ok != false && maq1Secret[fila][col - i] != 'A') {
											if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
											else ok = false;
										}
									}
									else {
										while(ok != false && maq1Secret[fila - i][col] != 'A' && fila - i > 0) {
											if(maq1Secret[fila - i][col] == maq1Sol[fila - i][col]) i++;
											else ok = false;
										}
										if(ok != false && maq1Secret[fila - i][col] != 'A') {
											if(maq1Secret[fila - i][col] == maq1Sol[fila - i][col]) ok = true;
											else ok = false;
										}
									}
								}
							}
							else {
								if (col == 0) {
									if(maq1Secret[fila - 1][col] == 'B') {
										while(ok != false && fila - i > -1) { //0
											if(maq1Secret[fila - i][col] == 'B') i++;
											else ok = false;
										}
										fila = fila - i;
										i = 1;
										ok = true;
										while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
											if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
											else ok = false;
										}
										if(ok != true && maq1Secret[fila + i][col] != 'A') {
											if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
											else ok = false;
										}
									}
									else {
										if(maq1Secret[fila + 1][col] == 'B') {
											while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
												if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
												else ok = false;
											}
											if(ok != false && maq1Secret[fila + i][col] != 'A') {
												if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
												else ok = false;
											}
										}
										else {
											while(ok != false && maq1Secret[fila][col + i] != 'A' && col + i < TAB - 1) {
												if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) i++;
												else ok = false;
											}
											if(ok != false && maq1Secret[fila][col + i] != 'A') {
												if(maq1Secret[fila][col + i] == maq1Sol[fila][col + i]) ok = true;
												else ok = false;
											}
										}
									}
								}
								else {
									if(col == 9) {
										if(maq1Secret[fila - 1][col] == 'B') {
											while(ok != false && fila - i > -1) { //0
												if(maq1Secret[fila - i][col] == 'B') i++;
												else ok = false;
											}
											fila = fila - i;
											i = 1;
											ok = true;
											while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
												if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
												else ok = false;
											}
											if (ok != false && maq1Secret[fila + i][col] != 'A') {
												if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
												else ok = false;
											}
										}
										else {
											if(maq1Secret[fila + 1][col] == 'B') {
												while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB -1) {
													if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
													else ok = false;
												}
												if (ok != false && maq1Secret[fila + i][col] != 'A') {
													if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
													else ok = false;
												}
											}
											else {
												while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
													if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
													else ok = false;
												}
												if (ok != false && maq1Secret[fila][col - i] != 'A') {
													if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
													else ok = false;
												}
											}
										}
									}
									else {
										if(maq1Secret[fila][col + 1] == 'B') {
											while(col + i < TAB && ok != false) { //TAB -1
												if(maq1Secret[fila][col + i] != 'A') i++;
												else ok = false;
											}
											col = col + i;
											i = 1;
											ok = true;
											while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) {
												if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
												else ok = false;
											}
											if (ok != false && maq1Secret[fila][col - i] != 'A') {
												if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
												else ok = false;
											}
										}
										else {
											if(maq1Secret[fila][col - 1] == 'B') {
												while(ok != false && maq1Secret[fila][col - i] != 'A' && col - i > 0) { // 0
													if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) i++;
													else ok = false;
												}
												if(ok != false && maq1Secret[fila][col - i] != 'A') {
													if(maq1Secret[fila][col - i] == maq1Sol[fila][col - i]) ok = true;
													else ok = false;
												}
											}
											else {
												if(maq1Secret[fila - 1][col] == 'B') {
													while(ok != false && fila - i > -1) { // 0
														if(maq1Secret[fila - i][col] == 'B') i++;
														else ok = false;
													}
													fila = fila - i;
													i = 1;
													ok = true;
													while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) {
														if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
														else ok = false;
													}
													if (ok != false && maq1Secret[fila + i][col] != 'A') {
														if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
														else ok = false;
													}
												}
												else {
													while(ok != false && maq1Secret[fila + i][col] != 'A' && fila + i < TAB - 1) { // -1
														if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) i++;
														else ok = false;
													}
													if (ok != false && maq1Secret[fila + i][col] != 'A') {
														if(maq1Secret[fila + i][col] == maq1Sol[fila + i][col]) ok = true;
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
			if (ok == true) System.out.println("Baixell enfonsat");
			else System.out.println("Baixell tocat.");
		}
		return ok;
	}
	/**
	 * Method <b>comprovarTablero</b>, Comprova si tots els baixells dels taulell han sigut descoberts.
	 * @param Solucion Taulell que tot el mon pot veure.
	 * @param Secret Taulell que conte la solucio, secret.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param Player Indica el jugador.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: Tots els baixells trobats i undits.</li>
	 * 		<li>False: Algun baixell no torbat o no undit.</li>
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
	 * Method <b>BarcosDireccion3</b>, Comprova que és pot posar els baixells amb direccio 2 i 3.
	 * @param FilaMod Indica la fila on comença el baixell.
	 * @param ColMod Indica la columna on comença el baixell.
	 * @param pos Indica el numero de posicions que tindra el baixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param maq1Secret Taulell secret, on es realitzaran totes les comprovacions.
	 * @return Retorna un boolean.
	 * 	<ul>
	 * 		<li>True: El baixell es pot ubicar a a questa posició.</li>
	 * 		<li>False: El baixell no es pot ubicar a aquesta posició.</li>
	 * 	</ul>
	 */
	public static boolean BarcosDireccion3(int FilaMod, int ColMod, int pos, int TAB, char[][] maq1Secret) {
		boolean ok = false; //desplacamiento hacia el 9 de 0 a 9
		
		if(FilaMod == 0 && ColMod == 0) {
			do {
				if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B') ok = true;
				else ok = false;
				FilaMod++;
				pos--;
			}while(ok != false && pos > -1);
			if(ok != false) {
				if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
				else ok = false;
			}
		}
		else {
			if(FilaMod == 9 && ColMod == 0) {
				if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
				else ok = false;
				if (ok != false) {
					do {
						if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B') ok = true;
						else ok = false;
						FilaMod++;
						pos--;
					}while(ok != false && pos > -1 && FilaMod <= TAB - 1);
				}
			}
			else {
				if(FilaMod == 0 && ColMod == 9) {
					do {
						if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
						else ok = false;
						FilaMod++;
						pos--;
					}while(ok != false && pos > -1);
					if (ok != false) {
						if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
						else ok = false;
					}
				}
				else {
					if(FilaMod == 9 && ColMod == 9) {
						if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
						else ok = false;
						if (ok != false) {
							do {
								if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
								FilaMod++;
								pos--;
							}while(ok != false && pos > -1 && FilaMod < TAB);
						}
					}
					else {
						if(FilaMod == 0) {
							do {
								if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
								FilaMod++;
								pos--;
							}while(ok != false && pos > -1);
							if (ok != false) {
								if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
								else ok = false;
							}
						}
						else {
							if(FilaMod == 9) {
								if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B' && maq1Secret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
								else ok = false;
								if(ok != false) {
									do {
										if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B') ok = true;
										else ok = false;
										FilaMod++;
										pos--;
									}while(ok != false && pos > -1 && FilaMod < TAB);
								}
							}
							else {
								if(ColMod == 0) {
									if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
									else ok = false;
									if(ok != false) {
										do {
											if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B') ok = true;
											else ok = false;
											FilaMod++;
											pos--;
										}while(ok != false && pos > -1);
										if(ok != false && FilaMod < TAB - 1) {
											if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod + 1] != 'B') ok = true;
											else ok = false;
										}
									}
								}
								else {
									if(ColMod == 9) {
										if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
												else ok = false;
												FilaMod++;
												pos--;
											}while(ok != false && pos > -1);
											if(ok != false && FilaMod < TAB) {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B') ok = true;
												else ok = false;
											}
										}
									}
									else {
										//System.out.println("Fila " + FilaMod + " Col " + ColMod + " Direccion ");
										if(maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B' && maq1Secret[FilaMod - 1][ColMod + 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod ][ColMod + 1] != 'B') ok = true;
												else ok = false;
												FilaMod++;
												pos--;
											}while(ok != false && pos > -1 && FilaMod < TAB - 1);
											if(ok != false) {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod ][ColMod + 1] != 'B') ok = true;
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
	 * Method <b>BarcosDireccion0</b>, Comprova que és pot posar els baixells amb direccio 0 i 1.
	 * @param FilaMod Indica la fila on comença el baixell.
	 * @param ColMod Indica la columna on comença el baixell.
	 * @param pos Indica el numero de posicions que tindra el baixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param maq1Secret Taulell secret, on es realitzaran totes les comprovacions.
	 * @return Retorna un boolean.
	 * 	<ul>
	 * 		<li>True: El baixell es pot ubicar a a questa posició.</li>
	 * 		<li>False: El baixell no es pot ubicar a aquesta posició.</li>
	 * 	</ul>
	 */
	public static boolean BarcosDireccion0(int FilaMod, int ColMod, int pos, int TAB, char[][] maq1Secret) {
		boolean ok = false; //desplacamiento hacia la derecha
		
		if(FilaMod == 0 && ColMod == 0) {
			do {
				if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
				else ok = false;
				pos--;
				ColMod++;
			}while(ok != false && pos > -1);
			if(ok != false) {
				if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
				else ok = false;
			}
		}
		else {
			if(FilaMod == 9 && ColMod == 0) {
				do {
					if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
					else ok = false;
					pos--;
					ColMod++;
				}while(ok != false && pos > -1);
				if(ok != false) {
					if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
					else ok = false;
				}
			}
			else {
				if(FilaMod == 0 && ColMod== 9) {
					do {
						if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
						else ok = false;
						pos--;
						ColMod++;
					}while(ok != false && pos > -1);
					if(ok != false && ColMod <= TAB - 1) {
						if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
						else ok = false;
					}
				}
				else {
					if(FilaMod == 9 && ColMod == 9) {
						do {
							if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
							else ok = false;
							pos--;
							ColMod++;
						}while(ok != false && pos > -1);
						if(ok != false && ColMod <= TAB -1) {
							if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
							else ok = false;
						}
					}
					else {
						if(FilaMod == 0) {
							if(maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
							else ok = false;
							if(ok != false) {
								do {
									if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
									else ok = false;
									pos--;
									ColMod++;
								}while(ok != false && pos > -1);
								if(ok != false && ColMod <= TAB - 1) {
									if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
									else ok = false;
								}
							}
						}
						else {
							if(FilaMod == 9) {
								if(maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B') ok = true;
								else ok = false;
								if(ok != false) {
									do {
										if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
										else ok = false;
										pos--;
										ColMod++;
									}while(ok != false && pos > -1);
									if(ok != false && ColMod <= TAB - 1) {
										if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
										else ok = false;
									}
								}
							}
							else {
								if(ColMod == 0) {
									do {
										if(maq1Secret[FilaMod][ColMod] == 'B' || maq1Secret[FilaMod - 1][ColMod] == 'B' || maq1Secret[FilaMod + 1][ColMod] == 'B') ok = false;
										else ok = true;
										pos--;
										ColMod++;
									}while(ok != false && pos > -1);//pos - 1
									if(ok != false) {
										if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
										else ok = false;
									}
								}
								else {
									if(ColMod == 9) {
										if(maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B' && maq1Secret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if (ok != false) {
											do {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
												else ok = false;
												pos--;
												ColMod++;
											}while(ok != false && pos > -1);
										}
									}
									else {
										if(maq1Secret[FilaMod][ColMod - 1] != 'B' && maq1Secret[FilaMod - 1][ColMod - 1] != 'B' && maq1Secret[FilaMod + 1][ColMod - 1] != 'B') ok = true;
										else ok = false;
										if(ok != false) {
											do {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B') ok = true;
												else ok = false;
												pos--;
												ColMod++;
											}while(ok != false && pos > -1 && ColMod < TAB - 1);
											if(ok != false) {
												if(maq1Secret[FilaMod][ColMod] != 'B' && maq1Secret[FilaMod + 1][ColMod] != 'B' && maq1Secret[FilaMod - 1][ColMod] != 'B') ok = true;
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
	 * Method <b>comprobar</b>, comprova que el baixell cap al taulell.
	 * @param fila Indica la fila on comença el baixell.
	 * @param col Indica la columna on comença el baixell.
	 * @param direccion Indica la direcció cap a on es direccionara el baixell.
	 * @param TAB Indica la alçada i la amplada del taulell.
	 * @param pos Indica el numero de posicions que tindra el baixell
	 * @param maq1Secret Conte el taulell on es grabaran els baixells.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>True: El baixell cap al taulell.</li>
	 * 		<li>False: El baixell no cap al taulell</li>
	 * 	</ul>
	 */
	public static boolean comprobar (int fila, int col, int direccion, int TAB, int pos, char[][] maq1Secret) {
		boolean ok = false;
		//System.out.println("Fila " + fila + " col " + col + " direccon " + direccion + " ok " + ok);
		switch (direccion) {
		case 0: //derecha 0-9
			if (col + pos < TAB) ok = true;
			else ok = false;
			break;
		case 1: //izquierda 9-0
			if (col - pos >= 0) ok = true;
			else ok = false;
			break;
		case 2: //abajo 0 - 9
			if (fila + pos < TAB) ok = true;
			else ok = false;
			break;
		case 3: //arriba 9 - 0
			if (fila - pos >= 0) ok = true;
			else ok = false;
			break;
			default: ok = false;
		}
		//System.out.println("Fila " + fila + " col " + col + " direccon " + direccion + " ok " + ok);
		return ok;
	}
	/**
	 * Method <b>posicionarBarco</b>, indica on comença els baixells, la direccio i crida als methods de comprovacio dels methods BarcosDireccion0 i BarcosDireccion3.
	 * @param fila Indica la fila on comença el baixell.
	 * @param col Indica la columna on comença el baixell.
	 * @param direccion Indica la direcció del baixell.
	 * @param TAB Indica la alçada i la amplada del baixell.
	 * @param pos Indica quantes posicions tindra el baixell.
	 * @param maq1Secret Conte el taulell secret, on s'escriuran els baixells.
	 * @return Retorna un boolean:
	 * 	<ul>
	 * 		<li>Ture: S'ha escrit el baixell al taulell.</li>
	 * 		<li>False: No s'ha esccrit el baixell al taulell.</li>
	 * 	</ul>
	 */
	public static boolean posicionarBarco(int fila, int col, int direccion, int TAB, int pos, char[][] maq1Secret) {
		boolean ok = false;
		int FilaMod = 0;
		int ColMod = 0;
		int direccion1 = 0;
		//la posicionacion de los barcos consiste en comprovar que no hay barcos proximos a este, los barcos se posicionan de izquierda a derecha i de arriba(0-9) a abajo (9-0).
		switch(direccion) {
		case 0: //derecha
			FilaMod = fila;
			ColMod = col;
			direccion1 = 0;
			break;
		case 1: //izquierda
			FilaMod = fila;
			ColMod = col - pos;
			direccion1 = 0;
			break;
		case 2: //arriba 9 - 0
			FilaMod = fila; // - pos
			ColMod = col;
			direccion1 = 3;
			break;
		case 3: //Abajo 0 - 9
			FilaMod = fila - pos;
			ColMod = col;
			direccion1 = 3;
			break;
			default: ok = false;
		}
		
		if(direccion1 == 0) ok = BarcosDireccion0(FilaMod, ColMod, pos, TAB, maq1Secret); //reescrivir
		else ok = BarcosDireccion3(FilaMod, ColMod, pos, TAB, maq1Secret); //reescrivir
		
		if(ok != false) IniMatrizes.escribirMatriz(FilaMod, ColMod, pos, maq1Secret, direccion1); //reescrivir
		
		return ok;
	}
}
