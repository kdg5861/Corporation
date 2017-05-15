/** Kyle Gorlick
	 BadAttributeValueException Class*/

public class BadAttributeValueException extends Exception
{
	public BadAttributeValueException()
	{
		super("An error has occurred while trying to set an attribute value");
	}
	public BadAttributeValueException(String message)
	{
		super(message);
	}
	public BadAttributeValueException(String attName, int badValue)
	{
		super(attName + " " + badValue + " is a bad value");
	}
	public BadAttributeValueException(String attName, double badValue)
	{
		super(attName + " " + badValue + " is a bad value");
	}
	public BadAttributeValueException(String attName, String badValue)
	{
		super(attName + " " + badValue + " is a bad value");
	}
}