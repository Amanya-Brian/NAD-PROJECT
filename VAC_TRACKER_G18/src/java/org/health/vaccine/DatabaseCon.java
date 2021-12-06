/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.health.vaccine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Home
 */
class DatabaseCon {
    
 private String user = "root";
    private String password  ="root";
    private String jdbcdriver = "com.mysql.jdbc.Driver";
    private String jdbcConnection = "jdbc:mysql://localhost:8889/VAC_TRACKER_G18";
    

    
    //connection
    public Connection getConnection(){
        Connection con = null;
        try{
              Class.forName(this.jdbcdriver);
              
              try{
                   con = DriverManager.getConnection(this.jdbcConnection,this.user,this.password);
                   
              }
              catch(SQLException e){
                
                  System.out.println("Connect failed : " +e.getMessage());
              }
        }
        catch(ClassNotFoundException ex){
            System.out.println("Error : " +ex.getMessage()); 
            
        }
        
        return con;
        
    }

    
    
}

