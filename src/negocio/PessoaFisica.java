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
public class PessoaFisica extends Cliente{
    
    String cpf;

    public PessoaFisica(String nome, String endereco, String numero, String bairro, String complemento, String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente, String cpf) {
        super(nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    
}
