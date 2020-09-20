package org.abc.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.abc.domain.DetalleCompra;

public interface DetalleCompraService {
	List<DetalleCompra> getTodosDetalleCompras(Integer idCompra);
	public BigDecimal getSumTotal(Integer idCompra);
	public List<DetalleCompra> getdetCompraEnInventario(Integer idProducto);
//	List<DetalleCompra> getBuscarDetalleComprasPorFechas(Date fec_inicio,Date fec_fin);
    void actualizarDetalleCompra(DetalleCompra prd);
    void eliminarDetalleCompra(Integer id);
    public DetalleCompra getDetalleCompraId(Integer id);
    public void insertarDetalleCompra(DetalleCompra prd);
}
