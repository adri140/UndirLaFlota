package enfonsarlaflota;

/**
 * <h2>Clase RUN, és la classe principal, executa el programa.</h2>
 * @author Adrian Recio Marín
 * @version Console-2
 * @since 10/02/2018
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
		System.out.println("Gràcies per jugar.");
	}
}
