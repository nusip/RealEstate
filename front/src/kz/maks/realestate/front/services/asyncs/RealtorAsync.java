package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

public interface RealtorAsync {

    void list(RealtorSearchParams params, Callback<ListResponse<RealtorDto>> callback);

}
