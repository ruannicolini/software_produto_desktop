/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import negocio.Configuracoes;
import negocio.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class ConfiguracoesDAO {

    public ConfiguracoesDAO() throws Exception, SQLException{
        
    }
    
    public void alterar(Configuracoes config)  throws Exception, SQLException {
        
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.update(config);
            
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
    
    public Configuracoes consultar ( ) throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL
            Query consulta = sessao.createQuery("from Configuracoes config where config.idConfiguracoes = 1");
            lista = consulta.list();
            
            sessao.getTransaction().commit();
            
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
               sessao.close();
            }
            return (Configuracoes) lista.get(0);
        }
    }

    
}
