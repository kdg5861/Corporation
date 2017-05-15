/** Kyle Gorlick
	 Person Class*/


/** The Person class is the super class for the abstract Employee class.
	This class collects personal information about each employee*/
public class Person
{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	
	/** Parameterized constructor uses mutators to set values passed from other classes*/
	public Person(String fName, String lName, String adrs, String cty,
		String st, String zip) throws BadAttributeValueException
	{
		setFirstName(fName);
		setLastName(lName);
		setAddress(adrs);
		setCity(cty);
		setState(st);
		setZipCode(zip);
	}
	/** Default constructor passed generic values into the parameterized constructor*/
	public Person() throws BadAttributeValueException
	{
		this("no","name","no address","no city","XX","00000");
	}
	
	// accessors
	
	/** Accessor to retrieve first name
		@return - returns first name*/
	public String getFirstName()
	{
		return firstName;
	}
	
	/** Accessor to retrieve last name
		@return - returns last name*/
	public String getLastName()
	{
		return lastName;
	}
	
	/** Accessor to retrieve address
		@return - returns address*/
	public String getAddress()
	{
		return address;
	}
	
	/** Accessor to retrieve city
		@return - returns city*/
	public String getCity()
	{
		return city;
	}
	
	/** Accessor to retrieve state
		@return - returns state*/
	public String getState()
	{
		return state;
	}
	
	/** Accessor to retrieve zipcode
		@return - returns zipcode*/
	public String getZipCode()
	{
		return zipCode;
	}
	
	// mutators
	
	/** Mutator to set first name
		@param fName - first name passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setFirstName(String fName) throws BadAttributeValueException
	{
		if(fName.length() > 0 && fName.length() < 13)
		{
			firstName = fName;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The first name",fName);
		}
	}
	
	/** Mutator to set last name
		@param lName - last name passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setLastName(String lName) throws BadAttributeValueException
	{
		if(lName.length() > 0 && lName.length() < 31)
		{
			lastName = lName;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The last name",lName);
		}
	}
	
	/** Mutator to set address
		@param adrs - address passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setAddress(String adrs) throws BadAttributeValueException
	{
		if(adrs.length() > 0 && adrs.length() < 36)
		{
			address = adrs;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The address",adrs);
		}
	}
	
	/** Mutator to set city
		@param cty - city value passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setCity(String cty) throws BadAttributeValueException
	{
		if(cty.length() > 0 && cty.length() < 13)
		{
			city = cty;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The city name",cty);
		}
	}
	
	/** Mutator to set state
		@param st - state name passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setState(String st) throws BadAttributeValueException
	{
		if(st.length() == 2)
		{
			st = st.toUpperCase();
			state = st;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The state name",st);
		}
	}
	
	/** Mutator to set zip code - checks zp string to ensure each value is numeric
		@param zp - zipcode passed in from Corporation class
		@return - indicates true for value change / false if no change made*/
	public boolean setZipCode(String zp) throws BadAttributeValueException
	{
		int ascii = -1;
		int junk = 0;
		int validator = 0;
		for(int i = 0; i < zp.length(); i++)
		{
			ascii = (int)zp.charAt(i);
			if(ascii >= 48 && ascii <= 57)
			{
				junk ++;
			}
			else
			{
				validator ++;
			}
		}
		if(validator == 0 && zp.length() == 5)
		{
			zipCode = zp;
			return true;
		}
		else
		{
			throw new BadAttributeValueException("The zip code entry",zp);
		}
	}
	
	// toString method prints values
	public String toString()
	{
		return getFirstName() + " " + getLastName() + "\n" + getAddress()
			+ "\n" + getCity() + ", " + getState() + " " + getZipCode() + "\n";
	}
}