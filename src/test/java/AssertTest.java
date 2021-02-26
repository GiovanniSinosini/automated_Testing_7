

import org.junit.Assert;
import org.junit.Test;

import com.github.giovannisinosini.automated_Testing_7.entidades.Usuario;

public class AssertTest {
	
	@Test
	public void test() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals("Erro de comparação ", 1, 1);
		Assert.assertEquals(0.512345, 0.512, 0.001);  // 0.001 = number of decimal places to be included in the comparison
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		// primitive types
		
		int i = 11;
		Integer i2 = 11;
		
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		// string test
		
		Assert.assertEquals("casa", "casa");
		Assert.assertNotEquals("casa", "Casa");
		// Assert.assertEquals("casa", "Casa");
		Assert.assertTrue("casa".equalsIgnoreCase("Casa"));
		Assert.assertTrue("casa".startsWith("ca"));
		
		// object test
		
		Usuario u1 = new Usuario("Usuario 1"); 
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = u2;
		Usuario u4 = null;
		
		Assert.assertEquals(u1, u2);  // content testing
		Assert.assertSame(u2, u3);  // instance testing
		Assert.assertNotSame(u1, u3);
		
		Assert.assertNull(u4);
		Assert.assertNotNull(u1);
	}

}
