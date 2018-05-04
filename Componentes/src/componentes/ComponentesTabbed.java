/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class ComponentesTabbed extends JTabbedPane implements ActionListener, ChangeListener{
    JPanel panelBotones, pBotN, pBotS, pBotE, pBotO, pBotC;
    JButton botonN1, botonN2, botonS1, botonS2, botonS3, botonP;
    JCheckBox checkE1, checkE2, checkE3;
    JTextField areaT;
    JLabel altoL1,altoL2,anchoL1,anchoL2;
    static JSlider alto, ancho;
    JPanel panelCombos;
    JPanel panelEtiqueta;
    JPanel panelTextos;
    
    public ComponentesTabbed() throws HeadlessException {
        
        panelBotones = new JPanel(new BorderLayout());
        panelCombos = new JPanel();
        panelEtiqueta = new JPanel();
        panelTextos = new JPanel();
        
        panelBotones.setBorder(BorderFactory.createTitledBorder(new EtchedBorder(EtchedBorder.LOWERED),"Panel de Botones"));
        panelBotones.setBackground(Color.gray);
        pBotN = new JPanel(new FlowLayout());
        pBotN.setBorder(BorderFactory.createLineBorder(Color.red));
        pBotE = new JPanel();
        pBotE.setBorder(BorderFactory.createLineBorder(Color.cyan));
        pBotE.setPreferredSize(new Dimension(80, HEIGHT));
        pBotC = new JPanel();
        pBotC.setBorder(BorderFactory.createLineBorder(Color.yellow));
        pBotO = new JPanel();
        pBotO.setBorder(BorderFactory.createLineBorder(Color.cyan));
        pBotO.setPreferredSize(new Dimension(80, HEIGHT));
        pBotS = new JPanel();
        pBotS.setBorder(BorderFactory.createTitledBorder(null, "Panel sur"));
        
        botonP = new JButton("Botón de prueba");
        botonP.setBackground(Color.green);
        botonP.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        botonP.setBounds(50, 50, 100, 50);
       
        botonN1 = new JButton("Primero");
        botonN2 = new JButton("Segundo");
        alto = new JSlider(VERTICAL,0, 200, 100);
        
        alto.setPaintLabels(true);
        alto.setPaintTicks(true);
        alto.setMajorTickSpacing(30);
        alto.setMinorTickSpacing(15);
        
        ancho = new JSlider(VERTICAL, 0, 400, 250);
        ancho.setPaintLabels(true);
        ancho.setPaintTicks(true);
        ancho.setMajorTickSpacing(50);
        ancho.setMinorTickSpacing(25);
        
        altoL1 = new JLabel("Alto");
        altoL2 = new JLabel("Uds:"+Integer.toString(botonP.getHeight()));
        altoL2.setPreferredSize(new Dimension(75, 27));
        anchoL1 = new JLabel("Ancho");
        anchoL2 = new JLabel("Uds:"+Integer.toString(botonP.getWidth()));
        anchoL2.setPreferredSize(new Dimension(75, 27));
        alto.addChangeListener(this);
        ancho.addChangeListener(this);

        
        
        
        
        panelBotones.add(pBotN, BorderLayout.NORTH);
        panelBotones.add(pBotE, BorderLayout.EAST);
        panelBotones.add(pBotC, BorderLayout.CENTER);
        panelBotones.add(pBotO, BorderLayout.WEST);
        panelBotones.add(pBotS, BorderLayout.SOUTH);
        
        pBotN.add(botonN1);
        pBotN.add(botonN2);
        
        pBotO.add(anchoL1);
        pBotO.add(ancho);
        pBotO.add(anchoL2);
        pBotO.add(altoL1);
        pBotO.add(alto);
        pBotO.add(altoL2);
        
        botonS1 = new JButton("Primero");
        botonS2 = new JButton("Segundo");
        botonS3 = new JButton("Tercero");
        
        areaT = new JTextField(2);
        areaT.setPreferredSize(new Dimension(WIDTH, 27));
        pBotS.add(botonS1);
        pBotS.add(areaT);
        pBotS.add(botonS2);
        pBotS.add(botonS3);
        

        checkE1 = new JCheckBox("Boton 1");
        checkE2 = new JCheckBox("Boton 2");
        checkE3 = new JCheckBox("Boton 3");
        
        
        pBotE.add(checkE1);
        pBotE.add(checkE2);
        pBotE.add(checkE3);
        

        
        pBotC.add(botonP);
        addTab("Botones", panelBotones);
        addTab("Combos", panelCombos);
        addTab("Etiquetas", panelEtiqueta);
        addTab("Textos", panelTextos);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        
    }
    @Override
    public void stateChanged(ChangeEvent e) {
       JSlider slider = (JSlider)e.getSource();
       int valor = slider.getValue();
       
       if(slider == ancho){
       botonP.setSize(valor, botonP.getHeight());
       anchoL2.setText("Ancho: " +valor);
       }
       else{
       botonP.setSize(botonP.getWidth(), valor);
       altoL2.setText("Alto: " +valor);
       }
    }
    
}
