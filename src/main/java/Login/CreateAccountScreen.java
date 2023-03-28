package Login;

import java.awt.event.ActionEvent;
import javax.swing.*;

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

    private static JLabel emailLabel;
    private static JTextField email;
    private static JLabel confirmEmailLabel;
    private static JTextField confirmEmail;
    private static JLabel passwordLabel;
    private static JPasswordField password;
    private static JLabel confirmPasswordLabel;
    private static JPasswordField confirmPassword;
    private String userEmail;
    private static String confirmUserEmail;
    private static char[] userPassword;
    private static char[] confirmUserPassword;
    private static JButton createAccountButton;
        
    public void createAccountGUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(875,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        
        
        emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10,20,80,25);
        panel.add(emailLabel);
        
        email = new JTextField();
        email.setBounds(100,20,165,25);
        email.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userEmail = email.getText();
            }
        })
                ;
        panel.add(email);
        
        confirmEmailLabel = new JLabel("Confirm Email:");
        confirmEmailLabel.setBounds(10,50,80,25);
        panel.add(confirmEmailLabel);
        
        confirmEmail = new JTextField();
        confirmEmail.setBounds(100,50,165,25);
        confirmEmail.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmUserEmail = confirmEmail.getText();
            }
        });
        panel.add(confirmEmail);
        
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,80,80,25);
        panel.add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(100,80,165,25);
        password.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] userPassword = password.getPassword();
            }
        });
        panel.add(password);
        
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(10,110,80,25);
        panel.add(confirmPasswordLabel);
        
        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(100,110,165,25);
        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] confirmUserPassword = confirmPassword.getPassword();
            }
        });
        panel.add(confirmPassword);
        
        createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(10,170,80,25);
        createAccountButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Login.createAccount(userEmail, confirmUserEmail, userPassword, confirmUserPassword)) {
                    
                }
            }
        });
        panel.add(createAccountButton);
        
        frame.setVisible(true); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
