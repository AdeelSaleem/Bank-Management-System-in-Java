package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JLabel label, label1;
    JTextField amount;
    JButton withdraw, back;

    String pinNo;
    Withdrawal(String pinNo) {
        this.pinNo=pinNo;
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        label = new JLabel(imageIcon1);
        add(label);


        label1 = new JLabel("Enter the amount you want to Withdraw");
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        label1.setBounds(170, 230, 400, 50);
        label.add(label1);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,14));
        amount.setBounds(170, 280, 300, 30);
        label.add(amount);


        withdraw = new JButton("Withdraw");
        withdraw.setForeground(Color.BLACK);
        withdraw.setBounds(350, 430, 150, 30);
        label.add(withdraw);
        withdraw.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(350, 470, 150, 30);
        label.add(back);
        back.addActionListener(this);


        setLocation(300, 0);
        setSize(900, 850);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdraw) {
            String number=amount.getText();
            Date date=new Date();

            try {
                Conn conn=new Conn();
                String query="insert into bank values('"+pinNo+"','"+date+"','Withdraw','"+number+"')";
                conn.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+ " withdraw Successfully");
                setVisible(false);
                new Transactions(pinNo).setVisible(true);

            } catch (Exception e){
                System.out.println("Error Occurred");
            }


        }else{
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }

    }
}
