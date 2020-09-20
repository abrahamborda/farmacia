package org.abc.viewmodel;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.abc.domain.Compra;
import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.CompraService;
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
public class CompraVM {
	private final static Logger logger = LoggerFactory.getLogger(CompraVM.class);

	List<Compra> compras;
	Compra selectedCompra;
	Compra selectedCompraCopy;
	Date fecInicio;
	Date fecFin;
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();

	@WireVariable
	private CompraService compraService;

	@Init
	public void init() {
		fecFin=Parametros.getFechaActual();
		fecInicio=Parametros.getSumasDiasFecha(fecFin, Parametros.DIAS_COMPRA);
		
		populateCompras();
	}

	@NotifyChange({ "compras", "selectedPersona" })
	@Command
	public void buscar() {
//		System.out.println("=============" + fecInicio + "::" + fecFin);
		populateCompras();
		selectedCompra = null;
	}

	@NotifyChange("selectedCompraCopy")
	@Command
	public void editCompra() {
		selectedCompraCopy = compraService.getCompraId(selectedCompra.getIdCompra());
		logger.debug("Compra for edit: {}", selectedCompraCopy);
	}

	@NotifyChange("selectedCompraCopy")
	@Command
	public void newCompra() {
		selectedCompraCopy = new Compra();
		selectedCompraCopy.setFecha(new Date());
		selectedCompraCopy.setHora(new Date());
		selectedCompraCopy.setTotal(new BigDecimal(0));
		buscarPersona();
	}
	@Command
	public void buscarPersona() {
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/buscar_persona.zul", null,
				null);
		window.doModal();
	}
	@GlobalCommand
	@NotifyChange({ "selectedCompraCopy" })
	public void refreshvaluesPersona(@BindingParam("selectedPersona") Persona selectedPersona) {
		System.out.println("............." + selectedPersona.getNombre());
		selectedCompraCopy.setIdPersona(selectedPersona.getIdPersona());
		selectedCompraCopy.setNomPersona(selectedPersona.getNombre());
	}
	@NotifyChange({ "compras", "selectedCompraCopy" })
	@Command
	public void submit() {
		Usuario usuario = authenticationService.getUserCredential();
		selectedCompraCopy.setIdUsuario(usuario.getIdUsuario());
		if (selectedCompraCopy.getIdCompra() != null) {
			compraService.actualizarCompra(selectedCompraCopy);
		} else {
			selectedCompraCopy.setTotal(new BigDecimal(0));
			compraService.insertarCompra(selectedCompraCopy);
		}
		selectedCompraCopy = null;
		populateCompras();
	}

	@NotifyChange({ "compras", "selectedCompraCopy" })
	@Command
	public void delete() {
		try {
			compraService.eliminarCompra(selectedCompraCopy.getIdCompra());
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: " + selectedCompraCopy.getIdCompra(), "error",
					null, "middle_center", 1000, true);
		}
		selectedCompraCopy = null;
		populateCompras();
	}

	@NotifyChange({ "selectedCompraCopy" })
	@Command
	public void cancel() {
		selectedCompraCopy = null;
	}
	@Command
	public void admDetalle() {
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("compra", selectedCompraCopy);
		Window window = (Window) Executions.createComponents(Parametros.URL_ZUL + "/editar_compra.zul", null,
				parametros);
		window.doModal();
	}
	@GlobalCommand
	@NotifyChange({ "compras", "selectedCompraCopy" })
	public void populateComprasGlobal() {
		selectedCompraCopy = null;
		populateCompras();
	}
	public void populateCompras() {
		this.compras = compraService.getBuscarComprasPorFechas(fecInicio, fecFin);
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra getSelectedCompra() {
		return selectedCompra;
	}

	public void setSelectedCompra(Compra selectedCompra) {
		this.selectedCompra = selectedCompra;
	}

	public Compra getSelectedCompraCopy() {
		return selectedCompraCopy;
	}

	public void setSelectedCompraCopy(Compra selectedCompraCopy) {
		this.selectedCompraCopy = selectedCompraCopy;
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
