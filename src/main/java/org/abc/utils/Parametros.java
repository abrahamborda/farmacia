package org.abc.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.IsA;

public class Parametros {
	public static String ESTADO_ACTIVO = "A";
	public static String ESTADO_ELIMINADO = "X";
	public static String SI = "Si";
	public static String NO = "No";
	public static String VERDADERO = "Verdadero";
	public static String FALSO = "Falso";
	public static int DIAS_COMPRA = -30;
	public static String URL_ZUL= "/pages";
	public static String URL_INDEX= "/";

	private static List<String> unidadesMedidas = new ArrayList<String>();
	private static List<String> presentaciones = new ArrayList<String>();
	static {
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

	public static String getStringLike(String str) {
		if (str != null)
			return "%" + (str.replaceAll("\\s", "%")).toUpperCase() + "%";
		else
			return "%";
	}

	public static Date getFechaActual() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.getTime();
	}

	public static Date getSumasDiasFecha(Date date, int dias) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

}
