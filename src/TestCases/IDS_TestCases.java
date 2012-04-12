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
 * IDS_TestCases.java
 * Purpose: Test cases for Iterative Deepening Search
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */

public class IDS_TestCases {

	Scanner s;
	String line1,line2;
	@Test
	public void IDS_Test1() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/1_i"));
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
	public void IDS_Test2() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/2_i"));
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
	public void IDS_Test3() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/3_i"));
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
	public void IDS_Test4() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/4_i"));
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
	public void IDS_Test5() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/5_i"));
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
	public void IDS_Test6() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/6_i"));
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
	public void IDS_Test7() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/7_i"));
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
	public void IDS_Test8() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in8");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/8_i"));
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
	public void IDS_Test9() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in9");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/9_I"));
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
	public void IDS_Test10() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in10");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/10_i"));
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
	public void IDS_Test11() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in11");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/11_i"));
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
	public void IDS_Test12() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in12");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/12_i"));
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
	public void IDS_Test13() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in13");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/13_i"));
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
	public void IDS_Test14() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in14");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/14_i"));
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
	public void IDS_Test15() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in15");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/15_i"));
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

