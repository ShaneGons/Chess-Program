package GUI;
import Backend.RegularExpression;
import Backend.Run;
import java.awt.event.ActionEvent;
import javax.swing.*;
import Main.main;
import HashMaps.HashData;
import libraryFunctions.repository;

public class ChangeDetails extends javax.swing.JFrame {
    JButton backButton;
    JPanel changeDetailPanel;
    
    public ChangeDetails() {
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

    public void changeDetails(){
        
    }
    public void runChangeDetails(){
        changeDetailPanel = new JPanel();
        main.frame.add(changeDetailPanel);
        
        JButton changeEmailButton = new JButton("Change Email");
        changeEmailButton.setBounds(20, 40, 150, 25);
        changeEmailButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDetailPanel.setVisible(false);
                changeEmail();
            }
        });
        changeDetailPanel.add(changeEmailButton);
        
        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(100, 40, 150, 25);
        changePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDetailPanel.setVisible(false);
                changePassword();
            }
        });
        changeDetailPanel.add(changePasswordButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(40, 80, 100, 25);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeDetailPanel.setVisible(false);
                Run.runViewDetails();
                Run.destroyObject(5);
            }
        });
        changeDetailPanel.add(backButton);
        
        changeDetailPanel.setVisible(true);
    }
    
    private void changeEmail(){
        JPanel changeEmailPanel = new JPanel();
        main.frame.add(changeEmailPanel);
        
        JLabel newEmailLabel = new JLabel("New Email:");
        newEmailLabel.setBounds(10, 20, 80, 25);
        changeEmailPanel.add(newEmailLabel);
        
        JTextField newEmailField = new JTextField(20);
        newEmailLabel.setBounds(100, 20, 180, 25);
        changeEmailPanel.add(newEmailField);
        
        JLabel confirmNewEmailLabel = new JLabel("Confirm New Email:");
        confirmNewEmailLabel.setBounds(10, 50, 80, 25);
        changeEmailPanel.add(confirmNewEmailLabel);
        
        JTextField confirmNewEmailField = new JTextField(20);
        confirmNewEmailField.setBounds(100, 50, 180, 25);
        changeEmailPanel.add(confirmNewEmailField);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 80, 90, 25);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeEmailPanel.setVisible(false);
                runChangeDetails();
            }
        });
        changeEmailPanel.add(backButton);
        
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(120, 80, 90, 25);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newEmail = newEmailField.getText();
                String confirmNewEmail = confirmNewEmailField.getText();
                if (newEmail.equals(confirmNewEmail)) {
                    if (RegularExpression.isValidEmail(newEmail)) {
                        String sql = "SELECT Logins.* FROM Logins where Email = '"+main.currentAccount.getEmail()+"'";
                        repository.changeAccountDetail(main.currentAccount.getEmail(), newEmail,"Email",sql);
                        main.currentAccount.setEmail(newEmail);
                        changeEmailPanel.setVisible(false);
                        repository.wait(1000);
                        changeDetailPanel.setVisible(true);
                    }
                    
                }
            }
        });
        changeEmailPanel.add(nextButton);
    }
    private void changePassword(){
        JPanel changePasswordPanel = new JPanel();
        main.frame.add(changePasswordPanel);
        
        JLabel newPasswordLabel = new JLabel("New Password");
        newPasswordLabel.setBounds(10, 20, 165, 25);
        changePasswordPanel.add(newPasswordLabel);
        
        JPasswordField newPasswordField = new JPasswordField(20);
        newPasswordLabel.setBounds(185, 20, 180, 25);
        changePasswordPanel.add(newPasswordField);
        
        JLabel confirmNewPasswordLabel = new JLabel("Confirm New Password:");
        confirmNewPasswordLabel.setBounds(10, 50, 165, 25);
        changePasswordPanel.add(confirmNewPasswordLabel);
        
        JPasswordField confirmNewPasswordField = new JPasswordField(20);
        confirmNewPasswordField.setBounds(185, 50, 180, 25);
        changePasswordPanel.add(confirmNewPasswordField);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(10, 80, 90, 25);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePasswordPanel.setVisible(false);
                runChangeDetails();
            }
        });
        changePasswordPanel.add(backButton);
        
        JButton nextButton = new JButton("Next");
        nextButton.setBounds(120, 80, 90, 25);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    char[] newPassword = newPasswordField.getPassword();
                    char[] confirmNewPassword = confirmNewPasswordField.getPassword();

                    if (newPassword.equals(confirmNewPassword)) {
                        String password = HashData.byteArrayToString(HashData.getHashValue(newPassword));
                        String sql = "SELECT Logins.* FROM Logins";
                        repository.changeAccountDetail(main.currentAccount.getEmail(), password, "Password", sql);
                        password = null;
                        changePasswordPanel.setVisible(false);
                        repository.wait(1000);
                        changeDetailPanel.setVisible(true);
                    }
                } catch (Exception error) {
                    System.out.println(e + " in change password");
                }
                
            }
        });
        changePasswordPanel.add(nextButton);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
