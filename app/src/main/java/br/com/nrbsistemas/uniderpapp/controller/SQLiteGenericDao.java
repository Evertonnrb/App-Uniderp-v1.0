package br.com.nrbsistemas.uniderpapp.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Everton on 12/04/2017.
 */

public interface SQLiteGenericDao<T> {
    /**
     * Design patterns DAO
     */

   // this.T= (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
     //       .getActualTypeArguments()[0];

    public long salvar(T t) throws Exception;
    public long ediar(T t) throws Exception;
    public long deletar(T t) throws Exception;
    public T buscar();
    public List<T> buscarTodos();
}
