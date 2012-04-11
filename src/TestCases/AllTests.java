package TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AStar_TestCases.class, BFS_TestCases.class,
		DFS_TestCases.class, Greedy_TestCases.class, HC_TestCases.class,
		IDS_TestCases.class })
public class AllTests {

}
