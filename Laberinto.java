
/** Esta clase permite construir un laberinto y también permite
 * solucionarlo, partiendo de la posición (0, 0) y llegando a la
 * posición (N - 1, N -1), donde N es un entero mayor o igual que 1
 * que es determinado por el usuarion. En caso de no existir 
 * solución, el programa lo señala
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2023-1
 * @since Estrucutras de datos 2023-1
 */
public class Laberinto {
    private int[][] tablero; // Variable que apunta a una representación del laberinto
    /* El laberinto será cuadrado, y esta variable almacena la longitud de los lados de este
     * tablero
     */
    private int longitudTablero; 

    /**
     * Contructor de la clase Laberinto.
     * @param ladoTablero el entero ingresado indica la longitud de los lados del 
     * laberinto. El laberinto será cuadrado
     */
    public Laberinto(int ladoTablero) {
	// El tablero será el cuadrado del entero ingresado
	tablero = new int[ladoTablero][ladoTablero]; 

	/* Ingresamo un cero cada entrada del arreglo. El cero representará que esa
	 * posición en el laberinto corresponde a una espacio libre
	 */
	for(int i = 0; i < ladoTablero; i++) {
	    for(int j = 0; j < ladoTablero; j++) {
		tablero[i][j] = 0;
	    }
	}
	// Almacena la longitud de los lados del tablero
	longitudTablero = ladoTablero;
    }    

    /**
     * Ingresa un valor entero en una posición del tablero
     * @param valorInsertado Número entero que se desea ingresar en el tablero
     * @param posicionX Es la posición vertical en el que se desea ingresar el valor
     * @param posicionY Es la posición horizontal en el que se desea ingresar el valor
     */
    private void insertaValor(int valorInsertado, int posicionX, int posicionY)
	throws IndexOutOfBoundsException {
	// Si las posiciones ingresada son negativas, lanza una excepción
	if (posicionX < 0 || posicionY < 0) {
	    throw new IndexOutOfBoundsException("Posición fuera del rango");
	}
	/* Si las posiciones ingresadas son mayores o iguales que las longitud de los
	 * lados del tbalero, se lanza una excepción
	 */
	if (posicionX >= tablero.length || posicionY >= tablero.length) {
	    throw new IndexOutOfBoundsException("Posición fuera del rango");
	}
	/* En caso de que la posición ingresada es válida, lo único que hacemos es ingresar
	 * el valor del primer parámetro en el tablero del laberinto
	 */
	tablero[posicionX][posicionY] = valorInsertado;
    }

    /**
     * Imprime el estado actual del laberinto. El número 0 indica que se tiene un espacio
     * libre que no se ha recorrido. El número 1, indica que se tiene una pared. Y el 
     *número 2 indica que se tiene un espacio libre que ha sido recorrido.
     */
    public void imprimeLaberinto() {
	// Recorremos todas las posiciones del tablero del laberinto
	for(int i = 0; i < tablero.length; i++) {
	    for(int j = 0; j < tablero.length; j++) {
		//Imprimimos el estado de la casilla
		System.out.print(tablero[i][j] + " "); 
	    }
	    System.out.println();
	}
	System.out.println();
    }

    /**
     * Inserta una pared en el tablero. Es decir, insertamos un 1 en cierta la 
     * posición ingresada
     * @param posicionX es la posición vertical en el que se ingresará la pared
     * @param posicionY Es la posición horizontal en la que se ingresará la
     * pared
     */
    public void insertaPared(int posicionX, int posicionY) {
	// Solo ingresa un 1 en la posición ingresada
	insertaValor(1, posicionX, posicionY);
    }

    /**
     * Marca la posición ingresada como que ya fue visitada. Es decir, coloca un
     * 2 en dicha posición
     * @param posicionX posición vertical en el que se marcará la visita
     * @param posicionY posición horizontal en el que se marcará la visita
     */
    public void marcaCasillaVisitada(int posicionX, int posicionY) {
	// Solo inserta un 2 en la posición ingresada
	insertaValor(2, posicionX, posicionY);
    }

    /**
     * Dada la posición ingresada, este método nos indica si nos podemos mover en la 
     * dirección ingresada. 0 indica a la derecha, 1 hacia abajo, 2 a la izquierda y 3 
     * hacia arriba. Si se ingresa un número mayor a 3, se devuelve false
     * @param direccion Dirección hacia la cual se desea mover
     * @param posicionX posición vertical
     * @param posicionY posición horizontal
     * @return true, si nos podemos mover hacia la dirección ingresada; false, en caso 
     * contrario o si se ingresa un número mayor a 3
     */
    public boolean intentaMovimiento(int direccion, int posicionX, int posicionY) {
	// Si se ingresa un número mayor a 3, se devuelve false
	if (direccion > 3) {
		return false;
	    }
	
	// Verificamos si a la derecha existe casilla a la cual podemos movernos
	if(direccion == 0 &&
	   (posicionY + 1 < longitudTablero) &&
	   (int)tablero[posicionX][posicionY + 1] == 0) {	    
	    return true; // Devuelve true si nos podemos mover a la derecha
	} else if(direccion == 1 &&
		  (posicionX + 1 < longitudTablero) &&
		  (int)tablero[posicionX + 1][posicionY] == 0) {
	    /* Verificamos si nos podemos mover ahcia abajo. Devuelve true si es
	     * posible
	     */
	    return true;
	    } else if(direccion == 2 &&
		      (posicionY - 1 > -1) && (int)tablero[posicionX][posicionY - 1] == 0) {
	    // Verifica si nos podemos mover hacia abajo, devuelve true si es posible
	    return true;
	} else if(direccion == 3 &&
		  (posicionX - 1 > -1) && (int)tablero[posicionX - 1][posicionY] == 0) {
	    // Verifica si nos podemos devolver hacia arriba, devuelve true si es posible
	    return true;
	} else { // Devuelve false si no es posible movernos hacia ninguna de las 4 direcciones
	    return false;
	}
    }

    /**
     * Recuerde que vamos a representar cada dirección de la siguiente manera; 0 hacia la
     * derecha, 1 hacia abajo, 2 hacia la izquierda y 3 hacia arriba. Este método nos devuelve la 
     * primera dirección mayor o igual a la ingresada como número tal que es posible movernos hacia 
     * ella. En caso de que no exista dicha dirección, devuelve el número 4, lo que no representa
     * ninguna dirección.
     * @param direccion La dirección a partir del cual queremos encontrar una dirección disponible.
     * Recuerde que el orden es el siguiente: 0 hacia la derecha, 1 hacia abajo, 2 hacia la 
     * izquierda y 3 hacia arriba
     * @param posicionX La posición vertical
     * @param posicionY La posición horizontal
     * @return La dirección mayor o igual a la ingresada tal que nos podemos mover hacia ella.
     * Recuerde que 0 indica hacia la derecha, 1 hacia abajo, 2 hacia la izquierda y 3 hacia arriba.
     * Si devulve el número 4, indice que no existió dirección alguna a la que nos pudimos mover y 
     * que sea mayor o igual a la ingresada. Pues el 4 no indica dirección alguna
     */
    public int devuelveDireccionDisponible(int direccion, int posicionX, int posicionY) {
	/* Esta variable almacenará el resultado. En caso de que no encontremos nada en el siguiente
	 * siguiente ciclo for, devolvemos el 4, lo que indicaría que no existe una dirección 
	 * mayor o igual al ingresado tal que podemos dirigirnos hacia ella
	 */
	int resultado = 4; 
	// Recorremos todas las direcciones a aprtir de la ingresada.
	for(int i = direccion; i < 4; i++) {
	    /* Cuando encontremos la primera dirección a la que es posible dirigirse,
	     * entonces guardamos la dirección en la cual nos encontramos en esta 
	     * iteración y rompemos este ciclo for
	     */
	    if( intentaMovimiento(i, posicionX, posicionY)) {	
		resultado = i;
		break;
	    }
	}
	return resultado;
    }

    /**
     * Ingresada una dirección y una posición vertical, indica la nueva posición 
     * vertical a la cual terminas estando al moverte hacia esa dirección.
     * @param direccion La dirección a la cual nso movemos
     * @param posicionX La posición vertical en el cual nos encontramos
     * @return La posición vertical a la cual nos encontramos después de 
     * dirigirnos hacia la dirección ingresada
     */
    public int mueveVerticalmente(String direccion, int posicionX) {
	// Si nos movemos hacia arriba, solo restamos una unidad a posicionX
	if(direccion.equals("Arriba")) {
	    return posicionX - 1;
	}
	// Si nos movemos hacia abajo, solo sumamos una unidad a posicionX
	if(direccion.equals("Abajo")) {
	    return posicionX + 1;
	}
	// Si nos movemos hacia cualquier otra dirección, posicionX no cambia
	return posicionX;
    }

    /**
     * Ingresada una dirección y una posición horizontal, indica la nueva posición
     * horizontal a la cual terminas estando al moverte hacia esa dirección.
     * @param direccion La dirección hacia donde nos queremos mover
     * @param poscicionY La posición horizontal en donde nos encontramos
     * @return La nueva posición horizontal en el que nos encontramos
     */
    public int mueveHorizontalmente(String direccion, int posicionY) {
	// Si nos movemos a la derecha, sumamos una unidad a posicionY
	if(direccion.equals("Derecha")) {
	    return posicionY + 1;
	}
	// Si nos movemos a la iquierda, restamos una unidad a posicionY
	if(direccion.equals("Izquierda")) {
	    return posicionY - 1;
	}
	// Si nos movemos hacia cualquier otra dirección, posicionY no cambia
	return posicionY;
    }

    /**
     * Quita la visita en la casilla en el que nos encontramos. Es decir, solo 
     * colocamos un 0 en la casilla actual
     * @param posicionX La posición vertical en el que nos encontramos
     * @param posicionY La posición horizontal en el que nos encontramo
     */
    public void quitaVisita(int posicionX, int posicionY) {
	// Solo coloca un 0 en la posición ingresada
	tablero[posicionX][posicionY] = 0;
    }

    /**
     * Este método nos devuelve una cadena en el cual se describe cómo podemos 
     * llegar a la meta. Comenzamos en (0, 0) y la meta debe estar en 
     * (N- 1, N -1), donde N es la longitud de los lados del laberinto. En caso 
     * de que no sea posible resolver el laberinto, se devuelve un mensaje de fracaso.
     * Además, se muestra visualmente la solución al laberinto. Un 0 en el tablero,
     * representa una casilla sin pared que no fue visitada, el 1 indica una pared y
     * el 2 indica una casilla sin pared que se tuvo recorrer para llegar a la meta
     * @return Una cadena que indica cómo llegar a la meta. En caso de que no sea 
     * posible, devuelve un mensaje de fracaso
     */
    public String caminaAMeta() {
	int posicionX = 0; // Comenzamos en la posición vertical 0
	int posicionY = 0; // Comenzamos en la posición horizontal 0
	String mensajeFracaso = "No es posible llegar a la meta"; // Mesaje de fracaso
	/* Almacenamos las 4 direcciones en un arreglo. Note que el arreglo
	 * condiciona un orden de estas direcciones mediante el índice que tiene cada
	 * uno de ellos. Esto servirá para determinar un orden a la hroa de recorrer 
	 * las direcciones
	 */
	String[] direcciones = {"Derecha", "Abajo", "Izquierda", "Arriba"};
	/* Pila donde colocaremos las casillas que hemos recorrido y la dirección que 
	 * tomamos cuando estuvimos ahí.
	 */
	Stack<ParejaRecorrido> pilaRecorrido = new Stack<>();
	Stack<Integer> direccionesPendientes = new Stack<>();	
	ParejaRecorrido direccion; // Almacenamos la posición y al dirección que tomamos
	/* en esta variable construimos el recorrido para llegar a la meta. En caso de
	 * que sea posible
	 */
	String mensajeExito = "";
	/* Nos indice si podemos o no dirigirnos a una dirección amyor o igual a la que
	 * que quedó pendiente la última vez que pasamos por una posición del laberinto
	 */
	boolean existeDireccion; 

	//Variables que nos permite construir el recorrido que nos permite llegar a la meta
	int posicion1; 
	int posicion2;
	String recorrido = "";

	/* En esta variable almacenamos la última dirección a la cual intentamos dirigirnos
	 * cuando estabamos en una posición
	 */
	int contadorIntentos = 0;
	// Nos permite construir la dirección que tomamos cuando estabamos en una posición
	int flecha;	

	// Si en el inicio había una pared, es imposible llegar a la meta
	if((int)tablero[0][0] == 1) {
	    return mensajeFracaso;
	}

	// Marcamos una visita a la casilla de partida
	marcaCasillaVisitada(0, 0);	

	// Si aún no hemos llegado a la meta
	while(posicionX < longitudTablero - 1 || posicionY < longitudTablero - 1) {
	    /* Obtenemos la dirección mayor o igual a la cual habíamos intentado la última vez cuando
	     * estabamos en la posición actual
	     */
	    contadorIntentos = devuelveDireccionDisponible(contadorIntentos, posicionX, posicionY);
	    /* Verifica si existe alguna dirección mayor o igual a la que qued'pendiente tal que
	     * podemos movernos
	     */
	    existeDireccion = intentaMovimiento(contadorIntentos , posicionX, posicionY);

	    // En caso de que sí sea posible movernos a una dirección con tales propiedades
	    if(existeDireccion) {
		/* Creamos un objeto de la clase ParejaRecorrido donde registremos la posición
		 * actual y la dirección que tomamos
		 */
		direccion = new ParejaRecorrido(posicionX, posicionY,contadorIntentos);
		// Almacenamos el registro anterior en la pila
		pilaRecorrido.push(direccion);
		// Marcamos como visitada la casilla actual
		marcaCasillaVisitada(posicionX, posicionY);
		/* Obtenemos la siguiente posición vertical al movernos a la dirección
		 *actual
		 */
		posicionX = mueveVerticalmente(direcciones[contadorIntentos], posicionX);
		/* Obtenemos la siguiente posición horizontal al movernos a la dirección
		 * actual
		 */
		posicionY = mueveHorizontalmente(direcciones[contadorIntentos], posicionY);
		// En la siguiente posición, intentaremos movernos a partir de la derecha
		contadorIntentos = 0; 
	    } else {
		/* Si no pudimos movernos a ninguna dirección mayor o igual a la que quedó
		 * pendiente la última vez que visitamos la posición actual
		 */
		if(pilaRecorrido.isEmpty()) {
		    // Si la pila ya está vacía, no existe solución al laberinto
		    return mensajeFracaso;
		}
		
		quitaVisita(posicionX, posicionY); // Quita la visita a la posición actual
		direccion = pilaRecorrido.top(); // Devuelve el último registro ingresado en la pila
		pilaRecorrido.pop(); // Elimina el último registro en la pila
		// nos regresamos a la última casilla que se registró en la pila
		posicionX = direccion.proyeccionVertical();
		posicionY = direccion.proyeccionHorizontal();
		/* Intentamos movernos a una dirección mayor que la última dirección a la cual nos
		 * movimos cuando estabamos en la posición actual
		 */
		contadorIntentos = direccion.proyeccionFlecha() + 1;
	    }
	}

	// Si llegamos a este punto, significa que existe solución.

	// Mientras la pila no este vacía
	while(pilaRecorrido.isEmpty() == false) {
	    // Construimos el recorrido que se debe tomar para llegar a la meta

	    /* Sacamos de la pila los registros de las casillas que recorrimos y las direcciones
	     * que tomamos cuando estabamos en esas casillas
	     */
	    posicion1 = pilaRecorrido.top().proyeccionVertical(); 
	    posicion2 = pilaRecorrido.top().proyeccionHorizontal();
	    flecha = pilaRecorrido.top().proyeccionFlecha();
	    /* Vamos agregando la información de los registros en una cadena. En la construcción
	     * de esta cadena debemos ir agregando la información a la ziquierda de lo que ya hemos 
	     * construido
	     */
	    recorrido = "(" + posicion1 + ", " + posicion2 + " ); direccion: " + direcciones[flecha]
		+ "\n" + recorrido;
	    pilaRecorrido.pop();
	}
	return recorrido;
    }    
}

