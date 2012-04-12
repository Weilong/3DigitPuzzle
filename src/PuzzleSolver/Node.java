package PuzzleSolver;
import java.util.ArrayList;

public class Node
{
	private Node parent;
	private Number number;
	private ArrayList<Node> children = new ArrayList<Node>();
	private int ID;
	
	public Node(Number number)
	{
		this.number = number;
	}
	public int ID()
	{
		return ID;
	}
	public void setID(int ID)
	{
		this.ID = ID;
	}
	public Node parent()
	{
		return parent;
	}
	public Number getNumber()
	{
		return number;
	}
	
	public ArrayList<Node> getChildren()
	{
		return children;
	}
	
	public void setParent(Node node)
	{
		parent = node;
	}
}