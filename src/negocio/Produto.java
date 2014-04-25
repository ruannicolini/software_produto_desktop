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
public class Produto {
    int id;
    String descricao;
    Linha linha;
    Tipo tipo;
    float preco;
    boolean status;

    public Produto(String descricao, Linha linha, Tipo tipo, float preco, boolean status) {
        this.descricao = descricao;
        this.linha = linha;
        this.tipo = tipo;
        this.preco = preco;
        this.status = status;
    }

    public Produto(int id, String descricao, Linha linha, Tipo tipo, float preco, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.linha = linha;
        this.tipo = tipo;
        this.preco = preco;
        this.status = status;
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

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Object[] toArray() {
        return new Object[]{this,this.descricao, this.linha.getNome(), this.tipo.getDescricao(), this.getPreco(), this.getStatus()};
    }
}
