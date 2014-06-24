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
        Ajuda professorDeHistoria = new AjudaCidadePesq();
        Ajuda professorDeLiteratura = new AjudaCliente();
        Ajuda inspetor = new AjudaCidade();
        Ajuda diretor = new AjudaClientePesq();

        professorDeHistoria.setSucessor(professorDeLiteratura);
        professorDeLiteratura.setSucessor(inspetor);
        inspetor.setSucessor(diretor);
 
        professorDeHistoria.solicitaAjuda(RequisicaoAjuda.AQUISICAO_DE_CADEIRA);
        professorDeHistoria.solicitaAjuda(RequisicaoAjuda.DUVIDA_SOBRE_A_REVOLUCAO_FRANCESA);
        professorDeHistoria.solicitaAjuda(RequisicaoAjuda.INFORMACAO_DE_NUMERO_DE_SALA);
        professorDeHistoria.solicitaAjuda(RequisicaoAjuda.DUVIDA_SOBRE_VANGUARDAS_LITERARIAS);
    }
    
}

