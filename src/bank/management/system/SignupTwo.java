package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField emailTextField, addressTextField, cityTextField, stateTextField,ptcl,bill;

    // JTextField pinTextField;
    JButton next;
    JRadioButton seniorY,seniorN,existingY,existingN;
    JLabel  personalDetails, name, fname, dob, gender, email, marital, address, city, pin, state;

    String formno;
    ButtonGroup buttonGroup, buttonGroup1;


    JComboBox<String> religion,category,income,education,occupation;



    public SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");


        personalDetails = new JLabel("Page 2:Additional Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 20));
        personalDetails.setBounds(250, 100, 400, 50);
        add(personalDetails);
//////////////////////Religion///////////////////////
        name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(120, 170, 100, 30);
        add(name);
        String[] valReligion ={"Muslim","Hindu","Christian"};
        religion=new JComboBox<>(valReligion);
        religion.setBackground(Color.white);
        religion.setBounds(300, 170, 400, 30);
        add(religion);
//////////////////////Category///////////////////////

        fname = new JLabel("Category:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(120, 220, 150, 30);
        add(fname);
        String[] valCategory ={"General","Super Ameer","Ameer","Gareeb","Super Gareeb"};
        category=new JComboBox<>(valCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300, 220, 400, 30);
        add(category);

//////////////////////Income///////////////////////
        dob = new JLabel("Income:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(120, 270, 200, 20);
        add(dob);
        String[] valIncome ={"NULL","<150,000","<250,000","<500,000","Up to 10,00,000"};
        income=new JComboBox<>(valIncome);
        income.setBackground(Color.WHITE);
        income.setBounds(300, 270, 400, 30);
        add(income);

//////////////////////Education///////////////////////
        gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(120, 320, 200, 20);
        add(gender);
        email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(120, 345, 200, 20);
        add(email);

        String[] valEducation ={"No Education","Matric Pass","F.SC Pass","Bachelor's","Masters","PHD","Other"};
        education=new JComboBox<>(valEducation);
        education.setBackground(Color.WHITE);
        education.setBounds(300, 320, 400, 30);
        add(education);

//////////////////////Occupation///////////////////////

        marital = new JLabel("Occupation:");
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(120, 420, 200, 30);
        add(marital);

        String[] valOccupation ={"Salaried","Self Employed","Business Man","Nulla Berozgar","Retired","Other"};
        occupation=new JComboBox<>(valOccupation);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300, 420, 400, 30);
        add(occupation);



//////////////////////PTCL No.///////////////////////
        address = new JLabel("PTCL No. :");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(120, 470, 200, 20);
        add(address);

        ptcl = new JTextField();
        ptcl.setFont(new Font("Raleway", Font.BOLD, 14));
        ptcl.setBounds(300, 470, 400, 30);
        add(ptcl);
//////////////////////Bill No.///////////////////////
        city = new JLabel("Bill No. :");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(120, 520, 200, 20);
        add(city);

        bill = new JTextField();
        bill.setFont(new Font("Raleway", Font.BOLD, 14));
        bill.setBounds(300, 520, 400, 30);
        add(bill);
//////////////////////Senior Citizen///////////////////////
        state = new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(120, 570, 200, 20);
        add(state);

        seniorY=new JRadioButton("Yes");
        seniorY.setBackground(Color.WHITE);
        seniorY.setBounds(300, 570, 50, 20);
        add(seniorY);

        seniorN=new JRadioButton("No");
        seniorN.setBackground(Color.WHITE);
        seniorN.setBounds(350, 570, 50, 20);
        add(seniorN);

        buttonGroup=new ButtonGroup();
        buttonGroup.add(seniorY);
        buttonGroup.add(seniorN);



//////////////////////Existing Account///////////////////////
        pin = new JLabel("Existing Account:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(120, 620, 200, 30);
        add(pin);


        existingY=new JRadioButton("Yes");
        existingY.setBackground(Color.WHITE);
        existingY.setBounds(300, 630, 50, 20);
        add(existingY);

        existingN=new JRadioButton("No");
        existingN.setBackground(Color.WHITE);
        existingN.setBounds(350, 630, 50, 20);
        add(existingN);

        buttonGroup1=new ButtonGroup();
        buttonGroup1.add(existingY);
        buttonGroup1.add(existingN);

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
        new SignupTwo("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if (seniorY.isSelected()) {
            seniorCitizen = "Yes";
        } else {
            seniorCitizen = "No";
        }
        String sptcl = ptcl.getText();
        String sbill = bill.getText();

        String existingAccount = null;
        if (existingY.isSelected()) {
            existingAccount = "Yes";
        }  else {
            existingAccount = "No";
        }

        try {
            if (sbill.equals("")) {
                JOptionPane.showMessageDialog(null, "Bill No is Required");
            }else{
                Conn conn=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+sptcl+"','"+sbill+"','"+seniorCitizen+"','"+existingAccount+"')";
                conn.statement.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
