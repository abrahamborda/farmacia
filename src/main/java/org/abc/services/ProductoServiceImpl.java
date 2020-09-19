package org.abc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Persona;
import org.abc.domain.Producto;
import org.abc.domain.ProductoExample;
import org.abc.mapper.ProductoMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Resource
	private ProductoMapper productoMapper;

	@Override
	public List<Producto> getTodosProductos() {
		ProductoExample example = new ProductoExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		return productoMapper.selectByExample(example);
	}

	@Override
	public List<Producto> getBuscarProductos(String descripcion, String principio) {
		if(descripcion.trim().equals("") && principio.trim().equals(""))
			return new ArrayList<Producto>();
		ProductoExample example = new ProductoExample();
		example.createCriteria().andDescripcionLike(Parametros.getStringLike(descripcion))
				.andPrincipioLike(Parametros.getStringLike(principio)).andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		return productoMapper.selectByExample(example);
	}

	@Override
	public void actualizarProducto(Producto prd) {
		prd.setFechaMod(new Date());
		productoMapper.updateByPrimaryKey(prd);
	}

	@Override
	public void eliminarProducto(Integer id) {
		productoMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Producto getProductoId(Integer id) {
		return productoMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarProducto(Producto prd) {
		productoMapper.insertSelective(prd);
	}
}
