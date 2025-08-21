package Test;
import SeccionA.Calculation;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculationTest {
	
	@Test
	public void testFindMax() {
		/*assertEquals(4, Calculation.findMax(new int[] {1,3,4,2}));*/
		assertEquals(-1, Calculation.findMax(new int[] {-12,-1,-3,-4,-2}));
		assertEquals(7, Calculation.findMax(new int[] {-5,0,-7,7,-2,3}));
		assertEquals(23, Calculation.findMax(new int[] {-15,0,-7,9,12,23}));
	}

}
