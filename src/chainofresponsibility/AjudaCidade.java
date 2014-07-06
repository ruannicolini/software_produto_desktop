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
public class AjudaCidade extends Ajuda {
//    JanelaAjudaDialog janelaAjuda;
//    String texto;
    
    @Override
    public void solicitaAjuda(String janela) {
        if (janela.equals("JANELA_CIDADE")) {
            texto = "Oi \n\n\n\n\n\n Oi CIDADE!! ;)";
            janelaAjuda = new JanelaAjudaDialog(null, true, texto);
            
            janelaAjuda.setLocationRelativeTo(null); // Faz com que a janela apareça no meio da tela
            janelaAjuda.setVisible(true);
        } else {
            if (sucessor != null) {
                //System.out.println("Esta janela nao atende esse HELP  " + requisicao.toString() + ", pediu para outra janela atender");
                sucessor.solicitaAjuda(janela);
            }
        }
    }
}
