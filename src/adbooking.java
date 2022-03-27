
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aikay
 */
public class adbooking extends javax.swing.JFrame {

    /**
     * Creates new form adbooking
     */
    public adbooking() {
        initComponents();
        booking_load();
    }
    
    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    DefaultTableModel d;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        adbookingtbl = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        adbookingtbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        adbookingtbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Venue", "Menu", "Person", "Photographer", "Music", "Date", "Total", "Paid", "Un Paid"
            }
        ));
        adbookingtbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adbookingtblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adbookingtbl);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Booking Details");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adbookingtblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adbookingtblMouseClicked

    }//GEN-LAST:event_adbookingtblMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminView av = new AdminView();
        this.hide();
        av.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
public void booking_load()
{
    int c;
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding_management","root","12345");
        st = con.createStatement();
        rs = st.executeQuery("select * from booking");
                    
        ResultSetMetaData rsd = rs.getMetaData();
        c = rsd.getColumnCount();
            
        d = (DefaultTableModel)adbookingtbl.getModel();
        d.setRowCount(0);
        
        adbookingtbl.getColumnModel().getColumn(0).setPreferredWidth(8);
        adbookingtbl.getColumnModel().getColumn(1).setPreferredWidth(50);
        adbookingtbl.getColumnModel().getColumn(2).setPreferredWidth(162);
        adbookingtbl.getColumnModel().getColumn(3).setPreferredWidth(150);
        adbookingtbl.getColumnModel().getColumn(4).setPreferredWidth(50);
        adbookingtbl.getColumnModel().getColumn(5).setPreferredWidth(40);
        adbookingtbl.getColumnModel().getColumn(6).setPreferredWidth(40);
        adbookingtbl.getColumnModel().getColumn(7).setPreferredWidth(75);
        adbookingtbl.getColumnModel().getColumn(8).setPreferredWidth(50);
        adbookingtbl.getColumnModel().getColumn(9).setPreferredWidth(50);
        adbookingtbl.getColumnModel().getColumn(10).setPreferredWidth(50);
       
        while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("b_id"));
                    v2.add(rs.getString("b_name"));
                    v2.add(rs.getString("b_venue"));
                    v2.add(rs.getString("b_menu"));
                    v2.add(rs.getString("b_person"));
                    v2.add(rs.getString("b_photographer"));
                    v2.add(rs.getString("b_music"));
                    v2.add(rs.getString("b_date"));
                    v2.add(rs.getString("b_total"));
                    v2.add(rs.getString("p_amount"));
                    v2.add(rs.getString("up_amount"));
                }
                d.addRow(v2);
            }
    }catch(SQLException e)
    {
        e.printStackTrace();
    }
}
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
            java.util.logging.Logger.getLogger(adbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adbooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adbooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adbookingtbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
