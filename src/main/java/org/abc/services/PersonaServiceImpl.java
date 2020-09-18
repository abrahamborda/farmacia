package org.abc.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.abc.domain.Persona;
import org.abc.domain.PersonaExample;
import org.abc.mapper.PersonaMapper;
import org.abc.utils.Parametros;
import org.springframework.stereotype.Service;

@Service("personaService")
public class PersonaServiceImpl implements PersonaService {

	@Resource
	private PersonaMapper personaMapper;

	@Override
	public List<Persona> getTodosPersonas() {
		PersonaExample example = new PersonaExample();
		example.createCriteria().andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("ap,am,nombre");
		return personaMapper.selectByExample(example);
	}
	
	@Override
	public List<Persona> getBuscarPersonasPorNombre(String nombre) {
		if(nombre.trim().equals(""))
			return new ArrayList<Persona>();
		PersonaExample example = new PersonaExample();
		example.createCriteria().andNombreLike("%"+(nombre.replaceAll("\\s","%")).toUpperCase()+"%").andEstadoEqualTo(Parametros.ESTADO_ACTIVO);
		example.setOrderByClause("nombre");
		return personaMapper.selectByExample(example);
	}

	@Override
	public void actualizarPersona(Persona prd) {
		prd.setFechaMod(new Date());
		personaMapper.updateByPrimaryKey(prd);
	}

	@Override
	public void eliminarPersona(Integer id) {
		personaMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Persona getPersonaId(Integer id) {
		return personaMapper.selectByPrimaryKey(id);
	}

	@Override
	public void insertarPersona(Persona prd) {
		personaMapper.insertSelective(prd);
	}
}
