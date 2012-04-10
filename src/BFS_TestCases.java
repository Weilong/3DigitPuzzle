import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import org.junit.Test;
import java.io.File;
import java.util.Scanner;


public class BFS_TestCases {

	Scanner s;
	@Test
	public void BFS_Test1() throws FileNotFoundException {
		PrintStream originalOut = System.out;
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		PuzzleSolver solver = new PuzzleSolver("ai_ass1_tests/in/in1");
		solver.solve('B');
		s = new Scanner(new File("ai_ass1_tests/out/1_b"));
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
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
		assertEquals(s.nextLine()+"\n"+s.nextLine(),os.toString());
		
		System.setOut(originalOut);	
		
	}
}

