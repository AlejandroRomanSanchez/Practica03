
/**
 * Clase que sirve para hacer pruebas del método solucionaProblema de la clase
 * Queens
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos
 */
public class PruebasQueens {
    public static void main(String[] args) {
	/* Se recomienda que para visualizar mejor algunas partes, se deberían
	 * poner como comentarios aquellas líneas que no se desean ejecutar
	 */

	/* Creamos el tablero para resolver el problema clásico. Es decir,
	 * para resolver el problema de 8 reinas
	 */
	Queens tablero8 = new Queens(8);	
	System.out.println("Para 8 reinas:");
	tablero8.solucionaProblema();

	// Para una reina
	System.out.println("Para una reina:");
	Queens tablero1 = new Queens(1);
	tablero1.solucionaProblema();

	// Para dos reinas
	System.out.println("Para dos reinas: ");
	Queens tablero2 = new Queens(2);
	tablero2.solucionaProblema();

	// Para tres reinas
	System.out.println("Para tres reinas: ");
	Queens tablero3 =  new Queens(3);
	tablero3.solucionaProblema();

	// Para cuatro reinas
	System.out.println("Para cuatro reinas:");
	Queens tablero4 = new Queens(4);
	tablero4.solucionaProblema();

	// Para cinco reinas
	System.out.println("Para cinco reinas:");
	Queens tablero5 = new Queens(5);
	tablero5.solucionaProblema();

	// Para seis reinas
	System.out.println("Para seis reinas: ");
	Queens tablero6 = new Queens(6);
	tablero6.solucionaProblema();

	// Para siete reinas
	System.out.println("Para siete reinas:");
	Queens tablero7 = new Queens(7);
	tablero7.solucionaProblema();

	// Para diez reinas
	System.out.println("Para siete reinas:");
	Queens tablero10 = new Queens(10);
	tablero10.solucionaProblema();
    }    

}
