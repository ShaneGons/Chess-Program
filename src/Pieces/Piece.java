package Pieces;
import java.util.*;
import Game.*;
public abstract class Piece {
    int file, rank; // location of piece on the board
    char colour; // colour of piece
    int position; // position of piece on board
    LinkedList<Integer> attackSq = new LinkedList(); // all the squares a piece can attack
    LinkedList<Integer> movementSq = new LinkedList(); // all the squares a piece can move to (takes into account other pieces)
    LinkedList<Piece> piecesBlocked = new LinkedList();// list of pieces that it blocks from moving to certain squares
    char type;
    LinkedList<Integer> blockedMoves = new LinkedList();
    int pieceValue;
 
    abstract void findAttackSq();
    // finds all the squares the piece can attack
    
    abstract void findMovementSq(List<Piece> piecesInPlay); 
    // the parameter is a list of all the pieces on the board
    // finds all the squares the piece can move to (takes into account other pieces)
    // can be used to check if other king is in check
    
    abstract boolean canReachSquare(int finalX, int finalY);
    // checks for if it can move to given spot
    // checks if there is a piece blocking it from moving to the spot
    
    protected boolean isLegalMove(int finalRank, int finalFile, int[][] board) { 
    // the two integer values passed are the file (finalX) and the rank (finalY) of the square that it wants to move to
    // Checks that the move is valid
        int finalPosition = Piece.calcPosition(finalFile, finalRank);
        if (movementSq.contains(finalPosition)) {
            return true;
        }return false;
    }
    
    protected int whichPieceCaptured(int position, List<Piece> piecesInPlay){
    // the list passed contains all the pieces on the board and the integer value 'position' is the position the piece wants to move to
    // does square moved to contain enemy piece
        for (int i = 0; i < piecesInPlay.size(); i++) {
                if (piecesInPlay.get(i).getPosition() == position) {
                    return position;
                }
            }return -1;
    }
    
    public static int calcPosition(int rank, int file){
        return (rank*8) + file;
        // calculates and returns the position of the piece;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public char getColour() {
        return colour;
    }

    public void setColour(char colour) {
        this.colour = colour;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public char getType(){
        return 'x';
    }

    public LinkedList getAttackSq() {
        return attackSq;
    }

    public void setAttackSq() {
        findAttackSq();
    }

    public LinkedList getMovementSq() {
        return movementSq;
    }

    public void setMovementSq(LinkedList<Piece> piecesInPlay) {
        findMovementSq(piecesInPlay);
    }

    public LinkedList getPiecesBlocked() {
        return piecesBlocked;
    }

    public void setPiecesBlocked(LinkedList piecesBlocked) {
        this.piecesBlocked = piecesBlocked;
    }

    public LinkedList<Integer> getBlockedMoves() {
        return blockedMoves;
    }

    public void setBlockedMoves(LinkedList<Integer> blockedMoves) {
        this.blockedMoves = blockedMoves;
    }

    public int getPieceValue() {
        return pieceValue;
    }

    @Override
    public String toString() {
        return "Piece{" + "file=" + file + ", rank=" + rank + ", colour=" + colour + ", position=" + position + ", movementSq=" + movementSq + ", type=" + type + '}';
    }
    
}
