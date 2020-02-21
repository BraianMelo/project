package model.Dao.impl;

import db.DB;
import java.util.List;
import model.Dao.PeopleDao;
import model.entities.People;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PeopleDaoJDBC implements PeopleDao{
     
    private Connection conn;
    
    public PeopleDaoJDBC(Connection conn){
        this.conn = conn;
    }
    
    @Override
    public void insert(People people) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO people "
                    + "(name,gender,email,user,password) "
                    + "VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, people.getName().toLowerCase());
            st.setString(2, String.valueOf(people.getGender()));
            st.setString(3, people.getEmail().toLowerCase());
            st.setString(4, people.getUser().toLowerCase());
            st.setString(5, cryptography(people.getPassword().toLowerCase() ,'c'));
            
            int rows = st.executeUpdate();
            
            if(rows > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    people.setId(rs.getInt(1));
                }
                DB.closeResultSet(rs);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(List<People> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<People> findAll() {
       Statement st = null;
       ResultSet rs = null;
       List<People> list = new ArrayList<>();
       try{
           st = conn.createStatement();
           rs = st.executeQuery("SELECT * FROM people");
           
           while(rs.next()){
               Integer id = rs.getInt("id");
               String name = rs.getString("name");
               char gender = rs.getString("gender").charAt(0);
               String email = rs.getString("email");
               String user = rs.getString("user");
               String password = cryptography(rs.getString("password"), 'd');
               list.add(new People(id, name, gender, email, user, password));
           }
           return list;  
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
           return null;
       }finally{  
               DB.closeStatement(st);
               DB.closeResultSet(rs);
        }
    }
    
    public static String cryptography(String word,char x){
        char list[] = word.toCharArray();
        for(int c = 0; c < list.length; ++c){
            if(x == 'c'){
                 list[c] = (char) (list[c] + (char)5);
            }else{
                 list[c] = (char) (list[c] - (char)5);
            }
        }
        return String.valueOf(list);
    }  

}
 