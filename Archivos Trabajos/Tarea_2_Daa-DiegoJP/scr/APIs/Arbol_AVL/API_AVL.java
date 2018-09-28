/**
 * @author Dante
 *
 */
package APIs.Arbol_AVL;

public class API_AVL{
	/**
	 * parametros
	 * @param raiz parametro de la clase
	 */
	private Nodo_arbol_AVL raiz;
	
	public API_AVL() {
		raiz=null;
	}
	/**
	 * obtiene la raiz del arbol
	 * @return devuelve un nodo en este caso la raiz del arbol
	 * */
	public Nodo_arbol_AVL obtener_raiz(){
		return raiz;
	}
	/**
	 * Buscar y Leer un dato en el arbol AVL, uso recursivo
	 *@param dato numero entero a buscar en el arbol
	 *@param un_nodo1 un nodo en el arbol avl
	 *@return retorna un nodo 
	 */
	public  Nodo_arbol_AVL Buscar_registro_en_AVL(int dato,Nodo_arbol_AVL un_nodo1){
		if(un_nodo1==null) {
			System.out.println("No se encuentra el dato en el arbol. ");
			return null;
		}
		else {
			if(un_nodo1.Valor==dato){
				System.out.println("Se encontro el dato en el arbol avl. ");
				System.out.println(un_nodo1.Valor);
				return un_nodo1;
			}
			else {
				if(un_nodo1.Valor<dato) {
					System.out.println("El dato buscado es Mayor que el valor del nodo actual nos desplazamos al hijo derecho. ");
					return Buscar_registro_en_AVL(dato,un_nodo1.hijoderecho);
				}
				else {
					    System.out.println("El dato buscado es Menor que el valor del nodo actual nos desplazamos al hijo izquierdo. ");
						return Buscar_registro_en_AVL(dato,un_nodo1.hijoizquierdo);
				}
			}
		}
	}
	
	/**
	 * Obtener factor de equilibrio
	 *@param un_nodo2 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un entero para este caso el factor de equilibrio
	 */
	public int Obtener_FE(Nodo_arbol_AVL un_nodo2) {
		if(un_nodo2==null) {
			return -1;
		}
		else {
			return un_nodo2.FE;
		}
	}
	/**
	 * Rotar a la derecha
	 *@param un_nodo3 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public Nodo_arbol_AVL rotacion_a_derecha(Nodo_arbol_AVL un_nodo3) {
		Nodo_arbol_AVL auxiliar = un_nodo3.hijoizquierdo;
		un_nodo3.hijoizquierdo = auxiliar.hijoderecho;
		auxiliar.hijoderecho = un_nodo3;
		
		un_nodo3.FE = Math.max(Obtener_FE(un_nodo3.hijoizquierdo),Obtener_FE(un_nodo3.hijoderecho))+1;
		
		auxiliar.FE = Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotar a la derecha
	 *@param un_nodo4 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public Nodo_arbol_AVL rotacion_a_izquierda(Nodo_arbol_AVL un_nodo4) {
		
		Nodo_arbol_AVL auxiliar = un_nodo4.hijoderecho;
		un_nodo4.hijoderecho = auxiliar.hijoizquierdo;
		auxiliar.hijoizquierdo = un_nodo4;
		
		un_nodo4.FE=Math.max(Obtener_FE(un_nodo4.hijoizquierdo),Obtener_FE(un_nodo4.hijoderecho))+1;
		
		auxiliar.FE=Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotacion doble izquierda = rotacion izquierda + rotacion derecha
	 *@param un_nodo5 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public Nodo_arbol_AVL rotacion_doble_izquierda(Nodo_arbol_AVL un_nodo5) {
		Nodo_arbol_AVL temporal;
		
		un_nodo5.hijoizquierdo = rotacion_a_izquierda(un_nodo5.hijoizquierdo);
		
		temporal = rotacion_a_derecha(un_nodo5);
		
		return temporal;
	}
	/**
	 * Rotacion doble derecha = rotacion derecha + rotacion izquierda
	 *@param un_nodo6 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public Nodo_arbol_AVL rotacion_doble_derecha(Nodo_arbol_AVL un_nodo6) {
		Nodo_arbol_AVL temporal;
		
		un_nodo6.hijoderecho=rotacion_a_derecha(un_nodo6.hijoderecho);
		
		temporal = rotacion_a_izquierda(un_nodo6);
		
		return temporal;
	}
	/**
	 * Actualizar altura
	 *@param sub_arbol un nodo de la clase Nodo_arbol_AVL
	 */
	public void actualizar_altura(Nodo_arbol_AVL sub_arbol) {
		if(	(sub_arbol.hijoizquierdo==null)&&(sub_arbol.hijoderecho!=null)	){
			sub_arbol.FE=sub_arbol.hijoderecho.FE+1;
		}else {
			if(	(sub_arbol.hijoderecho==null)&&(sub_arbol.hijoizquierdo!=null)	) {
				sub_arbol.FE = sub_arbol.hijoizquierdo.FE+1;
			}
			else {
				sub_arbol.FE = Math.max(Obtener_FE(sub_arbol.hijoizquierdo), Obtener_FE(sub_arbol.hijoderecho))+1;
			}
		}
	}
	/**
	 * Insertar dato en AVL, Uso recursivo
	 *@param nuevo un nodo de la clase Nodo_arbol_AVL
	 *@param sub_arbol un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public Nodo_arbol_AVL insertar_AVL(Nodo_arbol_AVL nuevo,Nodo_arbol_AVL sub_arbol) {
		//la raiz
		Nodo_arbol_AVL Nuevo_padre = sub_arbol;
		
		//condicion 1
		if(nuevo.Valor<sub_arbol.Valor) {
			System.out.println("El dato "+nuevo.Valor+" es Menor que "+sub_arbol.Valor+" nos desplazamos al hijo izquierdo. ");
			if( sub_arbol.hijoizquierdo==null) {
				System.out.println("El nodo esta vacio, asignamos el nuevo valor. ");
				sub_arbol.hijoizquierdo=nuevo;
			}
			else {
				sub_arbol.hijoizquierdo=insertar_AVL(nuevo,sub_arbol.hijoizquierdo);
				if((Obtener_FE(sub_arbol.hijoizquierdo) - Obtener_FE(sub_arbol.hijoderecho)==2)) {
					if(nuevo.Valor<sub_arbol.hijoizquierdo.Valor) {
						System.out.println("Esta muy cargado a la izquierda rotamos a la derecha para balancear el arbol AVL. ");
						Nuevo_padre = rotacion_a_derecha(sub_arbol);
					}
					else {
						System.out.println("Rotamos a la izquierda y luego a la derecha para balancear el arbol AVL");
						Nuevo_padre = rotacion_doble_izquierda(sub_arbol);
					}
				}
			}		
		}
		//caso 2
		else {
			if(nuevo.Valor>sub_arbol.Valor) {
				System.out.println("El dato "+nuevo.Valor+ " es Mayor que "+sub_arbol.Valor+" nos desplazamos al hijo derechoo ");
				if( sub_arbol.hijoderecho==null) {
					System.out.println("El nodo esta vacio, asignamos el nuevo valor ");
					sub_arbol.hijoderecho=nuevo;
				}
				else {
					sub_arbol.hijoderecho = insertar_AVL(nuevo,sub_arbol.hijoderecho);
					if((Obtener_FE(sub_arbol.hijoderecho) - Obtener_FE(sub_arbol.hijoizquierdo)==2)) {
						if(nuevo.Valor>sub_arbol.hijoderecho.Valor) {
							System.out.println("Esta muy cargado a la derecha rotamos a la izquierda para balancear el arbol ");
							Nuevo_padre = rotacion_a_izquierda(sub_arbol);
						}
						else {
							System.out.println("Rotamos a la derecha y luego a la izquierda para balancear el arbol ");
							Nuevo_padre = rotacion_doble_derecha(sub_arbol);
						}
					}
				}
			}
			//caso 3
			else {
				System.out.println("Nodo duplicado");
			}	
		}
		System.out.println("Actualizamos el factor de equilibrio.\n ");
		actualizar_altura(sub_arbol);
		return Nuevo_padre;
	}
	/**
	 * insertar
	 *@param dato el entero a insertar
	 */
	public void insertar(int dato) {
		Nodo_arbol_AVL nuevo = new Nodo_arbol_AVL(dato);
		if(raiz==null) {
			System.out.println("El arbol AVL esta vacio ingreso el dato en la raiz.");
			raiz=nuevo;
		}
		else {
			raiz=insertar_AVL(nuevo,raiz);
		}
	}
	/**
	 * Buscar un registro y borrarlo, uso recursivo
	 *@param dato el entero a buscar
	 *@param un_nodo12 un nodo de la clase Nodo_arbol_AVL
	 *@return retorna un nodo
	 */
	public  Nodo_arbol_AVL Buscar_registro_en_AVL_y_borrar(int dato,Nodo_arbol_AVL un_nodo12){
		if(un_nodo12==null) {
			System.out.println("No se encuentra el dato en el arbol. ");
		}
		else {
			if(un_nodo12.Valor==dato){
				//caso sin hijos
				if(un_nodo12.hijoderecho==null && un_nodo12.hijoizquierdo==null) {
						System.out.println("Se encontro el dato en el arbol avl tiene 0 hijos. ");
						System.out.println("Dato borrado");
						un_nodo12=null;
						return(un_nodo12);
				}
				else {
					//caso 1 hijo 
					if(un_nodo12.hijoderecho==null && un_nodo12.hijoizquierdo!=null) {
						System.out.println("Se encontro el dato en el arbol avl tiene 1 hijo izquierdo ");
						System.out.println("Dato borrado");
						Nodo_arbol_AVL auxiliar = un_nodo12.hijoizquierdo;
						un_nodo12=null;
						return(auxiliar);
					}
					else {
						//caso 1 hijo
						if(un_nodo12.hijoderecho!=null && un_nodo12.hijoizquierdo==null) {
							System.out.println("Se encontro el dato en el arbol avl tiene 1 hijo derecho ");
							System.out.println("Dato borrado");
							Nodo_arbol_AVL auxiliar = un_nodo12.hijoderecho;
							un_nodo12=null;
							return(auxiliar);
						}
						else {
							//caso 2 hijos
							System.out.println("Se encontro el dato en el arbol avl tiene 2 hijos ");
							System.out.println("Dato borrado");
							Nodo_arbol_AVL auxiliar=un_nodo12.hijoderecho;
							if(auxiliar.hijoizquierdo!=null) {
								auxiliar = auxiliar.hijoizquierdo;
								auxiliar.hijoderecho=un_nodo12.hijoderecho;
								auxiliar.hijoizquierdo=un_nodo12.hijoizquierdo;
								un_nodo12=null;
								return(auxiliar);
							}
							else {
								auxiliar.hijoizquierdo=un_nodo12.hijoizquierdo;
								un_nodo12=null;
								return(auxiliar);
							}
						}
					}
				}
			}
			else {
				if(un_nodo12.Valor<dato) {
					System.out.println("El dato buscado es Mayor que el valor del nodo actual nos desplazamos al hijo derecho. ");
					un_nodo12.hijoderecho = (Buscar_registro_en_AVL_y_borrar(dato,un_nodo12.hijoderecho));
				}
				else {
					    System.out.println("El dato buscado es Menor que el valor del nodo actual nos desplazamos al hijo izquierdo. ");
						un_nodo12.hijoizquierdo = (Buscar_registro_en_AVL_y_borrar(dato,un_nodo12.hijoizquierdo));
				}
			}
		}
		System.out.println("Actualizamos el factor de equilibrio.\n ");
		actualizar_altura(un_nodo12);
		return un_nodo12;
		
	}
	/**
	 * Eliminar registro en arbol AVL
	 *@param dato el entero a eliminar
	 *@param arbol_avl1 un arbol AVL
	 *@return retorna un arbol avl
	 */
		public API_AVL Eliminar_registro_en_AVL(int dato,API_AVL arbol_avl1 ) {
			API_AVL arbol_avl_nuevo = new API_AVL();
			
			Nodo_arbol_AVL nodo_raiz = arbol_avl1.raiz;
			nodo_raiz = Buscar_registro_en_AVL_y_borrar(dato,nodo_raiz);//un_nodo12
			arbol_avl_nuevo.raiz=nodo_raiz;

			return arbol_avl_nuevo;
		}	
	/**
	 * Recorrer arbol en preorden
	 *@param un_nodo8 un nodo de la clase Nodo_arbol_AVL
	 */
	public void Preorden(Nodo_arbol_AVL un_nodo8) {
		if(un_nodo8!=null) {
			System.out.print(un_nodo8.Valor+"|");
			Preorden(un_nodo8.hijoizquierdo);
			Preorden(un_nodo8.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol Inorden
	 *@param un_nodo7 un nodo de la clase Nodo_arbol_AVL
	 */
	public void Inorden(Nodo_arbol_AVL un_nodo7) {
		if(un_nodo7!=null) {
			Inorden(un_nodo7.hijoizquierdo);
			System.out.print(un_nodo7.Valor+"|");
			Inorden(un_nodo7.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol en postorden
	 *@param un_nodo9 un nodo de la clase Nodo_arbol_AVL
	 */
	public void Postorden(Nodo_arbol_AVL un_nodo9) {
		if(un_nodo9!=null) {
			Postorden(un_nodo9.hijoizquierdo);
			Postorden(un_nodo9.hijoderecho);
			System.out.print(un_nodo9.Valor+"|");
		}
	}
}
