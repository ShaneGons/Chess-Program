package GUI;

import Backend.*;
import Main.main;
import java.awt.event.ActionEvent;
import javax.swing.*;
import libraryFunctions.repository;

public class CreateAccountScreen extends javax.swing.JFrame {
    public CreateAccountScreen() {
        initComponents();
        createAccountGUI();
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

    private JLabel emailLabel;
    private JTextField email;
    private JLabel confirmEmailLabel;
    private JTextField confirmEmail;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPassword;
    private JButton createAccountButton;
    private JLabel createdAccountFlag = new JLabel("Account successfully created!");
    private JButton backButton;
        
    public void createAccountGUI(){
        JPanel panel = new JPanel();
        main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main.frame.add(panel);
        panel.setLayout(null);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10,20,130,25);
        panel.add(emailLabel);
        
        email = new JTextField();
        email.setBounds(150,20,165,25);
        panel.add(email);
        
        confirmEmailLabel = new JLabel("Confirm Email:");
        confirmEmailLabel.setBounds(10,50,130,25);
        panel.add(confirmEmailLabel);
        
        confirmEmail = new JTextField();
        confirmEmail.setBounds(150,50,165,25);
        panel.add(confirmEmail);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,80,130,25);
        panel.add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(150,80,165,25);
        panel.add(password);
        
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10,110,130,25);
        panel.add(confirmPasswordLabel);
        
        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(150,110,165,25);
        panel.add(confirmPassword);
        
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(150,170,165,25);
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String userEmail = email.getText();
                    String confirmUserEmail = confirmEmail.getText();
                    char[] userPassword = password.getPassword();
                    char[] confirmUserPassword = confirmPassword.getPassword();
                    boolean passwordEquals = true;
                    for (int i = 0; i < userPassword.length; i++) {
                        if (userPassword[i] != confirmUserPassword[i]) {
                            passwordEquals = false;
                        }
                    }
                    if (userEmail.equals(confirmUserEmail) && passwordEquals) {
                        String pass = "";
                        for (int i = 0; i < userPassword.length; i++) {
                            pass += userPassword[i];
                        }
                        if (RegularExpression.isValidPassword(pass) && RegularExpression.isValidEmail(confirmUserEmail)) {
                            if (email != null && confirmEmail != null && password != null && confirmPassword != null) {
                                userAccount account = new userAccount();
                                account.setEmail(confirmUserEmail);
                                Run.createAccount(account, userPassword);
                                panel.setVisible(false);
                                Run.destroyObject(1);
                            }else System.out.println("Items are null");
                        }else System.out.println("password not strong enough");
                    }else System.out.println("Not matching");
                } catch (Exception error) {
                    System.out.println(error);
                }
                
            }
        });
        panel.add(createAccountButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(10, 175, 100, 25);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setVisible(false);
                Run.runLoginScreen(0,main.currentAccount);
                Run.destroyObject(1);
            }
        });
        panel.add(backButton);
        panel.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
