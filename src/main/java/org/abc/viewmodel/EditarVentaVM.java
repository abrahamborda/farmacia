package org.abc.viewmodel;

import org.abc.domain.Venta;
import org.abc.domain.DetalleCompra;
import org.abc.domain.DetalleVenta;
import org.abc.domain.Producto;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.VentaService;
import org.abc.services.DetalleVentaService;
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
public class EditarVentaVM {
	private final static Logger logger = LoggerFactory.getLogger(EditarVentaVM.class);

	List<DetalleVenta> detalleVentas;
	DetalleVenta selectedDetalleVenta;
	DetalleVenta selectedDetalleVentaCopy;
	Venta venta;
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();

	@WireVariable
	private DetalleVentaService detalleVentaService;
	@WireVariable
	private VentaService ventaService;
	@Wire("#detalleVentasPage")
    private Window win;

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Execution exec= Executions.getCurrent();
		Map map = exec.getArg();
		venta= (Venta)map.get("venta");
		populateDetalleVentas();
	}

	@NotifyChange("selectedDetalleVentaCopy")
	@Command
	public void editDetalleVenta() {
		selectedDetalleVentaCopy = detalleVentaService.getDetalleVentaId(selectedDetalleVenta.getIdDetalleVenta());
		logger.debug("DetalleVenta for edit: {}", selectedDetalleVentaCopy);
	}

	@Command
	public void buscarProducto(@BindingParam("idProducto") Integer idProducto) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("idProducto", idProducto);
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/buscar_producto_venta.zul", null,
				parametros);
		window.doModal();
	}

	@GlobalCommand
	@NotifyChange({ "selectedDetalleVentaCopy" })
	public void refreshvaluesProducto(@BindingParam("selectedDetalleCompra") DetalleCompra selectedDetalleCompra) {
		selectedDetalleVentaCopy.setDetProducto(selectedDetalleCompra.getDetProducto());
		selectedDetalleVentaCopy.setIdProducto(selectedDetalleCompra.getIdProducto());
		selectedDetalleVentaCopy.setIdDetalleCompra(selectedDetalleCompra.getIdDetalleCompra());
		selectedDetalleVentaCopy.setPrecioUnitario(selectedDetalleCompra.getPrecioVenta());
		calcularImporte();
	}

	@NotifyChange("selectedDetalleVentaCopy")
	@Command
	public void calcularImporte() {
		selectedDetalleVentaCopy.setImporte(selectedDetalleVentaCopy.getPrecioUnitario()
				.multiply(new BigDecimal(selectedDetalleVentaCopy.getCantidad())));
	}

	@NotifyChange({ "detalleVentas", "selectedDetalleVentaCopy","venta" })
	@Command
	public void submit() {
		Usuario usuario = authenticationService.getUserCredential();
		selectedDetalleVentaCopy.setIdVenta(venta.getIdVenta());
		if (selectedDetalleVentaCopy.getIdDetalleVenta() != null) {
			detalleVentaService.actualizarDetalleVenta(selectedDetalleVentaCopy);
		} else {
			detalleVentaService.insertarDetalleVenta(selectedDetalleVentaCopy);
		}
		actualizarVenta();
		selectedDetalleVentaCopy = null;
		populateDetalleVentas();
	}

	@NotifyChange({ "detalleVentas", "selectedDetalleVentaCopy","venta" })
	@Command
	public void delete() {
		try {
			detalleVentaService.eliminarDetalleVenta(selectedDetalleVentaCopy.getIdDetalleVenta());
			actualizarVenta();
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: " + selectedDetalleVentaCopy.getIdDetalleVenta(), "error",
					null, "middle_center", 1000, true);
		}
		selectedDetalleVentaCopy = null;
		populateDetalleVentas();
	}

	@NotifyChange({ "selectedDetalleVentaCopy" })
	@Command
	public void cancel() {
		selectedDetalleVentaCopy = null;
	}

	@NotifyChange("selectedDetalleVentaCopy")
	@Command
	public void newDetalleVenta() {
		selectedDetalleVentaCopy = new DetalleVenta();
		selectedDetalleVentaCopy.setCantidad(1);
		selectedDetalleVentaCopy.setPrecioUnitario(new BigDecimal(0));
		buscarProducto(0);
	}
	@Command
    public void closeThis() {
		BindUtils.postGlobalCommand(null, null, "populateVentasGlobal", null);
        win.detach();
    }
	public void actualizarVenta() {
		venta.setTotal(detalleVentaService.getSumTotal(venta.getIdVenta()));
		ventaService.actualizarVenta(venta);
	}

	private void populateDetalleVentas() {
		this.detalleVentas = detalleVentaService.getTodosDetalleVentas(venta.getIdVenta());
	}

	public List<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(List<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}

	public DetalleVenta getSelectedDetalleVenta() {
		return selectedDetalleVenta;
	}

	public void setSelectedDetalleVenta(DetalleVenta selectedDetalleVenta) {
		this.selectedDetalleVenta = selectedDetalleVenta;
	}

	public DetalleVenta getSelectedDetalleVentaCopy() {
		return selectedDetalleVentaCopy;
	}

	public void setSelectedDetalleVentaCopy(DetalleVenta selectedDetalleVentaCopy) {
		this.selectedDetalleVentaCopy = selectedDetalleVentaCopy;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
