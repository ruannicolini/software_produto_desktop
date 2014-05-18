/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.SQLException;
import java.util.List;
import negocio.Cidade;
import negocio.Linha;
import negocio.Tipoproduto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ruan
 */
public class TipoProdutoDAO {

    public TipoProdutoDAO() throws Exception, SQLException{
        
    }
    
    
    public List listarTipos() throws Exception, SQLException {
        Session sessao = null;
        List<Tipoproduto> lista = null;
        try {
              sessao = dao.HibernateUtil.getSessionFactory().openSession();
              sessao.beginTransaction();

              // Usando HQL
              Query consulta = sessao.createQuery("from Tipoproduto");
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
