# Práctica 3: Pilas
Nombre de alumno: Alejandro Román Sánchez
Número de cuenta: 408093413

# Descripción.
En esta actividad primero implementamos una clase llamada Stack mediante la implementación de la interfaz
TDAStack. Posteriormente, mediante esta implementación resolvemos las actividades propuestas en esta práctica.

## Estructura del proyecto
La estructura del proyecto es la suguiente:

1. TDAStack: Es la interfaz que nos permitirá implementar las Stacks que utilizaremos para resolver las
   actividades.
2. Stack: Una implementación de la interfaz TDAStack, en ella definimos las operaciones y la estrutura de las
   pilas que utilizaremos en esta práctica. Cabe señalar que hacemos uso de una clase llamada Node, para hacer
   uso de referencias
3. StackCaracteres: Esta clase permite resolver la Actividad 2 de la práctica. Se tiene una pila en el que
   dada una cadena podemos ingresar sus caracteres por separado en la pila (las agregamos a la pila del
   último caracter al primero) y al final colocamos un entero que representa la longitud de la cadena
   ingresada. Además, a la hora de eliminar elementos de la pila, lo que siempre está en el tope, si no es vacía,
   es un número entero, el cual indica el número de caracteres que debemos sacar de la pila. Esto permite que
   podemos sacar la última cadena que se ingresó.
4. PruebasStackCaracteres: Hacemos pruebas de la clase StackCaracteres
5. AnalizadorHTML: Esta clase permite determinar si la cadena ingresada tiene etiquetas de HTML balanceadas.
   Hacemos uso de la implementación Stack
6. PruebasAnalizadorHTML: Hacemos las pruebas de la clase AnalizadorHTML
7. Queens: Esta clase permite resolver el problema de las N reinas, donde N es una entero mayor o igual que 1.
   A saber, este problema se refiere que dado N, entonces debes de colocar N reinas en un tablero de NxN de tal
   manera que ninguna reina sea amenazada por otra. Esta clase permite nos opciones: Si existe solución, te
   devolverá todas las soluciones existentes; en caso contrario, te indicará que no es posible resolver el
   problema para esa N
8  PruebasQueens: Esta clase permite probar a la clase Queens. Se recomiendo, antes de ejecutar el archivo, poner
   como comentarios aquellas líneas que no se desean ejecutar, pues lo que se imprime en su totalidad es algo
   muy extenso.
9. ParejaRecorrido: Clase auxiliar para resolver el problema del laberinto. Los objetos de esta clase permite
   hacer un registro de la casilla del tablero en la que estabamos en un momento y de la dirección que tomamos;
   si tomamos la derecha, hacia abajo, la izquierda o hacia arriba.
10. Laberinto: Esta clase permite resolver laberintos cuadrados, partimos de la casilla (0,0) y debemos llegar
    a la casilla (N - 1, N - 1), donde N es la longitud de los lados del laberinto
11. PruebasLaberinto: En esta clase hacemos las pruebas de la clase Laberinto

## Instrucciones de compilación y ejecución.

Antes de hacer uso de todas las clases de esta práctica, primero debemos de escribir desde la dirección de
a carpeta del proyecto lo siguiente:
javac TDAStack.java
java TDAStack

Posteriormente, antes de usar las demás clases restantes, desde la dirección de la carpeta debemos de escribir
lo siguiente:
javac Stack.java
java Stack

Para hacer uso de las demás clases, debimos haber realizado de antemano la compilación de los dos archivos
anteriores.

Si queremos utilizar la clase StackCaracteres, debemos escribir desde la dirección de la carpeta del proyecto lo
siguiente:
javac StackCaracteres.java
java StackCaracteres

Para hacer pruebas de la clase StackCaracteres, primero debimos haber compilado el archivo
StackCaracteres.java. Luego, desde la dirección de la carpeta del proyecto escribimos:
javac PruebasStackCaracteres.java
java PruebasStackCaracteres

Para hacer uso de la clase AnalizadorHTML desde la dirección de la carpeta del proyecto escribimos:
javac AnalizadorHTML.java
java AnalizadorHTML

Para hacer pruebas de la clase AnalizadorHTML, debimos haber compilado de antemanos la clase
AnalizadorHTML, posteriormente desde la dirección de la carpeta del proyecto debemos escribir:
javac PruebasAnalizadorHTML.java
java PruebasAnalizadorHTML

Para hacer uso de la clase Queens, desde la dirección de la carpeta del proyecto, debemos de escribir:
javac Queens.java
java Queens

Para hacer las pruebas a la clase Queens, de antemano debemos haber compilado al archivo Queens.java.
Posteriormente, desde la dirección de la carpeta del proyecto, debemos escribir:
javac PruebasQueens.java
java PruebasQueens

Para hacer uso de la clase ParejaRecorrido, desde la dirección de la carpeta de la práctica, debemos escribir:
javac ParejaRecorrido.java
java ParejaRecorrido

Para hacer uso de la clase Laberinto, es muy importante que de antemano debimos haber compilado al archivo
ParejaRecorrido.java, pues la clase Laberinto hace uso de esto último. Posteriormente, desde la dirección de la
carpeta de la práctica debemos escribir:
javac Laberinto.java
java Laberinto

Por último, si queremos hacer pruebas a la clase Laberinto, de antemanos debimos de haber compilado los archivos
ParejaRecorrido.java y Laberinto.java, en ese orden. Posteriormente, desde la dirección de la carpeta de la
práctica debemos escribir:
javac PruebasLaberinto.java
java PruebasLaberinto



