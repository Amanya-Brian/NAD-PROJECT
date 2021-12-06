/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.health.health;

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

/**
 *
 * @author User
 */
public class HealthReport extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private String name;
    private String location;
    private String number_of_patients;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HealthReport</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h3>Health Centre Report:</h3>");
            
            try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection c;
            try {
                c = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vac_tracker","root","");
                Statement s = c.createStatement();
                
                String query = "select * from health_centre";
                ResultSet rs = s.executeQuery(query);
                
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr><th>Id</th><th>Name</th><th>Location</th><th>Number of patients</th><tr>");
                
                while(rs.next()){
                    out.println("<tr>"
                            + "<td>"+rs.getString("id")+"</td>"
                            + "<td>"+rs.getString("name")+"</td>"
                            + "<td>"+rs.getString("location")+"</td>"
                            + "<td>"+rs.getString("number_of_patients")+"</td>"
                            + "</tr>");
                }
                
                out.println("</table>");
                
            } catch (SQLException ex) {
               out.print(ex);
            }
            
        } catch (ClassNotFoundException ex) {
           out.println(ex);
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
