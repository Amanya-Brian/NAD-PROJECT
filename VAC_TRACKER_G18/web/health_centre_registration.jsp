<%-- 
    Document   : health_centre_registration
    Created on : Dec 3, 2021, 5:09:57 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Health Center</title>
    </head>
    <body>
        
        <% 
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String number_of_patients = request.getParameter("number_of_patients");
        %>
        
        <form action="/VAC_TRACKER_G18/HealthCentreRegistration" method="POST">

            <% if(id==null){ %>
            <label>Health Center Name:</label>
            <input type="text" name="name"><br/>
            
            <label>Location:</label>
            <input type="text" name="location"><br/>
            
            <label>Number of patients:</label>
            <input type="text" name="numberOfPatients"><br/>
            <input type='submit' value='Register Health Center'>
            
            <% }else{ %>
            
            <label>Health Center Name:</label>
            <input type="text" name="name" value="<%=name%>"><br/>
            
            <label>Location:</label>
            <input type="text" name="location" value="<%=location%>"><br/>
            
            <label>Number of patients:</label>
            <input type="text" name="numberOfPatients" value="<%=number_of_patients%>"><br/>
            <input type='submit' value='Update Health Center'>
            <% } %>
        </form>
        
        <a href="/VAC_TRACKER_G18/HealthReport">View Report</a>
    </body>
</html>
