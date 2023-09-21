/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tad_map;

/**
 *
 * @author degap
 */
public class TAD_MAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Map<Integer, String> mapa = new HashMap<>();
        mapa.insertar(988223344, "Luis");
        mapa.insertar(988223345, "Pedro");
        mapa.insertar(988223346, "Laura");
        mapa.insertar(988223342, "Antonio");
        mapa.insertar(988223354, "Andres");
        mapa.insertar(988223363, "Manuel");
        mapa.insertar(688223386, "Samuel");
        mapa.insertar(988223340, "Marcos");
        mapa.insertar(988223349, "Oscar");
        mapa.insertar(988223341, "Gerardo");
        mapa.insertar(788223343, "Andrea");
        mapa.insertar(639223344, "Ricardo");
        mapa.insertar(988251340, "Ramon");
        mapa.insertar(678223347, "Dolores");
        mapa.insertar(688323345, "Mario");
        mapa.insertar(981226332, "Laura");
        mapa.insertar(986223389, "Lorena");
        mapa.insertar(673223302, "Juan Carlos");
        mapa.insertar(662223326, "Santiago");
        System.out.println(mapa.recuperar(986223389));
        System.out.println(mapa.estaClave(988251340));
        System.out.println(mapa.estaClave(988001100));
        System.out.println(mapa.tamanho());
        System.out.println(mapa.estaValor("Andrea"));
        System.out.println(mapa.estaValor("Lolo"));
        //System.out.println(mapa.iteradorClaves());
       
        
        
        
    }
    
}
