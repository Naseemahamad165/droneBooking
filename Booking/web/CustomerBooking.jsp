<%-- 
    Document   : CustomerBooking
    Created on : 28-Mar-2023, 7:24:56 pm
    Author     : Naseem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
    </head>
    <body>
          <h1>Book New Drone</h1>  
<form action="BookServlet" method="post">  
<table>  
<tr><td>Enter Location:</td><td><input type="text" name="location"/></td></tr>    
<tr><td>Type Of Drone:</td><td><input type="text" name="drone"/></td></tr> 

<tr><td colspan="2"><input type="submit" value="Book"/></td></tr>  
</table>  
</form>
  
    </body>
</html>
