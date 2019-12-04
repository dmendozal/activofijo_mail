
package Software;

import Nucleo.protocolos.ClientePOP;
import Nucleo.utilidades.Constantes;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

public class HiloPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form HiloPrincipal
     */
    HiloCorreo myThread;

    public HiloPrincipal() {
        initComponents();
        this.setTitle("Correos Tecnologia Web");
        this.setLocationRelativeTo(null);
        btnCancelar.setEnabled(false);
    }

    public class HiloCorreo extends Thread {

        public volatile boolean estado = true;

        @Override
        public void run() {
            System.out.println("Se ha iniciado el proceso");
            while (estado) {
                // Preguntar si hay mail
               if (ClientePOP.verifyInbox()) {
                    String content[] = ClientePOP.readMail();
                    if (content != null) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Se acaba de recibir un correo");
                        System.out.println("-------------------------------------------");
                        new HiloAtencion(content).start();
                    }
                }
                waitCiclo();
            }
            System.out.println("Finalizado");
        }

        public void waitCiclo() {
            try {
                sleep(Constantes.TIME_THREAD * 1000); // Esperar 2 seg.
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public class HiloAtencion extends Thread {

        public volatile String mensaje[];

        public HiloAtencion(String mensaje[]) {
            this.mensaje = mensaje;
        }

        @Override
        public void run() {
//            System.out.println(mensaje[0] + "\n\r" + mensaje[1] + "\n\r" + mensaje[2] + "\n\r" + mensaje[3]);     
//            mensaje[1]="icode295@gmail.com";
            System.out.println(mensaje[0] + "\n\r" + mensaje[1] + "\n\r");
            try {
//                new ProcesadorMensaje().processMessage(mensaje[0],mensaje[1],mensaje[2],mensaje[3]);
            	new ProcesadorMensaje().processMessage(mensaje[0],mensaje[1],"","");
            } catch (Exception e) {
                System.out.println("Ocurrio una excepcion");
                System.out.println(e);
                System.err.println(e.getMessage());
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIniciar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnIniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnCancelar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        myThread = new HiloCorreo();
        myThread.start();
        btnCancelar.setEnabled(true);
        btnIniciar.setEnabled(false);

    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        myThread.estado = false;
        btnCancelar.setEnabled(false);
        btnIniciar.setEnabled(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(HiloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HiloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HiloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HiloPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HiloPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIniciar;
    // End of variables declaration//GEN-END:variables
}
