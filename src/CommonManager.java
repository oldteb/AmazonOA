package amazonOA;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommonManager {

	
	Employee findCommonManager(Employee ceo,  Employee employee1, Employee employee2) {
		if(ceo == null || employee1 == null || employee2 == null)  return null;
		if(ceo.id == employee1.id)  return employee1;
		if(ceo.id == employee2.id)  return employee2;
		
		Stack<Employee> stack1 = new Stack<Employee>();
		Stack<Employee> stack2 = new Stack<Employee>();
		
		dfs(ceo, employee1, stack1);
		dfs(ceo, employee2, stack2);
		
		while(stack1.size() != 0){
			if(stack1.size() == stack2.size()) {
				if(stack1.peek().id == stack2.peek().id)  return stack1.peek();
				else {
					stack1.pop();
					stack2.pop();
				}
			}
			else if (stack1.size() > stack2.size())
				stack1.pop();
			else 
				stack2.pop();
		}
		
		return null;
	}
	
	boolean dfs(Employee root,  Employee employee, Stack<Employee> stack) {
		if(root == null)  return false;
		stack.push(root);
		if(root.id == employee.id) return true;
		for(Employee emp : root.reports) {
			if(dfs(emp, employee, stack) == true)  return true;
		}
		stack.pop();
		return false;
	}
	
	public class Employee {
		int id;
	    String  name;
	    List<Employee>  reports = new ArrayList<Employee>();
	    
	    public Employee(int id){
	    	this.id = id;
	    }
	    
	    public void addEmployee(Employee emp) {
	    	reports.add(emp);
	    }
	    
	} 
}
