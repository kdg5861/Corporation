// Kyle Gorlick
// SalaryEmployeeGUI

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class CorporationGUI extends JFrame implements ActionListener
{
	HourlyEmployeeGUI hempGUI;
	SalaryEmployeeGUI sempGUI;
	PersonGUI perGUI;
	JButton choose;
	JComboBox guiChoices;
	String[] choices = {"Choose One", "Hourly Employee","Salary Employee","Person"};
	String chosen;
	JMenuBar menu;
	JMenu file;
	JMenuItem exit;
	ArrayList <Person> al;
	
	public CorporationGUI()
	{
		al = new ArrayList<Person>();
		hempGUI = new HourlyEmployeeGUI(al);
		sempGUI = new SalaryEmployeeGUI(al);
		perGUI = new PersonGUI(al);
		hempGUI.setVisible(false);
		sempGUI.setVisible(false);
		perGUI.setVisible(false);
		setLayout(new BorderLayout());
		menu = new JMenuBar();
		file = new JMenu("File");
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		menu.add(file);
		file.add(exit);
		setJMenuBar(menu);
		choose = new JButton("Add/View");
		choose.addActionListener(this);
		add(choose, "East");
		guiChoices = new JComboBox(choices);
		add(guiChoices, "West");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		pack();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
		if(e.getSource() == choose)
		{
			chosen = (String)guiChoices.getSelectedItem();
			if(chosen.equals("Choose One"))
			{
				JOptionPane.showMessageDialog(null,"Choose an option from the drop-down menu","Message",JOptionPane.INFORMATION_MESSAGE);
			}
			if(chosen.equals("Hourly Employee"))
			{
				hempGUI.setVisible(true);
			}
			if(chosen.equals("Salary Employee"))
			{
				sempGUI.setVisible(true);
			}
			if(chosen.equals("Person"))
			{
				perGUI.setVisible(true);
			}
		}
	}
	
	public static void main(String [] args)
	{
		CorporationGUI myGUI = new CorporationGUI();
	}
}