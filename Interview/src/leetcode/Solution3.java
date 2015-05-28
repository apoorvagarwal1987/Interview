package leetcode;

public class Solution3 {
	
	   
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]=temp;
    }
    
    public int firstMissingPositive(int[] nums) {
        int i=0 ;
        if(nums.length==0)
            return 1;
            
        int j, min=Integer.MAX_VALUE;
        for(j =0;j<nums.length;j++){
            if(nums[j]<0){
              swap(nums,i,j);
              i++;
            }
            else{
                if(min>nums[j])
                    min=nums[j];
            }
        }
        
        int pos = i;
        
        for(i=pos ; i<nums.length;i++){
            nums[i]-=min;
        }
        
        for(i=pos;i<nums.length;i++){
            
            if(nums[i]<nums.length-1){
                int val = nums[i];
                if (val<0){
                    val = -val;
                    if(nums[val]<0)
                        continue;
                    
                    nums[val]=-nums[val];
                }
                else{
                    if(nums[val]<0)
                        continue;
                        
                    nums[val]=-nums[val];
                }
            }
        }
        
        for(i=0 ; i<nums.length;i++){
           if(nums[i]>0)
            return i;
        }
        if(nums[nums.length-1]==nums.length-1)
            return min+1;
        return i;
    }
    
    public boolean canJump(int[] nums) {
        int cur=0,fast=1;
        int i =1;
        int max=0;
        if(nums.length==1)
            return true;
            
        cur=0;
        fast=cur+nums[0];
        max=0;
        
        if(fast>=nums.length-1)
                return true;
                
        for(int j=cur; cur!=fast && j<nums.length;j++){
            
            for(int k=cur;k<=fast && k<nums.length;k++){
            	int tc=k+nums[k];
                if(max<k+nums[k])
                   max=k+nums[k];
                   
                if(k+nums[k]>=nums.length-1)
                    return true;
            }
            
            if(max>=nums.length-1)
                return true;
                
            cur++;
            fast=cur+nums[cur];
            if(fast>=nums.length-1)
                return true;
                
        }
        
        return false;
    }
    
    public int numDistinct(String s, String t) {
        if(t.length()>s.length())
            return 0;
            
        int[] result= new int[1];    
        
        numDistinctUtil(s,t,0,0,result);        
        return result[0];
    }
    
    public void numDistinctUtil(String s, String t, int sPos, int tPos,int[] result){
    
        if(tPos==t.length()){
            result[0]++;
            return ;
        }    
        
        int nPos=sPos;
        
        while(nPos!=-1){
        	int pos=s.indexOf(t.charAt(tPos),nPos);
        	if(pos!=-1){
        		numDistinctUtil(s,t,pos+1,tPos+1,result);
        		nPos=s.indexOf(t.charAt(tPos),pos+1);
        	}
        	else
        		nPos=-1;
        } 
    }   
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]nums={5,9,3,2,1,0,2,3,3,1,0,0};
		//System.out.println(new Solution3().canJump(nums));
		int n = new Solution3().numDistinct("RRRR", "RRR");
		System.out.println("Result :"+n);

	}

}
