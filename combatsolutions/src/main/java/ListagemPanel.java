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
import java.util.List;

public class ListagemPanel extends JPanel {
    private JTextArea textArea;

    public ListagemPanel(AcademiaService academiaService) {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JButton btnListar = new JButton("Listar Alunos");
        add(btnListar, BorderLayout.SOUTH);

        btnListar.addActionListener(e -> {
            List<Aluno> alunos = academiaService.listarAlunos();
            StringBuilder sb = new StringBuilder();
            for (Aluno aluno : alunos) {
                sb.append(aluno).append("\n");
            }
            textArea.setText(sb.toString());
        });
    }
}