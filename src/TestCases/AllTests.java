package TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * COMP3308 Introduction to AI Assignment1
 * AllTests.java
 * Purpose: Test suite including all test cases
 *
 * @author Weilong Ding
 * @version 1.0 12/04/2012
 */
@RunWith(Suite.class)
@SuiteClasses({ AStar_TestCases.class, BFS_TestCases.class,
		DFS_TestCases.class, Greedy_TestCases.class, HC_TestCases.class,
		IDS_TestCases.class })
public class AllTests {

}
