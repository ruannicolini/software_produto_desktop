/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

/**
 *
 * @author Ruan
 */
public class Tipo {
    int id;
    String descricao;
    String unVenda;

    public Tipo(String descricao, String unVenda) {
        this.descricao = descricao;
        this.unVenda = unVenda;
    }

    
    public Tipo(int id, String descricao, String unVenda) {
        this.id = id;
        this.descricao = descricao;
        this.unVenda = unVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnVenda() {
        return unVenda;
    }

    public void setUnVenda(String unVenda) {
        this.unVenda = unVenda;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
    public Object[] toArray() {
        return new Object[]{this, getDescricao()};
    }
    
    
}
