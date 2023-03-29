


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Naseem
 */
public class customerDao {
     public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booking","root","");  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(customer e){  
        int status=0;  
        try{  
            Connection con=customerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into customer(Customer_name,Customer_email,Customer_number) values (?,?,?)");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
            ps.setString(3, e.getNumber());
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(customer e){  
        int status=0;  
        try{  
            Connection con=customerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update customer set Customer_name=?,Customer_email=?,Customer_number=? where Customer_id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getEmail());  
           ps.setString(3, e.getNumber());
            ps.setInt(4,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=customerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from customer where Customer_id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static customer getCustomerById(int id){  
        customer e=new customer();  
          
        try{  
            Connection con=customerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer where Customer_id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setEmail(rs.getString(3));
                e.setNumber(rs.getString(4));
                 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<customer> getAllEmployees(){  
        List<customer> list=new ArrayList<customer>();  
          
        try{  
            Connection con=customerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from customer");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                customer e=new customer();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));    
                e.setEmail(rs.getString(3));  
                e.setNumber(rs.getString(4));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
    
}
