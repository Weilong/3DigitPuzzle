import java.util.ArrayList;



public class Number
{
	public enum Digit{NONE, FIRST, SECOND, THIRD};
	private int firstDigit;
	private int secondDigit;
	private int thirdDigit;
	private Digit lastChanged;
	
	public Number(String num)
	{
		firstDigit = Character.digit(num.charAt(0), 10);
		secondDigit = Character.digit(num.charAt(1), 10);
		thirdDigit = Character.digit(num.charAt(2), 10);
		lastChanged = Digit.NONE;
	}
	
	public Number(int firstDigit,int secondDigit,int thirdDigit)
	{
		this.firstDigit = firstDigit;
		this.secondDigit = secondDigit;
		this.thirdDigit = thirdDigit;
		lastChanged = Digit.NONE;
	}
	
	public boolean isForbidden(ArrayList<String> forbidden)
	{
		//TODO
		return false;
	}
	
	public Digit lastChanged()
	{
		return lastChanged;
	}
	
	public int firstDigit()
	{
		return firstDigit;
	}
	
	public int secondDigit()
	{
		return secondDigit;
	}
	
	public int thirdDigit()
	{
		return thirdDigit;
	}
	
	public String Value()
	{
		return Integer.toString(firstDigit)+Integer.toString(secondDigit)+Integer.toString(thirdDigit); 
	}
	
	public String toString()
	{
		return Integer.toString(firstDigit)+Integer.toString(secondDigit)+Integer.toString(thirdDigit); 
	}
}