package enfonsarlaflota;
/**
 * <h2>Clase Salidas, conte totes els methods que mostren per consola les dades de sortida</h2>
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class Salidas {
	/**
	 * Method <b>mostrar</b>, mostra per consola el taulell compartit des de una altre clase i method.
	 * @param maq1Sol Taulell que es visualitzara per consola
	 * @param TAB Amplada i alçada del taulell
	 */
	public static void mostrar(char[][] maq1Sol, int TAB) {
		char car = 'A';
		System.out.println("   0123456789");
		for (int i = 0; i < TAB; i++) {
			System.out.print(car + "  ");
			car = (char) (car + 1);
			for(int p = 0; p < TAB; p++) {
				System.out.print(maq1Sol[i][p]);
			}
			System.out.println("");
		}
	}
}
