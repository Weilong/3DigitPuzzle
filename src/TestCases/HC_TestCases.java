package TestCases;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;

import org.junit.Test;

import PuzzleSolver.PuzzleSolver;

import java.util.Scanner;


public class HC_TestCases {

	Scanner s;
	String  line1,line2;
	@Test
	public void HC_Test1() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/1_H"));
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
	public void HC_Test2() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/2_H"));
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
	public void HC_Test3() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/3_H"));
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
	public void HC_Test4() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/4_H"));
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
	public void HC_Test5() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/5_H"));
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
	public void HC_Test6() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/6_H"));
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
	public void HC_Test7() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/7_H"));
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
	public void HC_Test8() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in8");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/8_H"));
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
	public void HC_Test9() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in9");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/9_H"));
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
	public void HC_Test10() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in10");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/10_H"));
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
	public void HC_Test11() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in11");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/11_H"));
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
	public void HC_Test12() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in12");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/12_H"));
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
	public void HC_Test13() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in13");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/13_H"));
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
	public void HC_Test14() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in14");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/14_H"));
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
	public void HC_Test15() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in15");
		solver.solve('H');
		s = new Scanner(new File("ai_ass1_tests/out/15_H"));
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

