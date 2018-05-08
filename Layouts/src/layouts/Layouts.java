/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class Layouts extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Layouts ventana = new Layouts();
        JPanel panelN, panelC;
        panelN = new JPanel(new FlowLayout(2));
        panelC = new JPanel(new GridBagLayout());
        //ventana.setLayout(new FlowLayout(FlowLayout.CENTER));

        //Panel norte//
        JButton boton1 = new JButton("boton 1");
        JButton boton2 = new JButton("boton 2");
        panelN.add(boton1);
        panelN.add(boton2);
        ventana.add(panelN, BorderLayout.NORTH);
        GridBagConstraints gbc1 = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        GridBagConstraints gbc3 = new GridBagConstraints();

        //Panel central//
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.gridheight=2;
        gbc1.fill=GridBagConstraints.VERTICAL;
        gbc1.weightx=0;
        gbc1.weighty=1.0;
        panelC.add(new JButton("(" + 0 + "," + 0 + ")"), gbc1);
        gbc2.gridx = 1;
        gbc2.gridy = 1;
        gbc2.gridheight=1;
        gbc2.gridwidth=GridBagConstraints.REMAINDER;
        gbc2.weightx=1.0;
        gbc2.weighty=1.0;
        gbc2.anchor=GridBagConstraints.SOUTH;
        gbc2.fill=GridBagConstraints.HORIZONTAL;
        
        
        panelC.add(new JButton("(" + 1 + "," + 1 + ")"), gbc2);
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.gridheight=1;
        gbc3.gridwidth=GridBagConstraints.REMAINDER;
        gbc3.weightx=1.0;
        gbc3.weighty=0.5;
        gbc3.fill=GridBagConstraints.BOTH;
        
        
        panelC.add(new JButton("(" + 2 + "," + 2 + ")"), gbc3);

        ventana.add(panelC, BorderLayout.CENTER);

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(600, 400);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

}
