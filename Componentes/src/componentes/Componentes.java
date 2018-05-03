/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Componentes extends JFrame implements ActionListener {

    /**
     * @param args the command line arguments
     */
    
    public Componentes(String titulo) throws HeadlessException{
        super(titulo);
        JPanel panelP = new JPanel();
        ComponentesJTabbed ventanaT = new ComponentesJTabbed();
        this.setContentPane(ventanaT);
        setVisible(true);
        ventanaT.setDefaultCloseOperation(3);
        ventanaT.setLocationRelativeTo(null);
        ventanaT.setSize(600, 600);

    }
    
    public static void main(String[] args) {
      
       
       
       
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
}
