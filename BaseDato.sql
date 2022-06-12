--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

-- Started on 2022-06-12 10:01:44 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'WIN1250';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3279 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 201 (class 1259 OID 33395)
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id bigint NOT NULL,
    direccion character varying(100) NOT NULL,
    edad integer NOT NULL,
    genero character varying(1) NOT NULL,
    identificacion character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    telefono character varying(10) NOT NULL,
    contrasenia character varying(255) NOT NULL,
    estado boolean NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 33393)
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cliente_id_seq OWNER TO postgres;

--
-- TOC entry 3280 (class 0 OID 0)
-- Dependencies: 200
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- TOC entry 203 (class 1259 OID 33403)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta (
    numero_cuenta bigint NOT NULL,
    cliente_id integer NOT NULL,
    estado boolean NOT NULL,
    saldo_inicial numeric(19,2) NOT NULL,
    tipo_cuenta character varying(255) NOT NULL
);


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 33401)
-- Name: cuenta_numero_cuenta_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cuenta_numero_cuenta_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cuenta_numero_cuenta_seq OWNER TO postgres;

--
-- TOC entry 3281 (class 0 OID 0)
-- Dependencies: 202
-- Name: cuenta_numero_cuenta_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cuenta_numero_cuenta_seq OWNED BY public.cuenta.numero_cuenta;


--
-- TOC entry 205 (class 1259 OID 33424)
-- Name: movimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movimiento (
    id_movimientos bigint NOT NULL,
    fecha timestamp without time zone NOT NULL,
    numero_cuenta bigint NOT NULL,
    saldo numeric(19,2) NOT NULL,
    tipo_movimiento character varying(1) NOT NULL,
    valor numeric(19,2) NOT NULL
);


ALTER TABLE public.movimiento OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 33422)
-- Name: movimiento_id_movimientos_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movimiento_id_movimientos_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movimiento_id_movimientos_seq OWNER TO postgres;

--
-- TOC entry 3282 (class 0 OID 0)
-- Dependencies: 204
-- Name: movimiento_id_movimientos_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movimiento_id_movimientos_seq OWNED BY public.movimiento.id_movimientos;


--
-- TOC entry 3127 (class 2604 OID 33398)
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- TOC entry 3128 (class 2604 OID 33406)
-- Name: cuenta numero_cuenta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta ALTER COLUMN numero_cuenta SET DEFAULT nextval('public.cuenta_numero_cuenta_seq'::regclass);


--
-- TOC entry 3129 (class 2604 OID 33427)
-- Name: movimiento id_movimientos; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento ALTER COLUMN id_movimientos SET DEFAULT nextval('public.movimiento_id_movimientos_seq'::regclass);


--
-- TOC entry 3269 (class 0 OID 33395)
-- Dependencies: 201
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, direccion, edad, genero, identificacion, nombre, telefono, contrasenia, estado) FROM stdin;
1	Villagomes	20	F	0907765637	Jenny	0982734845	123	t
5	Texas	55	M	0907765637	Efrain	0982734845	123	t
6	Villagomes	20	F	0907765637	Jenny	0982734845	123	t
7	Texas	34	M	0907765637	Efrain P	0982734845	123	t
8	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
9	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
10	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
11	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
12	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
13	Texas	60	M	0907765637	Peter	0982734845	123	t
14	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
15	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
16	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
17	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
18	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
19	Av. de la Republica	35	M	0606654567	TestUno	0987676787	1234	t
\.


--
-- TOC entry 3271 (class 0 OID 33403)
-- Dependencies: 203
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cuenta (numero_cuenta, cliente_id, estado, saldo_inicial, tipo_cuenta) FROM stdin;
3	1	t	1000.00	C
1	5	t	200.00	A
4	5	t	200.00	C
5	6	t	200.00	C
7	6	t	200.00	A
8	7	t	200.00	A
9	7	t	200.00	C
12	9	t	450.00	A
13	12	t	450.00	A
15	12	t	10000.00	C
16	13	t	50000.00	A
17	14	t	10000.00	C
18	14	t	10000.00	A
19	19	t	10000.00	A
\.


--
-- TOC entry 3273 (class 0 OID 33424)
-- Dependencies: 205
-- Data for Name: movimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movimiento (id_movimientos, fecha, numero_cuenta, saldo, tipo_movimiento, valor) FROM stdin;
2	2022-01-01 00:00:00	1	1020.00	D	530.00
3	2022-01-01 00:00:00	4	10202.00	D	300.00
4	2022-06-11 16:10:23.898663	4	9902.00	R	-300.00
5	2022-06-11 16:12:54.638052	4	9402.00	R	-500.00
7	2022-06-11 16:51:32.918809	4	10402.00	D	1000.00
8	2022-06-11 16:55:22.028168	4	10212.00	R	-190.00
9	2022-06-11 16:56:22.14609	4	10203.00	R	-9.00
10	2022-06-11 22:26:08.885895	1	1010.00	R	-10.00
11	2022-06-11 22:27:25.587409	1	1020.00	D	10.00
12	2022-06-11 22:28:29.209353	1	1010.00	R	-10.00
13	2022-06-11 22:35:27.087034	1	1000.00	R	-10.00
14	2022-06-11 22:39:59.943604	1	990.00	R	-10.00
15	2022-06-11 22:44:01.649544	15	9700.00	R	-300.00
16	2022-06-11 22:55:04.865575	16	49001.00	R	-999.00
17	2022-06-11 22:57:03.566876	1	980.00	R	-10.00
18	2022-06-11 23:01:11.69991	17	9000.00	R	-1000.00
19	2022-06-11 23:01:57.058884	18	9000.00	R	-1000.00
20	2022-06-11 23:13:14.096192	1	970.00	R	-10.00
21	2022-06-12 07:19:12.318432	1	960.00	R	-10.00
22	2022-06-12 07:20:08.642788	18	8988.00	R	-12.00
23	2022-06-12 08:04:51.394764	1	950.00	R	-10.00
24	2022-06-12 08:05:35.768388	1	940.00	R	-10.00
25	2022-06-12 08:19:24.358007	1	930.00	R	-10.00
\.


--
-- TOC entry 3283 (class 0 OID 0)
-- Dependencies: 200
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 19, true);


--
-- TOC entry 3284 (class 0 OID 0)
-- Dependencies: 202
-- Name: cuenta_numero_cuenta_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cuenta_numero_cuenta_seq', 19, true);


--
-- TOC entry 3285 (class 0 OID 0)
-- Dependencies: 204
-- Name: movimiento_id_movimientos_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movimiento_id_movimientos_seq', 25, true);


--
-- TOC entry 3131 (class 2606 OID 33400)
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- TOC entry 3133 (class 2606 OID 33408)
-- Name: cuenta cuenta_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pkey PRIMARY KEY (numero_cuenta);


--
-- TOC entry 3135 (class 2606 OID 33429)
-- Name: movimiento movimiento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT movimiento_pkey PRIMARY KEY (id_movimientos);


--
-- TOC entry 3136 (class 2606 OID 33645)
-- Name: cuenta fk_cuenta_cliete; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT fk_cuenta_cliete FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


--
-- TOC entry 3137 (class 2606 OID 33430)
-- Name: movimiento fkk10u787s9re28fue9gdscb5kt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movimiento
    ADD CONSTRAINT fkk10u787s9re28fue9gdscb5kt FOREIGN KEY (numero_cuenta) REFERENCES public.cuenta(numero_cuenta);


-- Completed on 2022-06-12 10:01:45 -05

--
-- PostgreSQL database dump complete
--

