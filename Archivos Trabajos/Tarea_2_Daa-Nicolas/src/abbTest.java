
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class abbTest {
	arbolBusquedaBinaria arbol = new arbolBusquedaBinaria();
	arbolBusquedaBinaria aux = new arbolBusquedaBinaria();
	@Test
	void test() {
		arbol.insertar(10);
		arbol.insertar(33);
		arbol.insertar(41);
		arbol.insertar(55);
		arbol.insertar(6);
		arbol.insertar(47);
		arbol.insertar(28);
		arbol.insertar(20);
		arbol.insertar(2);
		System.out.println("in Orden :");
		arbol.inOrdenAbb();
		System.out.println("");
		System.out.println("pre Orden :");
		arbol.preOrdenAbb();
		System.out.println("");
		System.out.println("pos Orden :");
		arbol.posOrdenAbb();
		System.out.println("");
		//verifico si los valores maximos corresponden a los ingresados
		assertEquals(true,arbol.existeDato(28));
		assertEquals(2,arbol.min());
	    assertEquals(55,arbol.max());
		//verifico si la altura es la correcta
		assertEquals(5,arbol.alturaDelAbb());
		//elimino dos datos para revisar 
		arbol.eliminarDato(47);
		arbol.eliminarDato(6);
		
		arbol.posOrdenAbb();
	}

}
