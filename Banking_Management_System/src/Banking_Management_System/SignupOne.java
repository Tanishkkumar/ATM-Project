package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JLabel;
import java.util.*;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
class spage extends JFrame implements ActionListener {

	JLabel formno, per, name, fname, dob, gender, email, marital, address, city, state, pincode;
	JTextField na, fna, gen, em, add, cit, st, pin;
	Random ran; // random number generation .
	JButton next;
	JDateChooser db;
	JRadioButton mar, far, bar, male, female;
	long random;

	spage() {
		
		super("AUTOMATED TELLER MACHINE");
		setLayout(null);
		setSize(750,760);
		setLocation(300, 5);
		// generating random number
		ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);

		// ***** *********************** Making jlabel for the form
		formno = new JLabel("APPLICATION FROM NO. " + random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(95, 20, 600, 40);
		add(formno);

		per = new JLabel("Page 1: Personal Details");
		per.setFont(new Font("Raleway", Font.BOLD, 22));
		per.setBounds(250, 80, 400, 30);
		add(per);

		// jlabel and textfield for name
		name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);

		na = new JTextField();
		na.setBounds(300, 140, 300, 30);
		na.setFont(new Font("Raleway", Font.BOLD, 14));
		add(na);

		// jname and textfeield for fname
		fname = new JLabel("Father's Name:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 200, 30);
		add(fname);

		fna = new JTextField();
		fna.setBounds(300, 190, 300, 30);
		fna.setFont(new Font("Raleway", Font.BOLD, 14));
		add(fna);

		// jname and jdatechooser for dob
		dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);

		db = new JDateChooser();
		db.setBounds(300, 240, 300, 30);
		add(db);

		// jname and Radio Button for gender
		gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.white);
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 90, 30);
		female.setBackground(Color.white);
		add(male);
		add(female);

		// this is used to group both the radiobutton so that only one radio button get
		// selected at a time whether its male or female.
		ButtonGroup gengrp = new ButtonGroup();
		gengrp.add(male);
		gengrp.add(female);

		// jname and textfeield for email
		email = new JLabel("Email::");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 200, 30);
		add(email);

		em = new JTextField();
		em.setBounds(300, 340, 300, 30);
		em.setFont(new Font("Raleway", Font.BOLD, 14));
		add(em);

		// jname and textfeield for address
		address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 390, 200, 30);
		add(address);

		add = new JTextField();
		add.setBounds(300, 390, 300, 30);
		add.setFont(new Font("Raleway", Font.BOLD, 14));
		add(add);

		// jname and RadioButton for marital
		marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 440, 200, 30);
		add(marital);

		mar = new JRadioButton("Married");
		mar.setBounds(300, 440, 70, 30);
		mar.setBackground(Color.white);
		far = new JRadioButton("Unmarried");
		far.setBounds(417, 440, 90, 30);
		far.setBackground(Color.white);
		bar = new JRadioButton("Other");
		bar.setBounds(545, 440, 100, 30);
		bar.setBackground(Color.white);
		add(mar);
		add(far);
		add(bar);

		// this is used to group both the radiobutton so that only one radio button get
		// selected at a time whether its male or female.
		ButtonGroup margrp = new ButtonGroup();
		margrp.add(mar);
		margrp.add(far);
		margrp.add(bar);

		// jname and textfeield for city
		city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 200, 30);
		add(city);

		cit = new JTextField();
		cit.setBounds(300, 490, 300, 30);
		cit.setFont(new Font("Raleway", Font.BOLD, 14));
		add(cit);

		// jname and textfeield for state
		state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 200, 30);
		add(state);

		st = new JTextField();
		st.setBounds(300, 540, 300, 30);
		st.setFont(new Font("Raleway", Font.BOLD, 14));
		add(st);

		// jname and textfeield for pincode
		pincode = new JLabel("Pin Code:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);

		pin = new JTextField();
		pin.setBounds(300, 590, 300, 30);
		pin.setFont(new Font("Raleway", Font.BOLD, 14));
		add(pin);

		// ***************** Making jbutton for next.
		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		// ********* to change color of the frame
		getContentPane().setBackground(Color.WHITE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) {
		String formno = ""+random;
		String name = na.getText();
		String father = fna.getText();
		String birth = ((JTextField) db.getDateEditor().getUiComponent()).getText();
		String gen = null;
		if (male.isSelected()) {
			gen = "Male";
		} else if (female.isSelected()) {
			gen = "Female";
		}
		String email = em.getText();
		String marital = null;
		if (mar.isSelected()) {
			marital = "Married";
		} else if (far.isSelected()) {
			marital = "Unmarried";
		} else if (bar.isSelected()) {
			marital = "Other";
		}

		String adres = add.getText();
		String citi = cit.getText();
		String stat = st.getText();
		String pp = pin.getText();

		try {
			if (name.equals("")) { // this is the validation for the name text field
				JOptionPane.showMessageDialog(null, "Name is Required	");
			} else {
				// ******ADDING TO DATABASE
				Conn c = new Conn();
				String query = "insert into signup values ('" + formno + "','" + name + "','" + father + "','" + birth
						+ "','" + gen + "','" + email + "','" + marital + "','" + adres + "','" + citi + "','" + stat
						+ "','" + pp + "')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new sin2(formno).setVisible(true);  //ye signuptwo to bhejega form no.
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

public class SignupOne {
	public static void main(String[] args) {
		spage ob = new spage();
		//ob.setSize(750, 760); // width,height
		//ob.setLocation(300, 5);
		ob.setVisible(true);
		//ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
