package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class depo extends JFrame implements ActionListener{
	JLabel l,entry;
	JTextField text;
	JButton depo,back;
   String pin;
	depo(String pin) {
		super("AUTOMATED TELLER MACHINE");
		this.pin=pin;
		setSize(800,  750);
		setLocation(300, 0);

		setLayout(null);

		// ********* setting frame and image
		String ai = "C:/Users/Tanishk kumar/Desktop/atm.jpg";
		ImageIcon ic = new ImageIcon(ai);
		Image i2 = ic.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ic = new ImageIcon(i2); // re allotment of image to imageicon object
		l = new JLabel(ic);
		l.setBounds(0, 0, 800, 730); // x,y,width,height
		add(l);
		
		// ******** setting entry over the image 
		entry=new JLabel("Enter Amount You Want To Deposit");
		entry.setBounds(160,235,300,30);
		entry.setForeground(Color.WHITE);
	   entry.setFont(new Font("Raleway",Font.BOLD,16));
	   l.add(entry);
	   
	   
	   //************ Enter the text field in the frame.
	   text=new JTextField();
	   text.setFont(new Font("Raleway",Font.BOLD,22));
	   text.setBounds(160,280,270,30);	
	   l.add(text);
	   
	   
	   //********* adding Button in the frame
	   depo=new JButton("Deposit");
	   depo.setBounds(330, 395, 120, 25);
	   depo.addActionListener(this);
	   l.add(depo);
	   
	   back=new JButton("Back");
	   back.setBounds(330, 425, 120, 25);
	   back.addActionListener(this);
	   l.add(back);

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==depo) {
			String amount=text.getText();
			Date date=new Date();
			if(amount.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
			}
			else {
				try {
				Conn c=new Conn();
				String query = "insert into Bankdata  values ('" + pin + "','" + date+ "', 'Deposit','" +amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+amount+" Deposited Successfully");
			setVisible(false);
			new signin(pin).setVisible(true);
				}catch (Exception ae) {
					System.out.println(ae);
				}
				
			}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new signin(pin).setVisible(true);
		}
	}
}

public class Deposit {
	public static void main(String[] args) {
		depo ob = new depo("");
		ob.setVisible(true);
	}
}
