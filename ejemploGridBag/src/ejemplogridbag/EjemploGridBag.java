/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplogridbag;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.font.EAttribute;

/**
 *
 * @author Pablo
 */
public class EjemploGridBag extends JFrame{
    
    JLabel name,item,address;
    JTextArea area44,areaAd,areaIt;
    JTextField fieldN;
    public EjemploGridBag(String title) throws HeadlessException {
        super(title);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.4;
        gbc.insets=new Insets(5,5,5,5);
        name = new JLabel("Name");
        this.add(name,gbc);
        gbc.gridx=3;
        gbc.gridy=5;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.2;
        area44 = new JTextArea(2,7);
        this.add(area44,gbc);
        
        gbc.gridx=1;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.2;
        item = new JLabel("Items");
        this.add(item,gbc);
        
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=GridBagConstraints.RELATIVE;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.weightx=0.4;
        fieldN = new JTextField();
        this.add(fieldN,gbc);
        
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.gridheight=GridBagConstraints.RELATIVE;
        gbc.fill=GridBagConstraints.BOTH;
        gbc.weightx=0.6;
        gbc.weighty=0.5;
        areaIt = new JTextArea();
        this.add(areaIt,gbc);
        address = new JLabel("Address");
        
    }

    public static void main(String[] args) {
        EjemploGridBag pantalla = new EjemploGridBag("Diselo GBL");
        pantalla.pack();
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pantalla.setLocationRelativeTo(null);
        
    }
    
}
