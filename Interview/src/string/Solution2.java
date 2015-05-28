package string;

import java.util.*;

public class Solution2 {
	public static void main(String ... args){
		Scanner inp = new Scanner(System.in);
		String input = inp.nextLine().toLowerCase();
		boolean flag = true;
		boolean present[] = new boolean[26];
		
		for(int i = 0;i<input.length();i++){
			if(input.charAt(i)>=97 && input.charAt(i)<=122){
				int loc = input.charAt(i)-97; 
				present[loc]=true;
			}
		}
		
		for(int i = 0;i<present.length && flag;i++){
			if(!present[i]) flag=false;
		}
		
		if(flag)
			System.out.println("pangram");
		
		else
			System.out.println("not pangram");
		inp.close();
	}
}
