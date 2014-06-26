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
        //ChainOfResponsibility.chamarAjuda();
    }
    public static void chamarAjuda(String janela){
        Ajuda ajudaCidade = new AjudaCidade();
        Ajuda ajudaCidadePesq = new AjudaCidadePesq();
        Ajuda ajudaCliente = new AjudaCliente();
        Ajuda ajudaClientePesq = new AjudaClientePesq();
        Ajuda ajudaLinha = new AjudaLinha();
        Ajuda ajudaLinhaPesq = new AjudaLinhaPesq();
        Ajuda ajudaPedido = new AjudaPedido();
        Ajuda ajudaPedidoPesq = new AjudaPedidoPesq();
        Ajuda ajudaPedidoPos = new AjudaPedidoPos();
        Ajuda ajudaPrincipal = new AjudaPrincipal();
        Ajuda ajudaProduto = new AjudaProduto();
        Ajuda ajudaProdutoPesq = new AjudaProdutoPesq();

        ajudaCidade.setSucessor(ajudaCidadePesq);
        ajudaCidadePesq.setSucessor(ajudaCliente);
        ajudaCliente.setSucessor(ajudaClientePesq);
        ajudaClientePesq.setSucessor(ajudaLinha);
        ajudaLinha.setSucessor(ajudaLinhaPesq);
        ajudaLinhaPesq.setSucessor(ajudaPedido);
        ajudaPedido.setSucessor(ajudaPedidoPesq);
        ajudaPedidoPesq.setSucessor(ajudaPedidoPos);
        ajudaPedidoPos.setSucessor(ajudaPrincipal);
        ajudaPrincipal.setSucessor(ajudaProduto);
        ajudaProduto.setSucessor(ajudaProdutoPesq);
        
        ajudaCidade.solicitaAjuda(janela);
    }
    
}

