
package model.Dao.impl;

import com.mysql.jdbc.profiler.LoggingProfilerEventHandler;
import db.DB;
import gui.loginView;
import java.util.List;
import model.Dao.TaskDao;
import model.entities.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class TaskDaoJDBC implements TaskDao{
    
    private Connection conn;

    public TaskDaoJDBC(Connection conn) {
        this.conn = conn;
    }   

    @Override
    public void insert(Task task) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("INSERT INTO task "
                    + "(id,tittle,deadline,way) "
                    + "VALUES (?,?,?,?)");
            
            st.setInt(1, task.getId());
            st.setString(2, task.getTitle().toLowerCase());
            st.setDate(3, new java.sql.Date(task.getDeadline().getTime()));
            st.setString(4, task.getWay());
            st.executeUpdate();
                    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(List<Task> list) {
        
       int id = loginView.peopleLogged.getId();
       PreparedStatement st = null;
       
       try{
           st = conn.prepareStatement("DELETE FROM task WHERE id = "+id);
           st.executeQuery();
           
           for(Task t:list){
               st = conn.prepareStatement("INSERT INTO task (id,tittle,deadline,way) VALUES (?,?,?,?) ");
               st.setInt(1, id);
               st.setString(2, t.getTitle());
               st.setDate(3, new java.sql.Date(t.getDeadline().getTime()));
               st.setString(4, t.getWay());
               st.executeUpdate();
           }
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }finally{
           DB.closeStatement(st);
       }
    }

    @Override
    public List<Task> findAll() {
        List<Task> list = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM task WHERE id = "+loginView.peopleLogged.getId());
            
            while(rs.next()){
                Integer id = rs.getInt("id");
                String title = rs.getString("tittle");
                Date deadline = rs.getDate("deadline");
                String way = rs.getString("tittle");
                list.add(new Task(id, title, deadline, way));
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

    @Override
    public void deleteByTittle(String tittle) {
       PreparedStatement st = null;
       try{
           
           st = conn.prepareStatement("DELETE FROM task WHERE tittle = '"+tittle+"'");
           st.executeUpdate();
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, e.getMessage());
       }finally{
           DB.closeStatement(st);
        }
    }

    
    
    
}
