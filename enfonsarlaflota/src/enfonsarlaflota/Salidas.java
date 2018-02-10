package enfonsarlaflota;
/**
 * <h2>Clase Salidas, conte totes els methods que mostren per consola les dades de sortida (no mostra els misatges de error, ni els missatges que es mostren havans de la entrada de dades)</h2>
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
 */
public class Salidas {
	/**
	 * Method <b>mostrar</b>, mostra per consola el taulell compartit des de una altre clase i method.
	 * @param MatSol Taulell que es visualitzara per consola
	 * @param TAB Amplada i alçada del taulell
	 */
	public static void mostrar(char[][] MatSol, int TAB) {
		char car = 'A';
		System.out.println("    0 1 2 3 4 5 6 7 8 9 ");
		for (int i = 0; i < TAB; i++) {
			System.out.print(car + "  |");
			car = (char) (car + 1);
			for(int p = 0; p < TAB; p++) {
				System.out.print(MatSol[i][p] + "|");
			}
			System.out.println("");
		}
	}
}
