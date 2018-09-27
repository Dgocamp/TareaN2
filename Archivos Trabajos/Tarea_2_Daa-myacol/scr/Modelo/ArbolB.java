public class ArbolB {
    
    
    static int orden; // Orden del arbol
    Nodo raiz; 
    
    public ArbolB(int orden){
    
        this.orden=orden;
        raiz = new Nodo(orden, null);
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    /**
     * Método para buscar devuelve un nodo con valor clave en él.
     * 
     */
    
    public Nodo Buscar(Nodo raiz, int clave){
    
        int i=0;                                                                //siempre queremos comenzar a buscar el 0 ° índice del nodo.
        while(i < raiz.NumClaves && clave > raiz.Claves[i]){                    
        
            i=i+1;
        }
        if(i <= raiz.NumClaves && clave == raiz.Claves[i]){                     //si la clave está en el nodo vamos a regresar al nodo
        
            System.out.println("clave encontrada "+clave+"   ");
            return raiz;
        }
        if(raiz.Hoja){                                                          //como ya hemos revisado la raíz si es hoja, no tenemos nada más que verificar
        
            System.out.println("clave no se encuentra en el arbol");
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
    
    public void Insertar(ArbolB Ab, int clave){
    
        Nodo r = Ab.raiz;                                                       //este método encuentra el nodo que se insertará a medida que pasa por este inicio en el nodo raíz.
        if(r.NumClaves == 2*orden-1){                                           //si esta lleno
        
            System.out.println("hoja llena ");
            Nodo s = new Nodo(orden,null);                                      //crea nuevo nodo
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
    
    public void Split(Nodo x, int i, Nodo y){
    
        System.out.println("\n dividiendo el nodo \n");
        Nodo z = new Nodo(orden,null);                                          //hay que tener un nodo adicional si vamos a dividir 
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
    
    public void InsertNonFull(Nodo x, int clave){
    
        int i= x.NumClaves;                                                     //i es el número de claves en el nodo x
        if(x.Hoja){
        
            while(i >= 1 && clave < x.Claves[i-1]){
            
                x.Claves[i] = x.Claves[i-1];
                i--;
            }
            x.Claves[i] = clave;                            
	    x.NumClaves ++;  
            System.out.println("insertamos la clave :"+clave);                  //Incremente el recuento de claves en este nodo ahora.
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
    
    public void eliminar(ArbolB x, int clave){
    
    
        Nodo temp = new Nodo(orden, null);
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
                    System.out.println("Dato eliminado con exito");
		
	}else{
            
            System.out.println("este nodo no es una hoja");
        }
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////  
    /**
     * Este será un método para imprimir el arbol en preorden.
     */
    
    public void Imprimir(Nodo n){
		for(int i = 0; i < n.NumClaves; i++){
                    
			System.out.print(n.getValor(i)+" " );                   //esta parte imprime el nodo raíz
		}
		if(!n.Hoja){                                                    //esto se llama cuando la raíz no es hoja;{
			for(int j = 0; j <= n.NumClaves; j++){                  //en este ciclo recursiva para imprimir el árbol en la forma de preorden.
			
				if(n.getHijo(j) != null) {
				                                                //yendo de la izquierda a la mayoría de los niños a los más a la derecha.
				System.out.println();	  
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
    
    public void SearchPrintNode( ArbolB T,int x){
        
		Nodo temp= new Nodo(orden,null);
		temp= Buscar(T.raiz,x);

		if (temp==null){

		System.out.println("La clave no existe");
                
		}
		else{

		Imprimir(temp); 
                
		}
    }

    
}
