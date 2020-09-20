package org.abc.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CompraExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public CompraExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value.getTime()), property);
		}

		protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Time> timeList = new ArrayList<>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				timeList.add(new java.sql.Time(iter.next().getTime()));
			}
			addCriterion(condition, timeList, property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
		}

		public Criteria andIdCompraIsNull() {
			addCriterion("id_compra is null");
			return (Criteria) this;
		}

		public Criteria andIdCompraIsNotNull() {
			addCriterion("id_compra is not null");
			return (Criteria) this;
		}

		public Criteria andIdCompraEqualTo(Integer value) {
			addCriterion("id_compra =", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraNotEqualTo(Integer value) {
			addCriterion("id_compra <>", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraGreaterThan(Integer value) {
			addCriterion("id_compra >", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_compra >=", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraLessThan(Integer value) {
			addCriterion("id_compra <", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraLessThanOrEqualTo(Integer value) {
			addCriterion("id_compra <=", value, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraIn(List<Integer> values) {
			addCriterion("id_compra in", values, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraNotIn(List<Integer> values) {
			addCriterion("id_compra not in", values, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraBetween(Integer value1, Integer value2) {
			addCriterion("id_compra between", value1, value2, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdCompraNotBetween(Integer value1, Integer value2) {
			addCriterion("id_compra not between", value1, value2, "idCompra");
			return (Criteria) this;
		}

		public Criteria andIdPersonaIsNull() {
			addCriterion("id_persona is null");
			return (Criteria) this;
		}

		public Criteria andIdPersonaIsNotNull() {
			addCriterion("id_persona is not null");
			return (Criteria) this;
		}

		public Criteria andIdPersonaEqualTo(Integer value) {
			addCriterion("id_persona =", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaNotEqualTo(Integer value) {
			addCriterion("id_persona <>", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaGreaterThan(Integer value) {
			addCriterion("id_persona >", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_persona >=", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaLessThan(Integer value) {
			addCriterion("id_persona <", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaLessThanOrEqualTo(Integer value) {
			addCriterion("id_persona <=", value, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaIn(List<Integer> values) {
			addCriterion("id_persona in", values, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaNotIn(List<Integer> values) {
			addCriterion("id_persona not in", values, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaBetween(Integer value1, Integer value2) {
			addCriterion("id_persona between", value1, value2, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdPersonaNotBetween(Integer value1, Integer value2) {
			addCriterion("id_persona not between", value1, value2, "idPersona");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioIsNull() {
			addCriterion("id_usuario is null");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioIsNotNull() {
			addCriterion("id_usuario is not null");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioEqualTo(Integer value) {
			addCriterion("id_usuario =", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioNotEqualTo(Integer value) {
			addCriterion("id_usuario <>", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioGreaterThan(Integer value) {
			addCriterion("id_usuario >", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioGreaterThanOrEqualTo(Integer value) {
			addCriterion("id_usuario >=", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioLessThan(Integer value) {
			addCriterion("id_usuario <", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioLessThanOrEqualTo(Integer value) {
			addCriterion("id_usuario <=", value, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioIn(List<Integer> values) {
			addCriterion("id_usuario in", values, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioNotIn(List<Integer> values) {
			addCriterion("id_usuario not in", values, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioBetween(Integer value1, Integer value2) {
			addCriterion("id_usuario between", value1, value2, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andIdUsuarioNotBetween(Integer value1, Integer value2) {
			addCriterion("id_usuario not between", value1, value2, "idUsuario");
			return (Criteria) this;
		}

		public Criteria andTotalIsNull() {
			addCriterion("total is null");
			return (Criteria) this;
		}

		public Criteria andTotalIsNotNull() {
			addCriterion("total is not null");
			return (Criteria) this;
		}

		public Criteria andTotalEqualTo(BigDecimal value) {
			addCriterion("total =", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotEqualTo(BigDecimal value) {
			addCriterion("total <>", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThan(BigDecimal value) {
			addCriterion("total >", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("total >=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThan(BigDecimal value) {
			addCriterion("total <", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalLessThanOrEqualTo(BigDecimal value) {
			addCriterion("total <=", value, "total");
			return (Criteria) this;
		}

		public Criteria andTotalIn(List<BigDecimal> values) {
			addCriterion("total in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotIn(List<BigDecimal> values) {
			addCriterion("total not in", values, "total");
			return (Criteria) this;
		}

		public Criteria andTotalBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andTotalNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("total not between", value1, value2, "total");
			return (Criteria) this;
		}

		public Criteria andEstadoIsNull() {
			addCriterion("estado is null");
			return (Criteria) this;
		}

		public Criteria andEstadoIsNotNull() {
			addCriterion("estado is not null");
			return (Criteria) this;
		}

		public Criteria andEstadoEqualTo(String value) {
			addCriterion("compra.estado =", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoNotEqualTo(String value) {
			addCriterion("estado <>", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoGreaterThan(String value) {
			addCriterion("estado >", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoGreaterThanOrEqualTo(String value) {
			addCriterion("estado >=", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoLessThan(String value) {
			addCriterion("estado <", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoLessThanOrEqualTo(String value) {
			addCriterion("estado <=", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoLike(String value) {
			addCriterion("estado like", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoNotLike(String value) {
			addCriterion("estado not like", value, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoIn(List<String> values) {
			addCriterion("estado in", values, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoNotIn(List<String> values) {
			addCriterion("estado not in", values, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoBetween(String value1, String value2) {
			addCriterion("estado between", value1, value2, "estado");
			return (Criteria) this;
		}

		public Criteria andEstadoNotBetween(String value1, String value2) {
			addCriterion("estado not between", value1, value2, "estado");
			return (Criteria) this;
		}

		public Criteria andFechaRegIsNull() {
			addCriterion("fecha_reg is null");
			return (Criteria) this;
		}

		public Criteria andFechaRegIsNotNull() {
			addCriterion("fecha_reg is not null");
			return (Criteria) this;
		}

		public Criteria andFechaRegEqualTo(Date value) {
			addCriterion("fecha_reg =", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegNotEqualTo(Date value) {
			addCriterion("fecha_reg <>", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegGreaterThan(Date value) {
			addCriterion("fecha_reg >", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegGreaterThanOrEqualTo(Date value) {
			addCriterion("fecha_reg >=", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegLessThan(Date value) {
			addCriterion("fecha_reg <", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegLessThanOrEqualTo(Date value) {
			addCriterion("fecha_reg <=", value, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegIn(List<Date> values) {
			addCriterion("fecha_reg in", values, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegNotIn(List<Date> values) {
			addCriterion("fecha_reg not in", values, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegBetween(Date value1, Date value2) {
			addCriterion("fecha_reg between", value1, value2, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaRegNotBetween(Date value1, Date value2) {
			addCriterion("fecha_reg not between", value1, value2, "fechaReg");
			return (Criteria) this;
		}

		public Criteria andFechaModIsNull() {
			addCriterion("fecha_mod is null");
			return (Criteria) this;
		}

		public Criteria andFechaModIsNotNull() {
			addCriterion("fecha_mod is not null");
			return (Criteria) this;
		}

		public Criteria andFechaModEqualTo(Date value) {
			addCriterion("fecha_mod =", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModNotEqualTo(Date value) {
			addCriterion("fecha_mod <>", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModGreaterThan(Date value) {
			addCriterion("fecha_mod >", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModGreaterThanOrEqualTo(Date value) {
			addCriterion("fecha_mod >=", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModLessThan(Date value) {
			addCriterion("fecha_mod <", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModLessThanOrEqualTo(Date value) {
			addCriterion("fecha_mod <=", value, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModIn(List<Date> values) {
			addCriterion("fecha_mod in", values, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModNotIn(List<Date> values) {
			addCriterion("fecha_mod not in", values, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModBetween(Date value1, Date value2) {
			addCriterion("fecha_mod between", value1, value2, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaModNotBetween(Date value1, Date value2) {
			addCriterion("fecha_mod not between", value1, value2, "fechaMod");
			return (Criteria) this;
		}

		public Criteria andFechaIsNull() {
			addCriterion("fecha is null");
			return (Criteria) this;
		}

		public Criteria andFechaIsNotNull() {
			addCriterion("fecha is not null");
			return (Criteria) this;
		}

		public Criteria andFechaEqualTo(Date value) {
			addCriterionForJDBCDate("fecha =", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaNotEqualTo(Date value) {
			addCriterionForJDBCDate("fecha <>", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaGreaterThan(Date value) {
			addCriterionForJDBCDate("fecha >", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("fecha >=", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaLessThan(Date value) {
			addCriterionForJDBCDate("fecha <", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("fecha <=", value, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaIn(List<Date> values) {
			addCriterionForJDBCDate("fecha in", values, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaNotIn(List<Date> values) {
			addCriterionForJDBCDate("fecha not in", values, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("fecha between", value1, value2, "fecha");
			return (Criteria) this;
		}

		public Criteria andFechaNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("fecha not between", value1, value2, "fecha");
			return (Criteria) this;
		}

		public Criteria andHoraIsNull() {
			addCriterion("hora is null");
			return (Criteria) this;
		}

		public Criteria andHoraIsNotNull() {
			addCriterion("hora is not null");
			return (Criteria) this;
		}

		public Criteria andHoraEqualTo(Date value) {
			addCriterionForJDBCTime("hora =", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraNotEqualTo(Date value) {
			addCriterionForJDBCTime("hora <>", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraGreaterThan(Date value) {
			addCriterionForJDBCTime("hora >", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("hora >=", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraLessThan(Date value) {
			addCriterionForJDBCTime("hora <", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraLessThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("hora <=", value, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraIn(List<Date> values) {
			addCriterionForJDBCTime("hora in", values, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraNotIn(List<Date> values) {
			addCriterionForJDBCTime("hora not in", values, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("hora between", value1, value2, "hora");
			return (Criteria) this;
		}

		public Criteria andHoraNotBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("hora not between", value1, value2, "hora");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table public.compra
	 * @mbg.generated  Fri Sep 18 15:30:47 BOT 2020
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.compra
     *
     * @mbg.generated do_not_delete_during_merge Fri Sep 18 11:02:07 BOT 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}