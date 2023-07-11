package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JButton button,button1;

    ButtonGroup buttonGroup;
    JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9;

    JRadioButton r1,r2,r3,r4;

    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formNo;



    public SignupThree(String formNo){
        this.formNo=formNo;
        setLayout(null);


        label1=new JLabel("Page 3: Account Details");
        label1.setFont(new Font("Raleway",Font.BOLD,25));
        label1.setBounds(250,50,400,50);
        add(label1);

        label2=new JLabel("Account Type");
        label2.setFont(new Font("Raleway",Font.BOLD,20));
        label2.setBounds(100,150,220,50);
        add(label2);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,200,150,30);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(300,200,150,30);
        add(r2);

        r3=new JRadioButton("Business Account");
        r3.setFont(new Font("Raleway",Font.BOLD,15));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,250,180,30);
        add(r3);

        r4=new JRadioButton("Salary Account");
        r4.setFont(new Font("Raleway",Font.BOLD,15));
        r4.setBackground(Color.WHITE);
        r4.setBounds(300,250,150,30);
        add(r4);

        buttonGroup=new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        label3=new JLabel("Card Number");
        label3.setFont(new Font("Raleway",Font.BOLD,25));
        label3.setBounds(100,320,200,50);
        add(label3);


        label4=new JLabel("PIN:");
        label4.setFont(new Font("Raleway",Font.BOLD,25));
        label4.setBounds(100,400,200,50);
        add(label4);

        label5=new JLabel("Services Required");
        label5.setFont(new Font("Raleway",Font.BOLD,25));
        label5.setBounds(100,480,250,50);
        add(label5);

      label6=new JLabel("Your 16 digit card number");
        label6.setFont(new Font("Raleway",Font.BOLD,12));
        label6.setBounds(100,340,200,50);
        add(label6);



       label7=new JLabel("Your 4 digit password");
        label7.setFont(new Font("Raleway",Font.BOLD,12));
        label7.setBounds(100,420,200,50);
        add(label7);

       label8=new JLabel("XXXX-XXXX-XXXX-1234");
        label8.setFont(new Font("Raleway",Font.BOLD,25));
        label8.setBounds(300,320,300,50);
        add(label8);

        label9=new JLabel("XXXX");
        label9.setFont(new Font("Raleway",Font.BOLD,25));
        label9.setBounds(300,400,200,50);
        add(label9);

        c1=new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway",Font.BOLD,15));
        c1.setBounds(100,530,200,50);
        c1.setBackground(Color.WHITE);
        add(c1);

        c2=new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,15));
        c2.setBounds(300,530,200,50);
        c2.setBackground(Color.WHITE);
        add(c2);

        c3=new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,15));
        c3.setBounds(100,570,200,50);
        c3.setBackground(Color.WHITE);
        add(c3);

        c4=new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,15));
        c4.setBounds(300,570,200,50);
        c4.setBackground(Color.WHITE);
        add(c4);

         c5=new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,15));
        c5.setBounds(100,610,200,50);
        c5.setBackground(Color.WHITE);
        add(c5);

        c6=new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,15));
        c6.setBounds(300,610,200,50);
        c6.setBackground(Color.WHITE);
        add(c6);

        c7=new JCheckBox("I hereby declares that the given details are correct according to best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,15));
        c7.setBounds(100,680,700,50);
        c7.setBackground(Color.WHITE);
        add(c7);



        button=new JButton("Submit");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Raleway",Font.BOLD,15));
        button.setBounds(250,720,100,50);
        add(button);
        button.addActionListener(this);

        button1=new JButton("Cancel");
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        button1.setFont(new Font("Raleway",Font.BOLD,15));
        button1.setBounds(450,720,100,50);
        add(button1);
        button1.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,50);
        setSize(850,850);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {

        new SignupThree("");

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==button){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving Account";
            } else if (r2.isSelected()) {
                accountType="Current Account";
            }else if(r3.isSelected()){
                accountType="Business Account";
            } else if (r4.isSelected()) {
                accountType="Salary Account";
            }

            Random random=new Random();

            String cardNumber=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);

            String pinNumber=""+Math.abs((random.nextLong()%9000L)+10000L);

            String facility="";

            if(c1.isSelected()){
                facility=facility+"ATM Card";

            } else if ((c2.isSelected())) {
                facility=facility+"Internet Banking";

            } else if ((c3.isSelected())) {
                facility=facility+"Mobile Banking";

            }else if ((c4.isSelected())) {
                facility=facility+"E-Statement";

            } else if ((c5.isSelected())) {
                facility = facility + "Email and SMS Alerts";

            } else if ((c6.isSelected())) {
                facility = facility + "Cheque Book";

            }


            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Please select account type");
                }else{
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formNo+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"')";
                    String query2="insert into login values('"+formNo+"','"+cardNumber+"','"+pinNumber+"')";

                    conn.statement.executeUpdate(query1);
                    conn.statement.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card No."+cardNumber+"\n"+"Pin :" +pinNumber);
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(true);
                }

            }catch(Exception e){
                System.out.println("Some Error occurred: "+e);
            }


        }else if(ae.getSource()==button1){
        System.exit(0);
        }
    }
}
