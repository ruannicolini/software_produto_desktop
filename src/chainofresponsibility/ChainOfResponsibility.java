/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chainofresponsibility;

/**
 *
 * @author Matheus
 */
public class ChainOfResponsibility {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ajuda ajudaCidadePesquisa = new AjudaCidadePesq();
        Ajuda ajudaCliente = new AjudaCliente();
        Ajuda ajudaCidade = new AjudaCidade();
        Ajuda ajudaClientePesquisa = new AjudaClientePesq();

        ajudaCidadePesquisa.setSucessor(ajudaCliente);
        ajudaCliente.setSucessor(ajudaCidade);
        ajudaCidade.setSucessor(ajudaClientePesquisa);
 
        ajudaClientePesquisa.solicitaAjuda(RequisicaoAjuda.AJUDA_CLIENTE_PESQ);
        ajudaCidadePesquisa.solicitaAjuda(RequisicaoAjuda.AJUDA_CIDADE_PESQ);
        ajudaCidade.solicitaAjuda(RequisicaoAjuda.AJUDA_CIDADE);
        ajudaCliente.solicitaAjuda(RequisicaoAjuda.AJUDA_CLIENTE);
    }
    
}

