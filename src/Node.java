import java.util.ArrayList;

public class Node
{
	private Node parent;
	private Number number;
	private int h; //admissible heuristic value for this node
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	public Node(Number number)
	{
		this.number = number;
	}
	
	public Node(Number number,int heuristic)
	{
		this.number = number;
		h = heuristic;
	}
	public Node parent()
	{
		return parent;
	}
	public Number getNumber()
	{
		return number;
	}
	
	public int getHValue()
	{
		return h;
	}
	
	public ArrayList<Node> getChildren()
	{
		return nodes;
	}
	
	public void setParent(Node node)
	{
		parent = node;
	}
}