package br.com.nrbsistemas.uniderpapp.controller.dao;

import java.util.List;

import br.com.nrbsistemas.uniderpapp.controller.SQLiteGenericDao;
import br.com.nrbsistemas.uniderpapp.model.Aluno;

/**
 * Created by Everton on 12/04/2017.
 */

public class AlunoDao implements SQLiteGenericDao<Aluno> {
    @Override
    public long salvar(Aluno aluno) throws Exception {
        return 0;
    }

    @Override
    public long ediar(Aluno aluno) throws Exception {
        return 0;
    }

    @Override
    public long deletar(Aluno aluno) throws Exception {
        return 0;
    }

    @Override
    public Aluno buscar() {
        return null;
    }

    @Override
    public List<Aluno> buscarTodos() {
        return null;
    }
}
