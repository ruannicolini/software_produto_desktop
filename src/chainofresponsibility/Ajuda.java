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
public abstract class Ajuda {

    protected Ajuda sucessor;

    public void setSucessor(final Ajuda sucessor) {
        this.sucessor = sucessor;
    }

    public abstract void solicitaAjuda(final RequisicaoAjuda requisicao);

}
