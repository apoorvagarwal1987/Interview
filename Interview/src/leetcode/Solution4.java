package leetcode;

import java.util.Arrays;

public class Solution4 {
	   public void getPermutation(int n, int k) {
	        Integer[] nums = new Integer[n];
	        int count=1;
	        for(int i=0;i<n;i++)
	            nums[i]=count++;
	        
	        
	        int result[] = new int[2];
	        permuteUtil(nums,0,result,k);
	    }
	    
	    public void permuteUtil(Integer[] nums, int pos, int[] result, int k){
	   
	        if(pos==nums.length-1 ){
	        	result[0]++;
	        	
	        	//if(result[0]==k)
	        		System.out.println(Arrays.toString(nums));
	        	
	            return;
	        }
	        for(int i =pos;i<nums.length;i++){
	            swap(nums,pos,i);	            
	            permuteUtil(nums, pos+1,  result,k);
	            swap(nums,pos,i);
	        }
	    }
	    
	   public void swap (Integer[] nums, int pos1, int pos2){
	        int temp = (int)nums[pos1];
	        nums[pos1]=nums[pos2];
	        nums[pos2]=temp;
	    }
	   
	   
	    private void swap(int[]nums, int pos1, int pos2){
	        int temp = nums[pos1];
	        nums[pos1]=nums[pos2];
	        nums[pos2]=temp;
	    }
	    
	    
	   public void sortColors(int[] nums) {
	        int i=0,j=0,k=nums.length-1;
	        int len = nums.length;
	        for(j=0;j<len && k>0;){
	        	//System.out.println(nums[j]);
	            if(nums[j]==1)
	                j++;
	            
	            else if(nums[j]==0){
	                swap(nums,i,j);
	                i++;
	                j++;
	            }
	            
	            else{
	            	if(j<k)
	            		swap(nums,j,k);
	                k--;
	            }
	        }
	    }
	   
	   
	   
	   
	   
	   public static void main(String ... args){
		   //new Solution4().getPermutation(3, 5);
		   int[] nums ={0,0};
		   new Solution4().sortColors(nums);
		   System.out.println(Arrays.toString(nums));
	   }
}
