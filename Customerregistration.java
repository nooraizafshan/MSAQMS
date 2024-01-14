
package msaqms;
import java.sql.Connection;
import java.util.regex.Pattern;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customerregistration {
    private String customerid;
    private String customername;
    private String customergmail;
    private String customersetpassword;
    private String confirmpassword;


    public void setCustomersetpassword(String customersetpassword) {
        this.customersetpassword = customersetpassword;
    }

    public String getCustomersetpassword() {
        return customersetpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
   

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setCustomerid(String customerid) {
        this.customerid = customerid;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setCustomergmail(String customergmail) {
        this.customergmail = customergmail;
    }

    

    public String getCustomerid() {
        return customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public String getCustomergmail() {
        return customergmail;
    }

   
    public void register(String customername,String customergmail,String customersetpassword,String confirmpassword)
    {
          Connection con;
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msaqms", "root", "562121");
               System.out.println("Connection Established");
                    String qry = "insert into registrationtable(customername,customergmail,customersetpassword,confirmpassword) values(?,?,?,?)";
                     PreparedStatement statement=con.prepareStatement(qry);
                      statement.setString(1,customername);
                       statement.setString(2, customergmail);
                     statement.setString(3,customersetpassword);
                     statement.setString(4,confirmpassword);
                 
                   statement.executeUpdate();
  
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Customerregistration.class.getName()).log(Level.SEVERE, null, ex);
        }
                          
                    
    }
   
public boolean validate(String gmail) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
            "[a-zA-Z0-9_+&-]+)@"+
            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    Pattern pattern = Pattern.compile(emailRegex);
    return pattern.matcher(gmail).matches();
}

public boolean Login(String customername, String confirmpassword) {
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/msaqms", "root", "562121");
         PreparedStatement stat = con.prepareStatement("SELECT * FROM registrationtable WHERE customername=? AND confirmpassword=?")) {
        stat.setString(1,customername);
        stat.setString(2, confirmpassword);

        try (ResultSet resultSet = stat.executeQuery()) {
            return resultSet.next();
        }
    } catch (SQLException ex) {
        Logger.getLogger(Customerregistration.class.getName()).log(Level.SEVERE, null, ex);
        return false;
    }
}
}