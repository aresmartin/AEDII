/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AB;

/**
 * @author adotsuarez
 * (C) Agustin Suarez Martinez, 2020
 * Public key: pgp.thisisadot.me
 */

public class EnlazadoPadreArbolBinario<E> implements ArbolBinario<E> {
    private NodoBinario<E> r;

    public EnlazadoPadreArbolBinario() {
        this.r = null;
    }

    public EnlazadoPadreArbolBinario(E elemRaiz, ArbolBinario<E> hi, ArbolBinario<E> hd) {
        if ((EnlazadoPadreArbolBinario)hi == null || (EnlazadoPadreArbolBinario)hd == null) {
            // Lo que hacemos es comprobar que lo que se nos pase esté instanciado y exista
            // (pero sin comprobar su valor aún)
            //
            // No es necesario el casting de interfaz a EnlazadoArbolBinario,
            // por este motivo es posible que se marque una redundancia.
            // Pero recuerda ¡una interfaz nunca puede ser null!
            // Puedes cargarte lo que es redundante, ¡pero ten en cuenta esto!

            throw new NullPointerException();
        }

        this.r = new NodoBinario<>(
                elemRaiz,
                ((EnlazadoPadreArbolBinario<E>)hi).r,
                ((EnlazadoPadreArbolBinario<E>)hd).r,
                null);

        if (((EnlazadoPadreArbolBinario<E>)hi).r != null) {
            ((EnlazadoPadreArbolBinario<E>)hi).r.setPadre(this.r);
           // ((EnlazadoPadreArbolBinario<E>)hi).r.setHermano(((EnlazadoPadreArbolBinario<E>)hd).r);
        }
        if (((EnlazadoPadreArbolBinario<E>)hd).r != null) {
            ((EnlazadoPadreArbolBinario<E>)hd).r.setPadre(this.r);
            //((EnlazadoPadreArbolBinario<E>)hd).r.setHermano(((EnlazadoPadreArbolBinario<E>)hi).r);
        }
        // Opcional: Padre apunta a sí mismo:
        //  this.r.setPadre(this.r);
        // No lo hacemos porque no debemos pensar que un nodo tiene de padre al mismo nodo.
        // Principalmente porque nos cambiaría la defición del testHermanoRoot [AED2-P3A3Ex-Hermano]
        // Puedes leer esta definición de "hermano no existente" en EnlazadoArbolBinarioTests.java:287
        //
        // Pendiente: Comprobar si se puede hacer directamente desde
        //  this.r = new NodoBinario<>(…, (h:) this.r)
    }

    private EnlazadoPadreArbolBinario(NodoBinario<E> raiz) {
        this.r = raiz;
    }

    public boolean esVacio() {
        return this.r == null;
    }

    public E raiz() throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("raiz: Árbol vacío");
        } else {
            return this.r.getElemento();
        }
    }

    // Modificación P3 ————
    public boolean esta(E elemento) {
        if (esVacio()) return false;
        if (this.r.getElemento().equals(elemento)) return true;
        return hijoIzq().esta(elemento) | hijoDer().esta(elemento);
    }
    // ————————————————————

    public ArbolBinario<E> hijoIzq() throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("hijoIzq: Árbol vacío");
        } else {
            return new EnlazadoPadreArbolBinario<>(this.r.getIzq());
        }
    }

    public ArbolBinario<E> hijoDer() throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("hijoDer: Árbol vacío");
        } else {
            return new EnlazadoPadreArbolBinario<>(this.r.getDer());
        }
    }

    // Padre [AED2-P3A3Ex-2]
    public ArbolBinario<E> padre() throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("padre: Árbol vacío");
        } else {
            return new EnlazadoPadreArbolBinario<>(this.r.getPadre());
        }
    }

   /* // Hermano [AED2-P3A3Ex-Hermano]
    public ArbolBinario<E> hermano() throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("hermano: Árbol vacío");
        } else {
            return new EnlazadoPadreArbolBinario<>(this.r.getHermano());
        }
    }*/

    public void setRaiz(E elemRaiz) throws ArbolVacioException {
        if (this.esVacio()) {
            throw new ArbolVacioException("raiz: Árbol vacío");
        } else {
            this.r.setElemento(elemRaiz);
        }
    }

    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioException, NullPointerException {
        if (hi == null) {
            throw new NullPointerException();
        } else if (this.esVacio()) {
            throw new ArbolVacioException("setHijoIzq: Árbol vacío");
        } else {
            this.r.setIzq(((EnlazadoPadreArbolBinario<E>)hi).r);
            ((EnlazadoPadreArbolBinario<E>)hi).r.setPadre(this.r);
           /* if (this.r.getDer() != null) {
                ((EnlazadoPadreArbolBinario<E>) hi).r.setHermano(this.r.getDer());
            }*/
        }
    }

    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioException, NullPointerException {
        if (hd == null) {
            throw new NullPointerException();
        } else if (this.esVacio()) {
            throw new ArbolVacioException("setHijoDer: Árbol vacío");
        } else {
            this.r.setDer(((EnlazadoPadreArbolBinario<E>)hd).r);
            ((EnlazadoPadreArbolBinario<E>)hd).r.setPadre(this.r);
           /* if (this.r.getDer() != null) {
                ((EnlazadoPadreArbolBinario<E>) hd).r.setHermano(this.r.getIzq());
            }*/
        }
    }

    public void suprimir() {
        this.r = null;
    }
}