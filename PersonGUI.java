// Kyle Gorlick
// PersonGUI

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class PersonGUI extends JFrame implements ActionListener
{
	JLabel fNm, lNm, str, ct, st, zp;
	JTextField fTx, lTx, sTx, cTx, txt, zTx;
	JButton next, hide;
	int checker;
	Person p;
	static ArrayList<Person> pal;
	public PersonGUI(ArrayList<Person> al)
	{
		checker = 0;
		pal = al;
		try
		{
			p = new Person();
		}
		catch(BadAttributeValueException e)
		{
			System.out.println(e.getMessage());
		}
		setTitle("Entry Information");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(7,1));
		JPanel txts = new JPanel();
		txts.setLayout(new GridLayout(7,1));
		fNm = new JLabel("First name:");
		labels.add(fNm);
		fTx = new JTextField(12);
		txts.add(fTx);
		lNm = new JLabel("Last name:");
		labels.add(lNm);
		lTx = new JTextField(30);
		txts.add(lTx);
		str = new JLabel("Street Address:");
		labels.add(str);
		sTx = new JTextField(35);
		txts.add(sTx);
		ct = new JLabel("City:");
		labels.add(ct);
		cTx = new JTextField(12);
		txts.add(cTx);
		st = new JLabel("State:");
		labels.add(st);
		txt = new JTextField(2);
		txts.add(txt);
		zp = new JLabel("Zip code:");
		labels.add(zp);
		zTx = new JTextField(5);
		txts.add(zTx);
		next = new JButton("Next");
		next.addActionListener(this);
		add(labels,"West");
		add(txts,"East");
		JPanel but = new JPanel();
		but.setLayout(new FlowLayout());
		hide = new JButton("Hide");
		hide.addActionListener(this);
		but.add(next);
		but.add(hide);
		add(but,"South");
		setResizable(false);
		setVisible(false);
		pack();
	}
	
	//String fName, lName, adrs, cty, sta, zip;
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == next)
		{
			if(checker < pal.size())
			{
				/*fName = fTx.getText();
				lName = lTx.getText();
				adrs = sTx.getText();
				cty = cTx.getText();
				sta = txt.getText();
				zip = zTx.getText();*/
				p = pal.get(checker);
				fTx.setText(p.getFirstName());
				lTx.setText(p.getLastName());
				sTx.setText(p.getAddress());
				cTx.setText(p.getCity());
				txt.setText(p.getState());
				zTx.setText(p.getZipCode());
				checker++;
			}
			else
			{
				JOptionPane.showMessageDialog(this, "All entries have been shown");
				checker = 0;
				fTx.setText("");
				lTx.setText("");
				sTx.setText("");
				cTx.setText("");
				txt.setText("");
				zTx.setText("");
			}
		}
		
		if(e.getSource() == hide)
		{
			setVisible(false);
		}
	}
	// fTx, lTx, sTx, cTx, txt, zTx;
	public static void main(String [] args)
	{
		PersonGUI myGUI = new PersonGUI(pal);
	}
}