import java.sql.*;
public class DB_checkIn {

    public boolean verify_checkIn(String custom_roomNo, String custom_checkInDate, String custom_checkOutDate, String price, String availRoom) {

        String DB_URL = "jdbc:mysql://localhost/myhotel";
        String USERNAME = "root";
        String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "INSERT INTO checkin (customer_roomNo, customer_checkInDate, customer_checkOutDate, price, availability_Rooms) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, custom_roomNo);
            preparedStatement.setString(2, custom_checkInDate);
            preparedStatement.setString(3, custom_checkOutDate);
            preparedStatement.setString(4, price);
            preparedStatement.setString(5, availRoom);
            int insertData = preparedStatement.executeUpdate();

            if(insertData > 0) {
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