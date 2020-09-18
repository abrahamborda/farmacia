package org.abc.utils;

import java.util.ArrayList;
import java.util.List;

public class Parametros {
	public static String ESTADO_ACTIVO="A";
	public static String ESTADO_ELIMINADO="X";
	public static String SI="Si";
	public static String NO="No";
	public static String VERDADERO="Verdadero";
	public static String FALSO="Falso";
	
	private static List<String> unidadesMedidas=new ArrayList<String>();
	private static List<String> presentaciones=new ArrayList<String>();
	static{
		unidadesMedidas.add("blue");
		unidadesMedidas.add("black");
		unidadesMedidas.add("white");
		
		presentaciones.add("blue");
		presentaciones.add("black");
		presentaciones.add("white");
	}
	
	public static final List<String> getUnidadesMedidas() {
        return new ArrayList<String>(unidadesMedidas);
    }

	public static final List<String> getPresentaciones() {
		return new ArrayList<String>(presentaciones);
	}
	
	
}
