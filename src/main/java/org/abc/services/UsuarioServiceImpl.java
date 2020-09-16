package org.abc.services;

import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Usuario;
import org.abc.domain.UsuarioExample;
import org.abc.mapper.UsuarioMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("usuarioService")
public class UsuarioServiceImpl implements UsuarioService {

	@Resource
	private UsuarioMapper usuarioMapper;

	@Override
	public List<Usuario> getTodosUsuarios() {
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		return usuarioMapper.selectByExample(example);
	}

	@Override
	public void actualizarUsuario(Usuario prd) {
		usuarioMapper.updateByPrimaryKey(prd);
	}

	@Override
	public void eliminarUsuario(Integer id) {
		usuarioMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Usuario getUsuarioId(Integer id) {
		return usuarioMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarUsuario(Usuario prd) {
		usuarioMapper.insert(prd);
	}

	@Override
	public Usuario getUsuarioLogin(Usuario usuario) {
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andLoginEqualTo(usuario.getLogin()).andClaveEqualTo(usuario.getClave())
				.andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		try {
			return usuarioMapper.selectByExample(example).get(0);
		} catch (Exception e) {
			return null;
		}
	}
}
