import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener{

    private JButton checkin_btn;
    private JButton checkout_btn;
    private JButton rooms_btn;
    private JButton logout_btn;
    private JButton update_btn;

    private JLabel heading = new JLabel("Hotel and Vacation Rentals");

    private JPanel panel;
    private JPanel navbarPanel = new JPanel();

    public HomePage(){
        this.setTitle("Hotel and Vacation Rentals");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(700, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 700, 100);

        navbarPanel.setLayout(null);
        navbarPanel.setBackground(Color.LIGHT_GRAY);
        navbarPanel.setBounds(0, 0, 700, 800);

        ImageIcon logo = new ImageIcon("img/logo.png");
        heading.setIcon(logo);
        heading.setIconTextGap(120);
        heading.setBounds(20, -150, 600, 400);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        heading.setForeground(Color.BLACK);
        this.add(heading);

        //user will checkin his/her designated choose room
        ImageIcon checkInIcon = new ImageIcon("img/checkin.png");
        checkin_btn = new JButton("Check In");
        checkin_btn.setIcon(checkInIcon);
        checkin_btn.setIconTextGap(10);
        checkin_btn.setBounds(70, 150, 250, 150);
        checkin_btn.setFocusable(false);
        checkin_btn.setFont(new Font("Arial", Font.BOLD, 20));
        checkin_btn.setForeground(Color.BLACK);
        checkin_btn.setBackground(Color.WHITE);
        checkin_btn.setBorder(null);
        this.add(checkin_btn);

        //user will checkout from the hotel
        ImageIcon checkOutIcon = new ImageIcon("img/checkout.png");
        checkout_btn = new JButton("Check out");
        checkout_btn.setIcon(checkOutIcon);
        checkout_btn.setIconTextGap(10);
        checkout_btn.setBounds(70, 350, 250, 150);
        checkout_btn.setFocusable(false);
        checkout_btn.setFont(new Font("Arial", Font.BOLD, 20));
        checkout_btn.setForeground(Color.BLACK);
        checkout_btn.setBackground(Color.WHITE);
        checkout_btn.setBorder(null);
        this.add(checkout_btn);

        //the information 
        ImageIcon roomsIcon = new ImageIcon("img/rooms.png");
        rooms_btn = new JButton("Rooms");
        rooms_btn.setIcon(roomsIcon);
        rooms_btn.setIconTextGap(10);
        rooms_btn.setBounds(370, 150, 250, 150);
        rooms_btn.setFocusable(false);
        rooms_btn.setFont(new Font("Arial", Font.BOLD, 20));
        rooms_btn.setBorder(null);
        rooms_btn.setForeground(Color.BLACK);
        rooms_btn.setBackground(Color.WHITE);
        this.add(rooms_btn);

        update_btn = new JButton("Update Details");
        update_btn.setBounds(370, 350, 250 , 150);
        update_btn.setFocusable(false);
        update_btn.setFont(new Font("Arial", Font.BOLD, 20));
        update_btn.setBackground(Color.WHITE);
        update_btn.setBorder(null);
        update_btn.setForeground(Color.BLACK);
        this.add(update_btn);

        //user will logout from this accoumt
        logout_btn = new JButton("Logout");
        logout_btn.setBounds(580, 35, 70, 30);
        logout_btn.setFocusable(false);
        logout_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        logout_btn.setBorder(null);
        logout_btn.setForeground(Color.BLACK);
        logout_btn.setBackground(Color.white);
        this.add(logout_btn);

        checkin_btn.addActionListener(this);
        checkout_btn.addActionListener(this);
        rooms_btn.addActionListener(this);
        update_btn.addActionListener(this);
        logout_btn.addActionListener(this);

        this.add(panel);
        this.add(navbarPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkin_btn) {
            this.setVisible(false);
            this.dispose();
            new UserCheckIn();
        } else if (e.getSource() == logout_btn) {
            int yesOrNo = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Message", JOptionPane.YES_NO_OPTION);
            if(yesOrNo == JOptionPane.YES_OPTION){
                this.setVisible(false);
                new Login();
            }
        } else if(e.getSource() == rooms_btn) {
            Rooms dbRooms = new Rooms();
            dbRooms.availRooms();
            this.setVisible(false);
        } else if(e.getSource() == checkout_btn) {
            this.setVisible(false);
            new UserCheckOut();
        } else if(e.getSource() == update_btn){
            new UserUpdate();
            this.setVisible(false);
        }
    }
}