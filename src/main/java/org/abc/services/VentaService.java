package org.abc.services;

import java.util.Date;
import java.util.List;

import org.abc.domain.Venta;

public interface VentaService {
	List<Venta> getTodosVentas();
	List<Venta> getBuscarVentasPorFechas(Date fec_inicio,Date fec_fin);
    void actualizarVenta(Venta prd);
    void eliminarVenta(Integer id);
    public Venta getVentaId(Integer id);
    public void insertarVenta(Venta prd);
}
