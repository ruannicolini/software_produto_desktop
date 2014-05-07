/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import negocio.Pessoajuridica;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class PessoajuridicaDAO {

    public PessoajuridicaDAO() throws Exception, SQLException{
    }
    public void inserir ( Pessoajuridica cliJ ) throws Exception, SQLException {
        
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(cliJ);
            
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

    public void excluir ( Pessoajuridica novaPessoaJ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.delete(novaPessoaJ);
            
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
        
    public void alterar ( Pessoajuridica novaPessoaJ ) throws Exception, SQLException {
 
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.update(novaPessoaJ);
            
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
    
    public Pessoajuridica pesquisar ( int id ) throws Exception, SQLException {
        Session sessao = null;
        Pessoajuridica cliJ = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from PESSOAJURIDICA where PESSOAJURIDICA.IDCLIENTE = "+ id);
            cliJ = (Pessoajuridica) consulta.list();
            
            sessao.getTransaction().commit(); 
                       
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            } 
            return cliJ;
        }
    }
    
}
