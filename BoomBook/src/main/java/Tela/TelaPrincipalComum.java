package Tela;

import BD.ConexaoBD;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import BD.Livro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipalComum extends JFrame {
    private List<Livro> listaLivros;
    private ConexaoBD conexaoBD;

    public TelaPrincipalComum() {
        listaLivros = new ArrayList<>();
        conexaoBD = new ConexaoBD();

        setTitle("Cadastro e Avaliação de Livros");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();

        setLocationRelativeTo(null); // Centralizar a janela na tela
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());

        
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JLabel lblTitulo = new JLabel("Título:");
        JTextField txtTitulo = new JTextField();
        JLabel lblAutor = new JLabel("Autor:");
        JTextField txtAutor = new JTextField();
        JLabel lblComentario = new JLabel("Comentário:");
        JTextField txtComentario = new JTextField();
        JLabel lblNota = new JLabel("Nota (0 a 10):");
        JTextField txtNota = new JTextField();
        JButton btnCadastrar = new JButton("Cadastrar Livro");

        inputPanel.add(lblTitulo);
        inputPanel.add(txtTitulo);
        inputPanel.add(lblAutor);
        inputPanel.add(txtAutor);
        inputPanel.add(lblComentario);
        inputPanel.add(txtComentario);
        inputPanel.add(lblNota);
        inputPanel.add(txtNota);
        inputPanel.add(btnCadastrar);

        // Painel de listagem de livros
        JPanel listPanel = new JPanel(new BorderLayout());
        JTextArea areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        listPanel.add(new JScrollPane(areaResultado), BorderLayout.CENTER);

        // Adicionando os painéis ao painel principal
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(listPanel, BorderLayout.CENTER);

        // Ação do botão cadastrar
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String titulo = txtTitulo.getText();
                    String autor = txtAutor.getText();
                    String comentario = txtComentario.getText();
                    int nota = Integer.parseInt(txtNota.getText());

                    if (nota < 0 || nota > 10) {
                        JOptionPane.showMessageDialog(TelaPrincipalComum.this, "A nota deve estar entre 0 e 10.",
                                "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Livro livro = new Livro(titulo, autor, comentario, nota);
                    
                    listaLivros.add(livro);

                    // Inserir livro no banco de dados
                    conexaoBD.inserirLivro(livro);

                    // Exibir livros
                    exibirLivros(areaResultado);
                    limparCampos(txtTitulo, txtAutor, txtComentario, txtNota);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(TelaPrincipalComum.this, "Digite um valor numérico para a nota.",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipalComum.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        add(panel);
    }

    private void exibirLivros(JTextArea areaResultado) {
        areaResultado.setText("Livros Cadastrados:\n");
        for (Livro livro : listaLivros) {
            areaResultado.append(livro.toString() + "\n");
        }
    }

    private void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }



/*
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
*/
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

