package org.abc.services;

import java.util.Map;

import org.abc.domain.Usuario;
import org.abc.utils.Parametros;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Initiator;

public class AuthenticationInit implements Initiator {

	private AuthenticationService authenticationService=new AuthenticationServiceImpl();

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		Usuario usuario = authenticationService.getUserCredential();
		if (usuario == null) {
			Executions.sendRedirect(Parametros.URL_INDEX);
			return;
		}

	}

}
