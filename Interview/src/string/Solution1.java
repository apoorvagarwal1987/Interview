package string;

import java.util.*;
public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Scanner inp = new Scanner(System.in);
		int testCases = inp.nextInt();
		boolean flag ;
		for(int k=1;k<=testCases;k++){
			String input = inp.next();
			int i =0, j = input.length()-1;
			
			flag = false;
			
			while(!flag && i<input.length()-2){
				
				int a = (int)input.charAt(i);
				int b = (int)input.charAt(i+1);
				int c = (int)input.charAt(j);
				int d = (int)input.charAt(j-1);
				
				if(Math.abs(a-b)!= Math.abs(c-d)){
					flag=true;
				}
				i++;
				j--;
			}
			if(flag)
				System.out.println("Not Funny");
			
			else
				System.out.println("Funny");
		}
		
		inp.close();
	}

}
