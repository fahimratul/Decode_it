package Model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import application.form.other.Addmember.UserProfilepic;

/**
 *
 * @author RATUL
 */
public class Userinfo {

    public UserProfilepic getProfile() {
        return profile;
    }

    public void setProfile(UserProfilepic profile) {
        this.profile = profile;
    }

    public  String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String Rank) {
        this.Rank = Rank;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    public String getPassword() {
        return pass;
    }

    public void setDescription(String description) {
        this.pass = description;
    }


    public Userinfo(String name, String Rank,String Email, Date date, String Mobile, String password,UserProfilepic profile) {
        this.name = name;
        this.Rank = Rank;
        this.email = Email;
        this.date = date;
        this.Mobile = Mobile;
        this.pass = password;
        this.profile = profile;
    }

    public Userinfo() {
        name="default";
    }

    private String name;
    private String Rank;
    private Date date;
    private String Mobile;
    private String pass;
    private UserProfilepic profile;
    private String email;

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        return new Object[]{this, email,Mobile,date == null ? "" : df.format(date)};
    }

    @Override
    public String toString() {
        return name;
    }
}
