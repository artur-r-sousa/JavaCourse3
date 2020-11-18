package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public abstract class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}
	
	public String toString() {
		return "P";
	}
	
	public abstract boolean[][] possibleMoves();
	
}