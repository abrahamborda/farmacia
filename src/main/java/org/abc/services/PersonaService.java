package org.abc.services;

import java.util.List;

import org.abc.domain.Persona;

public interface PersonaService {
	List<Persona> getTodosPersonas();
    void actualizarPersona(Persona prd);
    void eliminarPersona(Integer id);
    public Persona getPersonaId(Integer id);
    public void insertarPersona(Persona prd);
}
