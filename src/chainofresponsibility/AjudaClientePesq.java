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
public class AjudaClientePesq extends Ajuda {

    @Override
    public void solicitaAjuda(RequisicaoAjuda requisicao) {
        if (requisicao.equals(RequisicaoAjuda.AJUDA_CLIENTE_PESQ)) {
            System.out.println("HELP! DA JANELA (CLIENTE PESQUISA)");
        } else {
            if (sucessor != null) {
                System.out.println("Esta janela nao atende esse HELP  " + requisicao.toString() + ", pediu para outra janela atender");
                sucessor.solicitaAjuda(requisicao);
            }
        }
    }
}
