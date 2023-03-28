package GUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import Game.*;
import Pieces.*;
public class GameBoard extends javax.swing.JFrame {
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    JFrame frame;
    JButton squares[][] = new JButton[8][8];
    private int position = -1;
    boolean pieceToMove = false;
    boolean gameOver = false;
    JFrame gameFinish = new JFrame("checkmate");
    char whoseMove = 'W';
    Piece movingPiece;
    Board chessBoard = new Board("d");
    ImageIcon kingWhite = new ImageIcon("kingWhite.png");
    ImageIcon kingBlack = new ImageIcon("kingBlack.png");
    ImageIcon queenWhite = new ImageIcon("queenWhite.png");
    ImageIcon queenBlack = new ImageIcon("queenBlack.png");
    ImageIcon rookWhite = new ImageIcon("rookWhite.png");
    ImageIcon rookBlack = new ImageIcon("rookBlack.png");
    ImageIcon knightWhite = new ImageIcon("knightWhite.png");
    ImageIcon knightBlack = new ImageIcon("knightBlack.png");
    ImageIcon bishopWhite = new ImageIcon("bishopWhite.png");
    ImageIcon bishopBlack = new ImageIcon("bishopBlack.png");
    ImageIcon pawnWhite = new ImageIcon("pawnWhite.png");
    ImageIcon pawnBlack = new ImageIcon("pawnBlack.png");
    
    public GameBoard() {
        frame = new JFrame("Chess Game");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(8, 8));
        float[] black = Color.RGBtoHSB(102,39,0, null);
        float[] white = Color.RGBtoHSB(221,199,160, null);
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                squares[rank][file] = new JButton();
                if ((rank + file) % 2 == 1) {
                    squares[rank][file].setBackground(Color.getHSBColor(black[0],black[1],black[2])); // black squares
                    
                } else {
                    squares[rank][file].setBackground(Color.getHSBColor(white[0],white[1],white[2])); // white squares
                }   
                frame.add(squares[rank][file]);
                squares[rank][file].setBorder(BorderFactory.createLineBorder(Color.yellow, frame.getHeight()/100)); //sets border of square to be highlighted when selected, line thickness proportional to size of window
                squares[rank][file].setBorderPainted(false);
            }
        }
        setUpGUIBoard(chessBoard);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createActionButtonsForRestOfBoard();  //creates action for every other square
        frame.setVisible(true);
        
    }
    private void setLabels(){
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 10; file++) {
                squares[rank][file].add(new JLabel());
            }
        }
    }
    
    private void createActionButtonsForRestOfBoard() {
        squares[0][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,0);
            }
        });
        squares[0][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,1);
            }
        });
        squares[0][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,2);
            }
        });
        squares[0][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,3);
            }
        });
        squares[0][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,4);
            }
        });
        squares[0][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,5);
            }
        });
        squares[0][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,6);
            }
        });
        squares[0][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,0,7);
            }
        });
        squares[1][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,0);
            }
        });
        squares[1][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,1);
            }
        });
        squares[1][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,2);
            }
        });
        squares[1][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,3);
            }
        });
        squares[1][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,4);
            }
        });
        squares[1][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,5);
            }
        });
        squares[1][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,6);
            }
        });
        squares[1][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,1,7);
            }
        });
        squares[2][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,0);
            }
        });
        squares[2][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,1);
            }
        });
        squares[2][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,2);
            }
        });
        squares[2][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,3);
            }
        });
        squares[2][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,4);
            }
        });
        squares[2][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,5);
            }
        });
        squares[2][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,6);
            }
        });
        squares[2][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,2,7);
            }
        });
        squares[3][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,0);
            }
        });
        squares[3][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,1);
            }
        });
        squares[3][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,2);
            }
        });
        squares[3][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,3);
            }
        });
        squares[3][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,4);
            }
        });
        squares[3][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,5);
            }
        });
        squares[3][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,6);
            }
        });
        squares[3][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,3,7);
            }
        });
        squares[4][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,0);
            }
        });
        squares[4][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,1);
            }
        });
        squares[4][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,2);
            }
        });
        squares[4][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,3);
            }
        });
        squares[4][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,4);
            }
        });
        squares[4][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,5);
            }
        });
        squares[4][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,6);
            }
        });
        squares[4][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,4,7);
            }
        });
        squares[5][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,0);
            }
        });
        squares[5][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,1);
            }
        });
        squares[5][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,2);
            }
        });
        squares[5][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,3);
            }
        });
        squares[5][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,4);
            }
        });
        squares[5][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,5);
            }
        });
        squares[5][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,6);
            }
        });
        squares[5][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,5,7);
            }
        });
        squares[6][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,0);
            }
        });
        squares[6][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,1);
            }
        });
        squares[6][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,2);
            }
        });
        squares[6][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,3);
            }
        });
        squares[6][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,4);
            }
        });
        squares[6][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,5);
            }
        });
        squares[6][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,6);
            }
        });
        squares[6][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,6,7);
            }
        });
        squares[7][0].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,0);
            }
        });
        squares[7][1].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,1);
            }
        });
        squares[7][2].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,2);
            }
        });
        squares[7][3].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,3);
            }
        });
        squares[7][4].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,4);
            }
        });
        squares[7][5].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,5);
            }
        });
        squares[7][6].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,6);
            }
        });
        squares[7][7].addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqClicked(evt,7,7);
            }
        });
    }
    
    private void setUpGUIBoard(Board board){
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                Piece currentPiece = board.getPiece(rank, file);
                addGUIPiece(currentPiece, rank, file);
            }
        }
    }
    
    private boolean sqClicked(java.awt.event.ActionEvent evt, int rank, int file){
        if (!pieceToMove) {
            position = (rank*8)+file;
            System.out.println(position);
            System.out.println(chessBoard.getPiece(rank, file).getMovementSq());
            pieceToMove = true;
            squares[rank][file].setBorderPainted(true); //higlights the border of square
            return false;
        }
        int ogFile = position%8;
        int ogRank = position/8;
        squares[ogRank][ogFile].setBorderPainted(false); // unselects the original square
        pieceToMove = false;
        position = (rank*8)+file;
        if (moveToSq(ogRank,ogFile,rank,file,position)) {
            whoseMove = (whoseMove == 'W')? 'B':'W';
            Piece king = findKing(chessBoard);
            System.out.println("IsCheckMate: "+chessBoard.isCheckmate(king));
            if (chessBoard.isCheckmate(king)) {
                gameOver = true;
            }
        }else{
            return false;
        }
        gameFinish.setVisible(gameOver);
        for (int i = 0; i < chessBoard.getPiecesInPlay().size(); i++) {
        }
        return true;
    }
    
    public static void main(String[] args) {
        new GameBoard(); 
    }
    private boolean moveToSq(int ogRank, int ogFile, int finalRank, int finalFile, int finalPositon){
        movingPiece = chessBoard.getPiece(ogRank, ogFile);
        if (!(movingPiece.getColour() == whoseMove)) {
            return false;
        }if (!(movingPiece.getMovementSq().contains(finalPositon))) {
            return false;
        }Piece king = findKing(chessBoard);
        Piece initialPiece = chessBoard.getPiece(finalRank, finalFile); //gets the piece that is being replaced on board so if users move puts king into chech the original position of the board can be restored
        chessBoard.setPiece(finalRank, finalFile, movingPiece);
        chessBoard.setPiece(ogRank, ogFile, null);   
        if (chessBoard.isKingInCheck(king) != 0) {
            System.out.println("ahaaba");
            chessBoard.setPiece(ogRank, ogFile, movingPiece);
            chessBoard.setPiece(finalRank, finalFile, initialPiece);
            chessBoard.getPiecesInPlay().add(movingPiece);
            if (initialPiece.getType() != 'i') {
                chessBoard.getPiecesInPlay().add(initialPiece);
            }
            return false;
        }
        removeGUIPiece(movingPiece,ogRank,ogFile);
        addGUIPiece(movingPiece,finalRank,finalFile);
        return true;
    }
    private void addGUIPiece(Piece piece, int rank, int file){
        if (piece.getType() == 'k') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(kingWhite);
            }else squares[rank][file].setIcon(kingBlack);
        }else if (piece.getType() == 'n') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(knightWhite);
            }else squares[rank][file].setIcon(knightBlack);
        }else if (piece.getType() == 'b') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(bishopWhite);
            }else squares[rank][file].setIcon(bishopBlack);
        }else if (piece.getType() == 'r') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(rookWhite);
            }else squares[rank][file].setIcon(rookBlack);
        }else if (piece.getType() == 'q') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(queenWhite);
            }else squares[rank][file].setIcon(queenBlack);
        }else if (piece.getType() == 'p') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(pawnWhite);
            }else squares[rank][file].setIcon(pawnBlack);
        }
    }
        
    private void removeGUIPiece(Piece piece, int rank, int file){
        if (piece.getType() == 'k') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }else if (piece.getType() == 'n') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }else if (piece.getType() == 'b') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }else if (piece.getType() == 'r') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }else if (piece.getType() == 'q') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }else if (piece.getType() == 'p') {
            if (piece.getColour() == 'W') {
                squares[rank][file].setIcon(null);
            }else squares[rank][file].setIcon(null);
        }
    }
    
    private Piece findKing(Board board) {
        Piece king = new i(0,false);
        for (int i = 0; i < board.getPiecesInPlay().size(); i++) {
            if (board.getPiecesInPlay().get(i).getColour() == whoseMove && board.getPiecesInPlay().get(i).getType() == 'k') {
                king = board.getPiecesInPlay().get(i);
            }
        }return king;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
