package tadarbolbinario;

/*
 Clase con la implementación de los métodos de la interfase.
 */


/**
 *
 * @author svsemeria_ESEI
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> nodoRaiz; //Sólo tiene un atributo

    public EnlazadoArbolBinario() { //Produce un arbol vacio
        nodoRaiz = null;
    }

    public EnlazadoArbolBinario(E elemento, EnlazadoArbolBinario<E> izq, EnlazadoArbolBinario<E> der) throws NullPointerException { 

        if (izq.esVacio() || der.esVacio()) {
            throw new NullPointerException();
        }
        nodoRaiz = new NodoBinario<>(elemento, izq.nodoRaiz, der.nodoRaiz);

    }
    
    //Constructor privado, muy útil
    private EnlazadoArbolBinario(NodoBinario nodo) { //Método util para inicialización de arboles dentro de esta clase
        nodoRaiz = nodo;
    }

    public boolean esVacio() { //Perfecto
        return nodoRaiz == null;
    }

    public E raiz() throws ArbolVacioException { //Perfecto
        if (esVacio()) {
            throw new ArbolVacioException();
        } else {
            return nodoRaiz.getElem();
        }
    }

    //Método clave para otros métodos
    public EnlazadoArbolBinario<E> hijoIzq() throws ArbolVacioException { //Ya esta
        if (esVacio()) {
            throw new ArbolVacioException();
        } else {
            return new EnlazadoArbolBinario<>(nodoRaiz.getIzq());
        }
    }

    //Método clave para otros métodos
    public EnlazadoArbolBinario<E> hijoDer() throws ArbolVacioException { //Ya esta
        if (esVacio()) {
            throw new ArbolVacioException();
        } else {
            return new EnlazadoArbolBinario<>(nodoRaiz.getDer());
        }
    }

    public boolean esta(E elemento) { //Ya esta perfecto
        if(esVacio()){
            return false;
        }else if(nodoRaiz.getElem().equals(elemento)){
            return true;
        }else{
            return hijoIzq().esta(elemento) || hijoDer().esta(elemento);
        }
            
    }

    public void setRaiz(E elemRaiz) throws ArbolVacioException { //Perfecto
        if (esVacio()) {
            throw new ArbolVacioException();
        }
        nodoRaiz.setElem(elemRaiz);
    }

    public void setHijoIzq(EnlazadoArbolBinario<E> hi) throws ArbolVacioException, NullPointerException { //Está perfecto
        if (hi.esVacio()) {
            throw new NullPointerException();
        } else if (esVacio()) {
            throw new ArbolVacioException();
        } else {
            nodoRaiz.setIzq(((EnlazadoArbolBinario<E>) hi).nodoRaiz); //Especificamos el tipo de lo que le vamos a pasar

        }
    }

    public void setHijoDer(EnlazadoArbolBinario<E> hd) throws ArbolVacioException, NullPointerException { //Está perfecto
        if (hd.esVacio()) {
            throw new NullPointerException();
        } else if (esVacio()) {
            throw new ArbolVacioException();
        }
        nodoRaiz.setDer(((EnlazadoArbolBinario<E>) hd).nodoRaiz); //Especificamos el tipo de lo que le vamos a pasar
    }

    public void suprimir() { //Puede estar bien
        nodoRaiz = null;
    }

}
