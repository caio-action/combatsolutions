/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 202304289212
 */
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AcademiaService academiaService = new AcademiaService();

        while (true) {
            System.out.println("Sistema de Cobrança e Presença da Academia de Taekwondo");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Registrar Pagamento");
            System.out.println("3. Registrar Presença");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Presenças por Aluno");
            System.out.println("6. Listar Pagamentos por Aluno");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email do aluno: ");
                    String email = scanner.nextLine();
                    Aluno aluno = academiaService.cadastrarAluno(nome, email);
                    System.out.println("Aluno cadastrado: " + aluno);
                    break;
                case 2:
                    System.out.print("ID do aluno: ");
                    int alunoIdPagamento = scanner.nextInt();
                    System.out.print("Valor do pagamento: ");
                    double valor = scanner.nextDouble();
                    Pagamento pagamento = academiaService.registrarPagamento(alunoIdPagamento, valor);
                    System.out.println("Pagamento registrado: " + pagamento);
                    break;
                case 3:
                    System.out.print("ID do aluno: ");
                    int alunoIdPresenca = scanner.nextInt();
                    Presenca presenca = academiaService.registrarPresenca(alunoIdPresenca);
                    System.out.println("Presença registrada: " + presenca);
                    break;
                case 4:
                    List<Aluno> alunos = academiaService.listarAlunos();
                    System.out.println("Lista de Alunos:");
                    for (Aluno a : alunos) {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.print("ID do aluno: ");
                    int alunoIdPresencas = scanner.nextInt();
                    List<Presenca> presencas = academiaService.listarPresencasPorAluno(alunoIdPresencas);
                    System.out.println("Presenças do aluno " + alunoIdPresencas + ":");
                    for (Presenca p : presencas) {
                        System.out.println(p);
                    }
                    break;
                case 6:
                    System.out.print("ID do aluno: ");
                    int alunoIdPagamentos = scanner.nextInt();
                    List<Pagamento> pagamentos = academiaService.listarPagamentosPorAluno(alunoIdPagamentos);
                    System.out.println("Pagamentos do aluno " + alunoIdPagamentos + ":");
                    for (Pagamento p : pagamentos) {
                        System.out.println(p);
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}