import arbolBinario.ArbolBinario;
import arbolBinario.ArbolVacioExcepcion;
import arbolBinario.EnlazadoArbolBinario;

public class Main {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArbolBinario<Integer> arbol1 = new EnlazadoArbolBinario<>(
      4,
      new EnlazadoArbolBinario<>(),
      new EnlazadoArbolBinario<>()
    );
    ArbolBinario<Integer> arbol2 = new EnlazadoArbolBinario<>(
      3,
      new EnlazadoArbolBinario<>(),
      new EnlazadoArbolBinario<>()
    );
    ArbolBinario<Integer> arbol3 = new EnlazadoArbolBinario<>(
      6,
      arbol1,
      arbol2
    );
    ArbolBinario<Integer> arbol4 = new EnlazadoArbolBinario<>(
      7,
      arbol3,
      new EnlazadoArbolBinario<>()
    );

    ArbolBinario<Integer> arbolDos = new EnlazadoArbolBinario<>(
      1,
      new EnlazadoArbolBinario<>(),
      new EnlazadoArbolBinario<>()
    );
    ArbolBinario<Integer> arbolTres = new EnlazadoArbolBinario<>(
      1,
      arbolDos,
      new EnlazadoArbolBinario<>()
    );
    ArbolBinario<Integer> arbol = new EnlazadoArbolBinario<>(
      4,
      new EnlazadoArbolBinario<>(),
      new EnlazadoArbolBinario<>()
    );
    ArbolBinario<Integer> arbolCuatro = new EnlazadoArbolBinario<>(
      4,
      arbol,
      new EnlazadoArbolBinario<>()
    );

    System.out.println(completo(arbol4));
    System.out.println(sonIdenticos(null, null));
    System.out.println(numNodos(arbol2, 0));
    System.out.println("arbol to string: " + arbol4.raiz());
  }

  /*1.  Escribe  un  método  que  dado  un  árbol  binario  devuelva  verdadero  si  el  árbol  es  completo  y  falso  en  
otro caso. Un árbol binario es completo si todos sus nodos tienen dos descendientes, excepto las hojas.  */
  public static boolean completo(ArbolBinario vacio)
    throws ArbolVacioExcepcion {
    try {
      if (vacio.esVacio()) {
        return true;
      }
      if (vacio.hijoDer() != null && vacio.hijoIzq() != null) {
        return completo(vacio.hijoDer()) && completo(vacio.hijoIzq());
      }
    } catch (ArbolVacioExcepcion nueva) {
      return false;
    }
    return true;
  }

  /*2.  Escribe un método que dados dos árboles binarios A y B, determine si son idénticos o no.  */
  public static boolean sonIdenticos(ArbolBinario A, ArbolBinario B) {
    if (A == null && B == null) {
      return true;
    }

    if (A == null || B == null) {
      return false;
    }

    if (A.esVacio() && B.esVacio()) {
      return true;
    }

    if (A.raiz().equals(B.raiz())) {
      return (
        sonIdenticos(A.hijoDer(), B.hijoDer()) &&
        sonIdenticos(A.hijoIzq(), B.hijoIzq())
      );
    }

    return false;
  }

  /*3.  Escribe un método que cuente el número de nodos que están en el nivel n de un árbol binario. */

  public static int numNodos(ArbolBinario arbol, int nivel) {
    int hijos = 0;
    if (nivel == 0) {
      return 1;
    } else {
      try {
        hijos += numNodos(arbol.hijoDer(), nivel - 1);
      } catch (ArbolVacioExcepcion e) {}

      try {
        hijos += numNodos(arbol.hijoIzq(), nivel - 1);
      } catch (ArbolVacioExcepcion e) {}
      return hijos;
    }
  }

  /*4.  Escribe un método que dado un árbol binario A, cree un árbol binario B igual que A pero sin las hojas.  */
 // public static 
public static ArbolBinario<E>

}
