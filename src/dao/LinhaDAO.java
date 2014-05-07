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
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class LinhaDAO {

    public LinhaDAO() throws Exception, SQLException{
        
        
    }
    
    public void inserir(Linha lin) throws Exception, SQLException{
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(lin);
            
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
            Query consulta = sessao.createQuery("from Linha lin where lin.nome LIKE '%" +
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
        
    public void alterar(Linha novoLin)  throws Exception, SQLException {
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.update(novoLin);
            
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
        
    public void excluir ( Linha lin ) throws Exception, SQLException {
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.delete(lin);
            
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
    
    public List listarLinhas() throws Exception, SQLException {
        Session sessao = null;
        List<Linha> lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from Linha");
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
    
}
