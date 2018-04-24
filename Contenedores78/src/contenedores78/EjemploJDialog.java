/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Pablo
 */
public class EjemploJDialog extends JDialog {
    
    public EjemploJDialog(JFrame ventanaPrincipal,boolean modal){
        super(ventanaPrincipal, modal);
        setTitle("Resultado del boton JDialog");
        Container cpane1 = getContentPane();
        JPanel panelN = new JPanel();
        JPanel panelC = new JPanel();
        
        
        cpane1.add(panelN,BorderLayout.NORTH);
        cpane1.add(panelC,BorderLayout.CENTER);
        panelN.add(new JLabel(" Contenedor JDialog "),BorderLayout.NORTH);
        panelC.add(new JTextArea("Ejemplo de JDialog....", 10, 20), BorderLayout.CENTER);
        pack();
        //pone la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
                
    }
}
