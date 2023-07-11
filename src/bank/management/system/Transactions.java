package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Transactions extends JFrame implements ActionListener {

    JButton exit, deposit, withDraw, fastCash, balanceEnquiry, miniStatement, pinChange;
    JLabel label1;

    String pinNo;
    public Transactions(String pinNO) {
        this.pinNo=pinNO;
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 900, 900);
        add(label);


        label1 = new JLabel("Please Select Your Transaction");
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        label1.setBounds(220, 300, 250, 50);
        label.add(label1);

        deposit = new JButton("Deposit");
        deposit.setForeground(Color.BLACK);
        deposit.setBounds(160, 415, 150, 30);
        label.add(deposit);
        deposit.addActionListener(this);

        withDraw = new JButton("Cash Withdrawal");
        withDraw.setForeground(Color.BLACK);
        withDraw.setBounds(350, 415, 150, 30);
        label.add(withDraw);
        withDraw.addActionListener(this);

        fastCash = new JButton("Fast Cash");
        fastCash.setForeground(Color.BLACK);
        fastCash.setBounds(160, 450, 150, 30);
        label.add(fastCash);
        fastCash.addActionListener(this);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setForeground(Color.BLACK);
        miniStatement.setBounds(350, 450, 150, 30);
        label.add(miniStatement);
        miniStatement.addActionListener(this);

        pinChange = new JButton("Pin Change");
        pinChange.setForeground(Color.BLACK);
        pinChange.setBounds(160, 485, 150, 30);
        label.add(pinChange);
        pinChange.addActionListener(this);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setForeground(Color.BLACK);
        balanceEnquiry.setBounds(350, 485, 150, 30);
        label.add(balanceEnquiry);
        balanceEnquiry.addActionListener(this);

        exit = new JButton("Exit");
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
        new Transactions("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        }else if(ae.getSource()==withDraw){
            setVisible(false);
            new Withdrawal(pinNo).setVisible(true);
        }else if(ae.getSource()==fastCash){
            setVisible(false);
            new FastCash(pinNo).setVisible(true);
        }else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinNo).setVisible(true);
        }else if(ae.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNo).setVisible(true);
        }else if(ae.getSource()==miniStatement){
            new MiniStatement(pinNo).setVisible(true);
        }

    }
}
