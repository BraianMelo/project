package gui.facilities;


import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Methods {
    
    public static void requestFocus(KeyEvent evt,JTextField txt){
        if(enter(evt)){
            txt.requestFocus();
        }
    }
    
    public static void doClick(KeyEvent evt,JButton btn){
        if(enter(evt)){
            btn.doClick();
        }
    }
    
    public static boolean enter(KeyEvent evt){
        if(evt.getKeyCode() == evt.VK_ENTER){
           return true; 
        }
        return false;
    }
    


    
}
