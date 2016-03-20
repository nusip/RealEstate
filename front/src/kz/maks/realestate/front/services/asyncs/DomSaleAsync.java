package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.dom.DomSaleDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public interface DomSaleAsync
        extends ICRUDAsync<DomSaleSearchParams, DomSaleDto, DomSaleDto> {

}
