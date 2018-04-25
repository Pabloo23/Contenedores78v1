/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Pablo
 */
public class EjemploJScroll extends JFrame {
    
    JLabel etiqueta;
    JTextArea areaText;
    JPanel panelC,panelCn,panelCc;
    JScrollPane panelSc;
    
    public EjemploJScroll(){
        
        setTitle("Resultado boton JScroll ");
        Container cpane = getContentPane();
        //panel dentro del ScrollPane
            panelC = new JPanel();
            panelC.setLayout(new BorderLayout());
            //paneles finales para el Layout
                panelCn = new JPanel();
                panelCc = new JPanel();
            //------------------------------
        //----------------------------------
        //Creación del ScrollPane-----------
        panelSc = new JScrollPane(panelC, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        //---------------------------
        //Creación de objetos dentro del panel que va dentro del ScrollPane
        etiqueta = new JLabel("Ventana con JScroll");
        areaText = new JTextArea("Area de texto en un JScroll....", 10,30);
        
        cpane.add(panelSc);
        
        panelC.add(panelCn,BorderLayout.NORTH);
        panelCn.add(etiqueta);
        panelC.add(panelCc,BorderLayout.CENTER);
        panelCc.add(areaText);
        
        setSize(300, 200);
        setLocationRelativeTo(null);
        
    }
    
}
