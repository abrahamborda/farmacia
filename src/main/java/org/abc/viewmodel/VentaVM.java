package org.abc.viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.abc.domain.Venta;
import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.VentaService;
import org.abc.utils.Parametros;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;
import org.zkoss.zul.Window;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class VentaVM {
	private final static Logger logger = LoggerFactory.getLogger(VentaVM.class);

	List<Venta> ventas;
	Venta selectedVenta;
	Venta selectedVentaCopy;
	Date fecInicio;
	Date fecFin;
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();

	@WireVariable
	private VentaService ventaService;

	@Init
	public void init() {
		fecFin=Parametros.getFechaActual();
		fecInicio=Parametros.getSumasDiasFecha(fecFin, Parametros.DIAS_VENTA);
		
		populateVentas();
	}

	@NotifyChange({ "ventas", "selectedPersona" })
	@Command
	public void buscar() {
//		System.out.println("=============" + fecInicio + "::" + fecFin);
		populateVentas();
		selectedVenta = null;
	}

	@NotifyChange("selectedVentaCopy")
	@Command
	public void editVenta() {
		selectedVentaCopy = ventaService.getVentaId(selectedVenta.getIdVenta());
		logger.debug("Venta for edit: {}", selectedVentaCopy);
	}

	@NotifyChange("selectedVentaCopy")
	@Command
	public void newVenta() {
		selectedVentaCopy = new Venta();
		selectedVentaCopy.setFecha(new Date());
		selectedVentaCopy.setHora(new Date());
		selectedVentaCopy.setTotal(new BigDecimal(0));
		buscarPersona();
	}
	@Command
	public void buscarPersona() {
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/buscar_persona.zul", null,
				null);
		window.doModal();
	}
	@GlobalCommand
	@NotifyChange({ "selectedVentaCopy" })
	public void refreshvaluesPersona(@BindingParam("selectedPersona") Persona selectedPersona) {
		System.out.println("............." + selectedPersona.getNombre());
		selectedVentaCopy.setIdPersona(selectedPersona.getIdPersona());
		selectedVentaCopy.setNomPersona(selectedPersona.getNombre());
	}
	@NotifyChange({ "ventas", "selectedVentaCopy" })
	@Command
	public void submit() {
		Usuario usuario = authenticationService.getUserCredential();
		selectedVentaCopy.setIdUsuario(usuario.getIdUsuario());
		if (selectedVentaCopy.getIdVenta() != null) {
			ventaService.actualizarVenta(selectedVentaCopy);
		} else {
			selectedVentaCopy.setTotal(new BigDecimal(0));
			ventaService.insertarVenta(selectedVentaCopy);
		}
		selectedVentaCopy = null;
		populateVentas();
	}

	@NotifyChange({ "ventas", "selectedVentaCopy" })
	@Command
	public void delete() {
		try {
			ventaService.eliminarVenta(selectedVentaCopy.getIdVenta());
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: " + selectedVentaCopy.getIdVenta(), "error",
					null, "middle_center", 1000, true);
		}
		selectedVentaCopy = null;
		populateVentas();
	}

	@NotifyChange({ "selectedVentaCopy" })
	@Command
	public void cancel() {
		selectedVentaCopy = null;
	}
	@Command
	public void admDetalle() {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("venta", selectedVentaCopy);
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/editar_venta.zul", null,
				parametros);
		window.doModal();
	}
	@GlobalCommand
	@NotifyChange({ "ventas", "selectedVentaCopy" })
	public void populateVentasGlobal() {
		selectedVentaCopy = null;
		populateVentas();
	}
	public void populateVentas() {
		this.ventas = ventaService.getBuscarVentasPorFechas(fecInicio, fecFin);
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public Venta getSelectedVenta() {
		return selectedVenta;
	}

	public void setSelectedVenta(Venta selectedVenta) {
		this.selectedVenta = selectedVenta;
	}

	public Venta getSelectedVentaCopy() {
		return selectedVentaCopy;
	}

	public void setSelectedVentaCopy(Venta selectedVentaCopy) {
		this.selectedVentaCopy = selectedVentaCopy;
	}

	public Date getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(Date fecInicio) {
		this.fecInicio = fecInicio;
	}

	public Date getFecFin() {
		return fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
	}

}
