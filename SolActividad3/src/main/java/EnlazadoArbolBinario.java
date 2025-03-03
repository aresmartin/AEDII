public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{
    private NodoBinario<E> r;

    public EnlazadoArbolBinario(){
        r = null;
    }

    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi, ArbolBinario<E> hd){
        if(elemRaiz == null || hi == null || hd == null){
            throw new NullPointerException();
        }
         r = new NodoBinario<>(elemRaiz, ((EnlazadoArbolBinario)hi).r,((EnlazadoArbolBinario)hd).r); // hi y hd es un objeto de tipo enlazado arbol binario
    }

    public EnlazadoArbolBinario(NodoBinario<E> raiz){
        r = raiz;
    }

    @Override
    public boolean esVacio() {
        return r == null;
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion("Raiz: arbol vacio");
        }
        return r.getElemento();
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion("hijoIzq: arbol vacio"); //poner nombre método que lanza expeción
        }

        return new EnlazadoArbolBinario(r.getIzq()); // Tengo que devolver un arbol binario
    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if(esVacio()){
            throw new ArbolVacioExcepcion("hijoDer: arbol vacio"); //poner nombre método que lanza expeción
        }

        return new EnlazadoArbolBinario(r.getDer()); // Tengo que devolver un arbol binario
    }

    @Override
    public boolean esta(E elemento) {
        if(esVacio()){
            return false;
        }
        if(r.getElemento().equals(elemento)){
            return true;
        }
        return hijoIzq().esta(elemento) || hijoDer().esta(elemento);
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion, NullPointerException {
        if(elemRaiz == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion("setRaiz(): arbol vacio");
        }

        r.setElemento(elemRaiz);
    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {
        if(hi == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion("setIzq(): arbol vacio");
        }

        r.setIzq(((EnlazadoArbolBinario)hi).r); // hi es arbol binario pero quiero guardar nodo binario

    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {
        if(hd == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioExcepcion("setDer(): arbol vacio");
        }

        r.setDer(((EnlazadoArbolBinario)hd).r); // hi es árbol binario pero quiero guardar nodo binario
    }

    @Override
    public void suprimir() {
        r = null;

    }
}