package leetcode;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode next;
	
	public TreeNode(int x){
		val = x;
		left=right=next =null;
	}
}
public class Solution109 {
	
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
            
        return build(head, head,findTail(head));
    }
    
    
    private TreeNode build(ListNode in, ListNode start, ListNode end){
        
        if(end==start)
            return new TreeNode(start.val);
        
        
        ListNode prevMid = findMid(start,end);
        
        if(start.next==end){
            TreeNode node = new TreeNode(prevMid.val); 
            node.right=new TreeNode(prevMid.next.val);
            return node;
        }
            
        TreeNode node = new TreeNode(prevMid.next.val);        
        node.left=build(in, start,prevMid);        
        node.right=build(in, prevMid.next.next,end);

        return node;
    }
    
	private static ListNode findTail(ListNode node){
		if(node==null)
			return node;
		
		while(node.next!=null)
			node = node.next;
	
		return node;
		
	}
    
    private static ListNode findMid(ListNode start,ListNode end ){
	
		if(start==null || start.next==end)
			return start;
		
		ListNode prev=null;
		ListNode slow = start;
		ListNode fast = start;
		
		while(fast.next!=end.next && fast.next.next!=end.next){
			fast = fast.next.next;
			if(fast==null)
				return slow;
			prev=slow;
			slow = slow.next;
			
 		}	
		return prev;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode list = new ListNode(1);
		list.next=new ListNode(2);
		list.next.next=new ListNode(3);
		list.next.next.next=new ListNode(4);
		findMid(list, findTail(list));
	}

}
