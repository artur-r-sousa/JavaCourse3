
package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

	public Knight(Board board, Color color) {
		super(board, color);

	}

	public String toString() {
		return "H";
	}

	public boolean[][] possibleMoves(){
			//starts a 'false'-values matrix
			boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
			
			Position p = new Position(0, 0);
			
			//n
			p.setValues(position.getRow() - 1, position.getColumn() - 2);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 1, position.getColumn() + 2);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() - 2);
			if (getBoard().positionExists(p)  && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 1, position.getColumn() + 2);
			if (getBoard().positionExists(p)  && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 2, position.getColumn() - 1);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() + 2, position.getColumn() + 1);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 2, position.getColumn() - 1);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			p.setValues(position.getRow() - 2, position.getColumn() + 1);
			if (getBoard().positionExists(p) && !isThereAllyPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			return mat;
			
	}
	
}

