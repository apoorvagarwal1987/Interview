package implement;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode(int x){
		value = x;
		left=right=next =null;
	}
}

public class Boundary {
	private static void traverseLeft(TreeNode node){
		if(node.left==null && node.right!=null)
			System.out.print(node.value+"  ");
		
		while(node.left!=null){
			if(node.left==null && node.right==null){				
			}
			else
				System.out.print(node.value +"  ");
			node=node.left;
		}			
	}
	private static void traverseChild(TreeNode node){
		if(node==null)
			return;
		
		traverseChild(node.left);
		if(node.right==null && node.left==null)
			System.out.print(node.value+"  ");
		
		traverseChild(node.right);
		
	}
	private static void traverseRight(TreeNode node){
		if(node==null)
			return;
		
		traverseRight(node.right);
		
		if(node.left==null && node.right==null)
			{}
		
		else
			System.out.print(node.value +"  ");
	}

	
	public static void main (String ... args){
		 TreeNode root= new TreeNode(1);
		 root.left = new TreeNode(2);
		 root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4);
		 root.left.right = new TreeNode(5);
		 root.right.left= new TreeNode(8);
		 root.right.right= new TreeNode(9);
		 root.left.left.left= new TreeNode(6);
		 root.left.right.left= new TreeNode(7);
		 traverseLeft(root);
		 traverseChild(root);
		 traverseRight(root.right);
	}
}
