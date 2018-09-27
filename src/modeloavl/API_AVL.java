/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloavl;

import vista.Plataforma;

/**
 *
 * @author UsuarioN°1000
 */
public class API_AVL {
    /**
	 * parametros
	 */
	private NODO_AVL raiz;
        Plataforma p;
	String s = "";
	public API_AVL(Plataforma p) {
            this.p=p;
            raiz=null;
	}
        
	
	// getter
	public NODO_AVL obtener_raiz(){
		return raiz;
	}

  
        
	/**
	 * Buscar y Leer un dato en el arbol AVL
	 *
	 */
	public  NODO_AVL Buscar_registro_en_AVL(int dato,NODO_AVL un_nodo1){
		if(un_nodo1==null) {
                    p.pizarra.setText(p.pizarra.getText()+"No se encuentra el dato en el árbol.\n");
			//System.out.println("No se encuentra el dato en el árbol.\n");
			return null;
		}
		else {
			if(un_nodo1.Valor==dato){
                            p.info.setText(un_nodo1.Valor +" ENCONTRADO");
                            p.pizarra.setText(p.pizarra.getText()+"Se encontró el dato "+un_nodo1.Valor+" en el árbol avl.\n");
				//System.out.println("Se encontró el dato en el árbol avl.\n");
				//System.out.println(un_nodo1.Valor);
				return un_nodo1;
			}
			else {
				if(un_nodo1.Valor<dato) {
                                    p.pizarra.setText(p.pizarra.getText()+"El dato buscado es mayor que el valor del nodo actual, nos desplazamos al hijo derecho.\n");
                                    //System.out.println("El dato buscado es mayor que el valor del nodo actual, nos desplazamos al hijo derecho.\n");
                                    return Buscar_registro_en_AVL(dato,un_nodo1.hijoderecho);
				}
				else {
                                            p.pizarra.setText(p.pizarra.getText()+"El dato buscado es menor que el valor del nodo actual, nos desplazamos al hijo izquierdo.\n");
					    //System.out.println("El dato buscado es menor que el valor del nodo actual, nos desplazamos al hijo izquierdo.\n");
                                            return Buscar_registro_en_AVL(dato,un_nodo1.hijoizquierdo);
				}
			}
		}
	}
	
	/**
	 * Obtener factor de equilibrio
	 *
	 */
	public int Obtener_FE(NODO_AVL un_nodo2) {
		if(un_nodo2==null) {
			return -1;
		}
		else {
			return un_nodo2.FE;
		}
	}
	/**
	 * Rotar a la derecha
	 *
	 */
	public NODO_AVL rotacion_a_derecha(NODO_AVL un_nodo3) {
		NODO_AVL auxiliar = un_nodo3.hijoizquierdo;
		un_nodo3.hijoizquierdo = auxiliar.hijoderecho;
		auxiliar.hijoderecho = un_nodo3;
		
		un_nodo3.FE = Math.max(Obtener_FE(un_nodo3.hijoizquierdo),Obtener_FE(un_nodo3.hijoderecho))+1;
		
		auxiliar.FE = Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotar a la izquierda
	 *
	 */
	public NODO_AVL rotacion_a_izquierda(NODO_AVL un_nodo4) {
		
		NODO_AVL auxiliar = un_nodo4.hijoderecho;
		un_nodo4.hijoderecho = auxiliar.hijoizquierdo;
		auxiliar.hijoizquierdo = un_nodo4;
		
		un_nodo4.FE=Math.max(Obtener_FE(un_nodo4.hijoizquierdo),Obtener_FE(un_nodo4.hijoderecho))+1;
		
		auxiliar.FE=Math.max(Obtener_FE(auxiliar.hijoizquierdo),Obtener_FE(auxiliar.hijoderecho))+1;
		
		return auxiliar;
	}
	/**
	 * Rotacion doble izquierda = rotacion izquierda + rotacion derecha
	 *
	 */
	public NODO_AVL rotacion_doble_izquierda(NODO_AVL un_nodo5) {
		NODO_AVL temporal;
		
		un_nodo5.hijoizquierdo = rotacion_a_izquierda(un_nodo5.hijoizquierdo);
		
		temporal = rotacion_a_derecha(un_nodo5);
		
		return temporal;
	}
	/**
	 * Rotacion doble derecha = rotacion derecha + rotacion izquierda
public NODO_AVL rotacion_doble_derecha(NODO_AVL un_nodo6) {
	 */
	public NODO_AVL rotacion_doble_derecha(NODO_AVL un_nodo6) {
		NODO_AVL temporal;
		
		un_nodo6.hijoderecho=rotacion_a_derecha(un_nodo6.hijoderecho);
		
		temporal = rotacion_a_izquierda(un_nodo6);
		
		return temporal;
	}
	/**
	 * Actualizar altura
	 *
	 */
	public void actualizar_altura(NODO_AVL sub_arbol) {
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
	 * Insertar dato en AVL
	 *
	 */
	public NODO_AVL insertar_AVL(NODO_AVL nuevo,NODO_AVL sub_arbol) {
		//la raiz
		NODO_AVL Nuevo_padre = sub_arbol;
		
		//condicion 1
		if(nuevo.Valor<sub_arbol.Valor) {
                        p.pizarra.setText(p.pizarra.getText()+"El dato "+nuevo.Valor+" es menor que "+sub_arbol.Valor+", nos desplazamos al hijo izquierdo.\n");
			//System.out.println("El dato "+nuevo.Valor+" es Menor que "+sub_arbol.Valor+" nos desplazamos al hijo izquierdo. ");
			if( sub_arbol.hijoizquierdo==null) {
                                p.pizarra.setText(p.pizarra.getText()+"El nodo esta vacío, asignamos el nuevo valor.\n");
				//System.out.println("El nodo esta vacio, asignamos el nuevo valor. ");
				sub_arbol.hijoizquierdo=nuevo;
			}
			else {
                                p.pizarra.setText(p.pizarra.getText()+"FE del subárbol izquierdo "+Obtener_FE(sub_arbol.hijoizquierdo)+"|"+"FE del subárbol derecho "+Obtener_FE(sub_arbol.hijoderecho)+".\n");
				sub_arbol.hijoizquierdo=insertar_AVL(nuevo,sub_arbol.hijoizquierdo);
				//System.out.println("FE del subarbol izquierdo "+Obtener_FE(sub_arbol.hijoizquierdo)+"|"+"FE del subarbol derecho "+Obtener_FE(sub_arbol.hijoderecho));
				if((Obtener_FE(sub_arbol.hijoizquierdo) - Obtener_FE(sub_arbol.hijoderecho)==2)) {
					if(nuevo.Valor<sub_arbol.hijoizquierdo.Valor) {
                                                p.pizarra.setText(p.pizarra.getText()+"Esta muy cargado a la izquierda rotamos a la derecha para balancear el árbol AVL.\n");
						//System.out.println("Esta muy cargado a la izquierda rotamos a la derecha para balancear el arbol AVL. ");
						Nuevo_padre = rotacion_a_derecha(sub_arbol);
					}
					else {
                                                p.pizarra.setText(p.pizarra.getText()+"Rotamos a la izquierda y luego a la derecha para balancear el árbol AVL.\n");
						//System.out.println("Rotamos a la izquierda y luego a la derecha para balancear el arbol AVL");
						Nuevo_padre = rotacion_doble_izquierda(sub_arbol);
					}
				}
			}		
		}
		//caso 2
		else {
			if(nuevo.Valor>sub_arbol.Valor) {
                                p.pizarra.setText(p.pizarra.getText()+"El dato "+nuevo.Valor+ " es mayor que "+sub_arbol.Valor+", nos desplazamos al hijo derecho.\n");
				//System.out.println("El dato "+nuevo.Valor+ " es Mayor que "+sub_arbol.Valor+" nos desplazamos al hijo derechoo ");
				if( sub_arbol.hijoderecho==null) {
                                        p.pizarra.setText(p.pizarra.getText()+"El nodo está vacío, asignamos el nuevo valor.\n");
					//System.out.println("El nodo esta vacio, asignamos el nuevo valor ");
					sub_arbol.hijoderecho=nuevo;
				}
				else {                                        
					sub_arbol.hijoderecho = insertar_AVL(nuevo,sub_arbol.hijoderecho);
                                        p.pizarra.setText(p.pizarra.getText()+"FE del subárbol derecho "+Obtener_FE(sub_arbol.hijoderecho)+"|"+"FE del subárbol izquierdo "+Obtener_FE(sub_arbol.hijoizquierdo)+".\n");
					//System.out.println("FE del subarbol derecho "+Obtener_FE(sub_arbol.hijoderecho)+"|"+"FE del subarbol izquierdo "+Obtener_FE(sub_arbol.hijoizquierdo));
					p.pizarra.setText(p.pizarra.getText()+Obtener_FE(sub_arbol.hijoderecho)+"|"+ Obtener_FE(sub_arbol.hijoizquierdo)+".\n");
                                        //System.out.println(Obtener_FE(sub_arbol.hijoderecho)+"|"+ Obtener_FE(sub_arbol.hijoizquierdo));
					if((Obtener_FE(sub_arbol.hijoderecho) - Obtener_FE(sub_arbol.hijoizquierdo)==2)) {
						if(nuevo.Valor>sub_arbol.hijoderecho.Valor) {
                                                        p.pizarra.setText(p.pizarra.getText()+"Está muy cargado a la derecha, rotamos a la izquierda para balancear el árbol.\n");
							//System.out.println("Esta muy cargado a la derecha rotamos a la izquierda para balancear el arbol ");
							Nuevo_padre = rotacion_a_izquierda(sub_arbol);
						}
						else {
                                                        p.pizarra.setText(p.pizarra.getText()+"Rotamos a la derecha y luego a la izquierda para balancear el árbol.\n");
							//System.out.println("Rotamos a la derecha y luego a la izquierda para balancear el arbol ");
							Nuevo_padre = rotacion_doble_derecha(sub_arbol);
						}
					}
				}
			}
			//caso 3
			else {
                                p.pizarra.setText(p.pizarra.getText()+"Nodo duplicado.\n");
				//System.out.println("Nodo duplicado");
			}	
		}
                p.pizarra.setText(p.pizarra.getText()+"Actualizamos el factor de equilibrio.\n");
		//System.out.println("Actualizamos el factor de equilibrio.\n ");
		actualizar_altura(sub_arbol);
		return Nuevo_padre;
	}
	
	/**
	 * insertar
	 *
	 */
	public void insertar(int dato) {
		NODO_AVL nuevo = new NODO_AVL(dato);
		if(raiz==null) {
                        p.pizarra.setText(p.pizarra.getText()+"El árbol AVL esta vacío, ingreso el " +dato+ " en la raíz.\n");
			//System.out.println("El árbol AVL esta vacio ingreso el dato en la raíz.");
			raiz=nuevo;
		}
		else {
			raiz=insertar_AVL(nuevo,raiz);
		}
	}
	public  NODO_AVL Buscar_registro_en_AVL_y_borrar(int dato,NODO_AVL un_nodo12){
		if(un_nodo12==null) {
                        p.pizarra.setText(p.pizarra.getText()+"No se encuentra el dato en el árbol.\n");
			//System.out.println("No se encuentra el dato en el arbol. ");
		}
		else {
			if(un_nodo12.Valor==dato){
				//caso sin hijos
				if(un_nodo12.hijoderecho==null && un_nodo12.hijoizquierdo==null) {
                                                p.info.setText(un_nodo12.Valor+" ELIMINADO");
                                                p.pizarra.setText(p.pizarra.getText()+"Se encontró el dato en el árbol avl, tiene 0 hijos.\n");
						//System.out.println("Se encontro el dato en el arbol avl tiene 0 hijos. ");
                                                p.pizarra.setText(p.pizarra.getText()+"Dato borrado.\n");
						//System.out.println("Dato borrado");
						un_nodo12=null;
						return(un_nodo12);
				}
				else {
					//caso 1 hijo 
					if(un_nodo12.hijoderecho==null && un_nodo12.hijoizquierdo!=null) {
                                                p.pizarra.setText(p.pizarra.getText()+"Se encontró el dato en el árbol avl, tiene 1 hijo izquierdo.\n");
						//System.out.println("Se encontró el dato en el árbol avl, tiene 1 hijo izquierdo ");
                                                p.pizarra.setText(p.pizarra.getText()+"Dato borrado.\n");
						//.out.println("Dato borrado");
						NODO_AVL auxiliar = un_nodo12.hijoizquierdo;
						un_nodo12=null;
						return(auxiliar);
					}
					else {
						//caso 1 hijo
						if(un_nodo12.hijoderecho!=null && un_nodo12.hijoizquierdo==null) {
                                                        p.pizarra.setText(p.pizarra.getText()+"Se encontró el dato en el árbol avl, tiene 1 hijo derecho.\n");
							//System.out.println("Se encontró el dato en el árbol avl, tiene 1 hijo derecho.\n");
                                                        p.pizarra.setText(p.pizarra.getText()+"Dato borrado.\n");
							//System.out.println("Dato borrado");
							NODO_AVL auxiliar = un_nodo12.hijoderecho;
							un_nodo12=null;
							return(auxiliar);
						}
						else {
							//caso 2 hijos
							//System.out.println("Se encontro el dato en el arbol avl tiene 2 hijos ");
                                                        p.pizarra.setText(p.pizarra.getText()+"Se encontró el dato en el árbol avl, tiene 2 hijos.\n");
							//System.out.println("Dato borrado.\n");
                                                        p.pizarra.setText(p.pizarra.getText()+"Dato borrado.\n");
							NODO_AVL auxiliar=un_nodo12.hijoderecho;
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
                                        p.pizarra.setText(p.pizarra.getText()+"El dato buscado es mayor que el valor del nodo actual, nos desplazamos al hijo derecho.\n");				
					un_nodo12.hijoderecho = (Buscar_registro_en_AVL_y_borrar(dato,un_nodo12.hijoderecho));
				}
				else {
                                            p.pizarra.setText(p.pizarra.getText()+"El dato buscado es menor que el valor del nodo actual, nos desplazamos al hijo izquierdo.\n");					    
                                            un_nodo12.hijoizquierdo = (Buscar_registro_en_AVL_y_borrar(dato,un_nodo12.hijoizquierdo));
				}
			}
		}
                p.pizarra.setText(p.pizarra.getText()+"Actualizamos el factor de equilibrio.\n");
		actualizar_altura(un_nodo12);
		return un_nodo12;
		
	}
	/**
	 * Eliminar registro en arbol AVL
	 *
	 */
		public API_AVL Eliminar_registro_en_AVL(int dato,API_AVL arbol_avl1 ) {
			API_AVL arbol_avl_nuevo = new API_AVL(p);
			
			NODO_AVL nodo_raiz = arbol_avl1.raiz;
			nodo_raiz = Buscar_registro_en_AVL_y_borrar(dato,nodo_raiz);//un_nodo12
			

//			int iteracion=0;
//			nodo_raiz=actualizar_todo(iteracion,nodo_raiz);
			arbol_avl_nuevo.raiz=nodo_raiz;

			return arbol_avl_nuevo;
		}	
	/**
	 * Actualizar altura de todos los nodos
	 *
	 */
	public NODO_AVL actualizar_todo(int iteracion, NODO_AVL un_nodo11) {
		if(un_nodo11!=null) {
			iteracion++;
			actualizar_altura(un_nodo11);
			un_nodo11=actualizar_todo(iteracion,un_nodo11.hijoizquierdo);
			un_nodo11=actualizar_todo(iteracion,un_nodo11.hijoderecho);
		}
		return un_nodo11;
	}
	/**
	 * Recorrer arbol en preorden
	 *
	 */
	public void Preorden(NODO_AVL un_nodo8) {
		if(un_nodo8!=null) {
			//System.out.println("Preorden: "+un_nodo8.Valor);
                        p.pizarra.setText(p.pizarra.getText()+un_nodo8.Valor+"  ");
			Preorden(un_nodo8.hijoizquierdo);
			Preorden(un_nodo8.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol Inorden
	 *
	 */
	public void Inorden(NODO_AVL un_nodo7) {
		if(un_nodo7!=null) {
			Inorden(un_nodo7.hijoizquierdo);
                        p.pizarra.setText(p.pizarra.getText()+un_nodo7.Valor+"  ");
			//System.out.println("Inorden: "+un_nodo7.Valor);
			Inorden(un_nodo7.hijoderecho);
		}
	}
	/**
	 * Recorrer arbol en postorden
	 *
	 */
	public void Postorden(NODO_AVL un_nodo9) {
		if(un_nodo9!=null) {
			Postorden(un_nodo9.hijoizquierdo);
			Postorden(un_nodo9.hijoderecho);
                        p.pizarra.setText(p.pizarra.getText()+un_nodo9.Valor+"  ");             
			//System.out.println("Postorden: "+un_nodo9.Valor);
		}
	}
}
