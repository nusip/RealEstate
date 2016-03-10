package kz.maks.realestate.front.services;

import kz.maks.realestate.shared.remotes.*;

public class FrontRemotes {
    private static KvartiraSaleRemote kvartiraSaleRemote;
    private static KvartiraRentRemote kvartiraRentRemote;
    private static DomSaleRemote domSaleRemote;
    private static DomRentRemote domRentRemote;
    private static ActivationRemote activationRemote;

    public static KvartiraSaleRemote kvartiraSaleRemote() {
        return kvartiraSaleRemote;
    }

    public static KvartiraRentRemote kvartiraRentRemote() {
        return kvartiraRentRemote;
    }

    public static DomSaleRemote domSaleRemote() {
        return domSaleRemote;
    }

    public static DomRentRemote domRentRemote() {
        return domRentRemote;
    }

    public static ActivationRemote activationRemote() {
        return activationRemote;
    }

}
