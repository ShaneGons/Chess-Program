package Pieces;
import Game.Board;
import java.util.LinkedList;
import java.util.List;

public class Rook extends Piece {
    final char type = 'r';
    final int pieceValue = 500;

    public Rook(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }
    
    @Override
    void findAttackSq() {
        attackSq.clear();
        for (int i = 1; i <= file; i++) { //calcs horizontal line left
            attackSq.add(position-(i));
        }for (int i = 1; i <= 7-file; i++) { //calcs horizontal line right
            attackSq.add(position+(i));
        }for (int i = 1; i <= 7-rank; i++) { //calcs vertical line down
            attackSq.add(position+(8*i));
        }for (int i = 1; i <= rank; i++) { //calcs vertical line up
            attackSq.add(position-(8*i));
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
            }
            // removes the squares that are blocked off from the list of legal moves
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
