package org.abc.services;

import java.util.Date;
import java.util.List;

import org.abc.domain.Compra;

public interface CompraService {
	List<Compra> getTodosCompras();
	List<Compra> getBuscarComprasPorFechas(Date fec_inicio,Date fec_fin);
    void actualizarCompra(Compra prd);
    void eliminarCompra(Integer id);
    public Compra getCompraId(Integer id);
    public void insertarCompra(Compra prd);
}
