/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.List;

/**
 *
 * @author Ruan
 */
public class Pedido {
   String nomeCliente;
   String descricao;
   List listaProdutos;
   float valorTotal;

    public Pedido(String nomeCliente, String descricao, List listaProdutos, float valorTotal) {
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
        this.listaProdutos = listaProdutos;
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
   
    
}
