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
import negocio.Linha;

/**
 *
 * @author Ruan
 */
public class LinhaDAO {
    Statement stmt;

    public LinhaDAO() throws Exception, SQLException{
        stmt = ConexaoMySQL.obterConexao().createStatement();
        
    }
    
    
    public void inserir(Linha linha) throws Exception, SQLException{
        String sql = "INSERT INTO LINHA (nome, DESCRICAO)VALUES (?,?) ";
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
        pst.setString(1, linha.getNome() );
        pst.setString(2, linha.getDescricao());
        
        pst.execute();
        
    }
    
        public List pesquisar ( String pesqNome ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Linha WHERE Linha.nome LIKE '%" + pesqNome + "%' ");
        
        // Transformar RS em List
        
        while ( rs.next() ) {           
           Linha lin = new Linha ( rs.getInt("id_linha"), rs.getString("Linha.nome"), rs.getString("descricao"));
           
           lista.add(lin);                        
        }
        
        
        return lista;
    }
        
    public void alterar(Linha novoLin)  throws Exception, SQLException {
        String sql = "UPDATE linha SET nome = ?, descricao = ? WHERE id_linha = " + novoLin.getIdLinha();                
        
        PreparedStatement pst = ConexaoMySQL.obterConexao().prepareStatement( sql ) ;
        pst.setString(1, novoLin.getNome() );
        pst.setString(2, novoLin.getDescricao() );
        
        pst.execute();
        
       
        
    }    
        
    public void excluir ( Linha lin ) throws Exception, SQLException {
        
        String sql = "DELETE FROM linha WHERE id_linha = " + lin.getIdLinha();
        stmt.execute(sql);
        
    }
    
    public List listarLinhas() throws Exception, SQLException {
        
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from LINHA");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           int id = rs.getInt(1);
           String nome = rs.getString("NOME");
           String descricao = rs.getString("DESCRICAO");
           
           Linha lin = new Linha(id, nome, descricao);
           
           lista.add(lin);            
            
        }
        return lista;
    }
    
}
