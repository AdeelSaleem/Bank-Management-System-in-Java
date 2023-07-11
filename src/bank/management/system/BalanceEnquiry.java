package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;

    String pinNumber;

    public BalanceEnquiry(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 900, 900);
        add(label);



        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(350, 515, 150, 30);
        label.add(back);
        back.addActionListener(this);

        Conn conn=new Conn();
        int balance = 0;
        try {
            ResultSet rs = conn.statement.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

        }catch (Exception e){
            System.out.println("Exception Occurred "+e);
        }

        JLabel text=new JLabel("Your current balance amount is Rs: "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 13));
        text.setBounds(190,350,300,100);
        label.add(text);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 0);
        setSize(900, 880);
        //setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    setVisible(false);
    new Transactions(pinNumber).setVisible(true);
    }
}
