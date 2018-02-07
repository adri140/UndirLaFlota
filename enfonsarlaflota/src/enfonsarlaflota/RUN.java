package enfonsarlaflota;

/**
 * <h2>Clase RUN, és la classe principal, ejecuta el programa.</h2>
 * @author Adrian Recio Marín
 * @version 1.0.A
 * @since 6/2/2018
 */
public class RUN {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char resp; //resposta de l'usuari
		
		System.out.println("\nBenvinguts a ENFONSAR LA FLOTA \n");
		do {
			Joc.joc();
			resp = Entradas.charUser("del joc: ");
		}while(resp != 's' && resp != 'S');
		System.out.println("Gracies per jugar.");
	}
}
