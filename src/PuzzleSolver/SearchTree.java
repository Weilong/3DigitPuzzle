package PuzzleSolver;
/**
 * COMP3308 Introduction to AI Assignment1
 * SearchTree.java
 * Purpose: create a tree to store all the generated nodes
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class SearchTree
{
	private Node root;
	
	/**
	 * Constructor of SearchTree class
	 * the root of the tree is initialized
	 * @param start
	 */
	public SearchTree(Node start)
	{
		root = start;
	}
	
	/**
	 * @return the root of the tree
	 */
	public Node root()
	{
		return root;
	}
}