import java.sql.*;
import javax.swing.JOptionPane;

public class DB_login {  
    public boolean verify_login(String user, String password) {

        try {
            String URL = "jdbc:mysql://localhost:3306/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM login WHERE username = ? AND password = ?";
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