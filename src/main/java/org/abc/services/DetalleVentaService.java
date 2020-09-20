package org.abc.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.abc.domain.DetalleVenta;

public interface DetalleVentaService {
	List<DetalleVenta> getTodosDetalleVentas(Integer idVenta);
	public BigDecimal getSumTotal(Integer idVenta);
//	List<DetalleVenta> getBuscarDetalleVentasPorFechas(Date fec_inicio,Date fec_fin);
    void actualizarDetalleVenta(DetalleVenta prd);
    void eliminarDetalleVenta(Integer id);
    public DetalleVenta getDetalleVentaId(Integer id);
    public void insertarDetalleVenta(DetalleVenta prd);
}
