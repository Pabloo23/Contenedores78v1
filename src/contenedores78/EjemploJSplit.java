/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contenedores78;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javafx.scene.control.SplitPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

/**
 *
 * @author Pablo
 */
public class EjemploJSplit extends JFrame{
    
    JPanel panelC,panelO,panelE;
    JSplitPane panelSp;
    
    public EjemploJSplit(){
    
        setTitle("Resultado boton JSplit");
        Container cpane = getContentPane();
        panelC = new JPanel();
        panelO = new JPanel();
        panelO.setBackground(Color.pink);
        panelE = new JPanel();
        panelE.setBackground(Color.YELLOW);
        panelSp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, panelO, panelE);
        
        
        //cpane.add(panelC,BorderLayout.CENTER);
        //panelC.add(panelSp);
        cpane.add(panelSp);
        setSize(200, 200);
        //int ancho = panelSp.getHeight();
        panelSp.setDividerLocation(85);
        setLocationRelativeTo(null);
        
        
        
        
    }
    
}
