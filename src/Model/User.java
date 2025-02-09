/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.Connuser;
import raven.toast.Notifications;

/**
 *
 * @author RATUL
 */
public class User {
    private String name;
    private String rank;
    private String email;
    private String password;
    private String mobile;
    private String dob;
    private String role;

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDob() {
        return dob;
    }

    public String getRole() {
        return role;
    }
    
    public User(String name) {
        Connuser con= new Connuser();
        String query = "SELECT * FROM users WHERE username = ? ";
        try (PreparedStatement pstmt = con.con.prepareStatement(query)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()){
                    this.name = rs.getString("username");
                    this.rank = rs.getString("rank");
                    this.email = rs.getString("email");
                    this.dob = rs.getString("dob");
                    this.password = rs.getString("password");
                    this.role = rs.getString("role");
                    this.mobile = rs.getString("mobile");
                }
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,"Welcome "+ name);
            }
        } catch (SQLException e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER,"Error while reading user data");
        }

    }
}
