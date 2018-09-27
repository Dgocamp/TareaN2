/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modeloabb.API_ABB;
import modeloavl.API_AVL;
import modelob.API_AB;
import modelob.NODO_AB;
import vista.Plataforma;

/**
 *
 * @author UsuarioN°1000
 */
public class Controlador {
    Plataforma p;
    API_ABB abb;
    API_AVL avl;
    API_AB ab;

    public Controlador(Plataforma p,API_ABB abb,API_AVL avl,API_AB ab) {
        this.p = p;
        this.abb = abb;
        this.avl=avl;
        this.ab=ab;
        inicio();
    }
    private void inicio(){
        p.arboles.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(p.arboles.getSelectedIndex()){
                      case 1:
                          p.titulo.setText("Árbol binario");
                          p.recorridos.setEnabled(true);
                          p.btneliminar.setEnabled(true);
                          p.btnbuscar.setEnabled(true);
                          p.btninsertar.setEnabled(true);
                          p.btngenerar.setEnabled(true);
                          p.btnrecorrer.setEnabled(true);
                          p.btnbtree.setEnabled(false);
                          break;
                      case 2:
                          p.titulo.setText("Árbol AVL");
                    
                          p.recorridos.setEnabled(true);
                          p.btneliminar.setEnabled(true);
                          p.btnbuscar.setEnabled(true);
                          p.btninsertar.setEnabled(true);
                          p.btngenerar.setEnabled(true);
                          p.btnrecorrer.setEnabled(true);
                          p.btnbtree.setEnabled(false);
                          break;
                      case 3:
                          p.titulo.setText("Árbol B");  
                          p.recorridos.setEnabled(false);
                          p.btneliminar.setEnabled(false);
                          p.btnbuscar.setEnabled(false);
                          p.btninsertar.setEnabled(false);
                          p.btngenerar.setEnabled(false);
                          p.btnrecorrer.setEnabled(false);
                          p.btnbtree.setEnabled(true);
                                               
                          break;                       
                      
                }
                p.txtinsertar.setText("");p.txteliminar.setText("");p.txtbuscar.setText("");
                
            }
        });
        p.btnbtree.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(p.btnbtree.isSelected()){ 
                    if(Integer.parseInt(p.txtbtree.getText())>=2){
                        p.info.setText("ORDEN "+Integer.parseInt(p.txtbtree.getText()));
                        JOptionPane.showMessageDialog(null,"El Árbol B es de orden número "+Integer.parseInt(p.txtbtree.getText()));
                        ab = new API_AB(Integer.parseInt(p.txtbtree.getText()),p);
                        NODO_AB n = new NODO_AB(Integer.parseInt(p.txtbtree.getText()),null);
                        p.btnbuscar.setEnabled(true);
                        p.btneliminar.setEnabled(true);
                        p.btngenerar.setEnabled(true);
                        p.btnrecorrer.setEnabled(true);
                        p.btninsertar.setEnabled(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"Árbol debe de ser orden 2 o superior");
                    }
                                         
                }             
            }
        });
        p.btninsertar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(p.arboles.getSelectedIndex()){
                      case 1:
                          abb.insertar(Integer.parseInt(p.txtinsertar.getText()));
                          break;
                      case 2:
                          avl.insertar(Integer.parseInt(p.txtinsertar.getText()));
                          break;
                      case 3:                
                          ab.Insertar(ab,Integer.parseInt(p.txtinsertar.getText()));
                          break;                       
                      
                }
                p.txtinsertar.setText("");
                
            }
        });
        p.btneliminar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(p.arboles.getSelectedIndex()){
                      case 1:
                          abb.eliminarDato(Integer.parseInt(p.txteliminar.getText()));
                          break;
                      case 2:
                          avl.Eliminar_registro_en_AVL(Integer.parseInt(p.txteliminar.getText()),avl);
                          break;
                      case 3:
                 
                          ab.eliminar(ab,Integer.parseInt(p.txteliminar.getText()));
                          break;  
                      
                      
                }
                p.txteliminar.setText("");
            }
        });  
        p.btnbuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                switch(p.arboles.getSelectedIndex()){
                      case 1:
                          abb.busqueda(Integer.parseInt(p.txtbuscar.getText()));
                          break;
                      case 2:
                          avl.Buscar_registro_en_AVL(Integer.parseInt(p.txtbuscar.getText()),avl.obtener_raiz());
                          break;
                      case 3:
                          ab.Buscar(ab.getRaiz(),Integer.parseInt(p.txtbuscar.getText()));
                          break;                                              
                }
                p.txtbuscar.setText("");                
            }
        }); 
        p.btnrecorrer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 switch(p.arboles.getSelectedIndex()){
                      case 1:
                            switch(p.recorridos.getSelectedIndex()){
                                case 1:
                                    p.pizarra.setText(p.pizarra.getText()+"\nPreorden: ");
                                    abb.preOrdenAbb();
                                    break;
                                case 2:
                                    p.pizarra.setText(p.pizarra.getText()+"\nPosorden: ");
                                    abb.posOrdenAbb();
                                    break;
                                case 3:
                                    p.pizarra.setText(p.pizarra.getText()+"\nInorden: ");
                                    abb.inOrdenAbb();
                                    break;                                              
                            } 
                          break;
                      case 2:
                          switch(p.recorridos.getSelectedIndex()){
                                case 1:
                                    p.pizarra.setText(p.pizarra.getText()+"\nPreorden: ");
                                    avl.Preorden(avl.obtener_raiz());
                                    break;
                                case 2:
                                    p.pizarra.setText(p.pizarra.getText()+"\nPosorden: ");
                                    avl.Postorden(avl.obtener_raiz());
                                    break;
                                case 3:
                                    p.pizarra.setText(p.pizarra.getText()+"\nInorden: ");
                                    avl.Inorden(avl.obtener_raiz());
                                    break;                                              
                            } 
                          break;
                      case 3:
                          p.pizarra.setText(p.pizarra.getText()+"\nRecorrido Árbol B: ");
                          ab.Imprimir(ab.getRaiz());
                          break;                       
                      
                  }
                               
            }
        }); 
        p.btngenerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 switch(p.arboles.getSelectedIndex()){
                      case 1:
                            switch(p.valores.getSelectedIndex()){
                                case 1:
                                    for(int i=0;i<=100;i++){
                                        int numero = (int) (Math.random()*100) + 1;
                                        abb.insertar(numero);
                                    }  
                                    break;
                                case 2:
                                    for(int i=0;i<=1000;i++){
                                        int numero = (int) (Math.random()*1000) + 1;
                                        abb.insertar(numero);
                                    } 
                                    break;
                                case 3:
                                    for(int i=0;i<=10000;i++){
                                        int numero = (int) (Math.random()*10000) + 1;
                                        abb.insertar(numero);
                                    } 
                                    break;                                              
                            } 
                          break;
                      case 2:
                          switch(p.valores.getSelectedIndex()){
                                case 1:
                                    for(int i=0;i<=100;i++){
                                        int numero = (int) (Math.random()*100) + 1;
                                        avl.insertar(numero);
                                    }  
                                    break;
                                case 2:
                                    for(int i=0;i<=1000;i++){
                                        int numero = (int) (Math.random()*1000) + 1;
                                        avl.insertar(numero);
                                    } 
                                    break;
                                case 3:
                                    for(int i=0;i<=10000;i++){
                                        int numero = (int) (Math.random()*10000) + 1;
                                        avl.insertar(numero);
                                    } 
                                    break;                                              
                            } 
                          break;
                      case 3:
                          switch(p.valores.getSelectedIndex()){
                                case 1:
                                    for(int i=0;i<=100;i++){
                                        int numero = (int) (Math.random()*100) + 1;
                                        ab.Insertar(ab,numero);
                                    }  
                                    break;
                                case 2:
                                    for(int i=0;i<=1000;i++){
                                        int numero = (int) (Math.random()*1000) + 1;
                                        ab.Insertar(ab,numero);
                                    } 
                                    break;
                                case 3:
                                    for(int i=0;i<=10000;i++){
                                        int numero = (int) (Math.random()*10000) + 1;
                                        ab.Insertar(ab,numero);
                                    } 
                                    break;                                              
                            } 
                          break;                       
                      
                  }
            }
        });  
        p.btnborrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                p.pizarra.setText("");  
                p.info.setText("");
            }
        }); 
    }
    
}
