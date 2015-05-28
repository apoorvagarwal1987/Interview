package general;

class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int x){
		data = x;
		next = null;
	}
}

public class SortLinkedList {
	
	private static ListNode findMid(ListNode start,ListNode end ){
	
		if(start==null || start.next==end)
			return start;
		
		ListNode slow = start;
		ListNode fast = start;
		
		while(fast!=end && fast!=null && fast.next!=end && fast.next.next!=null){
			fast = fast.next.next;
			if(fast==null)
				return slow;
			slow = slow.next;
 		}	
		return slow;
		
	}
	
	private static ListNode findTail(ListNode node){
		if(node==null)
			return node;
		
		while(node.next!=null)
			node = node.next;
	
		return node;
		
	}
	
	private static ListNode mergeSort(ListNode start, ListNode end){
		
		if(start==null)
			return null;
		
		if(start==end){	
			start.next=null;
			return start;
		}

		if(start.next == end){
			if(start.data>end.data){
				int temp = start.data;
				start.data=end.data;
				end.data=temp;
			}
			end.next=null;
			return start;
		}
		
		ListNode mid = findMid(start,end);
		
		ListNode temp = mid.next;
		mid.next = null;
		ListNode m1= mergeSort(start, mid);
		ListNode m2 = mergeSort(temp, end);
		ListNode newNode=null,newCurr=null;
		
		while(m1!=null && m2!=null){
			if(m1.data>m2.data){
				if(newNode==null){
					newNode=m2;
					newCurr=m2;
				}
				else{
					newCurr.next=m2;
					newCurr=newCurr.next;
				}
				m2=m2.next;
			}
			else{
				if(newNode==null){
					newNode=m1;
					newCurr=m1;
				}
				else{
					newCurr.next=m1;
					newCurr=newCurr.next;
				}
				m1=m1.next;
			}
			newCurr.next=null;
		}
		if(m1==null){
			if(newNode==null){
				newNode=m2;
				newCurr=m2;
			}
			else
				newCurr.next=m2;
		}
		
		if(m2==null){
			if(newNode==null){
				newNode=m1;
				newCurr=m1;
			}
			else
				newCurr.next=m1;
			}		
		return newNode;
	}
	
	public static ListNode sort(ListNode node){
		return mergeSort(node, findTail(node));
	}
	
	private static void traverse(ListNode node){
		while(node!=null){
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	
	
 	public static void main(String... args){
		ListNode root = new ListNode(10);
		root.next=new ListNode(2);
		root.next.next=new ListNode(13);
		root.next.next.next=new ListNode(4);
		root.next.next.next.next=new ListNode(15);
		root.next.next.next.next.next=new ListNode(-6);
		root.next.next.next.next.next.next=new ListNode(57);
		
		traverse(sort(root));
	}
	
	
}
