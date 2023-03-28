package Pieces;
import Game.Board;
import java.util.LinkedList;
import java.util.List;

public class Knight extends Piece {
//    private int file, rank;
//    private char colour;
//    private int position;
//    private LinkedList <Integer> attackSq = new LinkedList();
//    private LinkedList <Integer> movementSq = new LinkedList();
    final char type = 'n';

    public Knight(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }

    @Override
    void findAttackSq() {
        attackSq.clear();
        attackSq.add(position-17);
        attackSq.add(position-15);
        attackSq.add(position-10);
        attackSq.add(position-6);
        attackSq.add(position+6);
        attackSq.add(position+10);
        attackSq.add(position+15);
        attackSq.add(position+17);
        removeSq();
        // finds all posible moves the knight could make if it is in the middle of the board
       // removeSq();
        // checks to see if any moves needs to be removed from the list due to the knight being on the edge of the board
    }
    void removeSq(){
        if (rank < 2) {
                attackSq.removeFirstOccurrence(position-17);
                attackSq.removeFirstOccurrence(position-15);
            if (rank < 1) {
                    attackSq.removeFirstOccurrence(position-10);
                    attackSq.removeFirstOccurrence(position-6);
            }
        }if (rank > 5) {
                attackSq.removeFirstOccurrence(position+17);
                attackSq.removeFirstOccurrence(position+15);
            if (rank > 6) {
                    attackSq.removeFirstOccurrence(position+10);
                    attackSq.removeFirstOccurrence(position+6);
            }
        }if (file < 2) {
                attackSq.removeFirstOccurrence(position-10);
                attackSq.removeFirstOccurrence(position+6);
            if (file < 1) {
                    attackSq.removeFirstOccurrence(position-17);
                    attackSq.removeFirstOccurrence(position+15);
            }
        }if (file > 5) {
                attackSq.removeFirstOccurrence(position-6);
                attackSq.removeFirstOccurrence(position+10);
            if (file > 6) {
                    attackSq.removeFirstOccurrence(position-15);
                    attackSq.removeFirstOccurrence(position+17);  
            }
        }
    }
    @Override
    void findMovementSq(List<Piece> piecesInPlay) {
        blockedMoves.clear();
        movementSq = attackSq;
        for (int i = 0; i < piecesInPlay.size(); i++) {
            if (piecesInPlay.get(i).getColour() == colour && movementSq.contains(piecesInPlay.get(i).getPosition())) { // checks if there is a piece on a square the knight attacks and if it can be captured or if it is the same colour as the knight
                    movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition()); // if the square is unreachable it indicates the knight can't move there
                    blockedMoves.add(piecesInPlay.get(i).getPosition());
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
