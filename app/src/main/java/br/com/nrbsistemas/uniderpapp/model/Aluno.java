package br.com.nrbsistemas.uniderpapp.model;

import android.text.format.DateFormat;

/**
 * Created by Everton on 26/03/2017.
 */

public class Aluno extends Pessoa{
    private Long ra;
    private Curso curso;
    private Disciplina disciplina;
    private Double n1;
    private Double n2;
    private Double media;
    private Boolean situacao;

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

    public Double getN1() {
        return n1;
    }

    public void setN1(Double n1) {
        this.n1 = n1;
    }

    public Double getN2() {
        return n2;
    }

    public void setN2(Double n2) {
        this.n2 = n2;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Double calculaMedia(Double b1,Double b2){
        setMedia(((getN1()*3)+(getN2()*4)));
        return this.getMedia();
    }
    public String imprimeSituacao(){

        String sit;

        if(getMedia()>=7){
            sit = "Aprovado";
        }else if(getMedia()<7 && getMedia()>3){
            sit = "Exame";
        }else{
            sit = "Reprovado";
        }
        return sit;
    }
}
