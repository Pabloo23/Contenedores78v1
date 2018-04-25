/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Pablo
 */
public class EjemploJTabbed extends JFrame{
    
    JPanel ventana1,ventana2,ventana3,panelC;
    JTabbedPane panelT;
    
    public EjemploJTabbed(){
    
        setTitle("Resultado boton JTabbed");
        Container cpane = getContentPane();
        setSize(500, 300);
        ventana1 = new JPanel();
        ventana1.setBackground(Color.red);
        ventana2 = new JPanel();
        ventana2.setBackground(Color.green);
        ventana3 = new JPanel();
        ventana3.setBackground(Color.blue);
        panelC = new JPanel();
        panelT = new JTabbedPane(JTabbedPane.TOP);
        panelT.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        //panelT.setTitleAt(1, "Ventana1");
        cpane.add(panelT);
        //cpane.add(panelC);
        //panelC.add(panelT);
        panelT.add(ventana1);
        panelT.setComponentAt(0, ventana1);
        panelT.add(ventana2);
        panelT.setComponentAt(1, ventana2);
        panelT.add(ventana3);
        panelT.setComponentAt(2, ventana3);
        
        panelT.setTitleAt(0, "Ventana 1");
        panelT.setTitleAt(1, "Ventana 2");
        panelT.setTitleAt(2, "Ventana 3");
        
        setLocationRelativeTo(null);
    }
   
}
