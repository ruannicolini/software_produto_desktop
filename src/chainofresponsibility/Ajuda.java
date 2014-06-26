/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chainofresponsibility;

import chainofresponsibility.visao.JanelaAjudaDialog;

/**
 *
 * @author Matheus
 */
public abstract class Ajuda {
    protected Ajuda sucessor;
    JanelaAjudaDialog janelaAjuda;
    String texto = null;

    public void setSucessor(Ajuda sucessor) {
        this.sucessor = sucessor;
    }

    public abstract void solicitaAjuda(String janela);

}
