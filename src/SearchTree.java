public class SearchTree
{
	private Node root;
	private int height;
	
	public SearchTree(Node start)
	{
		root = start;
		height = 0;
	}
	
	public Node Root()
	{
		return root;
	}
	
	public void incHeight()
	{
		height +=1; 
	}
	
	public int Height()
	{
		return height;
	}
}