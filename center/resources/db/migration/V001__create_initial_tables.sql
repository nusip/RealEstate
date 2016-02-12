--
-- Name: client; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE client (
    id bigint NOT NULL,
    isactive boolean,
    name character varying(255) NOT NULL
);


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
-- Name: domrent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent (
    id bigint NOT NULL,
    krishaid character varying(255),
    updatedat bigint,
    cena numeric(19,2),
    raznoe character varying(5000),
    ulicadom character varying(255),
    valyuta character varying(255),
    domofon boolean,
    elektrichestvo character varying(255),
    gaz character varying(255),
    internet character varying(255),
    kakogorojen character varying(255),
    kanalizaciya character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    kruglosutochnayaohrana boolean,
    otopleniye character varying(255),
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    reshetkinaoknah boolean,
    sanuzel character varying(255),
    signalizaciya boolean,
    sostoyaniye character varying(255),
    telefon character varying(255),
    tipstroyeniya character varying(255),
    videomofon boolean,
    videonablyudeniye boolean,
    voda character varying(255),
    vysotapotolkov double precision,
    kaksdayete character varying(255),
    region_id bigint
);


--
-- Name: domrent_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_photopaths (
    domrent_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: domrent_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domrent_telnumbers (
    domrent_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: domsale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale (
    id bigint NOT NULL,
    krishaid character varying(255),
    updatedat bigint,
    cena numeric(19,2),
    raznoe character varying(5000),
    ulicadom character varying(255),
    valyuta character varying(255),
    domofon boolean,
    elektrichestvo character varying(255),
    gaz character varying(255),
    internet character varying(255),
    kakogorojen character varying(255),
    kanalizaciya character varying(255),
    kolichestvokomnat integer,
    kolichestvourovney integer,
    kruglosutochnayaohrana boolean,
    otopleniye character varying(255),
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshaduchastka double precision,
    ploshadzhilaya double precision,
    pokrytiekryshi character varying(255),
    reshetkinaoknah boolean,
    sanuzel character varying(255),
    signalizaciya boolean,
    sostoyaniye character varying(255),
    telefon character varying(255),
    tipstroyeniya character varying(255),
    videomofon boolean,
    videonablyudeniye boolean,
    voda character varying(255),
    vysotapotolkov double precision,
    iszalog boolean,
    region_id bigint
);


--
-- Name: domsale_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_photopaths (
    domsale_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: domsale_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE domsale_telnumbers (
    domsale_id bigint NOT NULL,
    telnumbers character varying(255)
);


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
-- Name: kvartirarent; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent (
    id bigint NOT NULL,
    krishaid character varying(255),
    updatedat bigint,
    cena numeric(19,2),
    raznoe character varying(5000),
    ulicadom character varying(255),
    valyuta character varying(255),
    balkon character varying(255),
    domofon boolean,
    dver character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    internet character varying(255),
    isobwyaga boolean,
    kodovyzamok boolean,
    kolichestvokomnat integer,
    konsyerzh boolean,
    mebel character varying(255),
    ohrana boolean,
    parkovka character varying(255),
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    pol character varying(255),
    reshetkinaoknah boolean,
    sanuzel character varying(255),
    signalizaciya boolean,
    sostoyaniye character varying(255),
    telefon character varying(255),
    tipstroyeniya character varying(255),
    videomofon boolean,
    videonablyudeniye boolean,
    vysotapotolkov double precision,
    zhiloykomplex character varying(255),
    kaksdayete character varying(255),
    region_id bigint
);


--
-- Name: kvartirarent_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_photopaths (
    kvartirarent_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: kvartirarent_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirarent_telnumbers (
    kvartirarent_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: kvartirasale; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale (
    id bigint NOT NULL,
    krishaid character varying(255),
    updatedat bigint,
    cena numeric(19,2),
    raznoe character varying(5000),
    ulicadom character varying(255),
    valyuta character varying(255),
    balkon character varying(255),
    domofon boolean,
    dver character varying(255),
    etazh integer,
    etazhnost integer,
    godpostroyki integer,
    internet character varying(255),
    isobwyaga boolean,
    kodovyzamok boolean,
    kolichestvokomnat integer,
    konsyerzh boolean,
    mebel character varying(255),
    ohrana boolean,
    parkovka character varying(255),
    ploshadkuhnya double precision,
    ploshadobshaya double precision,
    ploshadzhilaya double precision,
    pol character varying(255),
    reshetkinaoknah boolean,
    sanuzel character varying(255),
    signalizaciya boolean,
    sostoyaniye character varying(255),
    telefon character varying(255),
    tipstroyeniya character varying(255),
    videomofon boolean,
    videonablyudeniye boolean,
    vysotapotolkov double precision,
    zhiloykomplex character varying(255),
    iszalog boolean,
    region_id bigint
);


--
-- Name: kvartirasale_photopaths; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_photopaths (
    kvartirasale_id bigint NOT NULL,
    photopaths character varying(255)
);


--
-- Name: kvartirasale_telnumbers; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE kvartirasale_telnumbers (
    kvartirasale_id bigint NOT NULL,
    telnumbers character varying(255)
);


--
-- Name: region; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE region (
    id bigint NOT NULL,
    krishaid character varying(255),
    updatedat bigint,
    deleted boolean,
    krishaalias character varying(255),
    name character varying(255),
    path character varying(255),
    parent_id bigint
);


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
-- Name: domrent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT domrent_pkey PRIMARY KEY (id);


--
-- Name: domsale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT domsale_pkey PRIMARY KEY (id);


--
-- Name: kvartirarent_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT kvartirarent_pkey PRIMARY KEY (id);


--
-- Name: kvartirasale_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT kvartirasale_pkey PRIMARY KEY (id);


--
-- Name: region_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY region
    ADD CONSTRAINT region_pkey PRIMARY KEY (id);


--
-- Name: uk_4d82t96jta8yi74jic0erkvjg; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY client
    ADD CONSTRAINT uk_4d82t96jta8yi74jic0erkvjg UNIQUE (name);


--
-- Name: uk_a4mblb7gvc6ib6q7v8m4m8xxv; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirasale
    ADD CONSTRAINT uk_a4mblb7gvc6ib6q7v8m4m8xxv UNIQUE (krishaid);


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
-- Name: uk_jxikhrymbvsrmg1gcby8bd42c; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT uk_jxikhrymbvsrmg1gcby8bd42c UNIQUE (krishaid);


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
-- Name: fk8jkla058vb38oj91wce3gnftc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent_telnumbers
    ADD CONSTRAINT fk8jkla058vb38oj91wce3gnftc FOREIGN KEY (domrent_id) REFERENCES domrent(id);


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
-- Name: fkb29gtsdav87qh1wkxe0bdtfdu; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domrent
    ADD CONSTRAINT fkb29gtsdav87qh1wkxe0bdtfdu FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkd80s2r5n9av6xlko3n395gn52; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale
    ADD CONSTRAINT fkd80s2r5n9av6xlko3n395gn52 FOREIGN KEY (region_id) REFERENCES region(id);


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
-- Name: fklnke8215o04qrho7xmh6684o2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY domsale_photopaths
    ADD CONSTRAINT fklnke8215o04qrho7xmh6684o2 FOREIGN KEY (domsale_id) REFERENCES domsale(id);


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
-- Name: fkmpsoxkp6qsbjvujk8txhofybi; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent
    ADD CONSTRAINT fkmpsoxkp6qsbjvujk8txhofybi FOREIGN KEY (region_id) REFERENCES region(id);


--
-- Name: fkqle8axcp2uh5qhfebd93gj6hc; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY kvartirarent_telnumbers
    ADD CONSTRAINT fkqle8axcp2uh5qhfebd93gj6hc FOREIGN KEY (kvartirarent_id) REFERENCES kvartirarent(id);
