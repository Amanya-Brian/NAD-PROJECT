<%-- 
    Document : Booking.jsp
    Created on : Dec 5, 2021, 2:39:53 PM
    Author     : Jovan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Booking Table</h1>
        <table>
            <form action="" method="Post" >
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="name"</>td><!-- comment -->
                </tr>
                <tr>
                    <td>Place of Vaccination</td>
                    <td><input type="text" name="place"></td>
                </tr>
                <tr>
                    <td>Vaccination Date</td>
                    <td><input type="Date" name="Date"></td><!-- comment -->
                </tr>
                <tr>
                    <td>Time>
                    <td><input type="time" name="time"></td>
                </tr>  
                <tr>
                    <td>Vaccine</td><!-- comment -->
                    <td><input type="text" name="text"></td>
                </tr>
            </form>
        </table>
          
    </body>
</html>
