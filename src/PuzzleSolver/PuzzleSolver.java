package PuzzleSolver;
import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
/**
 * COMP3308 Introduction to AI Assignment1
 * PuzzleSolver.java
 * Purpose: the main class of the program. receive the command from user
 * and do the chosen algorithm on given data. when searching is done print
 * out the path and expanded node list. If the searching hits the limit,
 * print out a warning message "Depth limit reached"
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class PuzzleSolver
{
	final int SEARCHLIMIT =1000;	//set a limit of 1000 expanded nodes maximum
	
	private Number start;
	private Number goal;
	private ArrayList<String> forbidden = new ArrayList<String>(); 
	private Queue<Node> fringe;
	private Queue<Node>	expanded;
	
	/*
	 * tmpExpanded list is to store the expanded nodes in IDS in 
	 * each round so that when check cycle, the nodes from earlier 
	 * round won't be checked. after each round tmpExpanded will be
	 * appended to expanded.
	 */
	private Queue<Node>	tmpExpanded; 
	private Stack<Node> path;
	private SearchTree tree;
	private int nodeNum;	//the total number of generated nodes
	
	/**
	 * This is the constructor of PuzzleSolver class which will read
	 * a file and initialize start, goal, and forbidden number list
	 * @param filename the directory of input file
	 */
	public PuzzleSolver(String filename)
	{
		this.readFile(filename);		
	}
	
	/**
	 * Read a file from given directory and assign values to start, 
	 * goal and forbidden number list
	 */
	public void readFile(String filename)
	{
		File file = new File(filename);
		try {
			Scanner s = new Scanner(file);
			start = new Number(s.nextLine());
			goal = new Number(s.nextLine());
			if (s.hasNextLine())
			{
				for (String number:s.nextLine().split(","))
				{
					forbidden.add(number);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Does the main logic of 3 digit puzzle solver. Certain search
	 * algorithm will run according to the given strategy.
	 * @param strategy refers to the first char of chosen algorithm
	 */
	public void solve(char strategy)
	{
		fringe = new LinkedList<Node>();
		expanded = new LinkedList<Node>();
		tmpExpanded = new LinkedList<Node>();
		path = new Stack<Node>();
		tree = new SearchTree(new Node(start));
			
		switch (strategy)
		{
		case 'B':	//run breadth-first search
			if(BFS(tree.root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.print("Depth limit reached");					
			break;
		case 'D':	//run depth-first-search
			if(DFS(tree.root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.print("Depth limit reached");
			break;
		case 'I':	//run iterative-depth-search
			if(IDS(tree.root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.print("Depth limit reached");
			break;
		case 'G':	//run greedy search
			if(Greedy(tree.root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.print("Depth limit reached");
			break;
		case 'A':	//run A* search
			if(AStar(tree.root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.print("Depth limit reached");
			break;
		case 'H':	//run hill-climbing search
			HillClimbing(tree.root());
			/*
			 * for hill-climbing search the result should be printed
			 * out no matter the goal is found or not. for in hill-
			 * climbing search only store one node in the memory, we
			 * need to trace back from where we stop.therefore before 
			 * print out the path we need turn the path over so that 
			 * it will be printed out in a correct order
			 */
			Queue<Node> tmpQ = new LinkedList<Node>();
			path.addAll(expanded);
			while (!path.isEmpty())
				tmpQ.add(path.pop());
			while (!tmpQ.isEmpty())
				path.add(tmpQ.poll());
			
			printPath();
			System.out.println();
			printExpanded();
			break;
		default:
		}
	}
	
	/**
	 * Does breadth-first-search from start to find the goal
	 * @param node is the start node
	 * @return result of BFS, if goal found return true,
	 * otherwise return false.
	 */
	public boolean BFS(Node node)
	{
		Number tmpNum;
		Node tmpNode;
		Node curr = null;
		fringe.add(node);
		//searching will stop when the number of expanded nodes hits the limit
		while(expanded.size()<SEARCHLIMIT)
		{
			/*
			 * avoid cycles: select a node from the fringe for expansion
			 * if it has not been expanded yet, expand it;else discard it
			 */
			boolean unvisited =false;
			while(!unvisited)
			{
				if (fringe.size()==0)	//when there is no node left for expanding, stop searching
					return true;
				curr = fringe.remove();
				unvisited= true;
				/*
				 * if expanded node list is not empty, compare current node with nodes in expanded list
				 * only two numbers with same value and same last changed digit are considered as identical
				 * only two nodes with identical numbers are considered identical. if a node has been visited,
				 * remove it from fringe, pop out another one and keep comparing until the current node is 
				 * unvisited or fringe become empty
				 */
				if (!expanded.isEmpty())
				{
					for (Node n:expanded)
					{	
						if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
						{
							unvisited = false;
							break;
						}
					}
				}				
			}
			
			expanded.add(curr);
			
			/*
			 * if the goal is reached, prepare path list and return true
			 */
			if (curr.getNumber().Value().equals(goal.Value()))
			{
				while(curr!=null)
				{
					path.push(curr);
					curr = curr.parent();
				}		
				return true;
			}
				
			/*
			 * Each node has no more than six possible children:
			 * 1) if first digit has not been changed last time
			 * we can get two children by adding and subtracting 1
			 * from first digit
			 * 2) if second digit has not been changed last time
			 * we can get two children by adding and subtracting 1
			 * from the second digit
			 * 3) if third digit has not been changed last time
			 * we can get two children by adding and subtracting 1
			 * from the third digit
			 */
			/*
			 * if first digit has not been changed,manipulate the first digit
			 */
			if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)	
			{
				//if first digit larger than 0, increase by 1
				if (curr.getNumber().firstDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitDec();
					tmpNum.setLastChanged(Number.Digit.FIRST);	//set lastChangedDigit as first digit
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}					
				}
				//if first digit less than 0, decrease by 1
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}	
				}
			}
			/*
			 * if secondDigit has not been changed,manipulate the second digit
			 */
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)	
			{
				//if second digit larger than 0, increase by 1
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}	
				}
				//if second digit less than 9, decrease by 1
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}	
				}
			}
			/*
			 * if thirdDigit has not been changed, manipulate the third digit
			 */
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)	
			{
				//if third digit larger than 0, increase by 1
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}	
				}
				//if third digit less than 9, decrease by 1
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					//if the number is not forbidden, create node
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Does depth-first-search from start to find the goal
	 * @param node is the latest expanded node
	 * @return result of DFS, if goal found return true,
	 * otherwise return false.
	 */
	public boolean DFS(Node node)
	{
		/*
		 * if the number of expanded node hits the limit, jump out
		 * of the recursion
		 */
		if(expanded.size()==SEARCHLIMIT)
			return false;
		
		Number tmpNum;
		Node tmpNode;
		Node curr = node;

		/*
		 * avoid cycles: select a node from the fringe for expansion
		 * if it has not been expanded yet, expand it;else discard it
		 */
		if (!expanded.isEmpty())
		{
			for (Node n:expanded)
			{	
				if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
				{
					return false;
				}
			}
		}				
		
		expanded.add(curr);
		
		if (curr.getNumber().Value().equals(goal.Value()))
		{
			path.push(curr);
			return true;
		}	
				
		if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
		{
			if (curr.getNumber().firstDigit()>0)
			{
				tmpNum = new Number(curr);
				tmpNum.firstDigitDec();
				tmpNum.setLastChanged(Number.Digit.FIRST);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					/*
					 * pass the generated node to another DFS method
					 * to do recursion. if goal found true will be returned
					 * and the current node will be pushed into path list
					 * while the searching gets all the way out of the recursion
					 */
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}							
				}										
			}
			if (curr.getNumber().firstDigit()<9)
			{
				tmpNum = new Number(curr);
				tmpNum.firstDigitInc();
				tmpNum.setLastChanged(Number.Digit.FIRST);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}	
				}
			}
		}
		if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
		{
			if (curr.getNumber().secondDigit()>0)
			{
				tmpNum = new Number(curr);
				tmpNum.secondDigitDec();
				tmpNum.setLastChanged(Number.Digit.SECOND);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}
				}
			}
			if (curr.getNumber().secondDigit()<9)
			{
				tmpNum = new Number(curr);
				tmpNum.secondDigitInc();
				tmpNum.setLastChanged(Number.Digit.SECOND);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}
				}
			}
		}
		if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
		{
			if (curr.getNumber().thirdDigit()>0)
			{
				tmpNum = new Number(curr);
				tmpNum.thirdDigitDec();
				tmpNum.setLastChanged(Number.Digit.THIRD);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}	
				}
			}
			if (curr.getNumber().thirdDigit()<9)
			{
				tmpNum = new Number(curr);
				tmpNum.thirdDigitInc();
				tmpNum.setLastChanged(Number.Digit.THIRD);
				if (!forbidden.contains(tmpNum.Value()))
				{	
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
					if (DFS(tmpNode))
					{
						path.push(curr);
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	/**
	 * Does iterative-deepening-search from start to find the goal
	 * @param node is the start node
	 * @return result of IDS, if goal found return true,
	 * otherwise return false.
	 */
	public boolean IDS(Node node)
	{
		boolean result = false;
		for (int limit=0;limit<Double.POSITIVE_INFINITY;limit++)
		{
			result = DLS(node,limit);
			tmpExpanded.clear();			//clear tmpExpanded for next round.
			if (result)
				return result;
			
			if (expanded.size()==SEARCHLIMIT)
				return result;
		}
		return result;
	}
	
	/**
	 * Does depth-limited-search from start to find the goal
	 * @param node is the start node
	 * @param depth is the limit the searching can reach
	 * @return result of DLS, if goal found return true,
	 * otherwise return false.
	 */
	public boolean DLS(Node node,int depth)
	{
		if(expanded.size()==SEARCHLIMIT)
				return false;
		if (depth>=0)
		{
			Number tmpNum;
			Node tmpNode;
			Node curr = node;
			//if the current node has already been expanded, jump out of this round
			if (!expanded.isEmpty())
			{
				for (Node n:tmpExpanded)
				{	
					if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
					{
						return false;
					}
				}
			}			
			
			tmpExpanded.add(curr);
			expanded.add(curr);
			if (curr.getNumber().Value().equals(goal.Value()))
			{
				path.push(curr);
				return true;
			}	
					
			if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
			{
				if (curr.getNumber().firstDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitDec();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}							
					}											
				}
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}	
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}
					}
				}
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}	
					}
				}
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{	
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						if (DLS(tmpNode,depth-1))
						{
							path.push(curr);
							return true;
						}	
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Does greedy search from start to find the goal
	 * @param node is the start node
	 * @return result of Greedy, if goal found return true,
	 * otherwise return false.
	 */
	public boolean Greedy(Node node)
	{
		Number tmpNum;
		Node tmpNode;
		Node curr = node;
		nodeNum = 1;
		/*
		 * Due to the specificity of informed search, we need to use a 
		 * Priority Queue as the fringe.the fringe will store the nodes
		 * in a non-decreasing order.what is more important is that if we
		 * got nodes with same heuristic value, the last added node should
		 * always be stored in front of the others with same value.
		 * if we only compare the heuristic value, the last added node will
		 * be stored at the end by default
		 * therefore here to cater our requirements we need to override the
		 * comparator to have a second criteria to compare the node.
		 * we first compare the heuristic, if node1 got larger value, it will
		 * be put after node2. if node1 got smaller value, it will be put
		 * before node2. if they got same value, we continue to compare their
		 * id.A smaller ID means this node is created earlier so that we can put
		 * the node with larger ID at front and vice versa. and this new comparator
		 * also obey the requirements from javadoc.
		 */
		fringe = new PriorityQueue<Node>(11,new Comparator<Node>(){
			@Override
			public int compare(Node node1,Node node2)
			{
				if (h(node1)>h(node2))
					return 1;
				else if (h(node1)<h(node2))
					return -1;
				else
				{
					if (node1.id()>node2.id())
						return -1;
					if (node1.id()<node2.id())
						return 1;
					return 0;
				}
			}
		});
		
		fringe.add(curr);
		while(expanded.size()<SEARCHLIMIT)
		{	
			//avoid cycles: select a node from the fringe for expansion
			//if it has not been expanded yet, expand it;else discard it
			boolean unvisited =false;
			while(!unvisited)
			{
				if (fringe.size()==0)
					return true;
				curr = fringe.remove();
				unvisited= true;
				if (!expanded.isEmpty())
				{
					for (Node n:expanded)
					{	
						if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
						{
							unvisited = false;
							break;
						}
					}
				}				
			}
			
			expanded.add(curr);
			
			if (curr.getNumber().Value().equals(goal.Value()))
			{
				while(curr!=null)
				{
					path.push(curr);
					curr = curr.parent();
				}		
				return true;
			}
					
			if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
			{
				if (curr.getNumber().firstDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitDec();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);		
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);	//set Id for the node
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Does A* search from start to find the goal
	 * @param node is the start node
	 * @return result of A*, if goal found return true,
	 * otherwise return false.
	 */
	public boolean AStar(Node node)
	{
		Number tmpNum;
		Node tmpNode;
		Node curr = node;
		nodeNum = 1;
		
		//pretty much the same as the one Greedy search uses
		fringe = new PriorityQueue<Node>(11,new Comparator<Node>(){
			@Override
			public int compare(Node node1,Node node2)
			{
				if (f(node1)>f(node2))
					return 1;
				else if (f(node1)<f(node2))
					return -1;
				else
				{
					if (node1.id()>node2.id())
						return -1;
					if (node1.id()<node2.id())
						return 1;
					return 0;
				}
			}
		});
		
		fringe.add(curr);
		while(expanded.size()<SEARCHLIMIT)
		{	
			//avoid cycles: select a node from the fringe for expansion
			//if it has not been expanded yet, expand it;else discard it
			boolean unvisited =false;
			while(!unvisited)
			{
				if (fringe.size()==0)
					return true;
				curr = fringe.remove();
				unvisited= true;
				if (!expanded.isEmpty())
				{
					for (Node n:expanded)
					{	
						if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
						{
							unvisited = false;
							break;
						}
					}
				}				
			}
			
			expanded.add(curr);
			
			if (curr.getNumber().Value().equals(goal.Value()))
			{
				while(curr!=null)
				{
					path.push(curr);
					curr = curr.parent();
				}		
				return true;
			}
					
			if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
			{
				if (curr.getNumber().firstDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitDec();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);		
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setID(nodeNum++);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Does hill climbing search from start to find the goal
	 * @param node is the start node
	 * @return result of Hill-Climbing, if goal found return true,
	 * otherwise return false.
	 */
	public boolean HillClimbing(Node node)
	{
		Number tmpNum;
		Node curr = node;
		Node neighbour = null;
		Node minH =null;	//the only node that memory stores
		
		while(expanded.size()<SEARCHLIMIT)
		{
			if (!expanded.isEmpty())
			{
				for (Node n:expanded)
				{	
					if (n.getNumber().Value().equals(curr.getNumber().Value())&&n.getNumber().lastChanged().equals(curr.getNumber().lastChanged())||curr.getNumber().Value().equals(start.Value()))
					{
						return false;
					}
				}
			}			
			
			expanded.add(curr);
			
			if (curr.getNumber().Value().equals(goal.Value()))
				return true;
				
			if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
			{
				if (curr.getNumber().firstDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitDec();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					
					if (!forbidden.contains(tmpNum.Value()))
					{	
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;			
						}
						else
							minH = neighbour;
					}
				}
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					
					if (!forbidden.contains(tmpNum.Value()))
					{	
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;				
						}
						else
							minH = neighbour;
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					
					if (!forbidden.contains(tmpNum.Value()))
					{	
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;			
						}
						else
							minH = neighbour;
					}
				}
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					
					if (!forbidden.contains(tmpNum.Value()))
					{	
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;				
						}
						else
							minH = neighbour;
					}
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					
					if (!forbidden.contains(tmpNum.Value()))
					{	
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;			
						}
						else
							minH = neighbour;
					}
				}
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					
					if (!forbidden.contains(tmpNum.Value()))
					{
						neighbour = new Node(tmpNum);
						if (minH!=null)
						{
							if (h(neighbour)<=h(minH))
								minH = neighbour;				
						}
						else
							minH = neighbour;
					}				
				}
			}
			//check if searching can go any deeper or not
			if (minH!=null&&!minH.equals(curr))
			{
				if (h(minH)<=h(curr))
					curr = minH;
				else
					return false;
			}
			else
				return false;
		}
		
		return false;
	}
	/**
	 * Devise a heuristic for each node.
	 * calculate the differences of each digit between the current node and goal node
	 * sum them up and add the difference between the largest difference and the second
	 * largest difference from above. 
	 * this heuristic is admissible because:
	 * 1) if all digits can be altered freely, the number of total movements should be the sum
	 * of differences between each digit of current node and goal.
	 * 2) but same digit cannot be altered in two successive moves, therefore in certain cases
	 * we need to "sacrifice" another digit to change a digit which is an "useless" move. Eg:
	 * if we want to transform 112 to 111 but the third digit has been changed, we need to change
	 * the first digit or the second digit first, say, 122, and then 121, 111, totally 3 steps.
	 * if we can change digits freely, only 1 step needed.
	 * 3)in the h formulation, the front part (firstDigitDiff + secondDigitDiff + thirdDigitDiff)
	 * calculate the steps needed for condition 1 and the latter part calculated difference between 
	 * the largest difference and the second largest difference from above which is the least "useless"
	 * step we need.
	 * 4) so far the heuristic is admissible and another constraint for the puzzle is the forbidden numbers
	 * which make the heuristic even more admissible because we need more steps to "detour" the forbidden
	 * numbers.
	 * @param node is the one we want to calculate with
	 * @return the heuristic value of the node;
	 */
	public int h(Node node)
	{
		int h,u;
		int firstDigitDiff=Math.abs(node.getNumber().firstDigit()-goal.firstDigit()),
			secondDigitDiff=Math.abs(node.getNumber().secondDigit()-goal.secondDigit()),
			thirdDigitDiff=Math.abs(node.getNumber().thirdDigit()-goal.thirdDigit());
		u=	Math.max(Math.max(firstDigitDiff, secondDigitDiff), Math.max(firstDigitDiff, thirdDigitDiff)) -
			Math.min(Math.max(firstDigitDiff, secondDigitDiff), Math.max(firstDigitDiff, thirdDigitDiff));
		h = firstDigitDiff + secondDigitDiff + thirdDigitDiff;
		
		/*
		 *the current heuristic i use is the obvious one.
		 *the commented out heuristic has an extra term and is improved to be more efficient than
		 *the obvious one
		 */
		//h = firstDigitDiff + secondDigitDiff + thirdDigitDiff +(u>1?u:0);
				
		return h;
	}
	
	/**
	 * calculate the cost to reach the node from start
	 * @param node is the one we want to reach
	 * @return cost
	 */
	public int g(Node node)
	{
		int depth;
		
		for (depth=0;node!=null;depth++)
			node = node.parent();
		return depth;
	}
	
	/**
	 * calculate the f value of the node. F value is the sum of the cost to reach
	 * the node and the heuristic of the node
	 * @param node is the one want to calculate
	 * @return f value of the node
	 */
	public int f(Node node)
	{
		return g(node)+h(node);
	}
	
	/**
	 * print out the path from start to goal
	 */
	public void printPath()
	{
		while (!path.isEmpty())
		{
			System.out.print(path.pop().getNumber().Value());
			if (path.size()!=0)
				System.out.print(",");
		}
	}
	
	/**
	 * print out all expanded nodes
	 */
	public void printExpanded()
	{
		while(!expanded.isEmpty())
		{
			System.out.print(expanded.remove().getNumber().Value());
			if (!expanded.isEmpty())
				System.out.print(",");
		}
	}
	
	/**
	 * main method to run the program
	 * @param args is used to pass test file and the chosen algorithm
	 */
	public static void main(String[] args)
	{
		PuzzleSolver solver = new PuzzleSolver(args[0]);
		solver.solve(args[1].charAt(0));
	}
}