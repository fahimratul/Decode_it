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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Userinfo(String name, String Rank, Date date, double salary, String description,UserProfilepic profile) {
        this.name = name;
        this.Rank = Rank;
        this.date = date;
        this.salary = salary;
        this.description = description;
        this.profile = profile;
    }

    public Userinfo() {
    }

    private String name;
    private String Rank;
    private Date date;
    private double salary;
    private String description;
    private UserProfilepic profile;

    public Object[] toTableRow(int rowNum) {
        DateFormat df = new SimpleDateFormat("dd-MMMM-yyyy");
        NumberFormat nf = new DecimalFormat("$ #,##0.##");
        return new Object[]{false, rowNum, this, date == null ? "" : df.format(date), nf.format(salary), description};
    }

    @Override
    public String toString() {
        return name;
    }
}
