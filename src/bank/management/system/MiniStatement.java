package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    String pinNumber;
    public MiniStatement(String pinNumber){
        this.pinNumber=pinNumber;

        setLayout(null);
        setTitle("Mini Statement");

        JLabel mini=new JLabel();
        mini.setFont(new Font("Raleway",Font.BOLD,14));
        mini.setBounds(40,100,250,300);
        add(mini);

        JLabel bank =new JLabel("Pakistan Bank");
        bank.setFont(new Font("Raleway",Font.BOLD,14));
        bank.setBounds(130,30,100,50);
        add(bank);

        JLabel card =new JLabel();
        card.setFont(new Font("Raleway",Font.BOLD,14));
        card.setBounds(40,80,300,50);
        add(card);

        JLabel balance=new JLabel();
        balance.setFont(new Font("Raleway",Font.BOLD,14));
        balance.setBounds(40,100,300,50);
        add(balance);



        try{
            Conn conn=new Conn();

            ResultSet resultSet=conn.statement.executeQuery("select * from login where pin= '"+pinNumber+"'");

            while(resultSet.next()){
                card.setText("Card Number: "+resultSet.getString("cardNumber").substring(0,4)+"-XXXX-XXXX-"+resultSet.getString("cardNumber").substring(12));

            }
        }catch (Exception e){
            System.out.println("Exception Occurred: 1234"+e);
        }

        try{
            Conn conn=new Conn();
            int bal = 0;
            ResultSet resultSet1=conn.statement.executeQuery("select * from bank where pinNumber= '"+pinNumber+"'");
            while(resultSet1.next()){
                mini.setText(mini.getText() +"<html>" + resultSet1.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet1.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet1.getString("amount")+"<br><br><html>");
                if (resultSet1.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(resultSet1.getString("amount"));
                } else {
                    bal -= Integer.parseInt(resultSet1.getString("amount"));
                }
                balance.setText("Your current balance is: "+bal);

            }


        }catch(Exception e){
            System.out.println("Exception Occurred: "+e);
        }




        setSize(400,600);
        setLocation(30,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
