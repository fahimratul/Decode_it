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
import net.coobird.thumbnailator.Thumbnails;
import connection.DatabaseConnection;
import Model.Userinfo;
import application.form.other.Addmember.UserProfilepic;

/**
 *
 * @author RAVEN
 */
public class Uploaddatabase {

    public List<Userinfo> getAll() throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from usersdata");
            r = p.executeQuery();
            List<Userinfo> list = new ArrayList<>();
            while (r.next()) {
                String name = r.getString("username");
                String rank = r.getString("rankofuser");
                String email = r.getString("email");
                Date date = r.getDate("dob");
                String mobile = r.getString("mobile");
                UserProfilepic profile = new UserProfilepic(r.getBytes("pic"));
                list.add(new Userinfo(name,rank, email,date,mobile,"",profile));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public List<Userinfo> search(String search) throws SQLException {
        Connection con = null;
        PreparedStatement p = null;
        ResultSet r = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("select * from usersdata where (username like ? or rankofuser like ? or mobile like ?)");
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
                list.add(new Userinfo(name,rank, email,date,mobile,"",profile));
            }
            return list;
        } finally {
            DatabaseConnection.getInstance().close(r, p, con);
        }
    }

    public void create(Userinfo data) throws SQLException, IOException {
        Connection con = null;
        PreparedStatement p = null;
        try {
            con = DatabaseConnection.getInstance().createConnection();
            p = con.prepareStatement("INSERT INTO usersdata(username, rankofuser, email, dob, mobile,pass, pic) VALUES(?,?,?,?,?,?,?)");
            p.setString(1, data.getName());
            p.setString(2, data.getRank());
            p.setString(3, data.getEmail());
            p.setDate(4, data.getDate());
            p.setString(5, data.getMobile());
            p.setString(6, data.getDescription());
            if (data.getProfile() != null) {
                p.setBytes(7, getByteImage(data.getProfile().getPath()));
            } else {
                p.setBytes(7, null);
            }
            p.execute();
        } finally {
            DatabaseConnection.getInstance().close(p, con);
        }
    }
//
//    public void delete(int id) throws SQLException {
//        Connection con = null;
//        PreparedStatement p = null;
//        try {
//            con = DatabaseConnection.getInstance().createConnection();
//            p = con.prepareStatement("delete from employee where ");
//            p.setInt(1, id);
//            p.execute();
//        } finally {
//            DatabaseConnection.getInstance().close(p, con);
//        }
//    }

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
