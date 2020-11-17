package boardgame;

public class Piece {
	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		//this.position = null; java automatically sets position as null, since its not informed

	}
	
	
	
	protected Board getBoard() {
		return board;
	}
		
}
