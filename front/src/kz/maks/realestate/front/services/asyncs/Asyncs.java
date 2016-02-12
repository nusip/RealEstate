package kz.maks.realestate.front.services.asyncs;

import kz.maks.realestate.front.services.asyncs.impl.DomRentAsyncImpl;
import kz.maks.realestate.front.services.asyncs.impl.DomSaleAsyncImpl;
import kz.maks.realestate.front.services.asyncs.impl.KvartiraRentAsyncImpl;
import kz.maks.realestate.front.services.asyncs.impl.KvartiraSaleAsyncImpl;

public class Asyncs {

    public static final KvartiraSaleAsync KVARTIRA_SALE_ASYNC = new KvartiraSaleAsyncImpl();
    public static final KvartiraRentAsync KVARTIRA_RENT_ASYNC = new KvartiraRentAsyncImpl();

    public static final DomSaleAsync DOM_SALE_ASYNC = new DomSaleAsyncImpl();
    public static final DomRentAsync DOM_RENT_ASYNC = new DomRentAsyncImpl();

}
