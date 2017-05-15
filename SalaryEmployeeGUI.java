// Kyle Gorlick
// SalaryEmployeeGUI

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SalaryEmployeeGUI extends JFrame implements ActionListener
{
	JLabel fNm, lNm, str, ct, st, zp, yrHir, dpt, salar, ben;
	JTextField fTx, lTx, sTx, cTx, zTx, yrTx, salTx;
	JComboBox deptCB, benefitCB, stateCB;
	JButton addBut, hide;
	static ArrayList<Person> sal;
	SalaryEmployee sEmp;
	public SalaryEmployeeGUI(ArrayList<Person> al)
	{
		sal = al;
		setTitle("Enter Personal Information");
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(10,1));
		JPanel txts = new JPanel();
		txts.setLayout(new GridLayout(10,1));
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
		stateCB = new JComboBox();
		stateCB.addItem("Choose state");
		stateCB.addItem("AK");
		stateCB.addItem("AL");
		stateCB.addItem("AR");
		stateCB.addItem("AZ");
		stateCB.addItem("CA");
		stateCB.addItem("CO");
		stateCB.addItem("CT");
		stateCB.addItem("DE");
		stateCB.addItem("FL");
		stateCB.addItem("GA");
		stateCB.addItem("HI");
		stateCB.addItem("IA");
		stateCB.addItem("ID");
		stateCB.addItem("IL");
		stateCB.addItem("IN");
		stateCB.addItem("KS");
		stateCB.addItem("KY");
		stateCB.addItem("LA");
		stateCB.addItem("MA");
		stateCB.addItem("MD");
		stateCB.addItem("ME");
		stateCB.addItem("MI");
		stateCB.addItem("MN");
		stateCB.addItem("MO");
		stateCB.addItem("MS");
		stateCB.addItem("MT");
		stateCB.addItem("NC");
		stateCB.addItem("ND");
		stateCB.addItem("NE");
		stateCB.addItem("NH");
		stateCB.addItem("NJ");
		stateCB.addItem("NM");
		stateCB.addItem("NV");
		stateCB.addItem("NY");
		stateCB.addItem("OH");
		stateCB.addItem("OK");
		stateCB.addItem("OR");
		stateCB.addItem("PA");
		stateCB.addItem("RI");
		stateCB.addItem("SC");
		stateCB.addItem("SD");
		stateCB.addItem("TN");
		stateCB.addItem("TX");
		stateCB.addItem("UT");
		stateCB.addItem("VA");
		stateCB.addItem("VT");
		stateCB.addItem("WA");
		stateCB.addItem("WI");
		stateCB.addItem("WV");
		stateCB.addItem("WY");
		txts.add(stateCB);
		zp = new JLabel("Zip code:");
		labels.add(zp);
		zTx = new JTextField(5);
		txts.add(zTx);
		yrHir = new JLabel("Year hired:");
		labels.add(yrHir);
		yrTx  = new JTextField(4);
		txts.add(yrTx);
		dpt = new JLabel("Department:");
		labels.add(dpt);
		deptCB = new JComboBox();
		deptCB.addItem("Engineering");
		deptCB.addItem("Marketing");
		deptCB.addItem("Manufacturing");
		txts.add(deptCB);
		salar = new JLabel("Salary:");
		labels.add(salar);
		salTx = new JTextField(6);
		txts.add(salTx);
		ben = new JLabel("Benefits:");
		labels.add(ben);
		benefitCB = new JComboBox();
		benefitCB.addItem("Low Plan");
		benefitCB.addItem("Middle Plan");
		benefitCB.addItem("High Plan");
		txts.add(benefitCB);
		//	JLabel fNm, lNm, str, ct, st, zp, yrHir, dpt, salar, ben;
		//	JTextField fTx, lTx, sTx, cTx, txt, zTx, yrTx, salTx;
		addBut = new JButton("Add");
		addBut.addActionListener(this);
		JPanel but = new JPanel();
		but.setLayout(new FlowLayout());
		but.add(addBut);
		hide = new JButton("Hide");
		hide.addActionListener(this);
		but.add(hide);
		add(labels,"West");
		add(txts,"East");
		add(but,"South");
		setResizable(false);
		setVisible(false);
		pack();
	}
	
	String fName, lName, adrs, cty, sta, zip, yrHrd, slry;
	int year = -1;
	int dIndex = -1;
	double sala = -1;
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == addBut)
		{
			if(!fTx.getText().equals("") && !lTx.getText().equals("") && !sTx.getText().equals("") && 
				!cTx.getText().equals("") && !zTx.getText().equals("") && !yrTx.getText().equals("") && !salTx.getText().equals(""))
			{
				fName = fTx.getText();
				lName = lTx.getText();
				adrs = sTx.getText();
				cty = cTx.getText();
				sta = (String)stateCB.getSelectedItem();
				zip = zTx.getText();
				yrHrd = yrTx.getText();
				slry = salTx.getText();
				year = Integer.parseInt(yrHrd);
				sala = Double.parseDouble(slry);
				if(deptCB.getSelectedItem().equals("Engineering"))
				{
					dIndex = 1;
				}
				if(deptCB.getSelectedItem().equals("Marketing"))
				{
					dIndex = 2;
				}
				if(deptCB.getSelectedItem().equals("Manufacturing"))
				{
					dIndex = 3;
				}
				try
				{
					sEmp = new SalaryEmployee(fName,lName,adrs,cty,sta,zip,year,dIndex,sala);
					if(benefitCB.getSelectedItem().equals("Low Plan"))
					{
						sEmp.setBenefits(new LowPlan());
					}
					if(benefitCB.getSelectedItem().equals("Middle Plan"))
					{
						sEmp.setBenefits(new MidPlan());
					}
					if(benefitCB.getSelectedItem().equals("High Plan"))
					{
						sEmp.setBenefits(new HighPlan());
					}
					sal.add(sEmp);
					fTx.setText("");
					stateCB.setSelectedIndex(0);
					deptCB.setSelectedIndex(0);
					benefitCB.setSelectedIndex(0);
					lTx.setText("");
					sTx.setText("");
					cTx.setText("");
					zTx.setText("");
					yrTx.setText("");
					salTx.setText("");
				}
				catch(BadAttributeValueException ee)
				{
					 JOptionPane.showMessageDialog(null, ee.getMessage(), "Error - Bad Value(s) entered", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "You must fill in each textfield", "Error - Blank Text Field(s)", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		/*
		JLabel fNm, lNm, str, ct, st, zp, yrHir, dpt, salar, ben;
		JTextField fTx, lTx, sTx, cTx, txt, zTx, yrTx, salTx;
		JComboBox deptCB;
		JComboBox benefitCB;
		JButton addBut;
		*/
		if(e.getSource() == hide)
		{
			setVisible(false);
		}
	}
	public static void main(String [] args)
	{
		SalaryEmployeeGUI myGUI = new SalaryEmployeeGUI(sal);
	}
}