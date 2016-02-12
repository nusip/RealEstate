package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.asyncs.ICRUDAsync;
import kz.maks.realestate.shared.dtos.get.dom.DomSaleGetDto;
import kz.maks.realestate.shared.dtos.list.dom.DomSaleListDto;
import kz.maks.realestate.shared.dtos.params.DomSaleSearchParams;

public interface DomSaleAsync
        extends ICRUDAsync<DomSaleSearchParams, DomSaleListDto, DomSaleGetDto> {

}
