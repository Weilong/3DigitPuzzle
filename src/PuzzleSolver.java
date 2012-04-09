import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class PuzzleSolver
{
	final int SEARCHLIMIT =1000;	//set a limit of 1000 expanded nodes maximum
	
	private Number start;
	private Number goal;
	private ArrayList<String> forbidden = new ArrayList<String>(); 
	private Queue<Node> fringe;
	private Queue<Node>	expanded;
	private Stack<String> path;
	private SearchTree tree;
	
	public PuzzleSolver(String filename)
	{
		this.readFile(filename);		
	}
	
	public void readFile(String filename)
	{
		File file = new File(filename);
		try {
			Scanner s = new Scanner(file);
			start = new Number(s.nextLine());
			goal = new Number(s.nextLine());
			if (s.hasNextLine())
			{
				for (String number:s.nextLine().split(" "))
				{
					forbidden.add(number);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void solve(char strategy)
	{
		switch (strategy)
		{
		case 'B':
			fringe = new LinkedList<Node>();
			expanded = new LinkedList<Node>();
			path = new Stack<String>();
			tree = new SearchTree(new Node(start));
			
			if(BFS(tree.Root()))
			{
				printPath();
				System.out.println();
				printExpanded();	
			}
			else
				System.out.println("Goal not found");			
			break;
		case 'D':
			fringe = new LinkedList<Node>();
			expanded = new LinkedList<Node>();
			path = new Stack<String>();
			tree = new SearchTree(new Node(start));
			
			if(DFS(tree.Root()))
			{
				printPath();
				System.out.println();
				printExpanded();
			}
			else
				System.out.println("Goal not found");
			break;
		case 'I':
			fringe = new LinkedList<Node>();
			expanded = new LinkedList<Node>();
			path = new Stack<String>();
			tree = new SearchTree(new Node(start));
			
			if(IDS(tree.Root()))
			{
				printPath();
				System.out.println();
				printExpanded();
			}
			else
				System.out.println("Goal not found");
			break;
		case 'G':
			Greedy();
			break;
		case 'A':
			AStar();
			break;
		case 'H':
			HillClimbing();
			break;
		default:
		}
	}
	
	public boolean BFS(Node node)
	{
		Number tmpNum;
		Node tmpNode;
		Node curr;
		fringe.add(node);
		while(fringe.size()!=0)
		{
			if (expanded.size()==SEARCHLIMIT)
				return false;
			
			curr = fringe.remove();
			expanded.add(curr);

			if (curr.getNumber().Value().equals(goal.Value()))
			{
				while(curr!=null)
				{
					path.push(curr.getNumber().Value());
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
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
				if (curr.getNumber().firstDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.firstDigitInc();
					tmpNum.setLastChanged(Number.Digit.FIRST);
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (curr.getNumber().secondDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitDec();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
				if (curr.getNumber().secondDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.secondDigitInc();
					tmpNum.setLastChanged(Number.Digit.SECOND);
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
			}
			if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (curr.getNumber().thirdDigit()>0)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitDec();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
				if (curr.getNumber().thirdDigit()<9)
				{
					tmpNum = new Number(curr);
					tmpNum.thirdDigitInc();
					tmpNum.setLastChanged(Number.Digit.THIRD);
					tmpNode = new Node(tmpNum);
					tmpNode.setParent(curr);
					curr.getChildren().add(tmpNode);
				}
			}
			//remove all forbidden numbers from the children list of a node
			for (int i=0;i<curr.getChildren().size();i++)
			{
				if (forbidden.contains(curr.getChildren().get(i).getNumber().Value()))
					curr.getChildren().remove(i);
			}
			fringe.addAll(curr.getChildren());
		}
		return false;
	}
	
	public boolean DFS(Node node)
	{
		//TODO
		if(expanded.size()==SEARCHLIMIT)
			return false;
		
		Number tmpNum;
		Node tmpNode;
		Node curr;
		
		curr = node;
		expanded.add(curr);
		
		if (curr.getNumber().Value().equals(goal.Value()))
		{
			path.push(curr.getNumber().Value());
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
					if (DFS(tmpNode))
					{
						path.push(curr.getNumber().Value());
						return true;
					}							
				}//to get the newly added node of the children node list and check											
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
						path.push(curr.getNumber().Value());
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
						path.push(curr.getNumber().Value());
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
						path.push(curr.getNumber().Value());
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
						path.push(curr.getNumber().Value());
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
						path.push(curr.getNumber().Value());
						return true;
					}	
				}
			}
		}
		return false;
	}
	
	public boolean IDS(Node node)
	{
		//TODO
		boolean result = false;
		for (int limit=0;limit<Double.POSITIVE_INFINITY;limit++)
		{
			expanded.clear();
			result = DLS(node,limit);
			if (result)
				return result;
			
			if (expanded.size()==SEARCHLIMIT)
				return result;
		}
		return result;
	}
	
	public boolean DLS(Node node,int depth)
	{
		if (depth>=0)
		{
			if(expanded.size()==SEARCHLIMIT)
				return false;
			
			Number tmpNum;
			Node tmpNode;
			Node curr;
			
			curr = node;
			expanded.add(curr);
			
			if (curr.getNumber().Value().equals(goal.Value()))
			{
				path.push(curr.getNumber().Value());
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
							path.push(curr.getNumber().Value());
							return true;
						}							
					}//to get the newly added node of the children node list and check											
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
							path.push(curr.getNumber().Value());
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
							path.push(curr.getNumber().Value());
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
							path.push(curr.getNumber().Value());
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
							path.push(curr.getNumber().Value());
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
							path.push(curr.getNumber().Value());
							return true;
						}	
					}
				}
			}
		}
		return false;
	}
	
	public void Greedy()
	{
		//TODO
	}
	
	public void AStar()
	{
		//TODO
	}
	
	public void HillClimbing()
	{
		//TODO
	}
	
	public void Heuristic(Node node)
	{
		//TODO
	}
	
	public void printPath()
	{
		while (!path.isEmpty())
		{
			System.out.print(path.pop());
			if (path.size()!=0)
				System.out.print(",");
		}
	}
	
	public void printExpanded()
	{
		while(expanded.size()!=0)
		{
			System.out.print(expanded.remove().getNumber().Value());
			if (expanded.size()!=0)
				System.out.print(",");
		}
	}
	
	public static void main(String[] args)
	{
		PuzzleSolver solver = new PuzzleSolver(args[0]);
		solver.solve(args[1].charAt(0));
	}
}