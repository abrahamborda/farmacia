package org.abc.viewmodel;

import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.PersonaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
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
public class BuscarPersonaVM {
	private final static Logger logger = LoggerFactory.getLogger(BuscarPersonaVM.class);

	List<Persona> personas;
	Persona selectedPersona;
	String nombres;
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@WireVariable
	private PersonaService personaService;
	@Wire("#personasPage")
    private Window win;

	@Init
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		nombres="";
	}

	@NotifyChange({"personas","selectedPersona"})
	@Command
//	public void buscar(@BindingParam("nombres") String nombres) {
	public void buscar() {
		System.out.println("============="+nombres);
		populatePersonas(nombres);
		selectedPersona=null;
	}
	@NotifyChange({"selectedPersona"})
	@Command
	public void selectedPersona() {
		System.out.println("=============__________"+selectedPersona.getNomCompleto());
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("selectedPersona", this.selectedPersona);
        BindUtils.postGlobalCommand(null, null, "refreshvaluesPersona", map);
		win.detach();
	}
	@Command
    public void closeThis() {
        win.detach();
    }

	private void populatePersonas(String nombre) {
		this.personas = personaService.getBuscarPersonasPorNombre(nombre);
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
}
