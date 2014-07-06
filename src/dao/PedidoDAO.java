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
    
    
    public int inserir(Pedido pedido) throws Exception, SQLException{
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

    public List pesquisarPedidoCliente(String pesqNomeCliente)  throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente JOIN FETCH p.cliente.cidade where p.cliente.nome LIKE '" +
                    pesqNomeCliente + "%' ORDER BY data DESC");
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

    public List pesquisarPedidoMes(String pesq) throws Exception, SQLException{
        int numMes;
        numMes = Mes(pesq);
        DateFormat dateFormat = new SimpleDateFormat("MM"); 
        
        
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente JOIN FETCH p.cliente.cidade where (month(p.data)) = "+numMes+" ORDER BY data DESC");
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

    public List apuracaoMes(String mes, String ano) throws Exception, SQLException{
        int numMes;
        numMes = Mes(mes);
        DateFormat dateFormat = new SimpleDateFormat("MM"); 
        
        
        Session sessao = null;
        List lista = null;
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente JOIN FETCH p.cliente.cidade where (month(p.data)) = "+numMes+" AND (year(p.data)) = "+ano+" ORDER BY data DESC");
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
    
    public List pesquisarPedidoHoje() throws Exception, SQLException {
        Session sessao = null;
        List lista = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd"); 
        Date date = new Date(); 
        String dataString = dateFormat.format(date);
        
        try {
            sessao = dao.HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();
            
            // Usando HQL           
            Query consulta = sessao.createQuery("From Pedido p JOIN FETCH p.cliente JOIN FETCH p.cliente.cidade where p.data = "+
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
        if("janeiro".contains(mes.toLowerCase())) {
            return 1;
        }else{
            if("fevereiro".contains(mes.toLowerCase())) {
                return 2;
            }else{
                if("marco".contains(mes.toLowerCase()) || "março".contains(mes.toLowerCase())) {
                    return 3;
                }else{
                    if("abril".contains(mes.toLowerCase())) {
                        return 4;
                    }else{
                        if("maio".contains(mes.toLowerCase())) {
                            return 5;
                        }else{
                            if("junho".contains(mes.toLowerCase())) {
                                return 6;
                            }else{
                                if("julho".contains(mes.toLowerCase())) {
                                    return 7;
                                }else{
                                    if("agosto".contains(mes.toLowerCase())) {
                                        return 8;
                                    }else{
                                        if("setembro".contains(mes.toLowerCase())) {
                                            return 9;
                                        }else{
                                            if("outubro".contains(mes.toLowerCase())) {
                                                return 10;
                                            }else{
                                                if("novembro".contains(mes.toLowerCase())) {
                                                     return 11;
                                                }else{
                                                    if("dezembro".contains(mes.toLowerCase())) {
                                                        return 12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0; //se o mês não for encontrado, retorna 0
    }
    
    public void excluir(Pedido ped)  throws Exception, SQLException{

    }
    
}
