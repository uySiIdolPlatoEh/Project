import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBAdminCheckIn {

    public boolean adminCheckIn(String custom_name, String custom_mobile_num, String custom_gender, String custom_nationality, String custom_address, String custom_email, String cardNumber, String cvcNumber){

        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO adminrooms (name, moblNum, gender, nationality, address, email, cardNum, cvcNum) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, custom_name);
            preparedStatement.setString(2, custom_mobile_num);
            preparedStatement.setString(3, custom_gender);
            preparedStatement.setString(4, custom_nationality);
            preparedStatement.setString(5, custom_address);
            preparedStatement.setString(6, custom_email);
            preparedStatement.setString(7, cardNumber);
            preparedStatement.setString(8, cvcNumber);
            int data = preparedStatement.executeUpdate();

            if(data > 0){
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}