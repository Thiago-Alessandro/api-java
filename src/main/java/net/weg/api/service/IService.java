package net.weg.api.service;

import net.weg.api.model.dto.IDTO;

import java.util.Collection;

public interface IService<T, ID> {

    T cadastrar(IDTO dto) throws Exception;
    T editar(IDTO dto) throws Exception;
    void deletar(ID id);
    T buscarUm(ID id);
    Collection<T> buscarTodos();

}
