package Pieces;
import java.util.LinkedList;
import java.util.List;

public class Queen extends Piece {
    final char type = 'q';
    final int pieceValue = 900;

    public Queen(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }

    @Override
    void findAttackSq() {
        // uses the same algorithm from the rook to calculate the vertical and horizonntal squares the queen can attack
        attackSq.clear();
        for (int i = 1; i <= file; i++) {
            attackSq.add(position-(i));
        }for (int i = 1; i <= 7-file; i++) {
            attackSq.add(position+(i));
        }for (int i = 1; i <= 7-rank; i++) {
            attackSq.add(position+(8*i));
        }for (int i = 1; i <= rank; i++) {
            attackSq.add(position-(8*i));
        }
        // uses the same algorithm from the bishop to calculate the diagonal squares the queen can attack
        int topLeftDiagonal = ((file < rank)? file:rank);
        int topRightDiagonal = ((file < 7-rank)? rank:7-file);
        int bottomLeftDiagonal = ((file < 7-rank)? file:7-rank);
        int bottomRightDiagonal = ((file < rank)? 7-rank:7-file);
        // calculates the number of squares the bishop can move on each diagonal
        for (int i = 1; i <= topLeftDiagonal; i++) {
            attackSq.add(position-(9*i));
        }for (int i = 1; i <= topRightDiagonal; i++) {
            attackSq.add(position-(7*i));
        }for (int i = 1; i <= bottomLeftDiagonal; i++) {
            attackSq.add(position+(7*i));
        }for (int i = 1; i <= bottomRightDiagonal; i++) {
            attackSq.add(position+(9*i));
        }
    }

    @Override
    void findMovementSq(List<Piece> piecesInPlay) {
        blockedMoves.clear();
        movementSq = attackSq;
        for (int i = 0; i < piecesInPlay.size(); i++) {
            if (movementSq.contains(piecesInPlay.get(i).getPosition())) {
                if (piecesInPlay.get(i).getColour() == colour) { // checks if the blockading piece is a players on piece - thus whether the piece can move to and capture the blocading piece
                    movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition());
                    blockedMoves.add(piecesInPlay.get(i).getPosition());
                }
                if (piecesInPlay.get(i).getFile() == file) { // checks if the blockading piece is on the same file
                    if (piecesInPlay.get(i).getRank() > rank) { // checks if blocading piece is above or below it
                        for (int j = 1; j <= 7-piecesInPlay.get(i).getRank(); j++) { // calcs the number of squares blocked
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()+(8*j));
                        }
                    }else if (piecesInPlay.get(i).getRank() < rank) {
                        for (int j = 1; j <= piecesInPlay.get(i).getRank(); j++) { // calcs the number of squares blocked
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()-(8*j));
                        }
                    } 
                }else if (piecesInPlay.get(i).getRank() == rank) { // checks if blocading piece is on the same rank
                    if (piecesInPlay.get(i).getFile() > file) { // checks if the blockading piece is to the right or left of it
                        for (int j = 1; j <= 7-piecesInPlay.get(i).getFile(); j++) { // calcs the number of squares blocked
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()+j);
                        }
                    }else if (piecesInPlay.get(i).getFile() < file) {
                        for (int j = 1; j <= piecesInPlay.get(i).getFile(); j++) { // calcs the number of squares blocked
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()-(j));
                        }
                    }
                }
                // code from bishop
                int squaresBlocked; // number of squares blocked
                if (piecesInPlay.get(i).getFile() < file) { // checks file and rank
                    if (piecesInPlay.get(i).getRank() < rank) {
                        squaresBlocked = ((piecesInPlay.get(i).getFile() < piecesInPlay.get(i).getRank())? piecesInPlay.get(i).getFile():piecesInPlay.get(i).getRank());
                        for (int j = 1; j <= squaresBlocked; j++) {
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()-(9*j));
                        }
                    }else if (piecesInPlay.get(i).getRank() > rank){
                        squaresBlocked = ((piecesInPlay.get(i).getFile() < 7-piecesInPlay.get(i).getRank())? piecesInPlay.get(i).getFile():7-piecesInPlay.get(i).getRank());
                        for (int j = 1; j <= squaresBlocked; j++) {
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()+(7*j));
                        }
                    }
                }else if (piecesInPlay.get(i).getFile() > file) {
                    if (piecesInPlay.get(i).getRank() < rank) {
                        squaresBlocked = ((piecesInPlay.get(i).getFile() > 7-piecesInPlay.get(i).getRank())? piecesInPlay.get(i).getRank():7-piecesInPlay.get(i).getFile());
                        for (int j = 1; j <= squaresBlocked; j++) {
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()-(7*j));
                        }
                    }else if (piecesInPlay.get(i).getRank() > rank) {
                        squaresBlocked = ((piecesInPlay.get(i).getFile() < piecesInPlay.get(i).getRank())? 7-piecesInPlay.get(i).getRank():7-piecesInPlay.get(i).getFile());
                        for (int j = 1; j <= squaresBlocked; j++) {
                            movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()+(9*j));
                        }
                    }
                }
            }
        }
    }

    @Override
    boolean canReachSquare(int finalX, int finalY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getType() {
        return type;
    }
    
}
