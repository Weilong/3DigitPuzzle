package TestCases;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

import PuzzleSolver.PuzzleSolver;


public class AStar_TestCases {

	Scanner s;
	String line1,line2;
	@Test
	public void AStar_Test1() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/1_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test2() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/2_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test3() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/3_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test4() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/4_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test5() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/5_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test6() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/6_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test7() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/7_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}

	@Test
	public void AStar_Test8() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in8");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/8_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test9() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in9");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/9_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test10() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in10");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/10_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test11() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in11");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/11_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test12() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in12");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/12_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test13() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in13");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/13_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test14() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in14");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/14_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void AStar_Test15() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in15");
		solver.solve('A');
		s = new Scanner(new File("ai_ass1_tests/out/15_A"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
	}
}

