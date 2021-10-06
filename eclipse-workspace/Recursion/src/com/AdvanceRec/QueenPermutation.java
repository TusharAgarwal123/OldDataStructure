package com.AdvanceRec;

public class QueenPermutation {
	
	static int c=0;

	public static void main(String[] args) {

		boolean board[] = new boolean[4];
//		queenPermutation(board, 0, 2, "");
		queenCombination(board, 0, 2, "", 0);

	}

	static int queenPermutation(boolean[] board, int qpsf, int qt, String ans) {

		if (qpsf == qt) {
			
			System.out.println(ans);
			return 1;
		}

		int c=0;
		for (int i = 0; i < board.length; i++) {

			if (board[i] == false) {
				board[i] = true;
				c+=queenPermutation(board, qpsf + 1, qt, ans + "q" + qpsf + "b" + i + " ");
				board[i] = false;
			}
		}

		return c;
	}
	
	static void queenCombination(boolean[] board,int qpsf,int qt,String ans,int index) {
		
		if(qpsf==qt) {
			c++;
			System.out.println(c+"."+ans);
			return;
		}
		
		for(int i=index;i<board.length;i++) {
			board[i]=true;
			queenCombination(board, qpsf+1, qt, ans+"q"+qpsf+"b"+i+" ", i+1);
			board[i]=false;
		}
		
	}

}
