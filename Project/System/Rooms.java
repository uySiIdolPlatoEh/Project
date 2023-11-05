import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Rooms extends JFrame implements ActionListener {
    
    private JButton backBtn = new JButton("Back");
    private JButton checkin_btn;

    private JPanel roomPanel = new JPanel();
    private JTable roomsTable = new JTable();
    private JScrollPane roomsPane = new JScrollPane(roomsTable);
    
    public Rooms() {
        this.setTitle("Rooms");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1100, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        roomPanel.setBackground(Color.gray);
        roomPanel.setBounds(0, 0, 1200, 600);

        roomsPane.setBounds(0, 0, 1080, 400);
        roomsPane.setViewportView(roomsTable);
        
        roomsTable.setFocusable(false);
        roomsTable.setCellSelectionEnabled(false);
        roomsTable.setEnabled(true);
        roomsTable.setColumnSelectionAllowed(false);
        roomsTable.setRowSelectionAllowed(true);
        roomsTable.setRowHeight(20);
        roomsTable.setGridColor(Color.BLACK);
        roomsTable.setShowGrid(true);
        this.add(roomsPane);

        backBtn.setBounds(20,480, 100, 50);
        backBtn.setFocusable(false);
        backBtn.setBorder(null);
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.WHITE);
        this.add(backBtn);

        checkin_btn = new JButton("Check In");
        checkin_btn.setBounds(950, 480, 100, 50);
        checkin_btn.setBackground(Color.white);
        checkin_btn.setBorder(null);
        checkin_btn.setForeground(Color.BLACK);
        checkin_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        checkin_btn.setFocusable(false);
        this.add(checkin_btn);

        backBtn.addActionListener(this);
        checkin_btn.addActionListener(this);

        this.add(roomPanel);
    }

    //Database of rooms
    public void availRooms(){
        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM checkin";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery(); 
            ResultSetMetaData rsmd = rs.getMetaData();

            DefaultTableModel roomsModel = (DefaultTableModel) roomsTable.getModel();

            int cols = rsmd.getColumnCount();
            String[] colsName = new String[cols];
            
            for(int i = 0; i < cols; i++) {
                colsName[i] = rsmd.getColumnName(i + 1);
                roomsModel.setColumnIdentifiers(colsName);
            }

            String custom_id, custom_roomNo, custom_checkInDate, custom_checkOutDate, price, availability;
            while(rs.next()) {
                custom_id = rs.getString("customer_id");
                custom_roomNo = String.valueOf(rs.getInt("customer_roomNo"));
                custom_checkInDate = rs.getString("customer_checkInDate");
                custom_checkOutDate = rs.getString("customer_checkOutDate");
                price = String.valueOf(rs.getInt("price"));
                availability = rs.getString("availability_Rooms");

                String[] rowData = {custom_id, custom_roomNo, custom_checkInDate, custom_checkOutDate, price, availability};
                if(rs.getString("availability_Rooms").equals("no")){
                    roomsModel.addRow(rowData);
                } else if(rs.getString("availability_Rooms").equals("yes")) {
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("100")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("200")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("300")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("400")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("500")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("600")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("700")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("800")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("900")){
                    roomsModel.addRow(rowData);
                } else if(String.valueOf(rs.getInt("price")).equals("1000")){
                    roomsModel.addRow(rowData);
                }  

            }
        }catch(SQLException e1) {
            e1.printStackTrace();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn) {
            this.setVisible(false);
            System.out.println("Back from the homepage!");
            new HomePage();
        } else if(e.getSource() == checkin_btn){
            this.setVisible(false);
            new UserCheckIn();
        } 
    }
}