/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.form.other.Setting;

import connection.Connuser;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RATUL
 */
public class LoadData {
        public static List<String> getlistMorse(){
        ResultSet r = null;
        List<String> list = new ArrayList<>();
        try {
            Connuser c = new Connuser();
            String query = "SELECT * FROM morsecode";
            PreparedStatement p = c.con.prepareStatement(query);
            r = p.executeQuery();
            while (r.next()) {
                String pat = r.getString("Pattern");
                list.add(pat);
            }

            r.close();
            c.con.close();
            return list;
        }catch(SQLException e){
            list.add("Defualt");
            return list;
        }
        
    }
        
        public static List<String> getlistRSA(){
        ResultSet r = null;
        List<String> list = new ArrayList<>();
        try {
            Connuser c = new Connuser();
            String query = "SELECT * FROM rsa";
            PreparedStatement p = c.con.prepareStatement(query);
            r = p.executeQuery();
            while (r.next()) {
                String pat = r.getString("Pattern");
                list.add(pat);
            }

            r.close();
            c.con.close();
            return list;
        }catch(SQLException e){
            list.add("Defualt");
            return list;
        }
        
    }
        public static List<String> getlistAES(){
        ResultSet r = null;
        List<String> list = new ArrayList<>();
        try {
            Connuser c = new Connuser();
            String query = "SELECT * FROM aes";
            PreparedStatement p = c.con.prepareStatement(query);
            r = p.executeQuery();
            while (r.next()) {
                String pat = r.getString("Pattern");
                list.add(pat);
            }

            r.close();
            c.con.close();
            return list;
        }catch(SQLException e){
            list.add("Defualt");
            return list;
        }
        
    }
}
