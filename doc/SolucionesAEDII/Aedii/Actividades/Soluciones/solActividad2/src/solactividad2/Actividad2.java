/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solactividad2;
import arbolBinario.*;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author LenovoPavon
 */
public class Actividad2 {

    //Ejercicios en transparencias
    
    //En transparencias
    public static <E> int numNodos(ArbolBinario<E> a){
        if (a.esVacio()) return 0;
        return 1 + numNodos (a.hijoIzq()) + numNodos(a.hijoDer());
    }
    
    //En transparencias  
    public static <E> int numHojas (ArbolBinario<E> a){
        if (a.esVacio()) return 0;
        if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) return 1;
        return numHojas(a.hijoIzq()) + numHojas(a.hijoDer());
    }
    
    //En transparencias
    public static <E> boolean degenerado (ArbolBinario<E> a){
    	if (a.esVacio()) return true;
    	else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) return true;
    	else if (!a.hijoIzq().esVacio() && !a.hijoDer().esVacio()) return false;
    	else return degenerado(a.hijoIzq()) && degenerado(a.hijoDer());
    }
    //En transparencias
    public static <E> ArbolBinario<E> copia(ArbolBinario<E> a){
        if (a.esVacio())
            return new EnlazadoArbolBinario<>();
        else
            return new EnlazadoArbolBinario<>(a.raiz(), copia(a.hijoIzq()), copia(a.hijoDer()));
    } 
    
    // Ejercicios para resolver en clase
    
    //Ejercicio 1
    public static <E> boolean completo (ArbolBinario<E> a){
    	if (a.esVacio()) return true;
    	else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio()) return true;
    	else if (a.hijoIzq().esVacio() || a.hijoDer().esVacio()) return false;
    	else return completo(a.hijoIzq()) && completo(a.hijoDer());
    }
    
    //Ejercicio 2
    public static <E> boolean identicos (ArbolBinario<E> a, ArbolBinario<E> b){
        if (!a.esVacio() && !b.esVacio())
            return a.raiz().equals(b.raiz()) && identicos(a.hijoIzq(), b.hijoIzq()) && identicos(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
       
        //Ejercicio 3
    public static <E> boolean esta (ArbolBinario<E> a, E elem){
        if (a.esVacio())
            return false;
        else if (a.raiz().equals(elem))
            return true;
        else return esta(a.hijoIzq(), elem) || esta(a.hijoDer(), elem);
    }
    
    //Ejercicio 4 
    public static <E> int contarNivel(ArbolBinario<E> a, int nivel){
        if (a.esVacio()) return 0;
        else if (nivel == 0) return 1;
            else return contarNivel(a.hijoIzq(), nivel-1) + contarNivel(a.hijoDer(), nivel-1);
    }
    
     //Ejercicio 5 
    public static <E> ArbolBinario<E> eliminarHojas(ArbolBinario<E> arbol){
    	if (arbol.esVacio()) return new EnlazadoArbolBinario<>(); 
    	else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio())
    		return new EnlazadoArbolBinario<>();
    	   	else return new EnlazadoArbolBinario<>(arbol.raiz(), eliminarHojas(arbol.hijoIzq()),eliminarHojas(arbol.hijoDer()));
    	}
    
    //Ejercicio 6
    private static int maximo(int num1, int num2){
    	return num1>num2? num1:num2;
    }
    public static <E> int altura(ArbolBinario<E> a){
    	if (a.esVacio()) return -1;
        else if (a.hijoIzq().esVacio() && a.hijoDer().esVacio())
                    return 0;
              else return 1 + maximo(altura(a.hijoIzq()), altura(a.hijoDer()));   
    }
    
    // otros ejercicios propuestos
    
    //Ejercicio 7
    public static <E> boolean mismaForma (ArbolBinario<E> a, ArbolBinario<E> b){
        if (!a.esVacio() && !b.esVacio())
            return mismaForma(a.hijoIzq(), b.hijoIzq()) && mismaForma(a.hijoDer(), b.hijoDer());
        else return a.esVacio() && b.esVacio();
    }
        
    //Ejercicio 8
    public static <E extends Comparable<E>> boolean arbolSeleccion (ArbolBinario<E> arbol){
	    if (arbol.esVacio()) return true;
	    else if (arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()) return true;
	        	else if (arbol.hijoIzq().esVacio() && !arbol.hijoDer().esVacio())
	      		return arbol.raiz().equals(arbol.hijoDer().raiz()) && arbolSeleccion(arbol.hijoDer());
	    	else if(!arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio())
	        		return arbol.raiz().equals(arbol.hijoIzq().raiz()) && arbolSeleccion(arbol.hijoIzq());
	    	else {
	    		E menor = arbol.hijoIzq().raiz().compareTo(arbol.hijoDer().raiz())<0? arbol.hijoIzq().raiz(): arbol.hijoDer().raiz();
	    		return arbol.raiz().equals(menor) &&  arbolSeleccion(arbol.hijoIzq()) &&  arbolSeleccion(arbol.hijoDer());
	    	}
    }

        
    //Ejercicio 9
    public static <E> boolean esCamino2(ArbolBinario<E> arbol, String camino){
        return esCamino2(arbol, camino, 0);
    }
   
    private static <E> boolean esCamino2(ArbolBinario<E> arbol, String camino, int i){
        if (camino.length() == 0 || i == camino.length()-1) return true;
        if (arbol.esVacio()) return false;
        if (arbol.raiz().equals(camino.charAt(i)))
            return esCamino2(arbol.hijoIzq(), camino, i+1) || esCamino2(arbol.hijoDer(), camino, i+1);
        else return false;
    }

    //Ejercicio 9 otra vez
    public static <E> boolean esCamino(ArbolBinario<E> arbol, String camino){
        if (camino.length() == 0 ) return true;
        else if (arbol.esVacio()) return false;
        else if (arbol.raiz().equals(camino.charAt(0)))
            return esCamino(arbol.hijoIzq(), camino.substring(1)) || esCamino(arbol.hijoDer(), camino.substring(1));
        else return false;
    }
    
       
    //Ejercicio 10
    public static <E> ArbolBinario<E> copiaHastaNivel(ArbolBinario<E> a, int nivel){
    	if (a.esVacio()) return new EnlazadoArbolBinario<>();
    	else 
            if (nivel==0) return new EnlazadoArbolBinario<>(a.raiz(), new EnlazadoArbolBinario<>(), new EnlazadoArbolBinario<>());                  
            else return new EnlazadoArbolBinario<>(a.raiz(), copiaHastaNivel(a.hijoIzq(), nivel-1), copiaHastaNivel(a.hijoDer(), nivel-1));
    }
    
    //Ejercicio 11
    
    public static <E> void visualizarPalabras(ArbolBinario<E> a){
    	String palabra = "";
    	visualizarPalabras(a, palabra);
    }
    
    public static <E> void visualizarPalabras(ArbolBinario<E> a, String palabra){
        if(!a.esVacio()){
            if(a.hijoIzq().esVacio() && a.hijoDer().esVacio())
                System.out.println(palabra+a.raiz());
            else {
                visualizarPalabras(a.hijoIzq(), palabra+a.raiz());
                visualizarPalabras(a.hijoDer(), palabra+a.raiz());
            }
        }
    }
    
    
    //Ejercicio 12
    public static <E> E padre(ArbolBinario<E> a, E elemento){
		if (a.esVacio()) return null;
		else if (a.raiz().equals(elemento)) return null;
		else
			if ((!a.hijoIzq().esVacio() && a.hijoIzq().raiz().equals(elemento)) ||
				(!a.hijoDer().esVacio() && a.hijoDer().raiz().equals(elemento)))
				return a.raiz();
			else{
				E aux = padre(a.hijoIzq(), elemento);
				if (aux == null)
					return padre(a.hijoDer(), elemento);
				else return aux;
			}
    }
    
    //Ejercicio 13
    public static <E> boolean distanciaK (ArbolBinario<E> a, E elem, int k){
        //devuelve true si elem está a distancia k de la raiz
        if (a.esVacio())
            return false;
        else if (a.raiz().equals(elem) && k==0)
                return true;
        else if (k==0)
            return false;
        else return distanciaK(a.hijoIzq(), elem, k-1) || distanciaK(a.hijoDer(), elem, k-1);             
    }
    
    
    
    
    //***************************
    //*****************************Otros métodos no propuestos *************
    //**************************
      
    public static <E> List<E> nodosNivel(ArbolBinario<E> a, int nivel){
        // añade a la lista todos los nodos de un nivel
        List<E> toret  = new LinkedList<>();
        if (!a.esVacio()){
            if (nivel == 0) toret.add(a.raiz());
            else {
            toret.addAll(nodosNivel(a.hijoIzq(), nivel-1));
            toret.addAll(nodosNivel(a.hijoDer(), nivel-1));
            }
        }
        return toret;
    }
    
    public static <E> boolean estaContenido (ArbolBinario<E> arbolA, ArbolBinario<E> arbolB){
        if (arbolA.esVacio())
            return true;
        else if (!esta(arbolB, arbolA.raiz()))
            return false;
        return estaContenido(arbolA.hijoIzq(), arbolB) && estaContenido(arbolA.hijoDer(), arbolB);
    }
    
    private static <E> boolean nivelLleno (ArbolBinario<E> a, int nivel){
    	if (a.esVacio())
    		return false;
    	else if (nivel == 0)
    		return true;
    	else return nivelLleno(a.hijoIzq(), nivel-1) && nivelLleno(a.hijoDer(), nivel-1);
    }
    
    public static <E> int mayorNivelLleno (ArbolBinario<E> a){
    	int i = 0;
    	while (nivelLleno(a,i)){
    		i++;
    	}
    	return i-1;   	
    }

    
    public static <E> ArbolBinario<E> espejo(ArbolBinario<E> a)
    {
    	if (a.esVacio()) return new EnlazadoArbolBinario<>();
    	else return new EnlazadoArbolBinario<>(a.raiz(), espejo(a.hijoDer()), espejo(a.hijoIzq()));
    }
    
    public static  ArbolBinario<String> reconstruir(String preord, String inord)
    {
	 if (preord.length() == 0)
            return new EnlazadoArbolBinario<>();
        else
        {
            String r = preord.charAt(0)+"";
            int p = inord.indexOf(r);
            return new EnlazadoArbolBinario<>(r,  
            		reconstruir(preord.substring(1, p + 1), inord.substring(0, p)),
            		reconstruir(preord.substring(p + 1), inord.substring(p + 1)));
        }           
    }
    
    public static  ArbolBinario<Integer> reconstruir2(String preord, String inord)
    {
	 if (preord.length() == 0)
            return new EnlazadoArbolBinario<>();
        else
        {
            char r = preord.charAt(0);
            int p = inord.indexOf(r);
            return new EnlazadoArbolBinario<>(Character.getNumericValue(r),
                reconstruir2(preord.substring(1, p + 1), inord.substring(0, p)),
                reconstruir2(preord.substring(p + 1),
                            inord.substring(p + 1)));
        }           
    }
 
    public static <E> void preorden(ArbolBinario<E> a)
    {
        if (!a.esVacio())
        {
            System.out.print(a.raiz() + " ");
            preorden(a.hijoIzq());
            preorden(a.hijoDer());
        }
    }    
    
    public static <E> void inorden(ArbolBinario<E> a)
    {
        if (!a.esVacio())
        {
            inorden(a.hijoIzq());
            System.out.print(a.raiz() + " ");
            inorden(a.hijoDer());
        }
    }   
    
    public static <E> void postorden(ArbolBinario<E> a)
    {
        if (!a.esVacio())
        {
            postorden(a.hijoIzq());
            postorden(a.hijoDer());
            System.out.print(a.raiz() + " ");
        }
    }
    
    
}
