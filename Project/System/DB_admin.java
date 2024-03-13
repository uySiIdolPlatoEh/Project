import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DB_admin {

    public boolean verifyAdmin(String admin_user, String admin_pass){
        String DB_URL = "jdbc:mysql://localhost/myhotel";
        String USERNAME = "root";
        String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM admin WHERE admin_username = ? AND admin_pass = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, admin_user);
            preparedStatement.setString(2, admin_pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()){
                JOptionPane.showMessageDialog(null, "User Found", "Message", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                System.out.println("User not found");
                JOptionPane.showMessageDialog(null, "Password Invalid", "Message", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("Connection failed");
            return false;
        } 
    }
}
