package org.abc.services;

import org.abc.domain.Persona;
import org.abc.domain.Usuario;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public void setUserCredential(Usuario usuario) {
        Session sess = Sessions.getCurrent();
        sess.setAttribute("usuario",usuario);
	}

	@Override
	public void logout() {
		Session sess = Sessions.getCurrent();
		sess.removeAttribute("usuario");
	}

	@Override
	public Usuario getUserCredential() {
		Session sess = Sessions.getCurrent();
		Usuario usuario = (Usuario) sess.getAttribute("usuario");
		/*if (usuario == null) {
			usuario = new Usuario();// new a anonymous user and set to session
			sess.setAttribute("usuario", usuario);
		}*/
		return usuario;
	}
}
