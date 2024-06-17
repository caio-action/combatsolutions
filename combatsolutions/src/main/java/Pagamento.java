/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 202304289212
 */
import java.util.Date;

public class Pagamento {
    private int id;
    private int alunoId;
    private Date data;
    private double valor;

    public Pagamento(int id, int alunoId, Date data, double valor) {
        this.id = id;
        this.alunoId = alunoId;
        this.data = data;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Pagamento [id=" + id + ", alunoId=" + alunoId + ", data=" + data + ", valor=" + valor + "]";
    }
}