package GUI;

import Backend.Game;
import Backend.PlayerGames;
import Backend.Run;
import Main.main;
import java.io.FileWriter;
import java.io.PrintWriter;
import libraryFunctions.repository;

public class EndGame extends javax.swing.JPanel {
    private PlayerGames playerGames1, playerGames2;
    private String gameFormat;
    private String whoseMove;
    private boolean incrementTime;
    String fenString;
    String fullDir;
    
    public EndGame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        save1Button = new javax.swing.JButton();
        noSaveButton = new javax.swing.JButton();
        save2Button = new javax.swing.JButton();
        save3Button = new javax.swing.JButton();
        save4Button = new javax.swing.JButton();
        save5Button = new javax.swing.JButton();

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        save1Button.setText("Save1");
        save1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save1ButtonActionPerformed(evt);
            }
        });

        noSaveButton.setText("Don't Save");
        noSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noSaveButtonActionPerformed(evt);
            }
        });

        save2Button.setText("Save2");
        save2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save2ButtonActionPerformed(evt);
            }
        });

        save3Button.setText("Save3");
        save3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save3ButtonActionPerformed(evt);
            }
        });

        save4Button.setText("Save4");
        save4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save4ButtonActionPerformed(evt);
            }
        });

        save5Button.setText("Save5");
        save5Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save5ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(noSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addGap(73, 73, 73))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(save3Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save1Button, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(save2Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save4Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(save5Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(noSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(save1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save4Button, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(save5Button, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void runEndGame(PlayerGames playerGames1, PlayerGames playerGames2, String gameFormat, char whoseMove, boolean incrementTime, String fenString){
        this.playerGames1 = playerGames1;
        this.playerGames2 = playerGames2;
        this.gameFormat = gameFormat;
        this.whoseMove = Character.toString(whoseMove);
        this.incrementTime = incrementTime;
        this.fenString = fenString;
        main.frame.add(panel);
        panel.add(save1Button);
        panel.add(save2Button);
        panel.add(save3Button);
        panel.add(save4Button);
        panel.add(save5Button);
        panel.add(backButton);
        panel.add(noSaveButton);
        panel.setVisible(true);
    }
    private void noSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noSaveButtonActionPerformed
        panel.setVisible(false);
        Run.runMainMenu();
        Run.destroyObject(9);
        Run.destroyObject(11);
    }//GEN-LAST:event_noSaveButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        panel.setVisible(false);
        Run.unHideGameBoard();
        Run.destroyObject(11);
    }//GEN-LAST:event_backButtonActionPerformed

    private void save1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save1ButtonActionPerformed
        fullDir = System.getProperty("user.dir")+"\\Save1.txt";
        playerGames1.setSave("Save1");
        playerGames2.setSave("Save1");
        Game newGame = new Game("Save1",gameFormat,incrementTime,whoseMove);
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save1' AND PlayerGames.Email='"+playerGames1.getEmail()+"'");
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save1' AND PlayerGames.Email='"+playerGames2.getEmail()+"'");
        repository.deleteRecord("delete from Games where Games.Save='Save1'");
        repository.addGameToDataBase(newGame);
        
        repository.addPlayerGameToDataBase(playerGames1);
        
        repository.addPlayerGameToDataBase(playerGames2);
        System.out.println(fenString);
        try {
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(fenString);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        panel.setVisible(false);
        Run.destroyObject(9);
        Run.runMainMenu();
        Run.destroyObject(11);
    }//GEN-LAST:event_save1ButtonActionPerformed

    private void save2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save2ButtonActionPerformed
        fullDir = System.getProperty("user.dir")+"\\Save2.txt";
        playerGames1.setSave("Save2");
        playerGames2.setSave("Save2");
        Game newGame = new Game("Save2",gameFormat,incrementTime,whoseMove);
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save2' AND PlayerGames.Email='"+playerGames1.getEmail()+"'");
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save2' AND PlayerGames.Email='"+playerGames2.getEmail()+"'");
        repository.deleteRecord("delete from Games where Games.Save='Save2'");
        repository.addGameToDataBase(newGame);
        
        repository.addPlayerGameToDataBase(playerGames1);
        
        repository.addPlayerGameToDataBase(playerGames2);
        System.out.println(fenString);
        try {
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(fenString);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        panel.setVisible(false);
        Run.destroyObject(9);
        Run.runMainMenu();
        Run.destroyObject(11);
    }//GEN-LAST:event_save2ButtonActionPerformed

    private void save3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save3ButtonActionPerformed
        fullDir = System.getProperty("user.dir")+"\\Save1.txt";
        playerGames1.setSave("Save3");
        playerGames2.setSave("Save3");
        Game newGame = new Game("Save3",gameFormat,incrementTime,whoseMove);
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save3' AND PlayerGames.Email='"+playerGames1.getEmail()+"'");
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save3' AND PlayerGames.Email='"+playerGames2.getEmail()+"'");
        repository.deleteRecord("delete from Games where Games.Save='Save3'");
        repository.addGameToDataBase(newGame);
        
        repository.addPlayerGameToDataBase(playerGames1);
        
        repository.addPlayerGameToDataBase(playerGames2);
        System.out.println(fenString);
        try {
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(fenString);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        panel.setVisible(false);
        Run.destroyObject(9);
        Run.runMainMenu();
        Run.destroyObject(11);
    }//GEN-LAST:event_save3ButtonActionPerformed

    private void save4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save4ButtonActionPerformed
        fullDir = System.getProperty("user.dir")+"\\Save1.txt";
        playerGames1.setSave("Save4");
        playerGames2.setSave("Save4");
        Game newGame = new Game("Save4",gameFormat,incrementTime,whoseMove);
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save4' AND PlayerGames.Email='"+playerGames1.getEmail()+"'");
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save4' AND PlayerGames.Email='"+playerGames2.getEmail()+"'");
        repository.deleteRecord("delete from Games where Games.Save='Save4'");
        repository.addGameToDataBase(newGame);
        
        repository.addPlayerGameToDataBase(playerGames1);
        
        repository.addPlayerGameToDataBase(playerGames2);
        System.out.println(fenString);
        try {
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(fenString);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        panel.setVisible(false);
        Run.destroyObject(9);
        Run.runMainMenu();
        Run.destroyObject(11);
    }//GEN-LAST:event_save4ButtonActionPerformed

    private void save5ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save5ButtonActionPerformed
        fullDir = System.getProperty("user.dir")+"\\Save1.txt";
        playerGames1.setSave("Save5");
        playerGames2.setSave("Save5");
        Game newGame = new Game("Save5",gameFormat,incrementTime,whoseMove);
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save5' AND PlayerGames.Email='"+playerGames1.getEmail()+"'");
        repository.deleteRecord("delete from PlayerGames where PlayerGames.Save='Save5' AND PlayerGames.Email='"+playerGames2.getEmail()+"'");
        repository.deleteRecord("delete from Games where Games.Save='Save5'");
        repository.addGameToDataBase(newGame);
        
        repository.addPlayerGameToDataBase(playerGames1);
        
        repository.addPlayerGameToDataBase(playerGames2);
        System.out.println(fenString);
        try {
            PrintWriter writer = new PrintWriter(fullDir);
            writer.print("");
            // other operations
            writer.close();
            FileWriter writeToFile = new FileWriter(fullDir,true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(fenString);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        panel.setVisible(false);
        Run.destroyObject(9);
        Run.runMainMenu();
        Run.destroyObject(11);
    }//GEN-LAST:event_save5ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton noSaveButton;
    private javax.swing.JPanel panel;
    private javax.swing.JButton save1Button;
    private javax.swing.JButton save2Button;
    private javax.swing.JButton save3Button;
    private javax.swing.JButton save4Button;
    private javax.swing.JButton save5Button;
    // End of variables declaration//GEN-END:variables
}
