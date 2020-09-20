package org.abc.viewmodel;

import org.abc.domain.Compra;
import org.abc.domain.DetalleCompra;
import org.abc.domain.Producto;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.CompraService;
import org.abc.services.DetalleCompraService;
import org.abc.utils.Parametros;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
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

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class EditarCompraVM {
	private final static Logger logger = LoggerFactory.getLogger(EditarCompraVM.class);

	List<DetalleCompra> detalleCompras;
	DetalleCompra selectedDetalleCompra;
	DetalleCompra selectedDetalleCompraCopy;
	Compra compra;
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();

	@WireVariable
	private DetalleCompraService detalleCompraService;
	@WireVariable
	private CompraService compraService;
	@Wire("#detalleComprasPage")
    private Window win;

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Execution exec= Executions.getCurrent();
		Map map = exec.getArg();
		compra= (Compra)map.get("compra");
		populateDetalleCompras();
	}

	@NotifyChange("selectedDetalleCompraCopy")
	@Command
	public void editDetalleCompra() {
		selectedDetalleCompraCopy = detalleCompraService.getDetalleCompraId(selectedDetalleCompra.getIdDetalleCompra());
		logger.debug("DetalleCompra for edit: {}", selectedDetalleCompraCopy);
	}

	@Command
	public void buscarProducto(@BindingParam("idProducto") Integer idProducto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idProducto", idProducto);
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/buscar_producto.zul", null,
				parametros);
		window.doModal();
	}

	@GlobalCommand
	@NotifyChange({ "selectedDetalleCompraCopy" })
	public void refreshvaluesProducto(@BindingParam("selectedProducto") Producto selectedProducto) {
		System.out.println("............." + selectedProducto.getDescripcion());
		selectedDetalleCompraCopy.setIdProducto(selectedProducto.getIdProducto());
		selectedDetalleCompraCopy.setDetProducto(selectedProducto.getDescripcion() + " "
				+ selectedProducto.getPrincipio() + " " + selectedProducto.getCategoria().getNombre()+" "
				+selectedProducto.getLaboratorio().getNombre()+" "+selectedProducto.getPresentacion()+" "+selectedProducto.getUnidadMedida());
	}

	@NotifyChange("selectedDetalleCompraCopy")
	@Command
	public void calcularImporte() {
		selectedDetalleCompraCopy.setImporte(selectedDetalleCompraCopy.getPrecioUnitario()
				.multiply(new BigDecimal(selectedDetalleCompraCopy.getCantidad())));
	}

	@NotifyChange({ "detalleCompras", "selectedDetalleCompraCopy","compra" })
	@Command
	public void submit() {
		Usuario usuario = authenticationService.getUserCredential();
		selectedDetalleCompraCopy.setIdCompra(compra.getIdCompra());
		if (selectedDetalleCompraCopy.getIdDetalleCompra() != null) {
			detalleCompraService.actualizarDetalleCompra(selectedDetalleCompraCopy);
		} else {
			detalleCompraService.insertarDetalleCompra(selectedDetalleCompraCopy);
		}
		actualizarCompra();
		selectedDetalleCompraCopy = null;
		populateDetalleCompras();
	}

	@NotifyChange({ "detalleCompras", "selectedDetalleCompraCopy","compra" })
	@Command
	public void delete() {
		try {
			detalleCompraService.eliminarDetalleCompra(selectedDetalleCompraCopy.getIdDetalleCompra());
			actualizarCompra();
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: " + selectedDetalleCompraCopy.getIdDetalleCompra(), "error",
					null, "middle_center", 1000, true);
		}
		selectedDetalleCompraCopy = null;
		populateDetalleCompras();
	}

	@NotifyChange({ "selectedDetalleCompraCopy" })
	@Command
	public void cancel() {
		selectedDetalleCompraCopy = null;
	}

	@NotifyChange("selectedDetalleCompraCopy")
	@Command
	public void newDetalleCompra() {
		selectedDetalleCompraCopy = new DetalleCompra();
		selectedDetalleCompraCopy.setCantidad(1);
		selectedDetalleCompraCopy.setPrecioUnitario(new BigDecimal(0));
		buscarProducto(1);
	}
	@Command
    public void closeThis() {
		BindUtils.postGlobalCommand(null, null, "populateComprasGlobal", null);
        win.detach();
    }
	public void actualizarCompra() {
		compra.setTotal(detalleCompraService.getSumTotal(compra.getIdCompra()));
		compraService.actualizarCompra(compra);
	}

	private void populateDetalleCompras() {
		this.detalleCompras = detalleCompraService.getTodosDetalleCompras(compra.getIdCompra());
	}

	public List<DetalleCompra> getDetalleCompras() {
		return detalleCompras;
	}

	public void setDetalleCompras(List<DetalleCompra> detalleCompras) {
		this.detalleCompras = detalleCompras;
	}

	public DetalleCompra getSelectedDetalleCompra() {
		return selectedDetalleCompra;
	}

	public void setSelectedDetalleCompra(DetalleCompra selectedDetalleCompra) {
		this.selectedDetalleCompra = selectedDetalleCompra;
	}

	public DetalleCompra getSelectedDetalleCompraCopy() {
		return selectedDetalleCompraCopy;
	}

	public void setSelectedDetalleCompraCopy(DetalleCompra selectedDetalleCompraCopy) {
		this.selectedDetalleCompraCopy = selectedDetalleCompraCopy;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

}
