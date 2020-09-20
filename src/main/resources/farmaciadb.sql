--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.20
-- Dumped by pg_dump version 9.4.20
<<<<<<< HEAD
-- Started on 2020-09-19 21:26:57
=======
-- Started on 2020-09-19 13:27:48
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11855)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
<<<<<<< HEAD
-- TOC entry 2131 (class 0 OID 0)
=======
-- TOC entry 2126 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 178 (class 1259 OID 522731009)
-- Name: categoria; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.categoria (
    id_categoria integer NOT NULL,
    nombre character varying NOT NULL,
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone
);


ALTER TABLE public.categoria OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 522731007)
-- Name: categoria_id_categoria_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.categoria_id_categoria_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.categoria_id_categoria_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2132 (class 0 OID 0)
=======
-- TOC entry 2127 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 177
-- Name: categoria_id_categoria_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.categoria_id_categoria_seq OWNED BY public.categoria.id_categoria;


--
-- TOC entry 184 (class 1259 OID 522731069)
-- Name: compra; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.compra (
    id_compra integer NOT NULL,
    id_persona integer NOT NULL,
    id_usuario integer NOT NULL,
    total numeric(10,2),
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone,
    fecha date,
    hora time with time zone
);


ALTER TABLE public.compra OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 522731067)
-- Name: compra_id_compra_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compra_id_compra_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compra_id_compra_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2133 (class 0 OID 0)
=======
-- TOC entry 2128 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 183
-- Name: compra_id_compra_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.compra_id_compra_seq OWNED BY public.compra.id_compra;


--
-- TOC entry 186 (class 1259 OID 522731089)
-- Name: detalle_compra; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.detalle_compra (
    id_detalle_compra integer NOT NULL,
    id_compra integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario numeric(10,2) NOT NULL,
    importe numeric(10,2) NOT NULL,
    nro_lote integer,
    fec_vencimiento date,
    precio_venta numeric(10,2)
);


ALTER TABLE public.detalle_compra OWNER TO postgres;

--
-- TOC entry 190 (class 1259 OID 522731127)
-- Name: detalle_venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.detalle_venta (
    id_detalle_venta integer NOT NULL,
    id_venta integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario numeric(10,2) NOT NULL,
    importe numeric(10,2) NOT NULL,
    id_detalle_compra integer NOT NULL
);


ALTER TABLE public.detalle_venta OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 522763935)
-- Name: det_compra_inventario; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.det_compra_inventario AS
 SELECT dc.id_detalle_compra,
    dc.id_compra,
    dc.id_producto,
    dc.cantidad,
    dc.precio_unitario,
    dc.importe,
    dc.nro_lote,
    dc.fec_vencimiento,
    dc.precio_venta,
    (dc.cantidad - (sum(
        CASE
            WHEN (dv.cantidad IS NULL) THEN 0
            ELSE dv.cantidad
        END))::integer) AS cnt_actual
   FROM (public.detalle_compra dc
     LEFT JOIN public.detalle_venta dv ON ((dc.id_detalle_compra = dv.id_detalle_compra)))
  GROUP BY dc.id_detalle_compra, dc.id_compra, dc.id_producto, dc.cantidad, dc.precio_unitario, dc.importe, dc.nro_lote, dc.fec_vencimiento, dc.precio_venta
 HAVING (dc.cantidad > sum(
        CASE
            WHEN (dv.cantidad IS NULL) THEN 0
            ELSE dv.cantidad
        END));


ALTER TABLE public.det_compra_inventario OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 522731087)
-- Name: detalle_compra_id_detalle_compra_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_compra_id_detalle_compra_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_compra_id_detalle_compra_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2134 (class 0 OID 0)
=======
-- TOC entry 2129 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 185
-- Name: detalle_compra_id_detalle_compra_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalle_compra_id_detalle_compra_seq OWNED BY public.detalle_compra.id_detalle_compra;


--
<<<<<<< HEAD
=======
-- TOC entry 190 (class 1259 OID 522731127)
-- Name: detalle_venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.detalle_venta (
    id_detalle_venta integer NOT NULL,
    id_venta integer NOT NULL,
    id_producto integer NOT NULL,
    cantidad integer NOT NULL,
    precio_unitario numeric(10,2) NOT NULL,
    importe numeric(10,2) NOT NULL,
    id_detalle_compra integer
);


ALTER TABLE public.detalle_venta OWNER TO postgres;

--
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- TOC entry 189 (class 1259 OID 522731125)
-- Name: detalle_venta_id_detalle_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.detalle_venta_id_detalle_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.detalle_venta_id_detalle_venta_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2135 (class 0 OID 0)
=======
-- TOC entry 2130 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 189
-- Name: detalle_venta_id_detalle_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.detalle_venta_id_detalle_venta_seq OWNED BY public.detalle_venta.id_detalle_venta;


--
-- TOC entry 180 (class 1259 OID 522731022)
-- Name: laboratorio; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.laboratorio (
    id_laboratorio integer NOT NULL,
    id_usuario integer NOT NULL,
    nombre character varying NOT NULL,
    telefono character varying NOT NULL,
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone
);


ALTER TABLE public.laboratorio OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 522731020)
-- Name: laboratorio_id_laboratorio_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.laboratorio_id_laboratorio_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.laboratorio_id_laboratorio_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2136 (class 0 OID 0)
=======
-- TOC entry 2131 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 179
-- Name: laboratorio_id_laboratorio_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.laboratorio_id_laboratorio_seq OWNED BY public.laboratorio.id_laboratorio;


--
-- TOC entry 176 (class 1259 OID 522730996)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.persona (
    id_persona integer NOT NULL,
    id_usuario integer NOT NULL,
    nombre character varying NOT NULL,
    ap character varying NOT NULL,
    am character varying,
    telefono character varying,
    direccion character varying,
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 522730994)
-- Name: persona_id_persona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.persona_id_persona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.persona_id_persona_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2137 (class 0 OID 0)
=======
-- TOC entry 2132 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 175
-- Name: persona_id_persona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.persona_id_persona_seq OWNED BY public.persona.id_persona;


--
-- TOC entry 182 (class 1259 OID 522731040)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.producto (
    id_producto integer NOT NULL,
    id_categoria integer NOT NULL,
    id_laboratorio integer NOT NULL,
    id_usuario integer NOT NULL,
    principio character varying NOT NULL,
    presentacion character varying NOT NULL,
    unidad_medida character varying NOT NULL,
    cantidad integer DEFAULT 0,
    descripcion character varying NOT NULL,
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 522731038)
-- Name: producto_id_producto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.producto_id_producto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.producto_id_producto_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2138 (class 0 OID 0)
=======
-- TOC entry 2133 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 181
-- Name: producto_id_producto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.producto_id_producto_seq OWNED BY public.producto.id_producto;


--
-- TOC entry 174 (class 1259 OID 522730983)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.usuario (
    id_usuario integer NOT NULL,
    id_persona integer NOT NULL,
    login character varying NOT NULL,
    clave character varying NOT NULL,
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 522730981)
-- Name: usuario_id_usuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuario_id_usuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_id_usuario_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2139 (class 0 OID 0)
=======
-- TOC entry 2134 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 173
-- Name: usuario_id_usuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuario_id_usuario_seq OWNED BY public.usuario.id_usuario;


--
-- TOC entry 188 (class 1259 OID 522731107)
-- Name: venta; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE public.venta (
    id_venta integer NOT NULL,
    id_persona integer,
    id_usuario integer NOT NULL,
    subtotal numeric(10,2),
    descuento numeric(10,2),
    total numeric(10,2),
    estado character(1) DEFAULT 'A'::bpchar,
    fecha_reg timestamp with time zone DEFAULT now(),
    fecha_mod timestamp with time zone,
    fecha date,
    hora time with time zone
);


ALTER TABLE public.venta OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 522731105)
-- Name: venta_id_venta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.venta_id_venta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.venta_id_venta_seq OWNER TO postgres;

--
<<<<<<< HEAD
-- TOC entry 2140 (class 0 OID 0)
=======
-- TOC entry 2135 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 187
-- Name: venta_id_venta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.venta_id_venta_seq OWNED BY public.venta.id_venta;


--
-- TOC entry 1944 (class 2604 OID 522731012)
-- Name: id_categoria; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.categoria ALTER COLUMN id_categoria SET DEFAULT nextval('public.categoria_id_categoria_seq'::regclass);


--
-- TOC entry 1954 (class 2604 OID 522731072)
-- Name: id_compra; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra ALTER COLUMN id_compra SET DEFAULT nextval('public.compra_id_compra_seq'::regclass);


--
-- TOC entry 1957 (class 2604 OID 522731092)
-- Name: id_detalle_compra; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_compra ALTER COLUMN id_detalle_compra SET DEFAULT nextval('public.detalle_compra_id_detalle_compra_seq'::regclass);


--
-- TOC entry 1961 (class 2604 OID 522731130)
-- Name: id_detalle_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta ALTER COLUMN id_detalle_venta SET DEFAULT nextval('public.detalle_venta_id_detalle_venta_seq'::regclass);


--
-- TOC entry 1947 (class 2604 OID 522731025)
-- Name: id_laboratorio; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laboratorio ALTER COLUMN id_laboratorio SET DEFAULT nextval('public.laboratorio_id_laboratorio_seq'::regclass);


--
-- TOC entry 1941 (class 2604 OID 522730999)
-- Name: id_persona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona ALTER COLUMN id_persona SET DEFAULT nextval('public.persona_id_persona_seq'::regclass);


--
-- TOC entry 1950 (class 2604 OID 522731043)
-- Name: id_producto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto ALTER COLUMN id_producto SET DEFAULT nextval('public.producto_id_producto_seq'::regclass);


--
-- TOC entry 1938 (class 2604 OID 522730986)
-- Name: id_usuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario ALTER COLUMN id_usuario SET DEFAULT nextval('public.usuario_id_usuario_seq'::regclass);


--
-- TOC entry 1958 (class 2604 OID 522731110)
-- Name: id_venta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta ALTER COLUMN id_venta SET DEFAULT nextval('public.venta_id_venta_seq'::regclass);


--
<<<<<<< HEAD
-- TOC entry 2110 (class 0 OID 522731009)
=======
-- TOC entry 2105 (class 0 OID 522731009)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 178
-- Data for Name: categoria; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.categoria (id_categoria, nombre, estado, fecha_reg, fecha_mod) FROM stdin;
1	CAT 	A	2020-09-17 20:10:41.053-04	\N
2	FFFFFFFF	A	2020-09-17 20:10:48.939-04	\N
3	TTTTTTTTTT	A	2020-09-17 20:10:50.99-04	\N
<<<<<<< HEAD
\.


--
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 177
-- Name: categoria_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.categoria_id_categoria_seq', 3, true);


--
-- TOC entry 2116 (class 0 OID 522731069)
-- Dependencies: 184
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.compra (id_compra, id_persona, id_usuario, total, estado, fecha_reg, fecha_mod, fecha, hora) FROM stdin;
3	2	1	77.00	A	2020-09-18 22:14:30.722-04	2020-09-19 13:06:40.033-04	2020-09-10	19:00:00-04
1	1	1	135.00	A	2020-09-18 14:53:40.367-04	2020-09-19 13:18:25.276-04	2020-09-18	19:15:00-04
5	1	1	0.00	A	2020-09-19 21:19:56.701-04	\N	2020-09-19	\N
=======
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
\.


--
<<<<<<< HEAD
-- TOC entry 2142 (class 0 OID 0)
-- Dependencies: 183
-- Name: compra_id_compra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
=======
-- TOC entry 2136 (class 0 OID 0)
-- Dependencies: 177
-- Name: categoria_id_categoria_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
--

<<<<<<< HEAD
SELECT pg_catalog.setval('public.compra_id_compra_seq', 5, true);
=======
SELECT pg_catalog.setval('public.categoria_id_categoria_seq', 3, true);
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git


--
<<<<<<< HEAD
-- TOC entry 2118 (class 0 OID 522731089)
-- Dependencies: 186
-- Data for Name: detalle_compra; Type: TABLE DATA; Schema: public; Owner: postgres
=======
-- TOC entry 2111 (class 0 OID 522731069)
-- Dependencies: 184
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: postgres
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
--

<<<<<<< HEAD
COPY public.detalle_compra (id_detalle_compra, id_compra, id_producto, cantidad, precio_unitario, importe, nro_lote, fec_vencimiento, precio_venta) FROM stdin;
12	1	5	1	4.00	4.00	234	2020-09-18	4.00
9	3	5	1	33.00	33.00	234	2020-09-02	3.00
11	3	5	1	44.00	44.00	2343	2020-09-09	2.40
10	1	4	2	44.00	88.00	123456	2020-10-28	4.50
7	1	5	1	43.00	43.00	45	2020-08-31	3.00
=======
COPY public.compra (id_compra, id_persona, id_usuario, total, estado, fecha_reg, fecha_mod, fecha, hora) FROM stdin;
3	2	1	77.00	A	2020-09-18 22:14:30.722-04	2020-09-19 13:06:40.033-04	2020-09-10	19:00:00-04
1	1	1	135.00	A	2020-09-18 14:53:40.367-04	2020-09-19 13:18:25.276-04	2020-09-18	19:15:00-04
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
\.


--
<<<<<<< HEAD
-- TOC entry 2143 (class 0 OID 0)
-- Dependencies: 185
-- Name: detalle_compra_id_detalle_compra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
=======
-- TOC entry 2137 (class 0 OID 0)
-- Dependencies: 183
-- Name: compra_id_compra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
--

<<<<<<< HEAD
SELECT pg_catalog.setval('public.detalle_compra_id_detalle_compra_seq', 12, true);
=======
SELECT pg_catalog.setval('public.compra_id_compra_seq', 4, true);
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git


--
<<<<<<< HEAD
-- TOC entry 2122 (class 0 OID 522731127)
-- Dependencies: 190
-- Data for Name: detalle_venta; Type: TABLE DATA; Schema: public; Owner: postgres
=======
-- TOC entry 2113 (class 0 OID 522731089)
-- Dependencies: 186
-- Data for Name: detalle_compra; Type: TABLE DATA; Schema: public; Owner: postgres
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
--

<<<<<<< HEAD
COPY public.detalle_venta (id_detalle_venta, id_venta, id_producto, cantidad, precio_unitario, importe, id_detalle_compra) FROM stdin;
3	2	5	22	2.40	52.80	11
4	2	5	2	3.00	6.00	7
=======
COPY public.detalle_compra (id_detalle_compra, id_compra, id_producto, cantidad, precio_unitario, importe, nro_lote, fec_vencimiento, precio_venta) FROM stdin;
12	1	5	1	4.00	4.00	234	2020-09-18	4.00
9	3	5	1	33.00	33.00	234	2020-09-02	3.00
11	3	5	1	44.00	44.00	2343	2020-09-09	2.40
10	1	4	2	44.00	88.00	123456	2020-10-28	4.50
7	1	5	1	43.00	43.00	45	2020-08-31	3.00
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
\.


--
<<<<<<< HEAD
-- TOC entry 2144 (class 0 OID 0)
=======
-- TOC entry 2138 (class 0 OID 0)
-- Dependencies: 185
-- Name: detalle_compra_id_detalle_compra_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_compra_id_detalle_compra_seq', 12, true);


--
-- TOC entry 2117 (class 0 OID 522731127)
-- Dependencies: 190
-- Data for Name: detalle_venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.detalle_venta (id_detalle_venta, id_venta, id_producto, cantidad, precio_unitario, importe, id_detalle_compra) FROM stdin;
\.


--
-- TOC entry 2139 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 189
-- Name: detalle_venta_id_detalle_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.detalle_venta_id_detalle_venta_seq', 4, true);


--
<<<<<<< HEAD
-- TOC entry 2112 (class 0 OID 522731022)
=======
-- TOC entry 2107 (class 0 OID 522731022)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 180
-- Data for Name: laboratorio; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.laboratorio (id_laboratorio, id_usuario, nombre, telefono, estado, fecha_reg, fecha_mod) FROM stdin;
1	1	gdfsgs	23424	A	2020-09-15 17:15:25.937-04	\N
2	1	erwere	324	A	2020-09-15 17:16:28.32-04	\N
\.


--
<<<<<<< HEAD
-- TOC entry 2145 (class 0 OID 0)
=======
-- TOC entry 2140 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 179
-- Name: laboratorio_id_laboratorio_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.laboratorio_id_laboratorio_seq', 2, true);


--
<<<<<<< HEAD
-- TOC entry 2108 (class 0 OID 522730996)
=======
-- TOC entry 2103 (class 0 OID 522730996)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 176
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id_persona, id_usuario, nombre, ap, am, telefono, direccion, estado, fecha_reg, fecha_mod) FROM stdin;
1	1	AAA	BBB	JJJJ	2345	FRKJ	A	2020-09-15 16:55:04.319-04	2020-09-17 20:06:18.636-04
2	1	AAASD	ASD				A	2020-09-17 13:03:56.934-04	2020-09-18 10:36:25.138-04
<<<<<<< HEAD
\.


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 175
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_persona_seq', 2, true);


--
-- TOC entry 2114 (class 0 OID 522731040)
-- Dependencies: 182
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id_producto, id_categoria, id_laboratorio, id_usuario, principio, presentacion, unidad_medida, cantidad, descripcion, estado, fecha_reg, fecha_mod) FROM stdin;
5	1	2	1	SFF	white	black	67	SADF	A	2020-09-17 22:55:22.747-04	\N
4	2	2	1	ASDF	blue	white	3	FASDF	A	\N	\N
=======
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
\.


--
<<<<<<< HEAD
-- TOC entry 2147 (class 0 OID 0)
=======
-- TOC entry 2141 (class 0 OID 0)
-- Dependencies: 175
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_persona_seq', 2, true);


--
-- TOC entry 2109 (class 0 OID 522731040)
-- Dependencies: 182
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.producto (id_producto, id_categoria, id_laboratorio, id_usuario, principio, presentacion, unidad_medida, cantidad, descripcion, estado, fecha_reg, fecha_mod) FROM stdin;
5	1	2	1	SFF	white	black	67	SADF	A	2020-09-17 22:55:22.747-04	\N
4	2	2	1	ASDF	blue	white	3	FASDF	A	\N	\N
\.


--
-- TOC entry 2142 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 181
-- Name: producto_id_producto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.producto_id_producto_seq', 7, true);


--
<<<<<<< HEAD
-- TOC entry 2106 (class 0 OID 522730983)
=======
-- TOC entry 2101 (class 0 OID 522730983)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 174
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id_usuario, id_persona, login, clave, estado, fecha_reg, fecha_mod) FROM stdin;
1	1	aaa	aaa	A	2020-09-15 16:55:20.263-04	\N
\.


--
<<<<<<< HEAD
-- TOC entry 2148 (class 0 OID 0)
=======
-- TOC entry 2143 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 173
-- Name: usuario_id_usuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuario_id_usuario_seq', 1, true);


--
<<<<<<< HEAD
-- TOC entry 2120 (class 0 OID 522731107)
=======
-- TOC entry 2115 (class 0 OID 522731107)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 188
-- Data for Name: venta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.venta (id_venta, id_persona, id_usuario, subtotal, descuento, total, estado, fecha_reg, fecha_mod, fecha, hora) FROM stdin;
1	1	1	\N	\N	6.00	A	2020-09-19 19:36:18.623-04	2020-09-19 19:53:26.247-04	2020-09-19	12:02:00-04
2	2	1	\N	\N	58.80	A	2020-09-19 19:51:31.674-04	2020-09-19 21:04:52.391-04	2020-09-19	19:51:00-04
3	2	1	\N	\N	0.00	A	2020-09-19 21:13:39.902-04	2020-09-19 21:13:52.791-04	2020-09-19	21:13:00-04
\.


--
<<<<<<< HEAD
-- TOC entry 2149 (class 0 OID 0)
=======
-- TOC entry 2144 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 187
-- Name: venta_id_venta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.venta_id_venta_seq', 3, true);


--
-- TOC entry 1967 (class 2606 OID 522731019)
-- Name: categoria_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.categoria
    ADD CONSTRAINT categoria_pkey PRIMARY KEY (id_categoria);


--
-- TOC entry 1973 (class 2606 OID 522731076)
-- Name: compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (id_compra);


--
-- TOC entry 1975 (class 2606 OID 522731094)
-- Name: detalle_compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.detalle_compra
    ADD CONSTRAINT detalle_compra_pkey PRIMARY KEY (id_detalle_compra);


--
-- TOC entry 1979 (class 2606 OID 522731132)
-- Name: detalle_venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_pkey PRIMARY KEY (id_detalle_venta);


--
-- TOC entry 1969 (class 2606 OID 522731032)
-- Name: laboratorio_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.laboratorio
    ADD CONSTRAINT laboratorio_pkey PRIMARY KEY (id_laboratorio);


--
-- TOC entry 1965 (class 2606 OID 522731006)
-- Name: persona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id_persona);


--
-- TOC entry 1971 (class 2606 OID 522731051)
-- Name: producto_pkey1; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey1 PRIMARY KEY (id_producto);


--
-- TOC entry 1963 (class 2606 OID 522730993)
-- Name: usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario);


--
-- TOC entry 1977 (class 2606 OID 522731114)
-- Name: venta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_pkey PRIMARY KEY (id_venta);


--
-- TOC entry 1986 (class 2606 OID 522731077)
-- Name: compra_id_persona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_id_persona_fkey FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona);


--
-- TOC entry 1987 (class 2606 OID 522731082)
-- Name: compra_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 1988 (class 2606 OID 522731095)
-- Name: detalle_compra_id_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_compra
    ADD CONSTRAINT detalle_compra_id_compra_fkey FOREIGN KEY (id_compra) REFERENCES public.compra(id_compra);


--
-- TOC entry 1989 (class 2606 OID 522731100)
-- Name: detalle_compra_id_producto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_compra
    ADD CONSTRAINT detalle_compra_id_producto_fkey FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);


--
<<<<<<< HEAD
-- TOC entry 1994 (class 2606 OID 522747546)
-- Name: detalle_venta_id_detalle_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_id_detalle_compra_fkey FOREIGN KEY (id_detalle_compra) REFERENCES public.detalle_compra(id_detalle_compra);


--
-- TOC entry 1992 (class 2606 OID 522731133)
=======
-- TOC entry 1990 (class 2606 OID 522747546)
-- Name: detalle_venta_id_detalle_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_id_detalle_compra_fkey FOREIGN KEY (id_detalle_compra) REFERENCES public.detalle_compra(id_detalle_compra);


--
-- TOC entry 1988 (class 2606 OID 522731133)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Name: detalle_venta_id_producto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_id_producto_fkey FOREIGN KEY (id_producto) REFERENCES public.producto(id_producto);


--
-- TOC entry 1993 (class 2606 OID 522731138)
-- Name: detalle_venta_id_venta_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.detalle_venta
    ADD CONSTRAINT detalle_venta_id_venta_fkey FOREIGN KEY (id_venta) REFERENCES public.venta(id_venta);


--
-- TOC entry 1982 (class 2606 OID 522731154)
-- Name: laboratorio_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.laboratorio
    ADD CONSTRAINT laboratorio_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 1981 (class 2606 OID 522731149)
-- Name: persona_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 1983 (class 2606 OID 522731052)
-- Name: producto_id_categoria_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_categoria_fkey FOREIGN KEY (id_categoria) REFERENCES public.categoria(id_categoria);


--
-- TOC entry 1984 (class 2606 OID 522731057)
-- Name: producto_id_laboratorio_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_laboratorio_fkey FOREIGN KEY (id_laboratorio) REFERENCES public.laboratorio(id_laboratorio);


--
-- TOC entry 1985 (class 2606 OID 522731062)
-- Name: producto_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
-- TOC entry 1980 (class 2606 OID 522731144)
-- Name: usuario_id_persona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_id_persona_fkey FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona);


--
-- TOC entry 1990 (class 2606 OID 522731115)
-- Name: venta_id_persona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_id_persona_fkey FOREIGN KEY (id_persona) REFERENCES public.persona(id_persona);


--
-- TOC entry 1991 (class 2606 OID 522731120)
-- Name: venta_id_usuario_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.venta
    ADD CONSTRAINT venta_id_usuario_fkey FOREIGN KEY (id_usuario) REFERENCES public.usuario(id_usuario);


--
<<<<<<< HEAD
-- TOC entry 2130 (class 0 OID 0)
=======
-- TOC entry 2125 (class 0 OID 0)
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


<<<<<<< HEAD
-- Completed on 2020-09-19 21:26:57
=======
-- Completed on 2020-09-19 13:27:48
>>>>>>> branch 'master' of https://github.com/abrahamborda/farmacia.git

--
-- PostgreSQL database dump complete
--

