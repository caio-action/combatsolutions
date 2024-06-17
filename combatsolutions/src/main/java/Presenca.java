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

public class Presenca {
    private int id;
    private int alunoId;
    private Date data;

    public Presenca(int id, int alunoId, Date data) {
        this.id = id;
        this.alunoId = alunoId;
        this.data = data;
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

    @Override
    public String toString() {
        return "Presenca [id=" + id + ", alunoId=" + alunoId + ", data=" + data + "]";
    }
}
