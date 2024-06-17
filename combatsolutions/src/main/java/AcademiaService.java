/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 202304289212
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class AcademiaService {
    private List<Aluno> alunos = new ArrayList<>();
    private List<Pagamento> pagamentos = new ArrayList<>();
    private List<Presenca> presencas = new ArrayList<>();

    private int nextAlunoId = 1;
    private int nextPagamentoId = 1;
    private int nextPresencaId = 1;

    // Cadastro de aluno
    public Aluno cadastrarAluno(String nome, String email) {
        Aluno aluno = new Aluno(nextAlunoId++, nome, email);
        alunos.add(aluno);
        return aluno;
    }

    // Registro de pagamento
    public Pagamento registrarPagamento(int alunoId, double valor) {
        Aluno aluno = encontrarAluno(alunoId);
        if (aluno == null || !aluno.isAtivo()) {
            throw new IllegalArgumentException("Aluno não encontrado ou inativo.");
        }
        Pagamento pagamento = new Pagamento(nextPagamentoId++, alunoId, new Date(), valor);
        pagamentos.add(pagamento);
        return pagamento;
    }

    // Registro de presença
    public Presenca registrarPresenca(int alunoId) {
        Aluno aluno = encontrarAluno(alunoId);
        if (aluno == null || !aluno.isAtivo()) {
            throw new IllegalArgumentException("Aluno não encontrado ou inativo.");
        }
        Presenca presenca = new Presenca(nextPresencaId++, alunoId, new Date());
        presencas.add(presenca);
        return presenca;
    }

    // Encontrar aluno por ID
    public Aluno encontrarAluno(int id) {
        return alunos.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
    }

    // Listar todos os alunos
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos);
    }

    // Listar presenças por aluno
    public List<Presenca> listarPresencasPorAluno(int alunoId) {
        return presencas.stream().filter(p -> p.getAlunoId() == alunoId).collect(Collectors.toList());
    }

    // Listar pagamentos por aluno
    public List<Pagamento> listarPagamentosPorAluno(int alunoId) {
        return pagamentos.stream().filter(p -> p.getAlunoId() == alunoId).collect(Collectors.toList());
    }
}