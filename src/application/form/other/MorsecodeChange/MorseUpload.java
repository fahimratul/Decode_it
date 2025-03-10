/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.form.other.MorsecodeChange;

import Model.Userinfo;
import connection.Connuser;
import raven.toast.Notifications;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RATUL
 */
public class MorseUpload {
    
        public static boolean search_username(String search) {
                try{
                        ResultSet r = null;
                        boolean flag;
                        Connuser c = new Connuser();
                        String query = "select * from morsecode where (Pattern like ?)";
                        PreparedStatement p = c.con.prepareStatement(query);
                        p.setString(1, "%" + search + "%");
                        r = p.executeQuery();
                        flag=r.next();
                        r.close();
                        c.con.close();
                        return flag;
                } catch (Exception e) {
                        Notifications.getInstance().show(Notifications.Type.ERROR, e.getMessage());
                }
                return false;
    }

        public static void create(String Pattern , String[] text) throws SQLException, IOException {
                Connuser c = new Connuser();
                String query= "INSERT INTO morsecode(Pattern,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                try {
                        PreparedStatement p = c.con.prepareStatement(query);
                        p.setString(1, Pattern);
                        for (int i = 0; i < 26; i++) {
                                p.setString(i + 2, text[i]);
                        }
                        p.execute();
                } finally {
                        c.con.close();
                }
        }




}
