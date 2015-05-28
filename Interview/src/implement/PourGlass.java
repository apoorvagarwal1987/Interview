package implement;

public class PourGlass {
	
	public static void glassQuantity(int gRow, int gCol, double quantity){
		double FULL=1.0;
		int total = gRow*(gRow+1)/2;
		double glasses[] = new double[total];
		int gIndex=0;
		glasses[gIndex]=quantity;
		for(int row=0;row<gRow;row++){
			for(int col=0,pos=1;col<=row;col++,pos++){
				int ch1 =gIndex+row +1;
				int ch2 =gIndex+row +2;
				double access=glasses[gIndex]-FULL;
				
				if(access<0){
					access=0;
				}
				glasses[gIndex]-=access;						
				if(ch1<total && ch2<total && access!=0){
					glasses[ch1]+=access/2;
					glasses[ch2]+=access/2;
				}
				
				if(row==gRow-1 && col==gCol-1)
					System.out.println(glasses[gIndex]);				
				
				gIndex++;
			}			
		}		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		glassQuantity(3,2 , 8);
	}

}
