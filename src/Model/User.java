/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import connection.Connuser;
import raven.toast.Notifications;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    
    public User(ResultSet rs) {
        try {
            name = rs.getString("username");
            rank = rs.getString("rank");
            email = rs.getString("email");
            password = rs.getString("password");
            mobile = rs.getString("mobile");
            dob = rs.getString("dob");
            role = rs.getString("role");
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error in User Model");
        }
    }
}
