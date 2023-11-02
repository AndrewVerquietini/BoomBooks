package TelaLogin;

import TelaAdmin.TelaPrincipalAdmin;
import BD.ConexaoBD;
import Tela.TelaPrincipalComum;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginTela extends javax.swing.JFrame {

private List<Usuario> usuariosCadastrados = new ArrayList<>();

    public LoginTela() {
        initComponents();   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmailLogin = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        EmailCadastro = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        SenhaLogin = new javax.swing.JPasswordField();
        SenhaCadastro = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ImagemBack = new javax.swing.JLabel();
        btnCadastro = new javax.swing.JButton();
        NomeCadastro = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        GeneroCadastro = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        IdadeCadastro = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 607));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Cadastro");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        EmailLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailLoginActionPerformed(evt);
            }
        });
        getContentPane().add(EmailLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 191, -1));

        jLabel3.setText("E-mail:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));
        getContentPane().add(EmailCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 191, -1));

        jLabel4.setText("Gênero:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, -1, -1));
        getContentPane().add(SenhaLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 191, -1));
        getContentPane().add(SenhaCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, 191, -1));

        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, -1));

        jLabel5.setText("Senha:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 355, -1, -1));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 347, -1, -1));

        ImagemBack.setIcon(new javax.swing.ImageIcon("C:\\Users\\andre\\Documents\\Projeto  A3\\BoomBooks\\BoomBooks\\BoomBook\\src\\main\\resources\\imagens\\BackGround.png")); // NOI18N
        getContentPane().add(ImagemBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 610));

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 290, -1, -1));
        getContentPane().add(NomeCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 90, 191, -1));

        jLabel9.setText("Nome:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("E-mail:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, -1, -1));

        GeneroCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneroCadastroActionPerformed(evt);
            }
        });
        getContentPane().add(GeneroCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 191, -1));

        jLabel10.setText("Idade:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 210, -1, -1));

        btnLogin.setText("Logar");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));
        getContentPane().add(IdadeCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 191, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailLoginActionPerformed

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        // TODO add your handling code here:
        cadastrarUsuario();
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        validarLogin();
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void GeneroCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneroCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GeneroCadastroActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginTela().setVisible(true);
            }
        });
    }
    private void validarLogin() {
        String email = EmailLogin.getText();
        String senha = new String(SenhaLogin.getPassword());

        ConexaoBD conexaoBD = new ConexaoBD();

        if (conexaoBD.validarLoginComum(email, senha)) {
            // Login de usuário comum bem-sucedido, você pode redirecionar para a tela de usuário comum.
            // Por exemplo, você pode abrir a TelaUsuarioComum:
            TelaPrincipalComum telaUsuarioComum = new TelaPrincipalComum();
            telaUsuarioComum.setVisible(true);
            this.dispose(); // Fecha a tela de login
        } else if (conexaoBD.validarLoginAdmin(email, senha)) {
            // Login de administrador bem-sucedido, você pode redirecionar para a tela de administrador.
            // Por exemplo, você pode abrir a TelaAdmin:
            TelaPrincipalAdmin telaAdmin = new TelaPrincipalAdmin();
            telaAdmin.setVisible(true);
            this.dispose(); // Fecha a tela de login
        } else {
            // Login falhou, exiba uma mensagem de erro ou realize outra ação apropriada.
            JOptionPane.showMessageDialog(this, "Credenciais inválidas. Tente novamente.");
        }
    }
    
    private void cadastrarUsuario() {
    String nome = NomeCadastro.getText();
    String email = EmailCadastro.getText();
    String senha = new String(SenhaCadastro.getPassword());
    String genero = GeneroCadastro.getText();
    int idade = Integer.parseInt(IdadeCadastro.getText());

    // Verifique se o email já está cadastrado
    for (Usuario usuario : usuariosCadastrados) {
        if (usuario.getEmail().equals(email)) {
            JOptionPane.showMessageDialog(this, "Este e-mail já está cadastrado.");
            return;
        }
    }

    // Crie um novo objeto Usuario e adicione à lista de usuários cadastrados
    Usuario novoUsuario = new Usuario(nome, email, senha, genero, idade);
    usuariosCadastrados.add(novoUsuario);

    // Insira os dados no banco de dados
    try {
        ConexaoBD.inserirUsuario(novoUsuario);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário no banco de dados.");
        ex.printStackTrace();
    }

    // Exiba uma mensagem de sucesso
    JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso.");

    // Limpe os campos após o cadastro
    NomeCadastro.setText("");
    EmailCadastro.setText("");
    SenhaCadastro.setText("");
    GeneroCadastro.setText("");
    IdadeCadastro.setText("");
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField EmailCadastro;
    private javax.swing.JFormattedTextField EmailLogin;
    private javax.swing.JFormattedTextField GeneroCadastro;
    private javax.swing.JFormattedTextField IdadeCadastro;
    private javax.swing.JLabel ImagemBack;
    private javax.swing.JFormattedTextField NomeCadastro;
    private javax.swing.JPasswordField SenhaCadastro;
    private javax.swing.JPasswordField SenhaLogin;
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
