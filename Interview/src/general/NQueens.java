package general;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<String[]> solveNQueens(int n) {
	   char[][] board = new char[n][n];
       makeBoard(n , board);
	   List<String[]> finalResult = new ArrayList<String[]>();
	   solveNQueens(n, board, 0, finalResult,0);
	   System.out.println(finalResult.indexOf(0));
	   return finalResult;
    }
	
	private void solveNQueens(int n, char [][] board, int queenPlaced, List<String[]> finalResult, int sRow) {
        //PlaceLoc place =  isAvailable(board);
		/*if(place == null){
			if(queenPlaced==n){
				String[] result = convertBoard(board);
				finalResult.add(result);				
			}
			return ;
		}

		int row = place.row;
		int col = place.col;
*/
		if(sRow!=queenPlaced)
			return;
		
		if(queenPlaced==n){
			ArrayList<String> result = new ArrayList<String>();
			for(int i=0;i<board.length;i++){
				result.add(new String(board[i]));
			}
			finalResult.add(result.toArray(new String[result.size()]));
			return;
		}
		
		for(int pR=sRow;pR<n;pR++){
			for(int pC=0;pC<n;pC++){
				if(isValidMove(board, pR,pC)){
					
					board[pR][pC] = 'Q';
					
					solveNQueens(n, board,queenPlaced+1,finalResult,pR+1);				
					
					board[pR][pC]='.';
				}
				
			}
		}
    }
	
	private boolean isValidMove(char [][]board, int row , int col){		
		return (isPlaceCol(board, row, col) && isPlaceRow(board, row, col) && isPlaceMainDig(board, row, col) && isPlaceRevMainDig(board, row, col));
	}	
	
	private boolean isPlaceCol(char board[][], int row, int col){
		for(int i=0;i<board.length;i++){
			if(board[i][col]=='Q')
				return false;
		}
		return true;
	}
	
	private boolean isPlaceRow(char board[][], int row, int col){
		for(int i =0;i<board.length;i++)
			if(board[row][i]=='Q')	
				return false;
		return true;
	}
	
	private boolean isPlaceMainDig(char board[][], int row, int col){
		int size = board.length;
		//move up
		
		int cRow = row;
		int cCol = col;
		
		while(cRow>=0 && cCol>=0){
			if(board[cRow][cCol]=='Q')
				return false;
			cRow--;
			cCol--;
		}
		cRow = row;
		cCol = col;
		while(cRow<size && cCol<size){
			if(board[cRow][cCol]=='Q')
				return false;
			cRow++;
			cCol++;
		}
		return true;
	}
	
	private boolean isPlaceRevMainDig(char board[][], int row, int col){
		int size = board.length;
		//move up
		
		int cRow = row;
		int cCol = col;
		
		while(cRow>=0 && cCol<size){
			if(board[cRow][cCol]=='Q')
				return false;
			cRow--;
			cCol++;
		}
		
		//move down
		cRow = row;
		cCol = col;
		while(cRow<size && cCol>=0){
			if(board[cRow][cCol]=='Q')
				return false;
			cRow++;
			cCol--;
		}
		return true;
	}
	
	private void makeBoard(int n , char board[][]){
		for(int i= 0;i<n;i++){
			for(int j =0;j<n;j++){
				board[i][j]='.';
			}
		}
	}
	
	public static void main(String[] args) {
		new NQueens().solveNQueens(4);

	}
}