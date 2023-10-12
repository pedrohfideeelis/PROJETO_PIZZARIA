package Visao;

import BD.salvarUsuario;
import static BD.salvarUsuario.salvarUsuario;
import Classes.CPFUtil;
import Classes.Usuario;
import javax.swing.JOptionPane;

public class TelaDeCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaDeCadastro
     */
    public TelaDeCadastro() {
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

        jPanel1 = new javax.swing.JPanel();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jTextFieldCPF = new javax.swing.JTextField();
        jTextFieldTelefone = new javax.swing.JTextField();
        jTextFieldEndereco = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCriarConta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(555, 555));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldLogin.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldLogin.setBorder(null);
        jPanel1.add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 162, 260, 30));

        jPasswordFieldSenha.setBackground(new java.awt.Color(255, 255, 255));
        jPasswordFieldSenha.setBorder(null);
        jPanel1.add(jPasswordFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 262, 260, 30));

        jTextFieldCPF.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldCPF.setBorder(null);
        jPanel1.add(jTextFieldCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 370, 260, 30));

        jTextFieldTelefone.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldTelefone.setBorder(null);
        jPanel1.add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 162, 260, 30));

        jTextFieldEndereco.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldEndereco.setBorder(null);
        jPanel1.add(jTextFieldEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 252, 260, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Front_Assets/TELA_CADASTRO.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButtonCriarConta.setText("CRIAR CONTA");
        jButtonCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarContaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 440, 130, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarContaActionPerformed

        String login = jTextFieldLogin.getText();
        String senha = new String(jPasswordFieldSenha.getPassword());
        String cpf = jTextFieldCPF.getText();
        String telefone = jTextFieldTelefone.getText();
        String endereco = jTextFieldEndereco.getText();

        if (login.isEmpty() || senha.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if (!CPFUtil.validarCPF(cpf)) {
            JOptionPane.showMessageDialog(this, "CPF inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario novoUsuario = new Usuario(login, senha, cpf, telefone, endereco);
            salvarUsuario(novoUsuario);

            // Limpa os campos após o cadastro
            jTextFieldLogin.setText("");
            jPasswordFieldSenha.setText("");
            jTextFieldCPF.setText("");
            jTextFieldTelefone.setText("");
            jTextFieldEndereco.setText("");

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        // Abre a tela de login
        TelaDeLogin telaLogin = new TelaDeLogin();
        telaLogin.setVisible(true);
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
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCriarConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldSenha;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldTelefone;
    // End of variables declaration//GEN-END:variables
}