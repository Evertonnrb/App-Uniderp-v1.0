package br.com.nrbsistemas.uniderpapp.model;


import android.text.format.DateFormat;

/**
 * Created by Everton on 26/03/2017.
 */

public abstract class Pessoa extends GenericDomain {
    private String nome;
    private String cpf;
    private String telefone;
    private DateFormat dateNascimento;

    public DateFormat getDateNascimento() {
        return dateNascimento;
    }

    public void setDateNascimento(DateFormat dateNascimento) {
        this.dateNascimento = dateNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    abstract DateFormat dataEntrada();
    abstract  DateFormat dataSaida();
    abstract Boolean ativo();
}
