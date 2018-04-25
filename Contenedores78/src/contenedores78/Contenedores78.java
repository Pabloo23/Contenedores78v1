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
    JButton bJDialog;
    JButton bJPanel;
    JButton bJScrollp;
    JButton bJSplitp;
    JButton bJTabbedp;
    
    public static void main(String[] args) {
        // TODO code application logic here
        Contenedores78 miVentana = new Contenedores78("Probando contenedores");
        miVentana.setSize(800, 300);
        miVentana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        miVentana.setVisible(true);
        miVentana.setLocationRelativeTo(null);
        
        
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
        bJFrame.setName("bJFrame");
        bJFrame.addActionListener(this);
        bJDialog = new JButton(" Ejemplo JDialog ");
        bJDialog.setName("bJDialog");
        bJDialog.addActionListener(this);
        bJPanel = new JButton(" Ejemplo JPanel ");
        bJPanel.setName("bJPanel");
        bJPanel.addActionListener(this);
        bJScrollp = new JButton(" Ejemplo JScroll ");
        bJScrollp.setName("bJScrollp");
        bJScrollp.addActionListener(this);
        bJSplitp = new JButton(" Ejemplo JSplit ");
        bJSplitp.setName("bJSplitp");
        bJSplitp.addActionListener(this);
        bJTabbedp = new JButton(" Ejemplo JTabbed ");
        bJTabbedp.setName("bJTabbedp");
        bJTabbedp.addActionListener(this);
        
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
        Container ventana;
        
        switch(boton.getName()){
        
            case "bJFrame":
                ventana = new EjemploJFrame();
                ventana.setVisible(true);
                break;
            case "bJDialog":
                ventana = new EjemploJDialog(this,true);
                ventana.setVisible(true);
                break;
            
            case "bJPanel":
                ventana = new EjemploJPanel();
                ventana.setVisible(true);
                break;
                
            case "bJScrollp":
                ventana = new EjemploJScroll();
                ventana.setVisible(true);
                break;
                
            case "bJSplitp":
                ventana = new EjemploJSplit();
                ventana.setVisible(true);
                break;
                
            case "bJTabbedp":
                ventana = new EjemploJTabbed();
                ventana.setVisible(true);
                break;
            
        }
 
    }
    
}
