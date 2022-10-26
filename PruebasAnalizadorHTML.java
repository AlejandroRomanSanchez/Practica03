
/**
 * Esta clase permite probar a la clase AnalizadorHTML
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 2 Octubre 2022
 * @since Estructuras de datos 2023-1
 */
public class PruebasAnalizadorHTML {
    public static void main(String[] args) {
	// Creación de cadenas de prueba
	String cadenaPrueba = "<<Erase una vez un chabelardo><a><b> c>> Aleluya>";
	String cadena1 = "<body><h1></h1><p></p><p></p><h1></h1></body>";
	String cadena2 = "<body><h1></h1><p><p></p><h1></h1></body>";
	String cadena3 = "<body></h1><p></p><p></p><h1></h1></body>";
	String cadena4 = "<body><h1></body></h1><p></p><p></p><h1></h1>";
	String cadena5 = "<etiqueta1><etiqueta2><etiqueta3></etiqueta3></etiqueta2></etiqueta1>";
	String cadena6 = "<html><head></head><body></body></html>";
	String cadena7 = "<html><head></head><body><p></p><button></button><table><tr><th>" +
	    "</th><th></th></tr><tr><td></td><td></td></tr><tr><td></td><td></td></tr></table></body></html>";

	/* Impresión de los resultados. Verificamos si cada una de estas cadenas tiene etiquetas HTML
	 * balanceadas
	 */
	System.out.println("¿Las siguientes cadenas tienen etiquetas HTML balanceadas?");
	System.out.println( cadenaPrueba + " | " + AnalizadorHTML.isHTMLMatched(cadenaPrueba));
	System.out.println(cadena1 + " | " + AnalizadorHTML.isHTMLMatched(cadena1));
	System.out.println(cadena2 + " | " + AnalizadorHTML.isHTMLMatched(cadena2));
	System.out.println(cadena3 + " | " + AnalizadorHTML.isHTMLMatched(cadena3));
	System.out.println(cadena3 + " | " + AnalizadorHTML.isHTMLMatched(cadena3));
	System.out.println(cadena5 + " | " + AnalizadorHTML.isHTMLMatched(cadena5));
	System.out.println(cadena6 + " | " + AnalizadorHTML.isHTMLMatched(cadena6));
	System.out.println(cadena7 + " | " +AnalizadorHTML.isHTMLMatched(cadena7));
    }
}
