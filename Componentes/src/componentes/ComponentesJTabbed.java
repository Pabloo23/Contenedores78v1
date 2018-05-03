/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Pablo
 */
public class ComponentesJTabbed extends JFrame{
    
    JPanel panelP1,panelN,panelS,panelE,panelO,panelC;
    JTabbedPane panelT;
    
    public ComponentesJTabbed(){
        panelT = new JTabbedPane();
        panelP1 = new JPanel(new BorderLayout());
        
        //creación de paneles de la Pestaña1
        panelN = new JPanel();
        panelN.setBorder(new LineBorder(Color.red));
        panelS = new JPanel();
        panelS.setBorder(new TitledBorder("Panel sur"));
        panelE = new JPanel();
        panelE.setBorder(new LineBorder(Color.cyan));
        panelO = new JPanel();
        panelO.setBorder(new LineBorder(Color.cyan));
        panelC = new JPanel();
        panelC.setBorder(new LineBorder(Color.yellow));
        
        
        panelP1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED), "Panel de botones"));
        panelT.addTab("Botones", null, panelP1, "Panel de botones");
   
    }
   
}
