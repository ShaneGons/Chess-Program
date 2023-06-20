package Pieces;

import java.util.List;

public class i extends Piece{ //class called i cause the piece is not real
//This is the piece that will be returned as an invalid piece/ can also be a temporary pawn for en passant,it is not a real piece
    private int moveTime; //If it is en passant move time is 1, if it is invalid piece then move time is 0
    private boolean enPassant;
    final char type = 'i';

    public i(int moveTime, boolean enPassant) {
        this.moveTime = moveTime;
        this.enPassant = enPassant;
    }
    
    @Override
    void findAttackSq() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void findMovementSq(List<Piece> piecesInPlay) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
