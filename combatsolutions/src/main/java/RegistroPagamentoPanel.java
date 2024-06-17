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

public class RegistroPagamentoPanel extends JPanel {
    public RegistroPagamentoPanel(AcademiaService academiaService) {
        setLayout(new GridLayout(3, 2));

        JLabel lblAlunoId = new JLabel("ID do Aluno:");
        JTextField txtAlunoId = new JTextField();

        JLabel lblValor = new JLabel("Valor:");
        JTextField txtValor = new JTextField();

        JButton btnRegistrar = new JButton("Registrar Pagamento");

        add(lblAlunoId);
        add(txtAlunoId);
        add(lblValor);
        add(txtValor);
        add(new JLabel()); // espaço vazio
        add(btnRegistrar);

        btnRegistrar.addActionListener(e -> {
            try {
                int alunoId = Integer.parseInt(txtAlunoId.getText());
                double valor = Double.parseDouble(txtValor.getText());
                Pagamento pagamento = academiaService.registrarPagamento(alunoId, valor);
                JOptionPane.showMessageDialog(this, "Pagamento registrado: " + pagamento);
                txtAlunoId.setText("");
                txtValor.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}