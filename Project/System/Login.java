import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener{
    
    private JButton login_btn = new JButton("Login");
    private JButton adminBtn;

    private JLabel user_txt = new JLabel("Username");
    private JLabel password_text = new JLabel("Password");
    private JLabel login_text = new JLabel("Login");

    private JTextField username_field = new JTextField();
    private JPasswordField password_field = new JPasswordField();  
    
    public Login(){
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
        login_text.setBounds(280, -80, 200, 300);
        login_text.setFont(new Font("Arial", Font.PLAIN, 40));
        login_text.setForeground(Color.BLACK);
        this.add(login_text);

        //bg of login
        JPanel login_bg = new JPanel();
        login_bg.setBackground(Color.gray);
        login_bg.setBounds(0, 0, 1000, 900);

        user_txt.setBounds(200, 100, 190,150);
        user_txt.setFont(new Font("Arial", Font.PLAIN, 30));
        user_txt.setForeground(Color.BLACK);
        this.add(user_txt);

        //a user prompts for username
        username_field.setBounds(200, 200, 290, 50); //x, y, width, height
        username_field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        password_text.setBounds(200, 220, 190,150);
        password_text.setFont(new Font("Arial", Font.PLAIN, 30));
        password_text.setForeground(Color.BLACK);
        this.add(password_text);

        //a user prompts for password
        password_field.setBounds(200, 320, 290, 50);
        password_field.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        password_field.setEchoChar('*');
        this.add(username_field);
        this.add(password_field); 

        //login button
        login_btn.setBounds(270, 400, 150, 50);
        login_btn.setFocusable(false);
        login_btn.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        login_btn.setBackground(Color.WHITE);
        login_btn.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(login_btn);

        adminBtn = new JButton("Admin");
        adminBtn.setBounds(610, 20, 50, 30);
        adminBtn.setFocusable(false);
        adminBtn.setBorder(null);
        adminBtn.setBackground(Color.WHITE);
        adminBtn.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(adminBtn);

        login_btn.addActionListener(this);
        adminBtn.addActionListener(this);
        this.add(login_bg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = username_field.getText();
        String password = password_field.getText();

        if(e.getSource() == login_btn) {
            DB_login verify = new DB_login();
            if (verify.verify_login(username, password)){
                new ChooseRooms();
                this.setVisible(false);
                this.dispose();
            }
            username_field.setText("");
            password_field.setText("");
        } else if(e.getSource() == adminBtn) { // admin proceed to admin page
            new Admin();
            this.setVisible(false);
        } 
    }
}