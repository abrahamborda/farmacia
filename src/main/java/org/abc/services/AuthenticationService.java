package org.abc.services;

import org.abc.domain.Usuario;

public interface AuthenticationService {
	public void setUserCredential(Usuario usuario);

	public void logout();

	public Usuario getUserCredential();
}
