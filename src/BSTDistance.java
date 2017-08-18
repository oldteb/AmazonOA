package amazonOA;

import java.util.ArrayList;
import java.util.List;

import datastructure.TreeNode;

public class BSTDistance {
	
	public int bstDistance(int[] values, int n, int node1, int node2) {
		if(values == null || n == 0 || node1 == node2)  return 0;
		
		List<TreeNode> trace1 = new ArrayList<TreeNode>(n);
		List<TreeNode> trace2 = new ArrayList<TreeNode>(n);
		
		TreeNode root = new TreeNode(values[0]);
		if(values[0] == node1) trace1.add(root);
		if(values[0] == node2) trace2.add(root);
		
		for(int i = 1; i < n && (trace1.size() == 0 || trace2.size() == 0); i++){
			if(values[i] == node1)
				insertBST(root,node1,trace1);
			else if(values[i] == node2)
				insertBST(root,node2,trace2);
			else
				insertBST(root,values[i],null);
		}
		
		if(trace1.size() == 0 || trace2.size() == 0)  return -1;
		
		int fatherDepth = Math.min(trace1.size(), trace2.size()) - 1;
		for(int i = 0; i < Math.min(trace1.size(), trace2.size()); i++) {
			if(trace1.get(i) != trace2.get(i)) {
				fatherDepth = i-1;
				break;
			}
		}

		return trace1.size()-1 + trace2.size()-1 - 2 * fatherDepth;
	}
	
	public void insertBST(TreeNode root, int val, List<TreeNode> trace) {
		if(trace != null)  trace.add(root);
		if(root.val < val) {
			if(root.right == null) {
				root.right = new TreeNode(val);
				if(trace != null)  trace.add(root.right);
				return;
			}
			else {
				insertBST(root.right,val,trace);
			}
		}
		else{
			if(root.left == null) {
				root.left = new TreeNode(val);
				if(trace != null)  trace.add(root.left);
				return;
			}
			else {
				insertBST(root.left,val,trace);
			}
		}
	}
	
	
}
