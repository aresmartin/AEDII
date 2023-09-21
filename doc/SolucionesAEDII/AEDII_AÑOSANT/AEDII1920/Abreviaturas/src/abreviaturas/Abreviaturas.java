
package abreviaturas;


public class Abreviaturas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String frase="Sr. José Pérez";
        System.out.println(ExtendAbreviaturas.extensionAbreviaturas(frase,"es"));
        String frase2= "This is Gd.";
        System.out.println(ExtendAbreviaturas.extensionAbreviaturas(frase2, "en"));
        String frase3= "Bonjour Dr Pepito, bonjour Dr José";
        System.out.println(ExtendAbreviaturas.extensionAbreviaturas(frase3, "fr"));
                }
    
}
