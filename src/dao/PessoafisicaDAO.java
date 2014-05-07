/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import negocio.Pessoafisica;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class PessoafisicaDAO {

    public PessoafisicaDAO()throws Exception, SQLException {
    }
    public void inserir ( Pessoafisica cliF ) throws Exception, SQLException {
        
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(cliF);
            
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
    
     public void excluir ( Pessoafisica novaPessoaF ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.delete(novaPessoaF);
            
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
        
    public void alterar ( Pessoafisica novaPessoaF ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.update(novaPessoaF);
            
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
    
    public Pessoafisica pesquisar ( int id ) throws Exception, SQLException {
        Session sessao = null;
        Pessoafisica cliF = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from PESSOAFISICA where PESSOAFISICA.IDCLIENTE = "+ id);
            cliF = (Pessoafisica) consulta.list();
            
            sessao.getTransaction().commit(); 
                       
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            } 
            return cliF;
        }
    }
}
