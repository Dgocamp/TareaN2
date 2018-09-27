import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hp Envy
 */
public class ArbolBTest {
    
    ArbolB ab = new ArbolB(3);
    Nodo n = new Nodo(3,null);
    @Test
    void testInsertar() {

        ab.Insertar(ab, 2);
        ab.Insertar(ab, 4);
        ab.Insertar(ab, 6);
        ab.Insertar(ab, 3);
        ab.Insertar(ab, 9);
        ab.Buscar(ab.raiz, 2);
        ab.Imprimir(ab.raiz);
        System.out.println("\n");
        //busco un valor ingresado
        //n = ab.Buscar(ab.raiz, 2);
        //int valor = n.NumClaves;
        assertEquals(2,ab.Buscar(ab.raiz, 2).NumClaves);
        
    }


  
}
