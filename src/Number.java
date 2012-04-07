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
	
	public Number(Node node)
	{
		this.firstDigit = node.getNumber().firstDigit;
		this.secondDigit = node.getNumber().secondDigit;
		this.thirdDigit = node.getNumber().thirdDigit;
		this.lastChanged = Digit.NONE;
	}
	
	public Digit lastChanged()
	{
		return lastChanged;
	}
	
	public void setLastChanged(Digit lastChanged)
	{
		this.lastChanged = lastChanged;
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
	
	public void firstDigitInc()
	{
		firstDigit+=1;
	}
	
	public void firstDigitDec()
	{
		firstDigit-=1;
	}
	
	public void secondDigitInc()
	{
		secondDigit+=1;
	}
	
	public void secondDigitDec()
	{
		secondDigit-=1;
	}
	
	public void thirdDigitInc()
	{
		thirdDigit+=1;
	}
	
	public void thirdDigitDec()
	{
		thirdDigit-=1;
	}
	
	public String toString()
	{
		return Integer.toString(firstDigit)+Integer.toString(secondDigit)+Integer.toString(thirdDigit); 
	}
}