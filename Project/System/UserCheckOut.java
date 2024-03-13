import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class UserCheckOut extends JFrame implements ActionListener {

    private JButton checkOutBtn = new JButton("Check Out");
    private JButton backBtn = new JButton("Back");

    private JPanel checkoutPanel = new JPanel();

    private JLabel id_lbl;
    private JLabel customerRoomNo;
    private JLabel customCheckOutDate_lbl;

    private JTextField id_fld;
    private JTextField customerRoomNoFld;
    private JTextField customCheckOutDate_fld;

    public UserCheckOut(){
        this.setTitle("Check Out");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        checkoutPanel.setBounds(0, 0, 700, 600);
        checkoutPanel.setBackground(Color.gray);

        id_lbl = new JLabel("ID");
        id_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        id_lbl.setBounds(45, 55, 200, 50);
        id_lbl.setForeground(Color.black);
        this.add(id_lbl);

        id_fld = new JTextField();
        id_fld.setBounds(180, 60, 200, 30);
        id_fld.setBorder(null);
        id_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        id_fld.setForeground(Color.black);
        this.add(id_fld);

        customerRoomNo = new JLabel("Room No");
        customerRoomNo.setBounds(45, 150, 200, 50);
        customerRoomNo.setFont(new Font("Arial", Font.PLAIN, 15));
        customerRoomNo.setForeground(Color.BLACK);
        this.add(customerRoomNo);
        
        customerRoomNoFld = new JTextField();
        customerRoomNoFld.setBounds(180, 160, 200, 30);
        customerRoomNoFld.setBorder(null);
        customerRoomNoFld.setFont(new Font("Poppins", Font.PLAIN, 12));
        customerRoomNoFld.setForeground(Color.black);
        this.add(customerRoomNoFld);

        customCheckOutDate_lbl = new JLabel("Check-out Date");
        customCheckOutDate_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        customCheckOutDate_lbl.setBounds(45, 100, 200, 50);
        customCheckOutDate_lbl.setForeground(Color.black);
        this.add(customCheckOutDate_lbl);

        customCheckOutDate_fld = new JTextField();
        customCheckOutDate_fld.setBounds(180, 110, 200, 30);
        customCheckOutDate_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        customCheckOutDate_fld.setBorder(null);
        customCheckOutDate_fld.setForeground(Color.BLACK);
        this.add(customCheckOutDate_fld);

        checkOutBtn.setBounds(230, 220, 100, 50);
        checkOutBtn.setFocusable(false);
        checkOutBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        checkOutBtn.setBorder(null);
        checkOutBtn.setForeground(Color.BLACK);
        checkOutBtn.setBackground(Color.WHITE);
        this.add(checkOutBtn);

        backBtn.setBounds(20, 290, 100, 50);
        backBtn.setFocusable(false);
        backBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        backBtn.setBorder(null);
        backBtn.setForeground(Color.BLACK);
        backBtn.setBackground(Color.white);
        this.add(backBtn);

        checkOutBtn.addActionListener(this);
        backBtn.addActionListener(this);
        
        this.add(checkoutPanel);

    }

    // database of checkout
    public boolean dbCheckOut(String customer_RoomNo, String custom_checkOut) {
        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "DELETE FROM checkin WHERE customer_roomNo = ? AND customer_checkOutDate = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, customer_RoomNo);
            preparedStatement.setString(2, custom_checkOut);
            int delete = preparedStatement.executeUpdate();
            
            if(delete > 0) {
                JOptionPane.showMessageDialog(this, "Data has been deleted", "Message", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "Data has not been deleted", "Message", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean db_checkOut(String id){
        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "DELETE FROM adminrooms WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, id);
            int delete = preparedStatement.executeUpdate();
            
            if(delete > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkOutBtn){
            UserCheckOut checkOut = new UserCheckOut();
            this.dispose();
            if(checkOut.db_checkOut(id_fld.getText()) == checkOut.dbCheckOut(customerRoomNoFld.getText(), customCheckOutDate_fld.getText())){
                new HomePage().setVisible(false);
            }
            id_fld.setText(""); 
            customerRoomNoFld.setText("");
            customCheckOutDate_fld.setText("");
        } else if(e.getSource() == backBtn) {
            this.setVisible(false);
            System.out.println("Back from the homepage!");
            new HomePage();
        }
    }

}