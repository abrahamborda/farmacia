package org.abc.viewmodel;

import org.abc.domain.Laboratorio;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.LaboratorioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;

import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LaboratorioVM {
	private final static Logger logger = LoggerFactory.getLogger(LaboratorioVM.class);

	List<Laboratorio> laboratorios;
	Laboratorio selectedLaboratorio;
	Laboratorio selectedLaboratorioCopy;
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@WireVariable
	private LaboratorioService laboratorioService;

	@Init
	public void init() {
		populateLaboratorios();
	}

	@NotifyChange("selectedLaboratorioCopy")
	@Command
	public void editLaboratorio() {
		selectedLaboratorioCopy = laboratorioService.getLaboratorioId(selectedLaboratorio.getIdLaboratorio());
		logger.debug("Laboratorio for edit: {}", selectedLaboratorioCopy);
	}

	@NotifyChange({"laboratorios","selectedLaboratorioCopy"})
	@Command
	public void submit() {
		Usuario usuario=authenticationService.getUserCredential();
		selectedLaboratorioCopy.setIdUsuario(usuario.getIdUsuario());
		if (selectedLaboratorioCopy.getIdLaboratorio() != null) {
			laboratorioService.actualizarLaboratorio(selectedLaboratorioCopy);
		} else {
			laboratorioService.insertarLaboratorio(selectedLaboratorioCopy);
		}
		selectedLaboratorioCopy = null;
		populateLaboratorios();
	}

	@NotifyChange({"laboratorios","selectedLaboratorioCopy"})
	@Command
	public void delete() {
		try {
			laboratorioService.eliminarLaboratorio(selectedLaboratorioCopy.getIdLaboratorio());
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: "+selectedLaboratorioCopy.getNombre(), "error", null, "middle_center", 1000, true);
		}
		selectedLaboratorioCopy = null;
		populateLaboratorios();
	}
	@NotifyChange({"selectedLaboratorioCopy"})
	@Command
	public void cancel() {
		selectedLaboratorioCopy = null;
	}

	@NotifyChange("selectedLaboratorioCopy")
	@Command
	public void newLaboratorio() {
		selectedLaboratorioCopy = new Laboratorio();
	}

	private void populateLaboratorios() {
		this.laboratorios = laboratorioService.getTodosLaboratorios();
	}

	public List<Laboratorio> getLaboratorios() {
		return laboratorios;
	}

	public void setLaboratorios(List<Laboratorio> laboratorios) {
		this.laboratorios = laboratorios;
	}

	public Laboratorio getSelectedLaboratorio() {
		return selectedLaboratorio;
	}

	public void setSelectedLaboratorio(Laboratorio selectedLaboratorio) {
		this.selectedLaboratorio = selectedLaboratorio;
	}

	public Laboratorio getSelectedLaboratorioCopy() {
		return selectedLaboratorioCopy;
	}

	public void setSelectedLaboratorioCopy(Laboratorio selectedLaboratorioCopy) {
		this.selectedLaboratorioCopy = selectedLaboratorioCopy;
	}

//	public LaboratorioService getLaboratorioService() {
//		return laboratorioService;
//	}
//
//	public void setLaboratorioService(LaboratorioService laboratorioService) {
//		this.laboratorioService = laboratorioService;
//	}
}
