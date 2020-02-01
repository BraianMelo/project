package db;

import javax.swing.JOptionPane;

public class dbException extends RuntimeException{
    
    public dbException(String msg){
        super(msg);
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
