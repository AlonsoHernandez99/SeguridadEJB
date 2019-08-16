--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.3
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE segds;
--
-- Name: segds; Type: DATABASE; Schema: -; Owner: segds
--

CREATE DATABASE segds WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_El Salvador.1252' LC_CTYPE = 'Spanish_El Salvador.1252';


ALTER DATABASE segds OWNER TO segds;

\connect segds

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: sec_mds_modulos_sistemas; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_mds_modulos_sistemas (
    mds_id integer NOT NULL,
    mds_nombre character varying(50),
    mds_orden integer NOT NULL,
    sis_id integer
);


ALTER TABLE sec_mds_modulos_sistemas OWNER TO segds;

--
-- Name: sec_opm_opciones_menu; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_opm_opciones_menu (
    opm_id integer NOT NULL,
    opm_comando character varying(500),
    opm_estado character varying(3),
    opm_etiqueta character varying(100),
    opm_orden integer NOT NULL,
    mds_id integer,
    opm_padre integer
);


ALTER TABLE sec_opm_opciones_menu OWNER TO segds;

--
-- Name: sec_opr_opciones_roles; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_opr_opciones_roles (
    opr_id integer NOT NULL,
    opm_id integer,
    rol_id integer
);


ALTER TABLE sec_opr_opciones_roles OWNER TO segds;

--
-- Name: sec_par_parametros; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_par_parametros (
    par_codigo character varying(20) NOT NULL,
    par_descripcion character varying(100),
    par_valor character varying(200)
);


ALTER TABLE sec_par_parametros OWNER TO segds;

--
-- Name: sec_rol_roles; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_rol_roles (
    rol_id integer NOT NULL,
    rol_estado character varying(3),
    rol_nombre character varying(50),
    sis_id integer
);


ALTER TABLE sec_rol_roles OWNER TO segds;

--
-- Name: sec_rou_roles_usuarios; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_rou_roles_usuarios (
    rou_id integer NOT NULL,
    rol_id integer,
    usr_codigo character varying(255)
);


ALTER TABLE sec_rou_roles_usuarios OWNER TO segds;

--
-- Name: sec_sis_sistemas; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_sis_sistemas (
    sis_id integer NOT NULL,
    sis_codigo character varying(30),
    sis_nombre character varying(50)
);


ALTER TABLE sec_sis_sistemas OWNER TO segds;

--
-- Name: sec_usr_usuarios; Type: TABLE; Schema: public; Owner: segds
--

CREATE TABLE sec_usr_usuarios (
    usr_codigo character varying(20) NOT NULL,
    usr_clave character varying(255) NOT NULL,
    usr_correo character varying(100),
    usr_estado character varying(3),
    usr_fecha_ingreso date,
    usr_nombre character varying(60)
);


ALTER TABLE sec_usr_usuarios OWNER TO segds;

--
-- Name: seq_mdsid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_mdsid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_mdsid_pk OWNER TO segds;

--
-- Name: seq_opmid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_opmid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_opmid_pk OWNER TO segds;

--
-- Name: seq_oprid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_oprid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_oprid_pk OWNER TO segds;

--
-- Name: seq_rolid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_rolid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_rolid_pk OWNER TO segds;

--
-- Name: seq_rouid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_rouid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_rouid_pk OWNER TO segds;

--
-- Name: seq_sisid_pk; Type: SEQUENCE; Schema: public; Owner: segds
--

CREATE SEQUENCE seq_sisid_pk
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE seq_sisid_pk OWNER TO segds;

--
-- Data for Name: sec_mds_modulos_sistemas; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_mds_modulos_sistemas VALUES (5, 'Configuración', 1, 2);
INSERT INTO sec_mds_modulos_sistemas VALUES (6, 'Operación', 2, 2);
INSERT INTO sec_mds_modulos_sistemas VALUES (7, 'Reportes', 4, 2);
INSERT INTO sec_mds_modulos_sistemas VALUES (8, 'Catálogos', 3, 2);


--
-- Data for Name: sec_opm_opciones_menu; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_opm_opciones_menu VALUES (3, '#', 'ACT', 'Ingredientes', 1, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (4, '#', 'ACT', 'Productos', 2, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (5, '#', 'ACT', 'Opciones de Menú', 3, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (6, '#', 'ACT', 'Menús', 4, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (7, '#', 'ACT', 'Tiendas', 5, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (8, '#', 'ACT', 'Equivalencias Aloha', 6, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (9, '#', 'ACT', 'Parámetros', 7, 5, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (10, '#', 'ACT', 'Bloqueo de Productos', 1, 6, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (11, '#', 'ACT', 'Clientes', 2, 6, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (12, '#', 'ACT', 'Departamentos y Municipios', 1, 8, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (13, '#', 'ACT', 'Colonias y Zonas', 2, 8, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (14, '#', 'ACT', 'Categorías de Productos', 3, 8, NULL);
INSERT INTO sec_opm_opciones_menu VALUES (15, '#', 'ACT', 'Tomar Pedido', 3, 6, NULL);


--
-- Data for Name: sec_opr_opciones_roles; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_opr_opciones_roles VALUES (3, 5, 1);
INSERT INTO sec_opr_opciones_roles VALUES (4, 6, 1);
INSERT INTO sec_opr_opciones_roles VALUES (5, 8, 1);
INSERT INTO sec_opr_opciones_roles VALUES (6, 3, 1);
INSERT INTO sec_opr_opciones_roles VALUES (7, 9, 1);
INSERT INTO sec_opr_opciones_roles VALUES (8, 7, 1);
INSERT INTO sec_opr_opciones_roles VALUES (9, 4, 1);
INSERT INTO sec_opr_opciones_roles VALUES (10, 10, 1);
INSERT INTO sec_opr_opciones_roles VALUES (11, 11, 1);
INSERT INTO sec_opr_opciones_roles VALUES (12, 13, 1);
INSERT INTO sec_opr_opciones_roles VALUES (13, 12, 1);
INSERT INTO sec_opr_opciones_roles VALUES (14, 14, 1);
INSERT INTO sec_opr_opciones_roles VALUES (15, 11, 5);
INSERT INTO sec_opr_opciones_roles VALUES (16, 10, 5);
INSERT INTO sec_opr_opciones_roles VALUES (17, 14, 5);
INSERT INTO sec_opr_opciones_roles VALUES (18, 12, 5);
INSERT INTO sec_opr_opciones_roles VALUES (19, 13, 5);
INSERT INTO sec_opr_opciones_roles VALUES (20, 15, 6);


--
-- Data for Name: sec_par_parametros; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_par_parametros VALUES ('mail_host', 'Servidor de correo.', 'smtp.gmail.com');
INSERT INTO sec_par_parametros VALUES ('mail_host_port', 'Puerto en el que escucha el servidor de correo.', '587');
INSERT INTO sec_par_parametros VALUES ('email', 'correo.', 'email');
INSERT INTO sec_par_parametros VALUES ('password', 'contraseña del correo.', 'pass');


--
-- Data for Name: sec_rol_roles; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_rol_roles VALUES (1, 'ACT', 'Gerente', 2);
INSERT INTO sec_rol_roles VALUES (5, 'ACT', 'Supervisor', 2);
INSERT INTO sec_rol_roles VALUES (6, 'ACT', 'Operador', 2);


--
-- Data for Name: sec_rou_roles_usuarios; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_rou_roles_usuarios VALUES (1, 1, 'DESAA');
INSERT INTO sec_rou_roles_usuarios VALUES (2, 5, 'SPRVSR');
INSERT INTO sec_rou_roles_usuarios VALUES (3, 6, 'OPR');


--
-- Data for Name: sec_sis_sistemas; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_sis_sistemas VALUES (2, 'LAILAI-CALL', 'CALL CENTER LAILAI');


--
-- Data for Name: sec_usr_usuarios; Type: TABLE DATA; Schema: public; Owner: segds
--

INSERT INTO sec_usr_usuarios VALUES ('DESAA', 'e9383d72a53549b50f6b6c9e306b54e23f361a0a5233573948d0895e9264618234c53f838106bd7c2fa0398a0bbd62fd15fbb894622a3984e38e539694732d87', 'workgroup115@gmail.com', 'ACT', '2018-01-12', 'ADMIN');
INSERT INTO sec_usr_usuarios VALUES ('SPRVSR', '0d270351d0a6f47593f744ecc0dfed3af66ccaf39c228b53d525143ec09f2ba1d8e752d1be8cfe284fca918c657d033a1633cbb7b118c14960a57a2e96866118', 'workgroup115@gmail.com', 'ACT', '2018-01-12', 'Sup 01');
INSERT INTO sec_usr_usuarios VALUES ('OPR', 'c622d8edfa96c562096a4fcffd81a98e7ec252c4fa65555814e0497a9c1e3773077447664ef87b4874780bbd8464049d676c8845cb3f113f47da04dc8ffdcd5f', 'workgroup115@gmail.com', 'ACT', '2018-01-12', 'Op 01');


--
-- Name: seq_mdsid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_mdsid_pk', 8, true);


--
-- Name: seq_opmid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_opmid_pk', 15, true);


--
-- Name: seq_oprid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_oprid_pk', 20, true);


--
-- Name: seq_rolid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_rolid_pk', 6, true);


--
-- Name: seq_rouid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_rouid_pk', 3, true);


--
-- Name: seq_sisid_pk; Type: SEQUENCE SET; Schema: public; Owner: segds
--

SELECT pg_catalog.setval('seq_sisid_pk', 2, true);


--
-- Name: sec_mds_modulos_sistemas sec_mds_modulos_sistemas_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_mds_modulos_sistemas
    ADD CONSTRAINT sec_mds_modulos_sistemas_pkey PRIMARY KEY (mds_id);


--
-- Name: sec_opm_opciones_menu sec_opm_opciones_menu_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opm_opciones_menu
    ADD CONSTRAINT sec_opm_opciones_menu_pkey PRIMARY KEY (opm_id);


--
-- Name: sec_opr_opciones_roles sec_opr_opciones_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opr_opciones_roles
    ADD CONSTRAINT sec_opr_opciones_roles_pkey PRIMARY KEY (opr_id);


--
-- Name: sec_par_parametros sec_par_parametros_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_par_parametros
    ADD CONSTRAINT sec_par_parametros_pkey PRIMARY KEY (par_codigo);


--
-- Name: sec_rol_roles sec_rol_roles_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_rol_roles
    ADD CONSTRAINT sec_rol_roles_pkey PRIMARY KEY (rol_id);


--
-- Name: sec_rou_roles_usuarios sec_rou_roles_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_rou_roles_usuarios
    ADD CONSTRAINT sec_rou_roles_usuarios_pkey PRIMARY KEY (rou_id);


--
-- Name: sec_sis_sistemas sec_sis_sistemas_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_sis_sistemas
    ADD CONSTRAINT sec_sis_sistemas_pkey PRIMARY KEY (sis_id);


--
-- Name: sec_usr_usuarios sec_usr_usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_usr_usuarios
    ADD CONSTRAINT sec_usr_usuarios_pkey PRIMARY KEY (usr_codigo);


--
-- Name: sec_opr_opciones_roles fk15x9scgx4yg0uuoq33olf3kn7; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opr_opciones_roles
    ADD CONSTRAINT fk15x9scgx4yg0uuoq33olf3kn7 FOREIGN KEY (rol_id) REFERENCES sec_rol_roles(rol_id);


--
-- Name: sec_mds_modulos_sistemas fk6kf08mqsnowclpclmoleiefo3; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_mds_modulos_sistemas
    ADD CONSTRAINT fk6kf08mqsnowclpclmoleiefo3 FOREIGN KEY (sis_id) REFERENCES sec_sis_sistemas(sis_id);


--
-- Name: sec_opm_opciones_menu fkeoc4877fnmh63rlfk2q97ynuu; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opm_opciones_menu
    ADD CONSTRAINT fkeoc4877fnmh63rlfk2q97ynuu FOREIGN KEY (mds_id) REFERENCES sec_mds_modulos_sistemas(mds_id);


--
-- Name: sec_opr_opciones_roles fkg3367h128f6ytyo1ad9hg5sp0; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opr_opciones_roles
    ADD CONSTRAINT fkg3367h128f6ytyo1ad9hg5sp0 FOREIGN KEY (opm_id) REFERENCES sec_opm_opciones_menu(opm_id);


--
-- Name: sec_rol_roles fkhaqyx1mpvqcuv41gpmwabgiop; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_rol_roles
    ADD CONSTRAINT fkhaqyx1mpvqcuv41gpmwabgiop FOREIGN KEY (sis_id) REFERENCES sec_sis_sistemas(sis_id);


--
-- Name: sec_rou_roles_usuarios fkn82xrk0fbgxmi8mtq63gd3ols; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_rou_roles_usuarios
    ADD CONSTRAINT fkn82xrk0fbgxmi8mtq63gd3ols FOREIGN KEY (rol_id) REFERENCES sec_rol_roles(rol_id);


--
-- Name: sec_rou_roles_usuarios fktbjb9bepjjn7riev75codmlp1; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_rou_roles_usuarios
    ADD CONSTRAINT fktbjb9bepjjn7riev75codmlp1 FOREIGN KEY (usr_codigo) REFERENCES sec_usr_usuarios(usr_codigo);


--
-- Name: sec_opm_opciones_menu fkye4cjgd8hrd8gciapvpk2s14; Type: FK CONSTRAINT; Schema: public; Owner: segds
--

ALTER TABLE ONLY sec_opm_opciones_menu
    ADD CONSTRAINT fkye4cjgd8hrd8gciapvpk2s14 FOREIGN KEY (opm_padre) REFERENCES sec_opm_opciones_menu(opm_id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

