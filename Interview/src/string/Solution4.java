package string;
import java.util.*;


public class Solution4 {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int diff =0;
		int count[] = new int[26];

		String st=scanner.next();
		int i = 0;
		boolean present[] = new boolean[26];
		while(i<st.length()){
			if(st.charAt(i)>=97 && st.charAt(i)<=122){
				int loc = st.charAt(i)-97; 
				present[st.charAt(i)-97]=true;
				count[loc]++;
			}
			i++;
		}
		diff=st.length();
		st=scanner.next();
		i =0;
		while(i<st.length()){
			if(st.charAt(i)>=97 && st.charAt(i)<=122){
				int loc = st.charAt(i)-97; 
				if(count[loc]>0){
					count[loc]--;
					diff--;
				}
				else
					diff++;				
			}
			i++;
		}



		scanner.close();
	}


}
