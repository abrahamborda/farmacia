package org.abc.viewmodel;

import java.util.HashMap;
import java.util.Map;

import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.services.PersonaService;
import org.abc.services.UsuarioService;
import org.abc.utils.Parametros;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Notification;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class LoginVM {
	private final static Logger logger = LoggerFactory.getLogger(LoginVM.class);

	Usuario usuario;
	String mensaje;

	@WireVariable
	private UsuarioService usuarioService;
	@WireVariable
	private PersonaService personaService;
	
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@Init
	public void init() {
		usuario = new Usuario();
		usuario.setLogin("aaa");
		usuario.setClave("aaa");
	}

	@NotifyChange({ "usuario", "mensaje" })
	@Command
	public void submit() {
		Usuario usuarioLogin = usuarioService.getUsuarioLogin(usuario);
		if(usuarioLogin==null) {
			setMensaje("incorrecto");
			Notification.show("safsadf", "error", null, "middle_center", 1000, true);
//			Notification.show("incorrecto");
			return;
		}
		Persona persona=personaService.getPersonaId(usuarioLogin.getIdPersona());
		usuarioLogin.setPersona(persona);
		authenticationService.setUserCredential(usuarioLogin);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("persona", persona);
		Executions.sendRedirect(Parametros.URL_INDEX);
//		PrincipalVM principal = (PrincipalVM) Executions.createComponents("/pages/principal.zul", null, params);
//		principal.doModal();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
}
