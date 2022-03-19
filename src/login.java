import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnnewuser = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        usrsignbt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(null);

        btnnewuser.setBackground(new java.awt.Color(0, 153, 153));
        btnnewuser.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnnewuser.setForeground(new java.awt.Color(51, 51, 51));
        btnnewuser.setText("Sign Up");
        btnnewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnewuserActionPerformed(evt);
            }
        });
        jPanel2.add(btnnewuser);
        btnnewuser.setBounds(300, 380, 87, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Password");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(300, 290, 140, 35);

        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel2.add(txtuser);
        txtuser.setBounds(460, 240, 165, 35);

        btncancel.setBackground(new java.awt.Color(255, 51, 51));
        btncancel.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        jPanel2.add(btncancel);
        btncancel.setBounds(530, 380, 100, 40);

        txtpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpassKeyPressed(evt);
            }
        });
        jPanel2.add(txtpass);
        txtpass.setBounds(460, 290, 165, 35);

        usrsignbt.setBackground(new java.awt.Color(0, 255, 0));
        usrsignbt.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        usrsignbt.setText("Sign In");
        usrsignbt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrsignbtActionPerformed(evt);
            }
        });
        jPanel2.add(usrsignbt);
        usrsignbt.setBounds(410, 380, 100, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Username");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(300, 240, 140, 35);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setText("Customer");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(350, 160, 174, 44);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("Login");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(360, 10, 174, 61);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Are You Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(653, 550, 190, 31);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rsz_tumblr_nsd09yjbo11urfkmqo1_1280.jpg"))); // NOI18N
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 0, 900, 600);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

    private void usrsignbtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrsignbtActionPerformed
        try {
            if (txtuser.getText().isEmpty() || txtpass.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Username or Password Empty");
            } else {
                String username = txtuser.getText();
                String password = txtpass.getText();

                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding_management", "root", "12345");
                pst = con.prepareStatement("select * from account where uname=? and pass=?");
                pst.setString(1, username);
                pst.setString(2, password);
                rs = pst.executeQuery();

                if (rs.next()) {
                    UserView s = new UserView();
                    this.hide();
                    s.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Username or Password Wrong");
                    txtuser.setText("");
                    txtpass.setText("");
                    txtuser.requestFocus();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_usrsignbtActionPerformed

    private void btnnewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnewuserActionPerformed
        Newuser n = new Newuser();
        this.hide();
        n.setVisible(true);
    }//GEN-LAST:event_btnnewuserActionPerformed
    private JFrame frame;
    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        frame = new JFrame("Exit");
        if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btncancelActionPerformed

    private void txtpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                if (txtuser.getText().isEmpty() || txtpass.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Username or Password Empty");
                } else {
                    String username = txtuser.getText();
                    String password = txtpass.getText();

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding_management", "root", "12345");
                    pst = con.prepareStatement("select * from account where uname=? and pass=?");
                    pst.setString(1, username);
                    pst.setString(2, password);
                    rs = pst.executeQuery();

                    if (rs.next()) {
                        UserView s = new UserView();
                        this.hide();
                        s.setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Username or Password Wrong");
                        txtuser.setText("");
                        txtpass.setText("");
                        txtuser.requestFocus();
                    }
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_txtpassKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        adminlogin al = new adminlogin();
        this.hide();
        al.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnnewuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtuser;
    private javax.swing.JButton usrsignbt;
    // End of variables declaration//GEN-END:variables
}
