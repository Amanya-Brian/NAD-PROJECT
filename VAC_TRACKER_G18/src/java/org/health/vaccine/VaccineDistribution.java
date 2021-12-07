/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.health.vaccine;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class VaccineDistribution extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet VaccineDistribution</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //distributing vaccines
             DatabaseCon con = new DatabaseCon();
                Connection connection = con.getConnection();
                Statement st;
            try {
                st = connection.createStatement();
                ResultSet vaccines = st.executeQuery("SELECT amount   FROM vaccines;");
                int totalVaccine = 0;
                while(vaccines.next()){
                    totalVaccine += vaccines.getInt("amount");
                }
                
                //
                String[] hospitals = {"Mulago","Norvik","CASE","Unoversity Hospital","Lubaga"};
                
                out.println("<h3>Distribution of vaccines to the five hospitals</h3>");
                out.println("<table>");  
                out.println("<tr>");
                for (int i = 0; i < 5; i++) {
                    out.println("<td>"+hospitals[i] + "</td><td>"+totalVaccine/5+"</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                }
                out.println("</table>");
            } catch (SQLException ex) {
                Logger.getLogger(VaccineDistribution.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
