package Game;
import java.util.*;
import java.io.*;
import Pieces.*;
public class Board{
    protected Piece[][] gameBoard = new Piece[8][8];
    protected LinkedList<Piece> piecesInPlay = new LinkedList();

    public Board(String saveFile) {
       setUpBoard(saveFile);
    } 
    
    private void setUpBoard(String saveFile){
        String startingPosition = System.getProperty("user.dir")+"\\StartingPosition.txt";
        String fenPosition = "";
        char colour = 'W';
        try {
            BufferedReader read = new BufferedReader(new FileReader(startingPosition));
            fenPosition = read.readLine();
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }int file = 0;
        int rank = 0;
        for (int i = 0; i < fenPosition.length(); i++) {
            if (fenPosition.charAt(i) == 'W') {
                colour = 'W';
                file -= 1;
            }else if (fenPosition.charAt(i) == 'B'){
                colour = 'B';
                file -= 1;
            }else if (fenPosition.charAt(i) == '/') {
                rank++;
                file = -1;
            }else if (fenPosition.charAt(i) == 'k') {
                gameBoard[rank][file] = new King(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'n') {
                gameBoard[rank][file] = new Knight(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'b') {
                gameBoard[rank][file] = new Bishop(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'r') {
                gameBoard[rank][file] = new Rook(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'q') {
                gameBoard[rank][file] = new Queen(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'p') {
                gameBoard[rank][file] = new Pawn(rank, file, colour);
            }else {
                int n = Character.getNumericValue(fenPosition.charAt(i));
                for (int j = 0; j < n; j++) {
                    gameBoard[rank][file+j] = new i(0,false);
                }file = file+n-1;
            }
            if (file != -1) {
                if (gameBoard[rank][file].getType() != 'i') {
                    piecesInPlay.add(gameBoard[rank][file]);
                }
            }file++;
            file = (file > 7)? 0:file;
            
        }
        for (int i = 0; i < piecesInPlay.size(); i++) {
            piecesInPlay.get(i).setMovementSq(piecesInPlay);
        }
    }
    public Piece getPiece(int rank, int file){
        try{
        return gameBoard[rank][file];
        }catch(Exception e){
            i notRealPiece = new i(0,false);
            return (notRealPiece);
        }
    }
    public void setPiece(int rank, int file, Piece piece){
        if (piece == null) {
            gameBoard[rank][file] = new i(0,false);
            piecesInPlay.remove(gameBoard[rank][file]);
        }else{
            piecesInPlay.remove(gameBoard[rank][file]);
            gameBoard[rank][file] = piece;
            gameBoard[rank][file].setRank(rank);
            gameBoard[rank][file].setFile(file);
            gameBoard[rank][file].setPosition(gameBoard[rank][file].calcPosition(rank,file));
        }for (int i = 0; i < piecesInPlay.size(); i++) {
            piecesInPlay.get(i).setAttackSq();
            piecesInPlay.get(i).setMovementSq(piecesInPlay);
        }
    }
    public boolean isEmpty(int rank, int file){
        return gameBoard[rank][file].getType() == 'i';
    }
    public void printBoard(){
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (gameBoard[rank][file].getType() == 'p') {
                    System.out.print("p");
                }else if (gameBoard[rank][file].getType() == 'b') {
                    System.out.print("b");
                }else if (gameBoard[rank][file].getType() == 'n') {
                    System.out.print("n");
                }else if (gameBoard[rank][file].getType() == 'r') {
                    System.out.print("r");
                }else if (gameBoard[rank][file].getType() == 'q') {
                    System.out.print("q");
                }else if (gameBoard[rank][file].getType() == 'k') {
                    System.out.print("k");
                }else System.out.print(" ");
            }System.out.println("");
        }
    }

    public LinkedList<Piece> getPiecesInPlay() {
        return piecesInPlay;
    }

    public void setPiecesInPlay(LinkedList<Piece> piecesInPlay) {
        this.piecesInPlay = piecesInPlay;
    }
    
    public int isKingInCheck(Piece king) {
        System.out.println("king: "+ king.getPosition());
        int numberOfChecks = 0;
        for (int i = 0; i < piecesInPlay.size(); i++) {
            if (piecesInPlay.get(i).getMovementSq().contains(king.getPosition())) {
                numberOfChecks++;
            }
        }return numberOfChecks;
    }
    public boolean isCheckmate(Piece king) {
        System.out.println("isking: "+isKingInCheck(king));
        boolean needsTwo = false;
        int n = isKingInCheck(king);
        if (n != 0) {
            for (int i = 0; i < piecesInPlay.size(); i++) {
                if (!piecesInPlay.get(i).equals(king)) {
                    king.getMovementSq().removeAll(piecesInPlay.get(i).getMovementSq());
                    king.getMovementSq().removeAll(piecesInPlay.get(i).getBlockedMoves());
                    if (piecesInPlay.get(i).getMovementSq().contains(king.getPosition())) {
                        for (int j = 0; j < piecesInPlay.size(); j++) {
                            if (piecesInPlay.get(j).getMovementSq().contains(piecesInPlay.get(i).getPosition())) {
                                needsTwo = true;
                            }
//                            }for (int k = 0; k < 10; k++) {
//                                if (piecesInPlay.get(k).getColour() == king.getColour() ) {
//                                
//                                }
//                            }
                        }
                    }
                }
            }System.out.println("hshs");
            System.out.println(n);
            System.out.println(needsTwo);
            System.out.println("hh");
            return ((king.getMovementSq().isEmpty()) && (needsTwo == false || n > 1))? true:false;
        }else return false;
    }

    public Piece[][] getGameBoard() {
        return gameBoard;
    }
}
