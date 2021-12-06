<%-- 
    Document   : save_health_center
    Created on : Dec 3, 2021, 8:16:11 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Health Center</title>
    </head>
    <body>
        <p>Health Center Registered successfully.</p>
        <h1>Registered Health Centres:</h1>
        <% 
        
        String name = request.getParameter("name");
        String location = request.getParameter("location");
        String number_of_patients = request.getParameter("number_of_patients");

        %>
        
        <%@taglib uri="WEB-INF/tlds/healthCentreRegistration.tld" prefix="health" %>
        <health:HealthCentreRegistrationHandler name="${name}" location="${location}" number_of_patients="${number_of_patients}"></health:HealthCentreRegistrationHandler>
        <a href="health_centre_registration.jsp">Register Health Center</a>
    </body>
</html>
