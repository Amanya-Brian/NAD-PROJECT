<%-- 
    Document   : vaccine
    Created on : Dec 4, 2021, 10:45:22 AM
    Author     : Hastings
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccines</title>
    </head>
    <body>
        <h1>VACCINES</h1>
        <form method="post" action="/VAC_TRACKER_G18/vaccineServlet">
            <label>Type of vaccine : </label>
            <input type="text" name="type"><br>
            <label>Amount of vaccines : </label>
            <input type="number" name="amount"><br>
            <label>Status of vaccines : </label>
            <input type="text" name="status"><br>
            <input type="submit" value="Submit">
        </form>
        
        <%@taglib uri="WEB-INF/tlds/vaccineTag_library.tld" prefix="vac" %>
        <%
            String type = request.getParameter("type");
            String status = request.getParameter("status");
            String amount = request.getParameter("amount");
            out.println("type "+type);
        %>
        <vac:vaccineTag type="${type}" status="${status}" amount="${amount}"></vac:vaccineTag>
        <a href="VaccineDistribution">Vaccine Distribution</a>
        <a href="index.jsp">Back</a>
    </body>
</html>
