/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;


import java.sql.*;

/**
 *
 * @author RATUL
 */
public class Connuser {
    public Connection con;
    public Statement st;
    public Connuser(){
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/decodeit_userinfo","root","LongLive@1");
            st=con.createStatement();
        }
        catch (Exception e){

        }
    }
}
