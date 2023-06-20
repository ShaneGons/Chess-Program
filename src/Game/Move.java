package Game;

import Pieces.Piece;

public class Move {
    private int ogRank, ogFile, finalRank, finalFile, ogPosition, finalPosition;
    private Piece movingPiece, replacedPiece;

    public Move(int ogRank, int ogFile) {
        this.ogRank = ogRank;
        this.ogFile = ogFile;
        this.ogPosition = Piece.calcPosition(ogRank, ogFile);
    }
    public Move(){
        
    }

    public int getOgRank() {
        return ogRank;
    }

    public void setOgRank(int ogRank) {
        this.ogRank = ogRank;
    }

    public int getOgFile() {
        return ogFile;
    }

    public void setOgFile(int ogFile) {
        this.ogFile = ogFile;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public void setFinalRank(int finalRank) {
        this.finalRank = finalRank;
    }

    public int getFinalFile() {
        return finalFile;
    }

    public void setFinalFile(int finalFile) {
        this.finalFile = finalFile;
    }

    public int getOgPosition() {
        return ogPosition;
    }

    public void setOgPosition(int ogPosition) {
        this.ogPosition = ogPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition() {
        this.finalPosition = Piece.calcPosition(finalRank, finalFile);
    }

    public Piece getMovingPiece() {
        return movingPiece;
    }

    public void setMovingPiece(Piece movingPiece) {
        this.movingPiece = movingPiece;
    }

    public Piece getReplacedPiece() {
        return replacedPiece;
    }

    public void setReplacedPiece(Piece replacedPiece) {
        this.replacedPiece = replacedPiece;
    }
    public int calcRank(int position){
        int rank = position/8;
        return rank;
    }
    public int calcFile(int position){
        int file = position%8;
        return file;
    }
    public void setFinalPosition(int finalPosition){
        this.finalPosition = finalPosition;
    }
    public void setOgPosition(){
        this.ogPosition = Piece.calcPosition(ogRank, ogFile);
    }

    @Override
    public String toString() {
        return "Move{" + "ogRank=" + ogRank + ", ogFile=" + ogFile + ", finalRank=" + finalRank + ", finalFile=" + finalFile + ", ogPosition=" + ogPosition + ", finalPosition=" + finalPosition + ", movingPiece=" + movingPiece + ", replacedPiece=" + replacedPiece + '}';
    }
    
}
