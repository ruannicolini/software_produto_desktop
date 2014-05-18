/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visao;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Ruan
 */
public class Background extends JPanel{
    BufferedImage b;  
    Rectangle2D rect;  
  
    public Background(String image) {  
        try {  
            b = ImageIO.read(Thread.currentThread().getClass().getResourceAsStream(image));//carrego a imagem  
            rect = new Rectangle(0, 0, b.getWidth(), b.getHeight());//crio um retangulo com o tamanho da imagem  
  
        } catch (IOException ex) {  
            ex.printStackTrace(System.err);  
        }  
    }  
  
    @Override  
    public void paintComponent(Graphics g) {   
        TexturePaint p = new TexturePaint(b, rect);//preencho a tela com esses retangulos  
        Graphics2D g2 = (Graphics2D) g;  
        g2.setPaint(p);//digo pro grafico da tela que vou fazer um texturePaint  
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());//desenho a textura na tela toda, preenchendo com a imagem escolhida  
  
    }  
}
