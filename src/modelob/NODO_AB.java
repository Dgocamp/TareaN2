/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelob;

/**
 *
 * @author UsuarioN°1000
 */
public class NODO_AB {
    
    int NumClaves;
    int Claves[];
    boolean Hoja; 
    int T;
    NODO_AB Hijo[]; 
    NODO_AB NodoPadre;   
    
  
    
    public NODO_AB(int t, NODO_AB padre){
    
        this.T=t;
        this.NodoPadre=padre;
        Claves = new int [2*t-1];
        Hijo = new NODO_AB[2*t];
        Hoja = true;
        NumClaves = 0;
    
    }
    
    public int getValor(int valor){
    
        return Claves[valor];
    }
    
    public NODO_AB getHijo(int valor){
    
        return Hijo[valor];
    }
}