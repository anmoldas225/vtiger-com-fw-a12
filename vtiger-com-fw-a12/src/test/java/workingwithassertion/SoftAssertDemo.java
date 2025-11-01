package workingwithassertion;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertDemo {

	@Test
	public void case1() {
		String a = "abc";
		String b = "abc";
		String c = "xyz";

		Object obj1 = null;
		Object obj2 = new Object();

		boolean status1 = a.equals(c); //false
		boolean status2 = b.equals(a); //true

		SoftAssert sa = new SoftAssert();
		
		sa.assertTrue(status1);       //False
		sa.assertFalse(status2);      //True
		
		sa.assertEquals(a, c);        //False
		sa.assertNotEquals(a, b);    //False

		sa.assertNull(obj2);         //Notnull  
		sa.assertNotNull(obj1);      //Null
		
		sa.assertAll();
	}	

}
