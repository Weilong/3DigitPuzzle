package TestCases;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;

import org.junit.Test;

import PuzzleSolver.PuzzleSolver;

import java.util.Scanner;

/**
 * COMP3308 Introduction to AI Assignment1
 * Greedy_TestCases.java
 * Purpose: Test cases for Greedy Search
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class Greedy_TestCases {

	Scanner s;
	String line1,line2;
	@Test
	public void Greedy_Test1() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/1_G"));
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
	public void Greedy_Test2() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/2_G"));
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
	public void Greedy_Test3() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/3_G"));
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
	public void Greedy_Test4() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/4_G"));
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
	public void Greedy_Test5() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/5_G"));
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
	public void Greedy_Test6() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/6_G"));
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
	public void Greedy_Test7() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/7_G"));
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
	public void Greedy_Test8() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in8");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/8_G"));
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
	public void Greedy_Test9() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in9");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/9_G"));
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
	public void Greedy_Test10() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in10");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/10_G"));
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
	public void Greedy_Test11() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in11");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/11_G"));
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
	public void Greedy_Test12() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in12");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/12_G"));
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
	public void Greedy_Test13() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in13");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/13_G"));
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
	public void Greedy_Test14() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in14");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/14_G"));
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
	public void Greedy_Test15() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in15");
		solver.solve('G');
		s = new Scanner(new File("ai_ass1_tests/out/15_G"));
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

