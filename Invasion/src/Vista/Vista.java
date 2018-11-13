/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Modelo;
import javax.swing.*;

/**
 *
 * @author nere1
 */
public class Vista extends javax.swing.JFrame {

    private Modelo m;
    private VerResumen vr;
    
    public Vista() {
        initComponents();
        
        m = new Modelo();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NuevoEntorno = new javax.swing.JButton();
        PasarUnDia = new javax.swing.JButton();
        PasarDiezDias = new javax.swing.JButton();
        VerResumen = new javax.swing.JButton();
        CalentamientoGlobal = new javax.swing.JButton();
        EnfriamientoGlobal = new javax.swing.JButton();
        InvasionZombie = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ImgDia = new javax.swing.JLabel();
        ImgHumano = new javax.swing.JLabel();
        ImgVampiro = new javax.swing.JLabel();
        ImgTemperatura = new javax.swing.JLabel();
        ImgZombie = new javax.swing.JLabel();
        ImgCazaVampiro = new javax.swing.JLabel();
        nDia = new javax.swing.JLabel();
        temperatura = new javax.swing.JLabel();
        nCazavampiros = new javax.swing.JLabel();
        nVampiros = new javax.swing.JLabel();
        nZombies = new javax.swing.JLabel();
        nHumanos = new javax.swing.JLabel();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 0, 0));

        NuevoEntorno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        NuevoEntorno.setText("NUEVO ENTORNO");
        NuevoEntorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoEntornoActionPerformed(evt);
            }
        });

        PasarUnDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasarUnDia.setText("PASAR UN DIA");
        PasarUnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasarUnDiaActionPerformed(evt);
            }
        });

        PasarDiezDias.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasarDiezDias.setText("PASAR 10 DIAS");
        PasarDiezDias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasarDiezDiasActionPerformed(evt);
            }
        });

        VerResumen.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        VerResumen.setText("VER RESUMEN");
        VerResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerResumenActionPerformed(evt);
            }
        });

        CalentamientoGlobal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CalentamientoGlobal.setText("CALENTAMIENTO GLOBAL");
        CalentamientoGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalentamientoGlobalActionPerformed(evt);
            }
        });

        EnfriamientoGlobal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        EnfriamientoGlobal.setText("ENFRIAMIENTO GLOBAL");
        EnfriamientoGlobal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnfriamientoGlobalActionPerformed(evt);
            }
        });

        InvasionZombie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        InvasionZombie.setText("INVASION DE ZOMBIES");
        InvasionZombie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvasionZombieActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Goudy Stout", 0, 24)); // NOI18N
        jLabel1.setText("SIMULADOR INVASIÓN");

        ImgDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/calendario.png"))); // NOI18N

        ImgHumano.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/humano.png"))); // NOI18N

        ImgVampiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Vampiro.png"))); // NOI18N

        ImgTemperatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/teperatura.png"))); // NOI18N

        ImgZombie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/zombie.png"))); // NOI18N

        ImgCazaVampiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/cazavampiro.png"))); // NOI18N

        nDia.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nDia.setText("0");

        temperatura.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        temperatura.setText("0");

        nCazavampiros.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nCazavampiros.setText("0");

        nVampiros.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nVampiros.setText("0");

        nZombies.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nZombies.setText("0");

        nHumanos.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nHumanos.setText("0");

        salir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgHumano)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(ImgDia)
                                .addGap(63, 63, 63)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(374, 374, 374)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nDia)
                                    .addComponent(nHumanos))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(PasarUnDia, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(CalentamientoGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(VerResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(148, 148, 148)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(InvasionZombie, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PasarDiezDias, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                                                .addComponent(ImgCazaVampiro)
                                                .addGap(33, 33, 33))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(170, 170, 170)
                                                .addComponent(ImgTemperatura)))
                                        .addGap(61, 61, 61)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(temperatura)
                                            .addComponent(nCazavampiros))
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(ImgZombie)
                                            .addComponent(ImgVampiro))
                                        .addGap(62, 62, 62))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(116, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EnfriamientoGlobal)
                            .addComponent(NuevoEntorno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(805, 805, 805)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nVampiros)
                            .addComponent(nZombies))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(salir)
                        .addContainerGap(122, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(225, 225, 225)
                                        .addComponent(nDia))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(227, 227, 227)
                                        .addComponent(nVampiros))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel1)
                                        .addGap(165, 165, 165)
                                        .addComponent(temperatura)))
                                .addGap(102, 102, 102))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(ImgVampiro, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgZombie)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nCazavampiros)
                                .addGap(102, 102, 102))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(nZombies))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(nHumanos))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgTemperatura)
                            .addComponent(ImgDia))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImgHumano)
                            .addComponent(ImgCazaVampiro))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NuevoEntorno)
                    .addComponent(PasarUnDia)
                    .addComponent(PasarDiezDias))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VerResumen)
                    .addComponent(salir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EnfriamientoGlobal)
                    .addComponent(CalentamientoGlobal)
                    .addComponent(InvasionZombie))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalentamientoGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalentamientoGlobalActionPerformed
        this.m.calentamientoGlobal();
        this.updateTag();
    }//GEN-LAST:event_CalentamientoGlobalActionPerformed

    private void PasarUnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasarUnDiaActionPerformed
        this.m.nextDay();
        this.updateTag();
    }//GEN-LAST:event_PasarUnDiaActionPerformed

    private void VerResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerResumenActionPerformed
        this.vr = new VerResumen(m);
        vr.setVisible(true);
        
       
        
    }//GEN-LAST:event_VerResumenActionPerformed

    private void PasarDiezDiasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasarDiezDiasActionPerformed
        this.m.pasarDiezDias();
        this.updateTag();
    }//GEN-LAST:event_PasarDiezDiasActionPerformed

    private void NuevoEntornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoEntornoActionPerformed
        this.m.crearEntorno();
        System.out.println("Entorno creado");
        this.updateTag();
    }//GEN-LAST:event_NuevoEntornoActionPerformed

    private void EnfriamientoGlobalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnfriamientoGlobalActionPerformed
        this.m.enfriamientoGlobal();
        this.updateTag();
    }//GEN-LAST:event_EnfriamientoGlobalActionPerformed

    private void InvasionZombieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvasionZombieActionPerformed
        this.m.invasionZombie();
        this.updateTag();
    }//GEN-LAST:event_InvasionZombieActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        
    }//GEN-LAST:event_salirActionPerformed

    
    private void updateTag(){
        this.nDia.setText(String.valueOf(this.m.getDia()));
        this.temperatura.setText(String.valueOf(this.m.getTemperatura()));
        this.nHumanos.setText(String.valueOf(this.m.getNhumanos()));
        this.nCazavampiros.setText(String.valueOf(this.m.getNcazaVampiros()));
        this.nVampiros.setText(String.valueOf(this.m.getNvampiros()));
        this.nZombies.setText(String.valueOf(this.m.getNzombies()));
    }
    
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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CalentamientoGlobal;
    private javax.swing.JButton EnfriamientoGlobal;
    private javax.swing.JLabel ImgCazaVampiro;
    private javax.swing.JLabel ImgDia;
    private javax.swing.JLabel ImgHumano;
    private javax.swing.JLabel ImgTemperatura;
    private javax.swing.JLabel ImgVampiro;
    private javax.swing.JLabel ImgZombie;
    private javax.swing.JButton InvasionZombie;
    private javax.swing.JButton NuevoEntorno;
    private javax.swing.JButton PasarDiezDias;
    private javax.swing.JButton PasarUnDia;
    private javax.swing.JButton VerResumen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nCazavampiros;
    private javax.swing.JLabel nDia;
    private javax.swing.JLabel nHumanos;
    private javax.swing.JLabel nVampiros;
    private javax.swing.JLabel nZombies;
    private javax.swing.JButton salir;
    private javax.swing.JLabel temperatura;
    // End of variables declaration//GEN-END:variables
}
