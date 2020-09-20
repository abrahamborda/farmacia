package org.abc.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoriaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public CategoriaExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
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

        public Criteria andIdCategoriaIsNull() {
            addCriterion("id_categoria is null");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaIsNotNull() {
            addCriterion("id_categoria is not null");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaEqualTo(Integer value) {
            addCriterion("id_categoria =", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotEqualTo(Integer value) {
            addCriterion("id_categoria <>", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaGreaterThan(Integer value) {
            addCriterion("id_categoria >", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_categoria >=", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaLessThan(Integer value) {
            addCriterion("id_categoria <", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaLessThanOrEqualTo(Integer value) {
            addCriterion("id_categoria <=", value, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaIn(List<Integer> values) {
            addCriterion("id_categoria in", values, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotIn(List<Integer> values) {
            addCriterion("id_categoria not in", values, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaBetween(Integer value1, Integer value2) {
            addCriterion("id_categoria between", value1, value2, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andIdCategoriaNotBetween(Integer value1, Integer value2) {
            addCriterion("id_categoria not between", value1, value2, "idCategoria");
            return (Criteria) this;
        }

        public Criteria andNombreIsNull() {
            addCriterion("nombre is null");
            return (Criteria) this;
        }

        public Criteria andNombreIsNotNull() {
            addCriterion("nombre is not null");
            return (Criteria) this;
        }

        public Criteria andNombreEqualTo(String value) {
            addCriterion("nombre =", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotEqualTo(String value) {
            addCriterion("nombre <>", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThan(String value) {
            addCriterion("nombre >", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreGreaterThanOrEqualTo(String value) {
            addCriterion("nombre >=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThan(String value) {
            addCriterion("nombre <", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLessThanOrEqualTo(String value) {
            addCriterion("nombre <=", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreLike(String value) {
            addCriterion("nombre like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotLike(String value) {
            addCriterion("nombre not like", value, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreIn(List<String> values) {
            addCriterion("nombre in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotIn(List<String> values) {
            addCriterion("nombre not in", values, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreBetween(String value1, String value2) {
            addCriterion("nombre between", value1, value2, "nombre");
            return (Criteria) this;
        }

        public Criteria andNombreNotBetween(String value1, String value2) {
            addCriterion("nombre not between", value1, value2, "nombre");
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
            addCriterion("estado =", value, "estado");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.categoria
     *
     * @mbg.generated do_not_delete_during_merge Thu Sep 17 20:11:30 BOT 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table public.categoria
     *
     * @mbg.generated Thu Sep 17 20:11:30 BOT 2020
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
}