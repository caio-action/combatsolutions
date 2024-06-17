/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 202304289212
 */
import javax.swing.*;
import java.awt.*;

public class AcademiaApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Academia de Taekwondo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);

            AcademiaService academiaService = new AcademiaService();

            // Painel principal
            JPanel mainPanel = new JPanel(new CardLayout());

            // Painéis específicos
            CadastroAlunoPanel cadastroAlunoPanel = new CadastroAlunoPanel(academiaService);
            RegistroPagamentoPanel registroPagamentoPanel = new RegistroPagamentoPanel(academiaService);
            RegistroPresencaPanel registroPresencaPanel = new RegistroPresencaPanel(academiaService);
            ListagemPanel listagemPanel = new ListagemPanel(academiaService);

            // Adicionando painéis ao CardLayout
            mainPanel.add(cadastroAlunoPanel, "CadastroAluno");
            mainPanel.add(registroPagamentoPanel, "RegistroPagamento");
            mainPanel.add(registroPresencaPanel, "RegistroPresenca");
            mainPanel.add(listagemPanel, "Listagem");

            // Menu de navegação
            JPanel menuPanel = new JPanel();
            JButton btnCadastroAluno = new JButton("Cadastrar Aluno");
            JButton btnRegistroPagamento = new JButton("Registrar Pagamento");
            JButton btnRegistroPresenca = new JButton("Registrar Presença");
            JButton btnListagem = new JButton("Listar Alunos");

            menuPanel.add(btnCadastroAluno);
            menuPanel.add(btnRegistroPagamento);
            menuPanel.add(btnRegistroPresenca);
            menuPanel.add(btnListagem);

            // Ações dos botões
            btnCadastroAluno.addActionListener(e -> {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "CadastroAluno");
            });

            btnRegistroPagamento.addActionListener(e -> {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "RegistroPagamento");
            });

            btnRegistroPresenca.addActionListener(e -> {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "RegistroPresenca");
            });

            btnListagem.addActionListener(e -> {
                CardLayout cl = (CardLayout) (mainPanel.getLayout());
                cl.show(mainPanel, "Listagem");
            });

            frame.setLayout(new BorderLayout());
            frame.add(menuPanel, BorderLayout.NORTH);
            frame.add(mainPanel, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}