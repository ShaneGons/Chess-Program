package Login;

import java.awt.event.ActionEvent;
import javax.swing.*;
import HashMaps.HashData;

public class LoginScreen extends javax.swing.JFrame {
    private static JLabel emailLabel;
    private static JTextField userEmail;
    private static JLabel passwordLabel;
    private static JPasswordField userPassword;
    private static JButton loginButton;
    private static JButton createAccountButton;
    
    public LoginScreen() {
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

    public  void main(String args[]) {
        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        int frameWidth = 700;
        int frameHeight = 400;
        frame.setSize(frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(frameWidth/2, frameHeight/2, frameWidth/9, frameHeight/8);
        panel.add(emailLabel);
        
        userEmail = new JTextField(20);
        userEmail.setBounds((frameWidth/2)-(frameWidth/3),frameHeight/2,165,25);
        panel.add(userEmail);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(frameWidth/2,(frameHeight/2)-(frameWidth/30),80,25);
        panel.add(passwordLabel);
        
        userPassword = new JPasswordField();
        userPassword.setBounds((frameWidth/2)+(frameWidth/3),(frameHeight/2)-(frameWidth/30),165,25);
        panel.add(userPassword);
        
        loginButton = new JButton("Login");
        loginButton.setBounds((frameWidth/2)+(frameHeight/3),(frameHeight/2)-(2*frameWidth/30),80,25);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = userEmail.getText();
                char[] password = userPassword.getPassword();
                Login.loginUser(email,password);
            }
        });
        panel.add(loginButton);
        
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10,110,80,25);
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccountScreen.createAccountGUI();
            }
        });
        panel.add(createAccountButton);
        
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
