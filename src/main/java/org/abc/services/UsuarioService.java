package org.abc.services;

import java.util.List;

import org.abc.domain.Usuario;

public interface UsuarioService {
	List<Usuario> getTodosUsuarios();
    void actualizarUsuario(Usuario prd);
    void eliminarUsuario(Integer id);
    public Usuario getUsuarioId(Integer id);
    public void insertarUsuario(Usuario prd);
    public Usuario getUsuarioLogin(Usuario usuario);
}
