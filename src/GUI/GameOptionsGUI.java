package GUI;
import Backend.Game;
import Backend.PlayerGames;
import Backend.Run;
import Main.main;
import Backend.userAccount;
import Game.Player;
import java.awt.Color;
import java.util.LinkedList;
import javax.swing.*;
import libraryFunctions.repository;

public class GameOptionsGUI extends javax.swing.JFrame {
    private String gameChoice;
    private userAccount secondPlayer;
    private int player1Time;
    private int player2Time;
    private boolean aiGame;
    private String gameMode = "Blitz";
    private final int aiSearchDepth;
    private boolean incrementTime = true;
    private char whoseMove = 'W';
    
    public GameOptionsGUI(String gameChoice, userAccount secondPlayer, PlayerGames player1, PlayerGames player2, boolean aiGame, int aiSearchDepth) {
        this.gameChoice = gameChoice;
        this.secondPlayer = secondPlayer;
        this.aiGame = aiGame;
        this.aiSearchDepth = aiSearchDepth;
        initComponents();
        
    }
    
    public void runGameOptions() {
        main.frame.add(panel);
        playerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {main.currentAccount.getEmail(),secondPlayer.getEmail()}));
        blitzButton1.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        classicalButton.setBorderPainted(false);
        
        if (!gameChoice.equalsIgnoreCase("NewGame")) {
            blitzLabel.setVisible(false);
            panel.remove(blitzButton1);
            panel.remove(blitzButton2);
            rapidLabel.setVisible(false);
            panel.remove(rapidButton1);
            rapidButton2.setVisible(false);
            rapidButton3.setVisible(false);
            classicalLabel.setVisible(false);
            panel.remove(classicalButton);
            incrementLabel.setVisible(false);
            panel.remove(incrementToggle);
        }
        panel.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        nextButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        blitzLabel = new javax.swing.JLabel();
        blitzButton1 = new javax.swing.JButton();
        blitzButton2 = new javax.swing.JButton();
        rapidLabel = new javax.swing.JLabel();
        rapidButton1 = new javax.swing.JButton();
        rapidButton2 = new javax.swing.JButton();
        rapidButton3 = new javax.swing.JButton();
        incrementLabel = new javax.swing.JLabel();
        incrementToggle = new javax.swing.JToggleButton();
        playerComboBox = new javax.swing.JComboBox<>();
        whiteLabel = new javax.swing.JLabel();
        classicalLabel = new javax.swing.JLabel();
        classicalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        blitzLabel.setText("Blitz");

        blitzButton1.setText("1 Minute");
        blitzButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blitzButton1ActionPerformed(evt);
            }
        });

        blitzButton2.setText("5 Minutes");
        blitzButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blitzButton2ActionPerformed(evt);
            }
        });

        rapidLabel.setText("Rapid");

        rapidButton1.setText("10 Minutes");
        rapidButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapidButton1ActionPerformed(evt);
            }
        });

        rapidButton2.setText("15 Minutes");
        rapidButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapidButton2ActionPerformed(evt);
            }
        });

        rapidButton3.setText("30 Minutes");
        rapidButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rapidButton3ActionPerformed(evt);
            }
        });

        incrementLabel.setText("Increment Time?");

        incrementToggle.setText("Yes");
        incrementToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                incrementToggleActionPerformed(evt);
            }
        });

        playerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        playerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerComboBoxActionPerformed(evt);
            }
        });

        whiteLabel.setText("Who is White?");

        classicalLabel.setText("Classical");

        classicalButton.setText("No Time Limit");
        classicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classicalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(classicalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rapidLabel)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rapidButton1)
                                .addGap(18, 18, 18)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(classicalButton)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(rapidButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(rapidButton3)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addComponent(blitzLabel)
                        .addGap(38, 373, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton)
                        .addGap(36, 36, 36))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(whiteLabel))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(blitzButton1)
                        .addGap(18, 18, 18)
                        .addComponent(blitzButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incrementLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(incrementToggle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(blitzLabel)
                        .addGap(12, 12, 12)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(blitzButton1)
                            .addComponent(blitzButton2))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(incrementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(incrementToggle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(rapidLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rapidButton1)
                    .addComponent(rapidButton2)
                    .addComponent(rapidButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(whiteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classicalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(classicalButton)
                .addGap(37, 37, 37)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(backButton))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        panel.setVisible(false);
        Run.runSavedGamesGUI(secondPlayer, aiGame, aiSearchDepth);
        Run.destroyObject(7);
    }//GEN-LAST:event_backButtonActionPerformed

    private void incrementToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_incrementToggleActionPerformed
        if (incrementToggle.getText().equalsIgnoreCase("Yes")) {
            incrementToggle.setText("No");
            incrementTime = false;
        }else {
            incrementToggle.setText("Yes");
            incrementTime = true;
        }
    }//GEN-LAST:event_incrementToggleActionPerformed

    private void blitzButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blitzButton1ActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        blitzButton1.setBorderPainted(true);
        player1Time = 1;
        player2Time = 1;
        gameMode = "Blitz";
    }//GEN-LAST:event_blitzButton1ActionPerformed

    private void blitzButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blitzButton2ActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        blitzButton2.setBorderPainted(true);
        player1Time = 5;
        player2Time = 5;
        gameMode = "Blitz";
    }//GEN-LAST:event_blitzButton2ActionPerformed

    private void rapidButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapidButton1ActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        rapidButton1.setBorderPainted(true);
        player1Time = 10;
        player2Time = 10;
        gameMode = "Rapid";
    }//GEN-LAST:event_rapidButton1ActionPerformed

    private void rapidButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapidButton2ActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        rapidButton2.setBorderPainted(true);
        player1Time = 15;
        player2Time = 15;
        gameMode = "Rapid";
    }//GEN-LAST:event_rapidButton2ActionPerformed

    private void rapidButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rapidButton3ActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        rapidButton3.setBorderPainted(true);
        player1Time = 30;
        player2Time = 30;
        gameMode = "Rapid";
    }//GEN-LAST:event_rapidButton3ActionPerformed

    private void classicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classicalButtonActionPerformed
        blitzButton1.setBorderPainted(false);
        blitzButton2.setBorderPainted(false);
        rapidButton1.setBorderPainted(false);
        rapidButton2.setBorderPainted(false);
        rapidButton3.setBorderPainted(false);
        classicalButton.setBorderPainted(false);
        
        classicalButton.setBorderPainted(true);
        player1Time = -1;
        player2Time = -1;
        gameMode = "Classical";
    }//GEN-LAST:event_classicalButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        char player1Colour, player2Colour;
        Player player1, player2;
        if (playerComboBox.getSelectedItem().equals(main.currentAccount.getEmail())) {
            player1Colour = 'W';
            player2Colour = 'B';
        }else{
            player1Colour = 'B';
            player2Colour = 'W';
        }
        
        if (gameMode.equals("Blitz")) {
            player1 = new Player(main.currentAccount.getEmail(), player1Colour, main.currentAccount.getBlitzRating());
            player2 = new Player(secondPlayer.getEmail(), player2Colour, secondPlayer.getBlitzRating());
        }else if (gameMode.equals("Rapid")) {
            player1 = new Player(main.currentAccount.getEmail(), player1Colour, main.currentAccount.getBlitzRating());
            player2 = new Player(secondPlayer.getEmail(), player2Colour, secondPlayer.getBlitzRating());
        }else{
            player1 = new Player(main.currentAccount.getEmail(), player1Colour, main.currentAccount.getBlitzRating());
            player2 = new Player(secondPlayer.getEmail(), player2Colour, secondPlayer.getBlitzRating());
        }if (!(gameChoice.equals("NewGame"))) {
            LinkedList<PlayerGames> playerGames = repository.getPlayerGame(gameChoice);
            if (player1.getColour() == playerGames.get(0).getWhoseMove().charAt(0)) {
                player1.setTime(playerGames.get(0).getTime());
                player2.setTime(playerGames.get(1).getTime());
            }else{
                player1.setTime(playerGames.get(1).getTime());
                player2.setTime(playerGames.get(0).getTime());
            }
            LinkedList<Game> games = repository.getSavedGames();
            for (int i = 0; i < games.size(); i++) {
                if (games.get(i).getSave().equals(gameChoice)) {
                    whoseMove = games.get(i).getWhoseMove();
                    gameMode = games.get(i).getGameFormat();
                    incrementTime = games.get(i).isIncrementTime();
                }
            }
        }
        panel.setVisible(false);
        Run.runGameBoard(gameChoice, aiGame, player1, player2, aiSearchDepth, whoseMove, gameMode,incrementTime);
        Run.destroyObject(7);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void playerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_playerComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton blitzButton1;
    private javax.swing.JButton blitzButton2;
    private javax.swing.JLabel blitzLabel;
    private javax.swing.JButton classicalButton;
    private javax.swing.JLabel classicalLabel;
    private javax.swing.JLabel incrementLabel;
    private javax.swing.JToggleButton incrementToggle;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel panel;
    private javax.swing.JComboBox<String> playerComboBox;
    private javax.swing.JButton rapidButton1;
    private javax.swing.JButton rapidButton2;
    private javax.swing.JButton rapidButton3;
    private javax.swing.JLabel rapidLabel;
    private javax.swing.JLabel whiteLabel;
    // End of variables declaration//GEN-END:variables
}
