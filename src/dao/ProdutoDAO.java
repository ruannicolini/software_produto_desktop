/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Cidade;
import negocio.Linha;
import negocio.Produto;
import negocio.Tipo;

/**
 *
 * @author Ruan
 */
public class ProdutoDAO {
    Statement stmt;

    public ProdutoDAO() throws Exception, SQLException {
        stmt = ConexaoMySQL.obterConexao().createStatement();
    }
    
    
    public List listarTipos() throws Exception, SQLException {
        
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from TIPOPRODUTO");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           int id = rs.getInt(1);
           String descricao = rs.getString("DESCRICAO");
           String unVenda = rs.getString("UN_VENDA");
           
           Tipo tip = new Tipo(id, descricao,unVenda);
           
           lista.add(tip);            
            
        }
        return lista;
    }
    
    public void inserir(Produto prod) throws Exception, SQLException{
        String sql = "INSERT INTO Produto (descricao, preco, HABILITADO_VENDA, ID_LINHA, ID_TIPOPRODUTO)VALUES (?,?,?,?,?) ";
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
        pst.setString(1, prod.getDescricao() );
        pst.setFloat(2, prod.getPreco());
        pst.setBoolean(3, prod.getStatus());   
        pst.setInt(4, prod.getLinha().getIdLinha());
        pst.setInt(5, prod.getTipo().getId());
        pst.execute();
        
    }
    public List pesquisarProduto ( String pesqDesc ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Produto, Linha , TIPOPRODUTO WHERE Produto.descricao LIKE '%" + pesqDesc + "%' AND LINHA.ID_LINHA = PRODUTO.ID_LINHA AND TIPOPRODUTO.ID_TIPO = PRODUTO.ID_TIPOPRODUTO");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           Linha lin = new Linha(rs.getInt("lINHA.id_linha"), rs.getString("LINHA.nome"), rs.getString("LINHA.DESCRICAO"));
           Tipo tip = new Tipo(rs.getInt("TIPOPRODUTO.id_TIPO"), rs.getString("TIPOPRODUTO.DESCRICAO"), rs.getString("UN_VENDA"));

           Produto prod = new Produto ( rs.getInt("id_produto"), rs.getString("Produto.descricao"),lin, tip, rs.getFloat("Produto.preco"), rs.getBoolean("HABILITADO_VENDA") );
           
           lista.add(prod);                        
        }
                
        return lista;
    }
        
    public List pesquisarProdutoPorLinha ( String pesqLinha ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Produto, Linha , TIPOPRODUTO WHERE Linha.nome LIKE '%" + pesqLinha + "%' AND PRODUTO.ID_LINHA = LINHA.ID_LINHA AND TIPOPRODUTO.ID_TIPO = PRODUTO.ID_TIPOPRODUTO");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           Linha lin = new Linha(rs.getInt("lINHA.id_linha"), rs.getString("LINHA.nome"), rs.getString("LINHA.DESCRICAO"));
           Tipo tip = new Tipo(rs.getInt("TIPOPRODUTO.id_TIPO"), rs.getString("TIPOPRODUTO.DESCRICAO"), rs.getString("UN_VENDA"));

           Produto prod = new Produto ( rs.getInt("id_produto"), rs.getString("Produto.descricao"),lin, tip, rs.getFloat("Produto.preco"), rs.getBoolean("HABILITADO_VENDA") );
           
           lista.add(prod);                        
        }
                
        return lista;
    }
    
    public List pesquisarProdutoPorTipo ( String pesqTipo ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Produto, Linha , TIPOPRODUTO WHERE TIPOPRODUTO.descricao LIKE '%" + pesqTipo + "%' AND PRODUTO.ID_TIPOPRODUTO = TIPOPRODUTO.ID_TIPO AND LINHA.ID_LINHA = PRODUTO.ID_LINHA");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           Linha lin = new Linha(rs.getInt("lINHA.id_linha"), rs.getString("LINHA.nome"), rs.getString("LINHA.DESCRICAO"));
           Tipo tip = new Tipo(rs.getInt("TIPOPRODUTO.id_TIPO"), rs.getString("TIPOPRODUTO.DESCRICAO"), rs.getString("UN_VENDA"));

           Produto prod = new Produto ( rs.getInt("id_produto"), rs.getString("Produto.descricao"),lin, tip, rs.getFloat("Produto.preco"), rs.getBoolean("HABILITADO_VENDA") );
           
           lista.add(prod);                        
        }
                
        return lista;
    }
    
    public void excluir ( Produto prod ) throws Exception, SQLException {
        
        String sql = "DELETE FROM produto WHERE id_produto = " + prod.getId();
        stmt.execute(sql);
        
    }
    
    public void alterar(Produto novoProd)  throws Exception, SQLException {
        String sql = "UPDATE produto SET descricao = ?, preco = ?, HABILITADO_VENDA = ?, id_linha = ?, ID_TIPOPRODUTO = ? WHERE id_produto = " + novoProd.getId();                
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql ) ;
        pst.setString(1, novoProd.getDescricao() );
        pst.setFloat(2, novoProd.getPreco());
        pst.setBoolean(3, novoProd.getStatus());
        pst.setInt(4, novoProd.getLinha().getIdLinha());
        pst.setInt(5, novoProd.getTipo().getId());
        
        pst.execute();
        
       
        
    }
}
