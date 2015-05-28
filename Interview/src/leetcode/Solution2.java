package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution2 {
	
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		
		HashMap<String,Integer> present = new HashMap<String,Integer>();
		HashMap<String,Integer> scan = new HashMap<String,Integer>();
		int len=s.length();
		
		for(String st:words){
			if(present.containsKey(st))
				present.put(st,present.get(st)+1);
			
			else
				present.put(st, 1);
		}
		
		int i=0,j=0,cut=0;
		while(i<s.length()){
			cut = i + words[0].length() * words.length;

			j=i;
			while(j<s.length() && j<cut && cut<=s.length()){
				String key = s.substring(j, j+words[0].length());
				if(present.containsKey(key)){
					if(scan.containsKey(key)){
						if(scan.get(key)==present.get(key)){
							break;
						}
						else {
							scan.put(key, scan.get(key)+1);
						}						
					}
					else{
						scan.put(key, 1);
					}
				}
				else{
					break;
				}
				
				j+=words[0].length();
				
			}
			
			
			if(j==cut){
				result.add(i);				
			}
			scan.clear();
			i++;
						
		}
		
		return result;
    }

	
	public int[] searchRange(int[] A, int target){
		int[] result = new int[2];
		
		result[0]=findMin(A,0,A.length-1,target);
		if(result[0]==-1)
			result[1]=-1;
		
		else{
			result[1]=result[0];
			result[1]=findMax(A, result[0], A.length-1, target);			
		}
		
		return result;		
	}
	
	public int findMin(int[]A, int low, int high, int target){
		if(low==high && A[low]==target)
			return low;
		
		if(low==high && A[low]!=target)
			return -1;
		
		if(low>high)
			return -1;
		
		int mid = low + (high-low)/2;
		
		
		
		if(A[mid]==target)
			if(mid-1>-1 && A[mid-1]==target)
				return findMin(A, low, mid-1, target);
		
			else
				return mid;
		
		else if(A[mid]>target)
			return findMin(A, low, mid-1, target);
		
		else
			return findMin(A, mid+1,high, target);
	}
	
	public int findMax(int[]A, int low, int high, int target){
		if(low==high && A[low]==target)
			return low;
		
		if(low==high && A[low]!=target)
			return -1;
		
		if(low>high)
			return -1;
		
		int mid = low + (high-low)/2;
		
		
		
		if(A[mid]==target)
			if(mid+1<A.length && A[mid+1]==target)
				return findMax(A, mid+1, high, target);
		
			else
				return mid;
		
		else if(A[mid]>target)
			return findMax(A, low, mid-1, target);
		
		else
			return findMax(A, mid+1,high, target);	}

    public int searchInsert(int[] A, int target) {
        return searchPos(A,0,A.length-1,target);
    }
    
    public int searchPos(int []A, int low, int high, int target){
    	
    	if(low>high)
    		return low;
    	
    	int mid = low + (high-low)/2;
    	
    	if(A[mid]==target)
    		return mid;
    	
    	else if(A[mid]>target)
    		return searchPos(A, low, mid-1, target);
    	
    	else
    		return searchPos(A, mid+1, high, target);   	
    	
    }
    
    public String countAndSay(int n){
    	System.out.println(1);
    	return countUtil(n , "1");
    }

    public String countUtil(int total, String current){
    	if(total==0)
    		return current;
    	
    	int count,i=0;
    	String currString="";
    	int len=current.length();
    	while(i<len){
    		char cCurr = current.charAt(i);
    		count=1;
    		while(++i<len && cCurr==current.charAt(i)) 
    			count++;
    		
    		currString=currString+count+cCurr;
    	}
    	System.out.println(currString);
    	return countUtil(--total,currString);
    }
    
    
    
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String words[] ={"fooo","barr","wing","ding","wing"};
		//System.out.println(new Solution2().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", words));
	
		String  words[] ={"foo","bar"};
		//System.out.println(new Solution2().findSubstring("barfoothefoobarman", words));

		int []A= {0,0,1,2,2};
		System.out.println(new Solution2().countAndSay(5));
		
	}

}
