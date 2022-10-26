
/**
 * Clase que permite hacer pruebas la clase Laberinto
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre
 * @since Estructuras de datos 2023-1
 */
public class PruebasLaberinto {
    public static void main(String[]  args) {

	// PRUEBA 1
	
	// Creamos un laberinto sin paredes
	Laberinto laberinto = new Laberinto(5);

	// Ingresamos paredes al laberinto creado
	for(int i = 0; i < 4; i++) {
	    laberinto.insertaPared(1, i);
	}

	for(int i = 1; i < 5; i++) {
	    laberinto.insertaPared(3, i);
	}

	System.out.println("Primer laberinto a resolver:");
	laberinto.imprimeLaberinto();	
	System.out.println("Solución:");
	System.out.println(laberinto.caminaAMeta());
	laberinto.imprimeLaberinto();

	// PRUEBA 2

	// Creamos el laberinto sin paredes
	Laberinto laberinto2 = new Laberinto(4);
	
	// Agregamos paredes al laberinto
	laberinto2.insertaPared(1,0);
	laberinto2.insertaPared(1,1);
	laberinto2.insertaPared(1,3);
	laberinto2.insertaPared(3,1);
	laberinto2.insertaPared(3,2);
	// Imprimimos el laberinto a resolver
	System.out.println("Segundo laberinto a resolver: ");
	laberinto2.imprimeLaberinto();
	System.out.println("Solución:");
	System.out.println(laberinto2.caminaAMeta());
	laberinto2.imprimeLaberinto();
	

	// PRUEBA 3

	// Creamos el laberinto sin paredes
	Laberinto laberinto3 = new Laberinto(4);
	// Ingresamos paredes al laberinto
	laberinto3.insertaPared(2,2);
	laberinto3.insertaPared(2,3);
	laberinto3.insertaPared(3,2);
	// Imprimimos el laberinto a resolver
	System.out.println("Tercer laberinto a resolver: ");
	laberinto3.imprimeLaberinto();	
	System.out.println("Solución:");
	System.out.println(laberinto3.caminaAMeta());
	laberinto3.imprimeLaberinto();

	
    }
}
