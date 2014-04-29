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
import util.ClienteException;

/**
 *
 * @author Ruan
 */
public class Controlador {
    
    CidadeDAO cidDAO;
    ClienteDAO cliDAO;
    LinhaDAO linhaDAO;
    ProdutoDAO produtoDAO;
    Cliente cli;
    Produto prod;

    public Controlador() throws Exception, SQLException {
        cidDAO = new CidadeDAO();
        cliDAO = new ClienteDAO();
        linhaDAO = new LinhaDAO();
        produtoDAO = new ProdutoDAO();
        
    }
    
  
    public int inserirCliente(String nome, String endereco, String numero, String bairro, String complemento, 
            String tel, String cel, Cidade cidade, String cep, char tipo_cliente,String email, String cpf, String cnpj, String ie)
            throws Exception, SQLException {
      
        if(tipo_cliente == 'J'){
            cli = new PessoaJuridica(nome, endereco, numero, bairro, complemento, tel, cel, cidade, cep, tipo_cliente,email, cnpj, ie);
        }else{
            if(tipo_cliente == 'F'){
                cli = new PessoaFisica(nome, endereco, numero, bairro, complemento, tel, cel, cidade, cep, tipo_cliente, email, cpf);
                
             }
        }
        
        cliDAO.inserir(cli);
        return cli.getIdCliente();
    }
    
    public void excluirCliente(Cliente cli) throws SQLException, Exception{
        cliDAO.excluir(cli);        
    }
    
    public void inserirCidade(String nome, String uf) throws Exception, SQLException{
        
        Cidade cid = new Cidade(nome,uf);
        cidDAO.inserir(cid);
    }
    
    public void carregarComboCidade(JComboBox combo) throws Exception, SQLException  {
        
        List lista = cliDAO.listarCidades();
        
        combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
    }
    
    public void carregarComboTipo(JComboBox combo) throws Exception, SQLException  {
        
        List lista = produtoDAO.listarTipos();
        combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
    }
    
    public void carregarComboLinhas(JComboBox combo) throws Exception, SQLException  {
        
        List lista = linhaDAO.listarLinhas();
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
    
    public void pesquisarCliente( JTable tabela, int tipo, String pesq ) throws Exception, SQLException {
        List lista = null;
        
        switch (tipo) {
            case 0: // Pesquisar NOME
                lista = cliDAO.pesquisar(pesq);
                break;
            case 1: // Pesquisar ID
                int id = Integer.parseInt(pesq);
                lista = cliDAO.pesquisar(id);
                break;
            case 2: // Pesquisar BAIRRO
                lista = cliDAO.pesquisarCidade(pesq);
                break;
            
        }    
        // PERCORRE A LISTA E COLOCA NA TABELA      
        Cliente cli;
        // Apagar as linhas da tabela
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        Iterator<Cliente> ite = lista.iterator();
        while ( ite.hasNext() ) {
            cli = ite.next();
            
            ((DefaultTableModel) tabela.getModel()).addRow( cli.toArray() );                        

        }                      
    }
    
    public int alterarCliente(int id, String nome, String endereco, String numero, String bairro, String complemento,
                    String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente, String email,
                    String cpf, String cnpj, String ie) throws SQLException, ClienteException, Exception{
                    Cliente cli = null;
                    if( tipo_cliente == 'F'){
                       cli = new PessoaFisica( id, nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente, email, cpf);
                    }else{
                        if(tipo_cliente == 'J'){
                            cli = new PessoaJuridica( id, nome, endereco, numero, bairro, complemento, telFixo, telCel, cidade, cep, tipo_cliente, email, cnpj, ie);
                        }
                    }
        
                    cliDAO.alterar(cli);
             
                    return cli.getIdCliente();
        
    }
    public void inserirLinha( String nome, String descricao) throws Exception, SQLException {
        Linha linha = new Linha(nome, descricao);
        linhaDAO.inserir(linha);
    }
    
    public void pesquisarLinha( JTable tabela, int tipo, String pesq ) throws Exception, SQLException {
        
        List lista = null;
        lista = linhaDAO.pesquisar(pesq);
        
        // PERCORRE A LISTA E COLOCA NA TABELA
        Linha lin;

        // Apagar as linhas da tabela
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        
        Iterator<Linha> ite = lista.iterator();
        while ( ite.hasNext() ) {
            lin = ite.next();
            ((DefaultTableModel) tabela.getModel()).addRow( lin.toArray() );                        
        }                          
    }
    
    public void excluirLinha(Linha lin) throws SQLException, Exception{
            linhaDAO.excluir(lin);
    }
    
    public void alterarLinha(int id, String nome, String descricao) throws Exception, SQLException {
        Linha lin = new Linha( id, nome, descricao );
        linhaDAO.alterar(lin);
    }
    
    public void inserirProduto(String descricao, Linha linha, Tipo tipo, float preco, char status) throws Exception, SQLException {
        
        if(status == 'T'){ prod = new Produto(descricao, linha, tipo, preco, true);     
        }else{
            if(status == 'F'){ prod = new Produto(descricao, linha, tipo, preco, false);}
        }
        produtoDAO.inserir(prod);
    }
    
    public void pesquisarProdutos( JTable tabela, int tipo, String pesq ) throws Exception, SQLException {
        List lista = null;
      
        switch (tipo) {
            case 0: // Pesquisar NOME
                lista = produtoDAO.pesquisarProduto(pesq);
                break;
            case 1: // Pesquisar Linha
                lista = produtoDAO.pesquisarProdutoPorLinha(pesq);
                break;
            case 2: // Pesquisar Tipo
                lista = produtoDAO.pesquisarProdutoPorTipo(pesq);
                break;      
        }
        // PERCORRE A LISTA E COLOCA NA TABELA
        Produto prod;
        
        // Apagar as linhas da tabela
        ((DefaultTableModel) tabela.getModel()).setRowCount(0);
        Iterator<Produto> ite = lista.iterator();
        while ( ite.hasNext() ) {
            prod = ite.next();
            ((DefaultTableModel) tabela.getModel()).addRow( prod.toArray() );                        

        }
    }
    
    public void excluirProduto(Produto prod) throws SQLException, Exception{
        produtoDAO.excluir(prod);        
    }
    
    public void alterarProduto(int id, String descricao, Linha linha, Tipo tipo, String preco, char habilitar_venda) throws Exception, SQLException {
        if(habilitar_venda == 'T'){
            prod = new Produto(id, descricao, linha, tipo, Float.parseFloat(preco), true);
        }else{
            if(habilitar_venda == 'F'){
                prod = new Produto(id, descricao, linha, tipo, Float.parseFloat(preco), false);
            }
        } 
        produtoDAO.alterar(prod);
    }

}
