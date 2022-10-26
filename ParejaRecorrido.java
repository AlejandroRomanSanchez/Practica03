
/**
 * Esta clase es auxiliar a la clase Laberinto. En los objetos de esta 
 * clase se almacenan una posición vertical y una horizontal en el 
 * laberinto, así como la dirección que se tomó cuando se estaba en ese 
 * punto. Por ejemplo, posición (9,3) hacia la izquierda. Esto sirve para
 * tener un registro completo de la acción que se tomó cuando se encontraba
 * en ese punto en el laberinto
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octrubre 2022
 * @since Estructura de datos 2023-1
 */
public class ParejaRecorrido {
    public int posicionVertical; // Almacena la posición vertical
    public int posicionHorizontal; // Almacena la posición horizontal
    // Almacena la dirección que se tomó cuando se encontraba en esa posición
    public int flecha; 

    /**
     * Constructor de la clase ParejaRecorrido
     * @param posicionX Es la posición vetical
     * @param posicionY Es la posición horizontal
     * @param direccion Es la dirección que se tomó en ese punto en el tablero
     * 0 es izquierda, 1 es abajo, 2 es derecha y 3 es arriba. Es posbile ingresar
     * otro números enteros, pero no importa pues en los métodos en que se utilizaron 
     * los objetos de esta clase, se tuvo el cuidado de que solo pueda tomar valores
     * 0, 1, 2 y 3
     */
    public ParejaRecorrido(int posicionX, int posicionY, int direccion) {
	posicionVertical = posicionX;
	posicionHorizontal = posicionY;
	flecha = direccion;
    }

    /**
     * Devuelve la posicion vertical
     * @return la posición vertical
     */
    public int proyeccionVertical() {
	return posicionVertical;
    }

    /**
     * Devuelve la posición horizontal
     * @return La posición horizontal
     */
    public int proyeccionHorizontal() {
	return posicionHorizontal;
    }

    /**
     * Devuelve la dirección que se tomó cuando nos encontrabamos en esa posición en el
     * laberinto. 0 si fue a la izquierda, 1 si fue hacia abajo, 2, si fue a la derecha y 
     * 3 si fue hacia arriba. Puede devolver otros valores, pero se tuvo el cuidado de que 
     * en los lugares donde se utilizaron objetos de esta clase, solo se manejen 0, 1, 2 
     * y 3
     * @return Devulve un entero; 0 significa a la izquierda, 1 hacia abajo, 2 hacia la derecha
     * y 3 hacia arriba. Puede devolver otros valores, pero se tuvo el cuidado de que cada vez
     * que se utilizaban los objetos de esta clase, este método solo devolviera los valores 0,
     * 1, 2 y 3
     */
    public int proyeccionFlecha() {
	return flecha;
    }
}

