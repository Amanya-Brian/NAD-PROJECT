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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author User
 */
public class EditHealthCentreHandler extends SimpleTagSupport {

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
                c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vac_tracker","root","");
                Statement s = c.createStatement();
                
                String query = "select * from health_centre";
                ResultSet rs = s.executeQuery(query);
                
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
//            throw new JspException("Error in EditHealthCentreHandler tag", ex);
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
