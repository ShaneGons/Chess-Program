package GUI;
import java.io.BufferedReader;
import java.io.FileReader;
import Backend.*;
import Main.main;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.BorderFactory;
import libraryFunctions.repository;
public class SavedGamesGUI extends javax.swing.JFrame {
    private String gameChoice = "NewGame";
    private userAccount secondAccount;
    private PlayerGames player1;
    private PlayerGames player2;
    private boolean aiGame;
    private int aiSearchDepth;
    
    public SavedGamesGUI(userAccount secondAccount, boolean aiGame, int aiSearchDepth) {
        this.secondAccount = secondAccount;
        this.aiGame = aiGame;
        this.aiSearchDepth = aiSearchDepth;
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        newGameButton = new javax.swing.JButton();
        save1Button = new javax.swing.JButton();
        save2Button = new javax.swing.JButton();
        save3Button = new javax.swing.JButton();
        save4Button = new javax.swing.JButton();
        save5Button = new javax.swing.JButton();
        save1Label = new javax.swing.JLabel();
        save2Label = new javax.swing.JLabel();
        save3Label = new javax.swing.JLabel();
        save4Label = new javax.swing.JLabel();
        save5Label = new javax.swing.JLabel();
        newGameLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newGameButton.setText("NewGame");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        save1Button.setText("No Save");
        save1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ButtonActionPerformed(evt);
            }
        });

        save2Button.setText("No Save");
        save2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ButtonActionPerformed(evt);
            }
        });

        save3Button.setText("No Save");
        save3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ButtonActionPerformed(evt);
            }
        });

        save4Button.setText("No Save");
        save4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save4ButtonActionPerformed(evt);
            }
        });

        save5Button.setText("No Save");
        save5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save5ButtonActionPerformed(evt);
            }
        });

        save1Label.setText("No Save");

        save2Label.setText("No Save");

        save3Label.setText("No Save");

        save4Label.setText("No Save");

        save5Label.setText("No Save");

        newGameLabel.setText("       New Game");

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(save4Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save1Button, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(save4Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(save5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(save2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(save2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(save5Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newGameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save3Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save3Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newGameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(save2Button, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                        .addComponent(save3Button, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                    .addComponent(save1Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save2Label)
                    .addComponent(save1Label)
                    .addComponent(save3Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save4Button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newGameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(save5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save4Label)
                    .addComponent(save5Label)
                    .addComponent(newGameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(nextButton))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void runSavedGames(){
        save1Button.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        save1Button.setBorderPainted(false);
        save2Button.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        save2Button.setBorderPainted(false);
        save3Button.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        save3Button.setBorderPainted(false);
        save4Button.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        save4Button.setBorderPainted(false);
        save5Button.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        save5Button.setBorderPainted(false);
        newGameButton.setBorder(BorderFactory.createLineBorder(Color.yellow, main.frame.getHeight()/100));
        newGameButton.setBorderPainted(false);
        Main.main.frame.add(jPanel1);
        Main.main.frame.add(jPanel2);
        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        try {
            LinkedList<Game> games = repository.getSavedGames();
            if (games.size()>0) {
                String startingPosition = System.getProperty("user.dir")+"\\"+games.get(0).getSave()+".txt"; //gets the contents from file in specified location
                String fenPosition = "";
                try {
                    BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
                    fenPosition = read.readLine(); //the first line of the file is turned into the fen position
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
                save1Button.setText(fenPosition);
                save1Label.setText(games.get(0).getGameFormat());
            }if (games.size()>1) {
                String startingPosition = System.getProperty("user.dir")+"\\"+games.get(0).getSave()+".txt"; //gets the contents from file in specified location
                String fenPosition = "";
                try {
                    BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
                    fenPosition = read.readLine(); //the first line of the file is turned into the fen position
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
                save1Button.setText(fenPosition);
                save2Label.setText(games.get(1).getGameFormat());
            }if (games.size()>2) {
                String startingPosition = System.getProperty("user.dir")+"\\"+games.get(0).getSave()+".txt"; //gets the contents from file in specified location
                String fenPosition = "";
                try {
                    BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
                    fenPosition = read.readLine(); //the first line of the file is turned into the fen position
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
                save1Button.setText(fenPosition);
                save3Label.setText(games.get(2).getGameFormat());
            }if (games.size()>3) {
                String startingPosition = System.getProperty("user.dir")+"\\"+games.get(0).getSave()+".txt"; //gets the contents from file in specified location
                String fenPosition = "";
                try {
                    BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
                    fenPosition = read.readLine(); //the first line of the file is turned into the fen position
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
                save1Button.setText(fenPosition);
                save4Label.setText(games.get(3).getGameFormat());
            }if (games.size()>4) {
                String startingPosition = System.getProperty("user.dir")+"\\"+games.get(0).getSave()+".txt"; //gets the contents from file in specified location
                String fenPosition = "";
                try {
                    BufferedReader read = new BufferedReader(new FileReader(startingPosition)); //reads the first line of the code
                    fenPosition = read.readLine(); //the first line of the file is turned into the fen position
                } catch (Exception e) {
                    System.out.println("Exception: "+e);
                }
                save1Button.setText(fenPosition);
                save5Label.setText(games.get(4).getGameFormat());
            }
        } catch (Exception e) {
            System.out.println(e+" in runSavedGames method");
        }
        
    }
    
    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "NewGame";
        newGameButton.setBorderPainted(true);
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void save1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "Save1";
        save1Button.setBorderPainted(true);
    }//GEN-LAST:event_save1ButtonActionPerformed

    private void save2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "Save2";
        save2Button.setBorderPainted(true);
    }//GEN-LAST:event_save2ButtonActionPerformed

    private void save3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "Save3";
        save3Button.setBorderPainted(true);
    }//GEN-LAST:event_save3ButtonActionPerformed

    private void save4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save4ButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "Save4";
        save4Button.setBorderPainted(true);
    }//GEN-LAST:event_save4ButtonActionPerformed

    private void save5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save5ButtonActionPerformed
        newGameButton.setBorderPainted(false);
        save1Button.setBorderPainted(false);
        save2Button.setBorderPainted(false);
        save3Button.setBorderPainted(false);
        save4Button.setBorderPainted(false);
        save5Button.setBorderPainted(false);
        
        gameChoice = "Save5";
        save5Button.setBorderPainted(true);
    }//GEN-LAST:event_save5ButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        LinkedList<PlayerGames> players = repository.getPlayerGame(gameChoice);
        players.add(null);
        players.add(null);
        if (players.get(0) == null) {
            gameChoice = "NewGame";
        }
        Run.runGameOptions(gameChoice, secondAccount, players.get(0), players.get(1), aiGame, aiSearchDepth);
        Run.destroyObject(6);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        jPanel1.setVisible(false);
        jPanel2.setVisible(false);
        Run.runMainMenu();
        Run.destroyObject(6);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JButton newGameButton;
    private javax.swing.JLabel newGameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton save1Button;
    private javax.swing.JLabel save1Label;
    private javax.swing.JButton save2Button;
    private javax.swing.JLabel save2Label;
    private javax.swing.JButton save3Button;
    private javax.swing.JLabel save3Label;
    private javax.swing.JButton save4Button;
    private javax.swing.JLabel save4Label;
    private javax.swing.JButton save5Button;
    private javax.swing.JLabel save5Label;
    // End of variables declaration//GEN-END:variables
}
