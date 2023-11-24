package Tela;

import BD.ConexaoBD;
import BD.Livro;
import TelaLogin.LoginTela;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaPrincipalComum extends JFrame {

    private List<Livro> listaLivros;
    private ConexaoBD conexaoBD;
    private JTextArea areaResultado;

    public TelaPrincipalComum() {
        conexaoBD = new ConexaoBD();
        listaLivros = new ArrayList<>();

        setTitle("Cadastro e Avaliação de Livros");
        setSize(930, 714);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        carregarLivrosDoBanco();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        // Adicionando Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu arquivoMenu = new JMenu("Arquivo");
        JMenuItem sairMenuItem = new JMenuItem("Sair");

        sairMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        arquivoMenu.add(sairMenuItem);
        menuBar.add(arquivoMenu);
        setJMenuBar(menuBar);

        // Configuração de cores e fontes
        Color backgroundColor = new Color(240, 240, 240);
        Color buttonColor = new Color(30, 144, 255);
        Font labelFont = new Font("Arial", Font.BOLD, 16);

        // Configuração do painel principal
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(backgroundColor);

        // Configuração do GroupLayout
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setFont(labelFont);
        JTextField txtTitulo = new JTextField();

        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(labelFont);
        JTextField txtAutor = new JTextField();

        JLabel lblComentario = new JLabel("Comentário:");
        lblComentario.setFont(labelFont);
        JTextField txtComentario = new JTextField();

        JLabel lblNota = new JLabel("Nota (0 a 10):");
        lblNota.setFont(labelFont);
        JTextField txtNota = new JTextField();

        // Adicionando ícones aos botões
        ImageIcon cadastrarIcon = new ImageIcon("cadastrar.png");
        JButton btnCadastrar = new JButton("Cadastrar Livro", cadastrarIcon);
        btnCadastrar.setBackground(buttonColor);

        ImageIcon visualizarIcon = new ImageIcon("visualizar.png");
        JButton btnVisualizarPorNota = new JButton("Visualizar por Nota", visualizarIcon);
        btnVisualizarPorNota.setBackground(buttonColor);

        ImageIcon loginIcon = new ImageIcon("login.png");
        JButton btnTelaLogin = new JButton("Tela de Login", loginIcon);
        btnTelaLogin.setBackground(buttonColor);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultado);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnCadastrar);
        buttonPanel.add(btnVisualizarPorNota);
        buttonPanel.add(btnTelaLogin);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitulo)
                        .addComponent(lblAutor)
                        .addComponent(lblComentario)
                        .addComponent(lblNota))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtTitulo)
                        .addComponent(txtAutor)
                        .addComponent(txtComentario)
                        .addComponent(txtNota)
                        .addComponent(buttonPanel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane));

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitulo)
                        .addComponent(txtTitulo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAutor)
                        .addComponent(txtAutor))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblComentario)
                        .addComponent(txtComentario))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNota)
                        .addComponent(txtNota))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonPanel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollPane));

        layout.setHorizontalGroup(hGroup);
        layout.setVerticalGroup(vGroup);

        // Adicionando ações aos botões
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarLivro(txtTitulo.getText(), txtAutor.getText(), txtComentario.getText(), txtNota.getText());
                limparCampos(txtTitulo, txtAutor, txtComentario, txtNota);
            }
        });

        btnVisualizarPorNota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarLivrosByNota();
                exibirLivros();
            }
        });

        btnTelaLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaLogin();
            }
        });

        // Estilizando o texto da área de resultado
        areaResultado.setFont(new Font("Arial", Font.PLAIN, 14));
        areaResultado.setForeground(Color.BLACK);

        // Adicionando tooltip text
        txtTitulo.setToolTipText("Digite o título do livro");
        txtAutor.setToolTipText("Digite o autor do livro");
        txtComentario.setToolTipText("Digite um comentário sobre o livro");
        txtNota.setToolTipText("Digite a nota do livro (0 a 10)");

        // Adicionando componentes ao painel norte, centro, sul, etc.
        add(panel, BorderLayout.CENTER);
    }

    private void abrirTelaLogin() {
        try {
            dispose();
            LoginTela loginTela = new LoginTela();
            loginTela.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cadastrarLivro(String titulo, String autor, String comentario, String nota) {
        try {
            int notaInt = Integer.parseInt(nota);

            if (notaInt < 0 || notaInt > 10) {
                JOptionPane.showMessageDialog(this, "A nota deve estar entre 0 e 10.",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Livro livro = new Livro(titulo, autor, comentario, notaInt);

            listaLivros.add(livro);
            conexaoBD.inserirLivro(livro);

            carregarLivrosDoBanco();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico para a nota.",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipalComum.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ordenarLivrosByNota() {
        listaLivros.sort((livro1, livro2) -> Integer.compare(livro2.getNota(), livro1.getNota()));
    }

    private void exibirLivros() {
        areaResultado.setText("Livros Cadastrados:\n");
        for (Livro livro : listaLivros) {
            areaResultado.append(livro.toString() + "\n");
        }
    }

    private void carregarLivrosDoBanco() {
        try {
            listaLivros = conexaoBD.obterLivros();
            exibirLivros();
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipalComum.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao carregar livros do banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

