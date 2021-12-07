/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.administration;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Julius
 */
public class vaccinatedTagHandler extends SimpleTagSupport {

    private String nin;
    private String name;
    private String healthcentre;
    private String dateofadministration;
    private String batchnumber;
    private String vaccineadministered;
    final int target = 100;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException,IOException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
               Class.forName("com.mysql.jdbc.Driver");
                //make db connection
                try{ 
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VAC_TRACKER_G18","root","");
                    Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    //Adding data to the db through sql statement
                    st.executeUpdate("insert into vaccinated set nin='"+nin+"',name='"+name+"',healthcentre='"+healthcentre+"',"
                       + "date_of_administration='"+dateofadministration+"',batch_number='"+batchnumber+"',vaccine_administered='"+vaccineadministered+"'");
                    
//                    int id = 0;
                    String query = "select * from vaccinated";
                    ResultSet rs = st.executeQuery(query);
                    rs.last();
                  
                        out.println("<h3>MOH has vaccinated "+rs.getInt("id")+" so far. We require "+(target-rs.getInt("id"))+" to hit our target of "+ target+"</h3>");
                    
                    if(!nin.isEmpty()){
                    out.println("The record has been entered successfully.");
                    }
                }catch(SQLException e){
                    out.println(e);
                }
                
           
        } catch (ClassNotFoundException e) {
            out.println(e);
        }
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthcentre(String healthcentre) {
        this.healthcentre = healthcentre;
    }

    public void setDateofadministration(String dateofadministration) {
        this.dateofadministration = dateofadministration;
    }

    public void setBatchnumber(String batchnumber) {
        this.batchnumber = batchnumber;
    }

    public void setVaccineadministered(String vaccineadministered) {
        this.vaccineadministered = vaccineadministered;
    }
    
    public String getName(){
        return this.name;
    }
    public String getNin(){
        return this.nin;
    }
    public String getHealthcentre(){
        return this.healthcentre ;
    }
    public String getDateofadministration(){
        return this.dateofadministration;
    }
    public String getBatchnumber(){
        return this.batchnumber ;
    }
    public String getVaccineadministered(){
        return this.vaccineadministered;
    }
}
