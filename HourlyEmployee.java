/** Kyle Gorlick
	 HourlyEmployee Class */

/** The HourlyEmployee class is a sub-class of Employee.
	 This class accepts values for an hourly-rate employee, calculates
	 the weekly pay accordingly, and passes the other values to the super-class*/
public class HourlyEmployee extends Employee
{
	private double hourlyWage;
	private double hoursWorked;
	
	/** Parameterized constructor uses mutators to set values passed from Corporation class,
		 as well as passing the rest of the values to super-classes*/
	public HourlyEmployee(String fName, String lName, String adrs, String cty,
		String st, String zip, int yrHired, int dptIndx, 
		double hrlyWge, double hrsWkd) throws BadAttributeValueException
	{
		super(fName, lName, adrs, cty, st, zip, yrHired, dptIndx);
		setHourlyWage(hrlyWge);
		setHoursWorked(hrsWkd);
	}
	
	/** Default constructor passed generic values into the parameterized constructor*/
	public HourlyEmployee() throws BadAttributeValueException
	{
		this("no","name","no address","no city","XX","00000",2000,1,10,40);
	}
	
	// accessors
	
	/** Accessor to retrieve hourly wage
		@return - returns hourly wage*/
	public double getHourlyWage()
	{
		return hourlyWage;
	}
	
	/** Accessor to retrieve number of hours worked
		@return - returns number of hours worked*/
	public double getHoursWorked()
	{
		return hoursWorked;
	}
	
	// mutators
	
	/** Mutator to set hourly wage
		@param hWage - hourly wage passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setHourlyWage(double hWage) throws BadAttributeValueException
	{
		if(hWage >= 10 && hWage <= 30)
		{
			hourlyWage = hWage;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The hourly wage",hWage);
		}
	}
	
	/** Mutator to set number of hours worked
		@param hWorked - number of hours worked passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setHoursWorked(double hWorked) throws BadAttributeValueException
	{
		if(hWorked >= 40 && hWorked <= 80)
		{
			hoursWorked = hWorked;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The number of hours",hWorked);
		}
	}
	
	// other methods
	
	/** this method created in the abstract Employee class is defined here
		 to multiply the hours worked by the hourly wage to calculate the weekly pay*/
	public double calcWeeklyPay()
	{
		double weeklyPay = hoursWorked * hourlyWage;
		weeklyPay = weeklyPay * 100;
		weeklyPay = Math.round(weeklyPay);
		weeklyPay = weeklyPay / 100;
		return weeklyPay;
	}
	
	// toString method is set to print info. to user
	public String toString()
	{
		return super.toString() + "Weekly pay: $" + calcWeeklyPay() + "\n";
	}
}