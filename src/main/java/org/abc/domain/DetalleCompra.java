package org.abc.domain;

import java.math.BigDecimal;
import java.util.Date;

public class DetalleCompra {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.id_detalle_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Integer idDetalleCompra;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.id_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Integer idCompra;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.id_producto
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Integer idProducto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.cantidad
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Integer cantidad;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.precio_unitario
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private BigDecimal precioUnitario;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.importe
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private BigDecimal importe;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.nro_lote
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Integer nroLote;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.fec_vencimiento
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private Date fecVencimiento;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column public.detalle_compra.precio_venta
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	private BigDecimal precioVenta;
	private String detProducto;
	private Integer cntActual;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.id_detalle_compra
	 * @return  the value of public.detalle_compra.id_detalle_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Integer getIdDetalleCompra() {
		return idDetalleCompra;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.id_detalle_compra
	 * @param idDetalleCompra  the value for public.detalle_compra.id_detalle_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setIdDetalleCompra(Integer idDetalleCompra) {
		this.idDetalleCompra = idDetalleCompra;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.id_compra
	 * @return  the value of public.detalle_compra.id_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Integer getIdCompra() {
		return idCompra;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.id_compra
	 * @param idCompra  the value for public.detalle_compra.id_compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.id_producto
	 * @return  the value of public.detalle_compra.id_producto
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Integer getIdProducto() {
		return idProducto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.id_producto
	 * @param idProducto  the value for public.detalle_compra.id_producto
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.cantidad
	 * @return  the value of public.detalle_compra.cantidad
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Integer getCantidad() {
		return cantidad;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.cantidad
	 * @param cantidad  the value for public.detalle_compra.cantidad
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.precio_unitario
	 * @return  the value of public.detalle_compra.precio_unitario
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.precio_unitario
	 * @param precioUnitario  the value for public.detalle_compra.precio_unitario
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.importe
	 * @return  the value of public.detalle_compra.importe
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public BigDecimal getImporte() {
		return importe;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.importe
	 * @param importe  the value for public.detalle_compra.importe
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.nro_lote
	 * @return  the value of public.detalle_compra.nro_lote
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Integer getNroLote() {
		return nroLote;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.nro_lote
	 * @param nroLote  the value for public.detalle_compra.nro_lote
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.fec_vencimiento
	 * @return  the value of public.detalle_compra.fec_vencimiento
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Date getFecVencimiento() {
		return fecVencimiento;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.fec_vencimiento
	 * @param fecVencimiento  the value for public.detalle_compra.fec_vencimiento
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setFecVencimiento(Date fecVencimiento) {
		this.fecVencimiento = fecVencimiento;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column public.detalle_compra.precio_venta
	 * @return  the value of public.detalle_compra.precio_venta
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column public.detalle_compra.precio_venta
	 * @param precioVenta  the value for public.detalle_compra.precio_venta
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getDetProducto() {
		return detProducto;
	}

	public void setDetProducto(String detProducto) {
		this.detProducto = detProducto;
	}

	public Integer getCntActual() {
		return cntActual;
	}

	public void setCntActual(Integer cntActual) {
		this.cntActual = cntActual;
	}
	
	
}