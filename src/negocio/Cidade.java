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
public class Cidade {
    int idCidade;    
    String nome;
    String uf;

    public Cidade(String nome, String uf) {
        this.nome = nome;
        this.uf = uf;
    }

    public Cidade(int idCidade, String nome, String uf) {
        this.idCidade = idCidade;
        this.nome = nome;
        this.uf = uf;
    }
    
    

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    @Override
    public String toString() {
        return nome;
    }    
    
    public Object[] toArray() {
        return new Object[]{this,this.getUf()};
    } 
    
}
