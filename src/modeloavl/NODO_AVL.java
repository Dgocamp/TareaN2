/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloavl;

/**
 *
 * @author UsuarioN°1000
 */
public class NODO_AVL {


    int Valor, FE;
    NODO_AVL hijoizquierdo;
    NODO_AVL hijoderecho;

    public NODO_AVL() {
    }
	
	public NODO_AVL (int Valor1) {
		this.Valor=Valor1;
		this.FE=0;
		this.hijoizquierdo=null;
		this.hijoderecho=null;
	}
	
	public int obtener_valor(){
		return Valor;
	}
	public NODO_AVL obtener_hijoderecho(){
		return hijoderecho;
	}
	public NODO_AVL obtener_hijoizquierdo(){
		return hijoizquierdo;
	}
}
