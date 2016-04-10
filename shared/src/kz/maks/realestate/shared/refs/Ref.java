package kz.maks.realestate.shared.refs;

import kz.maks.core.shared.models.HasTitle;

import java.io.Serializable;

public enum Ref implements HasTitle, Serializable {
    // dom
    Elektrichestvo("Электричество"),
    Gaz("Газ"),
    Kanalizaciya("Канализация"),
    Otopleniye("Отопление"),
    DomSanuzel("Санузел (дом)"),
    DomSostoyaniye("Состояние (дом)"),
    DomTelefon("Телефон (дом)"),
    DomTipStroyeniya("Тип строения (дом)"),
    Voda("Вода"),

    // kvartira
    Balkon("Балкон"),
    Dver("Дверь"),
    Mebel("Мебель"),
    Parkovka("Парковка"),
    Planirovka("Планировка"),
    Pol("Пол"),
    KvartiraSanuzel("Санузел (квартира)"),
    KvartiraSostoyaniye("Состояние (квартира)"),
    KvartiraTelefon("Телефон (квартира)"),
    KvartiraTipStroyeniya("Тип строения (квартира)"),

    // common
    Internet("Интернет"),
    IstochnikInfo("Источник информации"),
    KakSdayete("Как сдаёте"),
    Valyuta("Валюта"),
    ;

    private final String title;

    Ref(String title) {
        this.title = title;
    }


    @Override
    public String getTitle() {
        return title;
    }
}
