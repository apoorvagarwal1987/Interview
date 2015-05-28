package string;
import java.util.*;
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		
		for(int k = 1;k<=test;k++){
			int count[] = new int[26];
			int count1[] = new int[26];
			String st=scanner.next();
			
			
			if(st.length()%2!= 0)
				System.out.println("-1");
			
			else{
				int i = 0;
				while(i<st.length()/2){
					if(st.charAt(i)>=97 && st.charAt(i)<=122){
						int loc = st.charAt(i)-97; 
						count[loc]++;
					}
					i++;
				}
				int total=0;
				while(i<st.length()){
					if(st.charAt(i)>=97 && st.charAt(i)<=122){
						int loc = st.charAt(i)-97; 
						if(count[loc]>0)
							count[loc]--;
						
						else{
							count1[loc]++;
						}							
					}
					i++;
				}
				for(i=0;i<count.length;i++){
					if(count[i]!=0 || count1[i]!=0)
						total+=count[i]+count1[i];
				}
				if(total%2==0)
					System.out.println(total/2);
				
				else
					System.out.println("-1");
			}
						
		}		
		scanner.close();

	}

}
