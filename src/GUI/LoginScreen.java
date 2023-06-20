package GUI;

import java.awt.event.ActionEvent;
import javax.swing.*;
import Backend.*;
import Main.main;

public class LoginScreen extends javax.swing.JFrame {
    private JLabel emailLabel;
    private JTextField userEmail;
    private JLabel passwordLabel;
    private JPasswordField userPassword;
    private JButton loginButton;
    private JButton createAccountButton;
    JPanel loginPanel;
    private userAccount account;
    JLabel invalidAccount;
    
    public LoginScreen(userAccount account) {
        this.account = account;
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

    public void runLoginScreen(int newProgram){
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        main.frame.add(loginPanel);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 20, 80, 25);
        loginPanel.add(emailLabel);
        
        userEmail = new JTextField(20);
        userEmail.setBounds(100,20,165,25);
        loginPanel.add(userEmail);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        loginPanel.add(passwordLabel);
        
        userPassword = new JPasswordField();
        userPassword.setBounds(100,50,165,25);
        loginPanel.add(userPassword);
        
        invalidAccount = new JLabel("Invalid credentials");
        invalidAccount.setVisible(false);
        loginPanel.add(invalidAccount);
        invalidAccount.setBounds(10,110,130,25);
        
        loginButton = new JButton("Login");
        loginButton.setBounds(10,80,80,25);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   String email = userEmail.getText();
                    char[] password = userPassword.getPassword();
                    if (newProgram == 0) {
                        userAccount tempAccount = Login.loginUser(email,password,account);
                        if (tempAccount != null) {
                            account = tempAccount;
                            loginPanel.setVisible(false);
                            Run.runEmailVerification(1, account);
                            Run.destroyObject(0);
                        }else{
                            invalidAccount.setVisible(true);
                        }
                    }else if (!(main.currentAccount.getEmail().equals(userEmail.getText()))) {
                        userAccount tempAccount = Login.loginUser(email,password,account);
                        if (tempAccount != null) {
                            account = tempAccount;
                            loginPanel.setVisible(false);
                            Run.runEmailVerification(2, account);
                            Run.destroyObject(0);
                        }else{
                            invalidAccount.setVisible(true);
                        }
                    } 
                } catch (Exception error) {
                    System.out.println(error);
                }
                
            }
        });
        loginPanel.add(loginButton);
        if (newProgram == 0) {
            createAccountButton = new JButton("Create Account");
            createAccountButton.setBounds(10,110,165,25);
            createAccountButton.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    loginPanel.setVisible(false);
                    Run.runCreateAccountScreen();
                    Run.destroyObject(0);
                }
            });
            loginPanel.add(createAccountButton);
            
        }
        loginPanel.setVisible(true);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
