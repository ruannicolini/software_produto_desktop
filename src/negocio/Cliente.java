/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import util.*;

/**
 *
 * @author Ruan
 */
public class Cliente {
    int idCliente;
    String nome;
    String endereco;
    String numero;
    String bairro;
    String complemento;
    String telFixo;
    String telCel;
    Cidade cidade;
    String cep;
    char tipo_cliente;

    public Cliente(String nome, String endereco, String numero, String bairro, String complemento, 
            String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente) {
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.cidade = cidade;
        this.cep = cep;
        this.tipo_cliente = tipo_cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) throws ClienteException {
        if ( idCliente >= 0 ) {
            this.idCliente = id;
        } else {
            throw new ClienteException("ID do cliente inválido."); 
        } 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String geteEdereco() {
        return endereco;
    }

    public void setEndereco(String Endereco) {
        this.endereco = Endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getTelCel() {
        return telCel;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public char getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(char tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    
    
    
    
}
