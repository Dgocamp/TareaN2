/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloabb;

/**
 *
 * @author UsuarioN°1000
 */
public class NODO_ABB {
    API_ABB hd;
    API_ABB hi;
    private int numero;
        
    public NODO_ABB(){
        hd = null;
        hi = null;
        numero = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
}
