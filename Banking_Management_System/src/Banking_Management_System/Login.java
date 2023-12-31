package Banking_Management_System;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

@SuppressWarnings("serial")
class loginpage extends JFrame implements ActionListener {
   
	JButton login,clear,signup;
	JTextField cardtextfield;
	JPasswordField pintext;       //this will hid our password
	JLabel l1,cardno,pin;
	
	loginpage() {
		super("AUTOMATED TELLER MACHINE");

		String ai = "C:/Users/Tanishk kumar/Desktop/logo.jpg";
		ImageIcon ic = new ImageIcon(ai);
		Image i2 = ic.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT); // to set image size on the frame.
		ic = new ImageIcon(i2); // re allotment of image to imageicon object
		JLabel l = new JLabel(ic);

		setLayout(null); // setting borderlayout to null so that image can bw reposition
		l.setBounds(70, 10, 100, 100); // to set position of the image on the frame

		add(l);

		// ******************* to display text on the frame use JLabel
		l1 = new JLabel("Welcome To ATM"); // to display welcome to atm
		l1.setFont(new Font("Osward", Font.BOLD, 35));
		l1.setBounds(200, 40, 400, 40);
		add(l1);

		cardno = new JLabel("Card No:"); // to display card number
		cardno.setFont(new Font("Raleway", Font.BOLD, 28));
		cardno.setBounds(120, 150, 150, 40);
		add(cardno);

		pin = new JLabel("PIN:"); // to display pin
		pin.setFont(new Font("Osward", Font.BOLD, 28));
		pin.setBounds(120, 220, 400, 40);
		add(pin);
		
		

		// **************** to enter text for cardno and pin -->we use JTEXTFIELD
		cardtextfield = new JTextField();
		cardtextfield.setBounds(278, 155, 222, 29);
		cardtextfield.setFont(new Font("Arial",Font.BOLD,15));
		add(cardtextfield);

	    pintext = new JPasswordField();
		pintext.setBounds(278, 225, 222, 29);
		pintext.setFont(new Font("Arial",Font.BOLD,15));
		add(pintext);
		
		

		// **************** to add button in frame.
	    login = new JButton("SIGN IN"); // sign in button
		login.setBounds(278, 300, 100, 30);
		login.setBackground(Color.black);
		login.setForeground(Color.white); // change the foreground of the button
		login.addActionListener(this);
		add(login);

		clear = new JButton("CLEAR"); // clear button
		clear.setBounds(400, 300, 100, 30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);    //adding actionlistener 
		add(clear);

		signup = new JButton("SIGN UP"); // signup button
		signup.setBounds(278, 350, 222, 30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		

		// *********** to change the color of the frame
		getContentPane().setBackground(Color.WHITE);

	}
	
	
//*************** this will allow us to perform action when we click one of the button in our frame
	public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==clear) {
        	cardtextfield.setText("");
        	pintext.setText("");
        }
        else if(ae.getSource()==login) {
        	Conn c=new Conn();
        	String cardno=cardtextfield.getText();
        	@SuppressWarnings("deprecation")  // warnig ke liye hai
			String pin=pintext.getText();
        	String query="select * from login where Card_Number= '"+cardno+"' and Pin_Number= '"+pin+"'";
        	
        	try {
        		ResultSet rs=c.s.executeQuery(query);
        		if(rs.next()) {
        			setVisible(false);
        			new signin(pin).setVisible(true);   //open transaction page of transaction class
        		}
        		else {
        			JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
        		}
        	}catch (Exception e) {
        		System.out.println(e);
        	}
        }
        else if(ae.getSource()==signup){
        	setVisible(false);
        	new spage().setVisible(true);
        }
	}
}

public class Login {
	public static void main(String[] args) {
		loginpage ob = new loginpage();
		ob.setSize(800, 480);
		ob.setVisible(true);
		ob.setLocation(280, 140); // to set from where fram will occur on the screen
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
