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
				for (String number:s.nextLine().split(","))
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
		fringe = new LinkedList<Node>();
		expanded = new LinkedList<Node>();
		path = new Stack<String>();
		tree = new SearchTree(new Node(start));
			
		switch (strategy)
		{
		case 'B':
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
			if(Greedy(tree.Root()))
			{
				printPath();
				System.out.println();
				printExpanded();
			}
			else
				System.out.println("Goal not found");
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
		while(expanded.size()!=SEARCHLIMIT)
		{
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
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
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
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
						fringe.add(tmpNode);
					}
				}
			}
		}
		return false;
	}
	
	public boolean DFS(Node node)
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
	
	public boolean Greedy(Node node)
	{
		Number tmpNum;
		Node tmpNode;
		Node curr;
		Node minH = node;
	
		while(expanded.size()!=SEARCHLIMIT)
		{
			curr = minH;
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
					if (!forbidden.contains(tmpNum.Value()))
					{
						tmpNode = new Node(tmpNum);
						tmpNode.setParent(curr);
						curr.getChildren().add(tmpNode);
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
					}
				}
			}
			minH = curr.getChildren().get(0);
			for (Node n:curr.getChildren())
			{
				if (Heuristic(n)<Heuristic(minH))
					minH = n;
			}
		}
		return false;
	}
	
	public void AStar()
	{
		//TODO
	}
	
	public void HillClimbing()
	{
		//TODO
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
	 * @param node
	 * @return
	 */
	public int Heuristic(Node node)
	{
		int h;
		int u;
		int firstDigitDiff=Math.abs(node.getNumber().firstDigit()-goal.firstDigit()),
			secondDigitDiff=Math.abs(node.getNumber().secondDigit()-goal.secondDigit()),
			thirdDigitDiff=Math.abs(node.getNumber().thirdDigit()-goal.thirdDigit());
		u=	Math.max(Math.max(firstDigitDiff, secondDigitDiff), Math.max(firstDigitDiff, thirdDigitDiff)) -
			Math.min(Math.max(firstDigitDiff, secondDigitDiff), Math.max(firstDigitDiff, thirdDigitDiff));
		h = firstDigitDiff + secondDigitDiff + thirdDigitDiff +(u>1?u:0); // TODO to be commented
				
		return h;
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