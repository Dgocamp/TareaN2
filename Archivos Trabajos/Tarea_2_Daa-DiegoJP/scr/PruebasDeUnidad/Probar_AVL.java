/**
 * @author Dante
 * */
package PruebasDeUnidad;
import org.junit.Before;
import org.junit.Test;

import APIs.Arbol_AVL.API_AVL;
import APIs.Arbol_AVL.Nodo_arbol_AVL;
/** Clase testeadora para probar arbol AVL.
 *  Crear registro en el arbol AVL
 *  Leer registro en el arbol AVL
 *  Borrar registro en el arbol AVL
 * */
public class Probar_AVL {
	//parametros y clases
	int dato;
	API_AVL arbol_avl;
	Nodo_arbol_AVL un_nodo1;
	Nodo_arbol_AVL un_nodo2;
	
	@Before	
	public void before(){
	   //inicializar parametros y clase
	      arbol_avl = new API_AVL();
	      un_nodo1 = new Nodo_arbol_AVL(0);
	  	  un_nodo2 = new Nodo_arbol_AVL(0);
	}
			
	@Test
	public void test() {
		for(int numerodato = 1;numerodato<=6;numerodato++) {	
			dato= (int) Math.floor(Math.random()*990+1);
			System.out.println("Ingresando el " +dato);
			arbol_avl.insertar(dato);
		}	
		System.out.println("Recorremos el arbol en Pre orden.");
		arbol_avl.Preorden(arbol_avl.obtener_raiz());
		System.out.println("");
		
		System.out.println("\nBuscamos un valor.\n");
		un_nodo1=arbol_avl.Buscar_registro_en_AVL(dato,arbol_avl.obtener_raiz());
		
		System.out.println("\nBorramos un dato.\n");
		arbol_avl=arbol_avl.Eliminar_registro_en_AVL(dato,arbol_avl);
	
		System.out.println("\nBuscamos un valor.\n");
		un_nodo2=arbol_avl.Buscar_registro_en_AVL(dato,arbol_avl.obtener_raiz());
		try{
			Thread.sleep(900000);
		}catch(Exception e){System.out.println("Error.");}	
	}
}
