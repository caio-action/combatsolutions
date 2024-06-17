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

public class RegistroPresencaPanel extends JPanel {
    public RegistroPresencaPanel(AcademiaService academiaService) {
        setLayout(new GridLayout(2, 2));

        JLabel lblAlunoId = new JLabel("ID do Aluno:");
        JTextField txtAlunoId = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Presença");

        add(lblAlunoId);
        add(txtAlunoId);
        add(new JLabel()); // espaço vazio
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            try {
                int alunoId = Integer.parseInt(txtAlunoId.getText());
                Presenca presenca = academiaService.registrarPresenca(alunoId);
                JOptionPane.showMessageDialog(this, "Presença registrada: " + presenca);
                txtAlunoId.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID válido.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}
