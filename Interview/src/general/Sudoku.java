package general;

import java.util.ArrayList;
import java.util.List;

class PlaceLoc{
	int row;
	int col;
	public PlaceLoc(int x, int y){
		row=x;
		col=y;
	}
}

public class Sudoku {
	public void solveSudoku(char[][] board) {

		if(!isValidSudoku(board))
			return;

		solveSudokuUtil(board);
		return;

	}

	private boolean solveSudokuUtil(char[][]board){

		int [] pos = new int[2];
		PlaceLoc place =  isAvailable(board);
		if(place == null)
			return true;

		int row = place.row;
		int col = place.col;

		for(int i=1;i<10;i++){
			if(isValuePlace(board, row,col,i)){
				
				board[row][col] = Integer.toString(i).charAt(0);
				
				if(solveSudokuUtil(board))
					return true;
				
				board[row][col]='.';
			}				
		}
		return false;		
	}

	private boolean isValuePlace(char[][]board, int row, int col, int place){
		if(isSafeCol(board, row,col,place) && isSafeRow(board, row,col,place) && isSafeGrid(board, row,col,place)){
			return true;
		}
		return false;
	}

	public boolean isSafeCol(char[][]board, int row, int col, int place){
		for(int i =0;i<board.length;i++){
			if(board[i][col]!='.'){
				int num=board[i][col] - 48;
				if(place == num)
					return false;
			}
		}
		return true;	
	}

	public boolean isSafeRow(char[][]board, int row, int col, int place){
		for(int i =0;i<board.length;i++){
			if(board[row][i]!='.'){
				int num=board[row][i] - 48;
				if(num==place)
					return false;
			}
		}
		return true;		
	}
	
    public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		if(rowIndex<1)
			return null;
		int count =1;
		result.add(1);
		int prev,next;
		while(count<rowIndex){
			prev=result.get(0);
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			for(int i=1;i<result.size();i++){
				next=result.get(i);
				temp.add(i,(prev+next));
				prev=next;
			}
			temp.add(1);
			result=temp;
			count++;
		}
		return result;    
    }

	public boolean isSafeGrid(char[][]board, int row, int col, int place){

		row = row/3;
		col = col/3;

		int startRow= 3 * row;
		int startCol= 3 * col;


		for(int i =startRow;i<3+startRow;i++){		
			for(int j =startCol;j<3+startCol;j++){

				if(board[i][j]!='.'){
					int num=board[i][j] - 48;
					if(place==num)
						return false;
				}		
			}			
		}
		return true;			
	}

	public PlaceLoc isAvailable(char[][]board){
		PlaceLoc place = null; 
		for(int i = 0; i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if (board[i][j]=='.'){
					place = new PlaceLoc(i, j);
					return place;
				}
			}
		}		
		return place;
	}
	
	

	public boolean isValidSudoku(char[][] board) {
		for(int i =0;i<9;i++)
			if( !isValidRow(board,i)) 
				return false;

		for(int i =0;i<9;i++)
			if( !isValidCol(board,i)) 
				return false;


		for( int i =0;i<9;i++)
			if( !isValidGrid(board,i)) 
				return false;			

		return true;
	}

	public boolean isValidRow(char[][] board, int row){
		int allow[]={0,1,2,3,4,5,6,7,8,9};
		for(int i =0;i<board.length;i++){
			if(board[row][i]!='.'){
				int num=board[row][i] - 48;
				if(num>9 || num<1)
					return false;

				if(allow[num]<0)
					return false;

				else	
					allow[num]=-num;
			}
		}
		return true;		
	}

	public boolean isValidCol(char[][] board, int col){
		int allow[]={0,1,2,3,4,5,6,7,8,9};
		for(int i =0;i<board.length;i++){
			if(board[i][col]!='.'){
				int num=board[i][col] - 48;
				if(num>=10 || num<=0)
					return false;

				if(allow[num]<0)
					return false;

				else	
					allow[num]=-num;
			}
		}
		return true;		
	}

	public boolean isValidGrid(char[][] board, int grid){
		int allow[]={0,1,2,3,4,5,6,7,8,9};

		int row = grid/3;
		int col = grid%3;

		int startRow= 3 * row;
		int startCol= 3 * col;


		for(int i =startRow;i<3+startRow;i++){		
			for(int j =startCol;j<3+startCol;j++){

				if(board[i][j]!='.')
				{
					int num=board[i][j] - 48;
					if(num>=10 || num<=0)
						return false;

					if(allow[num]<0)
						return false;

					else	
						allow[num]=-num;
				}				

			}			
		}
		return true;	
	}	

	public static void print(char board[][]){
		for(int i = 0;i<9;i++){
			for(int j =0;j<9;j++){
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();		
	}
	
	public static void main(String[] args) {
		char [][] board = new char[9][9];

		board[0]="..9748...".toCharArray();
		board[1]="7........".toCharArray();
		board[2]=".2.1.9...".toCharArray();
		board[3]="..7...24.".toCharArray();
		board[4]=".64.1.59.".toCharArray();
		board[5]=".98...3..".toCharArray();
		board[6]="...8.3.2.".toCharArray();
		board[7]="........6".toCharArray();
		board[8]="...2759..".toCharArray();
		System.out.println("Original");
		//print(board);
		//new Solution2().solveSudoku(board);
		//print(board);
		
		System.out.println(new Sudoku().getRow(5));
		//System.out.println(Integer.toString(5));
	}

}
