/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Contenedores78 extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    JButton bJFrame;
    public static void main(String[] args) {
        // TODO code application logic here
        Contenedores78 miVentana = new Contenedores78("Probando contenedores");
        miVentana.setBounds(300, 300, 800, 300);
        miVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        miVentana.setVisible(true);
        
    }

    public Contenedores78(String title) throws HeadlessException {
        super(title);
        
        Container cpane = this.getContentPane();
        
        JPanel norte = new JPanel();
        GridLayout centroLay = new GridLayout(2,3,40,50);
        JPanel centro = new JPanel(centroLay);
        JPanel sur = new JPanel();
        
        //panel norte
        
        JLabel etiqueta = new JLabel("     CONTENEDORES JAVA Swing     ");
        norte.add(etiqueta);
        etiqueta.setFont(new Font("Tahoma",Font.ITALIC, 28));
        etiqueta.setBorder(BorderFactory.createLoweredBevelBorder());
        
        //panel central
        
        
        
        bJFrame = new JButton(" Ejemplo Jframe ");
        bJFrame.addActionListener(this);
        JButton bJDialog = new JButton(" Ejemplo JDialog ");
        JButton bJPanel = new JButton(" Ejemplo JPanel ");
        JButton bJScrollp = new JButton(" Ejemplo JScroll ");
        JButton bJSplitp = new JButton(" Ejemplo JSplit ");
        JButton bJTabbedp = new JButton(" Ejemplo JTabbed ");
        
        centro.add(bJFrame);
        centro.add(bJDialog);
        centro.add(bJPanel);
        centro.add(bJScrollp);
        centro.add(bJSplitp);
        centro.add(bJTabbedp);
        
       
        
        
        cpane.add(norte, BorderLayout.NORTH);
        cpane.add(centro, BorderLayout.CENTER);
        cpane.add(sur, BorderLayout.SOUTH);
        
        /*bJFrame.addActionListener((new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EjemploJFrame();
            }
        }));*/

        
        
        //panel sur
        JButton bJDeskTop = new JButton(" Ejemplo JDeskTopPane ");
        JButton bJToolBar = new JButton(" Ejemplo JToolBar ");
        
        sur.add(bJDeskTop);
        sur.add(bJToolBar);
        
    }//constructor
            @Override
    public void actionPerformed(ActionEvent e) {
        String textoB = e.getActionCommand();
        JButton boton = (JButton)e.getSource();
        
        if(boton==bJFrame){
        EjemploJFrame ventana = new EjemploJFrame();
        ventana.setVisible(true);
        }
    }
    
}
