/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import negocio.Linha;
import negocio.Produto;
import negocio.Tipoproduto;

/**
 *
 * @author Ruan
 */
public class CompositeProduto extends Produto implements ComponenteProduto {

    public CompositeProduto(Tipoproduto tipoproduto, Linha linha, String descricao, float preco, boolean statusVenda) {
        super(tipoproduto, linha, descricao, preco, statusVenda);
    }

    List<ComponenteProduto> produtosFilhos = new ArrayList<ComponenteProduto>(); // employees

    @Override
    public void add(ComponenteProduto cp) {
        produtosFilhos.add(cp);
    }

    @Override
    public void remove(ComponenteProduto cp) {
        produtosFilhos.remove(cp);
    }

    @Override
    public void print() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Name =" + getDescricao());
        System.out.println("Tipo =" + getTipoproduto());
        System.out.println("Linha =" + getLinha());
        System.out.println("Preco =" + getPreco());
        System.out.println("StatusVenda =" + isStatusVenda());
        System.out.println("-------------");

        Iterator<ComponenteProduto> employeeIterator = produtosFilhos.iterator();
        while (employeeIterator.hasNext()) {
            ComponenteProduto employee = employeeIterator.next();
            employee.print();
        }
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public ComponenteProduto getFilho(int i) {
        return produtosFilhos.get(i);
    }

}
