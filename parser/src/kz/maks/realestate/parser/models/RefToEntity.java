package kz.maks.realestate.parser.models;

import kz.maks.realestate.parser.entities.refs.AbstractRefEntity;

public enum RefToEntity {
    // dom
    Elektrichestvo(kz.maks.realestate.parser.entities.refs.Elektrichestvo.class),
    Gaz(kz.maks.realestate.parser.entities.refs.Gaz.class),
    Kanalizaciya(kz.maks.realestate.parser.entities.refs.Kanalizaciya.class),
    Otopleniye(kz.maks.realestate.parser.entities.refs.Otopleniye.class),
    DomSanuzel(kz.maks.realestate.parser.entities.refs.DomSanuzel.class),
    DomSostoyaniye(kz.maks.realestate.parser.entities.refs.DomSostoyaniye.class),
    DomTelefon(kz.maks.realestate.parser.entities.refs.DomTelefon.class),
    DomTipStroyeniya(kz.maks.realestate.parser.entities.refs.DomTipStroyeniya.class),
    Voda(kz.maks.realestate.parser.entities.refs.Voda.class),

    // kvartira
    Balkon(kz.maks.realestate.parser.entities.refs.Balkon.class),
    Dver(kz.maks.realestate.parser.entities.refs.Dver.class),
    Mebel(kz.maks.realestate.parser.entities.refs.Mebel.class),
    Parkovka(kz.maks.realestate.parser.entities.refs.Parkovka.class),
    Planirovka(kz.maks.realestate.parser.entities.refs.Planirovka.class),
    Pol(kz.maks.realestate.parser.entities.refs.Pol.class),
    KvartiraSanuzel(kz.maks.realestate.parser.entities.refs.KvartiraSanuzel.class),
    KvartiraSostoyaniye(kz.maks.realestate.parser.entities.refs.KvartiraSostoyaniye.class),
    KvartiraTelefon(kz.maks.realestate.parser.entities.refs.KvartiraTelefon.class),
    KvartiraTipStroyeniya(kz.maks.realestate.parser.entities.refs.KvartiraTipStroyeniya.class),

    // common
    Internet(kz.maks.realestate.parser.entities.refs.Internet.class),
    IstochnikInfo(kz.maks.realestate.parser.entities.refs.IstochnikInfo.class),
    KakSdayete(kz.maks.realestate.parser.entities.refs.KakSdayete.class),
    Valyuta(kz.maks.realestate.parser.entities.refs.Valyuta.class),;

    public final Class<? extends AbstractRefEntity> entityClass;

    RefToEntity(Class<? extends AbstractRefEntity> entityClass) {
        this.entityClass = entityClass;
    }
}
