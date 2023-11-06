package br.com.fatesg.pizzaria.view;

import br.com.fatesg.pizzaria.services.*;
import javax.swing.JOptionPane;

public class TelaCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeCadastro
     */
    public TelaCadastro() {
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

        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jTextFieldSenha = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextFieldCPF.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCPF.setBorder(null);

        jTextFieldTelefone.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefone.setBorder(null);

        jTextFieldEndereco.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEndereco.setBorder(null);

        jTextFieldSenha.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldSenha.setBorder(null);

        jTextFieldNome.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNome.setBorder(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Front_Assets/TELA_CADASTRO.png"))); // NOI18N

        jButtonCriarConta.setText("jButton1");
        jButtonCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(660, 660, 660)
                .addComponent(jButtonCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(440, 440, 440)
                .addComponent(jButtonCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarContaActionPerformed
        // TODO add your handling code here:
        String login = jTextFieldNome.getText();
        String senha = jTextFieldSenha.getText();
        String cpf = jTextFieldCPF.getText();
        String telefone = jTextFieldTelefone.getText();
        String endereco = jTextFieldEndereco.getText();

        //VERIFICA CPF CADASTRADO E DADOS NULOS
        if (login.isEmpty() || senha.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (!VerificaCPF.validarCPF(cpf)) { //VERIFICA CPF
            JOptionPane.showMessageDialog(this, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (UsuarioService.verificarCPFCadastrado(cpf)) { //VERIFICA CPF CADASTRADO
            JOptionPane.showMessageDialog(null, "CPF já cadastrado. Use outro CPF.");
        } else {
            //REALIZA O CADASTRO
            UsuarioService.cadastrarUsuario(login, cpf, telefone, endereco, senha);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

            jTextFieldNome.setText("");
            jTextFieldSenha.setText("");
            jTextFieldCPF.setText("");
            jTextFieldTelefone.setText("");
            jTextFieldEndereco.setText("");

            //FECHA A TELA E ABRE A TELA DE LOGIN
            this.dispose();
            TelaLogin telalogin = new TelaLogin();
            telalogin.setVisible(true);
        }
    }//GEN-LAST:event_jButtonCriarContaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSenha;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
