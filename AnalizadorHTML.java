import java.util.ArrayList;

/**
 * Clase que permite verificar si una cadena tiene etiquetas HTML balanceadas
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class AnalizadorHTML<T> {

    /** 
     * Separamos una cadena en términos del caracter >
     * @param cadena cadena a separar en términos del caracter >
     * @return un ArrayList de Java cuyos elementos muestran la segmentación 
     *de la cadena ingresada en términos del caracter >
     */
    public static ArrayList<String> separaEtiquetas(String cadena) {
	// ArrayList que apuntará al resultado
	ArrayList<String> listaAuxiliar = new ArrayList<>();
	/* En esta variable almacenaremos las segmentaciones de la cadena
	 * ingresada en términos del caracter >
	 */
	String elementoDeLista = "";

	// Recorremos la cadena
	for(int i = 0; i < cadena.length(); i++) {
	    // Agregamos el siguiente caracter a la variable elementoDeLista
	    elementoDeLista += cadena.substring(i, i + 1);
	    // Si el caracter en el que estamos es >
	    if (cadena.substring(i, i + 1).equals(">")) {
		/* Agregamos lo almacenado en la variable elementoDeLista
		 * al ArrayList que nos dará el resultado
		 */
		listaAuxiliar.add(listaAuxiliar.size(), elementoDeLista);
		/* Limpiamos la variable elementoDeLista para que en la siguiente 
		 *iteración se comience a almacenar la siguiente segmentación de 
		 * la cadena ingresada
		 */
		elementoDeLista = ""; 
	    }
	}
	return listaAuxiliar;
    }

    /**
     * Permite verificar si una cadena es semibalanceada. Definimos a una 
     * cadena como semibalanceada si tiene al caracter < al principio y 
     * no lo puede tener en los demás lugares.
     * @param cadena es la cadena que queremos verificar si es semibalanceada
     * @return Devuelve true si la cadena ingresada es semibalanceada; false,
     * en caso contrario
     */
    public static boolean esCadenaSemiBalanceada(String cadena) {
	/* Variable que cuenta cuántas veces aparece el caracter < después
	 * del primer caracter de la cadena ingresada
	 */
	int contador = 0;

	// Si aparece el caracter < al inicio
	if (cadena.substring(0, 1).equals("<")) {
	    /* Cuenta cuántas veces aparece < después del primer
	     * caracter de la cadena ingresada
	     */
	    for(int i = 1; i < cadena.length(); i++) {
		if(cadena.substring(i, i + 1).equals("<")) {
		    contador++;
		}
	    } // Si < aparece al menos una vez, devuelve false
	    if (contador > 0) { 
		return false;
	    } else { //Si < no apareció, devuelve true
		return true;
	    }
	} else { // Si < no apareció como primer caracter, devuelve false
	    return false;
	}
    }

    /**
     * Verifica si una cadena es segunda-diagonal. Decimos que una cadena
     * es segunda-diagonal, si tiene un segundo caracter y éste es /
     * @param cadena al que se le verifica si es segunda-diagonal
     * @return true, si la cadena ingresada es segunda-diagonal; false,
     * en caso contrario
     */
    public static boolean esSegundaDiagonal(String cadena) {	
	if (cadena.length() < 2) { // Si la cadena no tiene segundo caracter
	    return false; // No es segunda-diagonal
	} else if (cadena.substring(1, 2).equals("/")) {
	    return true; // Si el segundo caracter es /, entonces devuelve true
	} else { // Si el segundo caracter no es /, devuelve false
	    return false;
	}
    }

    /**
     * Verifica si dos caracteres son equivalentes. En este contexto, diremos que
     * dos caracteres son equivalente si uno se puede construir a partir del otro
     * solo agregando el caracter / en el segundo espacio de dicha cadena. Por 
     * ejemplo, Topologia y T/opologia son equivalente en nuestro contexto.
     * @param cadena1 Cadena que compararemos con otra para ver si es equivalente,
     * esta cadena no se construye a partir de la otra
     * @param cadena2 Cadena que compararemos con otra para ver si es equivalente,
     * esta cadena se supone que debería construirse apartir de la primera al 
     * insertarle el caracter / en su segundo espacio, si este método devolviera 
     * true
     * @return true si la segunda cadena se obtiene a partir de la primera al 
     * agregarle el caracter / en su segundo espacio; false, en caso contrario
     */
    public static boolean sonEquivalentes(String cadena1, String cadena2) {
	/* En esta variable construiremos una cadena apartir de la cadena1, al
	 * solo agregarle el caracter / en su segundo espacio
	 */
	String cadenaAuxiliar = cadena1.substring(0, 1) + "/";
	// El resto de caracteres coinciden con el resto de caracteres de cadena1
	for(int i = 1; i < cadena1.length(); i++) {
	    cadenaAuxiliar += cadena1.substring(i, i + 1);
	}
	/* Si cadenaAuxiliar coincide con cadena2, se devuelve true; en caso 
	 * contrario, se devuelve false
	 */
	return cadenaAuxiliar.equals(cadena2);
    }

    /**
     * Verifica si una cadena tiene etiqueta HTML balanceadas
     * @param cadena La cadena a la cual verificar si tiene etiqueta HTML 
     * balanceadas
     * @return true, si es una cadena que tiene etiqueta HTML balanceadas; 
     * false, en caso contrario
     */
    public static boolean isHTMLMatched(String cadena) {
	/* Segmentaremos la cadena ingresada en términos del caracter > por
	 * medio del método separaEtiquetas. Posteriormente, iremos metiendo
	 * y sacando estas segmentaciones en una pila, de acuerdo a los 
	 * siguientes criterios que se explican.
	 */
	int longitudCadena = cadena.length();
	/* Pila en el que iremos metiendo y sacando las segmentaciones de la
	 * cadena ingresada en términos del caracter >
	 */
	Stack<String> pilaAuxiliar = new Stack<>();
	/* Variable que lleva el conteo de la cantidad actual de segmentaciones que 
	 * están en la pila
	 */
	int cardinalidadPila = 0; 

	/* Si el último caracter de la cadena ingresada es >, entonces existe la 
	 * posibilidad de que la cadena tenga etiquetas HTML que están balanceadas
	 */
	if (cadena.substring(longitudCadena - 1, longitudCadena).equals(">")) {
	    /* Guardamos las segmentaciones de la cadena ingresada en términos
	     * del caracter > mediante el método separaEtiquetas
	     */
	    ArrayList<String> listaAuxiliar = separaEtiquetas(cadena);

	    /* Recorremos las segmentaciones para ver si todas son cadenas
	     * semi-balanceadas
	     */
	    for(int i = 0; i < listaAuxiliar.size(); i++) {
		/* En caso de que alguna segmentación no sea semi-balanceada,
		 * entonces podemos concluir que la cadena ingresada no tiene
		 * etiquetas HTML que estén balanceadas
		 */
		if (esCadenaSemiBalanceada(listaAuxiliar.get(i)) == false) {
		    return false;
		}
	    }

	    /* En caso de que todas las segmentaciones sí sean cadenas semi-balanceadas,
	     * procedemos a recorrer otra vez todas las segmentaciones. El objetivo es 
	     * encontrar la primera segmentación que sea segunda-diagonal, para poder 
	     * compararla con su segmentación anterior, pues ambas deberían ser equivalente.
	     * Pues si no sucediera esto, entonces podremos descartar que la cadena ingresada
	     * tenga etiquetas HTML balanceadas. Esto se debe a que no tenemos 
	     * instrucciones entre las etiquetas.
	     */
	    for(int i = 0; i < listaAuxiliar.size(); i++) {
		// Si la segmentación en la que estamos es segunda-diagonal
		if (esSegundaDiagonal(listaAuxiliar.get(i)) == true) {
		    if (pilaAuxiliar.isEmpty()) {
			/* Si no hay ninguna segmentación antes de la actual,
			 * entonces podemos concluir que la cadena ingresada 
			 * no tiene etiquetas balanceadas, pues estaríamos
			 * cerrando una etiqueta sin haberla abierto
			 */
			return false; 
		    }
		    /* Si la segmentación actual es segunda-diagonal y equivalente a su 
		     * segmentación anterior. Entonces eliminamos su segmentación 
		     * anterior de la pila. 
		     */
		    if (sonEquivalentes(pilaAuxiliar.top(), listaAuxiliar.get(i))){
			pilaAuxiliar.pop();
			// La cardinalidad de la pila disminuye una unidad
			cardinalidadPila--; 
		    } else {
			/* Si la segmentación actual es segunda-diagonal, pero la anterior
			 * no es equivalente a ésta, entonces la cadena ingresada no tiene
			 * etiquetas HTML balanceadas, pues tendríamos una etiquetq que
			 * cierra pero que nunca abrió
			 */
			return false;
		    }		     
		} else {
		    /* Si la segmentación actual no es segunda-diagonal, la agregamos a la
		     * pila
		     */
		    pilaAuxiliar.push(listaAuxiliar.get(i));
		    // Incrmentamos una unidad a la cantidad de elementos en la pila
		    cardinalidadPila++; 
		}
	    }

	    // Si terminamos de recorrer las segmentaciones
	    if(cardinalidadPila > 0) {
		/* Si además quedaron elementos en la pila, entonces la cadena ingresada
		 * no tiene etiquetas HTML balanceadas
		 */
		return false; 
	    } else {
		/* En caso de que no haya quedado segmentación alguna en la pila, entonces
		 * la cadena ingresada tiene etiquetas HTML balanceadas
		 */
		return true;
	    }
	} else {
	    /* Si la cadena ingresada no tiene como último caracter a >, automáticamente
	     * descartamos que tenga etiquetas HTML balanceadas
	     */
	    return false;
	}
    }        
}
	    
	    
