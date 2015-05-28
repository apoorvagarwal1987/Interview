package implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MorrisTraversal {
	
	private static TreeNode getInorderPre(TreeNode node){
		TreeNode result=node.left;
		while(result!=null && result.right!=null && result.right!=node)
			result=result.right;	
		
		return result;
	}
	
	public static void morrisTraversal(TreeNode node){
		TreeNode inOrder =null;
		while(node!=null){
			inOrder = null;
			if(node.left!=null){
				inOrder=getInorderPre(node);
				if(inOrder.right!=node){
					inOrder.right=node;
					node=node.left;					
				}
				else{
					System.out.print(node.value+"  ");
					inOrder.right=null;
					node=node.right;
				}
			}
			else{
				System.out.print(node.value+"  ");
				node=node.right;
			}
		}		
	}
	
	private static void inOrder(TreeNode root){
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.value+"  ");
		inOrder(root.right);
	}
	
	   public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>> output = new ArrayList<List<Integer>>();
	        
	        Stack<TreeNode > curr = new Stack<TreeNode >();
	        Stack<TreeNode > next = new Stack<TreeNode >();

	        curr.add(root);
	        
	        while(!curr.empty()){
	            TreeNode cNode = null;
	            
	            List<Integer> left = new ArrayList<Integer>();
	            while(!curr.empty()){
	                cNode=curr.pop();
	                if(cNode==null)
	                    continue;
	                left.add(cNode.value);
	                next.push(cNode.left);
	                next.push(cNode.right);           
	            }
	            if(left.size()>0)
	            	output.add(left);	
	            	
	            List<Integer> right = new ArrayList<Integer>();            
	            while(!next.empty()){
	                cNode=next.pop();
	                if(cNode==null)
	                    continue;
	                right.add(cNode.value);
	                curr.push(cNode.right);
	                curr.push(cNode.left);           
	            }
	            if(right.size()>0)
	            	output.add(right);	            
	            
	        }
	        return output;
	    }
	
	   
	    static int pos=0;
	    
	    private int find(int[]arr, int num,int start, int end){
	        int i =start;
	        for(;i<=end;i++){
	            if(arr[i]==num)
	                break;                 
	        }
	        return i;
	    }

	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        
	        return build(preorder, inorder, 0,inorder.length-1);
	    }
	    
	    private TreeNode build(int[]pre, int[] in, int start, int end){
	        
	        if(pos>pre.length-1 || start<0 || end>=in.length || end<start)
	            return null;
	            
	        TreeNode node = new TreeNode(pre[pos]);        
	        int place = find(in, pre[pos],start,end);
	        
	        pos++;
	        node.left=build(pre, in, start,place-1);
	        node.right=build(pre, in, place+1,end);
	        
	        return node;
	    }   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 TreeNode root= new TreeNode(1);
		/* root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(5);
		 root.right.left= new TreeNode(8);
		 root.right.right= new TreeNode(9);
		 root.left.left.left= new TreeNode(6);
		 root.left.right.left= new TreeNode(7);*/
		 //inOrder(root);
		 System.out.println();
		 List<List<Integer>> output = zigzagLevelOrder(root);
	}

}
