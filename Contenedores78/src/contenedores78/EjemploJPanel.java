/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class EjemploJPanel extends JFrame {
    
        public EjemploJPanel(){
        setTitle("Resultado del boton JPanel");
        Container cpane1 = getContentPane();
        JPanel panelN = new JPanel();
        JPanel panelC = new JPanel();
        JPanel panelCi = new JPanel();
        panelCi.setBackground(Color.red);
        JPanel panelCd = new JPanel();
        panelCd.setBackground(Color.green);
        JPanel panelS = new JPanel();
        panelC.setLayout(new BoxLayout(panelC, BoxLayout.LINE_AXIS));
        panelCd.setLayout(new BorderLayout());
        JPanel panelCdn = new JPanel();
        panelCdn.setBackground(null);
        JPanel panelCdc = new JPanel();
        panelCdc.setBackground(null);
        cpane1.add(panelN,BorderLayout.NORTH);
        cpane1.add(panelC,BorderLayout.CENTER);
        cpane1.add(panelS,BorderLayout.SOUTH);
        
        panelN.add(new JLabel(" Contenedor JPanel "));
        panelC.add(panelCi);
        panelC.add(panelCd);
        panelCi.add(new Label(" Titulo Panel1 "));
        panelCd.add(panelCdn,BorderLayout.NORTH);
        panelCd.add(panelCdc,BorderLayout.CENTER);
        panelCdn.add(new Label("Titulo Panel2"));
        panelCdc.add(new JButton(" Boton "));
        
        
        setSize(400,250);
        //pone la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
                
    }
    
}
