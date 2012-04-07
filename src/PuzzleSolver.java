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
	Queue<Node> fringe;
	Queue<Node>	expanded;
	Stack<String> path;
	
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
			BFS();
			break;
		case 'D':
			expanded = new LinkedList<Node>();
			path = new Stack<String>();
			SearchTree tree = new SearchTree(new Node(start));
			DFS(tree.Root());
			printPath();
			System.out.println();
			printExpanded();
			break;
		case 'I':
			IDS();
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
	
	public void BFS()
	{
		//TODO
		fringe = new LinkedList<Node>();
		expanded = new LinkedList<Node>();
		path = new Stack<String>();
		SearchTree tree = new SearchTree(new Node(start));
		Node curr;
		fringe.add(tree.Root());
		while(fringe.size()!=0)
		{
			curr = fringe.peek();
			expanded.add(fringe.remove());
			if (!curr.getNumber().Value().equals(goal.Value()))
			{
				if (curr.getNumber().lastChanged()!=Number.Digit.FIRST)
				{
					if (curr.getNumber().firstDigit()>0)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit()-1,curr.getNumber().secondDigit(),curr.getNumber().thirdDigit(),Number.Digit.FIRST)));
					if (curr.getNumber().firstDigit()<9)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit()+1,curr.getNumber().secondDigit(),curr.getNumber().thirdDigit(),Number.Digit.FIRST)));
				}
				if (curr.getNumber().lastChanged()!=Number.Digit.SECOND)
				{
					if (curr.getNumber().secondDigit()>0)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit(),curr.getNumber().secondDigit()-1,curr.getNumber().thirdDigit(),Number.Digit.SECOND)));
					if (curr.getNumber().secondDigit()<9)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit(),curr.getNumber().secondDigit()+1,curr.getNumber().thirdDigit(),Number.Digit.SECOND)));
				}
				if (curr.getNumber().lastChanged()!=Number.Digit.THIRD)
				{
					if (curr.getNumber().thirdDigit()>0)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit(),curr.getNumber().secondDigit(),curr.getNumber().thirdDigit()-1,Number.Digit.THIRD)));
					if (curr.getNumber().thirdDigit()<9)
						curr.getChildren().add(new Node(new Number(curr.getNumber().firstDigit(),curr.getNumber().secondDigit(),curr.getNumber().thirdDigit()+1,Number.Digit.THIRD)));
				}
				//remove all forbidden numbers from the children list of a node
				for (int i=0;i<curr.getChildren().size();i++)
				{
					if (forbidden.contains(curr.getChildren().get(i).getNumber().Value()))
						curr.getChildren().remove(i);
				}
				//set the all the children's parent of current node as the current node
				for (Node node:curr.getChildren())
				{
						node.setParent(curr);
				}
				fringe.addAll(curr.getChildren());

			}
			else
			{
				while(curr!=null)
				{
					path.push(curr.getNumber().Value());
					curr = curr.parent();
				}

				printPath();
				System.out.println();
				printExpanded();
				
				return;
			}
			if (expanded.size()==SEARCHLIMIT)
			{
				System.out.println("Goal not found");
				return;
			}
		}
		
	}
	
	public boolean DFS(Node currNode)
	{
		//TODO
		Number tmpNum;
		expanded.add(currNode);
		
		if (!currNode.getNumber().Value().equals(goal.Value()))
		{
			if (currNode.getNumber().lastChanged()!=Number.Digit.FIRST)
			{
				if (currNode.getNumber().firstDigit()>0)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit()-1,currNode.getNumber().secondDigit(),currNode.getNumber().thirdDigit(),Number.Digit.FIRST)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}								
					}//to get the newly added node of the children node list and check											
				}
				if (currNode.getNumber().firstDigit()<9)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit()+1,currNode.getNumber().secondDigit(),currNode.getNumber().thirdDigit(),Number.Digit.FIRST)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}	
					}
				}
			}
			if (currNode.getNumber().lastChanged()!=Number.Digit.SECOND)
			{
				if (currNode.getNumber().secondDigit()>0)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit(),currNode.getNumber().secondDigit()-1,currNode.getNumber().thirdDigit(),Number.Digit.SECOND)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}	
					}
				}
				if (currNode.getNumber().secondDigit()<9)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit(),currNode.getNumber().secondDigit()+1,currNode.getNumber().thirdDigit(),Number.Digit.SECOND)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}	
					}
				}
			}
			if (currNode.getNumber().lastChanged()!=Number.Digit.THIRD)
			{
				if (currNode.getNumber().thirdDigit()>0)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit(),currNode.getNumber().secondDigit(),currNode.getNumber().thirdDigit()-1,Number.Digit.THIRD)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}	
					}
				}
				if (currNode.getNumber().thirdDigit()<9)
				{
					if (!forbidden.contains((tmpNum=new Number(currNode.getNumber().firstDigit(),currNode.getNumber().secondDigit(),currNode.getNumber().thirdDigit()+1,Number.Digit.THIRD)).Value()))
					{	
						currNode.getChildren().add(new Node(tmpNum));
						if (DFS(currNode.getChildren().get(currNode.getChildren().size()-1)))
						{
							path.push(currNode.getNumber().Value());
							return true;
						}	
					}
				}
			}
		}
		else
		{
			path.push(currNode.getNumber().Value());
			return true;
		}
			
		if(expanded.size()==SEARCHLIMIT)
		{
			System.out.println("Goal not found");
			return false;
		}
		
		return false;
	}
	
	public void IDS()
	{
		//TODO
		
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
	
	public void checkSearchLimit()
	{
		if (expanded.size()==SEARCHLIMIT)
		{
			System.out.println("Goal not found");
			return;
		}
	}
	
	public static void main(String[] args)
	{
		PuzzleSolver solver = new PuzzleSolver(args[0]);
		solver.solve(args[1].charAt(0));
	}
}