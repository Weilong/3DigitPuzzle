import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintStream;

import org.junit.Test;
import java.util.Scanner;


public class IDS_TestCases {

	Scanner s;
	@Test
	public void DFS_Test1() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/1_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test2() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in2");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/2_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test3() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in3");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/3_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test4() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in4");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/4_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test5() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in5");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/5_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test6() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in6");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/6_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}
	
	@Test
	public void DFS_Test7() throws FileNotFoundException 
	{
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in7");
		solver.solve('I');
		s = new Scanner(new File("ai_ass1_tests/out/7_i"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
	}

}

