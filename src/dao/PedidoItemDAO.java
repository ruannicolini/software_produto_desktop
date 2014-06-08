/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import negocio.Pedidoitem;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class PedidoItemDAO {

    public PedidoItemDAO()throws Exception, SQLException {
    }
    
    public void inserir(Pedidoitem item){
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
    
    public List pesquisar(int codPedido) {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedidoitem pi JOIN FETCH pi.pedido JOIN FETCH pi.produto JOIN FETCH pi.produto.linha JOIN FETCH pi.produto.tipoproduto where pi.pedido.idPedido = " +
                    codPedido);
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
