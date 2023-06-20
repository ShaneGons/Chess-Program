package GUI;
import Backend.Run;
import java.awt.event.ActionEvent;
import libraryFunctions.repository;
import javax.swing.*;
import Main.main;

public class ViewDetailsGUI extends javax.swing.JFrame {
    public ViewDetailsGUI() {
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

    private JButton viewDetailsButton;
    private JButton changeDetailsButton;
    private JButton backButton;
    
    public void AccountInfo(){
        JPanel accountPanel = new JPanel();
        main.frame.add(accountPanel);
        
        viewDetailsButton = new JButton("View Account Details");
        viewDetailsButton.setBounds(10, 20, 150, 25);
        viewDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountPanel.setVisible(false);
                showDetails();
            }
        });
        accountPanel.add(viewDetailsButton);
        
        changeDetailsButton = new JButton("Change account details");
        changeDetailsButton.setBounds(10, 50, 150, 25);
        changeDetailsButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountPanel.setVisible(false);
                Run.runChangeDetails();
                Run.destroyObject(4);
            }
        });
        accountPanel.add(changeDetailsButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(80, 30, 110, 25);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountPanel.setVisible(false);
                Run.runMainMenu();
                Run.destroyObject(4);
            }
        });
        accountPanel.add(backButton);
        
        accountPanel.setVisible(true);
    }
    
    private void showDetails(){
        try {
            JPanel showDetailsPanel = new JPanel();
            main.frame.add(showDetailsPanel);
            
            backButton = new JButton("Back");
            backButton.setBounds(80, 30, 110, 25);
            backButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showDetailsPanel.setVisible(false);
                    AccountInfo();
                }
            });
            showDetailsPanel.add(backButton);
            
            JLabel emailLabel = new JLabel(main.currentAccount.getEmail());
            JLabel winsLabel = new JLabel(String.valueOf(main.currentAccount.getNumberOfWins()));
            JLabel lossesLabel = new JLabel(String.valueOf(main.currentAccount.getNumberOfLosses()));
            JLabel drawsLabel = new JLabel(String.valueOf(main.currentAccount.getNumberOfDraws()));
            JLabel blitzRatingLabel = new JLabel(String.valueOf(main.currentAccount.getBlitzRating()));
            JLabel rapidRatingLabel = new JLabel(String.valueOf(main.currentAccount.getRapidRating()));
            JLabel classicalRatingLabel = new JLabel(String.valueOf(main.currentAccount.getClassicalRating()));
            JLabel gamesPlayedLabel = new JLabel(String.valueOf(main.currentAccount.getNumberOfGamesPlayed()));
            JLabel winRateLabel = new JLabel(String.valueOf(main.currentAccount.getWinRate()));
            
            emailLabel.setBounds(10,20,200,25);
            winsLabel.setBounds(10,50,200,25);
            lossesLabel.setBounds(10,80,200,25);
            drawsLabel.setBounds(10,110,200,25);
            blitzRatingLabel.setBounds(10,140,200,25);
            rapidRatingLabel.setBounds(10, 170, 200, 25);
            classicalRatingLabel.setBounds(10, 200, 200, 25);
            gamesPlayedLabel.setBounds(10,230,200,25);
            winRateLabel.setBounds(10,200,260,25);
            
            showDetailsPanel.add(emailLabel);
            showDetailsPanel.add(winsLabel);
            showDetailsPanel.add(lossesLabel);
            showDetailsPanel.add(drawsLabel);
            showDetailsPanel.add(blitzRatingLabel);
            showDetailsPanel.add(rapidRatingLabel);
            showDetailsPanel.add(classicalRatingLabel);
            showDetailsPanel.add(gamesPlayedLabel);
            showDetailsPanel.add(winRateLabel);
            
        } catch (Exception e) {
            System.out.println(e+" error in showDetails()");
            System.out.println(main.currentAccount.toString());
        }
    }
        
//        private void updateDetails(){
//            try {
//                JPanel updateDetailsPanel = new JPanel();
//                main.frame.add(updateDetailsPanel);
//                
//                JButton changePasswordButton = new JButton("Change Password");
//                changePasswordButton.setBounds(10, 30, 130, 25);
//                changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        ChangeDetails.c
//                    }
//                });
//                updateDetailsPanel.add(changePasswordButton);
//                
//                JButton changeEmailButton = new JButton("Change Email");
//                changeEmailButton.setBounds(10, 60, 130, 25);
//                changeEmailButton.addActionListener(new java.awt.event.ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        changeEmail();
//                    }
//                });
//                updateDetailsPanel.add(changeEmailButton);
//            } catch (Exception e) {
//                System.out.println(e+" error in updateDetails()");
//            }
//        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
