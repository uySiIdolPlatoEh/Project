import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdminHomePage extends JFrame implements ActionListener{
    private JButton btn;   
    private JButton rooms_btn;

    private JPanel panel;

    public AdminHomePage(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(400, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBackground(Color.gray);
        panel.setBounds(0, 0, 500, 500);
        
        rooms_btn = new JButton("Rooms");
        rooms_btn.setBounds(30, 80, 100, 50);
        rooms_btn.setFocusable(false);
        rooms_btn.setBorder(null);
        rooms_btn.setBackground(Color.WHITE);
        rooms_btn.setFont(new Font("Arial", Font.PLAIN, 15));
        this.add(rooms_btn);

        btn = new JButton("Logout");
        btn.setBounds(320, 10, 50, 30);
        btn.setFocusable(false);
        btn.setBorder(null);
        btn.setBackground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.PLAIN, 15));
        this.add(btn);

        btn.addActionListener(this);
        rooms_btn.addActionListener(this);
        this.add(panel);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btn){
            int yesOrNo = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Message", JOptionPane.YES_NO_OPTION);
            if(yesOrNo == JOptionPane.YES_OPTION){
                new Admin();
                this.setVisible(false);
            }
        } else if(e.getSource() == rooms_btn){
            new AdminRooms();
            this.setVisible(false);
        }
    }   
}