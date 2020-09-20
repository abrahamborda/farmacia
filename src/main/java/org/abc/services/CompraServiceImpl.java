package org.abc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Compra;
import org.abc.domain.CompraExample;
import org.abc.mapper.CompraMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("compraService")
public class CompraServiceImpl implements CompraService {

	@Resource
	private CompraMapper compraMapper;

	@Override
	public List<Compra> getTodosCompras() {
		CompraExample example = new CompraExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("");
		return compraMapper.selectByExample(example);
	}
	
	@Override
	public List<Compra> getBuscarComprasPorFechas(Date fec_inicio,Date fec_fin) {
		CompraExample example = new CompraExample();
		example.createCriteria().andFechaBetween(fec_inicio, fec_fin).andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("fecha desc,hora desc");
		return compraMapper.selectByExample(example);
	}

	@Override
	public void actualizarCompra(Compra prd) {
		prd.setFechaMod(new Date());
		compraMapper.updateByPrimaryKeySelective(prd);
	}

	@Override
	public void eliminarCompra(Integer id) {
		compraMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Compra getCompraId(Integer id) {
		return compraMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarCompra(Compra prd) {
		compraMapper.insertSelective(prd);
	}
}
