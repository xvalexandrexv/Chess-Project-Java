package boardgame;

public class Board {

    private int rows;
    private int columns;
    private Piece [][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new boardException ("Error creating board: there must be at least 1 row and 1 colum");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }


    public Piece[][] getPieces() {
        return pieces;
    }

    public void setPieces(Piece[][] pieces) {
        this.pieces = pieces;
    }

    public Piece piece (int row, int column){
        if(!posistionExists(row, column)){
            throw new boardException("Position not on the board");
        }
        return pieces[row][column];
    }

    public Piece piece (Position position) {
        if(!positionExists(position)){
            throw new boardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColum()];
    }

    public int getColumns() {
        return columns;
    }

    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new boardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;
    }

    private boolean posistionExists (int row, int column) {
        return row >= 0 && row < rows && column >= 0 && row < columns;
    }

    public boolean positionExists (Position position){
        return posistionExists(position.getRow(), position.getColum());
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)){
            throw new boardException("Position not on the board");
        }
        return piece(position) != null;
    }

}
