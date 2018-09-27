/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarean2;

import controlador.Controlador;
import modeloabb.API_ABB;
import modeloavl.API_AVL;
import modelob.API_AB;
import vista.Plataforma;

/**
 *
 * @author UsuarioN°1000
 */
public class TareaN2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Plataforma p = new Plataforma();       
        API_ABB abb = new API_ABB(p);
        API_AVL avl = new API_AVL(p);       
        API_AB ab = new API_AB();
        Controlador c = new Controlador(p,abb,avl,ab);
        p.setVisible(true);
    }
    
}
