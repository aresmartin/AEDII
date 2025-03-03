// Actividad 5 Ejercicio 2

public static <E> boolean esIgualEstructura(ArbolGeneral<E> a, ArbolGeneral<E> b) {
    // Caso base: ambos árboles son nulos, tienen la misma estructura
    if (a.esVacio() && b.esVacio()) {
        return true;
    }

    // Si uno es nulo y el otro no, no tienen la misma estructura
    if (!a.esVacio() && !b.esVacio()) {
        ArbolGeneral<E> ha = a.hijoMasIzq();
		ArbolGeneral<E> hb = b.hijoMasIzq();
		
		while(!ha.esVacio() && !hb.esVacio() && esIgualEstructura(ha, hb)){
			ha = ha.hermanoDer();
			hb = hb.hermanoDer();
			
		}
		return ha.esVacio() && hb.esVacio();
		
    }

    return false;
}

// Ejercicio 3 (un arbol vacio es un arbol 2-3)
public static <E> boolean esArbolDosTres (ArbolGeneral<E> a){
	
	if(a.esVacio()){
		return true;
	}
	
	int numHijos = 0;
	ArbolGeneral<E> hijo = a.hijoMasIzq();
	
	while(!hijo.esVacio()){
		
		numHijos++;
		hijo.hermanoDer();
	}

		if(numHijos != 0 && numHijos != 2 && numHijos != 3){
				return false;
			
		}
		
		hijo = a.hijoMasIzq(); // se pasa al siguiente hijo (osea al de más abajo)
		while(!hijo.esVacio()){
			if(!hijo.esArbolDosTres()){
				return false;
				
			}
			hijo = hermanoDer();
			
		}
	
	return true;
	
	
}
// Ejercicio 6
public static<E> int getGrado(ArbolGeneral<E>a ){
	
	if(a.esVacio()){
		return 0;
		
	}
	
	int Max
	
	
	return maxGrado;
	
}

private static <E> int contarHijos(ArbolGeneral<E> a){
	if(a.esVacio()){
		return 0;
	}
	
	int cont = 0;
	ArbolGeneral<E> hijo = a.hijoMasIzq();
	while(!hijo.esVacio()){
		cont += 1;
		hijo = hijo.hermanoDer();
		
	}
	
	return cont;
	
	
}