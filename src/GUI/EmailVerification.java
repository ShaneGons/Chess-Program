package GUI;
import Backend.*;
import Main.main;
import javax.swing.JLabel;
import libraryFunctions.repository;
public class EmailVerification extends javax.swing.JPanel {
    int newProgram;
    public int verify;
    userAccount account;
    char[] pass;
    public EmailVerification(int newProgram, userAccount account) {
        this.newProgram = newProgram;
        this.account = account;
        initComponents();
        invalidLabel.setVisible(false);
    }
    public EmailVerification(int newProgram, userAccount account, char[]pass) {
        this.newProgram = newProgram;
        this.account = account;
        initComponents();
        invalidLabel.setVisible(false);
        this.pass = pass;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailVerificationPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        verifyButton = new javax.swing.JButton();
        generateButton = new javax.swing.JButton();
        invalidLabel = new javax.swing.JLabel();

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter OTP");

        verifyButton.setText("Verify");
        verifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyButtonActionPerformed(evt);
            }
        });

        generateButton.setText("Generate New OTP");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        invalidLabel.setText("Invalid verification code");

        javax.swing.GroupLayout emailVerificationPanelLayout = new javax.swing.GroupLayout(emailVerificationPanel);
        emailVerificationPanel.setLayout(emailVerificationPanelLayout);
        emailVerificationPanelLayout.setHorizontalGroup(
            emailVerificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailVerificationPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateButton)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                .addContainerGap(106, Short.MAX_VALUE)
                .addGroup(emailVerificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                        .addComponent(verifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(168, 168, 168))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                        .addComponent(invalidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(125, 125, 125))))
        );
        emailVerificationPanelLayout.setVerticalGroup(
            emailVerificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, emailVerificationPanelLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(verifyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(invalidLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(emailVerificationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailVerificationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(emailVerificationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void runEmailVerification() {
        main.frame.add(emailVerificationPanel);
        emailVerificationPanel.setVisible(true);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        emailVerificationPanel.setVisible(false);
        Run.runLoginScreen(newProgram, account);
        Run.destroyObject(10);
    }//GEN-LAST:event_backButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void verifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyButtonActionPerformed
        if (Email.checkOTP(jTextField1.getText())) {
            emailVerificationPanel.setVisible(false);
            if (newProgram == 1) {
                main.currentAccount = account;
                Run.runMainMenu();
                Run.destroyObject(10);
            }else if (newProgram == 2){
                Run.runSavedGamesGUI(account, false, 0);
                Run.destroyObject(10);
            }else if (newProgram == 0) {
                if (Login.createAccount(account.getEmail(), pass)) {
                    System.out.println("Account Made");
                    Run.runLoginScreen(newProgram, account);
                    Run.destroyObject(1);
                }else{
                    System.out.println("Account not made");
                    Run.runLoginScreen(newProgram, account);
                    Run.destroyObject(1);
                }
            }
        }else{
            invalidLabel.setVisible(true);
        }
    }//GEN-LAST:event_verifyButtonActionPerformed

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        Email.sendEmail(account);
    }//GEN-LAST:event_generateButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel emailVerificationPanel;
    private javax.swing.JButton generateButton;
    private javax.swing.JLabel invalidLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton verifyButton;
    // End of variables declaration//GEN-END:variables
}
