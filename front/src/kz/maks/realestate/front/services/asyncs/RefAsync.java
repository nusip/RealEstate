package kz.maks.realestate.front.services.asyncs;

import kz.maks.core.front.services.Callback;
import kz.maks.core.shared.dtos.RefDto;
import kz.maks.realestate.shared.refs.Ref;

import java.util.List;

public interface RefAsync {

    void list(Ref ref, Callback<List<RefDto>> callback);

    void save(Ref ref, List<RefDto> refDtoList, Callback<Void> callback);

}
