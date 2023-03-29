

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import static jdk.internal.editor.external.ExternalEditor.edit;
@WebServlet("/ViewServlet")  
public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='index.html'>Add New Customer</a>");  
        out.println("<h1>Customer List</h1>");  
          
        List<customer> list=customerDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Email</th><th>Number</th><th>Edit</th><th>Delete</th><th>Book Drone</th><th>View Booking</th></tr>");   
                 
        for(customer e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td> <td>"+e.getNumber()+"</td><td><a href='EditServlet?id="+e.getId()+"'>edit</a></td> <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td><td><a href='CustomerBooking.jsp'>Book</a></td><td><a href='CustomerBooking.jsp'>View</a></td></tr>");  
                  
                  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}  