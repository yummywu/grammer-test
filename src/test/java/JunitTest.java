import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class JunitTest {
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@After 
	public void After() {
		System.out.println("After");
	}
	
	@Ignore
	@Test
	public void what() {
		System.out.println("hello");
	}
	
	@Test
	public void helloMessageFormat() {
		System.out.println("MessageFormat");
	}
	
	@Test
	public void helloMessageWork() {
		System.out.println("MessageWork");
	}
}
