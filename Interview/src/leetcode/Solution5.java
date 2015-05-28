package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class Solution5 {
    public boolean exist(char[][] board, String word) {
        int i,j;
        ArrayList<Integer> present = new ArrayList<Integer>();
        for(i=0;i<board.length;i++){
            for(j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    present.clear();
                    if(existUtil(board,0,i,j,word,present)){
                        System.out.println(present);
                    	return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean existUtil(char[][]board, int pos,int rPos,int cPos,String word,ArrayList<Integer> present){
        if(pos==word.length())
            return true;
        
        if(!move(board,rPos,cPos))
            return false;
        
        int hash = rPos*board[0].length+cPos;
        if(present.contains(hash))
            return false;
        
        if(board[rPos][cPos]!=word.charAt(pos))
            return false;
        
        else{
            present.add(hash);
            if (!(existUtil(board, pos+1,rPos+1,cPos,word,present)||existUtil(board, pos+1,rPos-1,cPos,word,present)||
                    existUtil(board, pos+1,rPos,cPos-1,word,present)||existUtil(board, pos+1,rPos,cPos+1,word,present))){
            	present.remove(present.size()-1);
            	return false;
            }
            else
            	return true;
            
        }
    }
    
    private boolean move(char[][]board, int row,int col){
        if(row<0 || row>=board.length)
            return false;
        
        if(col<0 || col>=board[0].length)
            return false;
        
        return true;
    }
	
  /*  public int numDecodings(String s) {
        return numDecodingUtil(s,0);
    }
    
    private int numDecodingUtil(String s, int pos){
        if(pos>s.length())
            return 0;
            
        if(pos==s.length())
            return 1;
        String stemp = s.substring(pos,pos+1);
        int num = Integer.parseInt(s.substring(pos,pos+1));    
        int fCount =  numDecodingUtil(s, pos+1);
        
        if(pos+1==s.length())
            return fCount;
            
        num = Integer.parseInt(s.substring(pos,pos+2));
        if(num<=26 && num>0)
            return fCount + numDecodingUtil(s, pos+2);
        
        else 
             return fCount;
    }*/
    
    public int numDecodings(String s) {
        if(s.length()==0)
            return 0;
            
        int result[] = new int[s.length()];
        int pos=s.length()-1;
        if(Integer.parseInt(s.substring(pos,pos+1))!=0)
            result[s.length()-1]=1;
            
        for(pos=s.length()-2;pos>=0;pos--){
            
            if(Integer.parseInt(s.substring(pos,pos+1))!=0)
               result[pos]=result[pos+1];     
            
            int num = Integer.parseInt(s.substring(pos,pos+2));
            if(num<=26 && num>9){
                if(pos+2 >=result.length)
                    result[pos]++;
                
                if ((pos+2)<result.length)
                    result[pos]+=result[pos+2];
            }
            
        }
        return result[0];
    }
    
    
    public static void main(String[] args) {
		//"ABCE","SFES","ADEE"], "ABCESEEEFS"
		//char[][]board ={{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
		//String word="ABCESEEEFS";
		String num="01";
		//String num="60";
    	
    	System.out.println(new Solution5().numDecodings(num));
	}

}
