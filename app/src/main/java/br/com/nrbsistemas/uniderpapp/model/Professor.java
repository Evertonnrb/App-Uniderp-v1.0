package br.com.nrbsistemas.uniderpapp.model;

import android.text.format.DateFormat;

/**
 * Created by Everton on 26/03/2017.
 */

public class Professor extends Pessoa{
    private Long codigo;
    private Estado estado;
    private Cidade cidade;
    private Double salario;
    private Disciplina disciplina;

    @Override
    DateFormat dataEntrada() {
        return null;
    }

    @Override
    DateFormat dataSaida() {
        return null;
    }

    @Override
    Boolean ativo() {
        return null;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
