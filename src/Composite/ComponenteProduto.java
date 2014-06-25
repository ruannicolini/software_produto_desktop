/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package composite;

import negocio.*;

/**
 *
 * @author Ruan
 */
public interface ComponenteProduto{
    
    public void add(ComponenteProduto cp);  
     public void remove(ComponenteProduto cp); 
     public void print();
     
     public ComponenteProduto getFilho(int i);   
     public String getDescricao();   
     public Integer getIdProduto();
     public Tipoproduto getTipoproduto();
     public Linha getLinha();
     public float getPreco();
     public boolean isStatusVenda();
     
     @Override
    public String toString();
    public Object[] toArray();


      

}
