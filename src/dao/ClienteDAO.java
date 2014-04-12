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
import java.util.Date;
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
                     + "telefone, celular, id_cidade, tipo_cliente, cep, cnpj, ie, email) "
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        
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
            pst.setString(13, cli.getEmail());
        }else{
            if(cli.getTipo_cliente() == 'F'){
                            String sql = "INSERT INTO Cliente ( nome, endereco, numero, bairro, complemento, "
                     + "telefone, celular, id_cidade, tipo_cliente, cep, cpf, email) "
                     + "VALUES (?,?,?,?,?,?,?,?,?,?,?, ?) ";
        
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
            pst.setString(12, cli.getEmail());
            }     
        }
        pst.execute();
        
        // Pegar ID gerado pelo campo AUTO NUMERAÇÃO
        ResultSet rs = pst.getGeneratedKeys();
        if ( rs.next() ) {
            cli.setIdCliente( rs.getInt(1) );
        }  
    }
    
    public void alterar ( Cliente novoCli )  throws Exception, SQLException {
        
                PreparedStatement pst = null;
        if(novoCli.getTipo_cliente() == 'J'){
                String sql = "UPDATE Cliente SET nome = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?, "
                         + "telefone = ?, celular = ?, id_cidade = ?, tipo_cliente = ?, cep = ?, cnpj = ?, ie = ?, email = ? "
                         + "WHERE id_Cliente = " + novoCli.getIdCliente();

                pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
                pst.setString(1, novoCli.getNome() );
                pst.setString(2, novoCli.geteEdereco() );
                pst.setString(3, novoCli.getNumero());
                pst.setString(4, novoCli.getBairro() );
                pst.setString(5, novoCli.getComplemento() );
                pst.setString(6, novoCli.getTelFixo() );
                pst.setString(7, novoCli.getTelCel());
                pst.setInt(8, novoCli.getCidade().getIdCidade());
                pst.setString(9, String.valueOf( novoCli.getTipo_cliente() ));
                pst.setString(10, novoCli.getCep());
                pst.setString(11, ((PessoaJuridica) novoCli).getCnpj());
                pst.setString(12,((PessoaJuridica) novoCli).getIe());
                pst.setString(13, novoCli.getEmail());
        }else{
            if(novoCli.getTipo_cliente() == 'F'){
                       String sql = "UPDATE Cliente SET nome = ?, endereco = ?, numero = ?, bairro = ?, complemento = ?, "
                                + "telefone = ?, celular = ?, id_cidade = ?, tipo_cliente = ?, cep = ?, cpf = ?, email = ? "
                                + "WHERE id_Cliente = " + novoCli.getIdCliente();

                       pst = ConexaoMySQL.obterConexao().prepareStatement( sql, PreparedStatement.RETURN_GENERATED_KEYS ) ;
                       pst.setString(1, novoCli.getNome() );
                       pst.setString(2, novoCli.geteEdereco() );
                       pst.setString(3, novoCli.getNumero());
                       pst.setString(4, novoCli.getBairro() );
                       pst.setString(5, novoCli.getComplemento() );
                       pst.setString(6, novoCli.getTelFixo() );
                       pst.setString(7, novoCli.getTelCel());
                       pst.setInt(8, novoCli.getCidade().getIdCidade());
                       pst.setString(9, String.valueOf( novoCli.getTipo_cliente() ));
                       pst.setString(10, novoCli.getCep());
                       pst.setString(11,((PessoaFisica) novoCli).getCpf());
                       pst.setString(12, novoCli.getEmail());
            }     
        }
        pst.execute();    
    }
    
    
    public void excluir ( Cliente cli ) throws Exception, SQLException {
        
        String sql = "DELETE FROM Cliente WHERE id_Cliente = " + cli.getIdCliente();
        stmt.execute(sql);
        
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

    public List pesquisar ( String pesqNome ) throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from cliente, Cidade WHERE Cliente.id_Cidade = Cidade.id_Cidade AND "
                + "Cliente.nome LIKE '" + pesqNome + "%' ");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
            if(((rs.getString("tipo_cliente")).charAt(0)) == 'F'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaFisica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cpf")); 
                    lista.add(cli);  
            }else{
                if(((rs.getString("tipo_cliente")).charAt(0)) == 'J'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaJuridica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cnpj"), rs.getString("ie")); 
                    lista.add(cli);
                }
            }
        }
        return lista;
    } 
    
    public List pesquisar ( int id ) throws Exception, SQLException {

        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from cliente, Cidade WHERE Cliente.id_Cidade = Cidade.id_Cidade AND "
                + "Cliente.id_cliente = " + id);
        
        // Transformar RS em List
        
        while ( rs.next() ) {
            if(((rs.getString("tipo_cliente")).charAt(0)) == 'F'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaFisica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cpf")); 
                    lista.add(cli);  
            }else{
                if(((rs.getString("tipo_cliente")).charAt(0)) == 'J'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaJuridica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cnpj"), rs.getString("ie")); 
                    lista.add(cli);
                }
            }
        }
        
        
        return lista;
    }

//    public List pesquisar ( Date dt ) {
//        return null;
//    } 
    
    public List pesquisarCidade ( String cidade )  throws Exception, SQLException {
        ResultSet rs;
        List lista = new ArrayList();
        
        // Consulta no banco
        rs = stmt.executeQuery("SELECT * from cliente, Cidade WHERE Cliente.id_Cidade = Cidade.id_Cidade AND "
                + "Cidade.nome LIKE '" + cidade + "%' ");
        
        // Transformar RS em List
        
        while ( rs.next() ) {
            if(((rs.getString("tipo_cliente")).charAt(0)) == 'F'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaFisica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cpf")); 
                    lista.add(cli);  
            }else{
                if(((rs.getString("tipo_cliente")).charAt(0)) == 'J'){
                    
                    Cidade cid = new Cidade(rs.getInt("id_Cidade"), rs.getString("Cidade.nome"), rs.getString("Cidade.uf"));
           
                    Cliente cli = new PessoaJuridica ( rs.getInt("id_Cliente"), rs.getString("nome"), rs.getString("endereco"),
                            rs.getString("numero"), rs.getString("bairro"),rs.getString("complemento"),
                            rs.getString("telefone") ,rs.getString("celular"), cid, rs.getString("cep"), (rs.getString("tipo_cliente")).charAt(0),rs.getString("email"), rs.getString("cnpj"), rs.getString("ie")); 
                    lista.add(cli);
                }
            }
        }
        return lista;
    }

    public List pesquisar () {
        return null;
    }      
    
}
