public interface ArbolBinario<E>{
    public boolean esVacio();
    public E raiz() throws ArbolVacioException;
    public ArbolBinario<E> hijoIzq()throws ArbolVacioException;
    public ArbolBinario<E> hijoDer()throws ArbolVacioException;
    public boolean esta(E elemento);
    public void setRaiz(E elemRaiz) throws ArbolVacioException, NullPointerException;
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioException, NullPointerException;
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioException, NullPointerException;
    public void suprimir();
}
