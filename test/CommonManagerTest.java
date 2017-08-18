package amazonOA;

import org.junit.Assert;
import org.junit.Test;

import amazonOA.CommonManager.Employee;

public class CommonManagerTest {
	
	CommonManager instance = new CommonManager();
	
	@Test
	public void testSample1() {
		Employee emp0 = instance.new Employee(0);
		Employee emp1 = instance.new Employee(1);
		Employee emp2 = instance.new Employee(2);
		Employee emp3 = instance.new Employee(3);
		Employee emp4 = instance.new Employee(4);
		Employee emp5 = instance.new Employee(5);
		Employee emp6 = instance.new Employee(6);
		
		emp0.addEmployee(emp1);
		emp0.addEmployee(emp5);
		emp1.addEmployee(emp2);
		emp1.addEmployee(emp3);
		emp1.addEmployee(emp4);
		
		Employee manager = null;
		
		manager = instance.findCommonManager(emp0, emp2, emp4);
		System.out.println(manager.id);
		Assert.assertTrue(manager.id == 1);
		
		manager = instance.findCommonManager(emp0, emp2, emp1);
		System.out.println(manager.id);
		Assert.assertTrue(manager.id == 1);
		
		manager = instance.findCommonManager(emp0, emp2, emp0);
		System.out.println(manager.id);
		Assert.assertTrue(manager.id == 0);
		
		manager = instance.findCommonManager(emp0, emp2, emp6);
//		System.out.println(manager.id);
		Assert.assertTrue(manager == null);
		
		manager = instance.findCommonManager(emp0, emp2, emp5);
		System.out.println(manager.id);
		Assert.assertTrue(manager.id == 0);
		
		manager = instance.findCommonManager(emp0, emp0, emp0);
		System.out.println(manager.id);
		Assert.assertTrue(manager.id == 0);
	}
}
