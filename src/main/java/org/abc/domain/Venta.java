package org.abc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Venta {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.id_venta
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Integer idVenta;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.id_persona
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Integer idPersona;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.id_usuario
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Integer idUsuario;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.subtotal
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private BigDecimal subtotal;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.descuento
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private BigDecimal descuento;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.total
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private BigDecimal total;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.estado
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private String estado;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.fecha_reg
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Date fechaReg;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.fecha_mod
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Date fechaMod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.fecha
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Date fecha;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.venta.hora
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	private Date hora;
	
	private String nomPersona;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.id_venta
	 * @return  the value of public.venta.id_venta
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Integer getIdVenta() {
		return idVenta;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.id_venta
	 * @param idVenta  the value for public.venta.id_venta
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.id_persona
	 * @return  the value of public.venta.id_persona
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Integer getIdPersona() {
		return idPersona;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.id_persona
	 * @param idPersona  the value for public.venta.id_persona
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.id_usuario
	 * @return  the value of public.venta.id_usuario
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.id_usuario
	 * @param idUsuario  the value for public.venta.id_usuario
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.subtotal
	 * @return  the value of public.venta.subtotal
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public BigDecimal getSubtotal() {
		return subtotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.subtotal
	 * @param subtotal  the value for public.venta.subtotal
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.descuento
	 * @return  the value of public.venta.descuento
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public BigDecimal getDescuento() {
		return descuento;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.descuento
	 * @param descuento  the value for public.venta.descuento
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setDescuento(BigDecimal descuento) {
		this.descuento = descuento;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.total
	 * @return  the value of public.venta.total
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public BigDecimal getTotal() {
		return total;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.total
	 * @param total  the value for public.venta.total
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.estado
	 * @return  the value of public.venta.estado
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.estado
	 * @param estado  the value for public.venta.estado
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setEstado(String estado) {
		this.estado = estado == null ? null : estado.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.fecha_reg
	 * @return  the value of public.venta.fecha_reg
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Date getFechaReg() {
		return fechaReg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.fecha_reg
	 * @param fechaReg  the value for public.venta.fecha_reg
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.fecha_mod
	 * @return  the value of public.venta.fecha_mod
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Date getFechaMod() {
		return fechaMod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.fecha_mod
	 * @param fechaMod  the value for public.venta.fecha_mod
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setFechaMod(Date fechaMod) {
		this.fechaMod = fechaMod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.fecha
	 * @return  the value of public.venta.fecha
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.fecha
	 * @param fecha  the value for public.venta.fecha
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.venta.hora
	 * @return  the value of public.venta.hora
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public Date getHora() {
		return hora;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.venta.hora
	 * @param hora  the value for public.venta.hora
	 * @mbg.generated  Sat Sep 19 19:28:04 BOT 2020
	 */
	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getNomPersona() {
		return nomPersona;
	}

	public void setNomPersona(String nomPersona) {
		this.nomPersona = nomPersona;
	}
	
}