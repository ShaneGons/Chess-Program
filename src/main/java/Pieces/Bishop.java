package Pieces;
import java.util.LinkedList;
import java.util.List;

public class Bishop extends Piece {
//    private int file, rank;
//    private char colour;
//    private int position;
//    private LinkedList <Integer> attackSq = new LinkedList();
//    private LinkedList <Integer> movementSq = new LinkedList();
    final char type = 'b';

    public Bishop(int rank, int file, char colour) {
        this.file = file;
        this.rank = rank;
        this.colour = colour;
        this.position = calcPosition(rank, file);
        findAttackSq();
    }

    @Override
    void findAttackSq() {
        attackSq.clear();
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
                int squaresBlocked; // number of squares blocked
                if (piecesInPlay.get(i).getColour() == colour) { // checking colour of blocading piece
                    blockedMoves.add(piecesInPlay.get(i).getPosition());
                    if (piecesInPlay.get(i).getPosition() == 13) {
                        System.out.println("13");
                    }
                    movementSq.removeFirstOccurrence(piecesInPlay.get(i).getPosition());
                }if (piecesInPlay.get(i).getFile() < file) { // checks file and rank
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
                // uses the same formula in findAttackSq() to calculate the squares blocked by a piece
            }
        }System.out.println(blockedMoves);
    }

    @Override
    boolean canReachSquare(int finalY, int finalX) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getType() {
        return type;
    }
    
}
