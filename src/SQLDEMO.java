/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manan
 */
import java.sql.*;
public class SQLDEMO {
    PreparedStatement pst;
    public Connection con;
    ResultSet rst;
    public void Connect(){
        try{
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           // con=DriverManager.getConnection("Jdbc:odbc:mydsn");
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=dbclub;integratedSecurity=true;");
            System.out.println("Connected");
        }
        catch(Exception ex){
            System.out.println("Error "+ ex);
        }
    }
    public void Disconnect(){
        try{
            con.close();
            }
        catch(Exception ex){
            System.out.println("Error "+ ex);
        }
    }
    void show(){
        Connect();
        try{
            pst=con.prepareStatement("Select * from tbclub");
            rst=pst.executeQuery();
            while(rst.next()){
                System.out.println("StudentId ="+rst.getString(1));
            }
        rst.close();
        
        }
        catch(Exception ex){
            System.out.println("Error "+ex);
        }
        Disconnect();
    }
    public static void main(String a[]){
        SQLDEMO sql=new SQLDEMO();
        sql.show();
    }
}
