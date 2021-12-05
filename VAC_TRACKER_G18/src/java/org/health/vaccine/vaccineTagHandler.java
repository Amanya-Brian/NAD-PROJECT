/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.vaccine;

import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.JspFragment;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Home
 */
public class vaccineTagHandler extends SimpleTagSupport {
    
    private String tableName;
    private String values;
    
    DatabaseCon con = new DatabaseCon();
    Connection connection = con.getConnection();
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            String[] newValues = values.split(",");
            try {
                //creating a statement
                Statement st = connection.createStatement();
                
                if(newValues.length > 1){
                    st.executeUpdate("INSERT INTO `vaccineTable` (`type`, `amount`, `status`) "
                  + "VALUES ('"+newValues[1]+"', '"+newValues[0]+"', NULL);");
                }
            }catch (SQLException ex) {
                out.println("Failed : " + ex);
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in vaccineTagHandler tag", ex);
        }
    }
    public void setTable(String tableName) {
        this.tableName = tableName;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
