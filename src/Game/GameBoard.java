package Game;
import AI.MiniMax;
import Backend.*;
import Main.main;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import Pieces.*;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import libraryFunctions.repository;
public class GameBoard extends javax.swing.JFrame {
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        blackPanel = new javax.swing.JPanel();
        blackPlayerLabel = new javax.swing.JLabel();
        blackPointLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        blackRatingLabel = new javax.swing.JLabel();
        whitePanel = new javax.swing.JPanel();
        whitePlayerLabel = new javax.swing.JLabel();
        whitePointLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        whiteRatingLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        blackPlayerLabel.setText("jLabel1");

        blackPointLabel.setText("0");

        jLabel1.setText("Rating:");

        blackRatingLabel.setText("jLabel2");

        javax.swing.GroupLayout blackPanelLayout = new javax.swing.GroupLayout(blackPanel);
        blackPanel.setLayout(blackPanelLayout);
        blackPanelLayout.setHorizontalGroup(
            blackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blackPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(blackPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(blackPointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blackRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        blackPanelLayout.setVerticalGroup(
            blackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(blackPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(blackPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blackPlayerLabel)
                    .addComponent(blackPointLabel)
                    .addComponent(jLabel1)
                    .addComponent(blackRatingLabel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        whitePlayerLabel.setText("jLabel2");

        whitePointLabel.setText("0");

        jLabel2.setText("Rating:");

        whiteRatingLabel.setText("jLabel3");

        javax.swing.GroupLayout whitePanelLayout = new javax.swing.GroupLayout(whitePanel);
        whitePanel.setLayout(whitePanelLayout);
        whitePanelLayout.setHorizontalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(whitePlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(whitePointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whiteRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        whitePanelLayout.setVerticalGroup(
            whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(whitePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(whitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(whitePlayerLabel)
                    .addComponent(whitePointLabel)
                    .addComponent(jLabel2)
                    .addComponent(whiteRatingLabel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        exitButton.setText("EXIT");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(whitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(blackPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(blackPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        PlayerGames playerGames1 = new PlayerGames(save,player1.getUserName(),player1.getTime(),Character.toString(player1.getColour()));
        PlayerGames playerGames2 = new PlayerGames(save,player2.getUserName(),player2.getTime(),Character.toString(player2.getColour()));
        String fenString = chessBoard.convertBoardToFen();
        gamePanel.setVisible(false);
        frame.setVisible(false);
        Run.runEndGame(playerGames1, playerGames2, gameFormat,chessBoard.currentPlayer.getColour(),incrementTime,fenString);
    }//GEN-LAST:event_exitButtonActionPerformed

    JFrame gameFinish = new JFrame("CheckMate");
    JButton squares[][] = new JButton[8][8];
    private int position = -1;
    private boolean pieceToMove = false;
    private boolean gameOver = false;
    private Board chessBoard;
    private ImageIcon kingWhite = new ImageIcon("kingWhite.png");
    private ImageIcon kingBlack = new ImageIcon("kingBlack.png");
    private ImageIcon queenWhite = new ImageIcon("queenWhite.png");
    private ImageIcon queenBlack = new ImageIcon("queenBlack.png");
    private ImageIcon rookWhite = new ImageIcon("rookWhite.png");
    private ImageIcon rookBlack = new ImageIcon("rookBlack.png");
    private ImageIcon knightWhite = new ImageIcon("knightWhite.png");
    private ImageIcon knightBlack = new ImageIcon("knightBlack.png");
    private ImageIcon bishopWhite = new ImageIcon("bishopWhite.png");
    private ImageIcon bishopBlack = new ImageIcon("bishopBlack.png");
    private ImageIcon pawnWhite = new ImageIcon("pawnWhite.png");
    private ImageIcon pawnBlack = new ImageIcon("pawnBlack.png");
    boolean aiGame;
    Player player1;
    Player player2;
    String save;
    int attempt = 0;
    boolean aiMove = false;
    private final int aiSearchDepth;
    private final String gameFormat;
    public JPanel gamePanel = new JPanel();
    public JFrame frame = new JFrame();
    Boolean incrementTime;

    public GameBoard(String startingPosition, boolean aiGame, Player player1, Player player2, int aiSearchDepth, char whoseMove, String gameFormat, boolean incrementTime) {
        this.player1 = player1;
        this.player2 = player2;
        this.save = startingPosition;
        this.chessBoard = new Board();
        this.chessBoard.setUpBoard(startingPosition, player1, player2);
        this.aiGame = aiGame;
        this.aiSearchDepth = aiSearchDepth;
        chessBoard.currentPlayer = (player1.getColour() == whoseMove)? player1:player2;
        this.gameFormat = gameFormat;
        this.incrementTime = incrementTime;
        initComponents();
    }
    
    public void runGameBoard() {
        frame.add(whitePanel);
        frame.add(blackPanel);
        frame.add(buttonPanel);
        main.frame.add(gamePanel);
        whitePanel.setVisible(true);
        blackPanel.setVisible(true);
        buttonPanel.setVisible(true);
        gamePanel.setVisible(true);
        frame.setSize(300, 200);
        frame.setVisible(true);
        gamePanel.setLayout(new GridLayout(8, 8));
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
                gamePanel.add(squares[rank][file]);
                squares[rank][file].setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100)); //sets border of square to be highlighted when selected, line thickness proportional to size of window
                squares[rank][file].setBorderPainted(false);
            }
        }
        setUpGUIBoard(chessBoard);
        main.frame.add(gamePanel);
        createActionButtonsForRestOfBoard();  //creates action for every other square
        gamePanel.setVisible(true);
        buttonPanel.setVisible(true);
        blackPanel.setVisible(true);
        whitePanel.setVisible(true);
        if (player1.getColour() == 'W') {
            whitePlayerLabel.setText(player1.getUserName());
            whiteRatingLabel.setText(String.valueOf(player1.getRating()));
            blackPlayerLabel.setText(player2.getUserName());
            blackRatingLabel.setText(String.valueOf(player2.getRating()));
        }else{
            whitePlayerLabel.setText(player2.getUserName());
            whiteRatingLabel.setText(String.valueOf(player2.getRating()));
            blackPlayerLabel.setText(player1.getUserName());
            blackRatingLabel.setText(String.valueOf(player1.getRating()));
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
    
    private void sqClicked(java.awt.event.ActionEvent evt, int rank, int file){
        if (!aiMove) {
            sqClicked(rank,file);
        }
    }
    
    private void sqClicked(int rank, int file){
        if (!pieceToMove) { //checks if player is selecting a piece to move or a square to move to
            position = (rank*8)+file; //calc position of piece to move
            pieceToMove = true;
            squares[rank][file].setBorderPainted(true); //higlights the border of square
            return;
        }
        int ogFile = position%8; //calcs initial file
        int ogRank = position/8; //calcs initial rank
        Move move = new Move(ogRank, ogFile);
        move.setOgPosition(position);
        squares[move.getOgRank()][move.getOgFile()].setBorderPainted(false); // unselects the original square
        pieceToMove = false;
        position = (rank*8)+file;
        move.setFinalRank(rank);
        move.setFinalFile(file);
        move.setFinalPosition();
        playMove(move);
        if (aiMove == true) {
            makeAIMove();
        }
    }
    private boolean playMove(Move move){
        if (chessBoard.moveToSq(move,player1,player2)) { //checks if it is a valid move
            
            removeGUIPiece(move.getMovingPiece(),move.getOgRank(),move.getOgFile());
            addGUIPiece(move.getMovingPiece(),move.getFinalRank(),move.getFinalFile());
//            for (int j = 0; j < 8; j++) { // meant to promote pawn to queen
//                System.out.println(j);
//                System.out.println(chessBoard.getPiece(0, j).getType());
//                System.out.println(chessBoard.getPiece(7, j).getType());
//                if (chessBoard.getPiece(0, j).getType() == 'p') {
//                    removeGUIPiece(chessBoard.getPiece(0, j), 0, j);
//                    chessBoard.setPiece(0, j, new Queen(0,j,'W'), player1, player2);
//                    addGUIPiece(chessBoard.getPiece(0, j), 0, j);
//                }if (chessBoard.getPiece(7, j).getType() == 'p') {
//                    removeGUIPiece(chessBoard.getPiece(7, j), 0, j);
//                    chessBoard.setPiece(0, j, new Queen(7,j,'W'), player1, player2);
//                    addGUIPiece(chessBoard.getPiece(7, j), 7, j);
//                }
//                for (int k = 0; k < chessBoard.piecesInPlay.size(); k++) {
//                    chessBoard.piecesInPlay.get(k).setMovementSq(chessBoard.piecesInPlay);
//                }
//            }
            chessBoard.currentPlayer = (chessBoard.currentPlayer == player1)? player2:player1; //switchs whose turn it is
            System.out.println(chessBoard.isCheckmate());
            if (chessBoard.isCheckmate()) { //checks if game is over due to checkmate
                System.out.println(chessBoard.isCheckmate());
                gameOver = true;
                endGame();
            }
            if (aiGame) {
                aiMove = (chessBoard.currentPlayer.getUserName().equalsIgnoreCase("AI"))? true:false;
            }gameFinish.setVisible(gameOver);
            return true;
        }else{
            return false;
        }
        
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
    
    private void makeAIMove(){
        Move aiMove;
        attempt++;
        if ((chessBoard.getPiece(6, 4).getType() != 'p') && (attempt <= 1)) {
            aiMove = new Move();
            aiMove.setOgRank(1);
            aiMove.setOgFile(4);
            aiMove.setOgPosition();
            aiMove.setMovingPiece(chessBoard.getPiece(1, 4));
            aiMove.setFinalRank(3);
            aiMove.setFinalFile(4);
            aiMove.setFinalPosition();
            aiMove.setReplacedPiece(chessBoard.getPiece(3, 4));
        }else{
           if (player1.getUserName().equalsIgnoreCase("AI")) {
                MiniMax ai = new MiniMax(player1, player2, aiSearchDepth);
                aiMove = ai.execute(chessBoard);
            }else {
                MiniMax ai = new MiniMax(player1, player2, aiSearchDepth);
                aiMove = ai.execute(chessBoard);
            } 
        }
        playMove(aiMove);

    }
    
    private void endGame(){
        whitePanel.setVisible(false);
        blackPanel.setVisible(false);
        gamePanel.setVisible(false);
        buttonPanel.setVisible(false);
        JLabel gameOver = new JLabel("Game Over");
        String sql = "SELECT Logins.* FROM Logins";
        
        if (chessBoard.currentPlayer.equals(player1)) {
            player1.setRating(player1.getRating()-ratingChange(player1.getRating(),player2.getRating(),false));
            player2.setRating(player2.getRating()+ratingChange(player2.getRating(),player1.getRating(),true));
            repository.updateWinsLossesDraws(sql,"Losses", player1.getUserName(), 1, "Email");
            repository.updateWinsLossesDraws(sql, "Wins", player2.getUserName(), 1, "Email");
        }else{
            player1.setRating(player1.getRating()+ratingChange(player1.getRating(),player2.getRating(),true));
            player2.setRating(player2.getRating()-ratingChange(player2.getRating(),player1.getRating(),false));
            repository.updateWinsLossesDraws(sql,"Wins", player1.getUserName(), 1, "Email");
            repository.updateWinsLossesDraws(sql, "Losses", player2.getUserName(), 1, "Email");
        }
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='"+save+"' AND PlayerGames.Email='"+player1.getUserName()+"'");
        repository.deleteRecord("delete from Games where Games.Save='"+save+"'");
        if (gameFormat.equals("Blitz")) {
            repository.updateInt(sql, "BlitzRating", player1.getUserName(), player1.getRating(), "Email");
            repository.updateInt(sql, "BlitzRating", player2.getUserName(), player2.getRating(), "Email");
        }else if (gameFormat.equals("Rapid")) {
            repository.updateInt(sql, "RapidRating", player1.getUserName(), player1.getRating(), "Email");
            repository.updateInt(sql, "RapidRating", player2.getUserName(), player2.getRating(), "Email");
        }else {
            repository.updateInt(sql, "ClassicalRating", player1.getUserName(), player1.getRating(), "Email");
            repository.updateInt(sql, "ClassicalRating", player2.getUserName(), player2.getRating(), "Email");
        }
        try {
            String fullDir = System.getProperty("user.dir")+"\\Save1.txt";
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println("");
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
        }
        Run.runMainMenu();
        Run.destroyObject(9);
    }
    
    private static int ratingChange(int playerRating, int opponentRating, boolean win){
        if (win) {
            if (playerRating > opponentRating) {
                return (19/(playerRating-opponentRating))+1;
            }else if (playerRating == opponentRating){
                return 20;
            }else return ((opponentRating - playerRating)/4)+25;
        }else{
            if (playerRating < opponentRating) {
                return (19/(opponentRating-playerRating))+1;
            }else if (playerRating == opponentRating){
                return 20;
            }else return ((playerRating - opponentRating)/4)+25;
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blackPanel;
    private javax.swing.JLabel blackPlayerLabel;
    private javax.swing.JLabel blackPointLabel;
    private javax.swing.JLabel blackRatingLabel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel whitePanel;
    private javax.swing.JLabel whitePlayerLabel;
    private javax.swing.JLabel whitePointLabel;
    private javax.swing.JLabel whiteRatingLabel;
    // End of variables declaration//GEN-END:variables
}
