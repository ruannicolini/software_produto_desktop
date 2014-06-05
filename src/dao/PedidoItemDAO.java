/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import negocio.Pedidoitem;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class PedidoItemDAO {

    public PedidoItemDAO()throws Exception, SQLException {
    }
    
    public void inserirItem(Pedidoitem item){
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(item);
            
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
    
}
