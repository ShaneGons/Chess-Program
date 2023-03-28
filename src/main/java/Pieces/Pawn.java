package Pieces;
import java.util.List;
import java.util.LinkedList;

public class Pawn extends Piece{
//    private int file, rank;
//    private char colour;
//    private int position;
//    private LinkedList <Integer> attackSq = new LinkedList();
//    private LinkedList <Integer> movementSq = new LinkedList();
    final char type = 'p';

    public Pawn(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }

    @Override
    void findAttackSq() {
        attackSq.clear();
        if (colour == 'W'){
            if (rank != 0){
                attackSq.add(position-8);
                if (rank == 6) { // checks if this is the pawn's first move and whether it can go two squares
                    attackSq.add(position-16);
               }
            }// adds the squares the pawn can capture on
            if (file != 0){
                attackSq.add(position-9);
            }if (file != 7){
                attackSq.add(position-7);
            }
        }else{
            if (rank != 7) {
                attackSq.add(position+8);
                if (rank == 1) {
                    attackSq.add(position+16);
                }
            }if (file != 0){
                attackSq.add(position+7);
            }if (file != 7) {
                attackSq.add(position+9);
            }
        }
    }

    @Override
    void findMovementSq(List<Piece> piecesInPlay) {
        blockedMoves.clear();
        movementSq = attackSq;
        boolean cannotCaptureLeft = true;
        boolean cannotCaptureRight = true;
        for (int i = 0; i < piecesInPlay.size(); i++) {
            if (movementSq.contains(piecesInPlay.get(i).getPosition())) {
                if (piecesInPlay.get(i).getFile() == file) {
                    movementSq.removeFirstOccurrence(position+16);
                    movementSq.removeFirstOccurrence(position-16);
                    if (piecesInPlay.get(i).getRank() == rank+1 || piecesInPlay.get(i).getRank() == rank-1) {
                        movementSq.removeFirstOccurrence(position+8);
                        movementSq.removeFirstOccurrence(position-8);
                    }
                }// this checks if there is an enemy piece that can capture, if the enemy piece position is position+x, the pawn is white, if the it's position-x the it is black
                if (piecesInPlay.get(i).getPosition() == position+7 || piecesInPlay.get(i).getPosition() == position-9) {
                    if (piecesInPlay.get(i).getColour() == colour) {
                        blockedMoves.add(piecesInPlay.get(i).getPosition());
                        movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition());
                    }
                    cannotCaptureLeft = false; // updates if there is a piece to be captured on the left of the piece
                }if ((piecesInPlay.get(i).getPosition() == position+9 && piecesInPlay.get(i).getColour() != colour) || (piecesInPlay.get(i).getPosition() == position-7 && piecesInPlay.get(i).getColour() != colour)) {
                    cannotCaptureRight = false; // updates if there is a piece to ne captured on the right of the piece
                }
            }
        }if (cannotCaptureRight) {
            movementSq.removeFirstOccurrence(position+9);
            movementSq.removeFirstOccurrence(position-7);
        }if (cannotCaptureLeft) {
            movementSq.removeFirstOccurrence(position+7);
            movementSq.removeFirstOccurrence(position-9);
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
