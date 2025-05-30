package Utilidades;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author joaqu
 */
public class MostrarPanel {
    
    public static void showPanel(JPanel content, JPanel p, int ancho, int largo){        
        p.setSize(ancho,largo);
        p.setLocation(0,0);
        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
                return;
    }
    
}
