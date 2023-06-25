
package solactividad5;

import arbolGeneral.*;
import cola.*;
import java.util.List;


public class SolActividad5 {

    // En transparencias
    public static <E> void preorden(ArbolGeneral<E> a){
        if (!a.esVacio()){
            System.out.print(" "+a.raiz());
            ArbolGeneral<E> aux=a.hijoMasIzq();
            while (!aux.esVacio()){
                preorden(aux);
                aux=aux.hermanoDer();
            }
        }
    }
    // En transparencias    
    public static <E> void inorden(ArbolGeneral<E> a){
        if (!a.esVacio()){
            ArbolGeneral<E> aux=a.hijoMasIzq();
            inorden (aux);
            System.out.print(" "+a.raiz());
            if (!aux.esVacio()){
                aux=aux.hermanoDer();
                while (!aux.esVacio()){
                    inorden(aux);
                    aux=aux.hermanoDer();
                }
            }
        }
    }
    // En transparencias
    public static int contarNodos (ArbolGeneral<Integer> a){
        if (a.esVacio())
            return 0;
        else {
            int cont=1;
            ArbolGeneral<Integer> hijo = a.hijoMasIzq();
            while (!hijo.esVacio()){
                cont+=contarNodos(hijo);
                hijo=hijo.hermanoDer();
            }
            return cont;
        }
    }
    
    // Ejercicio 1
    public static int sumaNodos (ArbolGeneral<Integer> a){
        if (a.esVacio())
            return 0;
        else {
            int cont=a.raiz();
            ArbolGeneral<Integer> hijo = a.hijoMasIzq();
            while (!hijo.esVacio()){
                cont+=sumaNodos(hijo);
                hijo=hijo.hermanoDer();
            }
            return cont;
        }
    }

     //Ejercicio 2
    public static <E> boolean igualEstructura(ArbolGeneral<E> a, ArbolGeneral<E> b){
        if (a.esVacio() && b.esVacio()) return true;
        if (a.esVacio() || b.esVacio()) return false;
        ArbolGeneral<E> ha = a.hijoMasIzq();
        ArbolGeneral<E> hb = b.hijoMasIzq();
        while (!ha.esVacio() && !hb.esVacio())
        {
            if (!igualEstructura(ha,hb)) return false;
            ha = ha.hermanoDer();
            hb=hb.hermanoDer();
        }
        return ha.esVacio() && hb.esVacio();                    
    }


    //Ejercicio 3
    public static <E> boolean arbolDosTres (ArbolGeneral<E> a){
        if (a.esVacio())
            return true;
        ArbolGeneral<E> hijo = a.hijoMasIzq();
        if (hijo.esVacio()) return true;
        int cont = 0;
        while(!hijo.esVacio()){
            if (!arbolDosTres(hijo))
                return false;
            cont++;
            hijo = hijo.hermanoDer();
        } 
        if (cont==2 || cont==3) return true;
        return false;
    }
    
    //ejercicio 4
    public static <E extends Comparable<E>> boolean esSeleccion (ArbolGeneral<E> a){
        if (a.esVacio()) return true;
        else {
                ArbolGeneral<E> hijo = a.hijoMasIzq();
                if (hijo.esVacio()) return true;
                else {
                        E menor =hijo.raiz();
                        while (!hijo.esVacio() && esSeleccion(hijo)){
                                if(hijo.raiz().compareTo(menor)<0) menor=hijo.raiz();
                                hijo = hijo.hermanoDer();
                        }
                        if(hijo.esVacio() && a.raiz().equals(menor)) return true;
                        else return false;
                }
        }
    }

   

// Ejercicio 5
  public static <E> int nivel (ArbolGeneral<E> a, E elemento){
      if (a.esVacio())
          return -1; // no está elemento
      else {
          if (a.raiz().equals(elemento)){
              return 0;
          }
          else {
              ArbolGeneral<E> hijo = a.hijoMasIzq();
              while( ! hijo.esVacio()){
                  int n = nivel(hijo, elemento);
                  if ( n == -1) 
                      hijo  = hijo.hermanoDer();
                  else return 1 + n;
              }
              return -1; // no está elemento
          }
      }
  }

// Ejercicio 6
 public static <E> int grado(ArbolGeneral<E> a){
     if (a.esVacio())
         return 0;
     else {
         int num=0;
         ArbolGeneral<E> hijo=a.hijoMasIzq();
         while (!hijo.esVacio()){
             num++;
             hijo=hijo.hermanoDer();                
         }
         int maxGrado=num;
         hijo=a.hijoMasIzq();
         while (!hijo.esVacio()){
             int gradoAct=grado(hijo);
             if (gradoAct>maxGrado)
                 maxGrado=gradoAct;
             hijo=hijo.hermanoDer();
         }
         return maxGrado;
     }
 }

//*******************************
// ****************************** OTROS EJERCICIOS PROPUESTOS
// ******************************
     // Ejercicio 7
     public static <E> int altura(ArbolGeneral<E> a)
      {
         if (a.esVacio()) return 0;
         if (a.hijoMasIzq().esVacio()) return 0;
         int maxGrado=0;
         ArbolGeneral<E> hijo = a.hijoMasIzq();
         while (!hijo.esVacio())
         {
             int cont = altura(hijo);
             if (cont > maxGrado) maxGrado = cont;
             hijo = hijo.hermanoDer();
         }
         return maxGrado+1;
      }

     //ejercicio 8
     public static <E> void anchura(ArbolGeneral<E> a){
        Cola<ArbolGeneral<E>> c = new EnlazadaCola<>();
        c.insertar(a);
        do {
            a = c.suprimir();
            if (!a.esVacio()){
                System.out.print(a.raiz() + " ");
                ArbolGeneral<E> hijo=a.hijoMasIzq();
                while ( !hijo.esVacio() ){
                    c.insertar(hijo);
                    hijo=hijo.hermanoDer();
                }
            }
        }while (!c.esVacio());
     }

     //ejercicio 9
    
    public static int numNodosPares (ArbolGeneral<Integer> a){
      if (a.esVacio())
           return 0;

       else {
           int cont=0;
           if (a.raiz()%2==0) cont++;
           ArbolGeneral<Integer> hijo = a.hijoMasIzq();
           while (!hijo.esVacio()){
               cont+=numNodosPares(hijo);
               hijo=hijo.hermanoDer();
           }
           return cont;
       }
   }
    
    //ejercicio 10
    //guarda en una lista las hojas del árbol general	    
    public static <E> void hojas(ArbolGeneral<E> a, List<E> l){
        if (!a.esVacio()){
            if (a.hijoMasIzq().esVacio()) l.add(a.raiz());
                else {
                    ArbolGeneral<E> hijo = a.hijoMasIzq();
                    while (!hijo.esVacio())
                    {
                        hojas(hijo, l);
                        hijo = hijo.hermanoDer();
                    }                 
                }
        }
    }

//Otros métodos no propuestos
/*
    public static <E> boolean identicos(ArbolGeneral<E> a, ArbolGeneral<E> b){
        if (a.esVacio() && b.esVacio())
            return true;
        if (!a.esVacio() && !b.esVacio())
            if (!a.raiz().equals(b.raiz())) return false;
            else {
                ArbolGeneral<E> ha = a.hijoMasIzq();
                ArbolGeneral<E> hb = b.hijoMasIzq();
                while (!ha.esVacio() && !hb.esVacio())
                {
                    if (!identicos(ha,hb)) return false;
                    ha = ha.hermanoDer();
                    hb = hb.hermanoDer();
                }
                return ha.esVacio() && hb.esVacio();
            }
        return false;                    
    }

     
	  public static <E> boolean cuadArbol(ArbolGeneral<E> arbol){
        if (arbol.esVacio()) return true;
        else {
                ArbolGeneral<E> hijo = arbol.hijoMasIzq();
                if (hijo.esVacio()) return true;
                else {
                        int cont = 0;
                        while(!hijo.esVacio() && cuadArbol(hijo)){
                                cont++;
                                hijo = hijo.hermanoDer();
                        }
                        if (hijo.esVacio()) return cont==4;
                        else return false;
                }
        }
    }
    


    public static ArbolGeneral<Integer> duplicar (ArbolGeneral<Integer> a){
        if (a.esVacio()) return new EnlazadoArbolGeneral<>();
        int numSubArboles = subArboles(a);
        ArbolGeneral<Integer> [] copias = (ArbolGeneral<Integer>[])new ArbolGeneral[numSubArboles] ;
        ArbolGeneral<Integer> hijo = a.hijoMasIzq();
        int i = 0;
        while (!hijo.esVacio()){
            copias[i++] = duplicar(hijo);
            hijo=hijo.hermanoDer();
        }
        return new EnlazadoArbolGeneral<>(a.raiz()*2, copias);
    }


    public static <E> int subArboles(ArbolGeneral<E> a){
        if (a.esVacio())
            return 0;
        else {
            int cont = 0;
            ArbolGeneral<E> hijo = a.hijoMasIzq();
            while (!hijo.esVacio())
             {
                 cont++;
                 hijo = hijo.hermanoDer();
             }
            return cont;
     }
    }

    public static <E> boolean equilibrado(ArbolGeneral<E> a){
        if (a.esVacio())
            return true;
        else if (a.hijoMasIzq().esVacio())
                return true;
        else {
            int numSub = subArboles(a);
            ArbolGeneral<E> hijo = a.hijoMasIzq();
            while (!hijo.esVacio())
                    {
                                int numSubHijo = subArboles(hijo);
                                if (numSubHijo!=0 && numSub!=numSubHijo) return false;
                                if (!equilibrado(hijo)) return false;
                        hijo = hijo.hermanoDer();
                    }
            return true;
        }
    }

    public static <E> int numHijosPares(ArbolGeneral<E>  a){
        if (a.esVacio()) return 0;
        int contNodos=0, contHijos = 0;
            ArbolGeneral<E> hijo = a.hijoMasIzq();
            while (!hijo.esVacio()){
                contHijos++;
                hijo = hijo.hermanoDer();
            }
            if (contHijos%2==0) 
                contNodos =1;
            hijo = a.hijoMasIzq(); 
            while (!hijo.esVacio()){
                contNodos+=numHijosPares(hijo);;
                hijo = hijo.hermanoDer();
            }
            return contNodos;
    }
    
 */   

}
