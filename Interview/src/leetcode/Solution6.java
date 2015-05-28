package leetcode;

import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class Solution6 {
	
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr, first,hop,nextHop,start;
        int i=1;
        if(n==m)
            return head;
            
            
        first = head;
        for(;i<m-1;i++){
            first = first.next;
        }
        start = first.next;
        hop=start;
        nextHop=start;
        curr=first;        
        
        if(m==1){
        	if(n-m==1){
	        	nextHop=nextHop.next;
	        	hop.next=curr;
	        	curr.next=nextHop;
	        	
        	}
        	else{
        		for(i=m;i<n;i++){
    	            hop=nextHop;	            
    	            nextHop=nextHop.next;
    	            hop.next=curr;
    	            curr=hop;
    	        }
    	        first.next=nextHop;
    	        return curr;
        	}
        	
        }       
        else{        
	        for(i=m;i<=n;i++){
	            hop=nextHop;	            
	            nextHop=nextHop.next;
	            hop.next=curr;
	            curr=hop;
	        }
	        start.next=nextHop;
	        first.next=hop;
	   }
        if(m==1)
        	return start;
        else
        	return head;
    }
	
    private static void traverse(ListNode node){
    	ListNode curr = node;
		while(curr!=null){
			System.out.print(curr.val+" ");
			curr=curr.next;
		}
		System.out.println();
    }
	
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer>current = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Integer cur=1;
        Integer[] nums=new Integer[n];
        for(int i =0;i<n;i++){
            nums[i]=cur++;
        }
        combineUtil(nums, 0, k , current, result);
        return result;
    }
    
    public void combineUtil(Integer[] nums, int pos, int total , ArrayList<Integer>current, ArrayList<ArrayList<Integer>> result){
        if(current.size()==total){
            result.add(new ArrayList(current));
        }
        for(int i = pos; i<nums.length;i++){
            current.add(nums[i]);
            combineUtil(nums, i+1, total , current, result);
            current.remove(current.size()-1);
        }
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode root = new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		//root.next.next.next=new ListNode(4);
		//root.next.next.next.next=new ListNode(5);
		
		traverse(root);
		System.out.println("Traversal");
		//traverse(new Solution6().reverseBetween(root, 2, 3));
		traverse(new Solution6().reverseBetween(root,1 , 3));
		//traverse(new Solution6().reverseBetween(root, 2, 3));
		//traverse(new Solution6().reverseBetween(root, 4, 5));
		System.out.println(new Solution6().combine(4, 2 ));
	}

}
