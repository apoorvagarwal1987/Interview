package leetcode;

public class Solution1 {
	public int reverse(int x) {
        boolean isNeg=false;
        int num=0;
        if(x==0)
            return 0;
        int orig =x;
        if(x<0){
            x = x*-1;
        	isNeg=true;
        }
        
         if(x==Integer.MIN_VALUE)
        	return 0;
        
        int dig=0;
        int max = Integer.MAX_VALUE;
        int maxDig=0;
        while(max!=0){
        	maxDig++;
        	max=max/10;
        }
        	
        int next=0, first= x%10;
        while(x!=0){
        	next =x%10;        	
            if(dig+1==maxDig && (first)>=2){
            	if((first)==2){
            	    int ans = num*10+next;
            		if(ans<0 )
            			return 0;
            	}
            	else
            		return 0;
            }
            	
        	num=num*10+next;            
            dig++;
            x=x/10;
        }
        
        if(isNeg)
            num=-1* num;
            
        return num;
    }
	public static void main(String[] args) {
		System.out.println(new Solution1().reverse(-2147447412));
	}

}
