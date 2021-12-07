<%-- 
    Document   : taking-vaccine
    Created on : Dec 4, 2021, 9:51:04 AM
    Author     : Julius
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        
        <style>
            body,center{
                align-content: center;
                font-family: 'Nanum Gothic';
                justify-content: center;
                margin:auto;
                
                
            }
            form{
                position: relative;
                height: 50px;
                border-radius: 10px;
                text-align: center;
            }
        </style>
        
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registering those taking vaccine</title>
        
    </head>
    <body style="align-content: center">
    <center>
        
    
        <h1>REGISTER TO BE VACCINATED</h1>
        <form action="/VAC_TRACKER_G18/saveV" method="post">
                <table>
                <tr>
                    <td>NIN:</td>
                    <td><input type="text" name="nin"></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Health Centre:</td>

                    <td><select name="healthcentre" id="centres">
                            <option value="MULAGO HOSPITAL">MULAGO HOSPITAL</option>
                            <option value="UNIVERSITY HOSPITAL">UNIVERSITY HOSPITAL</option>
                            <option value="NORVIK HOSPITAL">NORVIK HOSPITAL</option>
                            <option value="CASE HOSPITAL">CASE HOSPITAL</option>
                            <option value="AAR HOSPITAL">AAR HOSPITAL</option>
                         </select>
                    </td>
                </tr>
                <tr>
                    <td>Date of Administration:</td>
                    <td><input type="date" name="dateofadministration"></td>
                </tr>
                <tr>
                    <td>Batch Number :</td>
                    <td><input type="text" name="batchnumber"></td>
                </tr>

                <tr>
                    <td>Vaccine Administered:</td>
                    <td><input type="text" name="vaccineadministered"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="submit" value="Save"></td>
                    <td><button><a href="/VAC_TRACKER_G18/allVaccinated">View Records Report</a></button></td>
                </tr>
            </table>
        </form>>
        
        
    </center></body>
</html>
