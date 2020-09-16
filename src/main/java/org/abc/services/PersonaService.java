package org.abc.services;

import java.util.List;

import org.abc.domain.Persona;

import net.learntechnology.empmaint.domain.Employee;

public interface PersonaService {
	List<Persona> getTodosPersonas();
    void actualizarPersona(Persona prd);
    void eliminarPersona(Integer id);
    public Persona getPersonaId(Integer id);
    public void insertarPersona(Persona prd);
}
