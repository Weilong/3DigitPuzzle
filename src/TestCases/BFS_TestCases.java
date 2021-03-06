package TestCases;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.Test;

import PuzzleSolver.PuzzleSolver;

import java.io.File;
import java.util.Scanner;

/**
 * COMP3308 Introduction to AI Assignment1
 * BFS_TestCases.java
 * Purpose: Test cases for Breadth First Search
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
public class BFS_TestCases {

	Scanner s;
	String line1, line2;
	@Test
	public void BFS_Test1() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/1_b"));
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
	public void BFS_Test2() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/2_b"));
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
	public void BFS_Test3() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/3_b"));
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
	public void BFS_Test4() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/4_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
		
	}
	
	@Test
	public void BFS_Test5() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/5_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
		
	}

	@Test
	public void BFS_Test6() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/6_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
		
	}
	
	@Test
	public void BFS_Test7() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/7_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
		
	}
	
	@Test
	public void BFS_Test8() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in8");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/8_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test9() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in9");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/9_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test10() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in10");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/10_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test11() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in11");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/11_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test12() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in12");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/12_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test13() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in13");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/13_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test14() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in14");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/14_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void BFS_Test15() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in15");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/15_b"));
		line1 = s.nextLine();
		if (s.hasNextLine())
		{
			line2 = s.nextLine();
			assertEquals(line1+"\n"+line2,os.toString());
		}
		else
			assertEquals(line1,os.toString());
		
		System.setOut(originalOut);	
		
		System.setOut(originalOut);	
	}
}

