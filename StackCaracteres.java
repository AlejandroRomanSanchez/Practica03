
/**
 * Clase que permite almacenar caracteres de una cadena en una pila 
 *junto con su longitud. Primero se almacenan los últimos caracteres
 * hasta reminar con el primero, para posteriormente almacenar un
 * entero que represente la longitud de la cadena.
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class StackCaracteres {

    // Hacemos uso de una pila para realizar las operaciones
    private Stack<Object> pila = new Stack<>(); 

    /**
     * Almacena una cadena de longitud k en la pila. Primero 
     * insertamos eñ último caracter de la cadena, para 
     * terminar con el primero. Posteriormente, almacenamos 
     * la longitud de dicha cadena.
     * @param cadena La cadena a almacenar en la pila
     */
    public void pushString(String cadena) {
	String caracter = ""; // Variable donde almacenaremos cada caracter
	int longitudCadena = cadena.length();
	// Tomamos cada caracter de la cadena, vamos del último al primero	
	for (int i = cadena.length() - 1; 0 <= i; i--) {
	    caracter = cadena.substring(i, i + 1);
	    pila.push(caracter); // Guardamos el caracter en la pila
	}
	// Por último guardamos la longitud de la cadena
	pila.push(longitudCadena);     
    }

    /**
     * Devuelve la última cadena insertada en la pila. Además, se eliminan
     * los caracteres de dicha cadena y su longitud
     * @return última cadena ingresada a la pila
     */
    public String popString() {
	// En el tope estará la longitud de la última cadena
	int longitudTopString = (int) pila.top();
	// Variable que permite construir la cadena a eliminar
	String cadenaTop = "";
	pila.pop(); // Quitamos la longitud de la última cadena ingresada
	/* El número entero que se eliminó acota lo que se eliminará 
	 *en la pila. En el siguiente ciclo vamos sacando los caracteres
	 * de la cadena.*/
	for(int i = 0; i < longitudTopString; i++) {
	    cadenaTop += pila.top(); // Agregamos el tope a la cadena resultanto
	    pila.pop(); // Quitamos el tope
	}
	return cadenaTop;
    }

    /**
     * Permite visualizar los elementos almacenados en la pila
     */
    public void imprimePila() {	
	pila.show();
    }           
}
