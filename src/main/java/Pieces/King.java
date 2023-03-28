package Pieces;
import java.util.LinkedList;
import java.util.List;
import Game.Board;

public class King extends Piece {
//    private int file, rank;
//    private char colour;
//    private int position;
//    private LinkedList <Integer> attackSq = new LinkedList();
//    private LinkedList <Integer> movementSq = new LinkedList();
    final char type = 'k';

    public King(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }

    @Override
    void findAttackSq() {
        attackSq.clear();
        // checking if the king is at the end of the board
        if (file != 0) { //checking if king is in the A file
            attackSq.add(position-1);
            if (rank != 0) { //checking if king is in the first rank rank
                attackSq.add(position-9);
            }if (rank != 7) { // checking if the king is on the last rank
                attackSq.add(position+7);
            }
        }if (file != 7) { // checking if the king is on the H file
            attackSq.add(position+1);
            if (rank != 0) { // checking if the king is on the first rank
                attackSq.add(position-7);
            }if (rank != 7) { // checking if the king is on the last rank
                attackSq.add(position+9);
            }
        }if (rank != 0) {
            attackSq.add(position-8);
        }if (rank != 7) {
            attackSq.add(position+8);
        }
    }

    @Override
    void findMovementSq(List<Piece> piecesInPlay) {
        blockedMoves.clear();
        movementSq = attackSq;
        for (int i = 0; i < piecesInPlay.size(); i++) {
            if (piecesInPlay.get(i).getColour() == colour && movementSq.contains(piecesInPlay.get(i).getPosition())) { //checks if there is a piece on the square the king attacks and if it can be captured
                movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition());
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
