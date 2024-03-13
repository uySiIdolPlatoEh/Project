import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
public class UserCheckIn extends JFrame implements ActionListener{
    private JLabel names_lbl;
    private JLabel reg_label;
    private JLabel mobile_lbl;
    private JLabel gen_label;
    private JLabel nationality_lbl;
    private JLabel address_lbl;
    private JLabel email_lbl;
    private JLabel roomNo_lbl;
    private JLabel checkInDate_lbl;
    private JLabel checkOutDate_lbl;
    private JLabel availability_lbl;
    private JLabel price_lbl;
    private JLabel cardNumLbl;
    private JLabel cvcLbl;

    private JTextField name_field;
    private JTextField mob_field;
    private JTextField address_fld;
    private JTextField email_fld;
    private JTextField nationality_field;
    private JTextField gender_field;
    private JTextField roomNo_fld;
    private JTextField price_fld;
    private JTextField avail_fld;
    private JTextField checkInDate_fld;
    private JTextField checkOutDate_fld;
    private JTextField cardNum_fld;
    private JTextField cvc_fld;

    private JButton back_btn;
    private JButton checkin_btn;

    public UserCheckIn() {
        this.setTitle("Check In");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1250, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        JPanel checkPan = new JPanel();
        checkPan.setBackground(Color.gray);
        checkPan.setBounds(0, 0, 1500, 800);

        reg_label = new JLabel("Check In");
        reg_label.setFont(new Font("Arial", Font.PLAIN, 30));
        reg_label.setForeground(Color.BLACK);
        reg_label.setBounds(460, -100, 500, 300);
        this.add(reg_label);

        names_lbl = new JLabel("Name");
        names_lbl.setForeground(Color.BLACK);
        names_lbl.setBounds(40, -35, 500, 300);
        names_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(names_lbl);

        name_field = new JTextField();
        name_field.setBounds(200, 100, 290, 30);
        name_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        name_field.setBorder(null);
        this.add(name_field);

        mobile_lbl = new JLabel("Mobile Number");
        mobile_lbl.setBounds(35, 15, 500, 300);
        mobile_lbl.setForeground(Color.black);
        mobile_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(mobile_lbl);

        mob_field = new JTextField();
        mob_field.setColumns(20);
        mob_field.setBounds(200, 150, 290, 30);
        mob_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        mob_field.setBorder(null);
        this.add(mob_field);

        gen_label = new JLabel("Gender");
        gen_label.setFont(new Font("Arial", Font.PLAIN, 20));
        gen_label.setBounds(33, 15, 500, 400);
        gen_label.setForeground(Color.BLACK);
        this.add(gen_label);

        gender_field = new JTextField();
        gender_field.setBounds(200, 200, 290, 30);
        gender_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        gender_field.setBorder(null);
        this.add(gender_field);

        nationality_lbl = new JLabel("Nationality");
        nationality_lbl.setForeground(Color.black);
        nationality_lbl.setBounds(33, 65, 500, 400);
        nationality_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(nationality_lbl);

        nationality_field = new JTextField();
        nationality_field.setBounds(200, 250, 290, 30);
        nationality_field.setFont(new Font("Poppins", Font.PLAIN, 12));
        nationality_field.setBorder(null);
        this.add(nationality_field);

        address_lbl = new JLabel("Address");
        address_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        address_lbl.setBounds(30, 115, 300, 400);
        address_lbl.setForeground(Color.BLACK);
        this.add(address_lbl);

        address_fld = new JTextField();
        address_fld.setBounds(200, 300, 290, 30);
        address_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        address_fld.setBorder(null);
        this.add(address_fld);

        email_lbl = new JLabel("Email");
        email_lbl.setBounds(30, 265, 300, 200);
        email_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        email_lbl.setForeground(Color.BLACK);
        this.add(email_lbl);

        email_fld = new JTextField();
        email_fld.setBounds(200, 350, 290, 30);
        email_fld.setBorder(null);
        email_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        this.add(email_fld);
        
        roomNo_lbl = new JLabel("Room No");
        roomNo_lbl.setBounds(28, 265, 200, 300);
        roomNo_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        roomNo_lbl.setForeground(Color.black);
        this.add(roomNo_lbl);

        roomNo_fld = new JTextField();
        roomNo_fld.setColumns(20);
        roomNo_fld.setBounds(200, 400, 290, 30);
        roomNo_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        roomNo_fld.setBorder(null);
        roomNo_fld.setForeground(Color.BLACK);
        this.add(roomNo_fld);

        checkInDate_lbl = new JLabel("Check In Date");
        checkInDate_lbl.setBounds(600, -35, 200, 300);
        checkInDate_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        checkInDate_lbl.setForeground(Color.BLACK);
        this.add(checkInDate_lbl);

        checkInDate_fld = new JTextField();
        checkInDate_fld.setBounds(780, 100, 290, 30);
        checkInDate_fld.setBorder(null);
        checkInDate_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        this.add(checkInDate_fld);

        checkOutDate_lbl = new JLabel("Check Out Date");
        checkOutDate_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        checkOutDate_lbl.setBounds(600, 15, 200, 300);
        checkOutDate_lbl.setForeground(Color.black);
        this.add(checkOutDate_lbl);

        checkOutDate_fld = new JTextField();
        checkOutDate_fld.setBounds(780, 150, 290, 30);
        checkOutDate_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        checkOutDate_fld.setBorder(null);
        this.add(checkOutDate_fld);

        price_lbl = new JLabel("Price");
        price_lbl.setBounds(600, 65, 200, 300);
        price_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        price_lbl.setForeground(Color.BLACK);
        this.add(price_lbl);

        price_fld = new JTextField();
        price_fld.setBounds(780, 200, 290, 30);
        price_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        price_fld.setBorder(null);
        price_fld.setForeground(Color.BLACK);
        this.add(price_fld);

        availability_lbl = new JLabel("is Available?");
        availability_lbl.setBounds(600, 110, 200, 300);
        availability_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        availability_lbl.setForeground(Color.BLACK);
        this.add(availability_lbl);

        avail_fld = new JTextField();
        avail_fld.setBounds(780, 250, 290, 30);
        avail_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        avail_fld.setBorder(null);
        avail_fld.setForeground(Color.BLACK);
        this.add(avail_fld);

        cardNumLbl = new JLabel("Card number", SwingConstants.CENTER);
        cardNumLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        cardNumLbl.setBounds(625, 75, 400, 500);
        cardNumLbl.setForeground(Color.black);
        this.add(cardNumLbl);

        cardNum_fld = new JTextField();
        cardNum_fld.setBounds(780, 340, 250, 30);
        cardNum_fld.setBorder(null);
        cardNum_fld.setForeground(Color.BLACK);
        cardNum_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        this.add(cardNum_fld);

        cvcLbl = new JLabel("CVC/CVV", SwingConstants.CENTER);
        cvcLbl.setBounds(615, 135, 400, 500);
        cvcLbl.setFont(new Font("Arial", Font.PLAIN, 16));
        cvcLbl.setForeground(Color.BLACK);
        this.add(cvcLbl);

        cvc_fld = new JTextField();
        cvc_fld.setBounds(780, 400, 250, 30);
        cvc_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        cvc_fld.setForeground(Color.BLACK);
        cvc_fld.setBorder(null);
        this.add(cvc_fld);

        back_btn = new JButton("Back");
        back_btn.setBounds(30, 480, 100, 50);
        back_btn.setBackground(Color.WHITE);
        back_btn.setForeground(Color.BLACK);
        back_btn.setBorder(null);
        back_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        back_btn.setFocusable(false);
        this.add(back_btn);

        checkin_btn = new JButton("Check In");
        checkin_btn.setBounds(1110, 480, 100, 50);
        checkin_btn.setBackground(Color.white);
        checkin_btn.setBorder(null);
        checkin_btn.setForeground(Color.BLACK);
        checkin_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        checkin_btn.setFocusable(false);
        this.add(checkin_btn);

        this.add(checkPan);

        back_btn.addActionListener(this);
        checkin_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = name_field.getText();
        String mobileNum = mob_field.getText();
        String gender = gender_field.getText();
        String nationality = nationality_field.getText();
        String address = address_fld.getText();
        String email = email_fld.getText();
        String cardNumber = cardNum_fld.getText();
        String cvcNumber = cvc_fld.getText();
        String roomNo = roomNo_fld.getText();
        String checkInDate = checkInDate_fld.getText();
        String checkOutDate = checkOutDate_fld.getText();
        String price = price_fld.getText();
        String availability = avail_fld.getText();

        if(e.getSource() == back_btn) {
            this.setVisible(false);
            System.out.println("Back from the homepage!");
            new HomePage();
        } else if(e.getSource() == checkin_btn) {
            DB_checkIn check = new DB_checkIn();
            DBAdminCheckIn adminRooms = new DBAdminCheckIn();
            this.dispose();
            if(adminRooms.adminCheckIn(name, mobileNum, gender, nationality, address, email, cardNumber, cvcNumber) == check.verify_checkIn(roomNo, checkInDate, checkOutDate, price, availability)) {
                new HomePage();
                this.setVisible(false);
                int yesOrno = JOptionPane.showConfirmDialog(null, "Do you want to check-in?", "Message", JOptionPane.YES_NO_OPTION);
                if(yesOrno == JOptionPane.YES_OPTION){
                    JOptionPane.showMessageDialog(null, "Customer data inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Customer data not inserted", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } 
            name_field.setText("");
            mob_field.setText("");
            gender_field.setText("");
            nationality_field.setText("");
            address_fld.setText("");
            email_fld.setText("");
            roomNo_fld.setText("");
            checkInDate_fld.setText("");
            checkOutDate_fld.setText("");
            price_fld.setText("");
            avail_fld.setText("");
            cardNum_fld.setText("");
            cvc_fld.setText("");
        } 
    }
}