/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import negocio.*;

/**
 *
 * @author Ruan
 */
public class Controlador {
    
    CidadeDAO cidDAO;
    ClienteDAO cliDAO;
    Cliente cli;

    public Controlador() throws Exception, SQLException {
        cidDAO = new CidadeDAO();
        cliDAO = new ClienteDAO();
        
    }
    
  
    public int inserirCliente(String nome, String endereco, String numero, String bairro, String complemento, 
            String tel, String cel, Cidade cidade, String cep, char tipo_cliente, String cpf, String cnpj, String ie)
            throws Exception, SQLException {
      
        if(tipo_cliente == 'J'){
            cli = new PessoaJuridica(nome, endereco, numero, bairro, complemento, tel, cel, cidade, cep, tipo_cliente, cnpj, ie);
        }else{
            if(tipo_cliente == 'F'){
                cli = new PessoaFisica(nome, endereco, numero, bairro, complemento, tel, cel, cidade, cep, tipo_cliente, cpf);
                
             }
        }
        
        cliDAO.inserir(cli);
        
        return cli.getIdCliente();
        
    }
    
    public void inserirCidade(String nome, String uf) throws Exception, SQLException{
        
        Cidade cid = new Cidade(nome,uf);
        cidDAO.inserir(cid);
    }
    
    public void carregarComboCidade(JComboBox combo) throws Exception, SQLException  {
        
        List lista = cliDAO.listarCidades();
        
        combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
    }

    
    public void pesquisarCidade( JTable tabela, int tipo, String pesq ) throws Exception, SQLException {
        
        List lista = null;
        
        switch (tipo) {
            case 0: // Pesquisar NOME
                lista = cidDAO.pesquisar(pesq);
                break;
            case 1: // Pesquisar ID
                lista = cidDAO.pesquisarUf(pesq);
                break;
            
        }
        
        
        // PERCORRE A LISTA E COLOCA NA TABELA
        
        Cidade cid;

        // Apagar as linhas da tabela
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        
        Iterator<Cidade> ite = lista.iterator();
        while ( ite.hasNext() ) {
            cid = ite.next();
            
            ((DefaultTableModel) tabela.getModel()).addRow( cid.toArray() );                        

        } 
                               
    }
    
    public void excluirCidade(Cidade cid) throws SQLException, Exception{
        cidDAO.excluir(cid);
    }
    
    public void alterarCidade(int id, String nome, String uf) throws Exception, SQLException {
     
        Cidade cid = new Cidade( id, nome, uf );
        cidDAO.alterar(cid);
    }
    
}
