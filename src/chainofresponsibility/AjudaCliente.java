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
public class AjudaCliente extends Ajuda {

    
   // @Override
    public void atende(final RequisicaoAjuda requisicao) {
        if (requisicao.equals(RequisicaoAjuda.DUVIDA_SOBRE_VANGUARDAS_LITERARIAS)) {
            System.out.println("O professor de Literatura respondeu a dúvida!");
        } else {
            if (sucessor != null) {
                System.out.println("O professor de literatura não pode atender uma " + requisicao.toString() + ", pediu para outra pessoa responder");
                sucessor.solicitaAjuda(requisicao);
            }
        }
    }

    @Override
    public void solicitaAjuda(RequisicaoAjuda requisicao) {
        
    }
}
