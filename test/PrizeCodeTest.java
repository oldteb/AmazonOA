package amazonOA;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class PrizeCodeTest {
	
	
	PrizeCode instance = new PrizeCode();
	
	@Test
	public void testSample() {
		List<String> shopList = new ArrayList<String>();
		shopList.add("peach");
		shopList.add("apple");
		shopList.add("apple");
		shopList.add("peach");
		shopList.add("banana");
		shopList.add("grape");
		shopList.add("banana");
		
		List<String> sub1 = new ArrayList<String>();
		List<String> sub2 = new ArrayList<String>();
		sub1.add("apple");
		sub1.add("apple");
		sub2.add("banana");
		sub2.add("anything");
		sub2.add("banana");
		List<List<String>> code = new ArrayList<List<String>>();
		code.add(sub1);
		code.add(sub2);
		
		int rst = instance.winPrize(shopList, code);
		
		System.out.println(rst);
		Assert.assertTrue(rst == 1);
		
	}
}
