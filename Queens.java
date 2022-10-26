import java.util.ArrayList;

/** Clase que permite solucionar el problema de las N reinas.
 * Se ingresa un entero N mayor o igual que 1. Posteriormente 
 * debemos de acomodar N reinas en un tablero de NxN de tal
 * forma que ninguna de las reinas amenace a alguna otra. En
 * caso de no existir solución, este programa lo señala
 * @author Alejandro román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class Queens {
    /* ArrayList que se puede interpretar como un tablero de dos dimensiones,
     * en el cual el índice representa la fila y el entero ingresado en ese
     * índice representa la columna. Así pues, se podrá representar la 
     * ubicación de una reina de cada fila mediante el par índice y entero 
     * almacenado en ese índice. Note que en cada fila tendremos siempre
     * una única reina colocada, si es que el tablero tiene solución
     */
    public ArrayList<Integer> listaTablero = new ArrayList<Integer>();
    public int[][] arregloTablero; // Permite representar el tablero
    public int ladoTablero; // Indica la longitud de cada lado del tablero

    /**
     * Constructor de la clase Queens, construye un tablero y asigna 0 en todas
     * sus entradas, el cero indica que no hay reina en esa posición
     * @param ladoTablero la longitud de cada lado del tablero
     */
    public Queens(int ladoTablero) {
	/* El arreglo que representa el tablero tendrá las mismas dimensiones
	 * que el tablero
	 */
	arregloTablero = new int[ladoTablero][ladoTablero];

	/* En cada entrada del arreglo, asignamos el valor 0, el cero indica
	 * que en esa entrada no se tiene reina alguna
	 */
	for(int i = 0; i < ladoTablero; i++) {
	    for(int j = 0; j < ladoTablero; j++) {
		arregloTablero[i][j] = 0;
	    }
	}
	/* El entero ingresado corresponderá a la longitud de los lados 
	 * del tablero
	 */
	this.ladoTablero = ladoTablero;
    }

    /**
     * Imprime la representación del estado actual del tablero. Si se han colocado
     * reinas en cierta posición, se indicará mediante un 1 en ese lugar
     */
    public void imprimeArregloTablero() {
	// Recorremos cada entrada del tablero
	for(int i = 0; i < ladoTablero; i++) {
	    for(int j = 0; j < ladoTablero; j++) {
		// Imprimimos la entrada actual del tablero
		System.out.print(arregloTablero[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    /**
     * Recuerde que, si el problema tiene solución para el tablero actual, entonces
     * cada fila debe tener una única reina, entonces tenemos un ArrayList que 
     * representa la posición de las reinas. El índice del ArrayList indica la fila,
     * mientras que el número ingresado en ese índice indica la columna en el cual
     * está colocada la reina, si es que tenemos una reina en ese lugar. Así pues, 
     * este método traduce la información del ArrayList en términos de un tablero 
     * bidimensional, para que la o las soluciones puedan visualizarse de una 
     * manera menos abstracta para el usuario. Donde se tenga una reina, se colocará 
     * el número 1, y en los demás lugares se tendrá un 0. Cabe señalar que para 
     * utilizar este método, iremos colocando las reinas de arriba hacia abajo. Así
     * pues, las filas que están hasta abajo posiblemente no van a tener reinas. De 
     * este modo, si el ArrayList tiene una cantidad de elementos menor que el lado 
     * del tablero, entonces esas casillas que faltan representarán espacios sin reinas;
     * es decir, se imprimirán solamente ceros en esas filas
     */
    public void traduceListaATablero() {
	/* Recorremos las casillas del ArrayList, es decir las filas en las que hemos
	 * colocado reinas; recuerde que las vamos colocando de arriba hacia abajo
	 */
	for(int i = 0; i < listaTablero.size(); i++) {
	    /* Para cada fila en el que hemos puesto una reina, recorremos sus 
	     * columnas
	     */
	    for(int j = 0; j < ladoTablero; j++) {
		// Esta condicón representa que tenemos una reina en esta posición
		if(j == listaTablero.get(i)) { 
		    arregloTablero[i][j] = 1; // Colocamos un 1 en esta posición
		} else { // Si no tenemos una reina en esta posición
		    arregloTablero[i][j] = 0; // Colocamos un 0 en esta posición
		}
	    }	
	}

	// Para las filas en las que aún no hemos colocado reinas, solo asignamos 0
	for(int i = listaTablero.size(); i < ladoTablero; i++) {
	    for(int j = 0; j < ladoTablero; j++) {
		arregloTablero[i][j] = 0;
	    }
	}
    }

    /**
     *Coloca una reina en el tablero; es decir, asignamos un 1 en la posición
     * ingresada
     * @param posicionX la posición vertical en el tablero
     * @param poscionY la posición horitzontal en el tablero
     */
    public void colocaReinaEn(int posicionX, int posicionY) {
	// Solo colocamos un uno en la posición ingresada
	arregloTablero[posicionX][posicionY] = 1; 
    }

    /**
     * Quita una reina en la posición ingresada, si es que había una reina; en caso 
     * contrario, no afecta esa posición. Es decir, ingresamos o mantenemos el 0 en
     * esa posición
     * @return posicionX la posición vertical
     * @return la posicion vertical
     */
    public void quitaReinaEn(int posicionX, int posicionY) {
	// Solo colocamos un 0 en la posicón ingresada
	arregloTablero[posicionX][posicionY] = 0;
    }

    /**
     * Para utilizar este método de manera adecuada debemos de tener en cuenta dos detalles:
     * Primero, que en la posición ingresada se debe tener colocada una reina. Segundo, solo
     * vamos a revisar las posiciones que se encuentran en la columna de la posicón ingresada 
     * y que se encuentren en las filas que están arriba de la fila en el que se encuentra la 
     * posición ingresada. Este método revisa si hay otra reina en esos lugares. Es decir, 
     * busca un 1 que se encuentre en la misma columna y arriba de ella. Recuerde que vamos 
     * a colocar las reinas de arriba hacia abajo.
     * @param posicionX la posición vertical
     * @param posicionY la posición horizontal
     * @return Si hay alguna reina arriba en la mismca columna de la posición ingresada y arriba
     * de ella, devuelve true; en caso contrario, devuelve false
     */
    public boolean tieneDosReinasEnColumna(int posicionX, int posicionY) {
	// Recorremos las filas que se encuentran arriba de la posición ingresada
	for(int i = 0; i < posicionX; i++) {
	    // Si encontramos una reina, el valor 1, en esa misma columna devuelve true
	    if(arregloTablero[i][posicionY] == 1) {
		return true;
	    }
	}
	// Si en el recorrido no encontramos reina alguna, devuelve false
	return false;
    }

    /**
     * Para utilizar este método adecuadamente debemos tener en cuenta dos detalles. Primero,
     * en la posición ingresada debemos tener colocada una reina. Segundo, solo revisaremos 
     * las casillas de las dos diagonales que pasan por la posición ingresada, y que están en 
     * las filas de arriba de la fila de la posición ingresada. Si en dichas casillas 
     * encontramos una reina, entonces este método devuelve true; en caso contrario, devuelve 
     * false
     * @param posicionX la posición vertical
     * @param posicionY la posición horizontal
     * @return devuelve true, si encontramos una reina en las casillas que están en las filas
     * superiores de la posición ingresada y que estén en las dos diagonales que pasan por dicha 
     * posición; false, en caso contrario
     */
    public boolean tieneDosReinasEnDiagonales(int posicionX, int posicionY) {
	int recorredorDeIndices = 1; // Esta variable nos permite recorrer las dos diagonales
	/* Estas variables representarán todas las casillas de la diagonal izquierda que pasa
	 * por la posición ingresada.
	 */
	int posicionXActual = posicionX - recorredorDeIndices; 
	int posicionYActual = posicionY - recorredorDeIndices;

	/* Esta condición evita que al recorrer la diagonal izquierda, no nos salgamos del rango
	 * permitido por el tablero
	 */
	while( posicionXActual > -1 &&
	       posicionYActual > -1) {
	    // Si encontramos una reina, el valor 1, devuelve true
	    if(arregloTablero[posicionXActual][posicionYActual] == 1) {
		return true; 
	    }
	    // Si no encontramos una reina
	    /* Incrementa una unidad a esta variable para irnos a la siguiente casilla izquierda
	     * de la diagonal izquierda, si es que aún existe
	     */
	    recorredorDeIndices += 1;
	    // Vamos a la siguiente casilla izquierda de la diagonal izquierda
	    posicionXActual = posicionX - recorredorDeIndices; 
	    posicionYActual = posicionY - recorredorDeIndices;
	}
	// En caso de que no encontramos una reina en la diagonal izquierda
	/* Regresamos al valor 1 esta variable para que nos permita ahora recorrer las casillas de la
	 * diagonal derecha
	 */
	recorredorDeIndices = 1;
	// Vamos a la primera casilla izquierda de la diagonal derecha, si es que la hay
	posicionXActual = posicionX - recorredorDeIndices;
	posicionYActual = posicionY + recorredorDeIndices;
	/* Esta condición evita que al recorrer la diagonal derecha, no nos salgamos del rango
	 * permitido por el tablero
	 */
	while(posicionXActual > -1 && posicionYActual < ladoTablero) {
	    // Si en la casilla actual encontramos una reina, el valor 1, devolvemos true
	    if (arregloTablero[posicionXActual][posicionYActual] == 1) {
		return true;
	    }
	    /* En caso de que no hayemos una reina, incrementamos esta variable para ir a la
	     * siguiente casilla derecha de la diagonal derecha, si es que aún existe
	     */
	    recorredorDeIndices += 1;
	    // Vamos a la siguiente casi derecha de la diagonal derecha, si es que existe
	    posicionXActual = posicionX - recorredorDeIndices;
	    posicionYActual = posicionY + recorredorDeIndices;
	}
	// En caso de que no hayamos encontrado reina alguna en ambas diagonales, devuelve false
	return false;
    }

    /**
     * Suponga que durante el proceso de ir colocando las reinas para encontrar una solución
     * al problema, nos encontramos en una fila y en una columna. Este método devuelve la 
     * siguiente columna que se encuentra a la derecha de la columna actual tal que, sobre la
     * misma fila actual, no es amenazada por ninguna de las reinas que se han colocado en las
     * filas superiores a la fila actual (recuerde que iremos colocando reinas de arriba hacia
     * abajo y solo una reina por fila). En caso de que no exista una columna con esas 
     * característca devuelve el número entero correspondiente a la longitud del lado del 
     * tablero, esto no representa una columna, solo representa que no existe una columna con 
     * esas propiedades. Si en la posición actual, no existe amenaza por parte de las reinas
     * que se han colocado arriba de la fila actual, entonces devuelve ese columna
     * @param columnaPendiente la columna en el cual nos encontramos
     * @param filaActual fila en el que nos encontramos
     * @return Devuelve la siguiente columna que se encuentra a la derecha de la posición actual 
     * en el cual, en la misma fila actual, podemos colocar una reina sin que sea amanezada por
     * las reinas que hemos colocado en las filas superiores a la fila actual. En caso de que 
     * no exista dicha columna, devolvemos la longitud del lado del tablero. En caso de que en la
     * posición actual no existe amenaza de las reinas colocadas arriba de las filas superiores
     * a la fila actual, entonces devuelve esa columna.
     */
    public int devuelveSiguienteColumnaDisponible(int columnaPendiente, int filaActual) {
	// Almacena el valor booleano devuelto por una condición que depende de la columna actual
	boolean condicionColumna;
	/* Almacena el valor booleano devuelto por una condición que depende de las diagonales que
	 * pasan por la posición actual
	 */
	boolean condicionDiagonales;
	// Almacena el resultado
	int columnaResultado = ladoTablero;

	// Recorremos las columnas que están a la derecha, incluyendo la actual 
	for(int i = columnaPendiente; i < ladoTablero; i++) {
	    /* Condición que verifica si sobre la fila actual y la columna en el que nos encontramos
	     * en la iteración existe una reina arriba de esa casilla
	     */
	    condicionColumna = tieneDosReinasEnColumna(filaActual, i);
	    /* Condición que verifica si sobre la fila actual y la columna en el que nos encontramos
	     * en la iteración existe sobre alguna de las dos diagonales una reina que amenace a la 
	     * casilla
	     */
	    condicionDiagonales = tieneDosReinasEnDiagonales(filaActual, i);
	    columnaResultado = i; // Almacenamos la columna en el cual nos encontramos

	    /* Si no existe ninguna reina que amenace a la casilla que nos da esta iteración,
	     * devuelve la columna de esta casilla de la iteración
	     */
	    if(condicionColumna == false && condicionDiagonales == false) {		
		return columnaResultado;
	    }
	}
	/* Si no existe casilla en la misma fila que se encuentre a la derecha de la posición actual,
	 * incluyendo a la columna ingresada como parámetro, entonces devolvemos la longitud de los
	 * lados del tablero
	 */
	columnaResultado = ladoTablero;
	return columnaResultado;
    }

    /**
     * En el ArrayList, colocamos un número. Recuerde que cada índice representa una fila, y el dato
     * ingresado en ese índice la columna. Si el índice ingresado es igual a la longitud de los lados
     * del tablero, solo agregamos al final del estado actual de la lista. Si el índice ingresado
     * es menor que la longitud de los lados del tablero, entonces quitamos el elemento que está 
     * y en su lugar colocamos el dato. En principio se puede ingresar datos mayores que la 
     * longitud de los lados del tablero, arrojando así una excepción; sin embargo, dentro del 
     * método que soluciona el problema, se tuvo el cuidado de nunca ingresar un índice mayor que la
     * longitud de los lados del tablero
     */
    public void colocaEnLista(int indice, int numero) {
	/* Si el índice ingresado es igual a la longitud de los lados del tablero, agregamos numero
	 * al final del estado actual del ArrayList
	 */
	if(indice == listaTablero.size()) {
	    listaTablero.add(indice, numero);
	} else {
	    /* En caso contrario, quitamos el dato que está en el índice ingresado, y colocamos el
	     * número ingresado en su lugar
	     */
	    listaTablero.set(indice, numero);
	}
    }

    /**
     * Dependiendo del tablero que se tenga, este método imprime todas las soluciones de las n 
     * reinas; en caso de que no exista solución, imprime un mensaje de fracaso.
     * Las soluciones se presentan en forma de un tablero bidimensional, en el cual el 0 significa
     * ausencia de reina en esa posición, mientras que el 1 significa que se tiene una reina en 
     * dicha posición
     */
    public void solucionaProblema() {	
	int filaActual = 0; // Fila en el que nos encontramos actualmente, comenzamos en la fila 0
	// Columna en el que nos encontramos actualmente, comenzamos en la columna 0
	int columnaActual = 0;	
	int contadorSoluciones = 0; // Registra el conteo de las soluciones que llevamos actualmente	

	// Ingresamos al siguinente ciclo while. En este ciclo se aplica el backtracking.
	while(true) {
	    /* Devuelve la siguiente columna tal que en la casilla que se encuentra en la fila
	     * actual y la columna devuelta no sea amenazada por ninguna reina que se ha 
	     * colocado hasta ahorita. Si no existe dicha columna, se devuelve la longitud de los
	     * lados del tablero
	     */ 
	    columnaActual = devuelveSiguienteColumnaDisponible(columnaActual, filaActual);
	    // Si en efecto, existe dicha columna
	    if(columnaActual < ladoTablero) {
		/* En el ArrayList, colocamos una representación de la reina colocada en la
		 * posición actual. Recuerde que el índice representa una fila, mientras que 
		 * el dato almacenado en ese índice representa una columna
		 */
		colocaEnLista(filaActual, columnaActual);
		// Colocamos una reina en la representación visual del tablero; es decir colocamos un 1
		traduceListaATablero();
		/* Si el ArrayList tiene una cantidad de elementos igual a la longitud de los lados del
		 * tablero, significa que hemos podido colocar una única reina en cada fila tal que no
		 * se amencaen entre ellas
		 */
		if(listaTablero.size() == ladoTablero) {
		    // Indica el número de solución que se imprime actualmente
		    System.out.println("La solución número " + (contadorSoluciones + 1) + " es: \n");
		    // Consideramos esta solución en el contador
		    contadorSoluciones++;
		    // Traducimos la información que se encuentra en el ArrayList en términos del tablero
		    traduceListaATablero();
		    /* Imprimimos el estado del tablero que corresponde a una solución. Recuerde que 1
		     * indica que hay una reina en ese lugar, mientras que 0 indica ausencia de éstas
		     */
		    imprimeArregloTablero();
		    /* En la siguiente iteración, comenzamos el análisis apartir de la siguiente columna
		     * que se encuentra a la derecha de la actual
		     */
		    columnaActual++;
		} else {
		    // Si aún existen filas inferiores a la actual tales que aún están libres de reinas	
		    filaActual++; // Nos movemos a la siguiente fila que está debajo de la actual
		    columnaActual = 0; // Comenzamos la siguiente iteración desde la primera columna
		}
	    } else {	       
		/* Si no existen columnas a la derecha, incluyendo a la actual, tales que, sobre la misma
		 * fila actual, no tenga casillas que no estén amenzadas por las reinas que hasta ahorita
		 * se han colocado en el tabler
		 */
		filaActual--; // Nos movemos a la fila anterior

		//Si la variable filaActual almacena el valor -1, hacemos que termina este ciclo while
		if(filaActual >= 0) { // Si la variable filaActual aún tiene sentido
		    /* Iniciamos la siguiente iteración en la siguiente columna a la derecha en el que nos
		     * habíamos quedado la última vez que estabamos en le fila anterior
		     */
		    columnaActual = listaTablero.get(filaActual) + 1;
		    /* Quitamos el último elemento ingresado en el ArrayList; es decir, quitamos la última
		     * reina que habíamos colocado en el tablero
		     */
		    listaTablero.remove(listaTablero.size() - 1);
		    // Traducimos el estado actual del ArrayList en términos del tablero visual
		    traduceListaATablero();
		} else {
		    /* Si la variable filaActual almacena un valor que ya no tiene sentido, el -1, paramos
		     * este proceso de backtracking. Es decir, salimos del ciclo while
		     */
		    break; 
		}
	    }	    
	}

	/* Si al salir del proceso de backtracking no encontramos soluciones. Imprimimos un mensaje de
	 * de fracaso. Es decir, indicamos que el tablero no tiene solución para el problema de las n
	 * reinas
	 */
	if(contadorSoluciones == 0) {
	    System.out.println("Este problema no tiene solución.");
	}
    }
}
