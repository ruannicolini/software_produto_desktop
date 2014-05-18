/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador;

import dao.*;
import java.math.BigDecimal;
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
    PessoafisicaDAO pfDAO;
    PessoajuridicaDAO pjDAO;
    LinhaDAO linhaDAO;
    ProdutoDAO produtoDAO;
    Cliente cli;
    Pessoafisica cliF;
    Pessoajuridica cliJ;
    Produto prod;
    TipoProdutoDAO tipoProdutoDAO;

    public Controlador() throws Exception, SQLException {
        cidDAO = new CidadeDAO();
        cliDAO = new ClienteDAO();
        linhaDAO = new LinhaDAO();
        produtoDAO = new ProdutoDAO();
        pjDAO = new PessoajuridicaDAO();
        pfDAO = new PessoafisicaDAO();
        tipoProdutoDAO = new TipoProdutoDAO();
    }
    
  
    public int inserirCliente(String nome, String endereco, String numero, String bairro, String complemento, 
            String tel, String cel, Cidade cidade, String cep, char tipo_cliente,String email, String cpf, String cnpj, String ie)
            throws Exception, SQLException {
        cli = new Cliente(cidade, nome, endereco, numero, bairro, complemento,tel, cel,cep, tipo_cliente, email);
        
        cliDAO.inserir(cli);
        if(tipo_cliente == 'J'){
            cliJ = new Pessoajuridica(cli,cnpj, ie);
            pjDAO.inserir(cliJ);

        }else{
            if(tipo_cliente == 'F'){
                cliF = new Pessoafisica(cli,cpf);
                pfDAO.inserir(cliF);
             }
        }
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
        
        List<Cidade> lista = cidDAO.listarCidades();
        
        combo.setModel( new DefaultComboBoxModel( lista.toArray() ) );
    }
    
    public void carregarComboTipo(JComboBox combo) throws Exception, SQLException  {
        
        List<Tipoproduto> lista = tipoProdutoDAO.listarTipos();
        
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
        Cidade cid = new Cidade(nome, uf );
        cid.setIdCidade(id);
        
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
    
//    public Pessoafisica pesquisarClienteF( Cliente cli ) throws Exception, SQLException {
//        Pessoafisica pf =  pfDAO.pesquisar(cli.getIdCliente());
//        return pf;
//    }
//    
//    public Pessoajuridica pesquisarClienteJ( Cliente cli ) throws Exception, SQLException {
//        return pjDAO.pesquisar(cli.getIdCliente());
//    }
    
    public int alterarCliente(int id, String nome, String endereco, String numero, String bairro, String complemento,
                    String telFixo, String telCel, Cidade cidade, String cep, char tipo_cliente, String email,
                    String cpf, String cnpj, String ie) throws SQLException, ClienteException, Exception{
        
                    Cliente cli = new Cliente(cidade, nome, endereco, numero, bairro, complemento,telFixo, telCel,cep, tipo_cliente, email);
                    cli.setIdCliente(id);
                                        
                    if( tipo_cliente == 'F'){
                        cliF = new Pessoafisica(cli,cpf);
                        cliF.setIdCliente(cli.getIdCliente());
                        
                        cli.setPessoafisica(cliF);
                    }else{
                        if(tipo_cliente == 'J'){
                            cliJ = new Pessoajuridica(cli,cnpj, ie);
                            cliJ.setIdCliente(cli.getIdCliente());
                            cli.setPessoajuridica(cliJ);
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
        Linha lin = new Linha(nome, descricao);
        lin.setIdLinha(id);
        linhaDAO.alterar(lin);
    }
    
    public void inserirProduto(String descricao, Linha linha, Tipoproduto tipo, float preco, char status) throws Exception, SQLException {
        
        if(status == 'T'){ 
            prod = new Produto(tipo, linha, descricao , preco, true);     
        }else{
            if(status == 'F'){ 
                prod = new Produto(tipo, linha, descricao , preco, false);}
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
    
    public void alterarProduto(int id, String descricao, Linha linha, Tipoproduto tipo, String preco, char habilitar_venda) throws Exception, SQLException {
        if(habilitar_venda == 'T'){
            prod = new Produto(tipo, linha, descricao, Float.parseFloat(preco), true);
            prod.setIdProduto(id);
        }else{
            if(habilitar_venda == 'F'){
                prod = new Produto(tipo, linha, descricao, Float.parseFloat(preco), false);
                prod.setIdProduto(id);
            }
        } 
        produtoDAO.alterar(prod);
    }

}
