package com.mycompany.repetiractividad4;

public class HeapVacioExcepcion extends RuntimeException{
    HeapVacioExcepcion(){
        super();
    }

    HeapVacioExcepcion(String msg){
        super(msg);
    }
}
