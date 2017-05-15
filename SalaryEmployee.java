/** Kyle Gorlick
	 SalaryEmployee Class*/

/** The SalaryEmployee class is a sub-class of Employee.
	 This class accepts values for salary paid employee, calculates
	 the weekly pay accordingly, and passes the other values to the super-class*/
public class SalaryEmployee extends Employee
{
	private double yearlySalary;
	
	/** Parameterized constructor uses mutators to set values passed from Corporation class,
		 as well as passing the rest of the values to super-classes*/
	public SalaryEmployee(String fName, String lName, String adrs, String cty,
		String st, String zip, int yrHired, 
		int dptIndx, double slry) throws BadAttributeValueException
	{
		super(fName, lName, adrs, cty, st, zip, yrHired, dptIndx);
		setYearlySalary(slry);
	}
	
	/** Default constructor passed generic values into the parameterized constructor*/
	public SalaryEmployee() throws BadAttributeValueException
	{
		this("no","name","no address","no city","XX","00000",2000,1,40000);
	}
	
	/** Accessor to retrieve yearly salary
		@return - returns yearly salary*/
	public double getYearlySalary()
	{
		return yearlySalary;
	}
	
	/** Mutator to set salary
		@param salary - salary figure passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setYearlySalary(double salary) throws BadAttributeValueException
	{
		if(salary >= 40000 && salary <= 120000)
		{
			yearlySalary = salary;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The yearly salary",salary);
		}
	}
	
	/** this method created in the abstract Employee class is defined here
		 to divide the salary by 52 weeks in order to calculate the weekly pay*/
	public double calcWeeklyPay()
	{
		double weeklyPay = yearlySalary/52;
		weeklyPay = weeklyPay * 100;
		weeklyPay = Math.round(weeklyPay);
		weeklyPay = weeklyPay / 100;
		return weeklyPay;
	}
	
	// toString method is set to print info to user
	public String toString()
	{
		return super.toString() + "Weekly pay: $" + calcWeeklyPay() + "\n";
	}
}