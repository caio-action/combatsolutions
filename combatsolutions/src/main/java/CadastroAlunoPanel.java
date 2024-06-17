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

public class CadastroAlunoPanel extends JPanel {
    public CadastroAlunoPanel(AcademiaService academiaService) {
        setLayout(new GridLayout(4, 2));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblEmail = new JLabel("Email:");
        JTextField txtEmail = new JTextField();

        JButton btnCadastrar = new JButton("Cadastrar");

        add(lblNome);
        add(txtNome);
        add(lblEmail);
        add(txtEmail);
        add(new JLabel()); // espaço vazio
        add(btnCadastrar);

        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            Aluno aluno = academiaService.cadastrarAluno(nome, email);
            JOptionPane.showMessageDialog(this, "Aluno cadastrado: " + aluno);
            txtNome.setText("");
            txtEmail.setText("");
        });
    }
}