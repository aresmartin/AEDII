package tema4_practica1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tema4_Practica1 {

    //EJERCICIO 1
    public static Map<Integer, Integer> darCambio(int importeDevolver, Map<Integer, Integer> cantidades) {
        Map<Integer, Integer> toret = new HashMap<>();
        boolean hayCambio = true;
        while (importeDevolver > 0 && hayCambio) {
            int billete = seleccionar(importeDevolver, cantidades);
            if (billete == 0) {
                hayCambio = false;
            } else {
                //determinar cuantos billetes
                int numBilleNecesito = importeDevolver / billete;
                int hayCaja = cantidades.get(billete);
                if (hayCaja < numBilleNecesito) {
                    numBilleNecesito = hayCaja;
                }
                //insertar solucion
                toret.put(billete, numBilleNecesito);
                //actualizar importe a devolver y mapa de cantidades
                importeDevolver = billete * numBilleNecesito;
                cantidades.put(billete, hayCaja - numBilleNecesito);

            }
        }

        if (!hayCambio) {
            return new HashMap<>();
        } else {
            return toret;
        }
    }

    private static Integer seleccionar(int importe, Map<Integer, Integer> cantidades) {

        Iterator<Integer> it = cantidades.keySet().iterator();
        int mejor = 0;
        while (it.hasNext()) {
            int actual = it.next();
            if (cantidades.get(actual) > 0 && actual < importe && actual > mejor) {
                mejor = actual;
            }
        }
        return mejor;
    }

    private static Integer seleccionar2(int importe, Map<Integer, Integer> cantidades) {

        int mejor = 0;
        for (Integer actual : cantidades.keySet()) {
            if (cantidades.get(actual) > 0 && actual < importe && actual > mejor) {
                mejor = actual;
            }
        }
        return mejor;
    }

    //EJERCICIO 2
    public static List<String> llenarCDVoraz(int capacidadMaxima, Map<String, Integer> espacioProgramas) {
        List<String> toret = new ArrayList<>();
        boolean hayProgramas = true;
        while (capacidadMaxima > 0 && hayProgramas) {
            String prog = mejor(capacidadMaxima, espacioProgramas);
            if (prog.equals("")) {
                hayProgramas = false;
            } else {
                toret.add(prog);
                capacidadMaxima -= espacioProgramas.get(prog);
                espacioProgramas.remove(prog);
            }

        }
        return toret;
    }

    private static String mejor(int capacidad, Map<String, Integer> programas) {
        String programa="";
        int tamaño=0;
        Iterator<String> it = programas.keySet().iterator();
        while(it.hasNext()){
            String actual= it.next();
            int peso = programas.get(actual);
            if(peso < capacidad && tamaño < peso){
                programa = actual;
                tamaño = programas.get(actual);
            }
        }
        return programa;
    }
    private static String mejor2(int capacidad, Map<String, Integer> programas) {
        String nombrePrograma = " ";
        int mejorPrograma=0;
        for(String nombre : programas.keySet()){
            if(mejorPrograma < programas.get(nombre) && programas.get(nombre)<=capacidad){
                mejorPrograma = programas.get(nombre);
                nombrePrograma = nombre;
            }
        }
        
        return nombrePrograma;
    }
}
