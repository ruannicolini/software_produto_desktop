/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import negocio.Pedido;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class PedidoDAO {

    public PedidoDAO()throws Exception, SQLException {
    }
    
    
    public int inserir(Pedido pedido){
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.save(pedido);
            
            sessao.getTransaction().commit();            
        } catch (HibernateException he) {
            sessao.getTransaction().rollback();
        }
        finally {
            if ( sessao != null ) {
                sessao.close();
            }            
        }
        return pedido.getIdPedido();
        
    }
    
    public void alterar(Pedido novoPed)  throws Exception, SQLException {
        Session sessao = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
                                  
            sessao.update(novoPed);
            
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

    public List pesquisarPedidoCliente(String pesqNomeCliente) {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
//            Query consulta = sessao.createQuery("from Pedido ped JOIN FETCH ped.cliente JOIN FETCH ped.pedidoitems where ped.cliente.nome LIKE '%" +
//                    pesqNomeCliente + "%' AND pedidoitem.pedido.idPedido = ped.idPedido");
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente where p.cliente.nome LIKE '" +
                    pesqNomeCliente + "%' ");
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

    public List pesquisarPedidoMes(String pesq) {
        return null;
    }

    public List pesquisarPedidoHoje(String pesq) {
        return null;
    }

    public void excluir(Pedido ped) {

    }
    
}
