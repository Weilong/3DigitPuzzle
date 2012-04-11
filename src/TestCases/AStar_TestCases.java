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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}

}

