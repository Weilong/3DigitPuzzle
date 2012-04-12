package PuzzleSolver;
import java.util.ArrayList;
/**
 * COMP3308 Introduction to AI Assignment1
 * Node.java
 * Purpose: store instances of Number class and relevant information
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class Node
{
	private Node parent;
	private Number number;
	private ArrayList<Node> children = new ArrayList<Node>();
	private int id;
	
	/**
	 * Constructor of Node class.
	 * member variable number will be initialized
	 * @param number
	 */
	public Node(Number number)
	{
		this.number = number;
	}
	
	/**
	 * @return id of the node
	 */
	public int id()
	{
		return id;
	}
	
	/**
	 * set id of the node as the given value
	 * @param ID
	 */
	public void setID(int ID)
	{
		this.id = ID;
	}
	
	/**
	 * @return the parent node of current node
	 */
	public Node parent()
	{
		return parent;
	}
	
	/**
	 * @return number of the node
	 */
	public Number getNumber()
	{
		return number;
	}
	
	/**
	 * @return children list of the node
	 */
	public ArrayList<Node> getChildren()
	{
		return children;
	}
	
	/**
	 * set the parent node of current node as the given node
	 * @param node
	 */
	public void setParent(Node node)
	{
		parent = node;
	}
}