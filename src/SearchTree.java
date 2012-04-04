public class SearchTree
{
	private Node root;
	private Node curr;
	private int height;
	
	public SearchTree(Node start)
	{
		root = start;
		curr = root;
		height = 0;
	}
	
	public Node Root()
	{
		return root;
	}
	
	public Node getCurr()
	{
		return curr;
	}
	
	public void setCurr(Node node)
	{
		curr = node;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void addNode(Node child)
	{
		curr.getChildren().add(child);
	}
}