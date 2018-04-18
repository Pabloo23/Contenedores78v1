/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertircelsius;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Pablo
 */
public class ConvertirCelsius {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana = new JFrame("Convertidor Celsius");
        Container cpane = ventana.getContentPane();
        //ventana.setLayout(new FlowLayout());
        /*GroupLayout layout = new GroupLayout(cpane);
        cpane.setLayout(layout);*/
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //objetos dentro de la ventana
        JTextField campoTexto = new JTextField();
        JLabel etiquetaC = new JLabel("Celsius");
        JLabel etiquetaF = new JLabel("Fahrenheit");
        JButton convertir = new JButton("Convertir");
        JButton limpiar = new JButton("Limpiar");
        
        
        campoTexto.setPreferredSize(new Dimension(50, 30));
        JPanel panelN = new JPanel();
        JPanel panelC = new JPanel();
        
        
        panelN.add(campoTexto);
        panelN.add(etiquetaC);
        panelC.add(convertir);
        panelC.add(etiquetaF);
        cpane.add(limpiar, BorderLayout.SOUTH);
        cpane.add(panelN,BorderLayout.NORTH);
        cpane.add(panelC,BorderLayout.CENTER);
        ventana.setBounds(500, 300, 400, 200);
        
        ventana.setVisible(true);

        convertir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int tempFahr = (int) ((Double.parseDouble(campoTexto.getText()))
                        * 1.8 + 32);
                etiquetaF.setText(tempFahr + " Fahrenheit");
            }
        });
        
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoTexto.setText("");
                etiquetaF.setText("Fahrenheit");
            }
        });

    }//main

}
