<%-- 
    Document   : certificateView
    Created on : Dec 5, 2021, 8:32:05 PM
    Author     : Julius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MOH COVID-19 CERTIFICATE</h1>
       
        <%
            String name = request.getParameter("name");
            String nin = request.getParameter("nin");
            String healthcentre = request.getParameter("healthcentre");
            String dateofadministration = request.getParameter("dateofadministration");
            String batchnumber = request.getParameter("batchnumber");
            String vaccineadministered = request.getParameter("vaccineadministered");
            
//            out.println("batch number: "+batchnumber);
        
        %>
        
<!--             bean to display certificate-->
        <jsp:useBean id="v" class="org.health.administration.vaccinatedTagHandler"></jsp:useBean>
        
        
        <!--        set the value of the student-->
        <jsp:setProperty name="v" property="name" value="${name}"></jsp:setProperty>
        <jsp:setProperty name="v" property="nin" value="${nin}"></jsp:setProperty>
        <jsp:setProperty name="v" property="healthcentre" value="${healthcentre}"></jsp:setProperty>
        <jsp:setProperty name="v" property="dateofadministration" value="${dateofadministration}"></jsp:setProperty>
        <jsp:setProperty name="v" property="batchnumber" value="${batchnumber}"></jsp:setProperty>
        <jsp:setProperty name="v" property="vaccineadministered" value="${vaccineadministered}"></jsp:setProperty>
        
<!--        get the value from jbean class-->
        <table>
            <tr>
                <td>NAME:</td>
                <td><jsp:getProperty name="v" property="name"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>NIN:</td>
                <td><jsp:getProperty name="v" property="nin"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>Health_Centre:</td>
                <td><jsp:getProperty name="v" property="healthcentre"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>Date_of_Administration:</td>
                <td><jsp:getProperty name="v" property="dateofadministration"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>Batch_Number:</td>
                <td><jsp:getProperty name="v" property="batchnumber"></jsp:getProperty></td>
            </tr>
            <tr>
                <td>Vaccine_Administered:</td>
                <td><jsp:getProperty name="v" property="vaccineadministered"></jsp:getProperty></td>
            </tr>
             
             <tr>
                    <td></td>
                    <td><button><a href="/VAC_TRACKER_G18/taking-vaccine.jsp">BACK TO VACCINATION PAGE</a></button></td>
                    <td></td>
              </tr>
        </table>
        
         <%@taglib uri="WEB-INF/tlds/vaccinated_library.tld" prefix="a" %>
         <a:vaccinatedTagHandler nin="${nin}" name="${name}" healthcentre="${healthcentre}" dateofadministration="${dateofadministration}" 
             batchnumber="${batchnumber}" vaccineadministered="${vaccineadministered}"></a:vaccinatedTagHandler>
             
         
    </body>
</html>
