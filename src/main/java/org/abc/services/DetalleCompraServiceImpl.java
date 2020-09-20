package org.abc.services;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.DetalleCompra;
import org.abc.domain.DetalleCompraExample;
import org.abc.mapper.DetalleCompraMapper;
import org.springframework.stereotype.Service;

@Service("detalleCompraService")
public class DetalleCompraServiceImpl implements DetalleCompraService {

	@Resource
	private DetalleCompraMapper detalleCompraMapper;

	@Override
	public List<DetalleCompra> getTodosDetalleCompras(Integer idCompra) {
		DetalleCompraExample example = new DetalleCompraExample();
		example.createCriteria().andIdCompraEqualTo(idCompra);
		example.setOrderByClause("id_detalle_compra");
		return detalleCompraMapper.selectByExample(example);
	}
	@Override
	public BigDecimal getSumTotal(Integer idCompra) {
		DetalleCompraExample example = new DetalleCompraExample();
		example.createCriteria().andIdCompraEqualTo(idCompra);
		return detalleCompraMapper.sumImporte(example);
	}
	@Override
	public List<DetalleCompra> getdetCompraEnInventario(Integer idProducto) {
		return detalleCompraMapper.selectDetCompraEnInventario(idProducto);
	}
	
//	@Override
//	public List<DetalleCompra> getBuscarDetalleComprasPorFechas(Date fec_inicio,Date fec_fin) {
//		DetalleCompraExample example = new DetalleCompraExample();
//		example.createCriteria().andFechaBetween(fec_inicio, fec_fin).andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
//		example.setOrderByClause("fecha");
//		return detalleCompraMapper.selectByExample(example);
//	}

	@Override
	public void actualizarDetalleCompra(DetalleCompra prd) {
		detalleCompraMapper.updateByPrimaryKeySelective(prd);
	}

	@Override
	public void eliminarDetalleCompra(Integer id) {
		detalleCompraMapper.deleteByPrimaryKey(id);
	}

	@Override
	public DetalleCompra getDetalleCompraId(Integer id) {
		return detalleCompraMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarDetalleCompra(DetalleCompra prd) {
		detalleCompraMapper.insertSelective(prd);
	}
}
