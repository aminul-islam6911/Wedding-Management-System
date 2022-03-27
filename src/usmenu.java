
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aikay
 */
public class usmenu extends javax.swing.JFrame {

    /**
     * Creates new form usmenu
     */
    public usmenu() {
        initComponents();
        menu_load();
    }
    
    Connection con;
    Statement pst;
    ResultSet rs;
    DefaultTableModel d;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menutable = new javax.swing.JTable();
        foodprice = new javax.swing.JTextField();
        foodname = new javax.swing.JTextField();
        foodid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menutable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        menutable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Platter id", "Platter name", "Platter price"
            }
        ));
        menutable.setRowHeight(20);
        menutable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menutableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menutable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 467, 320));

        foodprice.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(foodprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 30));

        foodname.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(foodname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 220, 30));

        foodid.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel1.add(foodid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 220, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Platter Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Platter Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 120, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Platter Price");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 120, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 240, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Back");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 110, 45));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/menubg.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
public void menu_load()
{
    int c;
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wedding_management","root","12345");
        pst = con.createStatement();
        rs = pst.executeQuery("select * from menu");
                    
        ResultSetMetaData rsd = rs.getMetaData();
        c = rsd.getColumnCount();
            
        d = (DefaultTableModel)menutable.getModel();
        d.setRowCount(0);
        
        menutable.getColumnModel().getColumn(0).setPreferredWidth(5);
        menutable.getColumnModel().getColumn(1).setPreferredWidth(200);
        menutable.getColumnModel().getColumn(2).setPreferredWidth(10);
        
        ((DefaultTableCellRenderer) menutable.getTableHeader().getDefaultRenderer())
                    .setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            menutable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            for (int x = 0; x < menutable.getColumnCount(); x++) {
                menutable.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
            }
        
        while(rs.next())
            {
                Vector v2 = new Vector();
                for(int i=1; i<=c; i++)
                {
                    v2.add(rs.getString("f_id"));
                    v2.add(rs.getString("food_name"));
                    v2.add(rs.getString("food_price"));   
                }
                d.addRow(v2);
            }
    }catch(SQLException e)
    {
        e.printStackTrace();
    }
}
    private void menutableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menutableMouseClicked
        // table
        d = (DefaultTableModel)menutable.getModel();
        int selecIndex = menutable.getSelectedRow();

        foodid.setText(d.getValueAt(selecIndex, 0).toString());
        foodname.setText(d.getValueAt(selecIndex, 1).toString());
        foodprice.setText(d.getValueAt(selecIndex, 2).toString());
    }//GEN-LAST:event_menutableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Back Button
        UserView s = new UserView();
        this.hide();
        s.setVisible(true);
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
            java.util.logging.Logger.getLogger(usmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField foodid;
    private javax.swing.JTextField foodname;
    private javax.swing.JTextField foodprice;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable menutable;
    // End of variables declaration//GEN-END:variables
}
