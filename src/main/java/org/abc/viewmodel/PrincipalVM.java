package org.abc.viewmodel;

import java.util.ArrayList;

import org.abc.domain.Menu;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;

public class PrincipalVM {
	
	private AuthenticationService authenticationService=new AuthenticationServiceImpl();
	
	private ArrayList<Menu> listMenu;
	String currentPage;
	Usuario usuario;

	@Init
	public void init() {
		initMenu();
		usuario=authenticationService.getUserCredential();
		if(usuario==null)
			currentPage = "/pages/login.zul";
		else
			currentPage = "/pages/index2.zul";
	}

	public ArrayList<Menu> getListMenu() {
		return listMenu;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	@NotifyChange("currentPage")
	@Command
	public void cargar(@BindingParam("target") String targetPage) {
		currentPage = targetPage;
	}

	private void initMenu() {
		listMenu = new ArrayList<Menu>();
		addPage("Personas", "/persona.zul");
		addPage("Laboratorios", "/laboratorio.zul");
		addPage("Orders", "/index2.zul");
		addPage("Fan Service", "/index2.zul");
	}

	private void addPage(String title, String includeUri) {
		includeUri = "/pages" + includeUri;
		listMenu.add(new Menu(title, includeUri));
	}

	@Command
	public void logout() {
		authenticationService.logout();
		Executions.sendRedirect("/");
	}

	public Usuario getUsuario() {
		return usuario;
	}
	

}
