package bank.management.system;

import java.sql.*;


public class Conn {

    Connection connection;
    Statement statement;
    public Conn(){
        try {
            connection =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","admin");
            statement=connection.createStatement();
            System.out.println("Connected");

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error Occurred");

        }
    }
}
