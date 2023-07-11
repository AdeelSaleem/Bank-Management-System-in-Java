package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton signIn, clear, signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;

    public Login() {
        setLayout(null);
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(70, 10, 100, 100);


        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("osward", Font.BOLD, 40));
        text.setBounds(200, 15, 400, 100);
        add(text);

        JLabel cardNo = new JLabel("Enter Card No.");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        cardNo.setBounds(120, 200, 400, 100);
        add(cardNo);

        cardTextField = new JTextField();
        cardTextField.setBounds(280, 235, 275, 30);
        cardTextField.setFont(new Font("arial", Font.BOLD,14));
        add(cardTextField);


        JLabel pin = new JLabel("Enter PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120, 300, 400, 100);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(280, 335, 275, 30);
        pinTextField.setFont(new Font("arial", Font.BOLD,14));
        add(pinTextField);

        signIn = new JButton("Sign In");
        signIn.setBounds(280, 400, 100, 30);
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);
        signIn.addActionListener(this);
        add(signIn);

        clear = new JButton("CLEAR");
        clear.setBounds(450, 400, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("Sign UP");
        signUp.setBounds(280, 450, 270, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setTitle("Automated Teller Machine");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300, 250);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signIn) {
            Conn conn=new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber=pinTextField.getText();
            String query="select * from login where cardNumber='"+cardNumber+"' and pin ='"+pinNumber+"'";
            try{
                ResultSet resultSet=conn.statement.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Card Number or PIN is invalid");
                }
            }catch(Exception e){
                System.out.println("Error Occurred = "+e);
            }


        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        } else if (ae.getSource() == signUp) {
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }

    public static void main(String[] args) {
        new Login();
    }


}
