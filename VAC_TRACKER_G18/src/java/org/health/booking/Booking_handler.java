/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/TagHandler.java to edit this template
 */
package org.health.booking;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Jovan
 */
public class Booking_handler extends SimpleTagSupport {

    private String Name;
    private String PlaceofVaccination;
    private String VaccinationDate;
    private String Time;
    private String Vaccine;

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
         
        
            try {
            

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VAC_TRACKER_G18","root","");
            Statement st = con.createStatement();
            st.executeUpdate("insert into booking set name='"+Name+"',place='"+PlaceofVaccination+"',date='"+VaccinationDate+"',time='"+Time+"',vaccine='"+Vaccine+"'");
            
            

        } catch (SQLException ex) {
            out.println(ex);
        }
    }catch (ClassNotFoundException ex) {
            out.println( ex);
    }
    }    

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPlaceofVaccination(String PlaceofVaccination) {
        this.PlaceofVaccination = PlaceofVaccination;
    }

    public void setVaccinationDate(String VaccinationDate) {
        this.VaccinationDate = VaccinationDate;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public void setVaccine(String Vaccine) {
        this.Vaccine = Vaccine;
    }
    
}
