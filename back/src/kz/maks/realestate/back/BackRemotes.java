package kz.maks.realestate.back;

import kz.maks.realestate.shared.remotes.*;

public class BackRemotes {
    private static KvartiraSaleRemote kvartiraSaleRemote;
    private static KvartiraRentRemote kvartiraRentRemote;
    private static DomSaleRemote domSaleRemote;
    private static DomRentRemote domRentRemote;
    private static RegionRemote regionRemote;
    private static ActivationRemote activationRemote;
    private static RealtorRemote realtorRemote;

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

    public static RegionRemote regionRemote() {
        return regionRemote;
    }

    public static ActivationRemote activationRemote() {
        return activationRemote;
    }

    public static RealtorRemote realtorRemote() {
        return realtorRemote;
    }
}
