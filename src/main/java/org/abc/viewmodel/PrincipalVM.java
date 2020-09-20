package org.abc.viewmodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.abc.domain.Menu;
import org.abc.domain.Usuario;
import org.abc.services.AuthenticationService;
import org.abc.services.AuthenticationServiceImpl;
import org.abc.utils.Parametros;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Window;

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
			currentPage = Parametros.URL_ZUL+"/login.zul";
		else
			currentPage = Parametros.URL_ZUL+"/index2.zul";
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
		addPage("Laboratorios", "/laboratorio.zul");
		addPage("Personas", "/persona.zul");
//		addPage("Buscar Personas", "/buscar_persona.zul");
		addPage("Productos", "/producto.zul");
//		addPage("Buscar Productos", "/buscar_producto.zul");
		addPage("Compras", "/compra.zul");
<<<<<<< HEAD
		addPage("Ventas", "/venta.zul");
=======
//		addPage("Detalle Compra", "/editar_compra.zul");
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
	}

	private void addPage(String title, String includeUri) {
		includeUri = Parametros.URL_ZUL + includeUri;
		listMenu.add(new Menu(title, includeUri));
	}

	@Command
	public void logout() {
		authenticationService.logout();
		Executions.sendRedirect(Parametros.URL_INDEX);
	}

	public Usuario getUsuario() {
		return usuario;
	}
	

}
