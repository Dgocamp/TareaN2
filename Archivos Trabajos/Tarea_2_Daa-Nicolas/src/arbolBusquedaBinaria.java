
/**
 * @author nicolasgarcia
 *	clase destinada al manejo de un Abb
 */

public class arbolBusquedaBinaria {
	private nodoArbol raiz;
	
	public arbolBusquedaBinaria() {
		@SuppressWarnings("unused")
		nodoArbol raiz = new nodoArbol();
	}
	
	/**
	 *Metodo destinado a la insercion de un numero en el abb
	 * este metodo comprueba si el nodo esta vacio,si este lo esta
	 * inserta el numero , de lo contrario comprueba si el numero a insertar
	 * es mayor al numero almacenado en la raiz/nodo si lo es,inserta el nuevo nodo
	 * de lo contrario preguntara si es menor , si lo es insertara en el hijo izquierdo 
	 * de lo contrario se tomara como un duplicado y este numero no sera insertado
	 * @param numero
	 */
	public void insertar(int numero) {
		if(estaVacio()) {
			nodoArbol nAbb = new nodoArbol();
			nAbb.setNumero(numero);
			nAbb.hd = new arbolBusquedaBinaria();
			nAbb.hi = new arbolBusquedaBinaria();
			raiz = nAbb;
		}else {
			if(numero > raiz.getNumero()) {
				(raiz.hd).insertar(numero);
			}else {
				if(numero < raiz.getNumero()) {
					(raiz.hi).insertar(numero);
				}else {
					System.out.println("numero "+numero+" duplicado");
				}
			}
		}
		
	}
		
	/**
	 * metodo el cual retorna verdadero si la raiz del arbol
	 * es null,es decir esta vacio
	 * @return Boolean 
	 */
	public boolean estaVacio() {
		if(raiz==null) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * metodo para busqueda de un numero en abb
	 * en primera instancia se pregunta si el arbol no esta vacio
	 * si es asi se comienza a buscar,primero pregunta si el numero
	 * esta contenido en el nodo en el cual estamos posicionados 
	 * si es asi retorna ese nodo de modo contrario comienza la busqueda
	 * en sus nodos hijos
	 * @param numero 
	 * @return Nodo
	 */
	public  arbolBusquedaBinaria busqueda(int numero) {
		return busquedaRecursiva(this,numero);
	}
	
	private  arbolBusquedaBinaria busquedaRecursiva(arbolBusquedaBinaria arbol,int numero) {
			if(arbol.raiz.getNumero() == numero) {
				return arbol;
			}else if(arbol.raiz.getNumero()>numero) {
				return busquedaRecursiva(arbol.raiz.hi,numero);
				
			}else if(arbol.raiz.getNumero()<numero) {
				return busquedaRecursiva(arbol.raiz.hd,numero);
			}
			return arbol;
	}

	public arbolBusquedaBinaria busquedaPadre(int numero) {
		arbolBusquedaBinaria padre=null;
		if(!estaVacio()) {
			if(raiz.hi.raiz.getNumero() == numero) {
				return padre;
			}else {
				if(raiz.hd.raiz.getNumero() == numero) {
					return padre;
			}
				if(raiz.getNumero() < numero) {
					return (padre = raiz.hi.busqueda(numero));
				}else {
					if(raiz.getNumero() > numero) {
						return(padre = raiz.hd.busqueda(numero));
					}
				}	
			}	
		}
		return padre;
	}

	/**
	 * metodo destinado a buscar si existe un numero espesifico 
	 * dentro del abb
	 * este metodo a diferencia de busqueda() solo devuelve si existe,no 
	 * devuelve el dato en si.
	 * @param numero
	 * @return boolean 
	 */
	public boolean existeDato(int numero) {
		if(!estaVacio()) {
			
			if(raiz.getNumero()==numero) {
	
				return true;
			}else {
				if(numero < raiz.getNumero()) {
					return(raiz.hi.existeDato(numero));
				}else {
					if(numero > raiz.getNumero()) {
					return(raiz.hd.existeDato(numero));
					}
					
				}
			}
		}
		return (false);
	}

	/**
	 * metodo destinado a devolver en un valor entero la altura del abb
	 * este metodo usa la instancia de Math.max() la cual devuelve el valor
	 * mayor entre dos o mas numero,en este caso se usa para devolver el valor
	 * del nodo mayor 
	 * @return int 
	 */
	public int alturaDelAbb() {
		if(!estaVacio()) {
			return (1 + Math.max(((raiz.hi).alturaDelAbb()), ((raiz.hd).alturaDelAbb())));
		}
		return 0;
	}

	/**
	 * metodo destinado a buscar el valor minimo dentro del arbol abb
	 * mientras el arbol no este vacio se seguira avanzando en los nodos
	 * izquierdos,cuando no existan mas hijos, se devuelve este valor
	 * @return int 
	 */
	public int min() {
		arbolBusquedaBinaria arbol = this;
		while(!arbol.raiz.hi.estaVacio()) {
			arbol = arbol.raiz.hi;
		}
		int nodoMin = arbol.raiz.getNumero();
		
		return nodoMin;
	}

	/**
	 * metodo destinado a buscar el valor maximo dentro del arbol abb
	 * mientras el arbol no este vacio se seguira avanzando en los nodos
	 * derechos,cuando no existan mas hijos ,se devuelve este valor
	 * @return int 
	 */
	public int max() {
		arbolBusquedaBinaria arbol = this;
		while(!arbol.raiz.hd.estaVacio()) {
			arbol = arbol.raiz.hd;
		}
		int nodoMin = arbol.raiz.getNumero();
		return nodoMin;
	}

	/**metodo el cual devuelve true si el nodo a evaluar es hoja o no 
	 * @return boolean
	 */
	public boolean esHoja() {
		if((raiz.hi).estaVacio() && (raiz.hd).estaVacio()) {
			return true;
		}
		return false;
	}

	/**metodo el cual elimina un nodo en el abb
	 * en primera instancia se busca el nodo que contiene el numero a eliminar
	 * luego se pregunta si este nodo es una hoja, si lo es se elimina directamente
	 * de lo contrario se pregunta si ambos hijos no estan vacios 
	 * si es asi entonces el nodo a eliminar pasa a ser el valor min de los hijos derechos del nodo
	 * eliminando de este modo el nodo que se busco,
	 * si uno o ambos hijos estan vacios se pregunta cual esta vacio y el que lo este pasa a ser el padre
	 * @param numero
	 */
	public void eliminarDato(int numero) {
		arbolBusquedaBinaria eliminar = busqueda(numero);
		if(!eliminar.estaVacio()) {
			if(eliminar.esHoja()) {
				eliminar.raiz=null;
			}else {
				if(!eliminar.raiz.hi.estaVacio() && !eliminar.raiz.hd.estaVacio() ) {
					eliminar.raiz.setNumero(eliminar.raiz.hd.min());
				}else {
					if(eliminar.raiz.hi.estaVacio()) {
						eliminar.raiz = eliminar.raiz.hd.raiz;
					}else {
						eliminar.raiz = eliminar.raiz.hi.raiz;
					}
				}
			}
		}
	}
	/**
	 * metodo el cual devuelve todos los datos ordenados en inOrden
	 */
	public void inOrdenAbb() {
		if(!this.estaVacio()) {
			raiz.hi.inOrdenAbb();
			System.out.print(raiz.getNumero()+" ");
			raiz.hd.inOrdenAbb();
		}
	}
	
	/**
	 * metodo el cual devuelve todos los datos ordenados en preOrden
	 */
	public void preOrdenAbb() {
		if(!this.estaVacio()) {
			System.out.print(raiz.getNumero()+" ");
			raiz.hi.preOrdenAbb();
			raiz.hd.preOrdenAbb();
		}
	}
	
	/**
	 * metodo el cual devuelve todos los datos ordenados en posOrden
	 */
	public void posOrdenAbb() {
		if(!this.estaVacio()) {
			raiz.hd.posOrdenAbb();
			raiz.hi.posOrdenAbb();
			System.out.print(raiz.getNumero()+" ");
		}
	}
	

}
