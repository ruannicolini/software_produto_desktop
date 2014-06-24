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

   // @Override
    public void atende(final RequisicaoAjuda requisicao) {
        if (requisicao.equals(RequisicaoAjuda.AQUISICAO_DE_CADEIRA)) {
            System.out.println("O diretor comprou uma cadera nova!");
        } else {
            if (sucessor != null) {
                System.out.println("O diretor de história não pode atender uma " + requisicao.toString() + ", procurou outra pessoa para atender");
                sucessor.solicitaAjuda(requisicao);
            }
        }
    }

    @Override
    public void solicitaAjuda(RequisicaoAjuda requisicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
