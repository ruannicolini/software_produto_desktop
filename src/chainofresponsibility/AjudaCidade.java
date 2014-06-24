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
public class AjudaCidade extends Ajuda {

 //   @Override
    public void atende(final RequisicaoAjuda requisicao) {
        if (requisicao.equals(RequisicaoAjuda.INFORMACAO_DE_NUMERO_DE_SALA)) {
            System.out.println("O inspetor informou que a sala de história fica no 2º andar!");
        } else {
            if (sucessor != null) {
                System.out.println("O inspetor não pode atender uma " + requisicao.toString() + ", pediu para outra pessoa atender");
                sucessor.solicitaAjuda(requisicao);
            }
        }
    }

    @Override
    public void solicitaAjuda(RequisicaoAjuda requisicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
