  

class nodoArbol {
	
		arbolBusquedaBinaria hd;
		arbolBusquedaBinaria hi;
        private int numero;
        
        public nodoArbol(){
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