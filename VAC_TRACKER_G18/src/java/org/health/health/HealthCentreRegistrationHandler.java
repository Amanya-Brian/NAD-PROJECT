/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.health;

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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class HealthCentreRegistrationHandler extends SimpleTagSupport {

    private String name;
    private String location;
    private String number_of_patients;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection c;
            try {
                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/vac_tracker_g18","root","");
                Statement s = c.createStatement();
                
                s.executeUpdate("insert into health_centre set name='"+name+"',location='"+location+"',number_of_patients='"+number_of_patients+"'");
                
                String query = "select * from health_centre";
                ResultSet rs = s.executeQuery(query);
                
                out.println("<table style='width:50%'>");
                out.println("<tr><th>Id</th><th>Name</th><th>Location</th><th>Number of patients</th><tr>");
                
                while(rs.next()){
                    out.println("<tr>"
                            + "<td>"+rs.getString("id")+"</td>"
                            + "<td>"+rs.getString("name")+"</td>"
                            + "<td>"+rs.getString("location")+"</td>"
                            + "<td>"+rs.getString("number_of_patients")+"</td>"
                            + "<td><a href='/VAC_TRACKER_G18/health_centre_registration.jsp?id="+rs.getString("id")+"&name="+rs.getString("name")+"&location="+rs.getString("location")+"&number_of_patients="+rs.getString("number_of_patients")+"'>Edit</a></td>"
                            + "</tr>");
                }
                
                out.println("</table>");
                
            } catch (SQLException ex) {
               out.print(ex);
            }
            
        } catch (ClassNotFoundException ex) {
           out.println(ex);
        }
        
//        try {
//            // TODO: insert code to write html before writing the body content.
//            // e.g.:
//            //
//            // out.println("<strong>" + attribute_1 + "</strong>");
//            // out.println("    <blockquote>");
//
//            JspFragment f = getJspBody();
//            if (f != null) {
//                f.invoke(out);
//            }
//
//            // TODO: insert code to write html after writing the body content.
//            // e.g.:
//            //
//            // out.println("    </blockquote>");
//        } catch (java.io.IOException ex) {
//            throw new JspException("Error in HealthCentreRegistrationHandler tag", ex);
//        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setNumber_of_patients(String number_of_patients) {
        this.number_of_patients = number_of_patients;
    }
    
}
