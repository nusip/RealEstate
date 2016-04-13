package kz.maks.realestate.parser.services;

import kz.maks.core.shared.models.ListResponse;
import kz.maks.realestate.shared.dtos.RealtorDto;
import kz.maks.realestate.shared.dtos.params.RealtorSearchParams;

import java.util.Date;
import java.util.List;

public interface RealtorService {

    ListResponse<RealtorDto> list(RealtorSearchParams params);

    Date getMaxUpdatedAt();

    List<RealtorDto> listNew(Date lastUpdatedAt);

    boolean realtorExists(String krishaId);

    void save(RealtorDto realtorDto);

}
