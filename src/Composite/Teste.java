/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;
/**
 *
 * @author Ruan
 */
public class Teste {

    public static void main(String[] args) {
        ComponenteProduto prod1 = new LeafProduto(null, null, "prod1", 1, true);        
        ComponenteProduto prod2 = new LeafProduto(null, null, "prod2", 2, true);
        
        ComponenteProduto kit1 = new CompositeProduto(null, null, "kit1", 10, true);
        kit1.add(prod1);
        kit1.add(prod2);
        
        ComponenteProduto prod3 = new LeafProduto(null, null, "prod3", 3, true);
        
        ComponenteProduto kitMaximo = new CompositeProduto(null, null, "kitMaximo", 100, true);
        kitMaximo.add(prod3);
        kitMaximo.add(kit1);
        
        // Mostrar Implementações
        System.out.println("\n\n\n KIT MÁXIMO =======================================");
        kitMaximo.print();
        System.out.println("\n\n\n KIT 1 =======================================");
        kit1.print();
        System.out.println("\n\n\n PROD3 =======================================");
        prod3.print();
        System.out.println("\n\n\n PROD2 =======================================");
        prod2.print();
        System.out.println("\n\n\n PROD1 =======================================");
        prod1.print();
        
       
        
    }

}
