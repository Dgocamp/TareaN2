/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelob;

import vista.Plataforma;


/**
 *
 * @author UsuarioN°1000
 */
public class API_AB {
    
    private int orden; // Orden del arbol
    NODO_AB raiz; 
    Plataforma p;
    public NODO_AB getRaiz() {
        return raiz;
    }
    
    
    public API_AB() {
       
    }
    
    public API_AB(int orden,Plataforma p){
        this.p=p;
        this.orden=orden;
        raiz = new NODO_AB(orden, null);
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Método para buscar devuelve un nodo con valor clave en él.
     * 
     */
    
    public NODO_AB Buscar(NODO_AB raiz, int clave){
    
        int i=0;                                                                //siempre queremos comenzar a buscar el 0 ° índice del nodo.
        while(i < raiz.NumClaves && clave > raiz.Claves[i]){                    
        
            i=i+1;
        }
        if(i <= raiz.NumClaves && clave == raiz.Claves[i]){    
            //si la clave está en el nodo vamos a regresar al nodo
            p.info.setText(clave+" ENCONTRADO");
            p.pizarra.setText(p.pizarra.getText()+"Clave encontrada: "+clave+".\n");
            //System.out.println("clave encontrada "+clave+"   ");
            return raiz;
        }
        if(raiz.Hoja){                                                          //como ya hemos revisado la raíz si es hoja, no tenemos nada más que verificar
            p.pizarra.setText(p.pizarra.getText()+"Clave no se encuentra en el árbol.\n");
            //System.out.println("clave no se encuentra en el arbol");
            return null;
            
        }else{                                                                  //de lo contrario, si no es deja recurrir hacia abajo a través del hijo. 
        
            return Buscar(raiz.getHijo(i),clave);
        }
    
    }
 
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Método para insertar en general.
     *
     */
    
    public void Insertar(API_AB Ab, int clave){
    
        NODO_AB r = Ab.raiz;                                                       //este método encuentra el nodo que se insertará a medida que pasa por este inicio en el nodo raíz.
        if(r.NumClaves == 2*orden-1){                                           //si esta lleno
        
            p.pizarra.setText(p.pizarra.getText()+"Hoja llena.\n");
            //System.out.println("hoja llena ");
            NODO_AB s = new NODO_AB(orden,null);                                      //crea nuevo nodo
            Ab.raiz = s;
            s.Hoja = false;
            s.NumClaves = 0;
            s.Hijo[0] = r;
            Split(s,0,r);                                                       //divide raiz
            InsertNonFull(s,clave);                                             //llama al metodo de incesion.
            
        }else{
        
            InsertNonFull(r,clave);                                             //si no está lleno solo insértelo.
        }
    
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Método de división. Se dividirá el nodo en el que queremos insertar si está lleno.
     */
    
    public void Split(NODO_AB x, int i, NODO_AB y){
        p.pizarra.setText(p.pizarra.getText()+"Dividiendo el nodo.\n");
        //System.out.println("\n dividiendo el nodo \n");
        NODO_AB z = new NODO_AB(orden,null);                                          //hay que tener un nodo adicional si vamos a dividir 
        z.Hoja = y.Hoja;                                                        //establecer booleano a lo mismo que y
        z.NumClaves = orden-1;                                                  
        for(int j=0; j< orden-1; j++){
        
            z.Claves[j] = y.Claves[orden+j];
        }
        if(!y.Hoja ){                                                           //si no es una hoja, tenemos que reasignar nodos secundarios.
        
            for(int k =0; k < orden;k++){
            
                //z.Claves[k]= y.Claves[k+orden];
                z.Hijo[k]=y.Hijo[k+orden];
            }
        }
        y.NumClaves=orden-1;
        for(int j= x.NumClaves; j>i;j--){                                       
        
            x.Hijo[j+1]= x.Hijo[j];                                             //cambiar hijos de x.
        }
        x.Hijo[i+1] = z;                                                        //reasignar i + 1 hijo de x
        for(int j = x.NumClaves; j> i; j--){        
        
            x.Claves[j + 1] = x.Claves[j];
        }
        x.Claves[i] = y.Claves[orden-1]; 
        y.Claves[orden-1 ] = 0;
        for(int j = 0; j < orden - 1; j++){
            
	    y.Claves[j + orden] = 0;                        
	}
	x.NumClaves ++; 
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Será el método de inserción cuando el nodo no está lleno.
     */
    
    public void InsertNonFull(NODO_AB x, int clave){
    
        int i= x.NumClaves;                                                     //i es el número de claves en el nodo x
        if(x.Hoja){
        
            while(i >= 1 && clave < x.Claves[i-1]){
            
                x.Claves[i] = x.Claves[i-1];
                i--;
            }
            x.Claves[i] = clave;                            
	    x.NumClaves ++;  
            p.pizarra.setText(p.pizarra.getText()+"Insertamos la clave: "+clave+".\n");
            //System.out.println("insertamos la clave :"+clave);                  //Incremente el recuento de claves en este nodo ahora.
        }else{
        
            int j=0;
           // while(j < 1 && clave > x.Claves[j]){
           while(j<x.NumClaves && clave > x.Claves[j]){
            
                j++;
            }
            if(x.Hijo[j].NumClaves == orden*2 - 1){
            
                Split(x,j,x.Hijo[j]);
                if(clave > x.Claves[j]){
                
                    j++;
                }
            }
            InsertNonFull(x.Hijo[j],clave);
        }
    }

////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////// 
    /**
     * Este método eliminará un valor de clave del nodo hoja en el que se encuentra. Usaremos el método de búsqueda para recorrer el árbol y encontrar el nodo donde está la clave.
     * Luego iteraremos a través de la matriz clave [] hasta que lleguemos al nodo y asignará la tecla de sobrescritura k [i] = k [i + 1] que queremos eliminar y también mantendrá los espacios en blanco.
     */
    
    public void eliminar(API_AB x, int clave){
    
    
        NODO_AB temp = new NODO_AB(orden, null);
        temp = Buscar(x.raiz ,clave);
        if(temp.Hoja && temp.NumClaves > orden - 1){
                    int i = 0;

                    while( clave > temp.getValor(i)){
                        
				i++;
                    }
                    for(int j = i; j < 2*orden - 2; j++){
                        
				temp.Claves[j] = temp.getValor(j+1);
                    }
                    temp.NumClaves --;
                    p.pizarra.setText(p.pizarra.getText()+"Dato eliminado con éxito.\n");
                    p.info.setText(clave+" ELIMINADO");
                    //System.out.println("Dato eliminado con exito");
		
	}else{
            p.pizarra.setText(p.pizarra.getText()+"Éste nodo no es una hoja.\n");
            //System.out.println("este nodo no es una hoja");
        }
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
    /**
     * Este será un método para imprimir el arbol en preorden.
     */
    
    public void Imprimir(NODO_AB n){
		for(int i = 0; i < n.NumClaves; i++){
                        p.pizarra.setText(p.pizarra.getText()+n.getValor(i)+"  ");
			//System.out.print(n.getValor(i)+" " );                   //esta parte imprime el nodo raíz
		}
		if(!n.Hoja){                                                    //esto se llama cuando la raíz no es hoja;{
			for(int j = 0; j <= n.NumClaves; j++){                  //en este ciclo recursiva para imprimir el árbol en la forma de preorden.
			
				if(n.getHijo(j) != null) {
                                p.pizarra.setText(p.pizarra.getText()+"\n");
				                                                //yendo de la izquierda a la mayoría de los niños a los más a la derecha.
				//System.out.println();	  
				Imprimir(n.getHijo(j));     
				}
			}
		}
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Este será un método para imprimir un nodo
     */
    
    public void SearchPrintNode( API_AB T,int x){
        
		NODO_AB temp= new NODO_AB(orden,null);
		temp= Buscar(T.raiz,x);

		if (temp==null){
                p.pizarra.setText(p.pizarra.getText()+"La clave no existe.\n");
		//System.out.println("La clave no existe");
                
		}
		else{

		Imprimir(temp); 
                
		}
    }

}
