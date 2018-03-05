
--
-- TOC entry 196 (class 1259 OID 25180)
-- Name: lotes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE lotes (
    id_lote bigint NOT NULL,
    tipo text,
    valor text,
    precio double precision,
    foto text,
    anno bigint,
    conservacion text,
    serie text,
    estrellas text,
    fecha_lote text,
    id_subasta bigint
);


ALTER TABLE lotes OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 25186)
-- Name: Lotes_sampleid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Lotes_sampleid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Lotes_sampleid_seq" OWNER TO postgres;

--
-- TOC entry 3158 (class 0 OID 0)
-- Dependencies: 197
-- Name: Lotes_sampleid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Lotes_sampleid_seq" OWNED BY lotes.id_lote;


--
-- TOC entry 203 (class 1259 OID 25251)
-- Name: Puja_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Puja_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Puja_seq" OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 25188)
-- Name: subastas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE subastas (
    id_subasta bigint NOT NULL,
    titulo text,
    finalizacion date
);


ALTER TABLE subastas OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 25194)
-- Name: Subastas_sampleid_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Subastas_sampleid_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Subastas_sampleid_seq" OWNER TO postgres;

--
-- TOC entry 3159 (class 0 OID 0)
-- Dependencies: 199
-- Name: Subastas_sampleid_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Subastas_sampleid_seq" OWNED BY subastas.id_subasta;


--
-- TOC entry 200 (class 1259 OID 25196)
-- Name: pagos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pagos (
    id_pago bigint NOT NULL,
    email character varying,
    id_puja bigint
);


ALTER TABLE pagos OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 25202)
-- Name: pujas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE pujas (
    id_puja bigint DEFAULT nextval('"Puja_seq"'::regclass) NOT NULL,
    id_lote bigint,
    email character varying,
    importe bigint,
    fecha date
);


ALTER TABLE pujas OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 25208)
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE usuarios (
    email character varying NOT NULL,
    contrasenna character varying,
    nombre character varying,
    apellidos character varying,
    telefono bigint,
    ciudad character varying,
    cod_postal bigint,
    dni character varying,
    calle character varying,
    admin boolean,
    cod_seguridad bigint,
    tipo_tarjeta character varying,
    num_tarjeta character varying
);


ALTER TABLE usuarios OWNER TO postgres;

--
-- TOC entry 3012 (class 2604 OID 25214)
-- Name: lotes id_lote; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lotes ALTER COLUMN id_lote SET DEFAULT nextval('"Lotes_sampleid_seq"'::regclass);


--
-- TOC entry 3013 (class 2604 OID 25215)
-- Name: subastas id_subasta; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY subastas ALTER COLUMN id_subasta SET DEFAULT nextval('"Subastas_sampleid_seq"'::regclass);


--
-- TOC entry 3016 (class 2606 OID 25217)
-- Name: lotes Lotes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lotes
    ADD CONSTRAINT "Lotes_pkey" PRIMARY KEY (id_lote);


--
-- TOC entry 3018 (class 2606 OID 25219)
-- Name: subastas Subastas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY subastas
    ADD CONSTRAINT "Subastas_pkey" PRIMARY KEY (id_subasta);


--
-- TOC entry 3020 (class 2606 OID 25221)
-- Name: pagos pagos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT pagos_pkey PRIMARY KEY (id_pago);


--
-- TOC entry 3022 (class 2606 OID 25254)
-- Name: pujas pujas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pujas
    ADD CONSTRAINT pujas_pkey PRIMARY KEY (id_puja);


--
-- TOC entry 3024 (class 2606 OID 25225)
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (email);


--
-- TOC entry 3025 (class 2606 OID 25226)
-- Name: lotes fk_subasta; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lotes
    ADD CONSTRAINT fk_subasta FOREIGN KEY (id_subasta) REFERENCES subastas(id_subasta);


--
-- TOC entry 3026 (class 2606 OID 25231)
-- Name: pagos pagos_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT pagos_email_fkey FOREIGN KEY (email) REFERENCES usuarios(email);


--
-- TOC entry 3027 (class 2606 OID 25255)
-- Name: pagos pagos_id_puja_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pagos
    ADD CONSTRAINT pagos_id_puja_fkey FOREIGN KEY (id_puja) REFERENCES pujas(id_puja);


--
-- TOC entry 3028 (class 2606 OID 25241)
-- Name: pujas pujas_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pujas
    ADD CONSTRAINT pujas_email_fkey FOREIGN KEY (email) REFERENCES usuarios(email);


--
-- TOC entry 3029 (class 2606 OID 25246)
-- Name: pujas pujas_id_lote_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY pujas
    ADD CONSTRAINT pujas_id_lote_fkey FOREIGN KEY (id_lote) REFERENCES lotes(id_lote);


-- Completed on 2018-01-16 15:27:37 CET

--
-- PostgreSQL database dump complete
--

