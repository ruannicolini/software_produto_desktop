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
import negocio.Pessoafisica;
import negocio.Pessoajuridica;
import negocio.Pessoafisica;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Ruan
 */
public class ClienteDAO {


    public ClienteDAO() throws Exception, SQLException {
        
      }   
    
    
    public void inserir ( Cliente cli ) throws Exception, SQLException {
        
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(cli);
            
            sessao.getTransaction().commit();            
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
                sessao.close();
            }            
        }
    }
    
    public void excluir ( Cliente cli ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            if(cli.getTipoCliente() == 'F'){
                sessao.delete(cli.getPessoafisica());
            }else{
                if(cli.getTipoCliente() == 'J'){
                    sessao.delete(cli.getPessoajuridica());
                }
            }
                                  
            sessao.delete(cli);
            
            sessao.getTransaction().commit();            
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
                sessao.close();
            }            
        }
        
    }
        
    public void alterar ( Cliente cli ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                        
            if(cli.getTipoCliente() == 'F'){
                sessao.update(cli.getPessoafisica());
            }else{
                if(cli.getTipoCliente() == 'J'){
                    sessao.update(cli.getPessoajuridica());
                }
            }
            
            sessao.update(cli);
            
            sessao.getTransaction().commit();            
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
                sessao.close();
            }            
        }
        
    }
    
       
    public List pesquisar ( String pesqNome ) throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("from Cliente cli JOIN FETCH cli.cidade  where cli.nome LIKE '" +
                    pesqNome + "%' ");
            lista = consulta.list();
            
            sessao.getTransaction().commit(); 
                       
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            } 
            return lista;
        }
    } 
    
    public List pesquisar ( int id ) throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from Cliente cli JOIN FETCH cli.cidade  where cli.idCliente = " + id);
            lista = consulta.list();
            
            sessao.getTransaction().commit(); 
                       
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            } 
            return lista;
        }
    }
    
    public List pesquisarCidade ( String cidade )  throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from Cliente cli JOIN FETCH cli.cidade  where cli.cidade.nome LIKE '" +
                    cidade + "%' ");
            lista = consulta.list();
            
            sessao.getTransaction().commit(); 
                       
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            } 
            return lista;
        }
    }

    public List pesquisar () {
        return null;
    }      
}
