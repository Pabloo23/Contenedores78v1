/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Gamero
 */
public class Componentes extends JFrame{

    
    public static void main(String[] args) {
        Componentes ventanaP = new Componentes("Ejercicio Componentes");
        ventanaP.setBounds(100, 25, 600, 700);
        ventanaP.setVisible(true);
        ventanaP.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public Componentes(String title) throws HeadlessException {
        super(title);
        add(new ComponentesTabbed());
        /*ComponentesBotones();
        this.setContentPane(rootPane);*/
        
    }
    
    /*void ComponentesBotones(){
        JTabbedPane tabs;
        JPanel panelBotones, pBotN, pBotS, pBotE, pBotO, pBotC;
        tabs = new JTabbedPane();
        tabs.setBorder(BorderFactory.createTitledBorder("Titulo panel exterior"));
        tabs.addTab("Botones", panelBotones);
        tabs.setVisible(true);
        
        panelBotones = new JPanel(new BorderLayout());
        pBotN = new JPanel();
        pBotS = new JPanel();
        pBotO = new JPanel();
        pBotE = new JPanel();
        pBotC = new JPanel();
        panelBotones.add(pBotN, BorderLayout.NORTH);
        pBotN.setBorder(BorderFactory.createLineBorder(Color.yellow));
        panelBotones.add(pBotS, BorderLayout.SOUTH);
        pBotS.setBorder(BorderFactory.createLineBorder(Color.red));
        panelBotones.add(pBotE, BorderLayout.EAST);
        pBotE.setBorder(BorderFactory.createLineBorder(Color.blue));
        panelBotones.add(pBotO, BorderLayout.WEST);
        pBotO.setBorder(BorderFactory.createLineBorder(Color.ORANGE));
        panelBotones.add(pBotC, BorderLayout.CENTER);
        pBotS.setBorder(BorderFactory.createLineBorder(Color.magenta));
    }*/
    
}
