package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton exit, deposit, withDraw, fastCash, balanceEnquiry, miniStatement, pinChange;
    JLabel label1;

    String pinNo;

    public FastCash(String pinNO) {
        this.pinNo = pinNO;
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 900, 900);
        add(label);


        label1 = new JLabel("Enter Withdrawal Amount");
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        label1.setBounds(220, 300, 250, 50);
        label.add(label1);

        deposit = new JButton("1000");
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(160, 415, 150, 30);
        label.add(deposit);
        deposit.addActionListener(this);

        withDraw = new JButton("5000");
        withDraw.setForeground(Color.BLACK);
        withDraw.setBounds(350, 415, 150, 30);
        label.add(withDraw);
        withDraw.addActionListener(this);

        fastCash = new JButton("10000");
        fastCash.setForeground(Color.BLACK);
        fastCash.setBounds(160, 450, 150, 30);
        label.add(fastCash);
        fastCash.addActionListener(this);

        miniStatement = new JButton("15000");
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setBounds(350, 450, 150, 30);
        label.add(miniStatement);
        miniStatement.addActionListener(this);

        pinChange = new JButton("25000");
        pinChange.setForeground(Color.BLACK);
        pinChange.setBounds(160, 485, 150, 30);
        label.add(pinChange);
        pinChange.addActionListener(this);

        balanceEnquiry = new JButton("50000");
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setBounds(350, 485, 150, 30);
        label.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);

        exit = new JButton("Back");
        exit.setForeground(Color.BLACK);
        exit.setBounds(350, 520, 150, 30);
        label.add(exit);
        exit.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 0);
        setSize(900, 880);
        //setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new FastCash("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(0); //k
            System.out.println(amount);
            Conn conn = new Conn();
            ResultSet rs = conn.statement.executeQuery("select * from bank where pinNumber = '"+pinNo+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            if (ae.getSource() == exit) {
                this.setVisible(false);
                new Transactions(pinNo).setVisible(true);
            }else{
                Date date = new Date();
                conn.statement.executeUpdate("insert into bank values('"+pinNo+"', '"+date+"', 'Withdrawal', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Withdrawal Successfully");

                setVisible(false);
                new Transactions(pinNo).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
