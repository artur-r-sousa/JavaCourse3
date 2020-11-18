package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.Color;

public class WPawn extends Pawn {

	public WPawn(Board board, Color color) {
		super(board, color);
		
	}
	
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];		
		Position p = new Position(0, 0);		

		p.setValues(position.getRow() - 1, position.getColumn());
		if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
			
		//capture
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//enPassant
		return mat;
	}
	
	
}
