package implement;

public class Preorder {
	
	int findBig(int [] arr, int low , int high,int num){
		int i;
		for(i= low;i<=high;i++){
			if(arr[i]>num)
				break;
		}
		return i;
	}
	
	
	TreeNode makeBST (int arr[], int low, int high){
		if(low>high)
			return null;
		
		if(low==high)
			return new TreeNode(arr[low]);

		TreeNode node = new TreeNode(arr[low]);
		int find = findBig(arr, low+1, high,arr[low]);
		node.left=makeBST(arr, low+1, find-1);
		node.right=makeBST(arr, find, high);
		return node;
	}
	
	void inOrder(TreeNode node){
		if(node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.value+"  ");
		inOrder(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={10,5,1,7,40,50};
		Preorder inp = new Preorder();
		TreeNode root = inp.makeBST(arr, 0, arr.length-1);
		inp.inOrder(root);
	}

}
