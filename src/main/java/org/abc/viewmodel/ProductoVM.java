package org.abc.viewmodel;

import org.abc.domain.Producto;
import org.abc.services.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ProductoVM {
	private final static Logger logger = LoggerFactory.getLogger(ProductoVM.class);

	List<Producto> productos;
	Producto selectedProducto;
	Producto selectedProductoCopy;

	@WireVariable
	private ProductoService productoService;

	@Init
	public void init() {
		populateProductos();
	}

	@NotifyChange("selectedProductoCopy")
	@Command
	public void editProducto() {
		//I prefer to use a copy vs editing the selectedUser from our grid
		selectedProductoCopy = productoService.getProductoId(selectedProducto.getId());
		logger.debug("Producto for edit: {}", selectedProductoCopy);
		//update the Department in our Producto based on the correct one form our departments list
		//this enables it show up selected properly. (note: might be a better way than this? let me know)
//		for(Department dept: departments) {
//			if (selectedProductoCopy.getDepartment().getId() == dept.getId()) {
//				selectedProductoCopy.setDepartment(dept);
//				break;
//			}
//		}
	}

	@NotifyChange({"productos","selectedProductoCopy"})
	@Command
	public void submit() {
		if (selectedProductoCopy.getId() != null) {
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
		productoService.eliminarProducto(selectedProductoCopy.getId());
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
//		selectedProductoCopy.setDepartment(departments.get(0));
	}

	private void populateProductos() {
		this.productos = productoService.getTodosProductos();
	}

//	public List<Department> getDepartments() {
//		return departments;
//	}
//
//	public void setDepartments(List<Department> departments) {
//		this.departments = departments;
//	}

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

//	public DepartmentService getDepartmentService() {
//		return departmentService;
//	}
//
//	public void setDepartmentService(DepartmentService departmentService) {
//		this.departmentService = departmentService;
//	}
}
