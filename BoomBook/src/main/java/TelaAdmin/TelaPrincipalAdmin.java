
package TelaAdmin;

import BD.ConexaoBD;
import TelaLogin.LoginTela;
import TelaLogin.Usuario;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelaPrincipalAdmin extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipalAdmin
     */
    public TelaPrincipalAdmin() {
        initComponents();
        setTitle("ADMIN");

    }

 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        IdadeCadastroADM = new javax.swing.JTextField();
        EmailCadastroADM = new javax.swing.JTextField();
        GenCadastroADM = new javax.swing.JTextField();
        SenhaCadastroADM = new javax.swing.JPasswordField();
        BntCadastroADM = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        VoltaTelaLogin = new javax.swing.JButton();
        NomeCadastroADM1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("E-mail");

        jLabel3.setText("Senha:");

        jLabel4.setText("Genêro:");

        BntCadastroADM.setText("Cadastrar");
        BntCadastroADM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BntCadastroADMActionPerformed(evt);
            }
        });

        jLabel5.setText("Idade:");

        VoltaTelaLogin.setText("Voltar");
        VoltaTelaLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VoltaTelaLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EmailCadastroADM))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeCadastroADM1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SenhaCadastroADM)
                            .addComponent(GenCadastroADM)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BntCadastroADM)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(VoltaTelaLogin))
                                    .addComponent(IdadeCadastroADM, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NomeCadastroADM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(EmailCadastroADM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(SenhaCadastroADM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(IdadeCadastroADM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GenCadastroADM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BntCadastroADM)
                    .addComponent(VoltaTelaLogin))
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BntCadastroADMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BntCadastroADMActionPerformed
         String nome = IdadeCadastroADM.getText();
        String email = EmailCadastroADM.getText();
        String senha = new String(SenhaCadastroADM.getPassword());
        String genero = GenCadastroADM.getText();
        String idade = IdadeCadastroADM.getText();
        
        // Verifique se todos os campos estão preenchidos
        if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            return;
        }

        // Crie um objeto Usuario com as informações
        Usuario novoUsuario = new Usuario(nome, email, senha, genero, 0); // 0 é a idade neste exemplo

        // Insira os dados no banco de dados
        try {
            ConexaoBD.inserirUsuario(novoUsuario);

            // Exiba uma mensagem de sucesso
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso.");
            
            // Limpe os campos após o cadastro
            IdadeCadastroADM.setText("");
            EmailCadastroADM.setText("");
            SenhaCadastroADM.setText("");
            GenCadastroADM.setText("");
            IdadeCadastroADM.setText("");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário no banco de dados.");
            ex.printStackTrace();
        }
    
    }//GEN-LAST:event_BntCadastroADMActionPerformed

    private void VoltaTelaLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltaTelaLoginActionPerformed
            LoginTela  loginTela = new LoginTela();
             loginTela.setVisible(true);
             this.dispose();
    }//GEN-LAST:event_VoltaTelaLoginActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BntCadastroADM;
    private javax.swing.JTextField EmailCadastroADM;
    private javax.swing.JTextField GenCadastroADM;
    private javax.swing.JTextField IdadeCadastroADM;
    private javax.swing.JTextField NomeCadastroADM1;
    private javax.swing.JPasswordField SenhaCadastroADM;
    private javax.swing.JButton VoltaTelaLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
