package amazonOA;

import org.junit.Assert;
import org.junit.Test;

public class BSTDistanceTest {
	
	BSTDistance instance = new BSTDistance();
	
	@Test
	public void testSample1() {
		int[] values = {5,6,3,1,2,4};
		
		int distance = instance.bstDistance(values, 6, 2, 4);
		
		System.out.println(distance);
		Assert.assertTrue(distance == 3);
		
	}
	
	@Test
	public void testSample2() {
		int[] values = {5,6,3,1,2,4};
		
		int distance = instance.bstDistance(values, 6, 5, 4);
		
		System.out.println(distance);
		Assert.assertTrue(distance == 2);
		
	}
	
	@Test
	public void testSample3() {
		int[] values = {1};
		
		int distance = instance.bstDistance(values, 1, 1, 1);
		
		System.out.println(distance);
		Assert.assertTrue(distance == 0);
		
	}
	
	@Test
	public void testSample4() {
		int[] values = {1,2,3,4,5,6};
		
		int distance = instance.bstDistance(values, 6, 2, 7);
		
		System.out.println(distance);
		Assert.assertTrue(distance == -1);
		
	}
	
	
}
