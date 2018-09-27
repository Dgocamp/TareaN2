public class Nodo {
    
    int NumClaves;
    int Claves[];
    boolean Hoja; 
    int T;
    Nodo Hijo[]; 
    Nodo NodoPadre;   
    
    
    
    public Nodo(int t, Nodo padre){
    
        this.T=t;
        this.NodoPadre=padre;
        Claves = new int [2*t-1];
        Hijo = new Nodo[2*t];
        Hoja = true;
        NumClaves = 0;
    
    }
    
    public int getValor(int valor){
    
        return Claves[valor];
    }
    
    public Nodo getHijo(int valor){
    
        return Hijo[valor];
    }
    
}
