package org.abc.viewmodel;

import org.abc.domain.Categoria;
import org.abc.domain.Laboratorio;
import org.abc.domain.Producto;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.CategoriaService;
import org.abc.services.LaboratorioService;
import org.abc.services.ProductoService;
import org.abc.utils.Parametros;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.ArrayList;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProductoVM {
	private final static Logger logger = LoggerFactory.getLogger(ProductoVM.class);

	List<Producto> productos;
	List<Categoria> categorias;
	List<Laboratorio> laboratorios;
	
//	String[] unidadsMedidas= {"aa","vv","cc"};
	Producto selectedProducto;
	Producto selectedProductoCopy;

	@WireVariable
	private ProductoService productoService;
	@WireVariable
	private CategoriaService categoriaService;
	@WireVariable
	private LaboratorioService laboratorioService;
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@Init
	public void init() {
		populateProductos();
		categorias=categoriaService.getTodosCategorias();
		laboratorios=laboratorioService.getTodosLaboratorios();
	}

	@NotifyChange("selectedProductoCopy")
	@Command
	public void editProducto() {
		//I prefer to use a copy vs editing the selectedUser from our grid
		selectedProductoCopy = productoService.getProductoId(selectedProducto.getIdProducto());
		logger.debug("Producto for edit: {}", selectedProductoCopy);
//		Categoria categoria=categoriaService.getCategoriaId(selectedProductoCopy.getIdCategoria());
//		selectedProductoCopy.setCategoria(categoria);
//		Laboratorio lab=laboratorioService.getLaboratorioId(selectedProductoCopy.getIdLaboratorio());
//		selectedProductoCopy.setLaboratorio(lab);
		//update the Department in our Producto based on the correct one form our departments list
		//this enables it show up selected properly. (note: might be a better way than this? let me know)
		for(Categoria cat: categorias) {
			if (selectedProductoCopy.getIdCategoria() == cat.getIdCategoria()) {
				selectedProductoCopy.setCategoria(cat);
				break;
			}
		}
		for(Laboratorio lab: laboratorios) {
			if (selectedProductoCopy.getIdLaboratorio() == lab.getIdLaboratorio()) {
				selectedProductoCopy.setLaboratorio(lab);
				break;
			}
		}
	}

	@NotifyChange({"productos","selectedProductoCopy"})
	@Command
	public void submit() {
		Usuario usuario=authenticationService.getUserCredential();
		selectedProductoCopy.setIdUsuario(usuario.getIdUsuario());
		selectedProductoCopy.setIdCategoria(selectedProductoCopy.getCategoria().getIdCategoria());
		selectedProductoCopy.setIdLaboratorio(selectedProductoCopy.getLaboratorio().getIdLaboratorio());
		if (selectedProductoCopy.getIdProducto() != null) {
			productoService.actualizarProducto(selectedProductoCopy);
		} else {
			productoService.insertarProducto(selectedProductoCopy);
		}
		//clear our selectedProductoCopy
		selectedProductoCopy = null;
		//populate the productos again
		populateProductos();
	}

	@NotifyChange({"productos","selectedProductoCopy"})
	@Command
	public void delete() {
		productoService.eliminarProducto(selectedProductoCopy.getIdProducto());
		//clear our selectedProductoCopy
		selectedProductoCopy = null;
		//populate the productos again
		populateProductos();
	}

	@NotifyChange("selectedProductoCopy")
	@Command
	public void newProducto() {
		selectedProductoCopy = new Producto();
		//set first department selected
		selectedProductoCopy.setCategoria(categorias.get(0));
		selectedProductoCopy.setLaboratorio(laboratorios.get(0));
		selectedProductoCopy.setUnidadMedida(Parametros.getUnidadesMedidas().get(0));
		selectedProductoCopy.setPresentacion(Parametros.getPresentaciones().get(0));
	}
	@NotifyChange({"selectedProductoCopy"})
	@Command
	public void cancel() {
		selectedProductoCopy = null;
	}

	private void populateProductos() {
		this.productos = productoService.getTodosProductos();
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Producto getSelectedProducto() {
		return selectedProducto;
	}

	public void setSelectedProducto(Producto selectedProducto) {
		this.selectedProducto = selectedProducto;
	}

	public Producto getSelectedProductoCopy() {
		return selectedProductoCopy;
	}

	public void setSelectedProductoCopy(Producto selectedProductoCopy) {
		this.selectedProductoCopy = selectedProductoCopy;
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}
	public List<String> getUnidadesMedidas() {
        return Parametros.getUnidadesMedidas();
    }
	public List<String> getPresentaciones() {
        return Parametros.getPresentaciones();
    }

}
