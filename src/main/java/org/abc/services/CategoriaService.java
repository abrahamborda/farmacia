package org.abc.services;

import java.util.List;

import org.abc.domain.Categoria;
import org.abc.domain.Laboratorio;

public interface CategoriaService {
	List<Categoria> getTodosCategorias();
    public Categoria getCategoriaId(Integer id);

}
