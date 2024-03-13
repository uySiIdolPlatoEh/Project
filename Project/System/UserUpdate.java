import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UserUpdate extends JFrame implements ActionListener {

    private JPanel panel;

    private JLabel name_lbl;
    private JLabel mobileNUm_lbl;
    private JLabel gender_lbl;
    private JLabel nationality_lbl;
    private JLabel address_lbl;
    private JLabel email_lbl;
   
    private JTextField name_field;
    private JTextField mobile_field;
    private JTextField gender_fld;
    private JTextField nationality_fld;
    private JTextField address_fld;
    private JTextField email_fld;

    private JButton backButton;
    private JButton updateButton;
    private JButton clearButton;

    public UserUpdate(){
        this.setTitle("Update Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 800, 900); 
        
        name_lbl = new JLabel("Name", SwingConstants.CENTER);
        name_lbl.setBounds(-20, -180, 400, 500);
        name_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        name_lbl.setForeground(Color.BLACK);
        this.add(name_lbl);
        
        name_field = new JTextField();
        name_field.setBounds(160, 80, 250, 30);
        name_field.setBorder(null);
        name_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        name_field.setForeground(Color.BLACK);
        this.add(name_field);

        mobileNUm_lbl = new JLabel("Mobile Number", SwingConstants.CENTER);
        mobileNUm_lbl.setBounds(8, -125, 400, 500);
        mobileNUm_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        mobileNUm_lbl.setForeground(Color.BLACK);
        this.add(mobileNUm_lbl);

        mobile_field = new JTextField();
        mobile_field.setBounds(160, 135, 250, 30);
        mobile_field.setBorder(null);
        mobile_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        name_field.setForeground(Color.BLACK);
        this.add(mobile_field);

        gender_lbl = new JLabel("Gender", SwingConstants.CENTER);
        gender_lbl.setBounds(-18, -70, 400, 500);
        gender_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        gender_lbl.setForeground(Color.BLACK);
        this.add(gender_lbl);

        gender_fld = new JTextField();
        gender_fld.setBounds(160, 190, 250, 30);
        gender_fld.setBorder(null);
        gender_fld.setForeground(Color.BLACK);
        gender_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        this.add(gender_fld);

        nationality_lbl = new JLabel("Nationality", SwingConstants.CENTER);
        nationality_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        nationality_lbl.setBounds(-8, -15, 400, 500);
        nationality_lbl.setForeground(Color.BLACK);
        this.add(nationality_lbl);

        nationality_fld = new JTextField();
        nationality_fld.setBounds(160, 245, 250, 30);
        nationality_fld.setBorder(null);
        nationality_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        nationality_fld.setForeground(Color.black);
        this.add(nationality_fld);

        address_lbl = new JLabel("Address" ,SwingConstants.CENTER);
        address_lbl.setForeground(Color.BLACK);
        address_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        address_lbl.setBounds(-12, 40, 400, 500);
        this.add(address_lbl);

        address_fld = new JTextField();
        address_fld.setBounds(160, 300, 250, 30);
        address_fld.setBorder(null);
        address_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        address_fld.setForeground(Color.BLACK);
        this.add(address_fld);

        email_lbl = new JLabel("Email", SwingConstants.CENTER);
        email_lbl.setBounds(-20, 95, 400, 500);
        email_lbl.setFont(new Font("Arial", Font.PLAIN, 15));
        email_lbl.setForeground(Color.BLACK);
        this.add(email_lbl);

        email_fld = new JTextField();
        email_fld.setBounds(160, 355, 250, 30);
        email_fld.setBorder(null);
        email_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        email_fld.setForeground(Color.BLACK);
        this.add(email_fld);

        backButton = new JButton("Back");
        backButton.setBounds(10, 500, 100, 50);
        backButton.setBackground(Color.white);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusable(false);
        backButton.setBorder(null);
        this.add(backButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(470, 500, 100, 50);
        updateButton.setBackground(Color.white);
        updateButton.setForeground(Color.BLACK);
        updateButton.setFocusable(false);
        updateButton.setBorder(null);
        this.add(updateButton);

        clearButton = new JButton("Clear Fields");
        clearButton.setBackground(Color.WHITE);
        clearButton.setFocusable(false);
        clearButton.setBorder(null);
        clearButton.setBounds(230, 500, 100, 50);
        clearButton.setForeground(Color.BLACK);
        this.add(clearButton);

        backButton.addActionListener(this);
        clearButton.addActionListener(this);
        updateButton.addActionListener(this);

        this.add(panel);
    }

    // database for updating details
    public boolean DB_updateDetails(String name, String mobileNum, String gender, String nationality, String address, String email){
        try {
            String DB_URL = "jdbc:mysql://localhost/myhotel";
            String USERNAME = "root";
            String PASSWORD = "";

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "UPDATE adminrooms SET name = ?, moblNum = ?, gender = ?, nationality = ?, address = ?, email = ? WHERE id = 17";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, mobileNum);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4, nationality);
            preparedStatement.setString(5, address);
            preparedStatement.setString(6, email);
            int update = preparedStatement.executeUpdate();
            if(update > 0){
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = name_field.getText();
        String mobileNumber = mobile_field.getText();
        String gender = gender_fld.getText();
        String nationality = nationality_fld.getText();
        String address = address_fld.getText();
        String email = email_fld.getText();

        if(e.getSource() == backButton){
            new HomePage();
            this.setVisible(false);
        } else if(e.getSource() == clearButton){
            name_field.setText("");
            mobile_field.setText("");
            gender_fld.setText("");
            nationality_fld.setText("");
            address_fld.setText("");
            email_fld.setText("");
            System.out.println("All data has been cleared in the textfield");
        } else if(e.getSource() == updateButton){
            UserUpdate update = new UserUpdate();
            this.dispose();
            System.out.println("Updated");
            if(update.DB_updateDetails(name, mobileNumber, gender, nationality, address, email)){
                new HomePage().setVisible(false);
                int yesOrNo = JOptionPane.showConfirmDialog(this, "Do you want to update info?", "Message", JOptionPane.YES_NO_OPTION);
                if(yesOrNo == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(this, "Customer data updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Customer data not updated", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            name_field.setText("");
            mobile_field.setText("");
            gender_fld.setText("");
            nationality_fld.setText("");
            address_fld.setText("");
            email_fld.setText("");
        }
    }
}   