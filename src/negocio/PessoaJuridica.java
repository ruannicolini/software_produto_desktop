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
public class PessoaJuridica extends Cliente{
    
    String cnpj;
    String ie;

    public PessoaJuridica(String nome, String endereco, String numero, String bairro, String complemento, String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente, String cnoj, String ie) {
        super(nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente);
        this.cnpj = cnpj;
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cgc) {
        this.cnpj = cgc;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }
    
    
    
}
