/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetapoocic.demineurv2;
/**
 *
 * @author francois
 */
public class Flash extends javax.swing.JFrame {

    /**
     * Creates new form Flash
     */
    public Flash() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Myprogress = new javax.swing.JProgressBar();
        pourcent = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenu sur le Demineur");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Le démineur est un jeu de réflexion dont le but est de localiser des mines");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 530, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Le démineur est un jeu de réflexion dont le but est de localiser des mines");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 450, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\francois\\Documents\\NetBeansProjects\\mavenproject1\\JavaSwingLoginUi\\DemineurV2\\src\\main\\java\\projetapoocic\\images\\icons8_explosive_64.png")); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\francois\\Documents\\NetBeansProjects\\mavenproject1\\JavaSwingLoginUi\\DemineurV2\\src\\main\\java\\projetapoocic\\images\\icons8_explosion_64.png")); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 110, 90));
        jPanel1.add(Myprogress, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 570, -1));

        pourcent.setForeground(new java.awt.Color(255, 255, 255));
        pourcent.setText("%");
        jPanel1.add(pourcent, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\francois\\Documents\\NetBeansProjects\\mavenproject1\\JavaSwingLoginUi\\DemineurV2\\src\\main\\java\\projetapoocic\\images\\game.jpg")); // NOI18N
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Flash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Flash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Flash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Flash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Flash().setVisible(true);
            }
        });*/
       Flash Myflash = new Flash();
        Myflash.setVisible(true);
        try {
            for (int i = 0; i <=100; i++) {
                Thread.sleep(80);
               Myflash.Myprogress.setValue(i);
               Myflash.pourcent.setText(Integer.toString(i)+"%");
                
            } 
            
        } catch (Exception e) {
        }
          new MineSweeper().setVisible(true);
          Myflash.dispose();
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar Myprogress;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pourcent;
    // End of variables declaration//GEN-END:variables
}
