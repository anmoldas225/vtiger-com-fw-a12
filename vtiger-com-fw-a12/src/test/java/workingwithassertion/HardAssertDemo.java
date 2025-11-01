package workingwithassertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertDemo {
	
	@Test
	public void case1() {
		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object obj1 = null;
		Object obj2 = new Object();

		boolean status1 = a.equals(c);
		boolean status2 = b.equals(c);

		Assert.assertTrue(status2);     //False
		Assert.assertFalse(status1);   //True

		Assert.assertEquals(a, b);       //True
		Assert.assertNotEquals(a, c);   //True

		Assert.assertNull(obj1);        //True
		Assert.assertNotNull(obj2);    //True
	}

}
