
package db;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection() throws Exception{
        if(conn == null){
            try{
                Properties prop = loadProperties();
                String url = prop.getProperty("dburl");
                conn = DriverManager.getConnection(url,prop);
            }catch(SQLException e){
               throw new db.dbException(e.getMessage());
            }               
        }
        return conn;
    }
    public static void closeConnection() throws Exception{
        if(conn != null){
            try{
                conn.close();
                conn = null;
            }catch(SQLException e){
                throw new db.dbException(e.getMessage());
            }
        }
    }
    
    public static Properties loadProperties() throws Exception{
        try(FileInputStream fip = new FileInputStream("src/db/db.properties")){
            Properties prop = new Properties();
            prop.load(fip);
            return prop;
        }catch(Exception e ){
            throw new db.dbException(e.getMessage());
        }
    }
    
       public static void closeStatement(Statement st){
        if(st != null){
            try{
                st.close();
                st = null;
            }catch(SQLException e){
                throw new db.dbException(e.getMessage());
            }
        }
    }
       
       public static void closeResultSet(ResultSet rs){
        if(rs!= null){
            try{
                rs.close();
                rs = null;
            }catch(SQLException e){
                throw new db.dbException(e.getMessage());
            }
        }
    }        
	
        
    
}
