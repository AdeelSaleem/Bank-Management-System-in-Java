package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;

public class PinChange extends JFrame implements ActionListener {

    String pinNo;
    JLabel label1, pintext, repintext;

    JPasswordField pin, repin;

    JButton back,change;

    PinChange(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0, 0, 900, 900);
        add(label);


        label1 = new JLabel("Change Your PIN");
        label1.setFont(new Font("System", Font.BOLD, 14));
        label1.setForeground(Color.WHITE);
        label1.setBounds(270, 300, 250, 50);
        label.add(label1);

        pintext = new JLabel("Enter Your PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 12));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(170, 350, 250, 50);
        label.add(pintext);


        pin = new JPasswordField();
        pin.setFont(new Font("System", Font.BOLD, 14));
        pin.setBounds(290, 360, 200, 30);
        label.add(pin);


        repintext = new JLabel("Re-enter Your PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 12));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(170, 400, 150, 50);
        label.add(repintext);


        repin = new JPasswordField();
        repin.setFont(new Font("System", Font.BOLD, 14));
        repin.setBounds(290, 410, 200, 30);
        label.add(repin);


        change = new JButton("Change");
        change.setForeground(Color.BLACK);
        change.setBounds(350, 475, 150, 30);
        label.add(change);
        change.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.BLACK);
        back.setBounds(350, 515, 150, 30);
        label.add(back);
        back.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 0);
        setSize(900, 880);
        //setUndecorated(true);
        setVisible(true);
    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource()==change){
            try{
                String npin=pin.getText();
                String rpin=repin.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Pin Doesn't Match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter pin");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter re-pin");
                    return;
                }


                try{
                    Conn conn=new Conn();
                    String query1="update bank set pinNumber = '"+rpin+"' where pinNumber= '"+pinNo+"' ";
                    String query2="update login set pin = '"+rpin+"' where pin= '"+pinNo+"' ";
                    String query3="update signupthree set pin = '"+rpin+"' where pin= '"+pinNo+"' ";

                    conn.statement.executeUpdate(query1);
                    conn.statement.executeUpdate(query2);
                    conn.statement.executeUpdate(query3);

                    JOptionPane.showMessageDialog(null,"PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                }catch (Exception e){
                    System.out.println("Exception Occurred" +e);
                }

            }catch(Exception e){
                System.out.println("Exception Occurred "+e);
            }
        }

    }
}
