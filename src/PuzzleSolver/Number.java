package PuzzleSolver;
/**
 * COMP3308 Introduction to AI Assignment1
 * Number.java
 * Purpose: create Number class to store and manipulate 3-digit numbers
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class Number
{
	public enum Digit{NONE, FIRST, SECOND, THIRD};
	private int firstDigit;
	private int secondDigit;
	private int thirdDigit;
	private Digit lastChanged;
	
	/**
	 * Constructor of Number class
	 * A string as argument is given
	 * @param num
	 */
	public Number(String num)
	{
		firstDigit = Character.digit(num.charAt(0), 10);
		secondDigit = Character.digit(num.charAt(1), 10);
		thirdDigit = Character.digit(num.charAt(2), 10);
		lastChanged = Digit.NONE;
	}
	
	/**
	 * Constructor of Number class
	 * A node as argument is give
	 * @param node
	 */
	public Number(Node node)
	{
		this.firstDigit = node.getNumber().firstDigit;
		this.secondDigit = node.getNumber().secondDigit;
		this.thirdDigit = node.getNumber().thirdDigit;
		this.lastChanged = Digit.NONE;
	}
	
	/**
	 * @return which digit is the last changed
	 */
	public Digit lastChanged()
	{
		return lastChanged;
	}
	
	/**
	 * set lastChanged of the number as the given argument
	 * @param lastChanged
	 */
	public void setLastChanged(Digit lastChanged)
	{
		this.lastChanged = lastChanged;
	}
	
	/**
	 * @return the first digit of the number
	 */
	public int firstDigit()
	{
		return firstDigit;
	}
	
	/**
	 * @return the second digit of the number
	 */
	public int secondDigit()
	{
		return secondDigit;
	}
	
	/**
	 * @return the third digit of the number
	 */
	public int thirdDigit()
	{
		return thirdDigit;
	}
	
	/**
	 * @return the value of the number
	 */
	public String Value()
	{
		return Integer.toString(firstDigit)+Integer.toString(secondDigit)+Integer.toString(thirdDigit); 
	}
	
	/**
	 * increase the first digit of the number by 1
	 */
	public void firstDigitInc()
	{
		firstDigit+=1;
	}
	
	/**
	 * decrease the first digit of the number by 1
	 */
	public void firstDigitDec()
	{
		firstDigit-=1;
	}
	
	/**
	 * increase the second digit of the number by 1
	 */
	public void secondDigitInc()
	{
		secondDigit+=1;
	}
	
	/**
	 * decrease the second digit of the number by 1
	 */
	public void secondDigitDec()
	{
		secondDigit-=1;
	}
	
	/**
	 * increase the third digit of the number by 1
	 */
	public void thirdDigitInc()
	{
		thirdDigit+=1;
	}
	
	/**
	 * decrease the third digit of the number by 1
	 */
	public void thirdDigitDec()
	{
		thirdDigit-=1;
	}
}