/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.health.administration;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Julius
 */
public class allVaccinated extends HttpServlet {

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
            out.println("<title>Servlet allVaccinated</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table>"
                    + "<tr>"
                    + ""
                    + "<td><h1> All Vaccinated Individuals Report</h1></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td></td>"
                    + "<td><button><a href=\"taking-vaccine.jsp\">RETURN</a></button></td>"
                    + "</tr>"
                    + "</table>");
//            out.println("<h1> All Vaccinated Individuals Report</h1>");
//            out.println("<button><a href=\"/taking-vaccine.jsp\">RETURN</a></button>");

            //retrieve from the database vaccinated
             try{
                
                Class.forName("com.mysql.jdbc.Driver");
                //make the db connection 
                try{
                 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/VAC_TRACKER_G18","root","");
                  //statements
                  Statement st = con.createStatement();
                  ResultSet rs = st.executeQuery("select * from vaccinated");
                  
                  out.println("<table border=1>"
                          +"<tr>"
                          +"<th>VACCINATION ID </th>"
                          +"<th>NIN </th>"
                          +"<th>Name </th>"
                          +"<th>Health_Centre </th>"
                          +"<th>Date_of_Administration </th>"
                          +"<th>Batch Number </th>"
                          +"<th>Vaccine_Administered </th>"
                          +"</tr>"
                     );
                  
                  while (rs.next()){
                     out.println("<tr>"
                             + "<td>"+rs.getString("id")+"</td>"
                             + "<td>"+rs.getString("nin")+"</td>"
                             + "<td>"+rs.getString("name")+"</td>"
                             + "<td>"+rs.getString("healthcentre")+"</td>"
                             + "<td>"+rs.getString("date_of_administration")+"</td>"
                             + "<td>"+rs.getString("batch_number")+"</td>"
                             + "<td>"+rs.getString("vaccine_administered")+"</td>"        
//                             + "<td><a href='/Shop/registrationform?id="+rs.getInt("id")+"'>Edit</a></td>"   
                             + "</tr>");
                  }
                  out.println("</table>");
                  //RETURM BUTTON 
                }catch(SQLException e){
                    out.println(e);
                }
            }catch(ClassNotFoundException e){
                out.println("The error is :"+e);
        
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
