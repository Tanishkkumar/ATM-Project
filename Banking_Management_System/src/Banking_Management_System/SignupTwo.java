package Banking_Management_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class sin2 extends JFrame implements ActionListener {
	JLabel form2, religion, category, income, education, qual, occupation, pan, adhar, senior, exist;
	JTextField paan, adhaar;
	JRadioButton sen1, sen2, ex1, ex2;
	JButton next;
	String formno;
	@SuppressWarnings("rawtypes")
	JComboBox re, in, ca, cq, oc;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	sin2(String formno) {
		super("AUTOMATED TELLER MACHINE");
		this.formno = formno;
		setSize(750, 760);
		setLocation(300, 5);
		setLayout(null);

		form2 = new JLabel("Page2: Additional Details");
		form2.setFont(new Font("Ralewat", Font.BOLD, 30));
		form2.setBounds(200, 15, 600, 40);
		add(form2);

		religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(75, 120, 400, 30);
		add(religion);

		String valrel[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
		re = new JComboBox(valrel);
		re.setBounds(300, 120, 300, 25);
		re.setBackground(Color.WHITE);
		add(re);

		category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(75, 170, 400, 30);
		add(category);

		String valcat[] = { "GENERAL", "OBC", "SC/ST", "Other" };
		ca = new JComboBox(valcat);
		ca.setBounds(300, 170, 300, 25);
		ca.setBackground(Color.WHITE);
		add(ca);

		income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(75, 220, 400, 30);
		add(income);

		String valin[] = { ">50000", ">=200000", "<20000", "Null" };
		in = new JComboBox(valin);
		in.setBounds(300, 220, 300, 25);
		in.setBackground(Color.WHITE);
		add(in);

		education = new JLabel("Educational");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(75, 270, 400, 30);
		add(education);
		qual = new JLabel("Qualification:");
		qual.setFont(new Font("Raleway", Font.BOLD, 20));
		qual.setBounds(75, 290, 400, 30);
		add(qual);

		String valq[] = { "Intermediate", "Graduate", "Post-Graduate", "P.H.D" };
		cq = new JComboBox(valq);
		cq.setBounds(300, 290, 300, 25);
		cq.setBackground(Color.WHITE);
		add(cq);

		occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(75, 340, 400, 30);
		add(occupation);

		String valocc[] = { "Salaried", "Self-Employed", "Buisiness", "Student", "Others" };
		oc = new JComboBox(valocc);
		oc.setBounds(300, 340, 300, 25);
		oc.setBackground(Color.WHITE);
		add(oc);

		pan = new JLabel("Pan Number:");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(75, 390, 400, 30);
		add(pan);

		paan = new JTextField();
		paan.setBounds(300, 390, 300, 25);
		paan.setFont(new Font("Raleway", Font.BOLD, 15));
		add(paan);

		adhar = new JLabel("Aadhar Number:");
		adhar.setFont(new Font("Raleway", Font.BOLD, 20));
		adhar.setBounds(75, 440, 400, 30);
		add(adhar);

		adhaar = new JTextField();
		adhaar.setBounds(300, 440, 300, 25);
		adhaar.setFont(new Font("Raleway", Font.BOLD, 15));
		add(adhaar);

		senior = new JLabel("Senior Citizen:");
		senior.setFont(new Font("Raleway", Font.BOLD, 20));
		senior.setBounds(75, 490, 400, 30);
		add(senior);

		sen1 = new JRadioButton("Yes");
		sen1.setBounds(300, 490, 90, 30);
		add(sen1);
		sen2 = new JRadioButton("No");
		sen2.setBounds(400, 490, 90, 30);
		add(sen2);

		ButtonGroup s = new ButtonGroup();
		s.add(sen1);
		s.add(sen2);

		exist = new JLabel("Existing Account:");
		exist.setFont(new Font("Raleway", Font.BOLD, 20));
		exist.setBounds(75, 540, 400, 30);
		add(exist);

		ex1 = new JRadioButton("Yes");
		ex1.setBounds(300, 540, 90, 30);
		add(ex1);
		ex2 = new JRadioButton("No");
		ex2.setBounds(400, 540, 90, 30);
		add(ex2);

		ButtonGroup e = new ButtonGroup();
		e.add(ex1);
		e.add(ex2);

		next = new JButton("Next");
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 630, 80, 30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String sreligion = (String) re.getSelectedItem();
		String scategory = (String) ca.getSelectedItem();
		String sincome = (String) in.getSelectedItem();
		String squalification = (String) cq.getSelectedItem();
		String soccupation = (String) oc.getSelectedItem();

		String ssenior = null;    // this is for the RadioButton
		if (sen1.isSelected()) {
			ssenior = "Yes";
		} else if (sen2.isSelected()) {
			ssenior = "No";
		}

		String sexist = null;
		if (ex1.isSelected()) {
			sexist = "Yes";
		} else if (ex2.isSelected()) {
			sexist = "No";
		}

		String span = paan.getText();
		String sadhar = adhaar.getText();

		try {
			Conn c = new Conn();
			String query = "insert into signupTwo values ('" + formno + "','" + sreligion + "','" + scategory + "','"
					+ sincome + "','" + squalification + "','" + soccupation + "','" + ssenior + "','" + sexist + "','"
					+ span + "','" + sadhar + "')";
			c.s.executeUpdate(query);
			

			setVisible(false);
			new sin3(formno).setVisible(true); 
		} catch (Exception e1) {
			System.out.println(e1);
		}
	}
}

public class SignupTwo {
	public static void main(String[] args) {
		sin2 ob = new sin2("");
		// ob.setBackground(Color.blue);
		ob.setVisible(true);
	}
}
