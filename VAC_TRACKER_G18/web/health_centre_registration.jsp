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
        <form action="save_health_center.jsp">
            <label>Health Center Name:</label>
            <input type="text" name="healthCenterName">
            
            <label>Location:</label>
            <input type="text" name="location">
            
            <label>Number of patients:</label>
            <input type="number" name="numberOfPatients">
        </form>
    </body>
</html>
