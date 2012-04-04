import java.io.*;
import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class PuzzleSolver
{
	public static final int SEARCHLIMIT =1000;	//set a limit of 1000 expanded nodes maximum
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
			for (String number:s.nextLine().split(" "))
			{
				forbidden.add(number);
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
		fringe.add(new Node(start));
		
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
	
	public void Heuristic(Number number)
	{
		//TODO
	}
	
	public static void main(String[] args)
	{
		PuzzleSolver solver = new PuzzleSolver(args[0]);
		solver.solve(args[1].charAt(0));
		
		//System.out.println(solver.start);
		//System.out.println(solver.goal);
		//System.out.println(solver.forbidden);
		
	}
}