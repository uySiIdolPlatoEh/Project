import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AdminRooms extends JFrame implements ActionListener{

    private JPanel panel;
    private JTable adminRooms = new JTable();
    private JScrollPane scrollPane = new JScrollPane(adminRooms);
    private JButton back_btn;
    
    public AdminRooms(){
        this.setTitle("Rooms");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1100, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 1090, 950);

        scrollPane.setBounds(0, 0, 1080, 400);
        scrollPane.setViewportView(adminRooms);

        adminRooms.setFocusable(false);
        adminRooms.setCellSelectionEnabled(false);
        adminRooms.setEnabled(true);
        adminRooms.setColumnSelectionAllowed(false);
        adminRooms.setRowSelectionAllowed(true);
        adminRooms.setRowHeight(20);
        adminRooms.setGridColor(Color.BLACK);
        this.add(scrollPane);

        back_btn = new JButton("Back");
        back_btn.setBounds(10, 490, 100, 50);
        back_btn.setFocusable(false);
        back_btn.setBorder(null);
        back_btn.setBackground(Color.WHITE);
        back_btn.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(back_btn);

        back_btn.addActionListener(this);

        this.add(panel);
    }

    // database of rooms
    public void admin_Rooms() {
        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";
    
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM adminrooms";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet resultSet = pstmt.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
    
            int cols = rsmd.getColumnCount();
            String[] colsNames = new String[cols];
            
            DefaultTableModel admin_roomsModel = (DefaultTableModel) adminRooms.getModel();

            for (int i = 0; i < cols; i++) {
                colsNames[i] = rsmd.getColumnName(i + 1);
            }
            admin_roomsModel.setColumnIdentifiers(colsNames);

            String id, name, moblNum, gender, nationality, address, email, cardNum, cvcCode;
            while (resultSet.next()) {
                id = resultSet.getString("id");
                name = resultSet.getString("name");
                moblNum = String.valueOf(resultSet.getInt("moblNum"));
                gender = resultSet.getString("gender");
                nationality = resultSet.getString("nationality");
                address = resultSet.getString("address");
                email = resultSet.getString("email");
                cardNum = String.valueOf(resultSet.getInt("cardNum"));
                cvcCode = String.valueOf(resultSet.getInt("cvcNum"));
    
                String[] row = {id, name, moblNum, gender, nationality, address, email, cardNum, cvcCode};
                if(resultSet.getString("gender").equals("Male")){
                    admin_roomsModel.addRow(row);
                } else if(resultSet.getString("gender").equals("Female")){
                    admin_roomsModel.addRow(row);
                }
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back_btn){
            new AdminHomePage();
            this.setVisible(false);
        }
    }
}
