package org.abc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Venta;
import org.abc.domain.VentaExample;
import org.abc.mapper.VentaMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("ventaService")
public class VentaServiceImpl implements VentaService {

	@Resource
	private VentaMapper ventaMapper;

	@Override
	public List<Venta> getTodosVentas() {
		VentaExample example = new VentaExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("");
		return ventaMapper.selectByExample(example);
	}
	
	@Override
	public List<Venta> getBuscarVentasPorFechas(Date fec_inicio,Date fec_fin) {
		VentaExample example = new VentaExample();
		example.createCriteria().andFechaBetween(fec_inicio, fec_fin).andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("fecha desc,hora desc");
		return ventaMapper.selectByExample(example);
	}

	@Override
	public void actualizarVenta(Venta prd) {
		prd.setFechaMod(new Date());
		ventaMapper.updateByPrimaryKeySelective(prd);
	}

	@Override
	public void eliminarVenta(Integer id) {
		ventaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Venta getVentaId(Integer id) {
		return ventaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarVenta(Venta prd) {
		ventaMapper.insertSelective(prd);
	}
}
