import java.util.ArrayList;

public class Node
{
	private Node parent;
	private Number number;
	private ArrayList<Node> children = new ArrayList<Node>();
	
	public Node(Number number)
	{
		this.number = number;
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