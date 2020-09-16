package org.abc.utils;

import org.zkoss.bind.BindContext;
import org.zkoss.bind.Converter;
import org.zkoss.zk.ui.Component;

public class BooleanConverter implements Converter{
	/**
	 * convertir de boolean a string
	 */
	@Override
	public Object coerceToUi(Object beanProp, Component component, BindContext ctx) {
//		final String format = (String) ctx.getConverterArg("format");
//        if (format == null) throw new NullPointerException("format attribute not found");
        final Boolean boolean1 = (Boolean) beanProp;
        return boolean1 == null ? null : boolean1 ?Parametros.SI:Parametros.NO;
	}
	/**
	 * convertir de string a boolean 
	 */
	@Override
	public Object coerceToBean(Object compAttr, Component component, BindContext ctx) {
//		final String format = (String) ctx.getConverterArg("format");
//        if (format == null) throw new NullPointerException("format attribute not found");
        final String date = (String) compAttr;
        return date == null ? null : date.equals(Parametros.SI)?true:false;
	}

	

}
