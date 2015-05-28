package string;
import java.util.*;
public class Solution3 {

	public static void main(String ... args){
		Scanner inp = new Scanner(System.in);
		int count[] = new int[26];
		int gems=0;
		int size = inp.nextInt();
		for(int k = 1;k<=size;k++){
			String st=inp.next();
			int i = 0;
			boolean present[] = new boolean[26];
			while(i<st.length()){
				if(st.charAt(i)>=97 && st.charAt(i)<=122 && !present[st.charAt(i)-97]){
					int loc = st.charAt(i)-97; 
					present[st.charAt(i)-97]=true;
					count[loc]++;
				}
			i++;
			}
		}
		for(int i=0;i<count.length;i++){
			if(count[i]==size)
				gems++;
		}
		System.out.println(gems);
		inp.close();
	
	}
}
