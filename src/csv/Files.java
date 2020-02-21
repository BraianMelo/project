
package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Files {
    
    public final String path = "C:\\Users\\Braian\\Documents\\Meu app";
    
    public String createTextArchivo(String title,String[] text){
        
        String way = path+"\\"+title+".txt";
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(way))){
            
            for(int c = 0; c < text.length;++c){
                bw.write(text[c]);
                bw.newLine();
            }
            bw.write(";");
            
            return way;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
            
    }
    
    public String[] getArchiveText(String title){
        
        String way = path+"\\"+title+".txt";
    
        try(BufferedReader br = new BufferedReader(new FileReader(way))){
            String line = br.readLine();
            
            List<String> list = new ArrayList<>();
            
            while(!line.equals(";")){
                list.add(line);
                line = br.readLine();
            }
             String text[] =  list.stream().toArray(String[] :: new);
            return text;
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    
        
    }
    
    public void deleteFile(String title){
         String way = path+"\\"+title+".txt";
         File file = new File(way);
         file.delete();
    }
}
