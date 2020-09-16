package org.abc.services;

import java.util.List;

import org.abc.domain.Producto;

import net.learntechnology.empmaint.domain.Employee;

public interface ProductoService {
	List<Producto> getTodosProductos();
    void actualizarProducto(Producto prd);
    void eliminarProducto(Integer id);
    public Producto getProductoId(Integer id);
    public void insertarProducto(Producto prd);

}
