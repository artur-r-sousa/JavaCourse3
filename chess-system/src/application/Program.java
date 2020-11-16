package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {
		
		ChessMatch chessMatch = new ChessMatch();
		//asks the class UI to printBoard for the pieces-matrix created in chessMatch.getpieces
		UI.printBoard(chessMatch.getPieces());

	}

}
