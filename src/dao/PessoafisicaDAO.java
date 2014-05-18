/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import negocio.Pessoafisica;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
// =============EXEMPLO UTILIZANDO CRITÉRIA ==============================    
//    public Pessoafisica pesquisar (int id) throws Exception, SQLException {
//        Session sessao = null;
//        List<Pessoafisica> lista = null;
//        
//        try {
//            sessao = dao.HibernateUtil.getSessionFactory().openSession();
//            sessao.beginTransaction();
//            
//            // Usando Criteria
//            Criteria cri = sessao.createCriteria(Pessoafisica.class);
//            cri.setFetchMode("cliente", FetchMode.JOIN);
//            cri.add( Restrictions.like("idCliente", id));
//            cri.addOrder( Order.asc("nome") );
//            
//            lista = cri.list();
//            
//            sessao.getTransaction().commit(); 
//                       
//        } catch (HibernateException he) {
//            sessao.getTransaction().rollback();
//        }
//        finally {
//            if ( sessao != null ) {
//               sessao.close();
//            } 
//            return lista.get(0);
//        }
//    
//    }
}
