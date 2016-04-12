package kz.maks.realestate.front.services.asyncs;

import kz.maks.realestate.front.services.asyncs.impl.*;

public class Asyncs {

    public static final KvartiraSaleAsync KVARTIRA_SALE_ASYNC = new KvartiraSaleAsyncImpl();
    public static final KvartiraRentAsync KVARTIRA_RENT_ASYNC = new KvartiraRentAsyncImpl();

    public static final DomSaleAsync DOM_SALE_ASYNC = new DomSaleAsyncImpl();
    public static final DomRentAsync DOM_RENT_ASYNC = new DomRentAsyncImpl();

    public static final UserAsync USER_ASYNC = new UserAsyncImpl();

    public static final RefAsync REF_ASYNC = new RefAsyncImpl();

    public static final RealtorAsync REALTOR_ASYNC = new RealtorAsyncImpl();

}
