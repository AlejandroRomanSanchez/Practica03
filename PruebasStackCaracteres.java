
/**
 * Clase que permite mostrar las pruebas hechas para la clase
 * StackCaracteres
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class PruebasStackCaracteres {
    public static void main (String[] args) {
	// Creamos un objeto de tipo StackCaracteres
	StackCaracteres pilaPrueba = new StackCaracteres();
	pilaPrueba.pushString("Animales"); // Agregamos una cadena al tope
	System.out.println("Agregamos la cadena Animales: ");
	pilaPrueba.imprimePila();	
	System.out.println();

	// Agregamos otra cadena al tope
	pilaPrueba.pushString("Computacion");
	System.out.println("Agregamos la cadena Computacion: ");
	pilaPrueba.imprimePila();
	System.out.println();

	// Agregamos otra cadena al topa
	pilaPrueba.pushString("Pera");
	System.out.println("Agregamos la cadena Pera: ");
	pilaPrueba.imprimePila();
	System.out.println();

	// Eliminamos el tope
	pilaPrueba.popString();
	System.out.println("Eliminamos el tope: ");
	pilaPrueba.imprimePila();
    }
}
