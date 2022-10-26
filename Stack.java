import java.util.EmptyStackException;

/** 
 * Implementación de la interfazTDAStack basada en referencias 
 * usando una clase nodo llamada Node
 * @author Alejandro Román Sánchez
 * Número de cuenta: Alejandro Román Sánchez
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class Stack<T> implements TDAStack<T> {

    /**
     * Clase auxiliar que nos provee de nodos para las referencias 
     * de la implementación de los Stacks
     */
    private class Node {
	public T elemento; // El elemento que almacena el nodo
	public Node siguiente; // Nos da la referencia al siguiente nodo

	/**
	 * Constructor del nodo
	 * @param Recibe el elemento que almacenará el nodo
	 */
	public Node(T elemento) {
	    this.elemento = elemento;
	}
    }

    private Node cabeza; // El nodo cabeza del stack

    /**
     * Agega un elemento en el tope
     * @param elemento el elemento a inserta en la pila
     */
    public void push(T elemento) {
	Node nuevoNodo = new Node(elemento); // Creamos el nodo que agregaremos
	if (cabeza == null) { // Si la cabeza apunta a null
	    cabeza = nuevoNodo; // Hacemos que cabeza apunte al nodo creado
	    nuevoNodo.siguiente = null; // El siguiente de dicho nodo apunta a null
	} else { // En caso de que la cabeza no apunte a null
	    // Hacemos que el siguiente al nodo creado apunte a la cabeza
	    nuevoNodo.siguiente = cabeza; 
	    cabeza = nuevoNodo; // Hacemos que la cabeza apunte al nodo creado
	}
    }

    /**
     * Elimina y regresa el tope de la pila
     * @return el elemento en el tope de la pila
     * @trows EmptyStackException en caso de que la pila esté vacía
     */
    public T pop() throws EmptyStackException {
	if (cabeza == null) { // Si la cabeza apunta anull
	    throw new EmptyStackException(); 
	} else { // Si la cabeza no apunta a null
	    T resultado = cabeza.elemento; // El resultado apunta a la cabeza
	    cabeza = cabeza.siguiente; // Apuntamos la cabeza al siguiente de la cabeza
	    return resultado;
	}
    }

    /**
     * Regresa el tope de la pila
     * @return el elemento en el tope de la pila
     * @throws EmptyStackException en caso de que la pila esté vacía
     */
    public T top() throws EmptyStackException {
	if (cabeza == null) { // Si la cabeza apunta a null
	    throw new EmptyStackException(); 
	} else { // Si la cabeza no apunta a null
	    return cabeza.elemento; 
	}
    }

    /**
     * Verifica que la lista sea vacía
     * @return true en caso de ser vacía, false en otro caso
     */
    public boolean isEmpty() {
	// Decimos que una pila está vacía si la cabeza apunta a null
	if (cabeza == null) {
	    return true;
	} else {
	    return false;
	}
    }

    /**
     * Limpia el stack
     */
    public void clear() {
	cabeza = null; // solo hacemos que la cabeza apunte a null
    }

    /**
     * Permite visualiza los elementos de un stack
     */
    public void show() {
	// Si la pila está vacía, solo indicamos que lo está
	if(isEmpty()) { 
	    System.out.println("La pila está vacía");
	} else { // En caso de que no este vacía
	    Node iterador = cabeza; // Hacemos que la variable iterador apunte a la cabeza
	    while (iterador != null) { // Siempre que el iterador no sea vacía
		// Imprimimos el elemento del nodo que es apuntado por el iterador
		System.out.print(iterador.elemento + " "); 
		iterador = iterador.siguiente; // Hacemos que el iterador apunte al siguiente
	    }
	    System.out.println();
	}
    }
}
	
	    

    
