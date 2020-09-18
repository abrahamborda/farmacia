package org.abc.services;

import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Categoria;
import org.abc.domain.CategoriaExample;
import org.abc.mapper.CategoriaMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Resource
	private CategoriaMapper categoriaMapper;
	
	@Override
	public List<Categoria> getTodosCategorias() {
		CategoriaExample example= new CategoriaExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("categoria");
		return categoriaMapper.selectByExample(example);
	}

	@Override
	public Categoria getCategoriaId(Integer id) {
		return categoriaMapper.selectByPrimaryKey(id);
	}

}
