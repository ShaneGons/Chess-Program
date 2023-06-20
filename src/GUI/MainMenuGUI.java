package GUI;
import java.awt.event.ActionEvent;
import javax.swing.*;
import Backend.*;
import Main.main;
public class MainMenuGUI extends javax.swing.JFrame {
    public MainMenuGUI() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private JButton leaderBoard;
    private JButton twoPlayerGame;
    private JButton AIGame;
    private JButton accountDetails;
    private JButton backButton;
    private JPanel mainMenuPanel;
    
    public void runMainMenuGUI() {
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(null);
        main.frame.add(mainMenuPanel);
        leaderBoard = new JButton("Leaderboard");
        leaderBoard.setBounds(10, 20, 150, 25);
        leaderBoard.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                MainMenu.makeChoice(0);
            }
        });
        mainMenuPanel.add(leaderBoard);
        
        twoPlayerGame = new JButton("Pass and Play");
        twoPlayerGame.setBounds(10, 50, 150, 25);
        twoPlayerGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                MainMenu.makeChoice(1);
            }
        });
        mainMenuPanel.add(twoPlayerGame);
        
        AIGame = new JButton("AI Game");
        AIGame.setBounds(10, 80, 150, 25);
        AIGame.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                MainMenu.makeChoice(2);
            }
        });
        mainMenuPanel.add(AIGame);
        
        accountDetails = new JButton("Account Details");
        accountDetails.setBounds(10, 110, 150, 25);
        accountDetails.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                MainMenu.makeChoice(3);
            }
        });
        mainMenuPanel.add(accountDetails);
        
        backButton = new JButton("Back");
        backButton.setBounds(10, 140, 150, 25);
        accountDetails.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainMenuPanel.setVisible(false);
                Run.runLoginScreen(0, main.currentAccount);
                Run.destroyObject(2);
            }
        });
        mainMenuPanel.add(backButton);
        
        mainMenuPanel.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
