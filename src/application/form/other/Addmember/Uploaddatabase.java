package application.form.other.Addmember;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

import application.Application;
import connection.Connuser;
import net.coobird.thumbnailator.Thumbnails;
import Model.Userinfo;
import application.form.other.Addmember.UserProfilepic;
import raven.alerts.MessageAlerts;
import raven.toast.Notifications;

/**
 *
 * @author RAVEN
 */
public class Uploaddatabase {

    public List<Userinfo> getAll() throws SQLException {
        ResultSet r = null;
        try {
            Connuser c = new Connuser();
            String query = "SELECT * FROM usersdata";
            PreparedStatement p = c.con.prepareStatement(query);
            r = p.executeQuery();
            List<Userinfo> list = new ArrayList<>();
            while (r.next()) {
                String name = r.getString("username");
                String rank = r.getString("rankofuser");
                String email = r.getString("email");
                Date date = r.getDate("dob");
                String mobile = r.getString("mobile");
                UserProfilepic profile = new UserProfilepic(r.getBytes("pic"));
                list.add(new Userinfo(name.toUpperCase(),rank, email,date,mobile,"",profile));
            }

            r.close();
            c.con.close();
            return list;
        }
        finally {
            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER,"All MEMBER DATA IS UPLOADED");
        }
    }

    public boolean search_username(String search) throws SQLException {
        ResultSet r = null;
        boolean flag;
        Connuser c = new Connuser();
        String query = "select * from usersdata where (username like ?)";
        PreparedStatement p = c.con.prepareStatement(query);
        p.setString(1, "%" + search + "%");
        r = p.executeQuery();
        flag=r.next();
        r.close();
        c.con.close();
        return flag;
    }
    
    
    public List<Userinfo> search(String search) throws SQLException {
        ResultSet r = null;
        try {
            Connuser c = new Connuser();
            String query = "select * from usersdata where (username like ? or rankofuser like ? or mobile like ?)";
            PreparedStatement p = c.con.prepareStatement(query);
            p.setString(1, "%" + search + "%");
            p.setString(2, "%" + search + "%");
            p.setString(3, "%" + search + "%");
            r = p.executeQuery();
            List<Userinfo> list = new ArrayList<>();
            while (r.next()) {
                String name = r.getString("username");
                String rank = r.getString("rankofuser");
                String email = r.getString("email");
                Date date = r.getDate("dob");
                String mobile = r.getString("mobile");
                UserProfilepic profile = new UserProfilepic(r.getBytes("pic"));
                list.add(new Userinfo(name.toUpperCase(),rank, email,date,mobile,"",profile));
            }

            r.close();
            c.con.close();
            return list;
        }
        finally {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER,"SHOWING THE SEARCH RESULTS OF "+search);
        }
    }

    public void create(Userinfo data) throws SQLException, IOException {
        Connuser c = new Connuser();
        String query= "INSERT INTO usersdata(username, rankofuser, email, dob, mobile,pass, pic) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement p = c.con.prepareStatement(query);

            p.setString(1, data.getName());
            p.setString(2, data.getRank());
            p.setString(3, data.getEmail());
            p.setDate(4, data.getDate());
            p.setString(5, data.getMobile());
            p.setString(6, data.getPassword());
            if (data.getProfile() != null) {
                p.setBytes(7, getByteImage(data.getProfile().getPath()));
            } else {
                p.setBytes(7, null);
            }
            p.execute();
        } finally {
            c.con.close();
        }
    }


    public  void getUser(String username) throws SQLException {
        ResultSet r = null;
        try {
            Connuser c = new Connuser();
            String query = "SELECT * FROM usersdata WHERE username = ?";

            PreparedStatement p = c.con.prepareStatement(query);
            p.setString(1, username);
            r = p.executeQuery();
            while (r.next()) {
                String name = r.getString("username");
                String rank = r.getString("rankofuser");
                String email = r.getString("email");
                Date date = r.getDate("dob");
                String mobile = r.getString("mobile");
                UserProfilepic profile = new UserProfilepic(r.getBytes("pic"));
                Application.user=new Userinfo(name.toUpperCase(),rank, email,date,mobile,"",profile);
            }
            r.close();
            c.con.close();
        }
        finally {
            MessageAlerts.getInstance().showMessage("WELCOME", "WELCOME "+username+" TO OUR APP DECODE IT. HOPE YOU WILL ENJOY OUR SYSTEM. FOR ANY HELP CONTACT WITH THE ADMIN. THANK YOU", MessageAlerts.MessageType.SUCCESS);
        }
    }
    
    private byte[] getByteImage(File file) throws IOException {
        BufferedImage image = Thumbnails.of(file)
                .width(500)
                .outputQuality(0.7f)
                .asBufferedImage();
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", out);
            byte[] data = out.toByteArray();
            return data;
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
