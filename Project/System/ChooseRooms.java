import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChooseRooms extends JFrame implements ActionListener {
    private JLabel selectLbl;
    private JLabel room1_Lbl;
    private JLabel price_Lbl;
    private JLabel person_lbl;
    private JLabel wifi_lbl;
    private JLabel refund_lbl;
    private JLabel rate_lbl;
    private JLabel breakFast_lbl;
    private JLabel room2_lbl;
    private JLabel rate2_lbl;
    private JLabel price2_lbl;
    private JLabel person2_lbl;
    private JLabel wifi2_lbl;
    private JLabel breakFast2_lbl;
    private JLabel refund2_lbl;

    private JPanel panel;

    private JButton reserve_btn1;
    private JButton homePageBtn;
    private JButton reserve2_btn;
    public ChooseRooms(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setBounds(0, 0, 700, 600);

        selectLbl = new JLabel("Select your room", SwingConstants.CENTER);
        selectLbl.setBounds(150, -160, 400, 400);
        selectLbl.setFont(new Font("Arial", Font.PLAIN, 25));
        selectLbl.setForeground(Color.BLACK);
        this.add(selectLbl);

        ImageIcon room1 = new ImageIcon("img/room1.png");
        room1_Lbl = new JLabel("Room 1");
        room1_Lbl.setIcon(room1);
        room1_Lbl.setVerticalTextPosition(SwingConstants.TOP);
        room1_Lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        room1_Lbl.setIconTextGap(10);
        room1_Lbl.setBounds(50, -10, 500, 400);
        room1_Lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        room1_Lbl.setForeground(Color.BLACK);
        this.add(room1_Lbl);

        rate_lbl = new JLabel("8.9/10 Fabulous", SwingConstants.CENTER);
        rate_lbl.setBounds(170, -110, 400, 500);
        rate_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        rate_lbl.setForeground(Color.BLACK);
        this.add(rate_lbl);

        price_Lbl = new JLabel("P100", SwingConstants.CENTER);
        price_Lbl.setBounds(132, -90, 400, 500);
        price_Lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        price_Lbl.setForeground(Color.BLACK);
        this.add(price_Lbl);

        person_lbl = new JLabel("2 Person's 1 Room", SwingConstants.CENTER);
        person_lbl.setBounds(128, -70, 500, 500);
        person_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        person_lbl.setForeground(Color.black);
        this.add(person_lbl);

        wifi_lbl = new JLabel("Free Wi-fi", SwingConstants.CENTER);
        wifi_lbl.setBounds(146, -50, 400, 500);
        wifi_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        wifi_lbl.setForeground(Color.BLACK);
        this.add(wifi_lbl);

        breakFast_lbl = new JLabel("Free Breakfast", SwingConstants.CENTER);
        breakFast_lbl.setBounds(163, -30, 400, 500);
        breakFast_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        breakFast_lbl.setForeground(Color.BLACK);
        this.add(breakFast_lbl);

        refund_lbl = new JLabel("Non-refundable", SwingConstants.CENTER);
        refund_lbl.setBounds(165, -10, 400, 500);
        refund_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        refund_lbl.setForeground(Color.BLACK);
        this.add(refund_lbl);

        ImageIcon room2 = new ImageIcon("img/room3.png");
        room2_lbl = new JLabel("Room 2", SwingConstants.CENTER);
        room2_lbl.setIcon(room2);
        room2_lbl.setVerticalTextPosition(SwingConstants.TOP);
        room2_lbl.setHorizontalTextPosition(SwingConstants.CENTER);
        room2_lbl.setIconTextGap(10);
        room2_lbl.setBounds(-25, 150, 400, 500);
        room2_lbl.setFont(new Font("Arial", Font.PLAIN, 20));
        room2_lbl.setForeground(Color.BLACK);
        this.add(room2_lbl);

        rate2_lbl = new JLabel("9.2/10 Excellent", SwingConstants.CENTER);
        rate2_lbl.setBounds(170, 105, 400, 500);
        rate2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        rate2_lbl.setForeground(Color.BLACK);
        this.add(rate2_lbl);

        price2_lbl = new JLabel("P200", SwingConstants.CENTER);
        price2_lbl.setBounds(135, 125, 400, 500);
        price2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        price2_lbl.setForeground(Color.black);
        this.add(price2_lbl);

        person2_lbl = new JLabel("4 Person's 1 Room", SwingConstants.CENTER);
        person2_lbl.setBounds(182, 146, 400, 500);
        person2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        person2_lbl.setForeground(Color.BLACK);
        this.add(person2_lbl);

        wifi2_lbl = new JLabel("Free Wi-fi", SwingConstants.CENTER);
        wifi2_lbl.setBounds(150, 165, 400, 500);
        wifi2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        wifi2_lbl.setForeground(Color.BLACK);
        this.add(wifi2_lbl);

        breakFast2_lbl = new JLabel("Free Breakfast", SwingConstants.CENTER);
        breakFast2_lbl.setBounds(168, 185, 400, 500);
        breakFast2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        breakFast2_lbl.setForeground(Color.BLACK);
        this.add(breakFast2_lbl);

        refund2_lbl = new JLabel("Non-refundable", SwingConstants.CENTER);
        refund2_lbl.setBounds(170, 204, 400, 500);
        refund2_lbl.setFont(new Font("Arial", Font.PLAIN, 16));
        refund2_lbl.setForeground(Color.black);
        this.add(refund2_lbl);

        reserve_btn1 = new JButton("Reserve");
        reserve_btn1.setBounds(540, 160, 100, 50);
        reserve_btn1.setFocusable(false);
        reserve_btn1.setBackground(Color.WHITE);
        reserve_btn1.setForeground(Color.BLACK);
        reserve_btn1.setBorder(null);
        reserve_btn1.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(reserve_btn1);

        reserve2_btn = new JButton("Reserve");
        reserve2_btn.setBounds(540, 370, 100, 50);
        reserve2_btn.setFont(new Font("Arial", Font.PLAIN, 12));
        reserve2_btn.setFocusable(false);
        reserve2_btn.setBackground(Color.WHITE);
        reserve2_btn.setForeground(Color.BLACK);
        reserve2_btn.setBorder(null);
        this.add(reserve2_btn);

        homePageBtn = new JButton("Homepage");
        homePageBtn.setBounds(590, 490,80, 50);
        homePageBtn.setFocusable(false);
        homePageBtn.setBackground(Color.WHITE);
        homePageBtn.setForeground(Color.BLACK);
        homePageBtn.setBorder(null);
        homePageBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        this.add(homePageBtn);

        reserve_btn1.addActionListener(this);  
        reserve2_btn.addActionListener(this);
        homePageBtn.addActionListener(this);
        this.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == reserve_btn1){
            new UserCheckIn();
            this.setVisible(false);
        } else if(e.getSource() == homePageBtn){
            new HomePage();
            this.setVisible(false);
        } else if(e.getSource() == reserve2_btn) {
            new UserCheckIn();
            this.setVisible(false);
        }
    }
}