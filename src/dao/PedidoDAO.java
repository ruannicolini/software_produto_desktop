/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        int numMes = Mes(pesq);
        
        DateFormat dateFormat = new SimpleDateFormat("MM"); 
         
        //String dataString = dateFormat.format(date);
        
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente where (month(p.data)) = "+numMes);
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

    public List pesquisarPedidoHoje() {
        Session sessao = null;
        List lista = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
        Date date = new Date(); 
        String dataString = dateFormat.format(date);
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente where p.data = "+
                    dataString+"");
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

    public int Mes(String mes){
        if((mes.equals("Janeiro"))||(mes.equals("janeiro"))||(mes.equals("JANEIRO"))){
            return 1;
        }else{
            if((mes.equals("Fevereiro"))||(mes.equals("fevereiro"))||(mes.equals("FEVEREIRO"))){
                return 2;
            }else{
                if((mes.equals("Março"))||(mes.equals("Marco"))||(mes.equals("Marco"))||(mes.equals("Março"))){
                    return 3;
                }
            }
        }
        if((mes.equals("Junho"))||(mes.equals("junho"))||(mes.equals("JUNHO"))){
            return 6;
        }
        return 0;
    }
    
    public void excluir(Pedido ped) {

    }
    
}
