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
import negocio.Cliente;
import negocio.Cidade;
import negocio.PessoaFisica;
import negocio.PessoaJuridica;


/**
 *
 * @author Ruan
 */
public class ClienteDAO {
    Statement stmt;

    public ClienteDAO() throws Exception, SQLException {
        
        stmt = ConexaoMySQL.obterConexao().createStatement();
        
    }    
    
    public void inserir ( Cliente cli ) throws Exception, SQLException {
        
        PreparedStatement pst = null;
        if(cli.getTipo_cliente() == 'J'){
            String sql = "INSERT INTO Cliente ( nome, endereco, numero, bairro, complemento, "
                     + "telefone, celular, id_cidade, tipo_cliente, cep, cnpj, ie) "
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
        
            pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
            pst.setString(1, cli.getNome() );
            pst.setString(2, cli.geteEdereco() );
            pst.setString(3, cli.getNumero());
            pst.setString(4, cli.getBairro() );
            pst.setString(5, cli.getComplemento() );
            pst.setString(6, cli.getTelFixo() );
            pst.setString(7, cli.getTelCel());
            pst.setInt(8, cli.getCidade().getIdCidade());
            pst.setString(9, String.valueOf( cli.getTipo_cliente() ));
            pst.setString(10, cli.getCep());
            pst.setString(11, ((PessoaJuridica) cli).getCnpj());
            pst.setString(12,((PessoaJuridica) cli).getIe());
            
        }else{
            if(cli.getTipo_cliente() == 'F'){
                            String sql = "INSERT INTO Cliente ( nome, endereco, numero, bairro, complemento, "
                     + "telefone, celular, id_cidade, tipo_cliente, cep, cpf) "
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
        
            pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
            pst.setString(1, cli.getNome() );
            pst.setString(2, cli.geteEdereco() );
            pst.setString(3, cli.getNumero());
            pst.setString(4, cli.getBairro() );
            pst.setString(5, cli.getComplemento() );
            pst.setString(6, cli.getTelFixo() );
            pst.setString(7, cli.getTelCel());
            pst.setInt(8, cli.getCidade().getIdCidade());
            pst.setString(9, String.valueOf( cli.getTipo_cliente() ));
            pst.setString(10, cli.getCep());
            pst.setString(11,((PessoaFisica) cli).getCpf());
                
            }     
        }
        pst.execute();
        
        // Pegar ID gerado pelo campo AUTO NUMERAÇÃO
        ResultSet rs = pst.getGeneratedKeys();
        if ( rs.next() ) {
            cli.setIdCliente( rs.getInt(1) );
        }  
    }
    
        public List listarCidades() throws Exception, SQLException {
        
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from Cidade");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
           int id = rs.getInt(1);
           String nome = rs.getString("nome");
           String uf = rs.getString("uf");
           
           Cidade cid = new Cidade(id, nome,uf);
           
           lista.add(cid);            
            
        }
        
        
        return lista;
    }
    
}
