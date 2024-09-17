package game.com;

import java.util.Scanner;

public class TicTacToeGameClass {

	public static void main(String[] args) {
		
		char[][] board=new char[3][3];
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				board[i][j]=' ';
			}
		}
		
		char player='X';
		boolean gameOver=false;
		Scanner sc=new Scanner(System.in);
		
		while(!gameOver) {
			printBoard(board);
			System.out.print("please enter the location:");
			int row=sc.nextInt();
			int col=sc.nextInt();
			
			if(board[row][col]==' ') {
				board[row][col]=player;
				gameOver=haveWon(board,player);
				if(!gameOver) {
					player=(player=='X')? 'O':'X';
					
				}else {
					System.out.println("Player "+player+" won!");
					
				}
			}else {
				System.out.println("invalid move! ");
			}
			
			
		}
		
		printBoard(board);
	}
	
	private static boolean haveWon(char[][] board, char player) {
		
		//chech in each row
		for(int row=0;row<board.length;row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		
		
		//check for column
		for(int col=0;col<board[0].length;col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		
		//diagonal 1
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		
		//diagonal 2
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
			return true;
		}
		
		return false;
	}

	private static void printBoard(char[][] board) {
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[i].length;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println();
		}
	}

}
