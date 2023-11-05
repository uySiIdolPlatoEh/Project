import java.sql.*;
import javax.swing.JOptionPane;

public class DB_login {  
    public boolean verify_login(String user, String password) {
        String DB_URL = "jdbc:mysql://localhost/myhotel";
        String USERNAME = "root";
        String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM login WHERE username = ? AND password_text = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
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