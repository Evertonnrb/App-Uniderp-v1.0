package br.com.nrbsistemas.uniderpapp.model;

import android.text.format.DateFormat;

/**
 * Created by Everton on 26/03/2017.
 */

public class Aluno extends Pessoa{
    private Long ra;
    private Curso curso;
    private Disciplina disciplina;

    public Long getRa() {
        return ra;
    }

    public void setRa(Long ra) {
        this.ra = ra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

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
}
