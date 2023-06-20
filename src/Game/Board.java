package Game;
import java.util.*;
import java.io.*;
import Pieces.*;
public class Board{
    public Piece[][] gameBoard = new Piece[8][8];
    public LinkedList<Piece> piecesInPlay = new LinkedList();
    public Player currentPlayer;

    public Board() {
    } 
    
    public void setUpBoard(String saveFile, Player player1, Player player2){
        String startingPosition = System.getProperty("user.dir")+"\\"+saveFile+".txt"; //gets the contents from file in specified location
        String fenPosition = "";
        char colour = 'W';
        try {
            BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
            fenPosition = read.readLine(); //the first line of the file is turned into the fen position
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }int file, rank = 0;
        rank = file = 0;
        for (int i = 0; i < fenPosition.length(); i++) { //loops through the fen string
            System.out.println(fenPosition);
            if (fenPosition.charAt(i) == 'W') { //if W, means incoming pieces are white
                colour = 'W';
                file -= 1;
            }else if (fenPosition.charAt(i) == 'B'){ //if B, means incoming pieces are black
                colour = 'B';
                file -= 1;
            }else if (fenPosition.charAt(i) == '/') { //if /, means the row is over and move to the next
                rank++;
                file = -1;
            }else if (fenPosition.charAt(i) == 'k') { //if k, means there is a king at this rank and file
                gameBoard[rank][file] = new King(rank, file, colour); // adds piece to to gameBoard
            }else if (fenPosition.charAt(i) == 'n') {//if n, means there is a knight at this rank and file
                gameBoard[rank][file] = new Knight(rank, file, colour); 
            }else if (fenPosition.charAt(i) == 'b') {//if b, means there is a bishop at this rank and file
                gameBoard[rank][file] = new Bishop(rank, file, colour); 
            }else if (fenPosition.charAt(i) == 'r') {//if r, means there is a rook at this rank and file
                gameBoard[rank][file] = new Rook(rank, file, colour); 
            }else if (fenPosition.charAt(i) == 'q') { //if q, means there is a queen at this rank and file
                gameBoard[rank][file] = new Queen(rank, file, colour);
            }else if (fenPosition.charAt(i) == 'p') { //if p, means there is a pawn at this rank and file
                gameBoard[rank][file] = new Pawn(rank, file, colour);
            }else { // if there is a integer
                int n = Character.getNumericValue(fenPosition.charAt(i));
                for (int j = 0; j < n; j++) { //integer says the number of empty spaces
                    gameBoard[rank][file+j] = new i(0,false); //adds invalid pieces to show empty spaces
                }file = file+n-1; //moves to the next file with a piece
            }
            if (file != -1) {
                if (gameBoard[rank][file].getType() != 'i') { //if not an empty space
                    piecesInPlay.add(gameBoard[rank][file]); //adds piece to the list of black pieces currently on the board
                    if (gameBoard[rank][file].getColour() == player1.getColour()){
                        player1.getPiecesInPlay().add(gameBoard[rank][file]);
                    }else player2.getPiecesInPlay().add(gameBoard[rank][file]);
                }
            }file++;
            file = (file > 7)? 0:file; //if end of file, go to the start of the file
            
        }
        for (int i = 0; i < player1.getPiecesInPlay().size(); i++) { //cycles through all pieces in play
            player1.getPiecesInPlay().get(i).setMovementSq(piecesInPlay); //sets valid moves for white
        }for (int i = 0; i < player2.getPiecesInPlay().size(); i++) {
            player2.getPiecesInPlay().get(i).setMovementSq(piecesInPlay);//set valid moves for black
        }
    }
    public String convertBoardToFen(){
        char currentColour = 'B';
        String fenString = "B";
        int n = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (gameBoard[i][j].getType() == 'i') {
                    n++;
                }else{
                    if (n!=0){
                        fenString += n;
                        n=0;
                    }
                    if (!(gameBoard[i][j].getColour() == currentColour)) {
                        currentColour = gameBoard[i][j].getColour();
                        fenString += currentColour;
                    }fenString += gameBoard[i][j].getType();
                }
            }if (n != 0) {
                fenString += n;
            }
            n=0;
            fenString += "/";
        }return fenString;
    }
    public Piece getPiece(int rank, int file){
        try{
        return gameBoard[rank][file];
        }catch(Exception e){
            i notRealPiece = new i(0,false);
            return (notRealPiece);
        }
    }
    public void setPiece(int rank, int file, Piece piece, Player player1, Player player2){
        if (piece == null) { //if setting an empty square
            gameBoard[rank][file] = new i(0,false); //then add invalid piece
            piecesInPlay.remove(piece);
            player1.piecesInPlay.remove(piece);
            player2.piecesInPlay.remove(piece);
        }else{
            piecesInPlay.remove(gameBoard[rank][file]);
            if (gameBoard[rank][file].getColour() == player1.getColour()) {
                player1.getPiecesInPlay().remove(gameBoard[rank][file]);
            }else player2.getPiecesInPlay().remove(gameBoard[rank][file]);//if a piece is being captured it is removed from the list of pieces in play
            gameBoard[rank][file] = piece; //sets the moving piece to its new square
            gameBoard[rank][file].setRank(rank);
            gameBoard[rank][file].setFile(file);
            gameBoard[rank][file].setPosition(gameBoard[rank][file].calcPosition(rank,file));
            //updates the piece's info
        }for (int i = 0; i < piecesInPlay.size(); i++) { //sets the valid moves for the pieces
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
    
    public int isKingInCheck() {
        int numberOfChecks = 0; //no. of pieces that check the king 
        Piece king = findKing(currentPlayer.getColour());
        for (int i = 0; i < piecesInPlay.size(); i++) { //cycle through array
            if (piecesInPlay.get(i).getMovementSq().contains(king.getPosition())) { //if piece checks king (contains the kings position in its list of legal squares)
                numberOfChecks++;
            }
        }return numberOfChecks;
    }
    private int isKingInCheck(Piece king) {
        int numberOfChecks = 0; //no. of pieces that check the king
        for (int i = 0; i < piecesInPlay.size(); i++) { //cycle through array
            if (piecesInPlay.get(i).getMovementSq().contains(king.getPosition())) { //if piece checks king (contains the kings position in its list of legal squares)
                numberOfChecks++;
            }
        }return numberOfChecks;
    }
    public boolean isCheckmate() {
        Piece king = findKing(currentPlayer.getColour());
        boolean needsTwo = false;
        int n = isKingInCheck(); //checks if king is in check
        if (n != 0) {
            for (int i = 0; i < piecesInPlay.size(); i++) { //loops through ever piece in play
                if (!piecesInPlay.get(i).equals(king)) {
                    king.getMovementSq().removeAll(piecesInPlay.get(i).getMovementSq());
                    king.getMovementSq().removeAll(piecesInPlay.get(i).getBlockedMoves());
                    //removes all squares that are attacked by enemy pieces from the kings list of available squares
                    if (piecesInPlay.get(i).getMovementSq().contains(king.getPosition())) { //if the the piece checks king
                        for (int j = 0; j < piecesInPlay.size(); j++) { //checking if the checking piece can be captured to remove king from check
                            if (piecesInPlay.get(j).getMovementSq().contains(piecesInPlay.get(i).getPosition())) {
                                System.out.println(piecesInPlay.get(j).toString());
                                needsTwo = true; //if a checking piece can be captured then two pieces need to check the king for it to be mate
                            }
                        }
                    }
                }
            }
            return ((king.getMovementSq().isEmpty()) && (needsTwo == false || n > 1))? true:false; //if king has no available move and it remains in check even if a checking piece can be captured then return checkmate
        }else return false;
    }

    public Piece[][] getGameBoard() {
        return gameBoard;
    }
    public boolean moveToSq(Move move, Player player1, Player player2){ //Move object will be passed instead
        move.setMovingPiece(getPiece(move.getOgRank(), move.getOgFile())); //piece that is to move

        if (!(move.getMovingPiece().getColour() == currentPlayer.getColour())) {  //checks if the player is trying to move their own piece
            return false;
        }if (!(move.getMovingPiece().getMovementSq().contains(move.getFinalPosition()))) { //checks if the square can be reached by the piece
            return false;
        }Piece king = findKing(currentPlayer.getColour());
        move.setReplacedPiece(getPiece(move.getFinalRank(), move.getFinalFile())); //gets the piece that is being replaced on board so if users move puts king into chech the original position of the board can be restored
        setPiece(move.getFinalRank(), move.getFinalFile(), move.getMovingPiece(), player1, player2); //moves the piece
        setPiece(move.getOgRank(), move.getOgFile(), null, player1, player2); //removes the piece of its original square
        if (isKingInCheck(king) != 0) { //checks if the player puts their king in check by moving the piece
            setPiece(move.getOgRank(), move.getOgFile(), move.getMovingPiece(), player1, player2); //if they do the move needs to be reversed
            setPiece(move.getFinalRank(), move.getFinalFile(), move.getReplacedPiece(), player1, player2);
            getPiecesInPlay().add(move.getMovingPiece());
            if (move.getReplacedPiece().getType() != 'i') {
                getPiecesInPlay().add(move.getReplacedPiece());
            }
            return false;
        }
        return true;
    }
    private Piece findKing(char whoseMove) {
        Piece king = new i(0,false);
        for (int i = 0; i < getPiecesInPlay().size(); i++) { //cycles through piecesInPlay list
            if (getPiecesInPlay().get(i).getColour() == whoseMove && getPiecesInPlay().get(i).getType() == 'k') {
                king = getPiecesInPlay().get(i);
            }
        }return king;
    }
    public void setBoard(Board board){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gameBoard[i][j] = board.getGameBoard()[i][j];
            }
        }
    }
}
