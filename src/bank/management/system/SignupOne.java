package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField emailTextField, nameTextField, fnameTextField, addressTextField, cityTextField, stateTextField,pinTextField;

   // JTextField pinTextField;
    JButton next;
    JRadioButton male, female, married, unmarried, other;
    JLabel formNo, personalDetails, name, fname, dob, gender, email, marital, address, city, pin, state;
    JDateChooser jDateChooser;
    ButtonGroup buttonGroup, buttonGroup1;



    public SignupOne() {
        Random ran = new Random();
        setLayout(null);
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        formNo = new JLabel("Application Frame No. is " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(140, 20, 600, 50);
        add(formNo);

        personalDetails = new JLabel("Page 1:Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 100, 400, 50);
        add(personalDetails);

        name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(140, 170, 100, 20);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameTextField.setBounds(300, 170, 400, 30);
        add(nameTextField);

        fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(140, 220, 150, 20);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameTextField.setBounds(300, 220, 400, 30);
        add(fnameTextField);

        dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(140, 270, 200, 20);
        add(dob);
        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(300, 270, 400, 30);
        jDateChooser.setForeground(new Color(105, 105, 105));
        add(jDateChooser);

        gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(140, 320, 100, 20);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 320, 60, 30);
        male.setFont(new Font("Raleway", Font.BOLD, 15));
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 320, 80, 30);
        female.setFont(new Font("Raleway", Font.BOLD, 15));
        female.setBackground(Color.WHITE);
        add(female);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);

        email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(140, 370, 200, 20);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        emailTextField.setBounds(300, 370, 400, 30);
        add(emailTextField);

        marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(140, 420, 200, 20);
        add(marital);

        married = new JRadioButton("Married");
        married.setBounds(300, 420, 100, 30);
        married.setFont(new Font("Raleway", Font.BOLD, 15));
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(400, 420, 100, 30);
        unmarried.setFont(new Font("Raleway", Font.BOLD, 15));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(530, 420, 100, 30);
        other.setFont(new Font("Raleway", Font.BOLD, 15));
        other.setBackground(Color.WHITE);
        add(other);

        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(married);
        buttonGroup1.add(unmarried);
        buttonGroup1.add(other);


        address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(140, 470, 200, 20);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        addressTextField.setBounds(300, 470, 400, 30);
        add(addressTextField);

        city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(140, 520, 200, 20);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        cityTextField.setBounds(300, 520, 400, 30);
        add(cityTextField);

        state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(140, 570, 200, 20);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        stateTextField.setBounds(300, 570, 400, 30);
        add(stateTextField);

        pin = new JLabel("Postal Code:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(140, 620, 200, 20);
        add(pin);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        pinTextField.setBounds(300, 620, 400, 30);
        add(pinTextField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 670, 80, 30);
        add(next);
        next.addActionListener(this);


        setSize(850, 800);
        setLocation(250, 100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    public static void main(String[] args) {
        new SignupOne();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNo = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)(jDateChooser.getDateEditor().getUiComponent())).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Mail";
        } else {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pinTextField.getText();

        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (unmarried.isSelected()) {
            marital = "Unmarried";
        } else {
            marital = "Other";
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else {

                Conn conn = new Conn();
                String query = "insert into signup values('" + formNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                conn.statement.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formNo).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
