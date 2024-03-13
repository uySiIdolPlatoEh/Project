import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Admin extends JFrame implements ActionListener{

    private JLabel login_lbl;
    private JLabel pass_lbl;

    private JTextField login_fld;
    private JPasswordField password_fld;

    private JButton login_btn;
    private JButton back_btn;

    private JPanel panel;
    public Admin(){
        this.setTitle("Admin");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setBounds(0, 0, 500, 500);

        login_lbl = new JLabel("Username");
        login_lbl.setBounds(150, -50, 200, 300);
        login_lbl.setFont(new Font("Arial", Font.BOLD, 18));
        login_lbl.setForeground(Color.black);
        this.add(login_lbl);

        login_fld = new JTextField();
        login_fld.setBounds(150, 120, 200, 30);
        login_fld.setBorder(null);
        login_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        this.add(login_fld);

        pass_lbl = new JLabel("Password");
        pass_lbl.setBounds(150, 30, 200, 300);
        pass_lbl.setFont(new Font("Arial", Font.BOLD, 18));
        pass_lbl.setForeground(Color.black);
        this.add(pass_lbl); 

        password_fld = new JPasswordField();
        password_fld.setBounds(150, 200, 200, 30);
        password_fld.setBorder(null);
        password_fld.setFont(new Font("Poppins", Font.PLAIN, 12));
        password_fld.setEchoChar('*');
        this.add(password_fld);

        login_btn = new JButton("Login");
        login_btn.setBounds(200, 250, 100, 50);
        login_btn.setFocusable(false);
        login_btn.setBorder(null);
        login_btn.setBackground(Color.WHITE);
        login_btn.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(login_btn);

        back_btn = new JButton("Back");
        back_btn.setBounds(10, 300, 100, 50);
        back_btn.setFocusable(false);
        back_btn.setBorder(null);
        back_btn.setBackground(Color.WHITE);
        back_btn.setFont(new Font("Arial", Font.BOLD, 15));
        this.add(back_btn);

        login_btn.addActionListener(this);
        back_btn.addActionListener(this);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login_btn){
            DB_admin admin = new DB_admin();
            if(admin.verifyAdmin(login_fld.getText(), password_fld.getText())){
                new AdminHomePage();
                this.setVisible(false);
            }
            login_fld.setText("");
            password_fld.setText("");
        } else if(e.getSource() == back_btn){
            new Login();
            this.setVisible(false);
        }
    }
    
}
