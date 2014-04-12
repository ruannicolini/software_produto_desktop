/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import util.ClienteException;

/**
 *
 * @author Ruan
 */
public class PessoaFisica extends Cliente{

    String cpf;

    public PessoaFisica(String nome, String endereco, String numero, String bairro, String complemento, String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente,String email, String cpf) {
        super(nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente, email);
        this.cpf = cpf;
    }
    public PessoaFisica(int idCliente, String nome, String endereco, String numero, String bairro, String complemento, String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente,String email, String cpf) throws ClienteException {
        super(idCliente, nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente, email);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
