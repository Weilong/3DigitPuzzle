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
	//private ArrayList<Node> fringe = new ArrayList<Node>();
	//private ArrayList<Node> expanded = new ArrayList<Node>();
	
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
			DFS();
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
		Queue<Node> fringe = new LinkedList<Node>();
		Queue<Node>	expanded = new LinkedList<Node>();
		SearchTree tree = new SearchTree(new Node(start));
		Node curr;
		fringe.add(tree.Root());
		while(fringe.size()!=0)
		{
			//System.out.println("running");
			curr = fringe.peek();
			expanded.add(fringe.remove());
			//System.out.println(curr.getNumber().Value());
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
				Stack<String> path = new Stack<String>();
				while(curr!=null)
				{
					path.push(curr.getNumber().Value());
					curr = curr.parent();
				}
				
				while (!path.isEmpty())
				{
					System.out.print(path.pop());
					if (path.size()!=0)
						System.out.print(",");
				}
									
				System.out.println();
				
				while(expanded.size()!=0)
				{
					System.out.print(expanded.remove().getNumber().Value());
					if (expanded.size()!=0)
						System.out.print(",");
				}
				
				return;
			}
			if (expanded.size()>SEARCHLIMIT)
			{
				System.out.println("Goal not found");
				return;
			}
		}
		
	}
	
	public void DFS()
	{
		//TODO
		
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
	
	public static void main(String[] args)
	{
		PuzzleSolver solver = new PuzzleSolver(args[0]);
		solver.solve(args[1].charAt(0));
	}
}