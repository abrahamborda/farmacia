package org.abc.viewmodel;

import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.PersonaService;
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
public class PersonaVM {
	private final static Logger logger = LoggerFactory.getLogger(PersonaVM.class);

	List<Persona> personas;
	Persona selectedPersona;
	Persona selectedPersonaCopy;
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@WireVariable
	private PersonaService personaService;

	@Init
	public void init() {
		populatePersonas();
	}

	@NotifyChange("selectedPersonaCopy")
	@Command
	public void editPersona() {
		selectedPersonaCopy = personaService.getPersonaId(selectedPersona.getIdPersona());
		logger.debug("Persona for edit: {}", selectedPersonaCopy);
	}

	@NotifyChange({"personas","selectedPersonaCopy"})
	@Command
	public void submit() {
		Usuario usuario=authenticationService.getUserCredential();
		selectedPersonaCopy.setIdUsuario(usuario.getIdUsuario());
		if (selectedPersonaCopy.getIdPersona() != null) {
			personaService.actualizarPersona(selectedPersonaCopy);
		} else {
			personaService.insertarPersona(selectedPersonaCopy);
		}
		selectedPersonaCopy = null;
		populatePersonas();
	}

	@NotifyChange({"personas","selectedPersonaCopy"})
	@Command
	public void delete() {
		try {
			personaService.eliminarPersona(selectedPersonaCopy.getIdPersona());
		} catch (Exception e) {
			Notification.show("No es posible eliminar a: "+selectedPersonaCopy.getNomCompleto(), "error", null, "middle_center", 1000, true);
		}
		selectedPersonaCopy = null;
		populatePersonas();
	}
	@NotifyChange({"selectedPersonaCopy"})
	@Command
	public void cancel() {
		selectedPersonaCopy = null;
	}

	@NotifyChange("selectedPersonaCopy")
	@Command
	public void newPersona() {
		selectedPersonaCopy = new Persona();
	}

	private void populatePersonas() {
		this.personas = personaService.getTodosPersonas();
	}

	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	public Persona getSelectedPersona() {
		return selectedPersona;
	}

	public void setSelectedPersona(Persona selectedPersona) {
		this.selectedPersona = selectedPersona;
	}

	public Persona getSelectedPersonaCopy() {
		return selectedPersonaCopy;
	}

	public void setSelectedPersonaCopy(Persona selectedPersonaCopy) {
		this.selectedPersonaCopy = selectedPersonaCopy;
	}

//	public PersonaService getPersonaService() {
//		return personaService;
//	}
//
//	public void setPersonaService(PersonaService personaService) {
//		this.personaService = personaService;
//	}
}
