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
public class AjudaCidadePesq extends Ajuda {

  //  @Override
    public void atende(final RequisicaoAjuda requisicao) {
        if (requisicao.equals(RequisicaoAjuda.DUVIDA_SOBRE_A_REVOLUCAO_FRANCESA)) {
            System.out.println("O professor de história respondeu a dúvida sobre a revolução francesa!");
        } else {
            if (sucessor != null) {
                System.out.println("O professor de história não pode atender uma " + requisicao.toString() + ", pediu para outra pessoa responder");
                sucessor.solicitaAjuda(requisicao);
            }
        }
    }

    @Override
    public void solicitaAjuda(RequisicaoAjuda requisicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
