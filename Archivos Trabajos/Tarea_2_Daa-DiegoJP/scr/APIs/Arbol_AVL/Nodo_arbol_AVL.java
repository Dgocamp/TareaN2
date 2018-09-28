/**
 * @author Dante
 */
package APIs.Arbol_AVL;

/**
 * Nodo del arbol AVL
 *
 */
public class Nodo_arbol_AVL {
	/**
	 * parametros
	 * @param Valor un dato entero
	 * @param FE factor de equilibrio
	 * @param hijoizquierdo un nodo de la clase Nodo_arbol_AVL hace referencia al izquierdo del nodo actual
	 * @param hijoderecho un nodo de la clase Nodo_arbol_AVL hace referencia al derecho del nodo actual
	 */
	int Valor, FE;
	Nodo_arbol_AVL hijoizquierdo,hijoderecho;
	/**
	 * parametros
	 * @param valor1 un dato entero
	 */
	public Nodo_arbol_AVL (int Valor1) {
		this.Valor=Valor1;
		this.FE=0;
		this.hijoizquierdo=null;
		this.hijoderecho=null;
	}
	/**
	 * obtener_valor
	 * @return Devuelve el dato del nodo
	 */
	public int obtener_valor(){
		return Valor;
	}
	/**
	 * obtener_hijoderecho
	 * @return devuelve un nodo
	 */
	public Nodo_arbol_AVL obtener_hijoderecho(){
		return hijoderecho;
	}
	/**
	 * obtener_hijoizquierdo
	 * @return devuelve un nodo
	 */
	public Nodo_arbol_AVL obtener_hijoizquierdo(){
		return hijoizquierdo;
	}
}