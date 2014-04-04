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

/**
 *
 * @author Ruan
 */
public class CidadeDAO {
    Statement stmt;

    public CidadeDAO() throws Exception {
        stmt = ConexaoMySQL.obterConexao().createStatement();
    }
    
    public void inserir(Cidade cid) throws Exception, SQLException{
        String sql = "INSERT INTO Cidade (nome, uf)VALUES (?,?) ";
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
        pst.setString(1, cid.getNome() );
        pst.setString(2, cid.getUf() );
        
        pst.execute();
        
        // Pegar ID gerado pelo campo AUTO NUMERAÇÃO
        System.out.println("Foi inserida a cidade com iD " +pst.getGeneratedKeys() + "."); 
        
    }
    
    public List pesquisar ( String pesqNome ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Cidade WHERE Cidade.nome LIKE '" + pesqNome + "%' ");
        
        // Transformar RS em List
        
        while ( rs.next() ) {           
           Cidade cid = new Cidade ( rs.getInt("id_cidade"), rs.getString("Cidade.nome"), rs.getString("uf"));
           
           lista.add(cid);                        
        }
        
        
        return lista;
    }
    public List pesquisarUf(String pesqUf) throws Exception, SQLException{
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Cidade WHERE Cidade.uf LIKE '" + pesqUf + "%' ");
        
        // Transformar RS em List
        
        while ( rs.next() ) {           
           Cidade cid = new Cidade ( rs.getInt("id_cidade"), rs.getString("Cidade.nome"), rs.getString("uf"));
           
           lista.add(cid);                        
        }
        
        
        return lista;
        
    }
    public void alterar(Cidade novoCid)  throws Exception, SQLException {
        String sql = "UPDATE cidade SET nome = ?, uf = ? WHERE id_cidade = " + novoCid.getIdCidade();                
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql ) ;
        pst.setString(1, novoCid.getNome() );
        pst.setString(2, novoCid.getUf() );
        
        pst.execute();
        
       
        
    }

    
}
