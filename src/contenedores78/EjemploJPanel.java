/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Pablo
 */
public class EjemploJPanel extends JFrame implements ActionListener {

    JPanel panelN;
    JPanel panelC;
    JPanel panelCi;
    JPanel panelCd;
    JPanel panelS;
    JLabel etiqueta1;
    JLabel etiqueta2;
    JButton boton1, boton2, boton3;

    public EjemploJPanel() {
        setTitle("Resultado del boton JPanel");
        Container cpane1 = getContentPane();

        creadorPanelNorte();
        creadorPanelCentral();
        creadorPanelSur();

        cpane1.add(panelN, BorderLayout.NORTH);
        cpane1.add(panelC, BorderLayout.CENTER);
        cpane1.add(panelS, BorderLayout.SOUTH);

        setSize(400, 250);
        //pone la ventana en el centro de la pantalla
        setLocationRelativeTo(null);

    }//constructor
    //PANEL NORTE--------------------------------------------------------------

    void creadorPanelNorte() {

        panelN = new JPanel();
        panelN.add(new JLabel(" Contenedor JPanel "));
    }

    //PANEL CENTRAL------------------------------------------------------------
    void creadorPanelCentral() {

        panelC = new JPanel();
        panelC.setLayout(new BoxLayout(panelC, BoxLayout.LINE_AXIS));

        panelCi = new JPanel();
        panelCi.setBackground(Color.red);

        JPanel panelCc = new JPanel();
        //panelCc.setSize(20, 10);
        etiqueta1 = new JLabel(" Titulo Panel1 ");
        panelCi.add(etiqueta1);

        panelCd = new JPanel();
        panelCd.setBackground(Color.green);
        panelCd.setLayout(new BoxLayout(panelCd, BoxLayout.PAGE_AXIS));
        
        JPanel panelCd1 = new JPanel();
        panelCd1.setBackground(null);
        JPanel panelCd2 = new JPanel();
        panelCd2.setBackground(null);

        panelCd.add(panelCd1);
        etiqueta2 = new JLabel(" Titulo Panel2 ");
        panelCd1.add(etiqueta2);
        /*etiqueta2.setAlignmentX(CENTER_ALIGNMENT);
            etiqueta2.setAlignmentY(CENTER_ALIGNMENT);*/
        panelCd.add(panelCd2);
        boton1 = new JButton(" Boton ");
        panelCd2.add(boton1);
        /*boton1.setAlignmentX(CENTER_ALIGNMENT);
            boton1.setAlignmentY(CENTER_ALIGNMENT);*/

        panelC.add(panelCi);
        panelC.add(panelCc);
        panelC.add(panelCd);
    }

    //PANEL SUR----------------------------------------------------------------
    void creadorPanelSur() {

        panelS = new JPanel();
        
        boton2 = new JButton(" Boton Visible ");
        boton2.setName("boton2");
        boton2.addActionListener(this);
        boton3 = new JButton(" Boton No Visible ");
        boton3.setName("boton3");
        boton3.addActionListener(this);
        
        
        panelS.setLayout(new GridLayout(2, 1,10,10));
        
        panelS.add(boton2);
        panelS.add(boton3);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();
        
            switch (boton.getName()) {

                case "boton2":
                    panelCd.setVisible(true);
                    break;
                case "boton3":
                    panelCd.setVisible(false);
                    break;
            }
        }
    }
