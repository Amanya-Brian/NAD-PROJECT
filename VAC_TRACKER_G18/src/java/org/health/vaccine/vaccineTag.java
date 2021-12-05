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
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Home
 */
public class vaccineTag extends SimpleTagSupport {

    private String type;
    private String status;
    private int amount;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
            
            try {
                //data entry
                DatabaseCon con = new DatabaseCon();
                Connection connection = con.getConnection();
                Statement st;
                st = connection.createStatement();
                if(type.length()>=1){
                    st.execute("INSERT INTO `vaccines` (`type`, `status`,`amount`) " + "VALUES ('"+type+"', '"+status+"','"+amount+"');");
                }
            } catch (SQLException ex) {
                out.println("Error inserting records : "+ex);
            }
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in vaccineTag tag", ex);
        }
    }
    
    
    

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
