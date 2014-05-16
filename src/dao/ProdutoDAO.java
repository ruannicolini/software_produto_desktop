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
import negocio.Tipoproduto;

/**
 *
 * @author Ruan
 */
public class ProdutoDAO {
    

    public ProdutoDAO() throws Exception, SQLException {
        
    }
    
    
        
    public void inserir(Produto prod) throws Exception, SQLException{
       
    }
    public List pesquisarProduto ( String pesqDesc ) throws Exception, SQLException {
        return null;
    }
        
    public List pesquisarProdutoPorLinha ( String pesqLinha ) throws Exception, SQLException {
        return null;
    }
    
    public List pesquisarProdutoPorTipo ( String pesqTipo ) throws Exception, SQLException {
        return null;
    }
    
    public void excluir ( Produto prod ) throws Exception, SQLException {
        
    }
    
    public void alterar(Produto novoProd)  throws Exception, SQLException {
        
    }
}
