public class EnlazadoArbolBinario<E> implements ArbolBinario<E>{

    private NodoBinario<E> nodoRaiz;

    public EnlazadoArbolBinario(){nodoRaiz = null;}
    
    public EnlazadoArbolBinario(NodoBinario<E> raiz){
        nodoRaiz = raiz;
    }
    
    public EnlazadoArbolBinario(E elemRaiz, ArbolBinario<E> hi, ArbolBinario<E> hd){
        if(elemRaiz == null || hi == null || hd == null){
            throw new NullPointerException();
        }
        nodoRaiz = new NodoBinario<>(elemRaiz, ((EnlazadoArbolBinario)hi).nodoRaiz, ((EnlazadoArbolBinario)hd).nodoRaiz);
    }


    @Override
    public boolean esVacio() {
        return nodoRaiz == null;
    }

    @Override
    public E raiz() throws ArbolVacioException {
        if(esVacio()){
            throw new ArbolVacioException("Raiz: arbol vacio");
        }
        return nodoRaiz.getElemento();    
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioException {
        if(esVacio()){
            throw new ArbolVacioException("hijoIzq(): arbol vacío");
        }
        
        return new EnlazadoArbolBinario(nodoRaiz.getIzq());
    }

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioException {
        if(esVacio()){
            throw new ArbolVacioException("hijoDer(): arbol vacío");
        }
        
        return new EnlazadoArbolBinario(nodoRaiz.getDer());
    }

    @Override
    public boolean esta(E elemento) {
        if(esVacio()){
            return false;
        }
        
        if(nodoRaiz.getElemento().equals(elemento)){
            return true;
        }else{
            return hijoIzq().esta(elemento) || hijoDer().esta(elemento);
        }
    }

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioException, NullPointerException {
        if(elemRaiz == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioException("setRaiz(): arbol vacio");
        }
        
        nodoRaiz.setElemento(elemRaiz);

    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioException, NullPointerException {
        
        if(hi == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioException("setHijoIzq(): arbol vacio");
        }
        
        nodoRaiz.setIzq(((EnlazadoArbolBinario)hi).nodoRaiz);

    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioException, NullPointerException {
        if(hd == null){
            throw new NullPointerException();
        }
        if(esVacio()){
            throw new ArbolVacioException("setHijoDer(): arbol vacio");
        }
        
        nodoRaiz.setDer(((EnlazadoArbolBinario)hd).nodoRaiz);
    }

    @Override
    public void suprimir() {
        nodoRaiz = null;
    }
}
