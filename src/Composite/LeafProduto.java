/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Composite;
import negocio.Linha;
import negocio.*;

/**
 *
 * @author Ruan
 */
public class LeafProduto extends Produto implements ComponenteProduto{
    
    public LeafProduto(Tipoproduto tipoproduto, Linha linha, String descricao, float preco, boolean statusVenda) {
        super(tipoproduto, linha, descricao, preco, statusVenda);
    }

    @Override
    public void add(ComponenteProduto cp) {
        //Essa classe é um nó filho, logo, esse método não é aplicado a ela.
    }

    @Override
    public void remove(ComponenteProduto cp) {
        //Essa classe é um nó filho, logo, esse método não é aplicado a ela.    
    }

    @Override
    public void print() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Name =" + getDescricao());
        System.out.println("Tipo =" + getTipoproduto());
        System.out.println("Linha =" + getLinha());
        System.out.println("Preco =" + getPreco());
        System.out.println("StatusVenda =" + isStatusVenda());
        System.out.println("-------------------------------------------------------------");   
    }

    @Override
    public ComponenteProduto getFilho(int i) {
        //Essa classe é um nó filho, logo, esse método não é aplicado a ela.
        return null;
    }
    
}
