import java.sql.*;
import java.util.*;
import java.io.*;

public class Conn{
Connection conn;
Statement s;
public Conn(){
try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             String URL = "jdbc:mysql://localhost:3306/bankManagement";
             String User = "root";
             String Password = "Himanshi14";
             
           conn = DriverManager.getConnection(URL,User,Password);
             
           s = conn.createStatement();  


           
            
          
         }
         catch(Exception e){
             e.printStackTrace();
         }

}


}