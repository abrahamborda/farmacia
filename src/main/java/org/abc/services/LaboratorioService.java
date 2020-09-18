package org.abc.services;

import java.util.List;

import org.abc.domain.Laboratorio;

public interface LaboratorioService {
	List<Laboratorio> getTodosLaboratorios();
    void actualizarLaboratorio(Laboratorio prd);
    void eliminarLaboratorio(Integer id);
    public Laboratorio getLaboratorioId(Integer id);
    public void insertarLaboratorio(Laboratorio prd);
}
