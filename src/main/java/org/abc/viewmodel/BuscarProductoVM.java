package org.abc.viewmodel;

import org.abc.domain.Producto;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.Window;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class BuscarProductoVM{
	private final static Logger logger = LoggerFactory.getLogger(BuscarProductoVM.class);

	List<Producto> productos;
	Producto selectedProducto;
	Producto prdABuscar;
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@WireVariable
	private ProductoService productoService;
	@Wire("#buscar_productosPage")
    private Window win;

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view,
            @ExecutionArgParam("idProducto") Integer idProducto) {
		Selectors.wireComponents(view, this, false);
//		Execution exec= Executions.getCurrent();
//		Map map = exec.getArg();
//		Integer idProducto= (Integer)map.get("idProducto");
		if(idProducto!=null)
			selectedProducto=productoService.getProductoId(idProducto);
		System.out.println(idProducto);
		prdABuscar=new Producto();
	}

	@NotifyChange({"productos","selectedProducto"})
	@Command
//	public void buscar(@BindingParam("nombres") String nombres) {
	public void buscar() {
//		System.out.println("============="+prdABuscar.getDescripcion());
		populateProductos();
		selectedProducto=null;
	}
	@NotifyChange({"selectedProducto"})
	@Command
	public void selectedProducto() {
		System.out.println("=============__________"+selectedProducto.getDescripcion());
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("selectedProducto", this.selectedProducto);
        BindUtils.postGlobalCommand(null, null, "refreshvaluesProducto", map);
		win.detach();
	}
	@Command
    public void closeThis() {
        win.detach();
    }

	private void populateProductos() {
		this.productos = productoService.getBuscarProductos(prdABuscar.getDescripcion(),prdABuscar.getPrincipio());
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

	public Producto getPrdABuscar() {
		return prdABuscar;
	}

	public void setPrdABuscar(Producto prdABuscar) {
		this.prdABuscar = prdABuscar;
	}
	
	
}
