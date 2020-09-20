package org.abc.services;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.DetalleVenta;
import org.abc.domain.DetalleVentaExample;
import org.abc.mapper.DetalleVentaMapper;
import org.springframework.stereotype.Service;

@Service("detalleVentaService")
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Resource
	private DetalleVentaMapper detalleVentaMapper;

	@Override
	public List<DetalleVenta> getTodosDetalleVentas(Integer idVenta) {
		DetalleVentaExample example = new DetalleVentaExample();
		example.createCriteria().andIdVentaEqualTo(idVenta);
		example.setOrderByClause("id_detalle_venta");
		return detalleVentaMapper.selectByExample(example);
	}
	@Override
	public BigDecimal getSumTotal(Integer idVenta) {
		DetalleVentaExample example = new DetalleVentaExample();
		example.createCriteria().andIdVentaEqualTo(idVenta);
		return detalleVentaMapper.sumImporte(example);
	}
	
//	@Override
//	public List<DetalleVenta> getBuscarDetalleVentasPorFechas(Date fec_inicio,Date fec_fin) {
//		DetalleVentaExample example = new DetalleVentaExample();
//		example.createCriteria().andFechaBetween(fec_inicio, fec_fin).andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
//		example.setOrderByClause("fecha");
//		return detalleVentaMapper.selectByExample(example);
//	}

	@Override
	public void actualizarDetalleVenta(DetalleVenta prd) {
		detalleVentaMapper.updateByPrimaryKeySelective(prd);
	}

	@Override
	public void eliminarDetalleVenta(Integer id) {
		detalleVentaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DetalleVenta getDetalleVentaId(Integer id) {
		return detalleVentaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarDetalleVenta(DetalleVenta prd) {
		detalleVentaMapper.insertSelective(prd);
	}
}
