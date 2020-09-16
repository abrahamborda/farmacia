package org.abc.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Laboratorio;
import org.abc.domain.LaboratorioExample;
import org.abc.mapper.LaboratorioMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("laboratorioService")
public class LaboratorioServiceImpl implements LaboratorioService {

	@Resource
	private LaboratorioMapper laboratorioMapper;

	@Override
	public List<Laboratorio> getTodosLaboratorios() {
		LaboratorioExample example = new LaboratorioExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("nombre");
		return laboratorioMapper.selectByExample(example);
	}

	@Override
	public void actualizarLaboratorio(Laboratorio prd) {
		prd.setFechaMod(new Date());
		laboratorioMapper.updateByPrimaryKey(prd);
	}

	@Override
	public void eliminarLaboratorio(Integer id) {
		laboratorioMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Laboratorio getLaboratorioId(Integer id) {
		return laboratorioMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarLaboratorio(Laboratorio prd) {
		laboratorioMapper.insertSelective(prd);
	}
}
