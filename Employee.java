/** Kyle Gorlick
	 Employee Class*/

/** The Employee class is a sub-class of Person.  Employee is an abstract
	 class that is a super-class for HourlyEmployee and SalaryEmployee.
	 This class collects the dept. and year hired for each employee*/
public abstract class Employee extends Person
{
	private int yearHired;
	private static final int ENGINEERING = 1;
	private static final int MARKETING = 2;
	private static final int MANUFACTURING = 3;
	private int deptIndex;
	int currentYear = 2017;
	Benefits ben;
	
	/** Parameterized constructor uses mutators to set values passed from other classes,
		 as well as passing in personal info. up to Person super-class*/
	public Employee(String fName, String lName, String adrs, String cty,
		String st, String zip, int yrHired, int dptIndx) throws BadAttributeValueException
	{
		super(fName, lName, adrs, cty, st, zip);
		setYearHired(yrHired);
		setDept(dptIndx);
	}
	
	/** Default constructor passed generic values into the parameterized constructor*/
	public Employee() throws BadAttributeValueException
	{
		this("no","name","no address","no city","XX","00000",2000,1);
	}
	
	/** Accessors*/
	
	/** Accessor to retrieve year hired
		@return - returns year hired*/
	public int getYearHired()
	{
		return yearHired;
	}
	
	/** Accessor to retrieve department
		@return - returns department*/
	public String getDept()
	{
		if(deptIndex == ENGINEERING)
		{
			return "Engineering";
		}
		if(deptIndex == MARKETING)
		{
			return "Marketing";
		}
		if(deptIndex == MANUFACTURING)
		{
			return "Manufacturing";
		}
		else
		{
			return "None";
		}
	}
	
	/** Accessor to retrieve benefits
		@return - returns which benefit plan the employee has*/
	public String getBenefits()
	{
		if(ben instanceof HighPlan)
		{
			return "Benefit plan: High";
		}
		if(ben instanceof MidPlan)
		{
			return "Benefit plan: Medium";
		}
		if(ben instanceof LowPlan)
		{
			return "Benefit plan: Low";
		}
		else
		{
			return "Benefit plan accessor error";
		}
	}
	
	/** Mutators*/
	
	/** Mutator to set year hired
		@param yr - year passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setYearHired(int yr) throws BadAttributeValueException
	{
		if(yr >= 1930 && yr <= 2017)
		{
			yearHired = yr;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The year",yr);
		}
	}
	
	/** Mutator to set department
		@param deptChc - department choice passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setDept(int deptChc) throws BadAttributeValueException
	{
		if(deptChc >= 1 && deptChc <= 3)
		{
			deptIndex = deptChc;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The dep't. choice",deptChc);
		}
	}
	
	/** Mutator to set department
		@param b - Benefit object passed from EmployeeUtilities class*/
	public void setBenefits(Benefits b)
	{
		ben = b;
	}
	
	// other methods
	
	// abstract method that is defined in HourlyEmployee and SalaryEmployee sub-classes
	public abstract double calcWeeklyPay();
	
	// method to calculate the number of years an employee has been with the company
	public int numYearsWorked()
	{
		return currentYear - yearHired;
	}
	
	// toString method prints values
	public String toString()
	{
		return super.toString() + "Number of years worked: " + numYearsWorked() + "\n";
	}
}