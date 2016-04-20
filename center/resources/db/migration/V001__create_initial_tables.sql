--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.1
-- Dumped by pg_dump version 9.5.1

--
-- Name: balkon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE balkon (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: balkon_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE balkon_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: client; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE client (
    id bigint NOT NULL,
    isactive boolean,
    name character varying(255) NOT NULL
);


--
-- Name: client_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE client_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: device; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE device (
    id bigint NOT NULL,
    isactive boolean,
    number character varying(255) NOT NULL,
    client_id bigint NOT NULL
);


--
-- Name: device_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE device_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_rent_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_rent_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_sale_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_sale_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_sanuzel_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_sanuzel_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_sostoyaniye_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_sostoyaniye_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_telefon_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_telefon_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: dom_tip_stroyeniya_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dom_tip_stroyeniya_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: domrent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    kakogorojen character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    vysotapotolkov double precision,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    elektrichestvo_id bigint,
    gaz_id bigint,
    internet_id bigint,
    kanalizaciya_id bigint,
    otopleniye_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    voda_id bigint,
    kaksdayete_id bigint
);


--
-- Name: domrent_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    kakogorojen character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    vysotapotolkov double precision,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    elektrichestvo_id bigint,
    gaz_id bigint,
    internet_id bigint,
    kanalizaciya_id bigint,
    otopleniye_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    voda_id bigint,
    kaksdayete_id bigint
);


--
-- Name: domrent_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_photopaths (
    domrent_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: domrent_photopaths_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_photopaths_aud (
    rev integer NOT NULL,
    domrent_id bigint NOT NULL,
    photopaths character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: domrent_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_telnumbers (
    domrent_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: domrent_telnumbers_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_telnumbers_aud (
    rev integer NOT NULL,
    domrent_id bigint NOT NULL,
    telnumbers character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: domsale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    kakogorojen character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    vysotapotolkov double precision,
    iszalog boolean,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    elektrichestvo_id bigint,
    gaz_id bigint,
    internet_id bigint,
    kanalizaciya_id bigint,
    otopleniye_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    voda_id bigint
);


--
-- Name: domsale_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    kakogorojen character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    vysotapotolkov double precision,
    iszalog boolean,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    elektrichestvo_id bigint,
    gaz_id bigint,
    internet_id bigint,
    kanalizaciya_id bigint,
    otopleniye_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    voda_id bigint
);


--
-- Name: domsale_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_photopaths (
    domsale_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: domsale_photopaths_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_photopaths_aud (
    rev integer NOT NULL,
    domsale_id bigint NOT NULL,
    photopaths character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: domsale_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_telnumbers (
    domsale_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: domsale_telnumbers_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_telnumbers_aud (
    rev integer NOT NULL,
    domsale_id bigint NOT NULL,
    telnumbers character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: domsanuzel; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsanuzel (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: domsostoyaniye; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsostoyaniye (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: domtelefon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domtelefon (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: domtipstroyeniya; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domtipstroyeniya (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: dver; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE dver (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: dver_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE dver_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: elektrichestvo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE elektrichestvo (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: elektrichestvo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE elektrichestvo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: gaz; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE gaz (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: gaz_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE gaz_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: internet; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE internet (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: internet_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE internet_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: istochnik_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE istochnik_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: istochnikinfo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE istochnikinfo (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kak_sdayete_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kak_sdayete_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kaksdayete; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kaksdayete (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kanalizaciya; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kanalizaciya (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kanalizaciya_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kanalizaciya_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_rent_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_rent_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_sale_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_sale_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_sanuzel_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_sanuzel_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_sostoyaniye_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_sostoyaniye_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_telefon_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_telefon_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartira_tip_stroyeniya_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE kvartira_tip_stroyeniya_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: kvartirarent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    kolichestvokomnat integer,
    kvartira integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    balkon_id bigint,
    dver_id bigint,
    planirovka_id bigint,
    pol_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    kaksdayete_id bigint
);


--
-- Name: kvartirarent_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    kolichestvokomnat integer,
    kvartira integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    balkon_id bigint,
    dver_id bigint,
    planirovka_id bigint,
    pol_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint,
    kaksdayete_id bigint
);


--
-- Name: kvartirarent_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_photopaths (
    kvartirarent_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: kvartirarent_photopaths_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_photopaths_aud (
    rev integer NOT NULL,
    kvartirarent_id bigint NOT NULL,
    photopaths character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: kvartirarent_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_telnumbers (
    kvartirarent_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: kvartirarent_telnumbers_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_telnumbers_aud (
    rev integer NOT NULL,
    kvartirarent_id bigint NOT NULL,
    telnumbers character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: kvartirasale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    kolichestvokomnat integer,
    kvartira integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    iszalog boolean,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    balkon_id bigint,
    dver_id bigint,
    planirovka_id bigint,
    pol_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint
);


--
-- Name: kvartirasale_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_aud (
    id bigint NOT NULL,
    rev integer NOT NULL,
    revtype smallint,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    cena numeric(19,2),
    cenaprodazhi numeric(19,2),
    dom character varying(255),
    isarchive boolean,
    peresechenie character varying(255),
    primechanie character varying(255),
    raznoe character varying(5000),
    ulica character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    kolichestvokomnat integer,
    kvartira integer,
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    iszalog boolean,
    assignedto_id bigint,
    istochnikinfo_id bigint,
    modifiedby_id bigint,
    region_id bigint,
    valyuta_id bigint,
    balkon_id bigint,
    dver_id bigint,
    planirovka_id bigint,
    pol_id bigint,
    sanuzel_id bigint,
    sostoyaniye_id bigint,
    telefon_id bigint,
    tipstroyeniya_id bigint
);


--
-- Name: kvartirasale_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_photopaths (
    kvartirasale_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: kvartirasale_photopaths_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_photopaths_aud (
    rev integer NOT NULL,
    kvartirasale_id bigint NOT NULL,
    photopaths character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: kvartirasale_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_telnumbers (
    kvartirasale_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: kvartirasale_telnumbers_aud; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_telnumbers_aud (
    rev integer NOT NULL,
    kvartirasale_id bigint NOT NULL,
    telnumbers character varying(255) NOT NULL,
    revtype smallint
);


--
-- Name: kvartirasanuzel; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasanuzel (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kvartirasostoyaniye; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasostoyaniye (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kvartiratelefon; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartiratelefon (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: kvartiratipstroyeniya; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartiratipstroyeniya (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: mebel; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE mebel (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: mebel_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE mebel_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: otopleniye; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE otopleniye (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: otopleniye_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE otopleniye_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: parkovka; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE parkovka (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: parkovka_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE parkovka_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: planirovka; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE planirovka (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: planirovka_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE planirovka_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: pol; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE pol (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: pol_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE pol_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: realtor; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE realtor (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    company character varying(255),
    name character varying(255),
    viddeyatelnosti character varying(255)
);


--
-- Name: realtor_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE realtor_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: realtor_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE realtor_telnumbers (
    realtor_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: region; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE region (
    id bigint NOT NULL,
    createdat timestamp without time zone,
    krishaid character varying(255),
    updatedat timestamp without time zone,
    deleted boolean,
    krishaalias character varying(255),
    name character varying(255),
    path character varying(255),
    parent_id bigint
);


--
-- Name: region_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE region_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: revinfo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE revinfo (
    rev integer NOT NULL,
    revtstmp bigint
);


--
-- Name: user_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE user_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: users; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE users (
    id bigint NOT NULL,
    credentials character varying(255),
    identifier character varying(255) NOT NULL,
    firstname character varying(255),
    lastname character varying(255),
    middlename character varying(255)
);


--
-- Name: valyuta; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE valyuta (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: valyuta_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE valyuta_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: voda; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE voda (
    id bigint NOT NULL,
    code character varying(255),
    title character varying(255)
);


--
-- Name: voda_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE voda_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- Name: balkon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY balkon
    ADD CONSTRAINT balkon_pkey PRIMARY KEY (id);


--
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: device_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY device
    ADD CONSTRAINT device_pkey PRIMARY KEY (id);


--
-- Name: domrent_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_aud
    ADD CONSTRAINT domrent_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: domrent_photopaths_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_photopaths_aud
    ADD CONSTRAINT domrent_photopaths_aud_pkey PRIMARY KEY (rev, domrent_id, photopaths);


--
-- Name: domrent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT domrent_pkey PRIMARY KEY (id);


--
-- Name: domrent_telnumbers_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_telnumbers_aud
    ADD CONSTRAINT domrent_telnumbers_aud_pkey PRIMARY KEY (rev, domrent_id, telnumbers);


--
-- Name: domsale_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_aud
    ADD CONSTRAINT domsale_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: domsale_photopaths_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_photopaths_aud
    ADD CONSTRAINT domsale_photopaths_aud_pkey PRIMARY KEY (rev, domsale_id, photopaths);


--
-- Name: domsale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT domsale_pkey PRIMARY KEY (id);


--
-- Name: domsale_telnumbers_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_telnumbers_aud
    ADD CONSTRAINT domsale_telnumbers_aud_pkey PRIMARY KEY (rev, domsale_id, telnumbers);


--
-- Name: domsanuzel_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsanuzel
    ADD CONSTRAINT domsanuzel_pkey PRIMARY KEY (id);


--
-- Name: domsostoyaniye_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsostoyaniye
    ADD CONSTRAINT domsostoyaniye_pkey PRIMARY KEY (id);


--
-- Name: domtelefon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domtelefon
    ADD CONSTRAINT domtelefon_pkey PRIMARY KEY (id);


--
-- Name: domtipstroyeniya_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domtipstroyeniya
    ADD CONSTRAINT domtipstroyeniya_pkey PRIMARY KEY (id);


--
-- Name: dver_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY dver
    ADD CONSTRAINT dver_pkey PRIMARY KEY (id);


--
-- Name: elektrichestvo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY elektrichestvo
    ADD CONSTRAINT elektrichestvo_pkey PRIMARY KEY (id);


--
-- Name: gaz_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gaz
    ADD CONSTRAINT gaz_pkey PRIMARY KEY (id);


--
-- Name: internet_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY internet
    ADD CONSTRAINT internet_pkey PRIMARY KEY (id);


--
-- Name: istochnikinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY istochnikinfo
    ADD CONSTRAINT istochnikinfo_pkey PRIMARY KEY (id);


--
-- Name: kaksdayete_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kaksdayete
    ADD CONSTRAINT kaksdayete_pkey PRIMARY KEY (id);


--
-- Name: kanalizaciya_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kanalizaciya
    ADD CONSTRAINT kanalizaciya_pkey PRIMARY KEY (id);


--
-- Name: kvartirarent_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_aud
    ADD CONSTRAINT kvartirarent_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: kvartirarent_photopaths_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_photopaths_aud
    ADD CONSTRAINT kvartirarent_photopaths_aud_pkey PRIMARY KEY (rev, kvartirarent_id, photopaths);


--
-- Name: kvartirarent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT kvartirarent_pkey PRIMARY KEY (id);


--
-- Name: kvartirarent_telnumbers_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_telnumbers_aud
    ADD CONSTRAINT kvartirarent_telnumbers_aud_pkey PRIMARY KEY (rev, kvartirarent_id, telnumbers);


--
-- Name: kvartirasale_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_aud
    ADD CONSTRAINT kvartirasale_aud_pkey PRIMARY KEY (id, rev);


--
-- Name: kvartirasale_photopaths_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_photopaths_aud
    ADD CONSTRAINT kvartirasale_photopaths_aud_pkey PRIMARY KEY (rev, kvartirasale_id, photopaths);


--
-- Name: kvartirasale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT kvartirasale_pkey PRIMARY KEY (id);


--
-- Name: kvartirasale_telnumbers_aud_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_telnumbers_aud
    ADD CONSTRAINT kvartirasale_telnumbers_aud_pkey PRIMARY KEY (rev, kvartirasale_id, telnumbers);


--
-- Name: kvartirasanuzel_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasanuzel
    ADD CONSTRAINT kvartirasanuzel_pkey PRIMARY KEY (id);


--
-- Name: kvartirasostoyaniye_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasostoyaniye
    ADD CONSTRAINT kvartirasostoyaniye_pkey PRIMARY KEY (id);


--
-- Name: kvartiratelefon_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartiratelefon
    ADD CONSTRAINT kvartiratelefon_pkey PRIMARY KEY (id);


--
-- Name: kvartiratipstroyeniya_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartiratipstroyeniya
    ADD CONSTRAINT kvartiratipstroyeniya_pkey PRIMARY KEY (id);


--
-- Name: mebel_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY mebel
    ADD CONSTRAINT mebel_pkey PRIMARY KEY (id);


--
-- Name: otopleniye_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY otopleniye
    ADD CONSTRAINT otopleniye_pkey PRIMARY KEY (id);


--
-- Name: parkovka_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY parkovka
    ADD CONSTRAINT parkovka_pkey PRIMARY KEY (id);


--
-- Name: planirovka_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY planirovka
    ADD CONSTRAINT planirovka_pkey PRIMARY KEY (id);


--
-- Name: pol_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pol
    ADD CONSTRAINT pol_pkey PRIMARY KEY (id);


--
-- Name: realtor_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY realtor
    ADD CONSTRAINT realtor_pkey PRIMARY KEY (id);


--
-- Name: region_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY region
    ADD CONSTRAINT region_pkey PRIMARY KEY (id);


--
-- Name: revinfo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY revinfo
    ADD CONSTRAINT revinfo_pkey PRIMARY KEY (rev);


--
-- Name: uk_1jcltkqgt2ekeiabdn15jbxv2; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kanalizaciya
    ADD CONSTRAINT uk_1jcltkqgt2ekeiabdn15jbxv2 UNIQUE (code);


--
-- Name: uk_2unhnvocc3pbhj6u57bbnh88c; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domtelefon
    ADD CONSTRAINT uk_2unhnvocc3pbhj6u57bbnh88c UNIQUE (code);


--
-- Name: uk_3xtu3v41mq3nw9f6gbxawr0io; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY gaz
    ADD CONSTRAINT uk_3xtu3v41mq3nw9f6gbxawr0io UNIQUE (code);


--
-- Name: uk_4d82t96jta8yi74jic0erkvjg; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY client
    ADD CONSTRAINT uk_4d82t96jta8yi74jic0erkvjg UNIQUE (name);


--
-- Name: uk_57heme5vl16ueg4mjtu8ohf7h; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY elektrichestvo
    ADD CONSTRAINT uk_57heme5vl16ueg4mjtu8ohf7h UNIQUE (code);


--
-- Name: uk_5odq48n6n8fyovnahv1qyvyx7; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY realtor
    ADD CONSTRAINT uk_5odq48n6n8fyovnahv1qyvyx7 UNIQUE (krishaid);


--
-- Name: uk_61hpn62drog2r6fc0v76glinn; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsostoyaniye
    ADD CONSTRAINT uk_61hpn62drog2r6fc0v76glinn UNIQUE (code);


--
-- Name: uk_7rxam5kelpwmcd1d9v07trbwa; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY internet
    ADD CONSTRAINT uk_7rxam5kelpwmcd1d9v07trbwa UNIQUE (code);


--
-- Name: uk_7wpqoi1s1jiidlw9lxcbgmnlo; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY planirovka
    ADD CONSTRAINT uk_7wpqoi1s1jiidlw9lxcbgmnlo UNIQUE (code);


--
-- Name: uk_81xiyxrbot3ai3hcyw6vtq5d5; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY mebel
    ADD CONSTRAINT uk_81xiyxrbot3ai3hcyw6vtq5d5 UNIQUE (code);


--
-- Name: uk_93ojxyngbldv7w76rnpsbubfc; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY istochnikinfo
    ADD CONSTRAINT uk_93ojxyngbldv7w76rnpsbubfc UNIQUE (code);


--
-- Name: uk_a4mblb7gvc6ib6q7v8m4m8xxv; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT uk_a4mblb7gvc6ib6q7v8m4m8xxv UNIQUE (krishaid);


--
-- Name: uk_awaalyh61999ptldxg14nao0w; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY dver
    ADD CONSTRAINT uk_awaalyh61999ptldxg14nao0w UNIQUE (code);


--
-- Name: uk_b7g3ds82rkrervpts7aciy1dh; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domtipstroyeniya
    ADD CONSTRAINT uk_b7g3ds82rkrervpts7aciy1dh UNIQUE (code);


--
-- Name: uk_f21hxm4s1gb2aukvr63a2kp4v; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasostoyaniye
    ADD CONSTRAINT uk_f21hxm4s1gb2aukvr63a2kp4v UNIQUE (code);


--
-- Name: uk_gbqlyq45rwkwt63ure9pjtwwe; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY pol
    ADD CONSTRAINT uk_gbqlyq45rwkwt63ure9pjtwwe UNIQUE (code);


--
-- Name: uk_gj9684itvcuexv871kw0iyjd1; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsanuzel
    ADD CONSTRAINT uk_gj9684itvcuexv871kw0iyjd1 UNIQUE (code);


--
-- Name: uk_gn203ngly410tq1b7t4icmhr5; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY otopleniye
    ADD CONSTRAINT uk_gn203ngly410tq1b7t4icmhr5 UNIQUE (code);


--
-- Name: uk_h6a4804uwgqf0sw5981pqxam4; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT uk_h6a4804uwgqf0sw5981pqxam4 UNIQUE (krishaid);


--
-- Name: uk_hquhkp4cq8s9usgcfmqocownv; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY region
    ADD CONSTRAINT uk_hquhkp4cq8s9usgcfmqocownv UNIQUE (krishaid);


--
-- Name: uk_i5pety7dj8ueekd8oxvpqiiuq; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY parkovka
    ADD CONSTRAINT uk_i5pety7dj8ueekd8oxvpqiiuq UNIQUE (code);


--
-- Name: uk_ifnw51uukjxbva9ua1em2ohpx; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kaksdayete
    ADD CONSTRAINT uk_ifnw51uukjxbva9ua1em2ohpx UNIQUE (code);


--
-- Name: uk_jag3b69s2kyr82dpyq0ogap8c; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartiratelefon
    ADD CONSTRAINT uk_jag3b69s2kyr82dpyq0ogap8c UNIQUE (code);


--
-- Name: uk_juvf9raagh94pb3834c30lt6e; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY voda
    ADD CONSTRAINT uk_juvf9raagh94pb3834c30lt6e UNIQUE (code);


--
-- Name: uk_jxikhrymbvsrmg1gcby8bd42c; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT uk_jxikhrymbvsrmg1gcby8bd42c UNIQUE (krishaid);


--
-- Name: uk_kr72esnsr4ogf4vys0i8n09fj; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartiratipstroyeniya
    ADD CONSTRAINT uk_kr72esnsr4ogf4vys0i8n09fj UNIQUE (code);


--
-- Name: uk_n16tqm0iihxtocteofq58wobw; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY balkon
    ADD CONSTRAINT uk_n16tqm0iihxtocteofq58wobw UNIQUE (code);


--
-- Name: uk_q2w5wwekp4nkrdgwyyyaj0baq; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT uk_q2w5wwekp4nkrdgwyyyaj0baq UNIQUE (krishaid);


--
-- Name: uk_qqyqejxx6vp6keuodv4wyam4; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY device
    ADD CONSTRAINT uk_qqyqejxx6vp6keuodv4wyam4 UNIQUE (number);


--
-- Name: uk_qxbxprw69rusb9ap6ydm5ndue; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT uk_qxbxprw69rusb9ap6ydm5ndue UNIQUE (identifier);


--
-- Name: uk_rihmxf3tcklj3wa27ftbvkg9g; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY valyuta
    ADD CONSTRAINT uk_rihmxf3tcklj3wa27ftbvkg9g UNIQUE (code);


--
-- Name: uk_tqce6fb3i70v1c8qm5dgc2ky7; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasanuzel
    ADD CONSTRAINT uk_tqce6fb3i70v1c8qm5dgc2ky7 UNIQUE (code);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: valyuta_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY valyuta
    ADD CONSTRAINT valyuta_pkey PRIMARY KEY (id);


--
-- Name: voda_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY voda
    ADD CONSTRAINT voda_pkey PRIMARY KEY (id);


--
-- Name: fk15lgbtn3aa86606cjul6m7i2o; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fk15lgbtn3aa86606cjul6m7i2o FOREIGN KEY (tipstroyeniya_id) REFERENCES kvartiratipstroyeniya(id);


--
-- Name: fk1urluh4v0r3avd4m7ombhnhey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_photopaths_aud
    ADD CONSTRAINT fk1urluh4v0r3avd4m7ombhnhey FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fk2ge9k1ljiv8w3ijggu5k4l0kj; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fk2ge9k1ljiv8w3ijggu5k4l0kj FOREIGN KEY (internet_id) REFERENCES internet(id);


--
-- Name: fk3d5q9k4oehuwl3oekiml6xkrm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fk3d5q9k4oehuwl3oekiml6xkrm FOREIGN KEY (pol_id) REFERENCES pol(id);


--
-- Name: fk3g9vsm4nr4r9c80u7dw09xsxr; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fk3g9vsm4nr4r9c80u7dw09xsxr FOREIGN KEY (sostoyaniye_id) REFERENCES domsostoyaniye(id);


--
-- Name: fk3qk0kbgwx8h70vcu0g2ejnhw8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fk3qk0kbgwx8h70vcu0g2ejnhw8 FOREIGN KEY (telefon_id) REFERENCES kvartiratelefon(id);


--
-- Name: fk3sos6ftw31vl4873qsro2cgj5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fk3sos6ftw31vl4873qsro2cgj5 FOREIGN KEY (valyuta_id) REFERENCES valyuta(id);


--
-- Name: fk4iwnf3e7fd5eugg08bno69n90; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fk4iwnf3e7fd5eugg08bno69n90 FOREIGN KEY (gaz_id) REFERENCES gaz(id);


--
-- Name: fk4owph7fqocf0qnu2c72rmyco3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_photopaths
    ADD CONSTRAINT fk4owph7fqocf0qnu2c72rmyco3 FOREIGN KEY (kvartirasale_id) REFERENCES kvartirasale(id);


--
-- Name: fk4rlwggb69ds3ox3xadufgoigq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_photopaths
    ADD CONSTRAINT fk4rlwggb69ds3ox3xadufgoigq FOREIGN KEY (kvartirarent_id) REFERENCES kvartirarent(id);


--
-- Name: fk5yx5baw4y4vfhlgs0xfsslljb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fk5yx5baw4y4vfhlgs0xfsslljb FOREIGN KEY (sostoyaniye_id) REFERENCES domsostoyaniye(id);


--
-- Name: fk67ip7s370tdsc1q4c9vsmxysx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_aud
    ADD CONSTRAINT fk67ip7s370tdsc1q4c9vsmxysx FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fk6pn5vcgt5cnqgagiw3lyey26d; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fk6pn5vcgt5cnqgagiw3lyey26d FOREIGN KEY (balkon_id) REFERENCES balkon(id);


--
-- Name: fk6rq4ni7y49bb2k4w1bbdtq1p9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fk6rq4ni7y49bb2k4w1bbdtq1p9 FOREIGN KEY (modifiedby_id) REFERENCES users(id);


--
-- Name: fk72447du12c7ky5s4w8rndm110; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fk72447du12c7ky5s4w8rndm110 FOREIGN KEY (dver_id) REFERENCES dver(id);


--
-- Name: fk76v47y27ccwssg3bg7iedp495; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fk76v47y27ccwssg3bg7iedp495 FOREIGN KEY (balkon_id) REFERENCES balkon(id);


--
-- Name: fk772fmo4p51bq44h4ivmv1lrrt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fk772fmo4p51bq44h4ivmv1lrrt FOREIGN KEY (sostoyaniye_id) REFERENCES kvartirasostoyaniye(id);


--
-- Name: fk7t0hxpvmephvju7egywfn85fu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY realtor_telnumbers
    ADD CONSTRAINT fk7t0hxpvmephvju7egywfn85fu FOREIGN KEY (realtor_id) REFERENCES realtor(id);


--
-- Name: fk84lkwvjo0gt38twmgxot82l19; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fk84lkwvjo0gt38twmgxot82l19 FOREIGN KEY (valyuta_id) REFERENCES valyuta(id);


--
-- Name: fk8jkla058vb38oj91wce3gnftc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_telnumbers
    ADD CONSTRAINT fk8jkla058vb38oj91wce3gnftc FOREIGN KEY (domrent_id) REFERENCES domrent(id);


--
-- Name: fk8n7jkttk128ax17trq1fn0jy3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fk8n7jkttk128ax17trq1fn0jy3 FOREIGN KEY (modifiedby_id) REFERENCES users(id);


--
-- Name: fk9e7thvsnebjypfw1jhq9sxa34; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fk9e7thvsnebjypfw1jhq9sxa34 FOREIGN KEY (istochnikinfo_id) REFERENCES istochnikinfo(id);


--
-- Name: fk9ec3bcle3dljh99ej7hckp5w7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY device
    ADD CONSTRAINT fk9ec3bcle3dljh99ej7hckp5w7 FOREIGN KEY (client_id) REFERENCES client(id);


--
-- Name: fk9hgc758ahme59vbj8lvi9ia51; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_telnumbers
    ADD CONSTRAINT fk9hgc758ahme59vbj8lvi9ia51 FOREIGN KEY (kvartirasale_id) REFERENCES kvartirasale(id);


--
-- Name: fk9vms8hb58ohnki844f0ubj39b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fk9vms8hb58ohnki844f0ubj39b FOREIGN KEY (kanalizaciya_id) REFERENCES kanalizaciya(id);


--
-- Name: fka3gp2a9jqfaowrfix3j3ylfyn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fka3gp2a9jqfaowrfix3j3ylfyn FOREIGN KEY (otopleniye_id) REFERENCES otopleniye(id);


--
-- Name: fka6pfbko8g5tsl5grkow9tp15x; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fka6pfbko8g5tsl5grkow9tp15x FOREIGN KEY (elektrichestvo_id) REFERENCES elektrichestvo(id);


--
-- Name: fkag03hx54qqux2b286d4rdto9s; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkag03hx54qqux2b286d4rdto9s FOREIGN KEY (sanuzel_id) REFERENCES domsanuzel(id);


--
-- Name: fkasdye0wp37ggddoscpr4yoxm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkasdye0wp37ggddoscpr4yoxm FOREIGN KEY (assignedto_id) REFERENCES users(id);


--
-- Name: fkb29gtsdav87qh1wkxe0bdtfdu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkb29gtsdav87qh1wkxe0bdtfdu FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkb75w89klgypjolpj23n4luov2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkb75w89klgypjolpj23n4luov2 FOREIGN KEY (valyuta_id) REFERENCES valyuta(id);


--
-- Name: fkbd57274rre8uxoxcfj9gei8ro; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkbd57274rre8uxoxcfj9gei8ro FOREIGN KEY (sanuzel_id) REFERENCES kvartirasanuzel(id);


--
-- Name: fkbeefmeoj8gnwgfdxvduatt84g; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkbeefmeoj8gnwgfdxvduatt84g FOREIGN KEY (tipstroyeniya_id) REFERENCES kvartiratipstroyeniya(id);


--
-- Name: fkc583jn1yt2e2ncbbh83rc7mhf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_aud
    ADD CONSTRAINT fkc583jn1yt2e2ncbbh83rc7mhf FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkc7afdqqnx4763984hmkhkohps; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkc7afdqqnx4763984hmkhkohps FOREIGN KEY (voda_id) REFERENCES voda(id);


--
-- Name: fkc957tgmeeskfq21jnchytcb1w; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkc957tgmeeskfq21jnchytcb1w FOREIGN KEY (pol_id) REFERENCES pol(id);


--
-- Name: fkd2fsih1hbjy4ekipq1hyrfqu1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkd2fsih1hbjy4ekipq1hyrfqu1 FOREIGN KEY (istochnikinfo_id) REFERENCES istochnikinfo(id);


--
-- Name: fkd80s2r5n9av6xlko3n395gn52; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkd80s2r5n9av6xlko3n395gn52 FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkdcuq0d3glqivc58ku5mxavye; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkdcuq0d3glqivc58ku5mxavye FOREIGN KEY (gaz_id) REFERENCES gaz(id);


--
-- Name: fkdh1s83po8j0mun9gnnp47541t; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY region
    ADD CONSTRAINT fkdh1s83po8j0mun9gnnp47541t FOREIGN KEY (parent_id) REFERENCES region(id);


--
-- Name: fkdoj6xh78blsretyd08ovy22tt; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_photopaths
    ADD CONSTRAINT fkdoj6xh78blsretyd08ovy22tt FOREIGN KEY (domrent_id) REFERENCES domrent(id);


--
-- Name: fke49twxg90vm924mu5b8msoiep; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_photopaths_aud
    ADD CONSTRAINT fke49twxg90vm924mu5b8msoiep FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fke8q2nn773lqidh7fop3ins6ak; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_telnumbers_aud
    ADD CONSTRAINT fke8q2nn773lqidh7fop3ins6ak FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkervaat7a99eu1hwnkr8h9e41a; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_photopaths_aud
    ADD CONSTRAINT fkervaat7a99eu1hwnkr8h9e41a FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkf8vvf1ryf3rpf33eb0ojobvgg; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkf8vvf1ryf3rpf33eb0ojobvgg FOREIGN KEY (modifiedby_id) REFERENCES users(id);


--
-- Name: fkg860qcaukk4d1abcisk07ya2m; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkg860qcaukk4d1abcisk07ya2m FOREIGN KEY (istochnikinfo_id) REFERENCES istochnikinfo(id);


--
-- Name: fkgdxuw30976amlsvft1rh7urvx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkgdxuw30976amlsvft1rh7urvx FOREIGN KEY (assignedto_id) REFERENCES users(id);


--
-- Name: fkgp43epy6ldgh2blybpodcyj1i; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkgp43epy6ldgh2blybpodcyj1i FOREIGN KEY (elektrichestvo_id) REFERENCES elektrichestvo(id);


--
-- Name: fkgt083qq6kj46xweqv9hphogxb; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkgt083qq6kj46xweqv9hphogxb FOREIGN KEY (otopleniye_id) REFERENCES otopleniye(id);


--
-- Name: fkh8jd1de20wjik7d4v9in1tgrs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkh8jd1de20wjik7d4v9in1tgrs FOREIGN KEY (kanalizaciya_id) REFERENCES kanalizaciya(id);


--
-- Name: fkh8q070q784pqafjsi3wigi6ll; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkh8q070q784pqafjsi3wigi6ll FOREIGN KEY (istochnikinfo_id) REFERENCES istochnikinfo(id);


--
-- Name: fkhgowupixrpm4wcbyp8y7aqat8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkhgowupixrpm4wcbyp8y7aqat8 FOREIGN KEY (planirovka_id) REFERENCES planirovka(id);


--
-- Name: fkhhg6n9ykscocum32mm7u8b5xp; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_telnumbers_aud
    ADD CONSTRAINT fkhhg6n9ykscocum32mm7u8b5xp FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkhltycubg7c802wp6yhnc96gqy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkhltycubg7c802wp6yhnc96gqy FOREIGN KEY (kaksdayete_id) REFERENCES kaksdayete(id);


--
-- Name: fkhtqg4vps1cw6ohaclyb53ucm5; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkhtqg4vps1cw6ohaclyb53ucm5 FOREIGN KEY (telefon_id) REFERENCES kvartiratelefon(id);


--
-- Name: fki0kvr1xm5eaos5nasuywllrgs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fki0kvr1xm5eaos5nasuywllrgs FOREIGN KEY (assignedto_id) REFERENCES users(id);


--
-- Name: fkirgw6umr0xjx7t1bhme0mabhq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_telnumbers_aud
    ADD CONSTRAINT fkirgw6umr0xjx7t1bhme0mabhq FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkjrwuihaf6i244qly7e0kylhh6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_photopaths_aud
    ADD CONSTRAINT fkjrwuihaf6i244qly7e0kylhh6 FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkjy2lg70yx3otfayjdhnqn8rri; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkjy2lg70yx3otfayjdhnqn8rri FOREIGN KEY (telefon_id) REFERENCES domtelefon(id);


--
-- Name: fkjyi72eqdqv19v7v0cetwtirum; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkjyi72eqdqv19v7v0cetwtirum FOREIGN KEY (tipstroyeniya_id) REFERENCES domtipstroyeniya(id);


--
-- Name: fkkix9cgmn8a314w8kwr733alxq; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkkix9cgmn8a314w8kwr733alxq FOREIGN KEY (sanuzel_id) REFERENCES kvartirasanuzel(id);


--
-- Name: fkkxoa3sgb9rpyq73rrsqhf7bdh; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkkxoa3sgb9rpyq73rrsqhf7bdh FOREIGN KEY (internet_id) REFERENCES internet(id);


--
-- Name: fkl503qqstbj6r8n1ndf72s2g8n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkl503qqstbj6r8n1ndf72s2g8n FOREIGN KEY (planirovka_id) REFERENCES planirovka(id);


--
-- Name: fklnke8215o04qrho7xmh6684o2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_photopaths
    ADD CONSTRAINT fklnke8215o04qrho7xmh6684o2 FOREIGN KEY (domsale_id) REFERENCES domsale(id);


--
-- Name: fklsatlqmuneeonj60lkl3j6vbs; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fklsatlqmuneeonj60lkl3j6vbs FOREIGN KEY (sostoyaniye_id) REFERENCES kvartirasostoyaniye(id);


--
-- Name: fkmdmkpaen9772rnxs4cupqxwfo; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT fkmdmkpaen9772rnxs4cupqxwfo FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkmfb5nmbtso0u0ls44nwkmdyf6; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_telnumbers
    ADD CONSTRAINT fkmfb5nmbtso0u0ls44nwkmdyf6 FOREIGN KEY (domsale_id) REFERENCES domsale(id);


--
-- Name: fkmgc4vr9vsnqkpy89031c5cq0n; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkmgc4vr9vsnqkpy89031c5cq0n FOREIGN KEY (sanuzel_id) REFERENCES domsanuzel(id);


--
-- Name: fkmpsoxkp6qsbjvujk8txhofybi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkmpsoxkp6qsbjvujk8txhofybi FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkmub3ja2v3jllrdtq3cv8n1pmn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkmub3ja2v3jllrdtq3cv8n1pmn FOREIGN KEY (modifiedby_id) REFERENCES users(id);


--
-- Name: fkn7agj193da00q8lpt74601plm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkn7agj193da00q8lpt74601plm FOREIGN KEY (kaksdayete_id) REFERENCES kaksdayete(id);


--
-- Name: fknvdcm8blyia64ca7ggekvggvy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_aud
    ADD CONSTRAINT fknvdcm8blyia64ca7ggekvggvy FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fko42be58356619726e7mpanx7q; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale_aud
    ADD CONSTRAINT fko42be58356619726e7mpanx7q FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- Name: fkpafdycnciif3liicbd2y50wy8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkpafdycnciif3liicbd2y50wy8 FOREIGN KEY (assignedto_id) REFERENCES users(id);


--
-- Name: fkpukraihhet4r3yfqayrar55nm; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkpukraihhet4r3yfqayrar55nm FOREIGN KEY (valyuta_id) REFERENCES valyuta(id);


--
-- Name: fkqe46paece2taro5j2ehoe1us8; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkqe46paece2taro5j2ehoe1us8 FOREIGN KEY (tipstroyeniya_id) REFERENCES domtipstroyeniya(id);


--
-- Name: fkqle8axcp2uh5qhfebd93gj6hc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_telnumbers
    ADD CONSTRAINT fkqle8axcp2uh5qhfebd93gj6hc FOREIGN KEY (kvartirarent_id) REFERENCES kvartirarent(id);


--
-- Name: fkswdnarv8fxh2r21ixndxb40uy; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkswdnarv8fxh2r21ixndxb40uy FOREIGN KEY (voda_id) REFERENCES voda(id);


--
-- Name: fksxp4k1t8op09aeccv3ngxwthn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fksxp4k1t8op09aeccv3ngxwthn FOREIGN KEY (telefon_id) REFERENCES domtelefon(id);


--
-- Name: fkt4bpd36gebifawi12m0pdp9xf; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkt4bpd36gebifawi12m0pdp9xf FOREIGN KEY (dver_id) REFERENCES dver(id);


--
-- Name: fkx4h93h3t35p3ucaw3koowvro; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_telnumbers_aud
    ADD CONSTRAINT fkx4h93h3t35p3ucaw3koowvro FOREIGN KEY (rev) REFERENCES revinfo(rev);


--
-- PostgreSQL database dump complete
--

