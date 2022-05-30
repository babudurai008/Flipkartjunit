package flipkart.com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class FlipkartShoping {
	@BeforeClass
	public static void befourclass () {
	System.out.println("Befour class");
	}
	@AfterClass
	public static void Afterclass () {
	System.out.println("After class");
	}
	
	@Before
	public void befourtest () {
	System.out.println("befour test");
	}
	@After
	public void Aftertest () {
	System.out.println("After test");
	}
	@Test
	public void a () {
	System.out.println("test 1");

}
	@Test

public void b () {
System.out.println("test 2");

}
	
	@Ignore

public void c () {
System.out.println("test 3");

}
	@Test

public void d () {
System.out.println("test 4");

}
	@Test

public void e () {
System.out.println("test 5");

}
}
